package oc.wh40k.units.im;



import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;



public class IMVenerableContemptorDreadnought extends Eintrag {

    OptionsUpgradeGruppe o2;



    public IMVenerableContemptorDreadnought() {

        name = "Venerable Contemptor Dreadnought";

        grundkosten = getPts("Venerable Contemptor Dreadnought") +

                getPts("Dreadnought combat weapon (AC)") +

                getPts("Combi-bolter (AC)");

        power = 10;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta (AC)")));

        ogE.addElement(new OptionsGruppeEintrag("Kheres assault cannon", "Kheres pattern assault cannon", getPts("Kheres pattern assault cannon (AC)")));

        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));



        complete();

    }



    @Override

    public void refreshen() {

        o2.alwaysSelected();

    }

}

