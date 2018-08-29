package oc.wh40k.units.or;

import oc.Eintrag;
import oc.RuestkammerStarter;



public class ORFlakkTrukk extends Eintrag {

		RuestkammerStarter t1;
	    RuestkammerStarter t2;
	    RuestkammerStarter t3;
		
	    public ORFlakkTrukk() {
	    
		name = "Flakk Trukk";
		grundkosten = 0;
	
	
		add(ico = new oc.Picture("oc/wh40k/images/GunTrukk.gif"));
		
	
	    t1 = new RuestkammerStarter(ID, randAbstand, cnt, "ORFlakkTrukkKammer", "Flakk Trukk");
		t1.initKammer();
		add(t1);
	
	    seperator();
	
	    t2 = new RuestkammerStarter(ID, randAbstand, cnt, "ORFlakkTrukkKammer", "Flakk Trukk");
		t2.initKammer();
		add(t2);
	
	    seperator();
	
	    t3 = new RuestkammerStarter(ID, randAbstand, cnt, "ORFlakkTrukkKammer", "Flakk Trukk");
		t3.initKammer();
		add(t3);
	
		complete();
	
	
	
    }

	//@OVERRIDE
	public void refreshen() {
	}
}
