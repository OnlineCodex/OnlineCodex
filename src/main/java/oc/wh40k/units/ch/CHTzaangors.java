package oc.wh40k.units.ch;


import oc.*;

public class CHTzaangors extends Eintrag {

    AnzahlPanel kultisten;
    RuestkammerStarter rkBoss;
    OptionsZaehlerGruppe o1;
    int modelle = 0;
    boolean isChampion = false;

    public CHTzaangors() {
        //name = "Chaoskultisten\n";
        grundkosten = 0;

        kultisten = new AnzahlPanel(ID, randAbstand, cnt, "Tzaangors", 10, 30, getPts("Tzaangors"));
        add(kultisten);

        add(ico = new oc.Picture("oc/wh40k/images/ChaosKultisten.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Tzaangor blades", "Tzaangor blades", getPts("Tzaangor blades")));
        ogE.addElement(new OptionsGruppeEintrag("Autopistol/Chainsword", "Autopistol & Chainsword", getPts("Autopistol") + getPts("Chainsword")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 10));
        o1.setAnzahl(0, kultisten.getModelle());

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Brayhorn", getPts("Brayhorn")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Icon of Flame", getPts("Icon of Flame")));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, CHEmptykammer.class, "Twistbray");
        ((CHEmptykammer) rkBoss.getKammer()).type = "Twistbray";
        rkBoss.initKammer();
        rkBoss.setGrundkosten(getPts("Twistbray"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();

    }

    @Override
    public void refreshen() {

        o1.setMaxAnzahl(kultisten.getModelle());

        power = 4 +
                ((kultisten.getModelle() == 20) ? 3 : 0) +
                ((kultisten.getModelle() == 30) ? 6 : 0);
    }
}
