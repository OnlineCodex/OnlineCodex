package oc.wh40k.units.ab;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ABSalamanderReconnaisanceCommander extends Eintrag {

    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o5;

    boolean mutex = false;

	public ABSalamanderReconnaisanceCommander() {
		name = "Salamander Reconnaisance Commander";
		grundkosten = 75;

		add(ico = new oc.Picture("oc/wh40k/images/ABCompanyCommandTank.jpg"));

		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", 10));
		ogE.addElement(new OptionsGruppeEintrag("Storm bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("AA Heavy stubber","Anti-aircraft mount heavy stubber", 15));
		ogE.addElement(new OptionsGruppeEintrag("AA Storm bolter","Anti-aircraft mount storm bolter", 15));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dozerblade", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Extra armour", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo-netting", 20));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Mine plough", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Artificer hull", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Armoured track guards", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Improved comms", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Anti-grenade mesh", 15));


		complete();
	}

	@Override
	public void refreshen() {
        o2.alwaysSelected();
	}

}
