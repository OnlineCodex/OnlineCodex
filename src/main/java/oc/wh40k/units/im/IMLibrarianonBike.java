package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMLibrarianonBike extends Eintrag {
	RuestkammerStarter waffenUndReliquien;

	public IMLibrarianonBike() {
		name = "Librarian on Bike";
		grundkosten = getPts("Librarian on Bike") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
		power = 8;

		seperator();

		waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceMarinesRuestkammer", "");
		((IMSpaceMarinesRuestkammer)waffenUndReliquien.getKammer()).setType("Librarian on Bike");
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
