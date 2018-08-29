package oc.wh40k.units.as;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class ASWaffenUndRelikte extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2, o3;
    OptionsEinzelUpgrade schriftrollen;
    OptionsEinzelUpgrade dimensionsschlüssel;
    OptionsEinzelUpgrade handwaffe = null;
    OptionsEinzelUpgrade boltpistole = null;
    OptionsEinzelUpgrade bolter = null;
    OptionsEinzelUpgrade spezialWaffe = null;
    OptionsUpgradeGruppe priesterWaffe = null;
    boolean SchwertDerMahnungBool=false;
    boolean buchBool=false;
    boolean litanaienBool=false;
    boolean mantelBool=false;
    boolean kolbenBool=false;
    boolean opheliaBool=false;
    boolean SkullofPetronella=false;
    boolean BladeoftheWorthy=false;
    boolean Castigator=false;
    boolean TheFontofFury=false;
    boolean ShroudoftheAntiMartyr=false;
    boolean DesvallessHolyCircle=false;
    boolean uniqueError=false;

	boolean isPrincipalis = false;
	boolean isPriester = false;    
	boolean isDialogus = false;  
	
	public ASWaffenUndRelikte() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		try {
			isPrincipalis = defaults[0]; 
			isPriester = defaults[1];        
			isDialogus = defaults[2];          
		} catch(Exception e) {}
		
	    if(isPrincipalis) {
	    	add(handwaffe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kettenschwert", 0));
	    	handwaffe.setSelected(true);
			add(boltpistole = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boltpistole", 0));
			boltpistole.setSelected(true);
	    } else if(isPriester) {
			ogE.addElement(new OptionsGruppeEintrag("Laserpistole", 0));
			ogE.addElement(new OptionsGruppeEintrag("Sturmgewehr", 0));
			ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 1));
			ogE.addElement(new OptionsGruppeEintrag("Bolter", 1));
			ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
			add(priesterWaffe = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			priesterWaffe.setSelected(0, true);
	    	add(handwaffe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Handwaffe", 0));
	    	handwaffe.setSelected(true);
	    } 
	    
	    seperator();
	   
	    if(!isDialogus) {
			ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
			ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
			if(isPriester || isPrincipalis)
				ogE.addElement(new OptionsGruppeEintrag("Eviscerator", 30));
			add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
			seperator();
			
			if(isPrincipalis)
				ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
			if(isPriester)
				ogE.addElement(new OptionsGruppeEintrag("Schrotflinte", 1));
				ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
				ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
				ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
				ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
				ogE.addElement(new OptionsGruppeEintrag("Condemnor-Bolter", 10));
				ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
			if(isPrincipalis){
				ogE.addElement(new OptionsGruppeEintrag("Infernopistole", 15));
			}
			add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		}
	    
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das Buch von St. Lucius"), 5));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Die Litanaien des Glaubens"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Der Umhang von St. Aspira"), 20));
		if(isPriester)
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Der Streitkolben von Valaan"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Der Mantel von Ophelia"), 25));
		if(isPrincipalis)
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das Schwert der Mahnung"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Skull of Petronella the Pious"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blade of the Worthy"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Castigator"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("The Font of Fury"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Shroud of the Anti-Martyr"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Desvalles's Holy Circle"), 35));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		setUeberschrift("Waffen und Relikte");
		sizeSetzen();
		
		seperator();
	}

	@Override
	public void refreshen() {		
		
		int nahkampfwaffen = 0;
		int fernkampfwaffen = 0;
		int relikte = 0;
		int substractor = 0;
		int sdm1 = 0;
		int sdm2 = 0;
		
		o1.setAktiv("Skull of Petronella the Pious", getCountFromInformationVector("EcclesiarchyRelics")>0);
		o1.setAktiv("Blade of the Worthy", getCountFromInformationVector("EcclesiarchyRelics")>0);
		o1.setAktiv("Castigator", getCountFromInformationVector("EcclesiarchyRelics")>0);
		o1.setAktiv("The Font of Fury", getCountFromInformationVector("EcclesiarchyRelics")>0);
		o1.setAktiv("Shroud of the Anti-Martyr", getCountFromInformationVector("EcclesiarchyRelics")>0);
		o1.setAktiv("Desvalles's Holy Circle", getCountFromInformationVector("EcclesiarchyRelics")>0);
		
		if(isPrincipalis) {
			if(handwaffe.isSelected() && boltpistole.isSelected()) { substractor = 2; }
			else if(handwaffe.isSelected() || boltpistole.isSelected()) { substractor = 1; }
			else if(!handwaffe.isSelected() && !boltpistole.isSelected()) { substractor = 0; }
			
			nahkampfwaffen = 2 - substractor - o2.getAnzahl() - (o1.isSelected("Das Schwert der Mahnung") ? 1:0) - (o1.isSelected("Blade of the Worthy") ? 1:0);
			fernkampfwaffen = 2 - substractor - o3.getAnzahl() - (o1.isSelected("Das Schwert der Mahnung") ? 1:0);
			sdm1= 2 - substractor - o2.getAnzahl();
			sdm2= 2 - substractor - o3.getAnzahl();
			relikte = 1;
			
			if(nahkampfwaffen < 0) nahkampfwaffen = 0;
			if(fernkampfwaffen < 0) fernkampfwaffen = 0;
			
			if(fernkampfwaffen > 1) fernkampfwaffen = 1;
			if(nahkampfwaffen > 1) nahkampfwaffen = 1;
			
			o3.setMaxAnzahl(nahkampfwaffen);
			o2.setMaxAnzahl(fernkampfwaffen);
			o1.setAktiv("Das Schwert der Mahnung", (sdm1>0 || sdm2>0));
			o1.setAktiv("Blade of the Worthy", (sdm2>0) && getCountFromInformationVector("EcclesiarchyRelics")>0);
			
			o1.setMaxAnzahl(relikte);
				
			legal = ((boltpistole.isSelected()?1:0) + (handwaffe.isSelected()?1:0) + (o1.isSelected("Das Schwert der Mahnung") ? 1:0) + (o1.isSelected("Blade of the Worthy") ? 1:0) + o2.getAnzahl() + o3.getAnzahl())==2;
			boltpistole.setLegal(legal);
			handwaffe.setLegal(legal);
			o1.setLegal(legal);
			o2.setLegal(legal);
			o3.setLegal(legal);
		}
		
		if(isPriester) {
			if(!priesterWaffe.isSelected()) nahkampfwaffen = 1;
			
			if(priesterWaffe.isSelected() && handwaffe.isSelected()) { substractor = 2; }
			else if(priesterWaffe.isSelected() || handwaffe.isSelected()) { substractor = 1; }
			else if(!priesterWaffe.isSelected() && !handwaffe.isSelected()) { substractor = 0; }
			
			nahkampfwaffen = 2 - substractor - o2.getAnzahl();
			fernkampfwaffen = 2 - substractor - o3.getAnzahl();
			relikte = 1;
			
			if(nahkampfwaffen < 0) nahkampfwaffen = 0;
			if(fernkampfwaffen < 0) fernkampfwaffen = 0;
			if(relikte < 0) relikte = 0;
			
			if(nahkampfwaffen > 1) nahkampfwaffen = 1;
			if(fernkampfwaffen > 1) fernkampfwaffen = 1;
			if(relikte > 1) relikte = 1;
			
			o3.setMaxAnzahl(nahkampfwaffen);
			o2.setMaxAnzahl(fernkampfwaffen);
			o1.setMaxAnzahl(relikte);
			
			legal = ((handwaffe.isSelected()?1:0) + (priesterWaffe.isSelected()?1:0) + o2.getAnzahl() + o3.getAnzahl())==2;
			handwaffe.setLegal(legal);
			priesterWaffe.setLegal(legal);
			o1.setLegal(legal);
			o2.setLegal(legal);
			o3.setLegal(legal);
		}
		
		if(isDialogus) {
			o1.setMaxAnzahl(1);
		}
		
	    //Einzigartige Gegenstände
		if(o1.isSelected("Das Schwert der Mahnung")){
			if(SchwertDerMahnungBool==false){
				SchwertDerMahnungBool=true;
				BuildaHQ.addToInformationVectorGlobal("ASSchwert", 1);
			}
		} else if(!o1.isSelected("Das Schwert der Mahnung")) {
			if(SchwertDerMahnungBool==true){
				SchwertDerMahnungBool=false;
				BuildaHQ.addToInformationVectorGlobal("ASSchwert", -1);
			}
		}
		
		if(o1.isSelected("Das Buch von St. Lucius")){
			if(buchBool==false){
				buchBool=true;
				BuildaHQ.addToInformationVectorGlobal("ASBuch", 1);
			}
		} else if(!o1.isSelected("Das Buch von St. Lucius")) {
			if(buchBool==true){
				buchBool=false;
				BuildaHQ.addToInformationVectorGlobal("ASBuch", -1);
			}
		}
		
		if(o1.isSelected("Die Litanaien des Glaubens")){
			if(litanaienBool==false){
				litanaienBool=true;
				BuildaHQ.addToInformationVectorGlobal("ASLitaneien", 1);
			}
		} else if(!o1.isSelected("Die Litanaien des Glaubens")) {
			if(litanaienBool==true){
				litanaienBool=false;
				BuildaHQ.addToInformationVectorGlobal("ASLitaneien", -1);
			}
		}
		
		if(o1.isSelected("Der Umhang von St. Aspira")){
			if(mantelBool==false){
				mantelBool=true;
				BuildaHQ.addToInformationVectorGlobal("ASMantel", 1);
			}
		} else if(!o1.isSelected("Der Mantel von St. Aspira")) {
			if(mantelBool==true){
				mantelBool=false;
				BuildaHQ.addToInformationVectorGlobal("ASMantel", -1);
			}
		}
		
		if(o1.isSelected("Der Streitkolben von Valaan")){
			if(kolbenBool==false){
				kolbenBool=true;
				BuildaHQ.addToInformationVectorGlobal("ASKolben", 1);
			}
		} else if(!o1.isSelected("Der Streitkolben von Valaan")) {
			if(kolbenBool==true){
				kolbenBool=false;
				BuildaHQ.addToInformationVectorGlobal("ASKolben", -1);
			}
		}
		
		if(o1.isSelected("Der Mantel von Ophelia")){
			if(opheliaBool==false){
				opheliaBool=true;
				BuildaHQ.addToInformationVectorGlobal("ASOphelia", 1);
			}
		} else if(!o1.isSelected("Der Mantel von Ophelia")) {
			if(opheliaBool==true){
				opheliaBool=false;
				BuildaHQ.addToInformationVectorGlobal("ASOphelia", -1);
			}
		}
		
		if(o1.isSelected("Skull of Petronella the Pious")){
			if(SkullofPetronella==false){
				SkullofPetronella=true;
				BuildaHQ.addToInformationVectorGlobal("SkullofPetronella", 1);
			}
		} else if(!o1.isSelected("Skull of Petronella the Pious")) {
			if(SkullofPetronella==true){
				SkullofPetronella=false;
				BuildaHQ.addToInformationVectorGlobal("SkullofPetronella", -1);
			}
		}
		
		if(o1.isSelected("Blade of the Worthy")){
			if(BladeoftheWorthy==false){
				BladeoftheWorthy=true;
				BuildaHQ.addToInformationVectorGlobal("BladeoftheWorthy", 1);
			}
		} else if(!o1.isSelected("Blade of the Worthy")) {
			if(BladeoftheWorthy==true){
				BladeoftheWorthy=false;
				BuildaHQ.addToInformationVectorGlobal("BladeoftheWorthy", -1);
			}
		}
		
		if(o1.isSelected("Castigator")){
			if(Castigator==false){
				Castigator=true;
				BuildaHQ.addToInformationVectorGlobal("Castigator", 1);
			}
		} else if(!o1.isSelected("Castigator")) {
			if(Castigator==true){
				Castigator=false;
				BuildaHQ.addToInformationVectorGlobal("Castigator", -1);
			}
		}
		
		if(o1.isSelected("The Font of Fury")){
			if(TheFontofFury==false){
				TheFontofFury=true;
				BuildaHQ.addToInformationVectorGlobal("TheFontofFury", 1);
			}
		} else if(!o1.isSelected("The Font of Fury")) {
			if(TheFontofFury==true){
				TheFontofFury=false;
				BuildaHQ.addToInformationVectorGlobal("TheFontofFury", -1);
			}
		}
		
		if(o1.isSelected("Shroud of the Anti-Martyr")){
			if(ShroudoftheAntiMartyr==false){
				ShroudoftheAntiMartyr=true;
				BuildaHQ.addToInformationVectorGlobal("ShroudoftheAntiMartyr", 1);
			}
		} else if(!o1.isSelected("Shroud of the Anti-Martyr")) {
			if(ShroudoftheAntiMartyr==true){
				ShroudoftheAntiMartyr=false;
				BuildaHQ.addToInformationVectorGlobal("ShroudoftheAntiMartyr", -1);
			}
		}
		//Desvalles's Holy Circle - 35
		if(o1.isSelected("Desvalles's Holy Circle")){
			if(DesvallessHolyCircle==false){
				DesvallessHolyCircle=true;
				BuildaHQ.addToInformationVectorGlobal("DesvallessHolyCircle", 1);
			}
		} else if(!o1.isSelected("Desvalles's Holy Circle")) {
			if(DesvallessHolyCircle==true){
				DesvallessHolyCircle=false;
				BuildaHQ.addToInformationVectorGlobal("DesvallessHolyCircle", -1);
			}
		}
		
		if(BuildaHQ.getCountFromInformationVectorGlobal("ASSchwert")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("ASBuch")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("ASLitaneien")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("ASMantel")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("ASKolben")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("ASOphelia")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("SkullofPetronella")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("BladeoftheWorthy")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("Castigator")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("TheFontofFury")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("ShroudoftheAntiMartyr")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("DesvallessHolyCircle")>1){
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
		
		if(SchwertDerMahnungBool==true){
			SchwertDerMahnungBool=false;
			BuildaHQ.addToInformationVectorGlobal("ASSchwert", -1);
		}
					
		if(buchBool==true){
			buchBool=false;
			BuildaHQ.addToInformationVectorGlobal("ASBuch", -1);
		}
					
		if(litanaienBool==true){
			litanaienBool=false;
			BuildaHQ.addToInformationVectorGlobal("ASLitaneien", -1);
		}
					
		if(mantelBool==true){
			mantelBool=false;
			BuildaHQ.addToInformationVectorGlobal("ASMantel", -1);
		}
						
		if(kolbenBool==true){
			kolbenBool=false;
			BuildaHQ.addToInformationVectorGlobal("ASKolben", -1);
		}
				
		if(opheliaBool==true){
			opheliaBool=false;
			BuildaHQ.addToInformationVectorGlobal("ASOphelia", -1);
		}
		
		if(SkullofPetronella==true){
			SkullofPetronella=false;
			BuildaHQ.addToInformationVectorGlobal("SkullofPetronella", -1);
		}

		if(BladeoftheWorthy==true){
			BladeoftheWorthy=false;
			BuildaHQ.addToInformationVectorGlobal("BladeoftheWorthy", -1);
		}
		
		if(Castigator==true){
			Castigator=false;
			BuildaHQ.addToInformationVectorGlobal("Castigator", -1);
		}
		
		if(TheFontofFury==true){
			TheFontofFury=false;
			BuildaHQ.addToInformationVectorGlobal("TheFontofFury", -1);
		}
		
		if(ShroudoftheAntiMartyr==true){
			ShroudoftheAntiMartyr=false;
			BuildaHQ.addToInformationVectorGlobal("ShroudoftheAntiMartyr", -1);
		}
		
		if(DesvallessHolyCircle==true){
			DesvallessHolyCircle=false;
			BuildaHQ.addToInformationVectorGlobal("DesvallessHolyCircle", -1);
		}
				
		super.deleteYourself();
	}
	
}
