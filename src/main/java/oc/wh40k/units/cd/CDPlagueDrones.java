package oc.wh40k.units.cd;

import java.io.SerializablePermission;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDPlagueDrones extends Eintrag {

	AnzahlPanel drones;
	OptionsEinzelUpgrade plaguebringer;

	public CDPlagueDrones() {

		name = "Plague Drones";
        grundkosten = 0;
        power = 5; 

        add(drones = new AnzahlPanel(ID, randAbstand, cnt, "Plague Drones", 3, 9, getPts("Plague Drones")));
        
        seperator();
        
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument of Chaos", getPts("Instrument of Chaos")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Icon", getPts("Daemonic Icon")));
		
		seperator();
		
		add(plaguebringer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Plaguebringer", getPts("Plaguebringer")));
		
		complete();

	}

	public void deleteYourself() { 
	}


	@Override
	public void refreshen() {
		power = drones.getModelle();
		
		if(!plaguebringer.isSelected())plaguebringer.setSelected(true);
	}
}
