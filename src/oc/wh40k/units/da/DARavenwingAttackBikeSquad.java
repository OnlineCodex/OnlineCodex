package oc.wh40k.units.da;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class DARavenwingAttackBikeSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1a;

	public DARavenwingAttackBikeSquad() {
		name = "Ravenwing Attack Bike Squad\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Attack Bike", "Attack Bikes", 1, 5, 45);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/DARavenwingSupportSquadron.gif"));

		seperator(12);

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
		add(o1a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		o1.setMaxAnzahl(squad.getModelle());
		o1a.setAnzahl(0, squad.getModelle());

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
		o1a.setMaxAnzahl(squad.getModelle()-o1.getAnzahl());
		o1a.setAnzahl(0,squad.getModelle()-o1.getAnzahl());
		o1.setMaxAnzahl(squad.getModelle());
	}

}
