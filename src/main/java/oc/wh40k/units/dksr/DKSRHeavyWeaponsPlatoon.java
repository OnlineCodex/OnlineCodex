package oc.wh40k.units.dksr;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class DKSRHeavyWeaponsPlatoon extends Eintrag {

	RuestkammerStarter heavyWeaponsSquad1;
	RuestkammerStarter heavyWeaponsSquad2;
	RuestkammerStarter heavyWeaponsSquad3;

	public DKSRHeavyWeaponsPlatoon() {
		name = "Heavy Weapon Platoon";
		grundkosten = 0;
		überschriftSetzen = true;


		add(ico = new oc.Picture("oc/wh40k/images/IGInfantryPlatoon.jpg"));
		

		seperator();

		heavyWeaponsSquad1 = new RuestkammerStarter(ID, randAbstand, cnt, "DKSRHeavyWeaponsSquad", "Heavy Weapons Squad", 1);
		heavyWeaponsSquad1.initKammer();
		heavyWeaponsSquad1.setGrundkosten(60);
		add(heavyWeaponsSquad1);

		seperator();

		heavyWeaponsSquad2 = new RuestkammerStarter(ID, randAbstand, cnt, "DKSRHeavyWeaponsSquad", "Heavy Weapons Squad", 1);
		heavyWeaponsSquad2.initKammer();
		heavyWeaponsSquad2.setGrundkosten(60);
		add(heavyWeaponsSquad2);

		seperator();

		heavyWeaponsSquad3 = new RuestkammerStarter(ID, randAbstand, cnt, "DKSRHeavyWeaponsSquad", "Heavy Weapons Squad", 1);
		heavyWeaponsSquad3.initKammer();
		heavyWeaponsSquad3.setGrundkosten(60);
		add(heavyWeaponsSquad3);

		complete();
	}

	@Override
	public void refreshen() {
        heavyWeaponsSquad1.setAbwaehlbar(false);
		heavyWeaponsSquad2.setAktiv(heavyWeaponsSquad1.isSelected());
		heavyWeaponsSquad3.setAktiv(heavyWeaponsSquad2.isSelected());

        heavyWeaponsSquad2.getPanel().setLocation((int) heavyWeaponsSquad2.getPanel().getLocation().getX(), (int) heavyWeaponsSquad1.getPanel().getLocation().getY() + (int)heavyWeaponsSquad1.getPanel().getSize().height + 10);
        heavyWeaponsSquad3.getPanel().setLocation((int) heavyWeaponsSquad3.getPanel().getLocation().getX(), (int) heavyWeaponsSquad2.getPanel().getLocation().getY() + (int)heavyWeaponsSquad2.getPanel().getSize().height + 10);
    }
}
