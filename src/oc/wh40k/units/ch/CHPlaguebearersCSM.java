package oc.wh40k.units.ch;

import java.io.SerializablePermission;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CHPlaguebearersCSM extends Eintrag {

	AnzahlPanel plaguebearers;
	OptionsEinzelUpgrade ridden;

	public CHPlaguebearersCSM() {

		name = "Plaguebearers";
        grundkosten = 0;
        power = 5; 

        add(plaguebearers = new AnzahlPanel(ID, randAbstand, cnt, "Plaguebearers", 10, 30, getPts("Plaguebearers CSM")));
        
        seperator();
        
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument of Chaos", getPts("Instrument of Chaos")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Icon", getPts("Daemonic Icon CSM")));
		
		seperator();
		
		add(ridden = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Plagueridden", getPts("Plagueridden")));
		
		complete();

	}

	public void deleteYourself() { 
	}


	@Override
	public void refreshen() {
		
		power = 5 +
				((plaguebearers.getModelle()==20)?5:0) +
				((plaguebearers.getModelle()==30)?10:0);
		
		if(!ridden.isSelected())ridden.setSelected(true);
	}
}
