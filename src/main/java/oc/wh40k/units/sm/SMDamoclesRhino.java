package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMDamoclesRhino extends Eintrag {

	public SMDamoclesRhino() {
		name = "Damocles Rhino";
		grundkosten = 60;
		überschriftSetzen = true;
		
		addToInformationVector("SMHQ", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SMDamoclesRhino.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

	@Override
	public void deleteYourself() {
		addToInformationVector("SMHQ", -1);
		super.deleteYourself();
	}
}
