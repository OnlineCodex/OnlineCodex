package oc.wh40k.units.da;

import oc.Eintrag;

public class DAEzekiel extends Eintrag {

    public DAEzekiel() {
        name = "Ezekiel";
        grundkosten = 145;

        add(ico = new oc.Picture("oc/wh40k/images/DAEzekiel.gif"));

        addToInformationVector("DAHQ", 1);
        complete();
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("DAHQ", -1);
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
