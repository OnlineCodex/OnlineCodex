package oc.wh40k.units.ch;

import oc.RuestkammerVater;

public class CHEmptykammer extends RuestkammerVater {

    String type = "";

    public CHEmptykammer() {
        grundkosten = 0;
        name = "sdf";
    }

    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        sizeSetzen();
    }

    @Override
    public void refreshen() {

    }

}
