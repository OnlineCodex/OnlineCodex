package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMLordAsterionMoloc extends Eintrag {

    public SMLordAsterionMoloc() {
        name = "Lord Asterion Moloc";
        grundkosten = 235;
        addToInformationVector("SMChapterMaster", 1);

        add(ico = new oc.Picture("oc/wh40k/images/SMChapterMasterLiasIssodon.jpg"));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);

        if (getCountFromInformationVector("SMChapterMaster") > 1 && getCountFromInformationVector("SMOnlyOneChapterMaster") > 0) {
            setFehlermeldung("nur ein Ordensmeister");
        } else {
            setFehlermeldung("");
        }
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("SMChapterMaster", -1);
        super.deleteYourself();
    }

}
