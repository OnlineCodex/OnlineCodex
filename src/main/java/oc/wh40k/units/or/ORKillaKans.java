package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORKillaKans extends Eintrag {

	AnzahlPanel Killabot;
	OptionsZaehlerGruppe KillabotFK;

	public ORKillaKans() {

		kategorie = 5;
		grundkosten = 0;
		Killabot = new AnzahlPanel(ID, randAbstand, cnt, "Killa Kan", "Killa Kans", 1, 6, getPts("Killa kans")+ getPts("Kan klaw"));
		add(Killabot);

		add(ico = new oc.Picture("oc/wh40k/images/Killabot.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Big shoota", getPts("Big shoota")));
		ogE.addElement(new OptionsGruppeEintrag("Rokkit launcha", getPts("Rokkit launcha")));
		ogE.addElement(new OptionsGruppeEintrag("Skorcha", getPts("skorcha")));
		ogE.addElement(new OptionsGruppeEintrag("Kustom mega-blasta", getPts("kustom mega-blasta")));
		ogE.addElement(new OptionsGruppeEintrag("Grotzooka", getPts("Grotzooka")));
		KillabotFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);
		add(KillabotFK);

		complete();

	}

	//@OVERRIDE
	public void refreshen() {
		KillabotFK.setMaxAnzahl(Killabot.getModelle());
		KillabotFK.setLegal(Killabot.getModelle() == KillabotFK.getAnzahl());
		if(Killabot.getModelle() > 3){
			power = 19;
		} else if(Killabot.getModelle() > 1){
			power = 10;
		} else {
			power = 4;
		}
	}
}
