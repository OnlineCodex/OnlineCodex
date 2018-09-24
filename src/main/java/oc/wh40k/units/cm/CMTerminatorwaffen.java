package oc.wh40k.units.cm;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class CMTerminatorwaffen extends RuestkammerVater {

	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsUpgradeGruppe o3;

	OptionsEinzelUpgrade blade;
	OptionsEinzelUpgrade horns;
	OptionsEinzelUpgrade balestar;
	OptionsEinzelUpgrade daemonheart;
	OptionsEinzelUpgrade prophet;

	OptionsEinzelUpgrade schriftrollen, handwaffe, kombibolter;
	OptionsEinzelUpgrade dimensionsschlüssel;

	OptionsEinzelUpgrade spineshiver;
	OptionsEinzelUpgrade crucible;
	OptionsEinzelUpgrade memory;
	OptionsEinzelUpgrade eye;
	OptionsEinzelUpgrade skull;
	OptionsEinzelUpgrade hand;

	boolean bladeBool=false;
	boolean hornsBool=false;
	boolean balestarBool=false;
	boolean daemonheartBool=false;
	boolean prophetBool=false;
	boolean fackelBool=false;
	boolean axtBool=false;
	boolean schwertBool=false;
	boolean kolbenBool=false;
	boolean schluesselBool=false;
	boolean rolleBool=false;
	boolean spineshiverBool=false;
	boolean crucibleBool=false;
	boolean memoryBool=false;
	boolean eyeBool=false;
	boolean skullBool=false;
	boolean handBool=false;
	boolean uniqueError=false;

	boolean malDesKhorne = false;
	boolean malDesTzeentch = false;

	boolean isChaosgeneral = false; //Handwaffe, Kombibolter 
	boolean isHexer = false;        //Psiwaffe, Kombibolter

	boolean isBlackLegion = false;
	boolean isCrimsonSlaughter = false;

	public CMTerminatorwaffen() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		try {
			isChaosgeneral = defaults[1]; 
			isHexer = defaults[2];            
		} catch(Exception e) {}

		if(defaults[0]){
			//Termichamp
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Geschenk der Mutation", 10));
		}

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kombibolter"), 0));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kombi-Flammenwerfer"), 7));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kombi-Melter"), 7));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kombi-Plasmawerfer"), 7));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiewaffe"), 12));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieschwert"), 12));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieaxt"), 12));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energielanze"), 12));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiestreitkolben"), 12));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieklaue"), 17));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiefaust"), 22));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kettenfaust"), 27));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		o1.setAnzahl(0, 1);

		seperator();

		if(isHexer) {
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Psiwaffe"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Psischwert"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Psiaxt"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Psistab"), 0));
		} else{
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiewaffe"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieschwert"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieaxt"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energielanze"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiestreitkolben"), 0));
		}
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieklaue"), 5));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiefaust"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kettenfaust"), 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		o2.setAnzahl(0, 1);
		sizeSetzen();

		seperator();

		if(isChaosgeneral || isHexer){
			ogE.addElement(new OptionsGruppeEintrag("Brandfackel von Skalathrax", 30));
			ogE.addElement(new OptionsGruppeEintrag("Axt der blinden Wut", 35));
			ogE.addElement(new OptionsGruppeEintrag("Das Mordschwert", 35));
			ogE.addElement(new OptionsGruppeEintrag("Der schwarze Streitkolben", 45));
			add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

			seperator();

			add(dimensionsschlüssel = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dimensionsschlüssel", 25));
			add(schriftrollen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schriftrollen des Magnus", 45));

			cnt=randAbstand;

			//BL
			add(spineshiver = new OptionsEinzelUpgrade(ID, randAbstand +280, cnt, "",BuildaHQ.translate("The Spineshiver Blade"), 30));
			add(crucible = new OptionsEinzelUpgrade(ID, randAbstand +280, cnt, "",BuildaHQ.translate("The Crucible of Lies"), 25));
			add(memory = new OptionsEinzelUpgrade(ID, randAbstand +280, cnt, "",BuildaHQ.translate("Last Memory of the Yuranthos"), 30));
			add(eye = new OptionsEinzelUpgrade(ID, randAbstand +280, cnt, "",BuildaHQ.translate("The Eye of Night"), 75));
			add(skull = new OptionsEinzelUpgrade(ID, randAbstand +280, cnt, "",BuildaHQ.translate("The Skull of Ker'ngar"), 40));
			add(hand = new OptionsEinzelUpgrade(ID, randAbstand +280, cnt, "",BuildaHQ.translate("The Hand of Darkness"), 50));

			seperator();

			//CS
			add(blade = new OptionsEinzelUpgrade(ID, randAbstand +280, cnt, "", BuildaHQ.translate("Blade of the Relentless"), 30));
			blade.setAktiv(false);
			add(horns = new OptionsEinzelUpgrade(ID, randAbstand +280, cnt, "", BuildaHQ.translate("The Slaughterers Horns"), 15));
			add(balestar = new OptionsEinzelUpgrade(ID, randAbstand +280, cnt, "", BuildaHQ.translate("The Balestar of Mannon"), 25));
			balestar.setAktiv(false);
			add(daemonheart = new OptionsEinzelUpgrade(ID, randAbstand +280, cnt, "", BuildaHQ.translate("Daemonheart"), 30));
			add(prophet = new OptionsEinzelUpgrade(ID, randAbstand +280, cnt, "", BuildaHQ.translate("Prophet of Voices"), 30));
		}


		setUeberschrift("Termiwaffen und Artefakte");
		sizeSetzen();
	}

	@Override
	public void refreshen() {	
		
		isCrimsonSlaughter=getCountFromInformationVector("CrimsonSlaughter")>0;
		
		if(isChaosgeneral || isHexer) {
			if(isBlackLegion){
				o3.setAktiv("Brandfackel von Skalathrax", !o1.isSelected() || !o2.isSelected());
				o3.setAktiv("Axt der blinden Wut", malDesKhorne && (!o1.isSelected() || !o2.isSelected()));
				o3.setAktiv("Das Mordschwert", (!o1.isSelected() || !o2.isSelected()));
				o3.setAktiv("Der schwarze Streitkolben", (!o1.isSelected() || !o2.isSelected()));
				dimensionsschlüssel.setAktiv(true);
				schriftrollen.setAktiv(malDesTzeentch);
				//BL
				spineshiver.setAktiv(true);
				crucible.setAktiv(true);
				memory.setAktiv(true);
				eye.setAktiv(true);
				skull.setAktiv(true);
				hand.setAktiv(true);
				//CS
				blade.setAktiv(false);
				balestar.setAktiv(false);
				daemonheart.setAktiv(false);
				horns.setAktiv(false);
				prophet.setAktiv(false);
			}else if(isCrimsonSlaughter){
				o3.setAktiv("Brandfackel von Skalathrax", (!o1.isSelected() || !o2.isSelected()));
				o3.setAktiv("Axt der blinden Wut", malDesKhorne && (!o1.isSelected() || !o2.isSelected()));
				o3.setAktiv("Das Mordschwert", (!o1.isSelected() || !o2.isSelected()));
				o3.setAktiv("Der schwarze Streitkolben", (!o1.isSelected() || !o2.isSelected()));
				dimensionsschlüssel.setAktiv(true);
				schriftrollen.setAktiv(malDesTzeentch);
				//BL
				spineshiver.setAktiv(false);
				crucible.setAktiv(false);
				memory.setAktiv(false);
				eye.setAktiv(false);
				skull.setAktiv(false);
				hand.setAktiv(false);
				//CS
				horns.setAktiv(true);
				prophet.setAktiv(true);
				blade.setAktiv(isChaosgeneral);
				balestar.setAktiv(isHexer);
				daemonheart.setAktiv(true);
			}else{
				o3.setAktiv("Brandfackel von Skalathrax", (!o1.isSelected() || !o2.isSelected()));
				o3.setAktiv("Axt der blinden Wut", malDesKhorne && (!o1.isSelected() || !o2.isSelected()));
				o3.setAktiv("Das Mordschwert", (!o1.isSelected() || !o2.isSelected()));
				o3.setAktiv("Der schwarze Streitkolben", (!o1.isSelected() || !o2.isSelected()));
				dimensionsschlüssel.setAktiv(true);
				schriftrollen.setAktiv(malDesTzeentch);
				//BL
				spineshiver.setAktiv(false);
				crucible.setAktiv(false);
				memory.setAktiv(false);
				eye.setAktiv(false);
				skull.setAktiv(false);
				hand.setAktiv(false);
				//CS
				blade.setAktiv(false);
				balestar.setAktiv(false);
				daemonheart.setAktiv(false);
				horns.setAktiv(false);
				prophet.setAktiv(false);
			}
		}
		int auswahlen=o1.getAnzahl()+o2.getAnzahl();
		if(o3!=null){
			auswahlen+=o3.getAnzahl();
			o3.setLegal(auswahlen>=2);
		}
		o1.setLegal(auswahlen>=2);
		o2.setLegal(auswahlen>=2);

		//Einzigartige Gegenstände
		if(isChaosgeneral || isHexer){
			if(o3.isSelected("Brandfackel von Skalathrax")){
				if(fackelBool==false){
					fackelBool=true;
					BuildaHQ.addToInformationVectorGlobal("CMFackel", 1);
				}
			} else if(!o3.isSelected("Brandfackel von Skalathrax")) {
				if(fackelBool==true){
					fackelBool=false;
					BuildaHQ.addToInformationVectorGlobal("CMFackel", -1);
				}
			}

			if(o3.isSelected("Axt der blinden Wut")){
				if(axtBool==false){
					axtBool=true;
					BuildaHQ.addToInformationVectorGlobal("CMAxt", 1);
				}
			} else if(!o3.isSelected("Axt der blinden Wut")) {
				if(axtBool==true){
					axtBool=false;
					BuildaHQ.addToInformationVectorGlobal("CMAxt", -1);
				}
			}

			if(o3.isSelected("Das Mordschwert")){
				if(schwertBool==false){
					schwertBool=true;
					BuildaHQ.addToInformationVectorGlobal("CMSchwert", 1);
				}
			} else if(!o3.isSelected("Das Mordschwert")) {
				if(schwertBool==true){
					schwertBool=false;
					BuildaHQ.addToInformationVectorGlobal("CMSchwert", -1);
				}
			}

			if(o3.isSelected("Der schwarze Streikolben")){
				if(kolbenBool==false){
					kolbenBool=true;
					BuildaHQ.addToInformationVectorGlobal("CMKolben", 1);
				}
			} else if(!o3.isSelected("Der schwarze Streikolben")) {
				if(kolbenBool==true){
					kolbenBool=false;
					BuildaHQ.addToInformationVectorGlobal("CMKolben", -1);
				}
			}

			if((isChaosgeneral || isHexer) && dimensionsschlüssel.isSelected()){
				if(schluesselBool==false){
					schluesselBool=true;
					BuildaHQ.addToInformationVectorGlobal("CMSchluessel", 1);
				}
			} else if((isChaosgeneral || isHexer) && !dimensionsschlüssel.isSelected()) {
				if(schluesselBool==true){
					schluesselBool=false;
					BuildaHQ.addToInformationVectorGlobal("CMSchluessel", -1);
				}
			}

			if((isChaosgeneral || isHexer) && schriftrollen.isSelected()){
				if(rolleBool==false){
					rolleBool=true;
					BuildaHQ.addToInformationVectorGlobal("CMRolle", 1);
				}
			} else if((isChaosgeneral || isHexer) && !schriftrollen.isSelected()) {
				if(rolleBool==true){
					rolleBool=false;
					BuildaHQ.addToInformationVectorGlobal("CMRolle", -1);
				}
			}
			//BL
			if(spineshiver.isSelected()){
				if(spineshiverBool==false){
					spineshiverBool=true;
					BuildaHQ.addToInformationVectorGlobal("BLSpineshiver", 1);
				}
			} else if(!spineshiver.isSelected()) {
				if(spineshiverBool==true){
					spineshiverBool=false;
					BuildaHQ.addToInformationVectorGlobal("BLSpineshiver", -1);
				}
			}
			
			if(crucible.isSelected()){
				if(crucibleBool==false){
					crucibleBool=true;
					BuildaHQ.addToInformationVectorGlobal("BLCrucible", 1);
				}
			} else if(!crucible.isSelected()) {
				if(crucibleBool==true){
					crucibleBool=false;
					BuildaHQ.addToInformationVectorGlobal("BLCrucible", -1);
				}
			}
			
			if(memory.isSelected()){
				if(memoryBool==false){
					memoryBool=true;
					BuildaHQ.addToInformationVectorGlobal("BLMemory", 1);
				}
			} else if(!memory.isSelected()) {
				if(memoryBool==true){
					memoryBool=false;
					BuildaHQ.addToInformationVectorGlobal("BLMemory", -1);
				}
			}

			if(eye.isSelected()){
				if(eyeBool==false){
					eyeBool=true;
					BuildaHQ.addToInformationVectorGlobal("BLEye", 1);
				}
			} else if(!eye.isSelected()) {
				if(eyeBool==true){
					eyeBool=false;
					BuildaHQ.addToInformationVectorGlobal("BLEye", -1);
				}
			}

			if(skull.isSelected()){
				if(skullBool==false){
					skullBool=true;
					BuildaHQ.addToInformationVectorGlobal("BLSkull", 1);
				}
			} else if(!skull.isSelected()) {
				if(skullBool==true){
					skullBool=false;
					BuildaHQ.addToInformationVectorGlobal("BLSkull", -1);
				}
			}
			
			if(hand.isSelected()){
				if(handBool==false){
					handBool=true;
					BuildaHQ.addToInformationVectorGlobal("BLHand", 1);
				}
			} else if(!hand.isSelected()) {
				if(handBool==true){
					handBool=false;
					BuildaHQ.addToInformationVectorGlobal("BLHand", -1);
				}
			}
			
			//CS
			
			if(blade.isSelected()){
				if(bladeBool==false){
					bladeBool=true;
					BuildaHQ.addToInformationVectorGlobal("CSBlade", 1);
				}
			} else if(!blade.isSelected()) {
				if(bladeBool==true){
					bladeBool=false;
					BuildaHQ.addToInformationVectorGlobal("CSBlade", -1);
				}
			}
			
			if(horns.isSelected()){
				if(hornsBool==false){
					hornsBool=true;
					BuildaHQ.addToInformationVectorGlobal("CSHorns", 1);
				}
			} else if(!horns.isSelected()) {
				if(hornsBool==true){
					hornsBool=false;
					BuildaHQ.addToInformationVectorGlobal("CSHorns", -1);
				}
			}
			
			if(balestar.isSelected()){
				if(balestarBool==false){
					balestarBool=true;
					BuildaHQ.addToInformationVectorGlobal("CSBalestar", 1);
				}
			} else if(!balestar.isSelected()) {
				if(balestarBool==true){
					balestarBool=false;
					BuildaHQ.addToInformationVectorGlobal("CSBalestar", -1);
				}
			}
			
			if(daemonheart.isSelected()){
				if(daemonheartBool==false){
					daemonheartBool=true;
					BuildaHQ.addToInformationVectorGlobal("CSDaemonheart", 1);
				}
			} else if(!daemonheart.isSelected()) {
				if(daemonheartBool==true){
					daemonheartBool=false;
					BuildaHQ.addToInformationVectorGlobal("CSDaemonheart", -1);
				}
			}
			
			if(prophet.isSelected()){
				if(prophetBool==false){
					prophetBool=true;
					BuildaHQ.addToInformationVectorGlobal("CSProphet", 1);
				}
			} else if(!prophet.isSelected()) {
				if(prophetBool==true){
					prophetBool=false;
					BuildaHQ.addToInformationVectorGlobal("CSProphet", -1);
				}
			}

			if(BuildaHQ.getCountFromInformationVectorGlobal("CMFackel")>1 ||
					BuildaHQ.getCountFromInformationVectorGlobal("CMAxt")>1 ||
					BuildaHQ.getCountFromInformationVectorGlobal("CMSchwert")>1 ||
					BuildaHQ.getCountFromInformationVectorGlobal("CMKolben")>1 ||
					BuildaHQ.getCountFromInformationVectorGlobal("CMSchluessel")>1 ||
					BuildaHQ.getCountFromInformationVectorGlobal("CMRolle")>1 ||
					BuildaHQ.getCountFromInformationVectorGlobal("BLSpineshiver")>1 ||
					BuildaHQ.getCountFromInformationVectorGlobal("BLCrucible")>1 ||
					BuildaHQ.getCountFromInformationVectorGlobal("BLMemory")>1 ||
					BuildaHQ.getCountFromInformationVectorGlobal("BLEye")>1 ||
					BuildaHQ.getCountFromInformationVectorGlobal("BLSkull")>1 ||
					BuildaHQ.getCountFromInformationVectorGlobal("BLHand")>1 ||
					BuildaHQ.getCountFromInformationVectorGlobal("CSBlade")>1 ||
					BuildaHQ.getCountFromInformationVectorGlobal("CSHorns")>1 ||
					BuildaHQ.getCountFromInformationVectorGlobal("CSBalestar")>1 ||
					BuildaHQ.getCountFromInformationVectorGlobal("CSDaemonheart")>1 ||
					BuildaHQ.getCountFromInformationVectorGlobal("CSProphet")>1){
					uniqueError=true;
			}else{
				uniqueError=false;
			}
		}
	}

	@Override
	public Object getSpecialValue() {
		return 0;
	}

	@Override
	public void switchEntry(String name, boolean aktiv) {
		boolean entrySwitched=false;
		if(name.equals( BuildaHQ.translate("Axt der blinden Wut"))){ 
			if(malDesKhorne!=aktiv){
				this.malDesKhorne = aktiv;
				entrySwitched=true;
			}
		}
		if(name.equals( BuildaHQ.translate("Schriftrollen des Magnus"))){ 
			if(malDesTzeentch!=aktiv){
				this.malDesTzeentch = aktiv;
				entrySwitched=true;
			}
		}

		if(entrySwitched){
			//Aktualisisert alle Einträge, auch die, welche diese Rüstkammer enthält.
			//Sonst werden dort zwar beim abwählen von Malen die Punkte korrekt berechnet, 
			//der Text aber nicht aktualisiert.
			RefreshListener.fireRefresh();
		}
	}

	@Override
	public void deleteYourself() {
		
		if(fackelBool==true){
			fackelBool=false;
			BuildaHQ.addToInformationVectorGlobal("CMFackel", -1);
		}
					
		if(axtBool==true){
			axtBool=false;
			BuildaHQ.addToInformationVectorGlobal("CMAxt", -1);
		}
					
		if(schwertBool==true){
			schwertBool=false;
			BuildaHQ.addToInformationVectorGlobal("CMSchwert", -1);
		}
					
		if(kolbenBool==true){
			kolbenBool=false;
			BuildaHQ.addToInformationVectorGlobal("CMKolben", -1);
		}
						
		if(schluesselBool==true){
			schluesselBool=false;
			BuildaHQ.addToInformationVectorGlobal("CMSchluessel", -1);
		}
				
		if(rolleBool==true){
			rolleBool=false;
			BuildaHQ.addToInformationVectorGlobal("CMRolle", -1);
		}
		
		if(spineshiverBool==true){
			spineshiverBool=false;
			BuildaHQ.addToInformationVectorGlobal("BLSpineshiver", -1);
		}
	
		if(crucibleBool==true){
			crucibleBool=false;
			BuildaHQ.addToInformationVectorGlobal("BLCrucible", -1);
		}
	
		if(memoryBool==true){
			memoryBool=false;
			BuildaHQ.addToInformationVectorGlobal("BLMemory", -1);
		}
	
		if(eyeBool==true){
			eyeBool=false;
			BuildaHQ.addToInformationVectorGlobal("BLEye", -1);
		}
	
		if(skullBool==true){
			skullBool=false;
			BuildaHQ.addToInformationVectorGlobal("BLSkull", -1);
		}
		
		if(handBool==true){
			handBool=false;
			BuildaHQ.addToInformationVectorGlobal("BLHand", -1);
		}
		
		if(bladeBool==true){
			bladeBool=false;
			BuildaHQ.addToInformationVectorGlobal("CSBlade", -1);
		}
					
		if(hornsBool==true){
			hornsBool=false;
			BuildaHQ.addToInformationVectorGlobal("CSHorns", -1);
		}
					
		if(balestarBool==true){
			balestarBool=false;
			BuildaHQ.addToInformationVectorGlobal("CSBalestar", -1);
		}
						
		if(daemonheartBool==true){
			daemonheartBool=false;
			BuildaHQ.addToInformationVectorGlobal("CSDaemonheart", -1);
		}
				
		if(prophetBool==true){
			prophetBool=false;
			BuildaHQ.addToInformationVectorGlobal("CSProphet", -1);
		}
				
		super.deleteYourself();
	}

}
