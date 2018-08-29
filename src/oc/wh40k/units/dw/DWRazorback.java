package oc.wh40k.units.dw;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RefreshListener;

public class DWRazorback extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade chronus;

	boolean chronusSelected = false;

	public DWRazorback() {
		name = "Razorback";
		grundkosten = 55;

		add(ico = new oc.Picture("oc/wh40k/images/SMLandSpeederStorm.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Sturmkanone", "Synchronisierte Sturmkanone", 20));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 20));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));

		complete();
	}

	@Override
	public void refreshen() {
		o2.alwaysSelected();
	}

	@Override
	public void deleteYourself() {
		if(chronusSelected) {
			BuildaHQ.addToInformationVectorGlobal("SMChronusAdded", -1);
		}
		super.deleteYourself();
	}

}
