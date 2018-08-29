package oc.wh40k.armies;

import java.io.InputStream;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;
import oc.Formation;
import oc.FormationEntry;
import oc.RefreshListener;
import oc.Superformation;

public class VOLKChaos extends BuildaVater {


	/*
	 * Chaos Space Marines
	 */
	
	public String[] HQeinträge_Chaos_Space_Marines = new String[]{"", "Legion", "", "Abaddon the Despoiler", "Huron Blackheart", "Cypher", "Fabius Bile", "Kharn the Betrayer",
				"Lucius the Eternal", "Chaos Lord", "Chaos Lord in Terminator Armour", "Chaos Lord on Bike", "Chaos Lord on Juggernaut of Khorne", "Chaos Lord on Disc of Tzeentch",
				"Chaos Lord on Palanquin of Nurgle", "Chaos Lord on Steed of Slaanesh", "Dark Apostle", "Exalted Champion", "Daemon Prince of Chaos CSM", "Daemon Prince of Chaos with Wings CSM",
				"Sorcerer", "Sorcerer in Terminator Armour", "Sorcerer on Bike", "Sorcerer on Disc of Tzeentch", "Sorcerer on Palanquin of Nurgle", "Sorcerer on Steed of Slaanesh", 
				"Warpsmith", "Lord of Contagion", "Malignant Plaguecaster", "", "Zhufor The Impaler", "Lord Arkos", "Chaos Hellwright", "Chaos Hellwright On Dark Abeyant", "Uraka The Warfiend", "Samus", "Mamon Transfigured", "Corbax Utterblight"};
	public String[] Eliteeinträge_Chaos_Space_Marines = new String[]{"", "Fallen", "Chaos Terminators", "Khorne Berzerkers", "Rubric Marines", "Plague Marines CSM", "Noise Marines", "Chosen", "Possessed", "Helbrute", "Mutilators", "", "Chaos Decimator", "Hellforged Contemptor Dreadnought"};
	public String[] Standardeinträge_Chaos_Space_Marines = new String[]{"", "Chaos Space Marines", "Chaos Cultists", "Tzaangors", "Poxwalkers", "Bloodletters", "Horrors", "Plaguebearers", "Daemonettes"};
	public String[] Sturmeinträge_Chaos_Space_Marines = new String[]{"", "Chaos Bikers", "Raptors", "Warp Talons", "Chaos Spawn", "", "Blood Slaughterer of Khorne", "Greater Blight Drone", "Hellforged Dreadclaw Drop Pod", "Hellforged Kharybdis Assault Claw", "Plague Toads Of Nurgle", "Pox Riders Of Nurgle"};
	public String[] Unterstützungseinträge_Chaos_Space_Marines = new String[]{"", "Chaos Land Raider", "Chaos Predator", "Chaos Vindicator", "Obliterators", "Havocs", "Forgefiend", "Maulerfiend", "Defiler", "", "Plague Hulk Of Nurgle", 
			"Hellforged Land Raider Proteus", "Hellforged Land Raider Achilles", "Hellforged Predator", "Hellforged Scorpius", "Hellforged Sicarian", "Hellforged Sicarian Venator", "Hellforged Deredeo Dreadnought", "Hellforged Rapier Battery", "Hellforged Leviathan Dreadnought", "Spined Chaos Beast"};
	public String[] Transporteinträge_Chaos_Space_Marines = new String[]{"", "Chaos Rhino"};
	public String[] Fliegereinträge_Chaos_Space_Marines = new String[]{"", "Heldrake", "", "Chaos Hell Blade", "Chaos Hell Talon", "Chaos Storm Eagle Assault Gunship", "Chaos Fire Raptor Assault Gunship", "Chaos Xiphon Interceptor"};
	public String[] Befestigungseinträge_Chaos_Space_Marines = new String[]{"", "Chaos Bastions"};
	public String[] LOWeinträge_Chaos_Space_Marines = new String[]{"", "Khorne Lord of Skulls", "", "Kytan Ravager", "Greater Brass Scorpion Of Khorne", "Hellforged Spartan Assault Tank", "Hellforged Cerberus Heavy Destroyer", "Hellforged Typhon Heavy Siege Tank", "Hellforged Fellblade", 
			"Hellforged Falchion", "Hellforged Mastodon", "Chaos Thunderhawk Assault Gunship", "Chaos Sokar Pattern Stormbird Gunship", "Anggrath The Unbound", "Zarakynel", "Aetaos'rau'keres", "Scabeiathrax The Bloated",
			"Renegade Knight Acheron", "Renegade Knight Lancer", "Renegade Knight Castigator", "Renegade Knight Atropos", "Renegade Knight Magaera", "Renegade Knight Porphyrion", "Renegade Knight Styrix", "", "Chaos Warlord Battle Titan", "Chaos Reaver Battle Titan", "Chaos Warhound Scout Titan"};

