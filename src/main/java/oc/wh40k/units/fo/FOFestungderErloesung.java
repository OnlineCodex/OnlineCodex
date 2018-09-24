package oc.wh40k.units.fo;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerStarter;

public class FOFestungderErloesung extends Eintrag {
	
	RuestkammerStarter hauptGeb;
	RuestkammerStarter hauptHind;
	RuestkammerStarter bunker1Geb;
	RuestkammerStarter bunker1Hind;
	RuestkammerStarter bunker2Geb;
	RuestkammerStarter bunker2Hind;
	RuestkammerStarter verbGeb;
	RuestkammerStarter verbHind;

	public FOFestungderErloesung() {
		name = "Festung der Erlösung";
		grundkosten = 220;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/Festung.jpg"));

		seperator();
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Waffenfernsteuerung",10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sprengsturm-Raketen",30));
		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Schwere Bolter",4,10));
		
		hauptGeb = new RuestkammerStarter(ID, randAbstand, cnt, "FOGebaeude", "Hauptturm: Gebäude");
		hauptGeb.initKammer(true);
		hauptGeb.setUeberschriftTrotzNullKostenAusgeben(true);
		add(hauptGeb);
		
		hauptHind = new RuestkammerStarter(ID, randAbstand, cnt, "FOHindernisse", "Hauptturm: Hindernisse");
		hauptHind.initKammer();
		hauptGeb.setUeberschriftTrotzNullKostenAusgeben(true);
		add(hauptHind);
		
		bunker1Geb = new RuestkammerStarter(ID, randAbstand, cnt, "FOGebaeude", "Bunker1: Gebäude");//Mit nur einer Auswahl
		bunker1Geb.initKammer(false);
		hauptGeb.setUeberschriftTrotzNullKostenAusgeben(true);
		add(bunker1Geb);
		
		bunker1Hind = new RuestkammerStarter(ID, randAbstand, cnt, "FOHindernisse", "Bunker1: Hindernisse");
		bunker1Hind.initKammer();
		hauptGeb.setUeberschriftTrotzNullKostenAusgeben(true);
		add(bunker1Hind);
		
		bunker2Geb = new RuestkammerStarter(ID, randAbstand, cnt, "FOGebaeude", "Bunker2: Gebäude");//Mit nur einer Auswahl
		bunker2Geb.initKammer(false);
		hauptGeb.setUeberschriftTrotzNullKostenAusgeben(true);
		add(bunker2Geb);
		
		bunker2Hind = new RuestkammerStarter(ID, randAbstand, cnt, "FOHindernisse", "Bunker2: Hindernisse");
		bunker2Hind.initKammer();
		hauptGeb.setUeberschriftTrotzNullKostenAusgeben(true);
		add(bunker2Hind);
		
		verbGeb = new RuestkammerStarter(ID, randAbstand, cnt, "FOGebaeude", "Verbindungskorridor: Gebäude");//Mit nur einer Auswahl
		verbGeb.initKammer(false);
		hauptGeb.setUeberschriftTrotzNullKostenAusgeben(true);
		add(verbGeb);
		
		verbHind = new RuestkammerStarter(ID, randAbstand, cnt, "FOHindernisse", "Verbindungskorridor: Hindernisse");
		verbHind.initKammer();
		hauptGeb.setUeberschriftTrotzNullKostenAusgeben(true);
		add(verbHind);
		
		complete();
	}

	@Override
	public void refreshen() {
	}
}