package oc.wh40k.units.gk;

import oc.Eintrag;

public class GKBrotherhoodChampion extends Eintrag {

	public GKBrotherhoodChampion() {
		name = "Brotherhood Champion";
		grundkosten = 150;

		add(ico = new oc.Picture("oc/wh40k/images/GKSeneschallderBruderschaft.jpg"));
		addToInformationVector("GKHQ", 1);
		complete();
	}

	@Override
	public void refreshen() {
	}

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        addToInformationVector("GKHQ", -1);
    }
}
