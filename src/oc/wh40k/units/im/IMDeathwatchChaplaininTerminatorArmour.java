package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMDeathwatchChaplaininTerminatorArmour extends Eintrag {
	OptionsEinzelUpgrade jump;
	RuestkammerStarter waffenUndReliquien;

	public IMDeathwatchChaplaininTerminatorArmour() {
		name = "Chaplain in Terminator Armour";
		grundkosten = getPts("Chaplain in Terminator Armour") + getPts("Crozius arcanum");
		power = 6;
		seperator();

		waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "DeathWatchKammer", "");
		((DeathWatchKammer)waffenUndReliquien.getKammer()).setType("Chaplain in Terminator Armour");
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
