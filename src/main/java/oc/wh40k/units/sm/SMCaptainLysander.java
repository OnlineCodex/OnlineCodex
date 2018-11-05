package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMCaptainLysander extends Eintrag {

    public SMCaptainLysander() {
        name = "Captain Lysander";
        grundkosten = 230;

        add(ico = new oc.Picture("oc/wh40k/images/CaptainLysander.gif"));

        addToInformationVector("Captain Lysander", 1);

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);

        //Detachments
        boolean max1Error = false;
        if (getCountFromInformationVector("Strike Force Ultra") > 0) {
            int i = getCountFromInformationVector("Captain Lysander") + getCountFromInformationVector("Captain");
            if (i > 1) {
                max1Error = true;
            }
        }

        //Errors
        if (max1Error) {
            setFehlermeldung("Genau 1");
        } else if (getCountFromInformationVector("SMImperialFists") != 1) {
            setFehlermeldung("Keine Imperial Fists");
        } else {
            setFehlermeldung("");
        }
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("Captain Lysander", -1);
        super.deleteYourself();
    }
}
