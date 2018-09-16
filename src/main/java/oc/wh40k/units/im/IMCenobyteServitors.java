package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;

public class IMCenobyteServitors extends Eintrag {

	AnzahlPanel squad;
	
	public IMCenobyteServitors() {
		name = "Cenobyte Servitors";
		grundkosten = 0;
		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Cenobyte Servitors", 3, 3, getPts("Cenobyte Servitors")));
		power = 1;
		seperator();

		complete();
	}

	@Override
	public void refreshen() {
            setUnikat(true);    
	}
}
