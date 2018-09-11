package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;

public class ORGretchin extends Eintrag {

	AnzahlPanel squad;

	public ORGretchin() {
		kategorie = 3;
		grundkosten = 0;

		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Gretchin", 10, 30, getPts("Gretchin")));
		add(ico = new oc.Picture("oc/wh40k/images/Grotz.gif"));
		
		seperator();
		
		complete();
	}

	@Override
	public void refreshen() {
		power = 2 + (squad.getModelle()-10)/10 * 1 + (squad.getModelle()%10 > 0 ? 1 : 0) * 1;
	}
}
