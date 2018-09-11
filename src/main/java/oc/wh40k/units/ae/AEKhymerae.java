package oc.wh40k.units.ae;

import oc.AnzahlPanel;
import oc.Eintrag;

public class AEKhymerae extends Eintrag {

	AnzahlPanel squad;
	
	public AEKhymerae() {
		name = "Khymerae";
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Khymerae", 2, 12, getPts("Khymerae") + getPts("Claws and talons"));
		add(squad);

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
		if(squad.getModelle() > 10){
			power = 6;
		} else if(squad.getModelle() > 8){
			power = 5;
		} else if(squad.getModelle() > 6){
			power = 4;
		} else if(squad.getModelle() > 4){
			power = 3;
		} else if(squad.getModelle() > 2){
			power = 2;
		} else {
			power = 1;
		}
	}

}
