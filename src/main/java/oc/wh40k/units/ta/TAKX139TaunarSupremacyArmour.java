package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

//[IA Experimental]

public class TAKX139TaunarSupremacyArmour extends Eintrag {

	public TAKX139TaunarSupremacyArmour() {
        name = "KX139 Ta'unar Supremacy Armour";
        grundkosten = 600;

        applyTitle = true;

        add(ico = new oc.Picture("oc/wh40k/images/Commander.gif"));

        seperator();

        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Fusion Eradicator", 0));

        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
    }

}
