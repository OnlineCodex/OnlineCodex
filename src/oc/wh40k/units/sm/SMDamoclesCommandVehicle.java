package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class SMDamoclesCommandVehicle extends Eintrag {


	public SMDamoclesCommandVehicle() {
		name = "Damocles Command Vehicle";
		grundkosten = 75;
		setUnikat(true);
		eintragsCNT=0;
		
		addToInformationVector("SMHQ", 1);
		
		add(ico = new oc.Picture("oc/wh40k/images/SMDamoclesCommandVehicle.jpg"));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Searchlight", 1));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 5));

		complete();
	}

	@Override
	public void refreshen() {
		setUnikat(true);
	}
	
	@Override
	public void deleteYourself() {
		addToInformationVector("SMHQ", -1);
		super.deleteYourself();
	}
}
