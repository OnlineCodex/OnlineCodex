package oc.wh40k.units.rh_ia13;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class RH_IA13RenegadeHydraBattery extends Eintrag {

	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;
	
	OptionsEinzelUpgrade mt;

	public RH_IA13RenegadeHydraBattery() {
		name = "Renegade Hydra Battery";
		grundkosten = 0;
		this.überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/IGHellhoundSquadron.jpg"));

		add(mt = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Militia Training", 10,1));
		
		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeHydraKammer", "Renegade Hydra", 1);
		t1.initKammer();
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeHydraKammer", "Renegade Hydra", 1);
		t2.initKammer();
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeHydraKammer", "Renegade Hydra", 1);
		t3.initKammer();
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
