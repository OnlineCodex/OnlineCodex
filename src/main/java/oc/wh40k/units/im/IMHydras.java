package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMHydras extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1x;
	OptionsZaehlerGruppe o2;
	OptionsEinzelZaehler oe1, oe2, oe3, oe4;

	public IMHydras() {
		name = "Hydras";
		grundkosten = 0;
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Hydra", "Hydras", 1, 3, getPts("Hydras") + getPts("Hydra quad autocannon"));
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (AM)")));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy Flamer (AM)")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (AM)")));
		ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber")));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Augur array", 1, getPts("Augur array")));
		add(oe2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Dozer blade", 1, getPts("Dozer blade")));
		add(oe3 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Hunter-killer missile", 1, getPts("Hunter-killer missile (AM)")));
		add(oe4 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Track guards", 1, getPts("Track guards")));

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o1x.setMaxAnzahl(squad.getModelle());
		o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl());
		
		o2.setMaxAnzahl(squad.getModelle());

		oe1.setMaxAnzahl(squad.getModelle());
		oe2.setMaxAnzahl(squad.getModelle());
		oe3.setMaxAnzahl(squad.getModelle());
		oe4.setMaxAnzahl(squad.getModelle());
		
		power = 7 * squad.getModelle();
	}

}
