package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORBlitzaBommer extends Eintrag {

	OptionsEinzelUpgrade o1, o2;
	
	public ORBlitzaBommer() {
		name = "Blitza-Bommer";
		grundkosten = getPts("Blitza-Bommer");
		
		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Two supa shoota", getPts("supa shoota")*2));
		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Big shoota", getPts("Big shoota")));
		
		power = 6;
		complete();
	}

	public void refreshen() {
		o1.setSelected(true);
		o2.setSelected(true);
	}
}
