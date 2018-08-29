package oc.wh40k.units.ab;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ABScoutSentinel extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	public ABScoutSentinel() {
		grundkosten = 35;
	}
	
  @Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag("Multi-laser", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Autocannon", 5));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multiple rocket pod", 15));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        setHeadline(o1, "Weapons & options");

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Searchlight", 1));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));

		sizeSetzen();
	}

  @Override
	public void refreshen() {
        o1.alwaysSelected();
	}

}
