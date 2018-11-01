package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ORDeffDreads extends Eintrag {

	AnzahlPanel Gargbot;
	OptionsZaehlerGruppe GargbotFK;
	OptionsEinzelZaehler Grothälfaz;
	OptionsEinzelZaehler Panzaplattenz;
	
	RuestkammerStarter d1;
	RuestkammerStarter d2;
	RuestkammerStarter d3;

	public ORDeffDreads() {

		kategorie = 3;
		überschriftSetzen=true;
		grundkosten = 0;

		add(ico = new oc.Picture("oc/wh40k/images/Gargbot.gif"));

		d1 = new RuestkammerStarter(ID, randAbstand, cnt, "ORDeffDreadKammer", "", 1);
		d1.initKammer();
		d1.setButtonText("Deff Dread 1");
		add(d1);
		d1.setAbwaehlbar(false);

		seperator();

		d2 = new RuestkammerStarter(ID, randAbstand, cnt, "ORDeffDreadKammer", "", 1);
		d2.initKammer();
		d2.setButtonText("Deff Dread 2");
		add(d2);

		seperator();

		d3 = new RuestkammerStarter(ID, randAbstand, cnt, "ORDeffDreadKammer", "", 1);
		d3.initKammer();
		d3.setButtonText("Deff Dread 3");
		add(d3);

		complete();
	}

	//@OVERRIDE
	public void refreshen() {
		int selected = (d1.isSelected()?1:0) + (d2.isSelected()?1:0) + (d3.isSelected()?1:0);
		if(selected == 1) power = 5;
		if(selected == 2) power = 10;
		if(selected == 3) power = 16;
	}
}























