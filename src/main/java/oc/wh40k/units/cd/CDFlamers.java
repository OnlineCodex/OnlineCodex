package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDFlamers extends Eintrag {

	AnzahlPanel flamers;
	OptionsEinzelUpgrade pyro;
	
	public CDFlamers() {

		name = "Flamers";
        grundkosten = 0;
        power = 5; 

        add(flamers = new AnzahlPanel(ID, randAbstand, cnt, "Flamers", 3, 9, getPts("Flamers")));
        
        seperator();
        	
		add(pyro = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Pyrocaster", getPts("Bloodreaper")));
        
		complete();

	}

	public void deleteYourself() { 
	}


	@Override
	public void refreshen() {	
		power = flamers.getModelle();
		if(!pyro.isSelected())pyro.setSelected(true);
	}
}
