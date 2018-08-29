package oc.wh40k.armies;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKKhorneDaemonkin extends BuildaVater {
	
	public VOLKKhorneDaemonkin() {
		reflectionKennung = "KD";

		HQeinträge = new String[] {"", "Chaos Lord", "Daemon Prince", "Herald", "Blood Throne", "Skulltaker", "Bloodthirster Of Unfettered Fury",
				"Bloodthirster Of Insensate Rage", "Wrath Of Khorne Bloodthirster"};
		Eliteeinträge = new String[] {"", "Possessed", "Chaos Terminators", "Bloodcrushers"};
		Standardeinträge = new String[] {"", "Chaos Cultists", "Chaos Space Marines", "Berzerkers", "Bloodletters"};
		Sturmeinträge = new String[] {"", "Chaos Spawn", "Chaos Rhino", "Chaos Bikers", "Flesh Hounds", "Raptors", "Warp Talons", "Heldrake"};
		Unterstützungeinträge = new String[] {"", "Chaos Land Raider", "Forgefiend", "Maulerfiend", "Defiler", "Soul Grinder", "Helbrute", "Skull Cannon"};
		LordofWar = new String[] {"", "Lord Of Skulls",
							      "", "[IA Experimental] Chaos Knight Paladin", "[IA Experimental] Chaos Knight Errant", "[IA Experimental] Kytan Daemon Engine of Khorne",};
        
        /**LoW
			Schädelherrscher des Khorne GW: Apoc
         	Chaos Reaver Battle Titan IA: Apoc
			Chaos Warhound Titan IA: Apoc
			Chaos Space Marine Thunderhawk Gunship IA: Apoc
			Greater Brass Scorpion of Khorne IA: Apoc
         */
        
        /*		
			
			CULT OF DESTRUCTION
			1 + Obliterator units
			1 + Mutilator units
			FORMATION RESTRICTIONS
			Each unit must consist of three models.
			
			HELDRAKE FEAR SQUADRON
			3-5 Heldrakes
			
			LEGIONNAIRE WARBAND
			1 Chaos Lord
			3 + Troops units
			2 + Elites units
			Any number of units
			from the following:
			- HQ
			- Fast attack
			- Heavy support
			FORMATION RESTRICTIONS
			All models in the Legionnaire Warband must have the Veterans of the Long War upgrade. If the Chaos Lord
			has a Mark of Chaos, all other units that are able to, must have the same Mark of Chaos as the Chaos Lord

			LORDS OF THE BLACK CRUSADE ?? Nochmal mit Bildern ansehn
			Abaddon the Despoiler
			1 Chaos Lord with the Mark of Khorne or Kharn the Betrayer
			1 Chaos Sorcerer with the Mark of Tzeentch or Ahriman
			1 Chaos Lord with Mark of Slaanesh or Lucius the Eternal
			
			THE LOST AND THE DAMNED
			1 + Dark Apostle
			6+ units of Chaos Cultists
			
			THOUSAND SONS WAR COVEN
			1 Chaos Sorcerer (Mastery Level 3) or Ahriman
			3 + Chaos Sorcerers (Mastery Level 1)

'			TIDE OF SPAWN
			5+ Chaos Spawn
			
			COHORT OF BLOOD
			Skull taker
			1 + Heralds of Khorne
			8 units of Bloodletters of Khorne
			FORMATION RESTRICTIONS
			Each of the Bloodletter units must have eight models.
			
			THE FLAMING HOST OF TZEENTCH
			1 Herald of Tzeentch or the Changeling
			9 units, in any combination, from the following:
			Pink Horrors of Tzeentch
			Flamers of Tzeentch
			Burning Chariot of Tzeentch
			
			THE GREAT PROMENADE OF EXQUISITE EXCESS
			The Masque of Slaanesh
			6 units, in any combination, from the following:
			Daemonettes of Slaanesh
			Seekers of Slaanesh
			
			THE TALLYMEN OF NURGLE
			Epidemius the Tallyman
			7 units, in any combination,from the following:
			Plague bearers of Nurgle
			Plague Drones of Nurgle
			
			TETRAGON OF DARKNESS
			1 Bloodthirster
			1 Lord of Change
			1 Great Unclean One
			1 Keeper of Secrets
			1 unit of Bloodletters of Khorne
			1 unit of Pink Horrors of Tzeentch
			1 unit of Plague bearers of Nurgle
			1 unit of Daemonettes of Slaanesh
		*/
        
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
        
		cnt += 480;
		
		nameDerArtDerArmee = "Khorne Daemonkin";
		nameDerArtDerArmeeDekliniert = "Khorne Daemonkin";
		textAreaUeberschrift = BuildaHQ.translate("Meine") + " Khorne Daemonkin";

		noAllies.clear();
		noAllies.add("RH");
		noAllies.add("CS");
		noAllies.add("CM");
		noAllies.add("BL");
		noAllies.add("EC");
		
		battleBrothers.add("RH");
		battleBrothers.add("CS");
		battleBrothers.add("CM");
		battleBrothers.add("BL");
		battleBrothers.add("CD");
		battleBrothers.add("CM");
		
		alliesOfConvenience.add("NE");
		alliesOfConvenience.add("OR");
		alliesOfConvenience.add("DM");
		alliesOfConvenience.add("DH");
		
		desperateAllies.add("DE");
		desperateAllies.add("TA");
		desperateAllies.add("FE");
		
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
		comeTheApocalypse.add("EL");
		comeTheApocalypse.add("TY");
		comeTheApocalypse.add("HQ");
		comeTheApocalypse.add("SY");
		comeTheApocalypse.add("DW");
		

		//Formationen
		formationen.add("Slaughtercult");
		formationen.add("Brazen Onslaught");
		formationen.add("Khornes Bloodstorm");
		formationen.add("Gorepack");
		formationen.add("Charnel Cohort");
		formationen.add("Lord of Slaughter");
		formationen.add("War Engine");
		
		int[] arr1 = {1,1,2,0,0,0,0,0};
		minAuswahlen.put("Slaughtercult",arr1);
		int[] arr2 = {1,4,10,2,0,0,0,0};
		maxAuswahlen.put("Slaughtercult",arr2);
		
		int[] arr3 = {0,3,0,0,0,0,0,0};
		minAuswahlen.put("Brazen Onslaught",arr3);
		int[] arr4 = {0,8,0,0,0,0,0,0};
		maxAuswahlen.put("Brazen Onslaught",arr4);
		
		int[] arr5 = {0,0,0,3,0,0,0,0};
		minAuswahlen.put("Khornes Bloodstorm",arr5);
		int[] arr6 = {0,0,0,9,0,0,0,0};
		maxAuswahlen.put("Khornes Bloodstorm",arr6);
	
		int[] arr7 = {0,0,0,3,0,0,0,0};
		minAuswahlen.put("Gorepack",arr7);
		int[] arr8 = {0,0,0,8,0,0,0,0};
		maxAuswahlen.put("Gorepack",arr8);

		int[] arr9 = {1,1,2,1,0,0,0,0};
		minAuswahlen.put("Charnel Cohort",arr9);
		int[] arr10 = {1,4,8,4,4,0,0,0};
		maxAuswahlen.put("Charnel Cohort",arr10);
		
		minAuswahlen.put("Lord of Slaughter",new int[] {1,0,0,0,0,0,0,0});
		maxAuswahlen.put("Lord of Slaughter",new int[] {1,0,0,0,0,0,0,0});
		
		minAuswahlen.put("War Engine",new int[] {0,0,0,0,1,0,0,0});
		maxAuswahlen.put("War Engine",new int[] {0,0,0,0,1,0,0,0});
		
		complete();
	}
	
	@Override
	public void volkRefresh() {
		
		if(getKontingentTyp().contains("Slaughtercult")){
			setInformationVectorValue("Slaughtercult", 1);
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Chaos Lord", "Daemon Prince", 
					   "Herald", "Blood Throne", "Bloodthirster Of Unfettered Fury", "Skulltaker"});//1
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Possessed"});//1-4
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Chaos Space Marines", "Berzerkers", "Bloodletters", "Chaos Cultists"});//2-8
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Chaos Spawn"});//0-2
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});	
		}
		else if(getKontingentTyp().contains("Brazen Onslaught")){
			setInformationVectorValue("Brazen Onslaught", 1);
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Chaos Terminators", "Bloodcrushers"});//1-4
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});	
			if(!isLoading){
				addUnit(1,"Chaos Terminators");
				addUnit(1,"Bloodcrushers");
				addUnit(1,"Bloodcrushers");
			}
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}
		else if(getKontingentTyp().contains("Khornes Bloodstorm")){
			setInformationVectorValue("Khornes Bloodstorm", 1);
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Raptors", "Warp Talons", "Heldrake"});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			if(!isLoading){
				addUnit(3,"Raptors");
				addUnit(3,"Raptors");
				addUnit(3,"Warp Talons");
			}
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}
		else if(getKontingentTyp().contains("Gorepack")){
			setInformationVectorValue("Gorepack", 1);
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Chaos Bikers", "Flesh Hounds"});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			if(!isLoading){
				addUnit(3,"Chaos Bikers");
				addUnit(3,"Chaos Bikers");
				addUnit(3,"Flesh Hounds");
			}
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}
		else if(getKontingentTyp().contains("Charnel Cohort")){
			setInformationVectorValue("Charnel Cohort", 1);
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Daemon Prince", "Herald", "Blood Throne", "Skulltaker"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Bloodcrushers"});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Bloodletters"});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Flesh Hounds"});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Skull Cannons"});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			if(!isLoading){
				addUnit(2,"Bloodletters");
				addUnit(2,"Bloodletters");
				addUnit(3,"Flesh Hounds");
				addUnit(1,"Bloodcrushers");
			}
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}
		else if(getKontingentTyp().contains("Lord of Slaughter")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Bloodthirster Of Unfettered Fury",
					"Bloodthirster Of Insensate Rage", "Wrath Of Khorne Bloodthirster", "Lord Of Skulls"});//0-1
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
		}
		else if(getKontingentTyp().contains("War Engine")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Forgefiend", "Maulerfiend", "Defiler", "Soul Grinder", "Helbrute", "Lord Of Skulls"});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});	
		}
		
		fillChooserSpace();
	}

	@Override
	protected void finalize() {
		System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
	}

}