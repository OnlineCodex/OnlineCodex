/* Regeln für Deimos-Lux Pattern Psycannon unter:
 * http://www.forgeworld.co.uk/Downloads/Product/PDF/g/greyknightsupd.pdf
 * nicht mehr existent!
 */

package oc.wh40k.units.gk;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsPanelSwitcher;
import oc.OptionsUpgradeGruppe;
import oc.OptionsVater;
import oc.RuestkammerVater;

public class GKTransporterKammer extends RuestkammerVater {

    OptionsUpgradeGruppe typ;
    OptionsUpgradeGruppe razorWeapons;
    OptionsPanelSwitcher switcher;

    boolean offerRhinoRazor = false;

    public GKTransporterKammer() {
            grundkosten = 0;
    }

	@Override
	public void initButtons(boolean... defaults) {

		this.offerRhinoRazor = defaults[0];

		if (this.offerRhinoRazor) {
			ogE.addElement(new OptionsGruppeEintrag("Rhino", 35));
			ogE.addElement(new OptionsGruppeEintrag("Razorback", 55));
			ogE.addElement(new OptionsGruppeEintrag("[IA2 2nd Ed] Vortimer Razorb.","[IA2 2nd Ed] Vortimer Pattern Razorback", 85));
		}
		add(typ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		// If Razorback should be available, offer weapons for selection
		if(offerRhinoRazor) {
			seperator();

            ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 0));
            ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Flamer", "Synchronisierter Schwerer Flammenwerfer", 0));
            ogE.addElement(new OptionsGruppeEintrag("Sync. Sturmkanone", "Synchronisierte Sturmkanone", 20));
            ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 20));
            ogE.addElement(new OptionsGruppeEintrag("Laserkanone & Plasma", "Laserkanone und synchronisierter Plasmawerfer", 20));
			add(razorWeapons = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		}

        seperator();

		OptionsVater[] rhino = new OptionsVater[]{
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchkopfrakete", 10),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10)
		};

		OptionsVater[] razor = new OptionsVater[]{
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchkopfrakete", 10),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10)
		};
		
		add(switcher = new OptionsPanelSwitcher(randAbstand, cnt, rhino, razor));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if (!typ.isSelected()) {
			typ.setSelected(0, true);
		}

		if (typ.isSelected("Rhino")) {
			switcher.forceSwitchPanel(0);
        } else if (typ.isSelected("Razorback")) {
			switcher.forceSwitchPanel(1);
		} else if (typ.isSelected("Inquisitions-Chimäre")) {
			switcher.forceSwitchPanel(2);
		}

		if(offerRhinoRazor) {
			razorWeapons.setAktiv(typ.isSelected("Razorback"));
			if(razorWeapons.isAktiv() && !razorWeapons.isSelected()) {
				razorWeapons.setSelected(0, true);
			}
		}
	}

}
