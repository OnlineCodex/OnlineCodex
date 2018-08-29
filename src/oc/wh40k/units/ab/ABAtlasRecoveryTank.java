package oc.wh40k.units.ab;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ABAtlasRecoveryTank extends Eintrag {

    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;

    boolean mutex = false;

	public ABAtlasRecoveryTank() {
		name = "Atlas Recovery Tank";
		grundkosten = 85;
        setEintragsCNT(0);

		add(ico = new oc.Picture("oc/wh40k/images/ABAtlasRecoveryTank.jpg"));
		
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Heavy stubber", 10));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Storm bolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dozerblade", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Extra armour", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo-netting", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Mine plough", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Armoured track guards", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Improved comms", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Anti-grenade mesh", 15));

		complete();
	}

	@Override
	public void refreshen() {
        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());
	}

}
