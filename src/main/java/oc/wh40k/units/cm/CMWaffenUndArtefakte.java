package oc.wh40k.units.cm;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class CMWaffenUndArtefakte extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2, o3;
	OptionsEinzelUpgrade blade;
    OptionsEinzelUpgrade crozius;
    OptionsEinzelUpgrade horns;
    OptionsEinzelUpgrade balestar;
    OptionsEinzelUpgrade daemonheart;
    OptionsEinzelUpgrade prophet;
    OptionsEinzelUpgrade schriftrollen;
    OptionsEinzelUpgrade dimensionsschlüssel;
    OptionsEinzelUpgrade handwaffe = null;
    OptionsEinzelUpgrade boltpistole = null;
    OptionsEinzelUpgrade bolter = null;
    OptionsEinzelUpgrade spezialWaffe = null;
    OptionsUpgradeGruppe psiWaffe = null;

    OptionsEinzelUpgrade spineshiver;
    OptionsEinzelUpgrade crucible;
    OptionsEinzelUpgrade memory;
    OptionsEinzelUpgrade eye;
    OptionsEinzelUpgrade skull;
    OptionsEinzelUpgrade hand;
    boolean bladeBool=false;
    boolean croziusBool=false;
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
	boolean malDesNurgle = false;
	boolean malDesSlaanesh = false;

	boolean isChaosgeneral = false; //Handwaffe, Boltpistole 
	boolean isHexer = false;        //Psiwaffe, Boltpistole
	boolean isWarpschmied = false;  //Energieaxt, Boltpistole
	boolean isApostel = false;      //Energiestreitkolben, Boltpistole
    boolean isDaemon = false; //Seuchenmesser, Boltpistole, Bolter
    
    boolean isBlackLegion = false;
	boolean isCrimsonSlaughter = false;
	
	public CMWaffenUndArtefakte() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		try {
			isChaosgeneral = defaults[0]; 
			isHexer = defaults[1];        
			isWarpschmied = defaults[2];  
			isApostel = defaults[3];      
			isDaemon = defaults[4];     
		} catch(Exception e) {}
		
	    if(isChaosgeneral || isDaemon) {
	    	add(handwaffe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Handwaffe", 0));
	    	handwaffe.setSelected(true);
	    } else if(isHexer) {
			ogE.addElement(new OptionsGruppeEintrag("Psiwaffe", 0));
			ogE.addElement(new OptionsGruppeEintrag("Psistab", 0));
			ogE.addElement(new OptionsGruppeEintrag("Psischwert", 0));
			ogE.addElement(new OptionsGruppeEintrag("Psiaxt", 0));
			add(psiWaffe = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			psiWaffe.setSelected(0, true);
	    } else if(isWarpschmied) {
	    	add(spezialWaffe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Energieaxt", 0));
	    	spezialWaffe.setSelected(true);
	    } else if(isApostel) {
	    	add(spezialWaffe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Energiestreitkolben", 0));
	    	spezialWaffe.setSelected(true);
	    } 
	    
	    if(!isDaemon){
		    add(boltpistole = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boltpistole", 0));
		    boltpistole.setSelected(true);
	    }
	    
	    seperator();
	   
		ogE.addElement(new OptionsGruppeEintrag("Kettenaxt", 8));
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Kombibolter", 3));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Brandfackel von Skalathrax"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Axt der blinden Wut"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das Mordschwert"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Der schwarze Streitkolben"), 45));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		seperator();
		
		add(dimensionsschlüssel = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Dimensionsschlüssel"), 25));
		add(schriftrollen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schriftrollen des Magnus"), 45));seperator();

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
		add(crozius = new OptionsEinzelUpgrade(ID, randAbstand +280, cnt, "", BuildaHQ.translate("Crozius of the Dark Covenant"), 30));
		crozius.setAktiv(false);
		add(horns = new OptionsEinzelUpgrade(ID, randAbstand +280, cnt, "", BuildaHQ.translate("The Slaughterers Horns"), 15));
		add(balestar = new OptionsEinzelUpgrade(ID, randAbstand +280, cnt, "", BuildaHQ.translate("The Balestar of Mannon"), 25));
		balestar.setAktiv(false);
		add(daemonheart = new OptionsEinzelUpgrade(ID, randAbstand +280, cnt, "", BuildaHQ.translate("Daemonheart"), 30));
		add(prophet = new OptionsEinzelUpgrade(ID, randAbstand +280, cnt, "", BuildaHQ.translate("Prophet of Voices"), 30));
		

		setUeberschrift("Waffen und Artefakte");
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		
		int nahkampfwaffen = 0;
		int fernkampfwaffen = 0;
		int artefakte = 0;
		int substractor = 0;
		
		isCrimsonSlaughter=getCountFromInformationVector("CrimsonSlaughter")>0;
		
		if(isChaosgeneral) {
			if(handwaffe.isSelected() && boltpistole.isSelected()) { substractor = 2; }
			else if(handwaffe.isSelected() || boltpistole.isSelected()) { substractor = 1; }
			else if(!handwaffe.isSelected() && !boltpistole.isSelected()) { substractor = 0; }
			
			nahkampfwaffen = 2 - substractor - o2.getAnzahl() - o1.getAnzahl();
			fernkampfwaffen = 2 - substractor - o3.getAnzahl() - o1.getAnzahl();
			artefakte = 2 - substractor - o2.getAnzahl() - o3.getAnzahl();
			
			if(nahkampfwaffen < 0) nahkampfwaffen = 0;
			if(fernkampfwaffen < 0) fernkampfwaffen = 0;
			if(artefakte < 0) artefakte = 0;
			
			if(fernkampfwaffen > 1) fernkampfwaffen = 1;
			if(artefakte > 1) artefakte = 1;
			
			o3.setMaxAnzahl(nahkampfwaffen);
			o2.setMaxAnzahl(fernkampfwaffen);
			
			
			o1.setAktiv(artefakte>0);
			o1.setAktiv(BuildaHQ.translate("Axt der blinden Wut"), malDesKhorne && artefakte>0);
			o1.setMaxAnzahl(artefakte);
				
			legal = ((boltpistole.isSelected()?1:0) + (handwaffe.isSelected()?1:0) + o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl())==2;
			boltpistole.setLegal(legal);
			handwaffe.setLegal(legal);
			o1.setLegal(legal);
			o2.setLegal(legal);
			o3.setLegal(legal);
		}
		
		if(isHexer) {
			if(!psiWaffe.isSelected()) nahkampfwaffen = 1;
			
			if(psiWaffe.isSelected() && boltpistole.isSelected()) { substractor = 2; }
			else if(psiWaffe.isSelected() || boltpistole.isSelected()) { substractor = 1; }
			else if(!psiWaffe.isSelected() && !boltpistole.isSelected()) { substractor = 0; }
			
			nahkampfwaffen = 2 - substractor - o2.getAnzahl() - o1.getAnzahl();
			fernkampfwaffen = 2 - substractor - o3.getAnzahl() - o1.getAnzahl();
			artefakte = 2 - substractor - o2.getAnzahl() - o3.getAnzahl();
			
			if(nahkampfwaffen < 0) nahkampfwaffen = 0;
			if(fernkampfwaffen < 0) fernkampfwaffen = 0;
			if(artefakte < 0) artefakte = 0;
			
			if(nahkampfwaffen > 1) nahkampfwaffen = 1;
			if(fernkampfwaffen > 1) fernkampfwaffen = 1;
			if(artefakte > 1) artefakte = 1;
			
			if(!boltpistole.isSelected()) { 
				o3.setMaxAnzahl(nahkampfwaffen); 
			} else {
				o3.setMaxAnzahl(0);
			}
			o2.setMaxAnzahl(fernkampfwaffen);
			o1.setMaxAnzahl(artefakte);
			o1.setAktiv(BuildaHQ.translate("Axt der blinden Wut"), false);
			
			legal = ((boltpistole.isSelected()?1:0) + (psiWaffe.isSelected()?1:0) + o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl())==2;
			boltpistole.setLegal(legal);
			psiWaffe.setLegal(legal);
			o1.setLegal(legal);
			o2.setLegal(legal);
			o3.setLegal(legal);
		}
		
		if(isWarpschmied || isApostel) {

			o3.setAktiv(false);
			
			if(spezialWaffe.isSelected() && boltpistole.isSelected()) { substractor = 2; }
			else if(spezialWaffe.isSelected() || boltpistole.isSelected()) { substractor = 1; }
			else if(!spezialWaffe.isSelected() && !boltpistole.isSelected()) { substractor = 0; }
			
			fernkampfwaffen = 2 - substractor - o1.getAnzahl();
			artefakte = 2 - substractor - o2.getAnzahl();
			
			if(fernkampfwaffen < 0) fernkampfwaffen = 0;
			if(artefakte < 0) artefakte = 0;
			
			if(fernkampfwaffen > 1) fernkampfwaffen = 1;
			if(artefakte > 1) artefakte = 1;
			
			o2.setMaxAnzahl(fernkampfwaffen);
			
			o1.setAktiv(artefakte>0);
			o1.setAktiv(BuildaHQ.translate("Axt der blinden Wut"), malDesKhorne && artefakte>0);
			o1.setMaxAnzahl(artefakte);
			
			legal = ((boltpistole.isSelected()?1:0) + (spezialWaffe.isSelected()?1:0) + o1.getAnzahl() + o2.getAnzahl())==2;
			boltpistole.setLegal(legal);
			spezialWaffe.setLegal(legal);
			o1.setLegal(legal);
			o2.setLegal(legal);
			
			if(!spezialWaffe.isSelected())
			{
				crozius.setAktiv(isApostel && isCrimsonSlaughter);
			}
		}
		
		if(isDaemon){
			o3.setAktiv(false);
			o2.setAktiv(false);
			
			if(!handwaffe.isSelected()){
				artefakte = 1;
			} else {
				artefakte = 0;
				if(o1.isSelected()){
					int index = o1.getSelectedIndex();
					o1.setSelected(index, false);
				}
			}
			
			o1.setAktiv(artefakte>0);
			o1.setAktiv(BuildaHQ.translate("Axt der blinden Wut"), malDesKhorne && artefakte>0);
			o1.setMaxAnzahl(artefakte);
			
			legal = ((handwaffe.isSelected()?1:0) + o1.getAnzahl())==1;
			handwaffe.setLegal(legal);
			o1.setLegal(legal);
		}
		
		if(isDaemon || isChaosgeneral || isHexer){
			if(isBlackLegion){
				o1.setAktiv("Brandfackel von Skalathrax", artefakte>0);
				o1.setAktiv("Axt der blinden Wut", malDesKhorne && artefakte>0);
				o1.setAktiv("Das Mordschwert", artefakte>0);
				o1.setAktiv("Der schwarze Streitkolben", artefakte>0);
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
			    crozius.setAktiv(false);
			    horns.setAktiv(false);
			    prophet.setAktiv(false);
			}else if(isCrimsonSlaughter){
				o1.setAktiv("Brandfackel von Skalathrax", artefakte>0);
				o1.setAktiv("Axt der blinden Wut", malDesKhorne && artefakte>0);
				o1.setAktiv("Das Mordschwert", artefakte>0);
				o1.setAktiv("Der schwarze Streitkolben", artefakte>0);
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
				daemonheart.setAktiv(!isDaemon);
			}else{
				o1.setAktiv("Brandfackel von Skalathrax", artefakte>0);
				o1.setAktiv("Axt der blinden Wut", malDesKhorne && artefakte>0);
				o1.setAktiv("Das Mordschwert", artefakte>0);
				o1.setAktiv("Der schwarze Streitkolben", artefakte>0);
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
			    crozius.setAktiv(false);
			    horns.setAktiv(false);
			    prophet.setAktiv(false);
			}
		}
		
	    //Einzigartige Gegenstände
		if(o1.isSelected("Brandfackel von Skalathrax")){
			if(fackelBool==false){
				fackelBool=true;
				BuildaHQ.addToInformationVectorGlobal("CMFackel", 1);
			}
		} else if(!o1.isSelected("Brandfackel von Skalathrax")) {
			if(fackelBool==true){
				fackelBool=false;
				BuildaHQ.addToInformationVectorGlobal("CMFackel", -1);
			}
		}
		
		if(o1.isSelected("Axt der blinden Wut")){
			if(axtBool==false){
				axtBool=true;
				BuildaHQ.addToInformationVectorGlobal("CMAxt", 1);
			}
		} else if(!o1.isSelected("Axt der blinden Wut")) {
			if(axtBool==true){
				axtBool=false;
				BuildaHQ.addToInformationVectorGlobal("CMAxt", -1);
			}
		}
		
		if(o1.isSelected("Das Mordschwert")){
			if(schwertBool==false){
				schwertBool=true;
				BuildaHQ.addToInformationVectorGlobal("CMSchwert", 1);
			}
		} else if(!o1.isSelected("Das Mordschwert")) {
			if(schwertBool==true){
				schwertBool=false;
				BuildaHQ.addToInformationVectorGlobal("CMSchwert", -1);
			}
		}
		
		if(o1.isSelected("Der schwarze Streitkolben")){
			if(kolbenBool==false){
				kolbenBool=true;
				BuildaHQ.addToInformationVectorGlobal("CMKolben", 1);
			}
		} else if(!o1.isSelected("Der schwarze Streitkolben")) {
			if(kolbenBool==true){
				kolbenBool=false;
				BuildaHQ.addToInformationVectorGlobal("CMKolben", -1);
			}
		}
		
		if(dimensionsschlüssel.isSelected()){
			if(schluesselBool==false){
				schluesselBool=true;
				BuildaHQ.addToInformationVectorGlobal("CMSchluessel", 1);
			}
		} else if(!dimensionsschlüssel.isSelected()) {
			if(schluesselBool==true){
				schluesselBool=false;
				BuildaHQ.addToInformationVectorGlobal("CMSchluessel", -1);
			}
		}
		
		if(schriftrollen.isSelected()){
			if(rolleBool==false){
				rolleBool=true;
				BuildaHQ.addToInformationVectorGlobal("CMRolle", 1);
			}
		} else if(!schriftrollen.isSelected()) {
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
				if(crozius.isSelected()){
					if(croziusBool==false){
						croziusBool=true;
						BuildaHQ.addToInformationVectorGlobal("CSCrozius", 1);
					}
				} else if(!crozius.isSelected()) {
					if(croziusBool==true){
						croziusBool=false;
						BuildaHQ.addToInformationVectorGlobal("CSCrozius", -1);
					}
				}
				
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
				BuildaHQ.getCountFromInformationVectorGlobal("CSCrozius")>1 ||
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
					
		if(croziusBool==true){
			croziusBool=false;
			BuildaHQ.addToInformationVectorGlobal("CSCrozius", -1);
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
