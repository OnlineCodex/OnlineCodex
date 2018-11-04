package oc.wh40k.units.ch;


import oc.Eintrag;

public class CHExaltedFlamerofTzeentch extends Eintrag {


    public CHExaltedFlamerofTzeentch() {

        name = "Exalted Flamer of Tzeentch";

        grundkosten = 50;

        add(ico = new oc.Picture("oc/wh40k/images/CDHerolddesTzeentch.gif"));

        complete();

    }

    @Override
    public void refreshen() {

    }
}
