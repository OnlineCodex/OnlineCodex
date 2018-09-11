
package oc.wh40k.units.cm;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CMFahrzeugruestkammer extends RuestkammerVater {

	OptionsUpgradeGruppe fahrzeugausruestung;

    boolean isTank = false;

	public CMFahrzeugruestkammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		try {
				isTank = defaults[0];
                } catch(Exception e) {}

		if(isTank) {
	        ogE.addElement(new OptionsGruppeEintrag("Kombibolter", 5));
	        ogE.addElement(new OptionsGruppeEintrag("Kakophon", 5));
	        ogE.addElement(new OptionsGruppeEintrag("Bulldozerschaufel", 5));
	        ogE.addElement(new OptionsGruppeEintrag("Warpfeuerspeier", 5));
	        ogE.addElement(new OptionsGruppeEintrag("Kombiflammenwerfer", 10));
	        ogE.addElement(new OptionsGruppeEintrag("Kombimelter", 10));
	        ogE.addElement(new OptionsGruppeEintrag("Kombiplasmawerfer", 10));
	        ogE.addElement(new OptionsGruppeEintrag("Zusätzliche Panzerung", 10));
	        ogE.addElement(new OptionsGruppeEintrag("Inferno-Raketenwerfer", 12));
	        ogE.addElement(new OptionsGruppeEintrag("Zerstörer-Klingen", 15));
	        ogE.addElement(new OptionsGruppeEintrag("Dämonenmaschine", 15));
	        add(fahrzeugausruestung=new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE,9));
		} else {
	        ogE.addElement(new OptionsGruppeEintrag("Kombibolter", 5));
	        ogE.addElement(new OptionsGruppeEintrag("Kakophon", 5));
	        ogE.addElement(new OptionsGruppeEintrag("Warpfeuerspeier", 5));
	        ogE.addElement(new OptionsGruppeEintrag("Kombiflammenwerfer", 10));
	        ogE.addElement(new OptionsGruppeEintrag("Kombimelter", 10));
	        ogE.addElement(new OptionsGruppeEintrag("Kombiplasmawerfer", 10));
	        ogE.addElement(new OptionsGruppeEintrag("Zusätzliche Panzerung", 10));
	        ogE.addElement(new OptionsGruppeEintrag("Inferno-Raketenwerfer", 12));
	        add(fahrzeugausruestung=new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE,6));
		}
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		fahrzeugausruestung.setAktiv("Kombiflammenwerfer",(!fahrzeugausruestung.isSelected("Kombimelter") && !fahrzeugausruestung.isSelected("Kombiplasmawerfer")));
		fahrzeugausruestung.setAktiv("Kombimelter",(!fahrzeugausruestung.isSelected("Kombiflammenwerfer") && !fahrzeugausruestung.isSelected("Kombiplasmawerfer")));
		fahrzeugausruestung.setAktiv("Kombiplasmawerfer",(!fahrzeugausruestung.isSelected("Kombimelter") && !fahrzeugausruestung.isSelected("Kombiflammenwerfer")));
	}

}
