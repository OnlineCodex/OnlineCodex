package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMPlatoonCommander extends Eintrag {
	
	RuestkammerStarter kammer;

	public IMPlatoonCommander() {
		name = "Platoon Commander";
		grundkosten = getPts("Platoon Commander") + getPts("Frag grenade (AM)");
		power = 2;
		
		kammer = new RuestkammerStarter(ID, randAbstand, cnt, "IMAstraMilitarumRuestkammer", "");
		((IMAstraMilitarumRuestkammer)kammer.getKammer()).setType("Platoon Commander");
		kammer.initKammer();
		kammer.setButtonText("Waffen");
		add(kammer);
		kammer.setAbwaehlbar(false);
		
		complete();
	}

	//@OVERRIDE
		public void refreshen() {
	        setUnikat(true);
		}
}