	/*
	 * World Eaters
	 */
	
	public String[] HQeinträge_World_Eaters = new String[]{"", "Kharn the Betrayer", "Chaos Lord", "Chaos Lord in Terminator Armour", "Chaos Lord on Bike", "Chaos Lord on Juggernaut of Khorne", "Exalted Champion", 
				"Dark Apostle", "Daemon Prince of Chaos", "Daemon Prince of Chaos with Wings", 
				"Warpsmith"};
	public String[] Eliteeinträge_World_Eaters = new String[]{"", "Fallen", "Plague Marines", "Noise Marines", "Rubric Marines", "Chaos Terminators", "Chosen", "Possessed", "Helbrute", "Mutilators"};
	public String[] Standardeinträge_World_Eaters = new String[]{"", "Khorne Berzerkers", "Chaos Space Marines", "Chaos Cultists"};
	public String[] Sturmeinträge_World_Eaters = new String[]{"", "Chaos Bikers", "Raptors", "Warp Talons", "Chaos Spawn"};
	public String[] Unterstützungseinträge_World_Eaters = new String[]{"", "Chaos Land Raider", "Chaos Predator", "Chaos Vindicator", "Obliterators", "Havocs", "Forgefiend", "Maulerfiend", "Defiler"};
	public String[] Transporteinträge_World_Eaters = new String[]{"", "Chaos Rhino"};
	public String[] Fliegereinträge_World_Eaters = new String[]{"", "Heldrake"};
	public String[] LOWeinträge_World_Eaters = new String[]{"", "Khorne Lord of Skulls"};
	
	/*
	 * Thousand Sons
	 */
	
	public String[] HQeinträge_ThousandSons = new String[]{"", "Ahriman", "Ahriman on Disc of Tzeentch", "Daemon Prince of Tzeentch", "Daemon Prince of Tzeentch with Wings",
				"Exalted Sorcerer", "Exalted Sorcerer on Disc of Tzeentch", "Thousand Sons Sorcerer", "TS Sorcerer in Terminator Armour", "Sorcerer on Disc of Tzeentch"};
	public String[] Eliteeinträge_ThousandSons = new String[]{"", "Tzaangor Shaman", "Flamers", "Scarab Occult Terminators", "Helbrute"};
	public String[] Standardeinträge_ThousandSons = new String[]{"", "TS Rubric Marines", "Tzaangors", "Chaos Cultists", "Horrors"};
	public String[] Sturmeinträge_ThousandSons = new String[]{"", "Tzaangor Enlightened", "Screamers", "Chaos Spawn"};
	public String[] Unterstützungseinträge_ThousandSons = new String[]{"", "Mutalith Vortex Beast", "Chaos Land Raider", "Chaos Predator", "Chaos Vindicator", "Forgefiend", "Maulerfiend", "Defiler"};
	public String[] Transporteinträge_ThousandSons = new String[]{"", "Chaos Rhino"};
	public String[] Fliegereinträge_ThousandSons = new String[]{"", "Heldrake"};
	public String[] LOWeinträge_ThousandSons = new String[]{"", "Magnus the Red"};

