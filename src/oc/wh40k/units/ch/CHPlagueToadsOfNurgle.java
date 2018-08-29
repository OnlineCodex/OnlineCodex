package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;

public class CHPlagueToadsOfNurgle extends Eintrag {

	AnzahlPanel Gnarlmaws;

	public CHPlagueToadsOfNurgle() {

		name = "Plague Toads of Nurgle";
        grundkosten = 0;
        power = 3; 

        add(Gnarlmaws = new AnzahlPanel(ID, randAbstand, cnt, "Plague Toads of Nurgle", 3, 9, getPts("Plague Toads of Nurgle")));
        
		complete();

	}

	public void deleteYourself() { 
	}


	@Override
	public void refreshen() {	
		power = 6 +
				((Gnarlmaws.getModelle()<=3)?0:0) +
				((Gnarlmaws.getModelle()<=6)?6:0) +
				((Gnarlmaws.getModelle()<=9)?6:0);
	}

}
