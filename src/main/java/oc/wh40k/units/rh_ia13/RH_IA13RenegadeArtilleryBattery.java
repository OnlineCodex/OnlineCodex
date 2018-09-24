package oc.wh40k.units.rh_ia13;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class RH_IA13RenegadeArtilleryBattery extends Eintrag {

	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;
	
	OptionsEinzelUpgrade mt;

	public RH_IA13RenegadeArtilleryBattery() {
		name = "Renegade Artillery Battery";
		grundkosten = 0;
		this.überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/IGHellhoundSquadron.jpg"));

		add(mt = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Militia Training", 10,1));
		
		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeArtilleryKammer", "", 1);
		t1.initKammer();
		t1.setButtonText("Tank 1");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeArtilleryKammer", "", 1);
		t2.initKammer();
		t2.setButtonText("Tank 2");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeArtilleryKammer", "", 1);
		t3.initKammer();
		t3.setButtonText("Tank 3");
		add(t3);
		

		complete();
	}

	@Override
	public void refreshen() {
		int tanks = (t1.isSelected()?1:0) + (t2.isSelected()?1:0) + (t3.isSelected()?1:0);
		mt.setModelle(tanks);
		
		if(getCountFromInformationVector("RHBloodyHandedReaver")==1){
        	mt.setSelected(true);
		}
	}

}
