package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMDeathwatchChaplain extends Eintrag {
	OptionsEinzelUpgrade jump;
	RuestkammerStarter waffenUndReliquien;

	public IMDeathwatchChaplain() {
		name = "Chaplain";
		grundkosten = getPts("Chaplain") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Crozius arcanum");

		seperator();

		add(jump = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Pack", getPts("Chaplain with Jump Pack") - getPts("Chaplain")));

		seperator();

		waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "DeathWatchKammer", "");
		((DeathWatchKammer)waffenUndReliquien.getKammer()).setType("Chaplain");
		waffenUndReliquien.initKammer();
		waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
		add(waffenUndReliquien);
		waffenUndReliquien.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
		power = 5 + (jump.isSelected()?1:0);
	}
}
