package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TYPurestrainGenestealers extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;

	public TYPurestrainGenestealers() {
		name = "Purestrain Genestealers";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Purestrain Genestealers", 5, 20, getPts("Purestrain Genestealers") + getPts("Rending claws (GSC)"));
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Purestrain talons", getPts("Purestrain talons")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		if (squad.getModelle() > 15)
			power = 16;
		else if (squad.getModelle() > 10)
			power = 12;
		else if (squad.getModelle() > 5)
			power = 8;
		else
			power = 4;
	}

}