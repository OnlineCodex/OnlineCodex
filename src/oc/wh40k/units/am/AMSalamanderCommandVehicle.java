package oc.wh40k.units.am;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class AMSalamanderCommandVehicle extends Eintrag {

    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o5;

    boolean mutex = false;
    
	public AMSalamanderCommandVehicle() {
		name = "Salamander Reconnaisance Commander";
		grundkosten = 60;

		add(ico = new oc.Picture("oc/wh40k/images/ABCompanyCommandTank.jpg"));

		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", 10));
		ogE.addElement(new OptionsGruppeEintrag("Storm bolter", 10));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dozerblade", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Extra armour", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo-netting", 20));

		complete();
	}

	@Override
	public void refreshen() {
        o2.alwaysSelected();
	}

}
