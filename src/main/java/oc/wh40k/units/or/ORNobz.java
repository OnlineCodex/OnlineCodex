package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORNobz extends Eintrag {

	AnzahlPanel bosse;
	OptionsZaehlerGruppe bosseCC;
	OptionsZaehlerGruppe bosseCCx;
	OptionsZaehlerGruppe bosseFK;
	OptionsZaehlerGruppe bosseFKx;
	OptionsZaehlerGruppe bosse2H;
	OptionsEinzelZaehler munigrotz;
	OptionsEinzelZaehler cyborg;

	public ORNobz() {
		kategorie = 2;
		grundkosten = 0;

		bosse = new AnzahlPanel(ID, randAbstand, cnt, "Nobz", 5, 10, getPts("Nobz") + getPts("Stikkbombs"));
		add(bosse);

		add(ico = new oc.Picture("oc/wh40k/images/Bosse.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Choppa", getPts("Choppa")));
		add(bosseCCx = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Big choppa", getPts("Big choppa")));
		ogE.addElement(new OptionsGruppeEintrag("Killsaw", getPts("Killsaw")));
		ogE.addElement(new OptionsGruppeEintrag("Power klaw", getPts("Power klaw")));
		ogE.addElement(new OptionsGruppeEintrag("Power stabba", getPts("Power stabba")));
		ogE.addElement(new OptionsGruppeEintrag("Slugga", getPts("Slugga")));
		add(bosseCC = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Slugga", getPts("Slugga")));
		add(bosseFKx = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Big choppa", getPts("Big choppa")));
		ogE.addElement(new OptionsGruppeEintrag("Killsaw", getPts("Killsaw")));
		ogE.addElement(new OptionsGruppeEintrag("Power klaw", getPts("Power klaw")));
		ogE.addElement(new OptionsGruppeEintrag("Power stabba", getPts("Power stabba")));
		ogE.addElement(new OptionsGruppeEintrag("Choppa", getPts("Choppa")));
        add(bosseFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
		
        ogE.addElement(new OptionsGruppeEintrag("Kombi-rokkit","Kombi-weapon with rokkit-launcha", getPts("Kombi-weapon with rokkit-launcha")));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-skorcha", "Kombi-weapon with skorcha", getPts("Kombi-weapon with skorcha")));
        add(bosse2H = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
		
		add(munigrotz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Ammo Runt", bosse.getModelle(), getPts("Ammo Runt")));
		add(cyborg = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Cybork body", bosse.getModelle()/5, getPts("Cybork body")));

		complete();
	}
	
	//@OVERRIDE
	public void refreshen() {
		bosseFKx.setMaxAnzahl(bosse.getModelle()-bosseFK.getAnzahl() - bosse2H.getAnzahl());
		bosseFKx.setAnzahl(0, bosse.getModelle()-bosseFK.getAnzahl() - bosse2H.getAnzahl());
		bosseFK.setMaxAnzahl(bosse.getModelle()-bosse2H.getAnzahl());
		
		bosseCCx.setMaxAnzahl(bosse.getModelle()-bosseCC.getAnzahl() - bosse2H.getAnzahl());
		bosseCCx.setAnzahl(0, bosse.getModelle()-bosseCC.getAnzahl() - bosse2H.getAnzahl());
		bosseCC.setMaxAnzahl(bosse.getModelle()-bosse2H.getAnzahl());
		
		bosse2H.setMaxAnzahl(bosse.getModelle());
		
		munigrotz.setMaxAnzahl(bosse.getModelle()/5);
		
		cyborg.setMaxAnzahl(bosse.getModelle()/5);
		
		if(bosse.getModelle()>5){
			power = 14;
		} else {
			power = 7;
		}
	}

}
