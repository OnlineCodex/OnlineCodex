package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORMeganobz extends Eintrag {

	AnzahlPanel Gargbosse;
	OptionsZaehlerGruppe GargbosseFK;

	public ORMeganobz() {

		grundkosten = 0;
		name = "Meganobz";
		
		add(Gargbosse = new AnzahlPanel(ID, randAbstand, cnt, "Meganobz", 3, 10, getPts("Meganobz") + getPts("Stikkbombs")));

		add(ico = new oc.Picture("oc/wh40k/images/Gargbosse.gif"));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Kustum Shoota + Klaw", getPts("Kustom Shoota") + getPts("Power Klaw")));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-rokkit + Klaw", getPts("Kombi-weapon with rokkit-launcha") + getPts("Power Klaw")));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-skorcha + Klaw", getPts("Kombi-weapon with skorcha") + getPts("Power Klaw")));
		ogE.addElement(new OptionsGruppeEintrag("Two killsaws", getPts("Two killsaws")));
		add(GargbosseFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, Gargbosse.getModelle()));
		GargbosseFK.setAnzahl(0, Gargbosse.getModelle());
		
		complete();

	}
	
	//@OVERRIDE
	public void refreshen() {
		GargbosseFK.setMaxAnzahl(Gargbosse.getModelle());
		GargbosseFK.setLegal(GargbosseFK.getAnzahl() == Gargbosse.getModelle());
		power = 1 + Gargbosse.getModelle() * 3;
	}
}
