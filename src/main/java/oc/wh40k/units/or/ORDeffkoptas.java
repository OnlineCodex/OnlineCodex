package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORDeffkoptas extends Eintrag {

	AnzahlPanel Killakoptaz;
	OptionsZaehlerGruppe KillakoptazFKx;
	OptionsZaehlerGruppe KillakoptazFK;
	OptionsEinzelZaehler Bomm;
	OptionsEinzelZaehler Killsaw;

	public ORDeffkoptas() {

		kategorie = 4;
		grundkosten = 0;

		add(Killakoptaz = new AnzahlPanel(ID, randAbstand, cnt, "Deffkopta", "Deffkoptas", 1, 5, getPts("Deffkoptas") + getPts("Spinnin' blades")));
		add(ico = new oc.Picture("oc/wh40k/images/Killakoptaz.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Kopta rokkits", getPts("Kopta rokkits")));
		add(KillakoptazFKx = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Kustom mega-blasta", getPts("Kustom mega-blasta")));
		ogE.addElement(new OptionsGruppeEintrag("Twin big shoota", getPts("Twin big shoota")));
		add(KillakoptazFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		add(Bomm = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Big bomm", 1, getPts("Big bomm")));
		add(Killsaw = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Killsaw", 1, getPts("Killsaw")));

		complete();

	}

	//@OVERRIDE
	public void refreshen() {
		KillakoptazFKx.setMaxAnzahl(Killakoptaz.getModelle()-KillakoptazFK.getAnzahl());
		KillakoptazFKx.setAnzahl(0,Killakoptaz.getModelle()-KillakoptazFK.getAnzahl());
		KillakoptazFK.setMaxAnzahl(Killakoptaz.getModelle());
		Killsaw.setMaxAnzahl(Killakoptaz.getModelle());
		Bomm.setMaxAnzahl(Killakoptaz.getModelle());
		if(Killakoptaz.getModelle()>3){
			power = 21;
		} else if(Killakoptaz.getModelle()>1){
			power = 13;
		} else {
			power = 5;
		}
	}
}
