package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORNobzonWarbikes extends Eintrag {

	AnzahlPanel Bosse;
	OptionsZaehlerGruppe BosseCC;
	OptionsZaehlerGruppe BosseCCx;
	OptionsZaehlerGruppe BosseFK;
	OptionsEinzelZaehler stikk;

	public ORNobzonWarbikes() {
		kategorie = 2;
		grundkosten = 0;

		Bosse = new AnzahlPanel(ID, randAbstand, cnt, "Nobz", 3, 9, getPts("Nobz on Warbikes") + getPts("Stikkbombs"));
		add(Bosse);

		add(ico = new oc.Picture("oc/wh40k/images/Bosse.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Choppa", getPts("Choppa")));
		add(BosseCCx = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Big choppa", getPts("Big choppa")));
		ogE.addElement(new OptionsGruppeEintrag("Killsaw", getPts("Killsaw")));
		ogE.addElement(new OptionsGruppeEintrag("Power klaw", getPts("Power klaw")));
		ogE.addElement(new OptionsGruppeEintrag("Power stabba", getPts("Power stabba")));
		ogE.addElement(new OptionsGruppeEintrag("Slugga", getPts("Slugga")));
		add(BosseCC = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Slugga", getPts("Slugga")));
		ogE.addElement(new OptionsGruppeEintrag("Big choppa", getPts("Big choppa")));
		ogE.addElement(new OptionsGruppeEintrag("Killsaw", getPts("Killsaw")));
		ogE.addElement(new OptionsGruppeEintrag("Power klaw", getPts("Power klaw")));
		ogE.addElement(new OptionsGruppeEintrag("Power stabba", getPts("Power stabba")));
		ogE.addElement(new OptionsGruppeEintrag("Choppa", getPts("Choppa")));
        add(BosseFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
        
		add(stikk = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Stikkbombs", Bosse.getModelle(), getPts("Stikkbombs")));
		
		complete();
	}
	
	//@OVERRIDE
	public void refreshen() {
		BosseFK.setMaxAnzahl(Bosse.getModelle());
		
		BosseCCx.setMaxAnzahl(Bosse.getModelle()-BosseCC.getAnzahl());
		BosseCCx.setAnzahl(0, Bosse.getModelle()-BosseCC.getAnzahl());
		BosseCC.setMaxAnzahl(Bosse.getModelle());
		
		stikk.setMaxAnzahl(Bosse.getModelle());
		
		if(Bosse.getModelle()>6){
			power = 19;
		} else if(Bosse.getModelle()>3){
			power = 14;
		} else {
			power = 7;
		}
		
	}

}
