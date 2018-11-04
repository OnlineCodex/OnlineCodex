package oc.wh40k.units.da;

import oc.Eintrag;

public class DAAsmodai extends Eintrag {

    public DAAsmodai() {
        name = "Asmodai";
        grundkosten = 140;

        add(ico = new oc.Picture("oc/wh40k/images/DAAsmodai.gif"));

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