	/*
	 * Death Guard
	 */
	public String[] HQeinträge_Death_Guard = new String[]{"", "Typhus", "Lord of Contagion", "Malignant Plaguecaster", "Daemon Prince of Nurgle", "Daemon Prince of Nurgle with Wings",
				"Chaos Lord", "Chaos Lord in Terminator Armour", "Sorcerer", "Sorcerer in Terminator Armour", "", "Necrosius the Undying"};
	public String[] Eliteeinträge_Death_Guard = new String[]{"", "Noxious Blightbringer", "Foul Blightspawn", "Biologus Putrifier", "Plague Surgeon", "Tallyman", "Deathshroud Terminators", "Blightlord Terminators", "Helbrute", "Beasts of Nurgle", "Possessed"};
	public String[] Standardeinträge_Death_Guard = new String[]{"", "Plague Marines", "Poxwalkers", "Chaos Cultists", "Plaguebearers", "Nurglings"};
	public String[] Sturmeinträge_Death_Guard = new String[]{"", "Foetid Bloat Drone", "Myphitic Blight-Haulers", "Chaos Spawn", "Plague Drones"};
	public String[] Unterstützungseinträge_Death_Guard = new String[]{"", "Chaos Land Raider", "Plagueburst Crawler", "Defiler", "Chaos Predator"};
	public String[] Transporteinträge_Death_Guard = new String[]{"", "Chaos Rhino"};
	public String[] Fliegereinträge_Death_Guard = new String[]{""};
	public String[] LOWeinträge_Death_Guard = new String[]{"", "Mortarion"};
	
	/*
	 * Emperors Children
	 */
	
	public String[] HQeinträge_Emperors_Children = new String[]{"", "Lucius the Eternal", "Chaos Lord", "Chaos Lord in Terminator Armour", "Chaos Lord on Bike", "Chaos Lord on Juggernaut of Khorne", "Chaos Lord on Disc of Tzeentch",
				"Chaos Lord on Palanquin of Nurgle", "Chaos Lord on Steed of Slaanesh", "Dark Apostle", "Daemon Prince of Chaos", "Daemon Prince of Chaos with Wings",
				"Sorcerer", "Sorcerer in Terminator Armour", "Sorcerer on Bike", "Sorcerer on Disc of Tzeentch", "Sorcerer on Palanquin of Nurgle", "Sorcerer on Steed of Slaanesh", 
				"Warpsmith"};
	public String[] Eliteeinträge_Emperors_Children = new String[]{"", "Fallen", "Plague Marines", "Khorne Berzerkers", "Rubric Marines", "Chaos Terminators", "Chosen", "Possessed", "Helbrute", "Mutilators"};
	public String[] Standardeinträge_Emperors_Children = new String[]{"", "Noise Marines", "Chaos Space Marines", "Chaos Cultists"};
	public String[] Sturmeinträge_Emperors_Children = new String[]{"", "Chaos Bikers", "Raptors", "Warp Talons", "Chaos Spawn"};
	public String[] Unterstützungseinträge_Emperors_Children = new String[]{"", "Chaos Land Raider", "Chaos Predator", "Chaos Vindicator", "Obliterators", "Havocs", "Forgefiend", "Maulerfiend", "Defiler"};
	public String[] Transporteinträge_Emperors_Children = new String[]{"", "Chaos Rhino"};
	public String[] Fliegereinträge_Emperors_Children = new String[]{"", "Heldrake"};
	public String[] LOWeinträge_Emperors_Children = new String[]{"", "Khorne Lord of Skulls"};
	
	/*
	 * Questor Traitoris
	 */
	
	public String[] HQeinträge_Questor_Traitoris = new String[]{""};
	public String[] Eliteeinträge_Questor_Traitoris = new String[]{""};
	public String[] Standardeinträge_Questor_Traitoris = new String[]{""};
	public String[] Sturmeinträge_Questor_Traitoris = new String[]{""};
	public String[] Unterstüzungseinträge_Questor_Traitoris = new String[]{""};
	public String[] Fliegereinträge_Questor_Traitoris = new String[]{""};
	public String[] Transporteinträge_Questor_Traitoris = new String[]{""};
	public String[] Befestigungseinträge_Questor_Traitoris = new String[]{""};
	public String[] LOWeinträge_Questor_Traitoris = new String[]{"", "Renegade Knight"};
	
	/*
	 * Daemons
	 */
	
