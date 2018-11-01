package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORBurnaBommer extends Eintrag {

	OptionsEinzelUpgrade o1, o2;
	
	public ORBurnaBommer() {
		name = "Burna-Bommer";
		grundkosten = getPts("Burna-Bommer");
		power = 7;

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Supa shoota", getPts("supa shoota")));
		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Twin big shoota", getPts("Twin big shoota")));
		
		add(ico = new oc.Picture("oc/wh40k/images/BrennaBomma.gif"));
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt,"", "Skorcha missiles", getPts("Skorcha missile")));
        
		complete();

	}

	public void refreshen() {
		o1.setSelected(true);
		o2.setSelected(true);
	}
}
