package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsZaehlerGruppe;

public class IMCyberwolves extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;

	public IMCyberwolves() {
		name = "Cyberwolves\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Cyberwolf", "Cyberwolves", 1, 5, getPts("Cyberwolves"));
		add(squad);
		
		complete();
	}

	@Override
	public void refreshen() {
		power = squad.getModelle();
	}

}
