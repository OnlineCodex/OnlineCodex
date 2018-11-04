package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMBrayarthAshmantle extends Eintrag {

    public SMBrayarthAshmantle() {
        //TODO Salamanders only
        name = "Bray'arth Ashmantle";
        grundkosten = 265;

        addToInformationVector("SMHQ", 1);

        add(ico = new oc.Picture("oc/wh40k/images/CaptainLysander.gif"));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("SMHQ", -1);
        super.deleteYourself();
    }

}
