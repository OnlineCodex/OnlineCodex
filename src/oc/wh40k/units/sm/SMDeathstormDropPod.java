package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMDeathstormDropPod extends Eintrag {

    OptionsUpgradeGruppe o1;

	public SMDeathstormDropPod() {
		name = "Deathstorm Drop Pod";
		grundkosten = 75;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/SMDeathwindDropPod.jpg"));

		ogE.addElement(new OptionsGruppeEintrag("Auto Whirlwind launchers", 0));
		ogE.addElement(new OptionsGruppeEintrag("Auto assault cannon", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Drop Pod Assault SR",25));
		
		complete();
	}

	@Override
	public void refreshen() {
        o1.alwaysSelected();
	}

}
