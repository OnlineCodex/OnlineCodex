package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

//[IA Experimental]

public class TAKX139TaunarSupremacyArmour extends Eintrag {

	OptionsEinzelUpgrade o3;

	public TAKX139TaunarSupremacyArmour() {
		name = "KX139 Ta'unar Supremacy Armour";
		grundkosten = 600;

		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/Commander.gif"));
		
		seperator();

		add(o3 = new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Fusion Eradicator", 0));
		
		complete();
	}

	//@OVERRIDE
	public void refreshen() {
	}
	
}
