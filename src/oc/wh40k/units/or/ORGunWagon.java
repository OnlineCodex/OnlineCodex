package oc.wh40k.units.or;

import oc.Eintrag;
import oc.RuestkammerStarter;



public class ORGunWagon extends Eintrag {

		RuestkammerStarter t1;
	    RuestkammerStarter t2;
	    RuestkammerStarter t3;
		
	    public ORGunWagon() {
	    
		name = "Gun Wagon";
		grundkosten = 0;
	
	
		add(ico = new oc.Picture("oc/wh40k/images/GunWagon.gif"));
		
	
	    t1 = new RuestkammerStarter(ID, randAbstand, cnt, "ORGunWagonKammer", "Gun Wagon");
		t1.initKammer();
		add(t1);
	
	    seperator();
	
	    t2 = new RuestkammerStarter(ID, randAbstand, cnt, "ORGunWagonKammer", "Gun Wagon");
		t2.initKammer();
		add(t2);
	
	    seperator();
	
	    t3 = new RuestkammerStarter(ID, randAbstand, cnt, "ORGunWagonKammer", "Gun Wagon");
		t3.initKammer();
		add(t3);
	
		complete();
	
	
	
    }

	//@OVERRIDE
	public void refreshen() {
	}
}
