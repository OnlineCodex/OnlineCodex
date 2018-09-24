package oc.wh40k.units.dw;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class DWTransporterKammer extends RuestkammerVater {

	OptionsGruppeEintrag oeRazor;
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;

	boolean[] defaults;
	int mod;

	public DWTransporterKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) { // [0] = kostenlos? [1] = Razorback?
		this.defaults = defaults;

		add(ico = new oc.Picture("oc/wh40k/images/SMRhinoGross.jpg"));

		mod = 1;

		if (defaults.length > 0) {
			mod = (defaults[0] ? 0 : 1);
		}

		ogE.addElement(new OptionsGruppeEintrag("Rhino", 35 * mod));

		if (defaults[1]) {
			ogE.addElement(oeRazor = new OptionsGruppeEintrag("Razorback", 55 * mod));
		}

		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator(5);

		if (defaults[1]) {
			ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 0));
			ogE.addElement(new OptionsGruppeEintrag("Sync. Sturmkanone", "Synchronisierte Sturmkanone", 20));
			ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 20));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

			seperator();
		}

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));

		sizeSetzen();

	}
	boolean razorbackBild = false;

	@Override
	public void refreshen() {
		boolean razorback = o1.isSelected("Razorback");
		o1.setPreis(0, 35 * mod);

		o1.alwaysSelected();
		
		if (razorback && !o2.isSelected()) {
			o2.setSelected("Synchronisierter Schwerer Bolter", true);
		}

		if (defaults[1]) {
			o2.setAktiv(razorback);
			o1.setPreis("Razorback", 55 * mod);
		}

		if (razorback == true && razorbackBild == false) {
			String icon = "oc/wh40k/images/SMRazorbackGross.jpg";
			ico.setIcon(icon);

			try {
				ico.updateSize();
			} catch (Exception e) {
			}

			razorbackBild = true;
		}

		if (razorback == false && razorbackBild == true) {
			String icon = "oc/wh40k/images/SMRhinoGross.jpg";
			ico.setIcon(icon);

			try {
				ico.updateSize();
			} catch (Exception e) {
			}

			razorbackBild = false;
		}
	}

	@Override
	public void specialAction(boolean... b) {
		if(oeRazor != null) {
			o1.setAktiv("Razorback", b[0]);
			o2.setAktiv(b[0] && o1.isSelected("Razorback"));
		}
	}

	@Override
	public void deleteYourself() {

		super.deleteYourself();
	}

}
