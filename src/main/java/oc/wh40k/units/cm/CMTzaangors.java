package oc.wh40k.units.cm;


import oc.*;

public class CMTzaangors extends Eintrag {

    AnzahlPanel kultisten;
    RuestkammerStarter champion;
    OptionsZaehlerGruppe o1;
    int modelle = 0;
    boolean isChampion = false;

    public CMTzaangors() {
        //name = "Chaoskultisten\n";
        grundkosten = 0;

        kultisten = new AnzahlPanel(ID, randAbstand, cnt, "Tzaangors", 10, 30, 7);
        add(kultisten);

        add(ico = new oc.Picture("oc/wh40k/images/ChaosKultisten.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffen", "Nahkampfwaffen", 0));
        ogE.addElement(new OptionsGruppeEintrag("Pistole & Schwert", "Autopistole & Kettenschwert", 1));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        o1.setAnzahl(0, kultisten.getModelle());

        seperator();

        champion = new RuestkammerStarter(ID, randAbstand, cnt, "CMKultistenChampion", "Twistbray");
        champion.initKammer(true);
        champion.setUeberschriftTrotzNullKostenAusgeben(true);
        champion.setGrundkosten(10);
        add(champion);

        complete();

    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(kultisten.getModelle() - (champion.isSelected() ? 1 : 0));

        if (modelle != kultisten.getModelle() || isChampion != champion.isSelected()) {
            modelle = kultisten.getModelle();
            isChampion = champion.isSelected();
            o1.setAnzahl(0, modelle - o1.getAnzahl(1) - (champion.isSelected() ? 1 : 0));
        }
    }
}
