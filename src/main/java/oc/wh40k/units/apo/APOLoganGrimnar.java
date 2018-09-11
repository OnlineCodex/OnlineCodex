package oc.wh40k.units.apo;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class APOLoganGrimnar extends Eintrag {

	OptionsEinzelUpgrade stormrider;
	
	public APOLoganGrimnar() {
		name = "Logan Grimnar";
		grundkosten = 250;

		addToInformationVector("SWHQ", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SWLoganGrimnar.jpg"));
		
		add(stormrider = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stormrider", 70));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
        if(getCountFromInformationVector("Kingsguard Stormforce")==1){
        	stormrider.setSelected(true);
        }
	}

	@Override
	public void deleteYourself() {

		super.deleteYourself();
	}

}
