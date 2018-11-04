package oc.wh40k.armies;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;
import oc.Formation;
import oc.FormationEntry;
import oc.RefreshListener;
import oc.Superformation;

public class VOLKGatheringStormIII extends BuildaVater {
	
	public VOLKGatheringStormIII() {
		reflectionKennung = "";
		
		HQeinträge = new String[] {"", ""};
		Eliteeinträge = new String[] {"", ""};
		Standardeinträge = new String[] {"", ""};
		Sturmeinträge = new String[] {"", ""};
		Unterstützungeinträge = new String[] {"", ""};
		LordofWar = new String[] {"", ""};
//        Formationen = new String[] {"", ""};
                
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 1, HQeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 2, Eliteeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 3, Standardeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 4, Sturmeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 5, Unterstützungeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,"FO", cnt, 0, 6, Befestigungen));
    	cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 7, LordofWar));
//        cnt += CHOOSERGRUPPEN_X_ABSTAND;
//        adden(new ChooserGruppe(this,"FORM", cnt, 0, 8, Formationen));
		cnt += 480;
			
		nameDerArtDerArmee = "Imperial Forces";
		nameDerArtDerArmeeDekliniert = "Imperial Forces";
		textAreaUeberschrift = BuildaHQ.translate("Meine") + " Imperial Forces";
		volk = "Imperial Forces";

		noAllies.clear();
		noAllies.add("MT");
		noAllies.add("AM");
		noAllies.add("ED");
		noAllies.add("AB");
		noAllies.add("DK");
		noAllies.add("DKAB");

		battleBrothers.add("AB");
		battleBrothers.add("AM");
		battleBrothers.add("AS");
		battleBrothers.add("BA");
		battleBrothers.add("CR");
		battleBrothers.add("DA");
		battleBrothers.add("DK");
		battleBrothers.add("DKAB");
		battleBrothers.add("ED");
		battleBrothers.add("GK");
		battleBrothers.add("IN");
		battleBrothers.add("IR");
		battleBrothers.add("MT");
		battleBrothers.add("SF");
		battleBrothers.add("SM");
		battleBrothers.add("TL");
		battleBrothers.add("SK");
		battleBrothers.add("DW");

		alliesOfConvenience.add("EL");
		alliesOfConvenience.add("HQ");

		desperateAllies.add("DE");
		desperateAllies.add("TA");
		desperateAllies.add("FE");
		desperateAllies.add("EC");
		
		comeTheApocalypse.add("BL");
		comeTheApocalypse.add("CD");
		comeTheApocalypse.add("CM");
		comeTheApocalypse.add("CS");
		comeTheApocalypse.add("DH");
		comeTheApocalypse.add("DM");
		comeTheApocalypse.add("NE");
		comeTheApocalypse.add("OR");
		comeTheApocalypse.add("RH");
		comeTheApocalypse.add("TY");
		comeTheApocalypse.add("SY");
		
		kontingente.add("");
		kontingente.add("");
		
		formationen.add("");
		formationen.add("Triumvirate Of The Primarch");
		formationen.add("Fallen Champions");
		formationen.add("Bulwark Of Purity");
		formationen.add("Victrix Guard");
		
		minAuswahlen.put("Triumvirate Of The Primarch",new int[] {2,0,0,0,0,0,1,0});
		maxAuswahlen.put("Triumvirate Of The Primarch",new int[] {2,0,0,0,0,0,1,0});
		
		minAuswahlen.put("Fallen Champions",new int[] {1,1,0,0,0,0,0,0});
		maxAuswahlen.put("Fallen Champions",new int[] {1,3,0,0,0,0,0,0});
		
		minAuswahlen.put("Bulwark Of Purity",new int[] {1,2,2,0,0,0,0,0});
		maxAuswahlen.put("Bulwark Of Purity",new int[] {1,2,2,0,0,0,0,0});
		
		minAuswahlen.put("Victrix Guard",new int[]{1,5,0,0,0,0,0,0});
		maxAuswahlen.put("Victrix Guard",new int[]{1,5,0,0,0,0,0,0});
					
		complete();
		
		//TODO: Ecclesiarchy Relics - Gathering Storm
		//Alle, die Celestine enthalten, und alle in "Castellans of the Imps" und "Wrathful Crusade"
		//Skull of Petronella the Pious - 30
		//Blade of the Worthy - 30 //replaces a melee weapon
		//Castigator - 15 
		//The Font of Fury - 10
		//Shroud of the Anti-Martyr - 35
		//Desvalles's Holy Circle - 35
		
