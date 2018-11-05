package oc.wh40k.units.ae;



import oc.Eintrag;

import oc.OptionsEinzelUpgrade;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;



public class AEAutarchSkyrunner extends Eintrag {



    OptionsEinzelUpgrade oe1;

    OptionsUpgradeGruppe o1;



    public AEAutarchSkyrunner() {

        name = "Autarch Skyrunner";

        grundkosten = getPts("Autarch Skyrunner") + getPts("Twin shuriken catapult");

        power = 7;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));

        ogE.addElement(new OptionsGruppeEintrag("Laser lance", getPts("Laser lance")));

        ogE.addElement(new OptionsGruppeEintrag("Fusion gun", getPts("Fusion gun")));

        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));



        complete();

    }



    @Override

    public void refreshen() {

        o1.alwaysSelected();

    }

}

