package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;

public class TYSporenmines extends Eintrag {

	AnzahlPanel squad;

	public TYSporenmines() {
		name = "Sporenmines";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Sporenminen", 3, 6, getPts("Spore mine"));
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYSporenminen.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
		power = 1;
		if(squad.getModelle()>3){
			power = 2;
		}
	}

}
