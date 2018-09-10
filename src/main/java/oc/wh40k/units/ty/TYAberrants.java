package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TYAberrants extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;

	public TYAberrants() {
		name = "Aberrants";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Aberrants", 4, 8, getPts("Aberrants") + getPts("Rending claws (GSC)"));
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Power pick", getPts("Power pick")));
		ogE.addElement(new OptionsGruppeEintrag("Power hammer", getPts("Power hammer")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		
		if(squad.getModelle() > 4) {
			power = 14;
		} else {
			power = 7;
		}
	}

}