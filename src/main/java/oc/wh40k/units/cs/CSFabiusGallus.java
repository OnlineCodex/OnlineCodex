package oc.wh40k.units.cs;

import oc.BuildaHQ;
import oc.Eintrag;

public class CSFabiusGallus extends Eintrag {

	public CSFabiusGallus() {
		name = "Fabius Gallus";
		grundkosten = 165;

		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("EliteKrieger");
		addToInformationVector("CMFabiusGallus", 1);
		
		add(ico = new oc.Picture("oc/wh40k/images/FabiusBile.gif"));
		

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
            BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("EliteKrieger");
        }
		super.deleteYourself();
	}

}
