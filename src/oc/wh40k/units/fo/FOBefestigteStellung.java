package oc.wh40k.units.fo;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class FOBefestigteStellung extends Eintrag {
	
	RuestkammerStarter impBast1;
	RuestkammerStarter impBast2;
	RuestkammerStarter impBast3;
	RuestkammerStarter aegis1;
	RuestkammerStarter aegis2;
	RuestkammerStarter aegis3;
	RuestkammerStarter aegis4;
	RuestkammerStarter aegis5;
	RuestkammerStarter hischi;
	RuestkammerStarter erimp;
	
	public FOBefestigteStellung() {
		name = "Befestigte Stellung";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/Aegis.jpg"));

		seperator();

		impBast1 = new RuestkammerStarter(ID, randAbstand, cnt, "FOImperialeBastionKammer", "Imperiale Bastion",1);
		impBast1.initKammer();
		impBast1.setUeberschriftTrotzNullKostenAusgeben(true);
		add(impBast1);
		
		impBast2 = new RuestkammerStarter(ID, randAbstand, cnt, "FOImperialeBastionKammer", "Imperiale Bastion",1);
		impBast2.initKammer();
		impBast2.setUeberschriftTrotzNullKostenAusgeben(true);
		add(impBast2);
		
		impBast3 = new RuestkammerStarter(ID, randAbstand, cnt, "FOImperialeBastionKammer", "Imperiale Bastion",1);
		impBast3.initKammer();
		impBast3.setUeberschriftTrotzNullKostenAusgeben(true);
		add(impBast3);
		
		aegis1 = new RuestkammerStarter(ID, randAbstand, cnt, "FOAegisVerteidigungslinieKammer", "Aegis Verteidigungslinie",1);
		aegis1.initKammer();
		aegis1.setUeberschriftTrotzNullKostenAusgeben(true);
		add(aegis1);
		
		aegis2 = new RuestkammerStarter(ID, randAbstand, cnt, "FOAegisVerteidigungslinieKammer", "Aegis Verteidigungslinie",1);
		aegis2.initKammer();
		aegis2.setUeberschriftTrotzNullKostenAusgeben(true);
		add(aegis2);
		
		aegis3 = new RuestkammerStarter(ID, randAbstand, cnt, "FOAegisVerteidigungslinieKammer", "Aegis Verteidigungslinie",1);
		aegis3.initKammer();
		aegis3.setUeberschriftTrotzNullKostenAusgeben(true);
		add(aegis3);
		
		aegis4 = new RuestkammerStarter(ID, randAbstand, cnt, "FOAegisVerteidigungslinieKammer", "Aegis Verteidigungslinie",1);
		aegis4.initKammer();
		aegis4.setUeberschriftTrotzNullKostenAusgeben(true);
		add(aegis4);
		
		aegis5 = new RuestkammerStarter(ID, randAbstand, cnt, "FOAegisVerteidigungslinieKammer", "Aegis Verteidigungslinie",1);
		aegis5.initKammer();
		aegis5.setUeberschriftTrotzNullKostenAusgeben(true);
		add(aegis5);
		
		hischi = new RuestkammerStarter(ID, randAbstand, cnt, "FOHimmelsschildLandeplattformKammer", "Himmelsschild Landeplattform",1);
		hischi.initKammer();
		hischi.setUeberschriftTrotzNullKostenAusgeben(true);
		add(hischi);
		
		erimp = new RuestkammerStarter(ID, randAbstand, cnt, "FOEhrwuerdigesImperium1Kammer", "Ehrwürdiges Imperium 1",1);
		erimp.initKammer();
		erimp.setUeberschriftTrotzNullKostenAusgeben(true);
		add(erimp);
		
		complete();
	}

	@Override
	public void refreshen() {
		impBast1.setAbwaehlbar(false);
		aegis1.setAbwaehlbar(false);
	}
}