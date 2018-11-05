package oc.wh40k.units;

import oc.Eintrag;

public class Celestine extends Eintrag {

    public Celestine() {
        name = "Sankt Celestine";
        grundkosten = 200;

        add(ico = new oc.Picture("oc/wh40k/images/ASSanktCelestine.jpg"));

        seperator();

        complete();

        addToInformationVector("EcclesiarchyRelics", 1);
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("EcclesiarchyRelics", -1);
        super.deleteYourself();
    }

}
