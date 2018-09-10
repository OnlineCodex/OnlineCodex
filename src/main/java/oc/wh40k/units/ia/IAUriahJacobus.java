package oc.wh40k.units.ia;

import oc.Eintrag;

public class IAUriahJacobus extends Eintrag {

	public IAUriahJacobus() {
		name = "Uriah Jacobus";
		grundkosten = 100;

		
		add(ico = new oc.Picture("oc/wh40k/images/ASUriahJacobus.jpg"));

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
