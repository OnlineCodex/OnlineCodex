package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMChapterMasterLiasIssodon extends Eintrag {

	public SMChapterMasterLiasIssodon() {
		name = "Ordensmeister Lias Issodon";
		grundkosten = 175;

		addToInformationVector("SMChapterMaster", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SMChapterMasterLiasIssodon.jpg"));

		seperator();

		complete();
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

	@Override
	public void deleteYourself() {
		addToInformationVector("SMChapterMaster", -1);
		super.deleteYourself();
	}

}
