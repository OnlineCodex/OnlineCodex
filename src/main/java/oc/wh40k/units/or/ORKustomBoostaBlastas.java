package oc.wh40k.units.or;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORKustomBoostaBlastas extends Eintrag {

	AnzahlPanel Buggies;
	OptionsZaehlerGruppe BuggiesFK;
	OptionsZaehlerGruppe BuggiesFKx;

	public ORKustomBoostaBlastas() {

		kategorie = 4;
		grundkosten = 0;

		Buggies = new AnzahlPanel(ID, randAbstand, cnt, "Warbuggy", "Warbuggies", 1, 5, getPts("Warbuggies"));
		add(Buggies);

		add(ico = new oc.Picture("oc/wh40k/images/Buggie.gif"));
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Twin big shoota", getPts("Twin big shoota")));
		add(BuggiesFKx = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Rack of rokkits", getPts("Rack of rokkits")));
		add(BuggiesFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		complete();
	}

	//@OVERRIDE
	public void refreshen() {

		BuggiesFKx.setMaxAnzahl(Buggies.getModelle()-BuggiesFK.getAnzahl());
		BuggiesFKx.setAnzahl(0,Buggies.getModelle()-BuggiesFK.getAnzahl());
		BuggiesFK.setMaxAnzahl(Buggies.getModelle());
		
		if(Buggies.getModelle() > 3){
			power = 16;
		} else if(Buggies.getModelle() > 1){
			power = 10;
		} else {
			power = 4;
		}
	}
}
