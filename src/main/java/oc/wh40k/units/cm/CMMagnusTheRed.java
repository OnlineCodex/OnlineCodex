package oc.wh40k.units.cm;



import oc.Eintrag;

import oc.OptionsUpgradeGruppe;



public class CMMagnusTheRed extends Eintrag {



    OptionsUpgradeGruppe o1;

    OptionsUpgradeGruppe o2;





    public CMMagnusTheRed() {

        name = "Magnus the Red";

        grundkosten = 650;



        setUnikat(true);



        complete();

    }



    @Override

    public void refreshen() {



    }



}

