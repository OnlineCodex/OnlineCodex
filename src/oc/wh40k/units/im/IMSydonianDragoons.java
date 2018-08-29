package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMSydonianDragoons extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1x;
	OptionsEinzelZaehler oe1;
	OptionsEinzelZaehler oe2;
	OptionsEinzelZaehler oe3;
	OptionsEinzelZaehler oe4;
	OptionsEinzelZaehler oe5;
	OptionsEinzelZaehler oe6;
	OptionsEinzelZaehler oe7;
	OptionsEinzelZaehler oe8;
	
	public IMSydonianDragoons() {
		name = "Sydonian Dragoons";
		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Sydonian Dragoons", 1, 6, getPts("Sydonian Dragoons")));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Taser lance", getPts("Taser lance")));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Radium jezzail", getPts("Radium jezzail")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
		
		add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Phosphor serpenta", 1, getPts("Phosphor serpenta")));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o1x.setMaxAnzahl(squad.getModelle());
		oe1.setMaxAnzahl(squad.getModelle());
		o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl());
		
		power = squad.getModelle()*3;
	}
}
