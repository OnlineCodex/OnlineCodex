package oc.wh40k.units.dw;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class DWChaplain extends Eintrag {

	RuestkammerStarter waffenUndReliquien;
	RuestkammerStarter spezialAusruestung;

	public DWChaplain() {
		name = "Watch Master";
		grundkosten = 95;

		add(ico = new oc.Picture("oc/wh40k/images/Kommandant.gif"));

		seperator();
		
		waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "DWWaffenUndReliquien", "");
		// Kompaniemeister, Absolutionspriester, Ordenspriester, Skriptor, Techmarine
		waffenUndReliquien.initKammer(false, false, true);
		waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
		add(waffenUndReliquien);
		waffenUndReliquien.setAbwaehlbar(false);

		seperator();

		spezialAusruestung = new RuestkammerStarter(ID, randAbstand, cnt, "DWSpezialausruestung", "");
		spezialAusruestung.initKammer(false, true, false);
		spezialAusruestung.setButtonText(BuildaHQ.translate("Spezielle Ausrüstung"));
		add(spezialAusruestung);
		spezialAusruestung.setAbwaehlbar(false);

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
