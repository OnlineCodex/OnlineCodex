package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDBloodcrushers extends Eintrag {

	AnzahlPanel bloodcrushers;
	OptionsEinzelUpgrade hunter;

	public CDBloodcrushers() {

		name = "Bloodcrushers";
        grundkosten = 0;
        power = 5; 

        add(bloodcrushers = new AnzahlPanel(ID, randAbstand, cnt, "Bloodcrushers", 3, 12, getPts("Bloodcrushers")));
        
        seperator();
        
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument of Chaos", getPts("Instrument of Chaos")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Icon", getPts("Daemonic Icon")));
		
		seperator();
		
		add(hunter = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bloodhunter", getPts("Bloodhunter")));
		
		complete();

	}

	public void deleteYourself() { 
	}


	@Override
	public void refreshen() {	
		if(!hunter.isSelected())hunter.setSelected(true);
	}
}
