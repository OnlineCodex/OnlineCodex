package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMAttackBikeSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o;

	public IMAttackBikeSquad() {
		name = "Attack Bike Squad";
		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Attack Bike", "Attack Bikes", 1, 3, getPts("Attack Bike Squad")));

		add(ico = new oc.Picture("oc/wh40k/images/SMTrikeSchwadron.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy Bolter", getPts("Heavy Bolter (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta (SM)")));
		add(o = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

		complete();
	}

	@Override
	public void refreshen() {
		o.setMaxAnzahl(squad.getModelle());
		o.setLegal(o.getAnzahl() == squad.getModelle());
		power = squad.getModelle() * 3;
	}

}
