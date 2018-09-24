package oc.wh40k.units.da;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class DATerminatorwaffen extends RuestkammerVater {

	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsUpgradeGruppe o4;
    OptionsEinzelUpgrade handwaffe, kombibolter;
	
	boolean isKompaniemeister = false; //E-Schwert
	boolean isAbsolutionspriester = false;//Crozius Arcanum
	boolean isScriptor = false; //Psi-Waffe
	
	boolean schnitterBool=false;
    boolean stimmeBool=false;
    boolean streitkolbenBool=false;
    boolean bestientöterBool=false;
    boolean leichentuchBool=false;
    boolean augeBool=false;
    boolean SkullofPetronella=false;
    boolean BladeoftheWorthy=false;
    boolean Castigator=false;
    boolean TheFontofFury=false;
    boolean ShroudoftheAntiMartyr=false;
    boolean DesvallessHolyCircle=false;
    boolean uniqueError=false;

	public DATerminatorwaffen() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		try {
			isKompaniemeister = defaults[0]; 
			isAbsolutionspriester = defaults[1];
			isScriptor = defaults[2];
		} catch(Exception e) {}
				
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sturmbolter"), 0));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kombi-Flammenwerfer"), 5));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kombi-Melter"), 5));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kombi-Plasmawerfer"), 5));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieklaue"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiehammer"), 25));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		if(!isScriptor) o1.setAnzahl(0, 1);
		if(isScriptor) o1.setPreis("Sturmbolter", 5);
		
		seperator();
		
		if(isKompaniemeister){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieschwert"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ehrenklinge"), 10));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieklaue"), 10));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sturmschild"), 10));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiefaust"), 10));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kettenfaust"), 15));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiehammer"), 15));
		}else if(isAbsolutionspriester){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Crozius Arcanum"), 0));
		}else if(isScriptor){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Psiwaffe"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Psischwert"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Psiaxt"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Psistab"), 0));
		} 
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		o2.setAnzahl(0, 1);
		sizeSetzen();
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Feindschnitter"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Stimme des Löwen"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Streitkolben der Erlösung"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bestientöter von Caliban"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blade of the Worthy (GS)"), 30)); // TODO NKW ersetzen
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
		setUeberschrift("Waffen und Artefakte");
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Leichentuch der Helden"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Auge des Ungesehenen"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Skull of Petronella the Pious (GS)"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Castigator (GS)"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("The Font of Fury (GS)"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Shroud of the Anti-Martyr (GS)"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Desvalles's Holy Circle (GS)"), 35));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));
		

		
		setUeberschrift("Termiwaffen und Artefakte");
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		int nahkampfwaffen = 0;
		int fernkampfwaffen = 0;
		int artefakte = 0;
		
		boolean EcclesiarchyRelics = getCountFromInformationVector("EcclesiarchyRelics")>0;
		
		o3.setAktiv(!o4.isSelected());
		o4.setAktiv(!o3.isSelected());
		
		o4.setAktiv("Skull of Petronella the Pious (GS)", EcclesiarchyRelics && !o3.isSelected());
		o3.setAktiv("Blade of the Worthy (GS)", EcclesiarchyRelics && !o4.isSelected());
		o4.setAktiv("Castigator (GS)", EcclesiarchyRelics && !o3.isSelected());
		o4.setAktiv("The Font of Fury (GS)", EcclesiarchyRelics && !o3.isSelected());
		o4.setAktiv("Shroud of the Anti-Martyr (GS)", EcclesiarchyRelics && !o3.isSelected());
		o4.setAktiv("Desvalles's Holy Circle (GS)", EcclesiarchyRelics && !o3.isSelected());
		
		
		nahkampfwaffen = 2 - o2.getAnzahl() - o3.getAnzahl();
		fernkampfwaffen = 2 - o3.getAnzahl() - o1.getAnzahl();
		artefakte = 2 - o2.getAnzahl() - o1.getAnzahl();
		
		if(nahkampfwaffen < 0) nahkampfwaffen = 0;
		if(fernkampfwaffen < 0) fernkampfwaffen = 0;
		if(artefakte < 0) artefakte = 0;
		
		if(fernkampfwaffen > 1) fernkampfwaffen = 1;
		if(artefakte > 1) artefakte = 1;
		
		o3.setMaxAnzahl(nahkampfwaffen);
		o2.setMaxAnzahl(fernkampfwaffen);
		
		o1.setAktiv(artefakte>0);
		o1.setMaxAnzahl(artefakte);
			
		if(isScriptor)
		{
			legal = o1.getAnzahl() +o2.getAnzahl()+o3.getAnzahl()<=2;
		}
		else 
		{
			legal = o1.getAnzahl() +o2.getAnzahl()+o3.getAnzahl()==2;
		}
		o1.setLegal(legal);
		o2.setLegal(legal);
		o3.setLegal(legal);
		
		//Einzigartige Gegenstände
				if(o3.isSelected("Feindschnitter")){
					if(schnitterBool==false){
						schnitterBool=true;
						BuildaHQ.addToInformationVectorGlobal("DASchnitter", 1);
					}
				} else if(!o3.isSelected("Feindschnitter")) {
					if(schnitterBool==true){
						schnitterBool=false;
						BuildaHQ.addToInformationVectorGlobal("DASchnitter", -1);
					}
				}
				
				if(o3.isSelected("Stimme des Löwen")){
					if(stimmeBool==false){
						stimmeBool=true;
						BuildaHQ.addToInformationVectorGlobal("DAStimme", 1);
					}
				} else if(!o1.isSelected("Stimme des Löwen")) {
					if(stimmeBool==true){
						stimmeBool=false;
						BuildaHQ.addToInformationVectorGlobal("DAStimme", -1);
					}
				}
				
				if(o3.isSelected("Streitkolben der Erlösung")){
					if(streitkolbenBool==false){
						streitkolbenBool=true;
						BuildaHQ.addToInformationVectorGlobal("DAStreitkolben", 1);
					}
				} else if(!o1.isSelected("Streitkolben der Erlösung")) {
					if(streitkolbenBool==true){
						streitkolbenBool=false;
						BuildaHQ.addToInformationVectorGlobal("DAStreitkolben", -1);
					}
				}
				
				if(o3.isSelected("Bestientöter von Caliban")){
					if(bestientöterBool==false){
						bestientöterBool=true;
						BuildaHQ.addToInformationVectorGlobal("DABestientöter", 1);
					}
				} else if(!o1.isSelected("Bestientöter von Caliban")) {
					if(bestientöterBool==true){
						bestientöterBool=false;
						BuildaHQ.addToInformationVectorGlobal("DABestientöter", -1);
					}
				}
				
				if(o4.isSelected("Leichentuch der Helden")){
					if(leichentuchBool==false){
						leichentuchBool=true;
						BuildaHQ.addToInformationVectorGlobal("DALeichtentuch", 1);
					}
				} else if(!o4.isSelected("Leichentuch der Helden")) {
					if(leichentuchBool==true){
						leichentuchBool=false;
						BuildaHQ.addToInformationVectorGlobal("DALeichtentuch", -1);
					}
				}
						
				if(o4.isSelected("Auge des Ungesehenen")){
					if(augeBool==false){
						augeBool=true;
						BuildaHQ.addToInformationVectorGlobal("DAAuge", 1);
					}
				} else if(!o4.isSelected("Auge des Ungesehenen")) {
					if(augeBool==true){
						augeBool=false;
						BuildaHQ.addToInformationVectorGlobal("DAAuge", -1);
					}
				}
				
				if(o4.isSelected("Skull of Petronella the Pious (GS)")){
					if(SkullofPetronella==false){
						SkullofPetronella=true;
						BuildaHQ.addToInformationVectorGlobal("SkullofPetronella", 1);
					}
				} else if(!o4.isSelected("Skull of Petronella the Pious (GS)")) {
					if(SkullofPetronella==true){
						SkullofPetronella=false;
						BuildaHQ.addToInformationVectorGlobal("SkullofPetronella", -1);
					}
				}
				
				if(o4.isSelected("Blade of the Worthy (GS)")){
					if(BladeoftheWorthy==false){
						BladeoftheWorthy=true;
						BuildaHQ.addToInformationVectorGlobal("BladeoftheWorthy", 1);
					}
				} else if(!o4.isSelected("Blade of the Worthy (GS)")) {
					if(BladeoftheWorthy==true){
						BladeoftheWorthy=false;
						BuildaHQ.addToInformationVectorGlobal("BladeoftheWorthy", -1);
					}
				}
				
				if(o4.isSelected("Castigator (GS)")){
					if(Castigator==false){
						Castigator=true;
						BuildaHQ.addToInformationVectorGlobal("Castigator", 1);
					}
				} else if(!o4.isSelected("Castigator (GS)")) {
					if(Castigator==true){
						Castigator=false;
						BuildaHQ.addToInformationVectorGlobal("Castigator", -1);
					}
				}
				
				if(o4.isSelected("The Font of Fury (GS)")){
					if(TheFontofFury==false){
						TheFontofFury=true;
						BuildaHQ.addToInformationVectorGlobal("TheFontofFury", 1);
					}
				} else if(!o4.isSelected("The Font of Fury (GS)")) {
					if(TheFontofFury==true){
						TheFontofFury=false;
						BuildaHQ.addToInformationVectorGlobal("TheFontofFury", -1);
					}
				}
				
				if(o4.isSelected("Shroud of the Anti-Martyr (GS)")){
					if(ShroudoftheAntiMartyr==false){
						ShroudoftheAntiMartyr=true;
						BuildaHQ.addToInformationVectorGlobal("ShroudoftheAntiMartyr", 1);
					}
				} else if(!o4.isSelected("Shroud of the Anti-Martyr (GS)")) {
					if(ShroudoftheAntiMartyr==true){
						ShroudoftheAntiMartyr=false;
						BuildaHQ.addToInformationVectorGlobal("ShroudoftheAntiMartyr", -1);
					}
				}
				//Desvalles's Holy Circle - 35
				if(o4.isSelected("Desvalles's Holy Circle (GS)")){
					if(DesvallessHolyCircle==false){
						DesvallessHolyCircle=true;
						BuildaHQ.addToInformationVectorGlobal("DesvallessHolyCircle", 1);
					}
				} else if(!o4.isSelected("Desvalles's Holy Circle (GS)")) {
					if(DesvallessHolyCircle==true){
						DesvallessHolyCircle=false;
						BuildaHQ.addToInformationVectorGlobal("DesvallessHolyCircle", -1);
					}
				}
						
				if(BuildaHQ.getCountFromInformationVectorGlobal("DASchnitter")>1 ||
						BuildaHQ.getCountFromInformationVectorGlobal("DAStimme")>1 ||
						BuildaHQ.getCountFromInformationVectorGlobal("DAStreitkolben")>1 ||
						BuildaHQ.getCountFromInformationVectorGlobal("DABestientöter")>1 ||
						BuildaHQ.getCountFromInformationVectorGlobal("DALeichtentuch")>1 ||
						BuildaHQ.getCountFromInformationVectorGlobal("DAAuge")>1 ||
						BuildaHQ.getCountFromInformationVectorGlobal("SkullofPetronella")>1 ||
						BuildaHQ.getCountFromInformationVectorGlobal("BladeoftheWorthy")>1 ||
						BuildaHQ.getCountFromInformationVectorGlobal("Castigator")>1 ||
						BuildaHQ.getCountFromInformationVectorGlobal("TheFontofFury")>1 ||
						BuildaHQ.getCountFromInformationVectorGlobal("ShroudoftheAntiMartyr")>1 ||
						BuildaHQ.getCountFromInformationVectorGlobal("DesvallessHolyCircle")>1) {
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
		
		if(entrySwitched){
			//Aktualisisert alle Einträge, auch die, welche diese Rüstkammer enthält.
			//Sonst werden dort zwar beim abwählen von Malen die Punkte korrekt berechnet, 
			//der Text aber nicht aktualisiert.
			RefreshListener.fireRefresh();
		}
	}
	
	@Override
	public void deleteYourself() {
		
		if(schnitterBool==true){
			schnitterBool=false;
			BuildaHQ.addToInformationVectorGlobal("DASchnitter", -1);
		}
					
		if(stimmeBool==true){
			stimmeBool=false;
			BuildaHQ.addToInformationVectorGlobal("DAStimme", -1);
		}
					
		if(streitkolbenBool==true){
			streitkolbenBool=false;
			BuildaHQ.addToInformationVectorGlobal("DAStreitkolben", -1);
		}
					
		if(bestientöterBool==true){
			bestientöterBool=false;
			BuildaHQ.addToInformationVectorGlobal("DABestientöter", -1);
		}
						
		if(leichentuchBool==true){
			leichentuchBool=false;
			BuildaHQ.addToInformationVectorGlobal("DALeichtentuch", -1);
		}
				
		if(augeBool==true){
			augeBool=false;
			BuildaHQ.addToInformationVectorGlobal("DAAuge", -1);
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