	public String[] HQeinträge_Daemons = new String[]{
				"", "Skarbrand", "Bloodthirster of Insensate Rage", "Wrath of Khorne Bloodthirster", "Bloodthirster of Unfettered Fury", "Skulltaker", "Bloodmaster", "Skullmaster", "Blood Throne", "Karanak", 
				"", "Kairos Fateweaver", "Lord of Change", "The Changeling", "The Blue Scribes", "Changecaster", "Fateskimmer", "Fluxmaster",
				"", "Rotigus", "Great Unclean One", "Epidemius", "Horticulous Slimux", "Poxbringer", "Sloppity Bilepiper", "Spoilpox Scrivener",
				"", "Keeper of Secrets", "The Masque of Slaanesh", "Herald of Slaanesh", "Herald of Slaanesh on Steed", "Herald of Slaanesh on Seeker Chariot", "Herald of Slaanesh on Exalted Seeker Chariot", 
				"", "Be'Lakor", "Daemon Prince of Chaos", "Daemon Prince of Chaos with Wings"};
	public String[] Eliteeinträge_Daemons = new String[]{"", "Bloodcrushers", "", "Flamers", "Exalted Flamer", "", "Beasts of Nurgle", "", "Fiends of Slaanesh"};
	public String[] Standardeinträge_Daemons = new String[]{"", "Bloodletters", "", "Horrors", "", "Plaguebearers", "Nurglings", "", "Daemonettes"};
	public String[] Sturmeinträge_Daemons = new String[]{"", "Flesh Hounds", "", "Screamers", "", "Plague Drones", "", "Seekers", "Hellflayer", "", "Furies"};
	public String[] Unterstüzungseinträge_Daemons = new String[]{"", "Skull Cannon", "", "Burning Chariot", "", "Seeker Chariot", "Exalted Seeker Chariot", "", "Soulgrinder"};
	public String[] Befestigungseinträge_Daemons = new String[]{"", "Feculent Gnarlmaws"};
	
