package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORDeffDreads extends Eintrag {

	AnzahlPanel Gargbot;
	OptionsZaehlerGruppe GargbotFK;
	OptionsEinzelZaehler Grothälfaz;
	OptionsEinzelZaehler Panzaplattenz;

	public ORDeffDreads() {

		kategorie = 3;
		überschriftSetzen=true;
		grundkosten = 0;

		add(Gargbot = new AnzahlPanel(ID, randAbstand, cnt, "Deff Dread", "Deff Dreads", 1, 3, getPts("Deff Dreads") + getPts("Dread klaw") + getPts("each subsequent dread klaw")));

		add(ico = new oc.Picture("oc/wh40k/images/Gargbot.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Big shoota", getPts("Big shoota")));
		ogE.addElement(new OptionsGruppeEintrag("Rokkit launcha", getPts("Rokkit launcha")));
		ogE.addElement(new OptionsGruppeEintrag("Skorcha", getPts("skorcha")));
		ogE.addElement(new OptionsGruppeEintrag("Kustom mega-blasta", getPts("kustom mega-blasta")));
		ogE.addElement(new OptionsGruppeEintrag("Dread klaw", getPts("each subsequent dread klaw")));
		GargbotFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2);
		add(GargbotFK);
		seperator(15);

		complete();

	}

	//@OVERRIDE
	public void refreshen() {
		GargbotFK.setMaxAnzahl(Gargbot.getModelle()*2);
		GargbotFK.setLegal(Gargbot.getModelle()*2 == GargbotFK.getAnzahl());
		power = 1 + Gargbot.getModelle()* 7;
	}
}























