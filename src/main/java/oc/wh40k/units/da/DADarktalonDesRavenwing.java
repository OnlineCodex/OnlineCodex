package oc.wh40k.units.da;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class DADarktalonDesRavenwing extends Eintrag {
	
	boolean added = false;

	public DADarktalonDesRavenwing() {
		name = "Darktalon des Ravenwing";
		grundkosten = 160;

		seperator();
        
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fliegerass", 50));
        
        complete();
	}

	@Override
	public void refreshen() {
	}
}