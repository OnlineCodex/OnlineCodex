package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMCompanyAncientonBike extends Eintrag {
	RuestkammerStarter waffenUndReliquien;

	public IMCompanyAncientonBike() {
		name = "Company Ancient on Bike";
		grundkosten = getPts("Company Ancient on Bike") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Twin boltgun");
		power = 5;
		seperator();

		waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceMarinesRuestkammer", "");
		((IMSpaceMarinesRuestkammer)waffenUndReliquien.getKammer()).setType("Company Ancient");
		waffenUndReliquien.initKammer();
		waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
		add(waffenUndReliquien);
		waffenUndReliquien.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
	}
}
