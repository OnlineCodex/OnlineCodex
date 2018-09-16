package oc.wh40k.units.ta;

import oc.Eintrag;

public class TAShasoRalai extends Eintrag {

	public TAShasoRalai() {
		name = "Shas'o R'alai";
		grundkosten = getPts("Shas'o R'alai") + getPts("Experimental pulse submunitions rifle") + getPts("Drone controller") + 2*getPts("Blacklight Marker Drones") + 2*getPts("Markerlight");
		
		seperator();

		addToInformationVector("TACommander", 1);
		
		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
        
        power = 10;
	}
	
	//@OVERRIDE
	public void deleteYourself() {
		addToInformationVector("TACommander", -1);
		
		super.deleteYourself();
	}

}
