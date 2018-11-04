package oc.wh40k.units.kd;


import oc.*;

public class KDChaosCultists extends Eintrag {

    AnzahlPanel kultisten;
    RuestkammerStarter champion;
    OptionsEinzelUpgrade schrotflinte;
    OptionsZaehlerGruppe schwereWaffe;
    OptionsZaehlerGruppe autogewehre;

    public KDChaosCultists() {
        //name = "Chaoskultisten\n";
        grundkosten = 0;

        kultisten = new AnzahlPanel(ID, randAbstand, cnt, "Chaos Cultists", 8, 35, 6);
        add(kultisten);

        add(ico = new oc.Picture("oc/wh40k/images/ChaosKultisten.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmgewehr", "Sturmgewehr", 1));
        add(autogewehre = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Maschinengewehr", 5));
        ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
        schwereWaffe = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);
        add(schwereWaffe);

        seperator();

        champion = new RuestkammerStarter(ID, randAbstand, cnt, "KDKultistenChampion", "Champion");
        champion.initKammer();
        champion.setUeberschriftTrotzNullKostenAusgeben(true);
        champion.setGrundkosten(10);
        add(champion);
        champion.setAbwaehlbar(false);

        seperator(0);

        complete();

    }

    @Override
    public void refreshen() {
        schwereWaffe.setMaxAnzahl(kultisten.getModelle() / 10);

        int subtractor = schwereWaffe.getAnzahl() + 1; // last one is the boss

        autogewehre.setMaxAnzahl(kultisten.getModelle() - subtractor);
    }
}
