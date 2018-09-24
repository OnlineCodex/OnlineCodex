package oc.wh40k.units.dw;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DWWatchCaptain extends Eintrag {

	boolean addedSpezialAuswahl = false; // spezialauswahl ist abhängig von "Space Marine bike"
	OptionsEinzelUpgrade meister, sturm, termi;
	RuestkammerStarter waffenUndReliquien;
	RuestkammerStarter termiWaffen;
	RuestkammerStarter spezialAusruestung;

	public DWWatchCaptain() {
		name = "Watch Captain";
		grundkosten = getPts("Watch Captain");

		addToInformationVector("Captain", 1);

		add(ico = new oc.Picture("oc/wh40k/images/Kommandant.gif"));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump pack", getPts("Watch Captain with Jump Pack") - getPts("Watch Captain")));
		
		seperator();

		waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "DWWaffenUndReliquien", "");
		((DWWaffenUndReliquien)waffenUndReliquien.getKammer()).SetType("Watch Captain");
		waffenUndReliquien.initKammer();
		waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
		add(waffenUndReliquien);
		waffenUndReliquien.setAbwaehlbar(false);

		seperator();

		complete();
	}

	@Override
	public void deleteYourself() {

		super.deleteYourself();
	}

	@Override
	public void refreshen() {

	}

}
