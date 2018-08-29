package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMTechmarineonBike extends Eintrag {
	OptionsEinzelUpgrade jump;
	RuestkammerStarter waffenUndReliquien;

	public IMTechmarineonBike() {
		name = "Techmarine on Bike";
		grundkosten = getPts("Techmarine on Bike") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Twin boltgun (SM)");

		seperator();


		waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceMarinesRuestkammer", "");
		((IMSpaceMarinesRuestkammer)waffenUndReliquien.getKammer()).setType("Techmarine");
		waffenUndReliquien.initKammer();
		waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
		add(waffenUndReliquien);
		waffenUndReliquien.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
		power = 6 + (((IMSpaceMarinesRuestkammer)waffenUndReliquien.getKammer()).oe1.isSelected()?1:0);
	}
}
