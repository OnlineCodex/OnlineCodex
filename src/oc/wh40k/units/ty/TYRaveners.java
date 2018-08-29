package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TYRaveners extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	boolean uniqueError = false;
	boolean roterSchrecken = false;

	public TYRaveners() {
		name = "Raveners";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Raveners", 3, 9, getPts("Raveners") + getPts("Scything Talons"));
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYVenatoren.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Scything Talons", getPts("Scything Talons")));
		ogE.addElement(new OptionsGruppeEintrag("Rending Claws", getPts("Rending Claws")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setAnzahl(0, squad.getModelle());

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Spinefists", getPts("Spinefists (Ravener)")));
		ogE.addElement(new OptionsGruppeEintrag("Devourer", getPts("Devourer")));
		ogE.addElement(new OptionsGruppeEintrag("Deathspitter", getPts("Deathspitter")));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		
		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o2.setMaxAnzahl(squad.getModelle());
		
		o1.setLegal(o1.getAnzahl() == squad.getModelle());
		
		if(squad.getModelle() > 6){
			power = 12;
		} else if(squad.getModelle() > 3){
			power = 8;
		} else {
			power = 4;
		}
	}
}
