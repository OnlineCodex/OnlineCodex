package oc.wh40k.armies;




import java.io.InputStream;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;
import oc.Formation;
import oc.FormationEntry;
import oc.RefreshListener;
import oc.Superformation;

public class VOLKChaosdaemons extends BuildaVater {

	public VOLKChaosdaemons() {
		
		reflectionKennung = "CD";
		
		InputStream is = this.getClass().getResourceAsStream("/oc/wh40k/indices/cd.csv");
		pointValues = BuildaHQ.loadindexFile(is);
		
		HQeinträge = new String[] {"", "Karanak", "Skarbrand", "Skulltaker", "Bloodthirster of Insensate Rage", "Bloodthirster of Unfettered Fury", "Wrath of Khorne Bloodthirster",
									"Herald of Khorne", "Herald of Khorne on Blood Throne", "Herald of Khorne on Juggernaut", "", "Kairos Fateweaver", "The Changeling", "The Blue Scribes",
									"Lord of Change", "Herald of Tzeentch", "Herald of Tzeentch on Disc", "Herald of Tzeentch on Burning Chariot",
									"", "Epidemius", "Great Unclean One", "Herald of Nurgle", "", "The Masque of Slaanesh", "Keeper of Secrets", "Herald of Slaanesh", "Herald of Slaanesh on Steed",
									"Herald of Slaanesh on Seeker Chariot", "Herald of Slaanesh on Exalted Seeker Chariot", "", "Be'lakor", "Daemon Prince of Chaos", "Daemon Prince of Chaos with Wings"};
		Eliteeinträge = new String[] {"", "Bloodcrushers", "", "Flamers", "Exalted Flamer", "", "Beasts of Nurgle", "", "Fiends of Slaanesh"};
		Standardeinträge = new String[] {"", "Bloodletters", "", "Horrors", "", "Plaguebearers", "Nurglings", "", "Daemonettes"};
		Sturmeinträge = new String[] {"", "Flesh Hounds", "", "Screamers", "", "Plague Drones", "", "Hellflayer", "Seekers", "", "Chaos Furies"};
		Unterstützungeinträge = new String[] {"", "Skull Cannon", "", "Burning Chariot", "", "Seeker Chariot", "Exalted Seeker Chariot", "", "Soulgrinder"};
		LordofWar = new String[] {""};

		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 1, HQeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 2, Standardeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 3, Eliteeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 4, Sturmeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 5, Unterstützungeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,"FO", cnt, 0, 6, Befestigungen));
    	cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 7, LordofWar));
        cnt += 480;

		nameDerArtDerArmee = "Chaosdämonen";
		nameDerArtDerArmeeDekliniert = "Chaosdämonen";
		textAreaUeberschrift = BuildaHQ.translate("Meine") + " Chaosdämonen";

		noAllies.clear();
		noAllies.add("CD");
		noAllies.add("EC");


		battleBrothers.add("CD");
		battleBrothers.add("BL");
		battleBrothers.add("CM");
		battleBrothers.add("CS");
		battleBrothers.add("RH");
		battleBrothers.add("KD");

		desperateAllies.add("DE");
		desperateAllies.add("DM");
		desperateAllies.add("OR");
		
		comeTheApocalypse.add("AB");
		comeTheApocalypse.add("AM");
		comeTheApocalypse.add("AS");
		comeTheApocalypse.add("BA");
		comeTheApocalypse.add("CR");
		comeTheApocalypse.add("DA");
		comeTheApocalypse.add("DK");
		comeTheApocalypse.add("DKAB");
		comeTheApocalypse.add("ED");
		comeTheApocalypse.add("GK");
		comeTheApocalypse.add("IN");
		comeTheApocalypse.add("IR");
		comeTheApocalypse.add("MT");
		comeTheApocalypse.add("SF");
		comeTheApocalypse.add("SM");
		comeTheApocalypse.add("TL");
		comeTheApocalypse.add("DH");
		comeTheApocalypse.add("EL");
		comeTheApocalypse.add("FE");
		comeTheApocalypse.add("NE");
		comeTheApocalypse.add("TA");
		comeTheApocalypse.add("TY");
		comeTheApocalypse.add("HQ");
		comeTheApocalypse.add("SY");
		comeTheApocalypse.add("DW");
		
		//Verschiedene Spezialkontingente
		kontingente.add("");
		kontingente.add("Daemonic Incursion Detachment (CotW)");
		kontingente.add("Daemon Legions of Tzeentch");
		
		//Formationen
		formationen.add("Formation");
		formationen.add("");
		formationen.add("Murderhorde (CotW)");
		formationen.add("Gorethunder Battery (CotW)");
		formationen.add("Warpflame Host (CotW)");
		formationen.add("Burning Skyhost (CotW)");
		formationen.add("Tallyband (CotW)");
		formationen.add("Rotswarm (CotW)");
		formationen.add("Flayertroupe (CotW)");
		formationen.add("Grand Cavalcade (CotW)");
		formationen.add("Infernal Tetrad (CotW)");
		formationen.add("Forgehost (CotW)");
		formationen.add("Brimstone Conflagration");
		formationen.add("Omniscient Oracles");
		formationen.add("Heralds Anarchic");
		formationen.add("Lorestealer Host");
		
		//Min/max-Auswahlen je Spezialkontingent
		minAuswahlen.put("Daemonic Incursion Detachment (CotW)", new int[] {0,0,0,0,0,0,0,0});
		maxAuswahlen.put("Daemonic Incursion Detachment (CotW)", new int[] {0,0,0,0,0,0,0,0});
		
		minAuswahlen.put("Murderhorde (CotW)", new int[] {1,0,0,0,0,0,0,0});
		maxAuswahlen.put("Murderhorde (CotW)", new int[] {1,8,8,8,0,0,0,0});
		
		minAuswahlen.put("Gorethunder Battery (CotW)", new int[] {1,0,0,0,3,0,0,0});
		maxAuswahlen.put("Gorethunder Battery (CotW)", new int[] {1,0,0,0,3,0,0,0});
		
		minAuswahlen.put("Warpflame Host (CotW)", new int[] {1,0,0,0,0,0,0,0});
		maxAuswahlen.put("Warpflame Host (CotW)", new int[] {10,9,9,0,0,0,0,0});
		
		minAuswahlen.put("Burning Skyhost (CotW)", new int[] {1,0,0,0,0,0,0,0});
		maxAuswahlen.put("Burning Skyhost (CotW)", new int[] {1,0,0,9,9,0,0,0});
		
		minAuswahlen.put("Tallyband (CotW)", new int[] {1,0,7,0,0,0,0,0});
		maxAuswahlen.put("Tallyband (CotW)", new int[] {1,0,7,0,0,0,0,0});
		
		minAuswahlen.put("Rotswarm (CotW)", new int[] {1,0,0,0,0,0,0,0});
		maxAuswahlen.put("Rotswarm (CotW)", new int[] {1,7,0,7,0,0,0,0});
		
		minAuswahlen.put("Flayertroupe (CotW)", new int[] {1,0,0,0,0,0,0,0});
		maxAuswahlen.put("Flayertroupe (CotW)", new int[] {1,6,6,0,0,0,0,0});
		
		minAuswahlen.put("Grand Cavalcade (CotW)", new int[] {1,0,0,0,0,0,0,0});
		maxAuswahlen.put("Grand Cavalcade (CotW)", new int[] {1,0,0,6,6,0,0,0});
		
		minAuswahlen.put("Infernal Tetrad (CotW)", new int[] {4,0,0,0,0,0,0,0});
		maxAuswahlen.put("Infernal Tetrad (CotW)", new int[] {4,0,0,0,0,0,0,0});
		
		minAuswahlen.put("Forgehost (CotW)", new int[] {0,0,0,0,3,0,0,0});
		maxAuswahlen.put("Forgehost (CotW)", new int[] {0,0,0,0,3,0,0,0});
		
		minAuswahlen.put("Brimstone Conflagration", new int[] {1,0,3,0,0,0,0,0});
		maxAuswahlen.put("Brimstone Conflagration", new int[] {1,0,9,0,0,0,0,0});
		
		minAuswahlen.put("Omniscient Oracles", new int[] {2,0,0,0,0,0,0,0});
		maxAuswahlen.put("Omniscient Oracles", new int[] {4,0,0,0,0,0,0,0});
		
		minAuswahlen.put("Heralds Anarchic", new int[] {1,0,0,0,0,0,0,0});
		maxAuswahlen.put("Heralds Anarchic", new int[] {9,0,0,0,0,0,0,0});
		
		minAuswahlen.put("Lorestealer Host", new int[] {1,0,3,0,0,0,0,0});
		maxAuswahlen.put("Lorestealer Host", new int[] {1,0,9,0,0,0,0,0});
		
		complete();
	}

	public void changeFormations(){
		if(getCountFromInformationVector("CWD")>0){
			
			formationBox.addItem("Daemon Lord (CotW)");
			formationBox.addItem("Daemon Flock (CotW)");
			formationBox.addItem("Hunter of Khorne (CotW)");

			minAuswahlen.put("Daemon Lord (CotW)", new int[] {1,0,0,0,0,0,0,0});
			maxAuswahlen.put("Daemon Lord (CotW)", new int[] {1,0,0,0,0,0,0,0});
			
			minAuswahlen.put("Daemon Flock (CotW)", new int[] {0,0,0,1,0,0,0,0});
			maxAuswahlen.put("Daemon Flock (CotW)", new int[] {0,0,0,1,0,0,0,0});
			
			minAuswahlen.put("Hunter of Khorne (CotW)", new int[] {1,0,0,0,0,0,0,0});
			maxAuswahlen.put("Hunter of Khorne (CotW)", new int[] {1,0,0,0,0,0,0,0});
		}
		
		if(getCountFromInformationVector("DLT")>0){
			
			formationBox.addItem("Lord of Pandemonium");
			formationBox.addItem("Agents of Tzeentch");

			minAuswahlen.put("Lord of Pandemonium", new int[] {1,0,0,0,0,0,0,0});
			maxAuswahlen.put("Lord of Pandemonium", new int[] {1,0,0,0,0,0,0,0});

			minAuswahlen.put("Agents of Tzeentch", new int[] {1,0,0,0,0,0,0,0});
			maxAuswahlen.put("Agents of Tzeentch", new int[] {1,0,0,0,0,0,0,0});
		}
	}
	
	@Override
  	public void volkRefresh() {
		setInformationVectorValue("Burning Skyhost (CotW)", 0);
		setInformationVectorValue("Gorethunder Battery (CotW)", 0);

    	if(getKontingentTyp().equals("Daemonic Incursion Detachment (CotW)")){ //Superformation))
    		setInformationVectorValue("CWD", 1);
			superformation = new Superformation(getPanel(), 0);
			superformation.reflectionKennungLokal=reflectionKennungLokal;
			superformation.volkFile=getClass().getName();
			superformation.tA=buildatextArea;
			superformation.buildaVater=this;
			
			superformation.minCommand=0;
			superformation.maxCommand=4;
			superformation.minCore=1;
			superformation.maxCore=Integer.MAX_VALUE;
			superformation.minAuxiliary=1;
			superformation.maxAuxiliary=Integer.MAX_VALUE;
			
			superformation.namenCommand.add("");
			superformation.namenCommand.add("Daemon Lord (CotW)");
			superformation.namenCommand.add("Infernal Tetrad (CotW)");
			
			superformation.namenCore.add("");
			superformation.namenCore.add("Murderhorde (CotW)");
			superformation.namenCore.add("Warpflame Host (CotW)");
			superformation.namenCore.add("Tallyband (CotW)");
			superformation.namenCore.add("Flayertroupe (CotW)");
			
			superformation.namenAuxiliary.add("");
			superformation.namenAuxiliary.add("Gorethunder Battery (CotW)");
			superformation.namenAuxiliary.add("Burning Skyhost (CotW)");
			superformation.namenAuxiliary.add("Rotswarm (CotW)");
			superformation.namenAuxiliary.add("Grand Cavalcade (CotW)");
			superformation.namenAuxiliary.add("Forgehost (CotW)");
			superformation.namenAuxiliary.add("Daemon Flock (CotW)");
			superformation.namenAuxiliary.add("Hunter of Khorne (CotW)");
			
			for(int i=0;i<myChooserGruppen.size();i++){
				myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
			}
			
			superformation.refreshControlPanel();
			
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
			
			RefreshListener.fireRefresh();
		}
    	
    	if(getKontingentTyp().equals("Daemon Legions of Tzeentch")){ //Superformation))
    		setInformationVectorValue("DLT", 1);
			superformation = new Superformation(getPanel(), 0);
			superformation.reflectionKennungLokal=reflectionKennungLokal;
			superformation.volkFile=getClass().getName();
			superformation.tA=buildatextArea;
			superformation.buildaVater=this;
			
			superformation.minCommand=0;
			superformation.maxCommand=4;
			superformation.minCore=1;
			superformation.maxCore=Integer.MAX_VALUE;
			superformation.minAuxiliary=1;
			superformation.maxAuxiliary=Integer.MAX_VALUE;
			
			superformation.namenCommand.add("");
			superformation.namenCommand.add("Lord of Pandemonium");
			superformation.namenCommand.add("Omniscient Oracles");
			
			superformation.namenCore.add("");
			superformation.namenCore.add("Warpflame Host (CotW)");
			superformation.namenCore.add("Lorestealer Host");
			
			superformation.namenAuxiliary.add("");
			superformation.namenAuxiliary.add("Agents of Tzeentch");
			superformation.namenAuxiliary.add("Forgehost (CotW)");
			superformation.namenAuxiliary.add("Burning Skyhost (CotW)");
			superformation.namenAuxiliary.add("Brimstone Conflagration");
			superformation.namenAuxiliary.add("Heralds Anarchic");
			
			for(int i=0;i<myChooserGruppen.size();i++){
				myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
			}
			
			superformation.refreshControlPanel();
			
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
			
			RefreshListener.fireRefresh();
		}
		
		if(getKontingentTyp().equals("Murderhorde (CotW)")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Herold des Khorne", "Schädelsammler"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Zerschmetterer des Khorne"});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Zerfleischer des Khorne"});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Bluthunde des Khorne"});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Herold des Khorne"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Zerfleischer des Khorne", "Bluthunde des Khorne", "Zerschmetterer des Khorne"}, 8, 8));
			
			if(!isLoading){
				addUnitNotLocked(0,"Herold des Khorne");
			}
		}
		
		if(getKontingentTyp().equals("Gorethunder Battery (CotW)")){
			setInformationVectorValue("Gorethunder Battery (CotW)", 1);
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Herold des Khorne"});//Restrictions: The Herald of Khorne must take a Blood Throne of Khorne as a Dedicated Transport. 
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Schaedelkanone des Khorne"});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Herold des Khorne"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Schaedelkanone des Khorne"}, 3, 3));
			
			if(!isLoading){
				addUnitNotLocked(0,"Herold des Khorne");
				addUnitNotLocked(4,"Schaedelkanone des Khorne");
				addUnitNotLocked(4,"Schaedelkanone des Khorne");
				addUnitNotLocked(4,"Schaedelkanone des Khorne");
			}
		}
		
		if(getKontingentTyp().equals("Warpflame Host (CotW)")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Herold des Tzeentch", "Der Wechselbalg", "Exalted Flamer of Tzeentch"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Feuerdämonen des Tzeentch"});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Pink Horrors"});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Herold des Tzeentch", "Der Wechselbalg"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Pink Horrors", "Feuerdämonen des Tzeentch", "Exalted Flamer of Tzeentch"}, 9, 9));
			
			if(!isLoading){
				addUnitNotLocked(0,"Herold des Tzeentch");
			}
		}
				
		if(getKontingentTyp().equals("Burning Skyhost (CotW)")){//Restrictions: The Herald of Tzeentch must take a Disc of Tzeentch or Burning Chariot of Tzeentch.
			setInformationVectorValue("Burning Skyhost (CotW)", 1);
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Herold des Tzeentch", "Die Blauen Gelehrten"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Kreischer des Tzeentch"});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Brennender Streitwagen"});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Herold des Tzeentch", "Die Blauen Gelehrten"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Kreischer des Tzeentch", "Brennender Streitwagen"}, 9, 9));
			
			if(!isLoading){
				addUnitNotLocked(0,"Herold des Tzeentch");
			}
		}
		
		if(getKontingentTyp().equals("Tallyband (CotW)")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Herold des Nurgle", "Epidemius"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Seuchenhüter des Nurgle", "Nurglings"});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Herold des Nurgle", "Epidemius"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Seuchenhüter des Nurgle", "Nurglings"}, 7, 7));
			
			if(!isLoading){
				addUnitNotLocked(0,"Herold des Nurgle");
			}
		}
		
		if(getKontingentTyp().equals("Rotswarm (CotW)")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Herold des Nurgle"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Schleimbestien des Nurgle"});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"","Seuchendrohnen"});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Herold des Nurgle"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Seuchendrohnen", "Schleimbestien des Nurgle"}, 7, 7));
			
			if(!isLoading){
				addUnitNotLocked(0,"Herold des Nurgle");
			}
		}
		
		if(getKontingentTyp().equals("Flayertroupe (CotW)")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Herold des Slaanesh", "Die Maske"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"","Slaaneshbestien"});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Dämonetten des Slaanesh"});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Herold des Slaanesh", "Die Maske"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Dämonetten des Slaanesh", "Slaaneshbestien"}, 6, 6));
			
			if(!isLoading){
				addUnitNotLocked(0,"Herold des Slaanesh");
			}
		}
		
		
		if(getKontingentTyp().equals("Grand Cavalcade (CotW)")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Herold des Slaanesh"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Jägerinnen des Slaanesh", "Höllenschinder des Slaanesh"});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Jagdkavalkade"});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Herold des Slaanesh"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Jägerinnen des Slaanesh", "Höllenschinder des Slaanesh", "Jagdkavalkade"}, 6, 6));
			
			if(!isLoading){
				addUnitNotLocked(0,"Herold des Slaanesh");
			}
		}
		
		if(getKontingentTyp().equals("Infernal Tetrad (CotW)")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Dämonenprinz des Khorne","Dämonenprinz des Nurgle","Dämonenprinz des Slaanesh","Dämonenprinz des Tzeentch"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Dämonenprinz des Khorne"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Dämonenprinz des Nurgle"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Dämonenprinz des Slaanesh"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Dämonenprinz des Tzeentch"}, 1, 1));
			
			if(!isLoading){
				addUnitNotLocked(0,"Dämonenprinz des Khorne");
				addUnitNotLocked(0,"Dämonenprinz des Nurgle");
				addUnitNotLocked(0,"Dämonenprinz des Slaanesh");
				addUnitNotLocked(0,"Dämonenprinz des Tzeentch");
			}
		}
		
		if(getKontingentTyp().equals("Forgehost (CotW)")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"","Seelenzermalmer"});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Seelenzermalmer"}, 3, 3));
			
			if(!isLoading){
				addUnitNotLocked(4,"Seelenzermalmer");
				addUnitNotLocked(4,"Seelenzermalmer");
				addUnitNotLocked(4,"Seelenzermalmer");
			}
		}
		
		if(getKontingentTyp().equals("Daemon Lord (CotW)")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"","Bloodthirster Of Unfettered Fury", "Bloodthirster Of Insensate Rage", "Wrath Of Khorne Bloodthirster", 
																		    "Skarbrand", "Schicksalsweber, Orakel des Tzeentch", "Ku'gath, der Seuchenvater", "Großer Verpester", "Herrscher des Wandels", 
																		    "Hüter der Geheimnisse", "Be'lakor", "Dämonenprinz des Khorne","Dämonenprinz des Nurgle","Dämonenprinz des Slaanesh",
																		    "Dämonenprinz des Tzeentch"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Bloodthirster Of Unfettered Fury", "Bloodthirster Of Insensate Rage", "Wrath Of Khorne Bloodthirster", 
				    "Skarbrand", "Schicksalsweber, Orakel des Tzeentch", "Ku'gath, der Seuchenvater", "Großer Verpester", "Herrscher des Wandels", 
				    "Hüter der Geheimnisse", "Be'lakor", "Dämonenprinz des Khorne","Dämonenprinz des Nurgle","Dämonenprinz des Slaanesh",
				    "Dämonenprinz des Tzeentch"}, 1, 1));
			
			if(!isLoading){
				addUnitNotLocked(0,"Bloodthirster Of Unfettered Fury");
			}
		}	

		if(getKontingentTyp().equals("Daemon Flock (CotW)")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Chaosfurien"});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Chaosfurien"}, 1, 1));
			
			if(!isLoading){
				addUnitNotLocked(3,"Chaosfurien");
			}
		}
		
    	if(getKontingentTyp().equals("Hunter of Khorne (CotW)")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Karanak"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Karanak"}, 1, 1));
			
			if(!isLoading){
				addUnitNotLocked(0,"Karanak");
			}
		}
    	
    	if(getKontingentTyp().equals("Brimstone Conflagration")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Exalted Flamer of Tzeentch"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Brimstone Horrors"});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Exalted Flamer of Tzeentch"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Brimstone Horrors"}, 3, 9));
			
			if(!isLoading){
				addUnit(0,"Exalted Flamer of Tzeentch");
				addUnit(2,"Brimstone Horrors");
				addUnit(2,"Brimstone Horrors");
				addUnit(2,"Brimstone Horrors");
			}
		}
    	
    	if(getKontingentTyp().equals("Omniscient Oracles")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Schicksalsweber, Orakel des Tzeentch",  "Herrscher des Wandels"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Schicksalsweber, Orakel des Tzeentch"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Herrscher des Wandels"}, 1, 3));
			
			if(!isLoading){
				addUnit(0,"Schicksalsweber, Orakel des Tzeentch");
				addUnit(0,"Herrscher des Wandels");
			}
		}
    	
    	if(getKontingentTyp().equals("Heralds Anarchic")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Herold des Tzeentch"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Herold des Tzeentch"}, 3, 9));
			
			if(!isLoading){
				addUnit(0,"Herold des Tzeentch");
				addUnit(0,"Herold des Tzeentch");
				addUnit(0,"Herold des Tzeentch");
			}
		}
		
    	if(getKontingentTyp().equals("Lorestealer Host")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Die Blauen Gelehrten"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Blue Horrors"});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Die Blauen Gelehrten"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Blue Horrors"}, 3, 9));
			
			if(!isLoading){
				addUnit(0,"Die Blauen Gelehrten");
				addUnit(2,"Blue Horrors");
				addUnit(2,"Blue Horrors");
				addUnit(2,"Blue Horrors");
			}
		}
    	
    	if(getKontingentTyp().equals("Lord of Pandemonium")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Schicksalsweber, Orakel des Tzeentch", "Herrscher des Wandels", "Herold des Tzeentch", "Dämonenprinz des Tzeentch"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Schicksalsweber, Orakel des Tzeentch"}, 0, 1));
			formation.entries.add(new FormationEntry(new String[]{"Herrscher des Wandels"}, 0, 1));
			formation.entries.add(new FormationEntry(new String[]{"Herold des Tzeentch"}, 0, 1));
			formation.entries.add(new FormationEntry(new String[]{"Dämonenprinz des Tzeentch"}, 0, 1));
			
			if(!isLoading){
				addUnitNotLocked(0,"Schicksalsweber, Orakel des Tzeentch");
			}
		}
    	
    	if(getKontingentTyp().equals("Agents of Tzeentch")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Der Wechselbalg", "Die Blauen Gelehrten"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Der Wechselbalg"}, 0, 1));
			formation.entries.add(new FormationEntry(new String[]{"Die Blauen Gelehrten"}, 0, 1));
			
			if(!isLoading){
				addUnitNotLocked(0,"Der Wechselbalg");
			}
		}
    	
		if(formation!=null){
			formation.refreshControlPanel();
		}
		
		fillChooserSpace();
    }
	
	@Override
	protected void finalize() {
		System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
	}

}