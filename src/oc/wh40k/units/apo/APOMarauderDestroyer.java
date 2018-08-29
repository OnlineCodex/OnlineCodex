package oc.wh40k.units.apo;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class APOMarauderDestroyer extends Eintrag {

	public APOMarauderDestroyer() {
		name = "Marauder Destroyer";
		grundkosten = 425;


		add(ico = new oc.Picture("oc/wh40k/images/MarauderDestroyer.gif"));
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "flare/chaff launcher", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "armoured cockpit", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "illum flares", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "infra-red targeting", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","paint sheme", "distinctive paint sheme", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "8 Hellstrike missiles", 80));

		complete();

	}

	public void refreshen() {
	}
}