//		formationBox.addItem("");
	}
	
	@Override
	public void refreshSupplements(){
	}
	
	public void changeFormations(){
		if(getCountFromInformationVector("Conclave Aquisitorius")>0){
			formationBox.addItem("Belisarius Cawl");
			
			minAuswahlen.put("Belisarius Cawl",new int[] {1,0,0,0,0,0,0,0});
			maxAuswahlen.put("Belisarius Cawl",new int[] {1,0,0,0,0,0,0,0});
		}
	}
	
	@Override
	public void volkRefresh() {
		
		if(getKontingentTyp().equals("Triumvirate Of The Primarch")){
			addToInformationVector("Triumvirate Of The Primarch", 1);
			
			clearCombo();
			
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Cypher", "Grand Master Voldus"});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{"", "Roboute Guilliman"});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Cypher"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Grand Master Voldus"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Roboute Guilliman"}, 1, 1));
			
			if(!isLoading){
				addUnit(HQ,"Cypher");
				addUnit(HQ,"Grand Master Voldus");
				addUnit(LOW,"Roboute Guilliman");
			}
			
		}else if(getKontingentTyp().equals("Fallen Champions")){
			addToInformationVector("Fallen Champions", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Cypher"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "SM Fallen"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Cypher"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"SM Fallen"}, 1, 3));
			
			if(!isLoading){
				addUnit(0,"Cypher");
				addUnit(1,"SM Fallen");

			}
			
			supplementBox.setEnabled(false);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("Bulwark Of Purity")){
			addToInformationVector("Bulwark Of Purity", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "GK Librarian"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "GK Paladin Squad"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "GK Terminator Squad"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"GK Librarian"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"GK Paladin Squad"}, 2, 2));
			formation.entries.add(new FormationEntry(new String[]{"GK Terminator Squad"}, 2, 2));
			
			if(!isLoading){
				addUnit(0,"GK Librarian");
				addUnit(1,"GK Paladin Squad");
				addUnit(1,"GK Paladin Squad");
				addUnit(2,"GK Terminator Squad");
				addUnit(2,"GK Terminator Squad");

			}
			
			supplementBox.setEnabled(false);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		} else if(getKontingentTyp().equals("Victrix Guard")){
			addToInformationVector("Victrix Guard", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "SM Captain Sicarius"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "SM Honour Guard", "SM Vanguard Veteran Squad", "SM Sternguard Veteran Squad"});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"SM Captain Sicarius"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"SM Honour Guard"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"SM Sternguard Veteran Squad", "SM Vanguard Veteran Squad"}, 4, 4));
			
			if(!isLoading){
				addUnit(0,"SM Captain Sicarius");
				addUnit(1,"SM Honour Guard");
				addUnitNotLocked(1,"SM Vanguard Veteran Squad");
				addUnitNotLocked(1,"SM Vanguard Veteran Squad");
				addUnitNotLocked(1,"SM Vanguard Veteran Squad");
				addUnitNotLocked(1,"SM Vanguard Veteran Squad");

			}
			
			supplementBox.setEnabled(false);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}

		if(formation!=null){
			formation.refreshControlPanel();
		}
		
		fillChooserSpace();
	}

	@Override
	protected void finalize() {
		LOGGER.info("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
	}

}