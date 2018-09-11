package oc.wh40k.units.cs;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class CSWaffenUndArtefakte extends RuestkammerVater {

	OptionsZaehlerGruppe o2, o3;
    OptionsEinzelUpgrade blade;
    OptionsEinzelUpgrade crozius;
    OptionsEinzelUpgrade horns;
    OptionsEinzelUpgrade balestar;
    OptionsEinzelUpgrade daemonheart;
    OptionsEinzelUpgrade prophet;
    OptionsEinzelUpgrade handwaffe = null;
    OptionsEinzelUpgrade boltpistole = null;
    OptionsEinzelUpgrade bolter = null;
    OptionsEinzelUpgrade spezialWaffe = null;
    OptionsUpgradeGruppe psiWaffe = null;
    boolean bladeBool=false;
    boolean croziusBool=false;
    boolean hornsBool=false;
    boolean balestarBool=false;
    boolean daemonheartBool=false;
    boolean prophetBool=false;
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
	
	public CSWaffenUndArtefakte() {
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
		
		add(blade = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Blade of the Relentless"), 30));
		blade.setAktiv(false);
		add(crozius = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Crozius of the Dark Covenant"), 30));
		crozius.setAktiv(false);
		add(horns = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("The Slaughterers Horns"), 15));
		add(balestar = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("The Balestar of Mannon"), 25));
		balestar.setAktiv(false);
		add(daemonheart = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Daemonheart"), 30));
		add(prophet = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Prophet of Voices"), 30));
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		
		int nahkampfwaffen = 0;
		int fernkampfwaffen = 0;
		int artefakte = 0;
		int substractor = 0;
		
		if(isChaosgeneral) {
			if(handwaffe.isSelected() && boltpistole.isSelected()) { substractor = 2; }
			else if(handwaffe.isSelected() || boltpistole.isSelected()) { substractor = 1; }
			else if(!handwaffe.isSelected() && !boltpistole.isSelected()) { substractor = 0; }
			
			nahkampfwaffen = 2 - substractor - o2.getAnzahl();
			fernkampfwaffen = 2 - substractor - o3.getAnzahl();
			artefakte = 2 - substractor - o2.getAnzahl() - o3.getAnzahl();
			
			if(nahkampfwaffen < 0) nahkampfwaffen = 0;
			if(fernkampfwaffen < 0) fernkampfwaffen = 0;
			if(artefakte < 0) artefakte = 0;
			
			if(fernkampfwaffen > 1) fernkampfwaffen = 1;
			if(artefakte > 1) artefakte = 1;
			
			o3.setMaxAnzahl(nahkampfwaffen);
			o2.setMaxAnzahl(fernkampfwaffen);
				
			legal = ((boltpistole.isSelected()?1:0) + (handwaffe.isSelected()?1:0) + o2.getAnzahl() + o3.getAnzahl())==2;
			boltpistole.setLegal(legal);
			handwaffe.setLegal(legal);
			o2.setLegal(legal);
			o3.setLegal(legal);
			
			blade.setAktiv(true);
		}
		
		if(isHexer) {
			if(!psiWaffe.isSelected()) nahkampfwaffen = 1;
			
			if(psiWaffe.isSelected() && boltpistole.isSelected()) { substractor = 2; }
			else if(psiWaffe.isSelected() || boltpistole.isSelected()) { substractor = 1; }
			else if(!psiWaffe.isSelected() && !boltpistole.isSelected()) { substractor = 0; }
			
			nahkampfwaffen = 2 - substractor - o2.getAnzahl();
			fernkampfwaffen = 2 - substractor - o3.getAnzahl();
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
			
			legal = ((boltpistole.isSelected()?1:0) + (psiWaffe.isSelected()?1:0) + o2.getAnzahl() + o3.getAnzahl())==2;
			boltpistole.setLegal(legal);
			psiWaffe.setLegal(legal);
			o2.setLegal(legal);
			o3.setLegal(legal);
			
			balestar.setAktiv(true);
		}
		
		if(isWarpschmied) {

			o3.setAktiv(false);
			
			if(spezialWaffe.isSelected() && boltpistole.isSelected()) { substractor = 2; }
			else if(spezialWaffe.isSelected() || boltpistole.isSelected()) { substractor = 1; }
			else if(!spezialWaffe.isSelected() && !boltpistole.isSelected()) { substractor = 0; }
			
			fernkampfwaffen = 2 - substractor;
			artefakte = 2 - substractor - o2.getAnzahl();
			
			if(fernkampfwaffen < 0) fernkampfwaffen = 0;
			if(artefakte < 0) artefakte = 0;
			
			if(fernkampfwaffen > 1) fernkampfwaffen = 1;
			if(artefakte > 1) artefakte = 1;
			
			o2.setMaxAnzahl(fernkampfwaffen);
			
			legal = ((boltpistole.isSelected()?1:0) + (spezialWaffe.isSelected()?1:0) + o2.getAnzahl())==2;
			boltpistole.setLegal(legal);
			spezialWaffe.setLegal(legal);
			o2.setLegal(legal);
		}
		
		if(isApostel) {

			o3.setAktiv(false);
			
			if(spezialWaffe.isSelected() && boltpistole.isSelected()) { substractor = 2; }
			else if(spezialWaffe.isSelected() || boltpistole.isSelected()) { substractor = 1; }
			else if(!spezialWaffe.isSelected() && !boltpistole.isSelected()) { substractor = 0; }
			
			fernkampfwaffen = 2 - substractor - (crozius.isSelected()?1:0);
			artefakte = 2 - substractor - o2.getAnzahl();
			
			if(fernkampfwaffen < 0) fernkampfwaffen = 0;
			if(artefakte < 0) artefakte = 0;
			
			if(fernkampfwaffen > 1) fernkampfwaffen = 1;
			if(artefakte > 1) artefakte = 1;
			
			o2.setMaxAnzahl(fernkampfwaffen);
			
			if(!spezialWaffe.isSelected())
			{
				crozius.setAktiv(true);
			}
			
			legal = ((boltpistole.isSelected()?1:0) + (spezialWaffe.isSelected()?1:0) + (crozius.isSelected()?1:0) + o2.getAnzahl())==2;
			boltpistole.setLegal(legal);
			spezialWaffe.setLegal(legal);
			o2.setLegal(legal);
		}
		
		if(isDaemon){
			
			daemonheart.setAktiv(false);
			
			o3.setAktiv(false);
			o2.setAktiv(false);
			
			legal = ((handwaffe.isSelected()?1:0))==1;
			handwaffe.setLegal(legal);
		}
			
	    //Einzigartige Gegenstände
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
		
		if(BuildaHQ.getCountFromInformationVectorGlobal("CSCrozius")>1 ||
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

	}
	
	@Override
	public void deleteYourself() {
		
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