	public VOLKChaos() {
		
		reflectionKennung = "CH";
		
		InputStream is = this.getClass().getResourceAsStream("/oc/wh40k/indices/chaos.csv");
		pointValues = BuildaHQ.loadindexFile(is);
		
		AdditionalInformation = new String[] {""};
		HQeinträge = new String[] {""};
		Eliteeinträge = new String[] {"", "Custodian Guard Squad"};
		Standardeinträge = new String[] {""};
		Sturmeinträge = new String[] {""};
		Unterstützungeinträge = new String[] {""};
		Transporteinträge = new String[] {""};
		Fliegereinträge = new String[] {""};
		Befestigungen = new String[] {""};
		LordofWar = new String[] {""};
		
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, AI, AdditionalInformation));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, HQ, HQeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, TR, Standardeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, EL, Eliteeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, FA, Sturmeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, HS, Unterstützungeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, TR, Transporteinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, FL, Fliegereinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, FORT, Befestigungen));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, LOW, LordofWar));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		
		cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

		volk = "CHAOS";
		nameDerArtDerArmee = "CHAOS";
		nameDerArtDerArmeeDekliniert = "CHAOS";

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
		formationen.add("CHAOS");
		formationen.add("Heretic Astartes");
		formationen.add("Chaos Space Marines");
		formationen.add("Emperor's Children");
		formationen.add("World Eaters");
		formationen.add("Death Guard");
		formationen.add("Thousand Sons");
		formationen.add("Chaosdaemons");
		formationen.add("Questor Traitoris");

		complete();
	}

	public void changeFormations(){
	}
	
	@Override
  	public void volkRefresh() {
		
    	if(getFormationType().equals("CHAOS")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(uniteUnitList(uniteUnitList(HQeinträge_Chaos_Space_Marines, HQeinträge_Death_Guard),HQeinträge_ThousandSons), HQeinträge_Daemons));
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(uniteUnitList(uniteUnitList(Eliteeinträge_Chaos_Space_Marines, Eliteeinträge_Death_Guard),Eliteeinträge_ThousandSons), Eliteeinträge_Daemons));
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(uniteUnitList(new String[]{"", "Chaos Space Marines", "Chaos Cultists", "Tzaangors", "Poxwalkers"}, Standardeinträge_Daemons));
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(uniteUnitList(uniteUnitList(Sturmeinträge_Chaos_Space_Marines, Sturmeinträge_Death_Guard),Sturmeinträge_ThousandSons), Sturmeinträge_Daemons));
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(uniteUnitList(uniteUnitList(uniteUnitList(Unterstützungseinträge_Chaos_Space_Marines, Unterstützungseinträge_Death_Guard),Unterstützungseinträge_ThousandSons), Unterstüzungseinträge_Daemons));
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_Chaos_Space_Marines);
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_Chaos_Space_Marines);
			myChooserGruppen.get(FORT).changeComboBoxAuswahlen(uniteUnitList(Befestigungseinträge_Chaos_Space_Marines, Befestigungseinträge_Daemons));
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(uniteUnitList(uniteUnitList(uniteUnitList(
					LOWeinträge_Chaos_Space_Marines, LOWeinträge_Death_Guard),LOWeinträge_ThousandSons),LOWeinträge_Questor_Traitoris));
		}
    	
    	if(getFormationType().equals("Heretic Astartes")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(uniteUnitList(HQeinträge_Chaos_Space_Marines, HQeinträge_Death_Guard),HQeinträge_ThousandSons));
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(uniteUnitList(Eliteeinträge_Chaos_Space_Marines, Eliteeinträge_Death_Guard),Eliteeinträge_ThousandSons));
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "Chaos Space Marines", "Chaos Cultists", "Tzaangors", "Poxwalkers"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(uniteUnitList(Sturmeinträge_Chaos_Space_Marines, Sturmeinträge_Death_Guard),Sturmeinträge_ThousandSons));
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(uniteUnitList(uniteUnitList(Unterstützungseinträge_Chaos_Space_Marines, Unterstützungseinträge_Death_Guard),Unterstützungseinträge_ThousandSons));
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_Chaos_Space_Marines);
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_Chaos_Space_Marines);
			myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungseinträge_Chaos_Space_Marines);
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(uniteUnitList(uniteUnitList(uniteUnitList(
					LOWeinträge_Chaos_Space_Marines, LOWeinträge_Death_Guard),LOWeinträge_ThousandSons),LOWeinträge_Questor_Traitoris));
		}
		
    	if(getFormationType().equals("Chaos Space Marines")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Chaos_Space_Marines);
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Chaos_Space_Marines);
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_Chaos_Space_Marines);
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_Chaos_Space_Marines);
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungseinträge_Chaos_Space_Marines);
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_Chaos_Space_Marines);
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_Chaos_Space_Marines);
			myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungseinträge_Chaos_Space_Marines);
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LOWeinträge_Chaos_Space_Marines);
		}
    	
    	if(getFormationType().equals("World Eaters")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_World_Eaters);
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_World_Eaters);
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_World_Eaters);
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_World_Eaters);
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungseinträge_World_Eaters);
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_World_Eaters);
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_World_Eaters);
			myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LOWeinträge_World_Eaters);
		}
    	
    	if(getFormationType().equals("Thousand Sons")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_ThousandSons);
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_ThousandSons);
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_ThousandSons);
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_ThousandSons);
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungseinträge_ThousandSons);
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_ThousandSons);
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_ThousandSons);
			myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LOWeinträge_ThousandSons);
		}
    	
    	if(getFormationType().equals("Death Guard")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Death_Guard);
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Death_Guard);
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_Death_Guard);
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_Death_Guard);
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungseinträge_Death_Guard);
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_Death_Guard);
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_Death_Guard);
			myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LOWeinträge_Death_Guard);
		}
    	
    	if(getFormationType().equals("Emperor's Children")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Emperors_Children);
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Emperors_Children);
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_Emperors_Children);
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_Emperors_Children);
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungseinträge_Emperors_Children);
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_Emperors_Children);
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_Emperors_Children);
			myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LOWeinträge_Emperors_Children);
		}
    	
    	if(getFormationType().equals("Questor Traitoris")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Questor_Traitoris);
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Questor_Traitoris);
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_Questor_Traitoris);
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_Questor_Traitoris);
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstüzungseinträge_Questor_Traitoris);
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_Questor_Traitoris);
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_Questor_Traitoris);
			myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LOWeinträge_Questor_Traitoris);
		}
    	
    	if(getFormationType().equals("Chaosdaemons")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Daemons);
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Daemons);
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_Daemons);
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_Daemons);
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstüzungseinträge_Daemons);
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungseinträge_Daemons);
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
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