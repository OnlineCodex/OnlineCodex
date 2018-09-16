package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORNobzonWarbikes extends Eintrag {

	AnzahlPanel Bosse;
	OptionsZaehlerGruppe BosseCC;
	OptionsZaehlerGruppe BosseCCx;
	OptionsZaehlerGruppe BosseFK;
	OptionsZaehlerGruppe BosseFKx;

	public ORNobzonWarbikes() {
		kategorie = 2;
		grundkosten = 0;

		Bosse = new AnzahlPanel(ID, randAbstand, cnt, "Nobz", 3, 10, getPts("Nobz on Warbikes") + getPts("Stikkbombs"));
		add(Bosse);

		add(ico = new oc.Picture("oc/wh40k/images/Bosse.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Choppa", getPts("Choppa")));
		add(BosseCCx = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Power klaw", getPts("Power klaw")));
		ogE.addElement(new OptionsGruppeEintrag("Big choppa", getPts("Big choppa")));
		add(BosseCC = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Slugga", getPts("Slugga")));
		add(BosseFKx = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Shoota", getPts("Shoota")));
    	ogE.addElement(new OptionsGruppeEintrag("Kustom shoota", getPts("Kustom shoota")));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-rokkit","Kombi-weapon with rokkit-launcha", getPts("Kombi-weapon with rokkit-launcha")));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-skorcha", "Kombi-weapon with skorcha", getPts("Kombi-weapon with skorcha")));
        add(BosseFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		complete();
	}
	
	//@OVERRIDE
	public void refreshen() {
		BosseFKx.setMaxAnzahl(Bosse.getModelle()-BosseFK.getAnzahl());
		BosseFKx.setAnzahl(0, Bosse.getModelle()-BosseFK.getAnzahl());
		BosseFK.setMaxAnzahl(Bosse.getModelle());
		
		BosseCCx.setMaxAnzahl(Bosse.getModelle()-BosseCC.getAnzahl());
		BosseCCx.setAnzahl(0, Bosse.getModelle()-BosseCC.getAnzahl());
		BosseCC.setMaxAnzahl(Bosse.getModelle());
		
		if(Bosse.getModelle()>6){
			power = 28;
		} else if(Bosse.getModelle()>3){
			power = 19;
		} else {
			power = 10;
		}
		
	}

}
