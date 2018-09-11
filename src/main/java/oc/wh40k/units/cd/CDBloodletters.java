package oc.wh40k.units.cd;

import java.io.SerializablePermission;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDBloodletters extends Eintrag {

	AnzahlPanel bloodletters;
	OptionsEinzelUpgrade reaper;

	public CDBloodletters() {

		name = "Bloodletters";
        grundkosten = 0;
        power = 5; 

        add(bloodletters = new AnzahlPanel(ID, randAbstand, cnt, "Bloodletters", 10, 30, getPts("Bloodletters")));
        
        seperator();
        
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument of Chaos", getPts("Instrument of Chaos")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Icon", getPts("Daemonic Icon")));
		
		seperator();
		
		add(reaper = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bloodreaper", getPts("Bloodreaper")));
		
		complete();

	}

	public void deleteYourself() { 
	}


	@Override
	public void refreshen() {
		power = bloodletters.getModelle();
		
		if(!reaper.isSelected())reaper.setSelected(true);
	}
}
