package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ORKommandos extends Eintrag {

	AnzahlPanel Kommandoz;
	OptionsZaehlerGruppe KommandozFK;
	RuestkammerStarter Boss;

	public ORKommandos() {
		kategorie = 2;
		grundkosten = 0;

		Kommandoz = new AnzahlPanel(ID, randAbstand, cnt, "Kommandos", 5, 15, getPts("Kommandos"));
		add(Kommandoz);

		add(ico = new oc.Picture("oc/wh40k/images/Kommandoz.gif"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Big shoota", getPts("Big shoota")));
		ogE.addElement(new OptionsGruppeEintrag("Burna", getPts("Burna")));
		ogE.addElement(new OptionsGruppeEintrag("Rokkit launcha", getPts("Rokkit launcha")));
		add(KommandozFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		Boss = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "Boss Nob");
		Boss.initKammer(true,false,false,false,false);
		Boss.setGrundkosten(getPts("Boss Nob"));
		Boss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(Boss);
		Boss.setAbwaehlbar(false);
		
		complete();
	}
	
	//@OVERRIDE
	public void refreshen() {
		Boss.setAbwaehlbar(true);
		power = 2 + Kommandoz.getModelle()/5*2;
	}

}
