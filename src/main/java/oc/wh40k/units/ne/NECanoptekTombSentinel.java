package oc.wh40k.units.ne;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class NECanoptekTombSentinel extends Eintrag {
	
	public NECanoptekTombSentinel() {
		name = "Canoptek Tomb Sentinel";
		grundkosten = getPts("Canoptek Tomb Sentinel") + getPts("Exile cannon") + getPts("Automaton claws");
		power = 9;
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Gloom prism", getPts("Gloom prism")));

		complete();
	}

	@Override
	public void refreshen() {
	} 
}
