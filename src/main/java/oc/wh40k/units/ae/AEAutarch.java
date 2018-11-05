package oc.wh40k.units.ae;



import oc.Eintrag;

import oc.OptionsEinzelUpgrade;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;



public class AEAutarch extends Eintrag {



    OptionsEinzelUpgrade oe1;

    OptionsUpgradeGruppe o1, o2, o3;



    public AEAutarch() {

        name = "Autarch";

        grundkosten = getPts("Autarch") + getPts("Plasma grenades") + getPts("Forceshield");

        power = 4;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Star glaive", getPts("Star glaive")));

        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));



        complete();

    }



    @Override

    public void refreshen() {

        o1.alwaysSelected();

    }

}