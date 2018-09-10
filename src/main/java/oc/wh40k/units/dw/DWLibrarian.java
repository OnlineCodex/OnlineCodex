package oc.wh40k.units.dw;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DWLibrarian extends Eintrag {

	boolean addedSpezialAuswahl = false; // spezialauswahl ist abhängig von "Space Marine bike"
	OptionsEinzelUpgrade meister, sturm, termi;
	RuestkammerStarter waffenUndReliquien;
	RuestkammerStarter termiWaffen;
	RuestkammerStarter spezialAusruestung;

	public DWLibrarian() {
		name = "Librarian";
		grundkosten = 95;

		addToInformationVector("Captain", 1);

		add(ico = new oc.Picture("oc/wh40k/images/Kommandant.gif"));

		seperator();

		waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "DWWaffenUndReliquien", "");
		// Kompaniemeister, Absolutionspriester, Ordenspriester, Skriptor, Techmarine
		waffenUndReliquien.initKammer(false, false, false, true);
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
