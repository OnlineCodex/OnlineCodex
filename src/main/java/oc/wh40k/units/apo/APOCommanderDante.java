package oc.wh40k.units.apo;


import oc.Eintrag;

public class APOCommanderDante extends Eintrag {

	public APOCommanderDante() {
		name = "Commander Dante";
		grundkosten = 220;

		add(ico = new oc.Picture("oc/wh40k/images/BACommanderDante.jpg"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}

}
