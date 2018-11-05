package oc.wh40k.units.cm;

import oc.Eintrag;

public class CMFabiusGallus extends Eintrag {

    boolean eliteBool = false;

    public CMFabiusGallus() {
        name = "Fabius Gallus";
        grundkosten = 165;

        add(ico = new oc.Picture("oc/wh40k/images/FabiusBile.gif"));
        addToInformationVector("CMFabiusGallus", 1);
        buildaVater.getChooserGruppeForChange(3).addSpezialAuswahl("EliteKrieger");
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("CMFabiusGallus", -1);
        if (getCountFromInformationVector("CMFabiusGallus") <= 0) {
            buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("EliteKrieger");
        }
        super.deleteYourself();
    }

}
