package oc.wh40k.units.fo;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class FODeflektorRelaisnetzwerk extends Eintrag {
	
	RuestkammerStarter relais1;
	RuestkammerStarter relais2;
	RuestkammerStarter relais3;
	RuestkammerStarter schild1;
	RuestkammerStarter schild2;
	RuestkammerStarter schild3;
	RuestkammerStarter erimp;

	/*
	1-3 Promethium-Relaisleitungen
	1-3 Deflektorschildgeneratoren
	0-1 Ehrwürdiges Imperium
	 */
	
	public FODeflektorRelaisnetzwerk() {
		name = "Deflektor-Relaisnetzwerk";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/Aegis.jpg"));

		seperator();

		relais1 = new RuestkammerStarter(ID, randAbstand, cnt, "FOPromethiumRelaisleitungenKammer", "Promethium-Relaisleitungen");
		relais1.initKammer(true);
		relais1.setUeberschriftTrotzNullKostenAusgeben(true);
		add(relais1);
		
		relais2 = new RuestkammerStarter(ID, randAbstand, cnt, "FOPromethiumRelaisleitungenKammer", "Promethium-Relaisleitungen");
		relais2.initKammer();
		relais2.setUeberschriftTrotzNullKostenAusgeben(true);
		add(relais2);
		
		relais3 = new RuestkammerStarter(ID, randAbstand, cnt, "FOPromethiumRelaisleitungenKammer", "Promethium-Relaisleitungen");
		relais3.initKammer(false);
		relais3.setUeberschriftTrotzNullKostenAusgeben(true);
		add(relais3);
		
		schild1 = new RuestkammerStarter(ID, randAbstand, cnt, "FODeflektorschildgeneratorKammer", "Deflektorschildgenerator");
		schild1.initKammer(true);
		schild1.setUeberschriftTrotzNullKostenAusgeben(true);
		add(schild1);
		
		schild2 = new RuestkammerStarter(ID, randAbstand, cnt, "FODeflektorschildgeneratorKammer", "Deflektorschildgenerator");
		schild2.initKammer();
		schild2.setUeberschriftTrotzNullKostenAusgeben(true);
		add(schild2);
		
		schild3 = new RuestkammerStarter(ID, randAbstand, cnt, "FODeflektorschildgeneratorKammer", "Deflektorschildgenerator");
		schild3.initKammer(false);
		schild3.setUeberschriftTrotzNullKostenAusgeben(true);
		add(schild3);
		
		erimp = new RuestkammerStarter(ID, randAbstand, cnt, "FOEhrwuerdigesImperium1Kammer", "Ehrwürdiges Imperium 1");
		erimp.initKammer();
		erimp.setUeberschriftTrotzNullKostenAusgeben(true);
		add(erimp);
		
		complete();
	}

	@Override
	public void refreshen() {
		relais1.setAbwaehlbar(false);
		schild1.setAbwaehlbar(false);
	}
}