package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMSanguinaryPriest extends Eintrag {
	OptionsEinzelUpgrade jump;
	RuestkammerStarter waffenUndReliquien;

	public IMSanguinaryPriest() {
		name = "Sanguinary Priest";
		grundkosten = getPts("Sanguinary Priest") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

		seperator();

		add(jump = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Pack", getPts("Sanguinary Priest with Jump Pack") - getPts("Sanguinary Priest")));

		seperator();

		waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceMarinesRuestkammer", "");
		((IMSpaceMarinesRuestkammer)waffenUndReliquien.getKammer()).setType("Sanguinary Priest");
		waffenUndReliquien.initKammer();
		waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
		add(waffenUndReliquien);
		waffenUndReliquien.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
		power = 4 + (jump.isSelected()?1:0);
	}
}
