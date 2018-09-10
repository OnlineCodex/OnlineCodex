package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMLordHighCommanderCarabCulln extends Eintrag {

	public SMLordHighCommanderCarabCulln() {
		name = "Lord High Commander Carab Culln";
		grundkosten = 215;

		addToInformationVector("SMLordHighCommanderCarabCulln", 1);
		addToInformationVector("SMChapterMaster", 1);
		addToInformationVector("SMOnlyOneChapterMaster", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SMMagisterSevrinLoth.gif"));

		complete();
	}

	@Override
	public void deleteYourself() {

		addToInformationVector("SMLordHighCommanderCarabCulln", -1);
		addToInformationVector("SMChapterMaster", -1);
		addToInformationVector("SMOnlyOneChapterMaster", -1);

		super.deleteYourself();
	}

	@Override
	public void refreshen() {
		setUnikat(true);

		if(getCountFromInformationVector("SMChapterMaster") > 1 && getCountFromInformationVector("SMOnlyOneChapterMaster") > 0) {
			setFehlermeldung("nur ein Ordensmeister");
		} else {
			setFehlermeldung("");
		}

	}

}
