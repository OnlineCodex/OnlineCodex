package oc.wh40k.units.im;

import oc.*;

public class IMSkitariiRangers extends Eintrag {

    AnzahlPanel squad;
    OptionsUpgradeGruppe o1;
    OptionsZaehlerGruppe o2;
    RuestkammerStarter rkBoss;

    public IMSkitariiRangers() {
        name = "Skitarii Rangers";
        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Skitarii Rangers", 5, 10, getPts("Skitarii Rangers")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Enh. data-tehter", "Enhanced data-tehter", getPts("Enhanced data-tether")));
        ogE.addElement(new OptionsGruppeEintrag("Omnispex", getPts("Omnispex")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE = IMAdeptusMechanicusSpecialWeapons.createRK("Galvanic rifle", "Galvanic rifle", buildaVater);
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, IMAdeptusMechanicusRuestkammer.class, "Ranger Alpha");
        rkBoss.initKammer(false, true, false, false);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() >= 10)
            o2.setMaxAnzahl(3);
        else
            o2.setMaxAnzahl(2);

        power = 4;
        if (squad.getModelle() > 5) {
            power = 8;
        }
    }

}
