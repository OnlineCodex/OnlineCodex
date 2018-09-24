package oc.wh40k.units.fo;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class FOImperialesVerteidigungsnetzwerk extends Eintrag {
	
	RuestkammerStarter impBast1;
	RuestkammerStarter impBast2;
	RuestkammerStarter impBast3;
	RuestkammerStarter impVL1;
	RuestkammerStarter impVL2;
	RuestkammerStarter impVL3;
	RuestkammerStarter impVS1;
	RuestkammerStarter impVS2;
	RuestkammerStarter impVS3;
	RuestkammerStarter impFA1;
	RuestkammerStarter impFA2;
	RuestkammerStarter impVW1;
	RuestkammerStarter impVW2;
	
	
	
	public FOImperialesVerteidigungsnetzwerk() {
		name = "Imperiales Verteidigungsnetzwerk";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/Aegis.jpg"));

		seperator();

		impBast1 = new RuestkammerStarter(ID, randAbstand, cnt, "FOImperialerBunkerKammer", "Imperialer Bunker",1);
		impBast1.initKammer();
		impBast1.setUeberschriftTrotzNullKostenAusgeben(true);
		add(impBast1);
		
		impBast2 = new RuestkammerStarter(ID, randAbstand, cnt, "FOImperialerBunkerKammer", "Imperialer Bunker",1);
		impBast2.initKammer();
		impBast2.setUeberschriftTrotzNullKostenAusgeben(true);
		add(impBast2);
		
		impBast3 = new RuestkammerStarter(ID, randAbstand, cnt, "FOImperialerBunkerKammer", "Imperialer Bunker",1);
		impBast3.initKammer();
		impBast3.setUeberschriftTrotzNullKostenAusgeben(true);
		add(impBast3);
		
		impVL1 = new RuestkammerStarter(ID, randAbstand, cnt, "FOImperialeVerteidigungslinieKammer", "Imperiale Verteidigungslinie",1);
		impVL1.initKammer();
		impVL1.setUeberschriftTrotzNullKostenAusgeben(true);
		add(impVL1);
		
		impVL2 = new RuestkammerStarter(ID, randAbstand, cnt, "FOImperialeVerteidigungslinieKammer", "Imperiale Verteidigungslinie",1);
		impVL2.initKammer();
		impVL2.setUeberschriftTrotzNullKostenAusgeben(true);
		add(impVL2);
		
		impVL3 = new RuestkammerStarter(ID, randAbstand, cnt, "FOImperialeVerteidigungslinieKammer", "Imperiale Verteidigungslinie",1);
		impVL3.initKammer();
		impVL3.setUeberschriftTrotzNullKostenAusgeben(true);
		add(impVL3);
		
		impVS1 = new RuestkammerStarter(ID, randAbstand, cnt, "FOImperialeVerteidigungsstellungKammer", "Imperiale Verteidigungsstellung",1);
		impVS1.initKammer();
		impVS1.setUeberschriftTrotzNullKostenAusgeben(true);
		add(impVS1);
		
		impVS2 = new RuestkammerStarter(ID, randAbstand, cnt, "FOImperialeVerteidigungsstellungKammer", "Imperiale Verteidigungsstellung",1);
		impVS2.initKammer();
		impVS2.setUeberschriftTrotzNullKostenAusgeben(true);
		add(impVS2);
		
		impVS3 = new RuestkammerStarter(ID, randAbstand, cnt, "FOImperialeVerteidigungsstellungKammer", "Imperiale Verteidigungsstellung",1);
		impVS3.initKammer();
		impVS3.setUeberschriftTrotzNullKostenAusgeben(true);
		add(impVS3);
		
		impFA1 = new RuestkammerStarter(ID, randAbstand, cnt, "FOFeuersturmAbwehrstellungKammer", "Feuersturm Abwehrstellung",1);
		impFA1.initKammer();
		impFA1.setUeberschriftTrotzNullKostenAusgeben(true);
		add(impFA1);
		
		impFA2 = new RuestkammerStarter(ID, randAbstand, cnt, "FOFeuersturmAbwehrstellungKammer", "Feuersturm Abwehrstellung",1);
		impFA2.initKammer();
		impFA2.setUeberschriftTrotzNullKostenAusgeben(true);
		add(impFA2);
		
		impVW1 = new RuestkammerStarter(ID, randAbstand, cnt, "FOVergelterWaffenbatterieKammer", "Vergelter Waffenbatterie",1);
		impVW1.initKammer();
		impVW1.setUeberschriftTrotzNullKostenAusgeben(true);
		add(impVW1);
		
		impVW2 = new RuestkammerStarter(ID, randAbstand, cnt, "FOVergelterWaffenbatterieKammer", "Vergelter Waffenbatterie",1);
		impVW2.initKammer();
		impVW2.setUeberschriftTrotzNullKostenAusgeben(true);
		add(impVW2);
		
		complete();
	}

	@Override
	public void refreshen() {
		impBast1.setAbwaehlbar(false);
		impVL1.setAbwaehlbar(false);
		impVS1.setAbwaehlbar(false);
	}
}