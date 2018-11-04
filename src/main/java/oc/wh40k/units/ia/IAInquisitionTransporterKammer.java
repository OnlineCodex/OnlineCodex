/* Regeln für Deimos-Lux Pattern Psycannon unter:
 * http://www.forgeworld.co.uk/Downloads/Product/PDF/g/greyknightsupd.pdf
 * nicht mehr existent!
 */

package oc.wh40k.units.ia;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IAInquisitionTransporterKammer extends RuestkammerVater {

    OptionsUpgradeGruppe typ;
    OptionsUpgradeGruppe promethium;
    OptionsEinzelUpgrade melter;

    OptionsUpgradeGruppe vehicleUpgrades;

    OptionsUpgradeGruppe chimeraWeapons1;
    OptionsUpgradeGruppe chimeraWeapons2;
    OptionsUpgradeGruppe razorWeapons;
    OptionsUpgradeGruppe LRWeapons;

    public IAInquisitionTransporterKammer() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {

        ogE.addElement(new OptionsGruppeEintrag("Sororitas Rhino", 40));
        ogE.addElement(new OptionsGruppeEintrag("Inquisitions-Chimäre", 55));
        ogE.addElement(new OptionsGruppeEintrag("Land Raider", 250));
        ogE.addElement(new OptionsGruppeEintrag("Land Raider Crusader", 250));
        ogE.addElement(new OptionsGruppeEintrag("Land Raider Redeemer", 240));
        ogE.addElement(new OptionsGruppeEintrag("[IA2 2nd Ed] LR Prometheus", 270));
        add(typ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Suchscheinwerfer", 1));
        ogE.addElement(new OptionsGruppeEintrag("Bulldozerschaufel", 5));
        ogE.addElement(new OptionsGruppeEintrag("Psiaktive Munition", 5));
        ogE.addElement(new OptionsGruppeEintrag("Warpstabilisierungsfeld", 5));
        ogE.addElement(new OptionsGruppeEintrag("Suchkopfrakete", 10));
        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Wahrsilberpanzerung", 10));
        ogE.addElement(new OptionsGruppeEintrag("Zusätzliche Panzerung", 15));
        add(vehicleUpgrades = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 7));
        ogE.addElement(new OptionsGruppeEintrag("Psiaktives Promethium", 15));//LR Redeemer u Razor SFlamer
        add(promethium = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        add(melter = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multimelter", 10)); //alle LR

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sync. schwerer Bolter", "Synchronisierter schwerer Bolter", 0));        //LR
        ogE.addElement(new OptionsGruppeEintrag("Sync. Sturmkanone", "Synchronisierte Sturmkanone", 0));                //LR Crusader u LR Redeemer
//        ogE.addElement(new OptionsGruppeEintrag("[FW] Psycannon", "[Forgeworld] Deimos-Lux Pattern Psycannon", 40));
        add(LRWeapons = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Flamer", "Synchronisierter Schwerer Flammenwerfer", 25));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Sturmkanone", "Synchronisierte Sturmkanone", 35));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 35));
        ogE.addElement(new OptionsGruppeEintrag("Laserkanone & Plasma", "Laserkanone und synchronisierter Plasmawerfer", 35));
//		ogE.addElement(new OptionsGruppeEintrag("[FW] Psycannon", "[Forgeworld] Deimos-Lux Pattern Psycannon", 40));
        add(razorWeapons = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Multilaser", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 0));
        add(chimeraWeapons1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 0));
        add(chimeraWeapons2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        sizeSetzen(200, 100, 390, KAMMER_HOEHE + cnt);
    }

    @Override
    public void refreshen() {
        if (!typ.isSelected()) {
            typ.setSelected(0, true);
        }

        chimeraWeapons1.setAktiv(typ.isSelected("Inquisitions-Chimäre"));
        chimeraWeapons2.setAktiv(typ.isSelected("Inquisitions-Chimäre"));
        razorWeapons.setAktiv(typ.isSelected("Razorback"));
        LRWeapons.setAktiv(0, typ.isSelected("Land Raider"));
        LRWeapons.setAktiv(1, (typ.isSelected("Land Raider Crusader") || typ.isSelected("Land Raider Redeemer")));
//		LRWeapons.setAktiv(2, (typ.isSelected("Land Raider Crusader") || typ.isSelected("Land Raider Redeemer") || typ.isSelected("Land Raider")));
        melter.setAktiv((typ.isSelected("Land Raider Crusader") || typ.isSelected("Land Raider Redeemer") || typ.isSelected("Land Raider") || typ.isSelected("[IA2 2nd Ed] LR Prometheus")));
        promethium.setAktiv(typ.isSelected("Land Raider Redeemer") || (typ.isSelected("Razorback") && razorWeapons.isSelected(1)));

        if (typ.isSelected("Land Raider") && !LRWeapons.isSelected()) {
            LRWeapons.setSelected(0, true);
        }

        if ((typ.isSelected("Land Raider Crusader") || typ.isSelected("Land Raider Redeemer")) && !LRWeapons.isSelected()) {
            LRWeapons.setSelected(1, true);
        }

        if (typ.isSelected("Razorback") && !razorWeapons.isSelected()) {
            razorWeapons.setSelected(0, true);
        }

        if (typ.isSelected("Inquisitions-Chimäre") && !chimeraWeapons1.isSelected()) {
            chimeraWeapons1.setSelected(0, true);
        }

        if (typ.isSelected("Inquisitions-Chimäre") && !chimeraWeapons2.isSelected()) {
            chimeraWeapons2.setSelected(0, true);
        }

    }
}
