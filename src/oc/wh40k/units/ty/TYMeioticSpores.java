package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;

public class TYMeioticSpores extends Eintrag {

    AnzahlPanel squad;
        
    public TYMeioticSpores() {
        name = "Meiotic Spores";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Meiotic Spore", "Meiotic Spores", 3, 9, getPts("Meiotic Spores"));
		add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/TYMeioticSpore.gif"));
        
        complete();

    }

    @Override
	public void refreshen() {
		if(squad.getModelle() > 6){
			power = 6;
		} else if(squad.getModelle() > 3){
			power = 4;
		} else {
			power = 2;
		}
	}

}
