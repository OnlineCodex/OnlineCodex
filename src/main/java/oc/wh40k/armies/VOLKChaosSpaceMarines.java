package oc.wh40k.armies;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;
import oc.Formation;
import oc.FormationEntry;
import oc.RefreshListener;
import oc.Superformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VOLKChaosSpaceMarines extends BuildaVater {

	private static final Logger LOGGER = LoggerFactory.getLogger(VOLKChaosSpaceMarines.class);
	
	public VOLKChaosSpaceMarines() {
		reflectionKennung = "CM";
		
		pointValues.put("Chaos Bikers", 31);
		pointValues.put("Chaos Cultists", 5);
		pointValues.put("Chaos Land Raider", 239);
		pointValues.put("Chaos Lord", 74);
		pointValues.put("Chaos Lord in Terminator Armour", 122);
		pointValues.put("Chaos Lord on Bike", 113);
		pointValues.put("Chaos Lord on Disc of Tzeentch", 100);
		pointValues.put("Chaos Lord on Juggernaut of Khorne", 125);
		pointValues.put("Chaos Lord on Palanquin of Nurgle", 99);
		pointValues.put("Chaos Lord on Steed of Slaanesh", 94);
		pointValues.put("Chaos Lord with Jump Pack", 93);
		pointValues.put("Chaos Predator", 102);
		pointValues.put("Chaos Rhino", 70);
		pointValues.put("Chaos Space Marines", 13);
		pointValues.put("Chaos Spawn", 33);
		pointValues.put("Chaos Terminators", 31);
		pointValues.put("Chaos Vindicator", 160);
		pointValues.put("Chosen", 16);
		pointValues.put("Daemon Prince", 146);
		pointValues.put("Daemon Prince with Wing", 170);
		pointValues.put("Dark Apostle", 72);
		pointValues.put("Defiler", 216);
		pointValues.put("Exalted Sorcerer", 86);
		pointValues.put("Exalted Sorcerer on Disc of Tzeentch", 120);
		pointValues.put("Fallen", 14);
		pointValues.put("Foetid Bloat-drone", 99);
		pointValues.put("Forgefind", 119);
		pointValues.put("Havocs", 13);
		pointValues.put("Helbrute", 72);
		pointValues.put("Heldrake", 138);
		pointValues.put("Khorne Berzerkers", 16);
		pointValues.put("Khorne Lord of Skulls", 465);
		pointValues.put("Lord of Contagion", 139);
		pointValues.put("Malignant Plaguecatser", 110);
		pointValues.put("Maulerfind", 149);
		pointValues.put("Mutilators", 63);
		pointValues.put("Noise Marines", 16);
		pointValues.put("Noxious Blightbringer", 73);
		pointValues.put("Obliberators", 65);
		pointValues.put("Plague Marines", 21);
		pointValues.put("Possessed", 22);
		pointValues.put("Poxwalkers", 6);
		pointValues.put("Raptors", 17);
		pointValues.put("Rubric Marines", 18);
		pointValues.put("Aspiring Sorcerer", 30);
		pointValues.put("Scarab Occult Terminators", 33);
		pointValues.put("Scarab Occult Sorcerer", 50);
		pointValues.put("Sorcerer", 90);
		pointValues.put("Sorcerer in Terminator Armour", 140);
		pointValues.put("Sorcerer on Bike", 130);
		pointValues.put("Sorcerer on Disc of Tzeentch", 125);
		pointValues.put("Sorcerer on Palanquin of Nurgle", 124);
		pointValues.put("Sorcerer on Steed of Slaanesh", 115);
		pointValues.put("Sorcerer with Jump Pack", 114);
		pointValues.put("Tzaangors", 7);
		pointValues.put("Warp Talons", 15);
		pointValues.put("Warpsmith", 78);
		
		pointValues.put("Abaddon the Despoiler", 253);
		pointValues.put("Ahriman", 131);
		pointValues.put("Ahriman on Disc of Tzeentch", 166);
		pointValues.put("Cypher", 110);
		pointValues.put("Fabius Bile", 109);
		pointValues.put("Huron Blackheart", 125);
		pointValues.put("Khârn the Betrayer", 173);
		pointValues.put("Lucius the Eternal", 115);
		pointValues.put("Magnus the Red", 415);
		pointValues.put("Typhus", 164);
		
		HQeinträge = new String[] {"", "Chaosgeneral", "Hexer", "Exalted Sorcerer", "Dämonenprinz", "Warpschmied", "Dunkler Apostel", "", "Abaddon der Vernichter", "Ahriman", "Fabius Gallus", 
								       "Huron Schwarzherz", "Kharn der Verräter", "Lucius der Ewige", "Typhus", "BeLakor", "Vrosh Tattersoul", 
							       "", "[IA Apo 2013] Zhufor", "[Forgeworld] Necrosius"};
		Eliteeinträge = new String[] {"", "Chaosterminatoren", "Höllenschlächter", "Mutilator",
				"", "[IA Experimental] Land Raider Proteus",
				"", "[IA Apo 2013] Chaos Contemptor Dreadnought", "[IA Apo 2013] Giant Chaos Spawn","[IA Apo 2013] Chaos Decimator Daemon Engine", ""};
		Standardeinträge = new String[] {"", "Chaos Space Marines", "Chaoskultisten", "Tzaangors"};
		Sturmeinträge = new String[] {"", "Chaosbiker", "Raptoren", "Warpkrallen", "Chaosbrut", "[DftS] Höllendrache",
								  "","[IA Apo 2013] Chaos Storm Eagle","[IA Aeronautica] Dreadclaw", "[IA Aeronautica] Hell Blade","[IA Aeronautica] Hell Talon"};
		Unterstützungeinträge = new String[] {"", "Havocs", "Kyborg", "Geissel", "Schmiedemonstrum", "Klauenmonstrum", "Land Raider des Chaos", "Vindicator des Chaos", 
												  "Predator des Chaos",
											  "", "[FW online] Deimos Pattern Vindicator Tank Destroyer", 
											  "", "[IA Experimental] Fire Raptor Gunship",
											  "", "[IA Apo 2013] Chaos Spartan Assault Tank", "[IA Apo 2013] Chaos Relic Predator", "[IA Apo 2013] Spined Chaos Beast"
											};
		LordofWar = new String[] {
            "", "Magnus The Red", "Schädelherrscher des Khorne", 
            "", "[IA Apo 2013] Chaos Warhound Titan", "[IA Apo 2013] Chaos Reaver Battle Titan", "[IA Apo 2013] Greater Brass Scorpion of Khorne", 
                "[IA Apo 2013] Thunderhawk Gunship",
            "", "[IA Experimental] Chaos Knight Paladin", "[IA Experimental] Chaos Knight Errant", "[IA Experimental] Kytan Daemon Engine of Khorne",
        };
        
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
		
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Auserkorene");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Khorne-Berserker");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Rubric Marines");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Scarab Occult Terminators");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Seuchenmarines");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Noisemarines");
		getChooserGruppeForChange(2).addSpezialAuswahl("Besessene");
		
		nameDerArtDerArmee = "Chaos Space Marines";
		nameDerArtDerArmeeDekliniert = "Chaos Space Marines";
		textAreaUeberschrift = BuildaHQ.translate("Meine") + " Chaos Space Marines";
		volk = "Chaos Space Marines";

		noAllies.clear();
		noAllies.add("RH");
		noAllies.add("CS");
		noAllies.add("CM");
		noAllies.add("BL");
		
		battleBrothers.add("RH");
		battleBrothers.add("CS");
		battleBrothers.add("CM");
		battleBrothers.add("BL");
		battleBrothers.add("CD");
		battleBrothers.add("KD");
		
		alliesOfConvenience.add("NE");
		alliesOfConvenience.add("OR");
		alliesOfConvenience.add("DM");
		alliesOfConvenience.add("DH");
		
		desperateAllies.add("DE");
		desperateAllies.add("TA");
		desperateAllies.add("FE");
		desperateAllies.add("EC");
		
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
		
		//Verschiedene Spezialkontingente der Chaos Space Marines
		supplements.add("Codex");
		supplements.add("Alpha Legion");
		supplements.add("Black Legion");
		supplements.add("Crimson Slaughter");
		supplements.add("Death Guard");
		supplements.add("Emperors Children");
		supplements.add("Iron Warriors");
		supplements.add("Night Lords");
		supplements.add("Thousand Sons");
		supplements.add("Word Bearers");
		supplements.add("World Eaters");
		
		formationen.add("");	
		
		minAuswahlen.put("The Bringers of Despair (BL)",new int[] {1,1,0,0,0,0,0,0});
		maxAuswahlen.put("The Bringers of Despair (BL)",new int[] {1,1,0,0,0,0,0,0});
		
		minAuswahlen.put("The Chosen of Abaddon (BL)",new int[] {1,0,0,0,0,0,0,0});
		maxAuswahlen.put("The Chosen of Abaddon (BL)",new int[] {4,4,4,0,0,0,0,0});
		
		minAuswahlen.put("The Hounds of Abaddon (BL)",new int[] {1,0,2,1,0,0,0,0});
		maxAuswahlen.put("The Hounds of Abaddon (BL)",new int[] {1,0,6,3,0,0,0,0});
		
		minAuswahlen.put("Daemon Engine Pack (BL)",new int[] {1,0,0,0,2,0,0,0});
		maxAuswahlen.put("Daemon Engine Pack (BL)",new int[] {1,0,0,0,2,0,0,0});
		
		minAuswahlen.put("Cyclopia Cabal (BL)",new int[] {3,0,0,0,0,0,0,0});
		maxAuswahlen.put("Cyclopia Cabal (BL)",new int[] {5,0,0,0,0,0,0,0});
		
		minAuswahlen.put("The Tormented (BL)",new int[] {1,2,0,0,0,0,0,0});
		maxAuswahlen.put("The Tormented (BL)",new int[] {1,5,0,0,0,0,0,0});
		
		minAuswahlen.put("Black Legion Warband (BL)",new int[] {1,1,2,1,0,0,0,0});
		maxAuswahlen.put("Black Legion Warband (BL)",new int[] {2,6,6,3,3,0,0,0});
		
		minAuswahlen.put("The Ravagers (CS)",new int[] {0,1,1,0,0,0,0,0});
		maxAuswahlen.put("The Ravagers (CS)",new int[] {0,1,1,0,0,0,0,0});
		
		minAuswahlen.put("Disciples of Mannon (CS)",new int[] {1,0,1,0,0,0,0,0});
		maxAuswahlen.put("Disciples of Mannon (CS)",new int[] {1,0,1,0,0,0,0,0});

		minAuswahlen.put("Brethren of the Dark Covenant (CS)",new int[] {1,0,2,0,0,0,0,0});
		maxAuswahlen.put("Brethren of the Dark Covenant (CS)",new int[] {1,0,4,0,0,0,0,0});

		minAuswahlen.put("Cult of Slaughter (CS)",new int[] {1,0,2,0,0,0,0,0});
		maxAuswahlen.put("Cult of Slaughter (CS)",new int[] {1,0,8,0,0,0,0,0});

		minAuswahlen.put("Lords of Slaughter (CS)",new int[] {1,1,2,0,0,0,0,0});
		maxAuswahlen.put("Lords of Slaughter (CS)",new int[] {1,1,4,0,0,0,0,0});
		
		minAuswahlen.put("Kanon's Helguard (CS)",new int[] {1,3,2,1,1,0,0,0});
		maxAuswahlen.put("Kanon's Helguard (CS)",new int[] {1,3,2,1,1,0,0,0});

		minAuswahlen.put("The Red Onslaught (CS)",new int[] {0,0,0,0,0,0,0,0});
		maxAuswahlen.put("The Red Onslaught (CS)",new int[] {0,0,0,0,0,0,0,0});
		
		minAuswahlen.put("Chaos Warband (TL)",new int[] {1,1,2,1,1,0,0,0});
		maxAuswahlen.put("Chaos Warband (TL)",new int[] {1,3,6,3,3,0,0,0});
		
		minAuswahlen.put("Maelstrom of Gore (TL)",new int[] {1,4,0,0,0,0,0,0});
		maxAuswahlen.put("Maelstrom of Gore (TL)",new int[] {1,8,0,0,0,0,0,0});
		
		minAuswahlen.put("The Lost And The Damned (TL)",new int[] {1,0,4,0,0,0,0,0});
		maxAuswahlen.put("The Lost And The Damned (TL)",new int[] {1,0,9,0,0,0,0,0});
		
		minAuswahlen.put("Helforged Warpack (TL)",new int[] {1,0,0,0,3,0,0,0});
		maxAuswahlen.put("Helforged Warpack (TL)",new int[] {1,0,0,0,5,0,0,0});
		
		minAuswahlen.put("Heldrake Terror Pack (TL)",new int[] {0,0,0,2,0,0,0,0});
		maxAuswahlen.put("Heldrake Terror Pack (TL)",new int[] {0,0,0,4,0,0,0,0});
		
		minAuswahlen.put("Cult Of Destruction (TL)",new int[] {1,0,0,0,0,0,0,0});
		maxAuswahlen.put("Cult Of Destruction (TL)",new int[] {1,5,0,0,5,0,0,0});
		
		minAuswahlen.put("Fist Of The Gods (TL)",new int[] {1,0,0,0,3,0,0,0});
		maxAuswahlen.put("Fist Of The Gods (TL)",new int[] {1,0,0,0,5,0,0,0});
		
		minAuswahlen.put("Raptor Talon (TL)",new int[] {1,0,0,3,0,0,0,0});
		maxAuswahlen.put("Raptor Talon (TL)",new int[] {1,0,0,5,0,0,0,0});
		
		minAuswahlen.put("Terminator Annihilation Force (TL)",new int[] {1,3,0,0,0,0,0,0});
		maxAuswahlen.put("Terminator Annihilation Force (TL)",new int[] {1,5,0,0,0,0,0,0});
		
		minAuswahlen.put("Favoured Of Chaos (TL)",new int[] {1,3,0,0,0,0,0,0});
		maxAuswahlen.put("Favoured Of Chaos (TL)",new int[] {1,5,0,0,0,0,0,0});
		
		minAuswahlen.put("Trinity Of Blood (TL)",new int[] {0,0,0,0,0,0,3,0});
		maxAuswahlen.put("Trinity Of Blood (TL)",new int[] {0,0,0,0,0,0,3,0});
		
		minAuswahlen.put("War Cabal (TS)",new int[] {2,1,1,0,0,0,0,0});
		maxAuswahlen.put("War Cabal (TS)",new int[] {4,3,3,0,0,0,0,0});
		
		minAuswahlen.put("War Coven (TS)",new int[] {4,0,0,0,0,0,0,0});
		maxAuswahlen.put("War Coven (TS)",new int[] {10,0,0,0,0,0,0,0});
		
		minAuswahlen.put("Tzaangor Warherd (TS)",new int[] {1,0,3,0,0,0,0,0});
		maxAuswahlen.put("Tzaangor Warherd (TS)",new int[] {1,0,9,0,0,0,0,0});
		
		minAuswahlen.put("Sekhmet Conclave (TS)",new int[] {0,3,0,0,0,0,0,0});
		maxAuswahlen.put("Sekhmet Conclave (TS)",new int[] {1,9,0,0,0,0,1,0});
		
		minAuswahlen.put("Ahriman's Exiles (TS)",new int[] {4,0,0,0,0,0,0,0});
		maxAuswahlen.put("Ahriman's Exiles (TS)",new int[] {10,0,0,0,0,0,0,0});
		
		minAuswahlen.put("Rehati War Sect (TS)",new int[] {3,0,0,0,0,0,1,0});
		maxAuswahlen.put("Rehati War Sect (TS)",new int[] {9,0,0,0,0,0,1,0});
		
		minAuswahlen.put("Plaque Colony (DG)",new int[] {1,0,3,0,0,0,0,0});
		maxAuswahlen.put("Plaque Colony (DG)",new int[] {1,0,7,0,0,0,0,0});
		
		minAuswahlen.put("Kakophoni (EC)",new int[] {1,0,3,0,0,0,0,0});
		maxAuswahlen.put("Kakophoni (EC)",new int[] {1,0,6,0,0,0,0,0});
		
		minAuswahlen.put("Black Legion Speartip",new int[] {0,0,0,0,0,0,0,0});
		maxAuswahlen.put("Black Legion Speartip",new int[] {0,0,0,0,0,0,0,0});
		
		minAuswahlen.put("Alpha Legion Insurgency Force",new int[] {0,0,0,0,0,0,0,0});
		maxAuswahlen.put("Alpha Legion Insurgency Force",new int[] {0,0,0,0,0,0,0,0});
		
		minAuswahlen.put("Iron Warriors Grand Company",new int[] {0,0,0,0,0,0,0,0});
		maxAuswahlen.put("Iron Warriors Grand Company",new int[] {0,0,0,0,0,0,0,0});
		
		minAuswahlen.put("Night Lord Murder Talon",new int[] {0,0,0,0,0,0,0,0});
		maxAuswahlen.put("Night Lord Murder Talon",new int[] {0,0,0,0,0,0,0,0});
		
		minAuswahlen.put("Word Bearers Grand Host",new int[] {0,0,0,0,0,0,0,0});
		maxAuswahlen.put("Word Bearers Grand Host",new int[] {0,0,0,0,0,0,0,0});
		
		minAuswahlen.put("World Eaters Butherhorde",new int[] {0,0,0,0,0,0,0,0});
		maxAuswahlen.put("World Eaters Butherhorde",new int[] {0,0,0,0,0,0,0,0});
		
		minAuswahlen.put("Thousand Sons Grand Coven",new int[] {0,0,0,0,0,0,0,0});
		maxAuswahlen.put("Thousand Sons Grand Coven",new int[] {0,0,0,0,0,0,0,0});
		
		minAuswahlen.put("Deathguard Vectorium",new int[] {0,0,0,0,0,0,0,0});
		maxAuswahlen.put("Deathguard Vectorium",new int[] {0,0,0,0,0,0,0,0});
		
		minAuswahlen.put("Emperors Children Rapture Battalion",new int[] {0,0,0,0,0,0,0,0});
		maxAuswahlen.put("Emperors Children Rapture Battalion",new int[] {0,0,0,0,0,0,0,0});
		
		minAuswahlen.put("Strongholds Of Chaos (TL)",new int[] {0,0,0,0,0,1,0,0});
		maxAuswahlen.put("Strongholds Of Chaos (TL)",new int[] {0,0,0,0,0,3,0,0});
		
		complete();
		
//		formationBox.addItem("");
	}
	
	@Override
	public void refreshSupplements(){
		if(getSupplementTyp().contains("Crimson Slaughter")){
			setInformationVectorValue("CrimsonSlaughter", 1);
			getChooserGruppeForChange(3).addSpezialAuswahl("Besessene");
			getChooserGruppeForChange(2).removeSpezialAuswahl("Besessene");
		}else{
			setInformationVectorValue("CrimsonSlaughter", 0);
			getChooserGruppeForChange(2).addSpezialAuswahl("Besessene");
			getChooserGruppeForChange(3).removeSpezialAuswahl("Besessene");
		}
		
		if(getSupplementTyp().contains("Black Legion")){
			setInformationVectorValue("BlackLegion", 1);
			getChooserGruppeForChange(3).addSpezialAuswahl("Auserkorene");
			getChooserGruppeForChange(2).removeSpezialAuswahl("Auserkorene");
		}else{
			setInformationVectorValue("BlackLegion", 0);
			getChooserGruppeForChange(2).addSpezialAuswahl("Auserkorene");
			getChooserGruppeForChange(3).removeSpezialAuswahl("Auserkorene");
		}
		
		if(getSupplementTyp().contains("Thousand Sons")){
			setInformationVectorValue("Thousand Sons", 1);
		} else {
			setInformationVectorValue("Thousand Sons", 0);
		}
		
		if(getSupplementTyp().contains("Alpha Legion")){
			setInformationVectorValue("Alpha Legion", 1);
		} else {
			setInformationVectorValue("Alpha Legion", 0);
		}
		
		if(getSupplementTyp().contains("Iron Warriors")){
			setInformationVectorValue("Iron Warriors", 1);
		} else {
			setInformationVectorValue("Iron Warriors", 0);
		}
		
		if(getSupplementTyp().contains("Night Lords")){
			setInformationVectorValue("Night Lords", 1);
		} else {
			setInformationVectorValue("Night Lords", 0);
		}
		
		if(getSupplementTyp().contains("Word Bearers")){
			setInformationVectorValue("Word Bearers", 1);
		} else {
			setInformationVectorValue("Word Bearers", 0);
		}
		
		if(getSupplementTyp().contains("World Eaters")){
			setInformationVectorValue("World Eaters", 1);
		} else {
			setInformationVectorValue("Word Eaters", 0);
		}
		
		if(getSupplementTyp().contains("Death Guard")){
			setInformationVectorValue("Death Guard", 1);
			getChooserGruppeForChange(EL).addSpezialAuswahl("Seuchenmarines");
			getChooserGruppeForChange(TR).removeSpezialAuswahl("Seuchenmarines");
		} else {
			setInformationVectorValue("Death Guard", 0);
			getChooserGruppeForChange(TR).addSpezialAuswahl("Seuchenmarines");
			getChooserGruppeForChange(EL).removeSpezialAuswahl("Seuchenmarines");
		}
		
		if(getSupplementTyp().contains("Emperors Children")){
			setInformationVectorValue("Emperors Children", 1);
			getChooserGruppeForChange(EL).addSpezialAuswahl("Noisemarines");
			getChooserGruppeForChange(TR).removeSpezialAuswahl("Noisemarines");
		} else {
			setInformationVectorValue("Emperors Children", 0);
			getChooserGruppeForChange(TR).addSpezialAuswahl("Noisemarines");
			getChooserGruppeForChange(EL).removeSpezialAuswahl("Noisemarines");
		}
		
		changeFormations();
	}
	
	@Override
	public void changeFormations(){
		if(getCountFromInformationVector("CrimsonSlaughter")>0){
			formationBox.removeItem("The Bringers of Despair (BL)");
			formationBox.removeItem("The Chosen of Abaddon (BL)");
			formationBox.removeItem("The Hounds of Abaddon (BL)");
			formationBox.removeItem("Daemon Engine Pack (BL)");
			formationBox.removeItem("Cyclopia Cabal (BL)");
			formationBox.removeItem("The Tormented (BL)");
			formationBox.removeItem("Black Legion Warband (BL)");
			formationBox.removeItem("Chaos Warband (TL)");
			formationBox.removeItem("Maelstrom of Gore (TL)");
			formationBox.removeItem("The Lost And The Damned (TL)");
			formationBox.removeItem("Helforged Warpack (TL)");
			formationBox.removeItem("Heldrake Terror Pack (TL)");
			formationBox.removeItem("Cult Of Destruction (TL)");
			formationBox.removeItem("Fist Of The Gods (TL)");
			formationBox.removeItem("Raptor Talon (TL)");
			formationBox.removeItem("Terminator Annihilation Force (TL)");
			formationBox.removeItem("Favoured Of Chaos (TL)");
			formationBox.removeItem("Trinity Of Blood (TL)");
			formationBox.removeItem("War Cabal (TS)");
			formationBox.removeItem("War Coven (TS)");
			formationBox.removeItem("Tzaangor Warherd (TS)");
			formationBox.removeItem("Sekhmet Conclave (TS)");
			formationBox.removeItem("Ahriman's Exiles (TS)");
			formationBox.removeItem("Rehati War Sect (TS)");
			formationBox.removeItem("Kakophoni (EC)");
			formationBox.removeItem("Plaque Colony (DG)");
			
			formationBox.addItem("The Ravagers (CS)");
			formationBox.addItem("Disciples of Mannon (CS)");
			formationBox.addItem("Brethren of the Dark Covenant (CS)");
			formationBox.addItem("Cult of Slaughter (CS)");
			formationBox.addItem("Lords of Slaughter (CS)");
			formationBox.addItem("Kanon's Helguard (CS)");
			formationBox.addItem("The Red Onslaught (CS)");
		}else if(getCountFromInformationVector("BlackLegion")>0){
			formationBox.removeItem("The Ravagers (CS)");
			formationBox.removeItem("Disciples of Mannon (CS)");
			formationBox.removeItem("Brethren of the Dark Covenant (CS)");
			formationBox.removeItem("Cult of Slaughter (CS)");
			formationBox.removeItem("Lords of Slaughter (CS)");
			formationBox.removeItem("Kanon's Helguard (CS)");
			formationBox.removeItem("The Red Onslaught (CS)");
			formationBox.removeItem("Chaos Warband (TL)");
			formationBox.removeItem("Maelstrom of Gore (TL)");
			formationBox.removeItem("The Lost And The Damned (TL)");
			formationBox.removeItem("Helforged Warpack (TL)");
			formationBox.removeItem("Heldrake Terror Pack (TL)");
			formationBox.removeItem("Cult Of Destruction (TL)");
			formationBox.removeItem("Fist Of The Gods (TL)");
			formationBox.removeItem("Raptor Talon (TL)");
			formationBox.removeItem("Terminator Annihilation Force (TL)");
			formationBox.removeItem("Favoured Of Chaos (TL)");
			formationBox.removeItem("Trinity Of Blood (TL)");
			formationBox.removeItem("War Cabal (TS)");
			formationBox.removeItem("War Coven (TS)");
			formationBox.removeItem("Tzaangor Warherd (TS)");
			formationBox.removeItem("Sekhmet Conclave (TS)");
			formationBox.removeItem("Ahriman's Exiles (TS)");
			formationBox.removeItem("Rehati War Sect (TS)");
			formationBox.removeItem("Kakophoni (EC)");
			formationBox.removeItem("Plaque Colony (DG)");
			
			formationBox.addItem("The Bringers of Despair (BL)");
			formationBox.addItem("The Chosen of Abaddon (BL)");
			formationBox.addItem("The Hounds of Abaddon (BL)");
			formationBox.addItem("Daemon Engine Pack (BL)");
			formationBox.addItem("Cyclopia Cabal (BL)");
			formationBox.addItem("The Tormented (BL)");
			formationBox.addItem("Black Legion Warband (BL)");
			formationBox.addItem("Black Legion Speartip");
		}else if(getCountFromInformationVector("Thousand Sons")>0){
			formationBox.removeItem("The Ravagers (CS)");
			formationBox.removeItem("Disciples of Mannon (CS)");
			formationBox.removeItem("Brethren of the Dark Covenant (CS)");
			formationBox.removeItem("Cult of Slaughter (CS)");
			formationBox.removeItem("Lords of Slaughter (CS)");
			formationBox.removeItem("Kanon's Helguard (CS)");
			formationBox.removeItem("The Red Onslaught (CS)");
			formationBox.removeItem("Chaos Warband (TL)");
			formationBox.removeItem("Maelstrom of Gore (TL)");
			formationBox.removeItem("The Lost And The Damned (TL)");
			formationBox.removeItem("Helforged Warpack (TL)");
			formationBox.removeItem("Heldrake Terror Pack (TL)");
			formationBox.removeItem("Cult Of Destruction (TL)");
			formationBox.removeItem("Fist Of The Gods (TL)");
			formationBox.removeItem("Raptor Talon (TL)");
			formationBox.removeItem("Terminator Annihilation Force (TL)");
			formationBox.removeItem("Favoured Of Chaos (TL)");
			formationBox.removeItem("Trinity Of Blood (TL)");
			formationBox.removeItem("Kakophoni (EC)");
			formationBox.removeItem("Plaque Colony (DG)");
			formationBox.removeItem("The Bringers of Despair (BL)");
			formationBox.removeItem("The Chosen of Abaddon (BL)");
			formationBox.removeItem("The Hounds of Abaddon (BL)");
			formationBox.removeItem("Daemon Engine Pack (BL)");
			formationBox.removeItem("Cyclopia Cabal (BL)");
			formationBox.removeItem("The Tormented (BL)");
			formationBox.removeItem("Black Legion Warband (BL)");
			
			formationBox.addItem("War Cabal (TS)");
			formationBox.addItem("War Coven (TS)");
			formationBox.addItem("Tzaangor Warherd (TS)");
			formationBox.addItem("Sekhmet Conclave (TS)");
			formationBox.addItem("Ahriman's Exiles (TS)");
			formationBox.addItem("Rehati War Sect (TS)");
			formationBox.addItem("Thousand Sons Grand Coven");
		} else if(getCountFromInformationVector("Death Guard")>0){
			formationBox.removeItem("The Ravagers (CS)");
			formationBox.removeItem("Disciples of Mannon (CS)");
			formationBox.removeItem("Brethren of the Dark Covenant (CS)");
			formationBox.removeItem("Cult of Slaughter (CS)");
			formationBox.removeItem("Lords of Slaughter (CS)");
			formationBox.removeItem("Kanon's Helguard (CS)");
			formationBox.removeItem("The Red Onslaught (CS)");
			formationBox.removeItem("Chaos Warband (TL)");
			formationBox.removeItem("Maelstrom of Gore (TL)");
			formationBox.removeItem("The Lost And The Damned (TL)");
			formationBox.removeItem("Helforged Warpack (TL)");
			formationBox.removeItem("Heldrake Terror Pack (TL)");
			formationBox.removeItem("Cult Of Destruction (TL)");
			formationBox.removeItem("Fist Of The Gods (TL)");
			formationBox.removeItem("Raptor Talon (TL)");
			formationBox.removeItem("Terminator Annihilation Force (TL)");
			formationBox.removeItem("Favoured Of Chaos (TL)");
			formationBox.removeItem("Trinity Of Blood (TL)");
			formationBox.removeItem("War Cabal (TS)");
			formationBox.removeItem("War Coven (TS)");
			formationBox.removeItem("Tzaangor Warherd (TS)");
			formationBox.removeItem("Sekhmet Conclave (TS)");
			formationBox.removeItem("Ahriman's Exiles (TS)");
			formationBox.removeItem("Rehati War Sect (TS)");
			formationBox.removeItem("Kakophoni (EC)");
			formationBox.removeItem("The Bringers of Despair (BL)");
			formationBox.removeItem("The Chosen of Abaddon (BL)");
			formationBox.removeItem("The Hounds of Abaddon (BL)");
			formationBox.removeItem("Daemon Engine Pack (BL)");
			formationBox.removeItem("Cyclopia Cabal (BL)");
			formationBox.removeItem("The Tormented (BL)");
			formationBox.removeItem("Black Legion Warband (BL)");
			
			formationBox.addItem("Plaque Colony (DG)");
			formationBox.addItem("Death Guard Vectorium");
		} else if(getCountFromInformationVector("Emperors Children")>0){
			formationBox.removeItem("The Ravagers (CS)");
			formationBox.removeItem("Disciples of Mannon (CS)");
			formationBox.removeItem("Brethren of the Dark Covenant (CS)");
			formationBox.removeItem("Cult of Slaughter (CS)");
			formationBox.removeItem("Lords of Slaughter (CS)");
			formationBox.removeItem("Kanon's Helguard (CS)");
			formationBox.removeItem("The Red Onslaught (CS)");
			formationBox.removeItem("Chaos Warband (TL)");
			formationBox.removeItem("Maelstrom of Gore (TL)");
			formationBox.removeItem("The Lost And The Damned (TL)");
			formationBox.removeItem("Helforged Warpack (TL)");
			formationBox.removeItem("Heldrake Terror Pack (TL)");
			formationBox.removeItem("Cult Of Destruction (TL)");
			formationBox.removeItem("Fist Of The Gods (TL)");
			formationBox.removeItem("Raptor Talon (TL)");
			formationBox.removeItem("Terminator Annihilation Force (TL)");
			formationBox.removeItem("Favoured Of Chaos (TL)");
			formationBox.removeItem("Trinity Of Blood (TL)");
			formationBox.removeItem("War Cabal (TS)");
			formationBox.removeItem("War Coven (TS)");
			formationBox.removeItem("Tzaangor Warherd (TS)");
			formationBox.removeItem("Sekhmet Conclave (TS)");
			formationBox.removeItem("Ahriman's Exiles (TS)");
			formationBox.removeItem("Rehati War Sect (TS)");
			formationBox.removeItem("Plaque Colony (DG)");
			formationBox.removeItem("The Bringers of Despair (BL)");
			formationBox.removeItem("The Chosen of Abaddon (BL)");
			formationBox.removeItem("The Hounds of Abaddon (BL)");
			formationBox.removeItem("Daemon Engine Pack (BL)");
			formationBox.removeItem("Cyclopia Cabal (BL)");
			formationBox.removeItem("The Tormented (BL)");
			formationBox.removeItem("Black Legion Warband (BL)");
			
			formationBox.addItem("Kakophoni (EC)");
			formationBox.addItem("Emperors Children Rapture Battalion");
		} else if(getCountFromInformationVector("Alpha Legion")>0){
			formationBox.removeItem("The Ravagers (CS)");
			formationBox.removeItem("Disciples of Mannon (CS)");
			formationBox.removeItem("Brethren of the Dark Covenant (CS)");
			formationBox.removeItem("Cult of Slaughter (CS)");
			formationBox.removeItem("Lords of Slaughter (CS)");
			formationBox.removeItem("Kanon's Helguard (CS)");
			formationBox.removeItem("The Red Onslaught (CS)");
			formationBox.removeItem("Chaos Warband (TL)");
			formationBox.removeItem("Maelstrom of Gore (TL)");
			formationBox.removeItem("The Lost And The Damned (TL)");
			formationBox.removeItem("Helforged Warpack (TL)");
			formationBox.removeItem("Heldrake Terror Pack (TL)");
			formationBox.removeItem("Cult Of Destruction (TL)");
			formationBox.removeItem("Fist Of The Gods (TL)");
			formationBox.removeItem("Raptor Talon (TL)");
			formationBox.removeItem("Terminator Annihilation Force (TL)");
			formationBox.removeItem("Favoured Of Chaos (TL)");
			formationBox.removeItem("Trinity Of Blood (TL)");
			formationBox.removeItem("War Cabal (TS)");
			formationBox.removeItem("War Coven (TS)");
			formationBox.removeItem("Tzaangor Warherd (TS)");
			formationBox.removeItem("Sekhmet Conclave (TS)");
			formationBox.removeItem("Ahriman's Exiles (TS)");
			formationBox.removeItem("Rehati War Sect (TS)");
			formationBox.removeItem("Plaque Colony (DG)");
			formationBox.removeItem("The Bringers of Despair (BL)");
			formationBox.removeItem("The Chosen of Abaddon (BL)");
			formationBox.removeItem("The Hounds of Abaddon (BL)");
			formationBox.removeItem("Daemon Engine Pack (BL)");
			formationBox.removeItem("Cyclopia Cabal (BL)");
			formationBox.removeItem("The Tormented (BL)");
			formationBox.removeItem("Black Legion Warband (BL)");
			formationBox.removeItem("Kakophoni (EC)");
			
			formationBox.addItem("Alpha Legion Insurgency Force");
		} else if(getCountFromInformationVector("Iron Warriors")>0){
			formationBox.removeItem("The Ravagers (CS)");
			formationBox.removeItem("Disciples of Mannon (CS)");
			formationBox.removeItem("Brethren of the Dark Covenant (CS)");
			formationBox.removeItem("Cult of Slaughter (CS)");
			formationBox.removeItem("Lords of Slaughter (CS)");
			formationBox.removeItem("Kanon's Helguard (CS)");
			formationBox.removeItem("The Red Onslaught (CS)");
			formationBox.removeItem("Chaos Warband (TL)");
			formationBox.removeItem("Maelstrom of Gore (TL)");
			formationBox.removeItem("The Lost And The Damned (TL)");
			formationBox.removeItem("Helforged Warpack (TL)");
			formationBox.removeItem("Heldrake Terror Pack (TL)");
			formationBox.removeItem("Cult Of Destruction (TL)");
			formationBox.removeItem("Fist Of The Gods (TL)");
			formationBox.removeItem("Raptor Talon (TL)");
			formationBox.removeItem("Terminator Annihilation Force (TL)");
			formationBox.removeItem("Favoured Of Chaos (TL)");
			formationBox.removeItem("Trinity Of Blood (TL)");
			formationBox.removeItem("War Cabal (TS)");
			formationBox.removeItem("War Coven (TS)");
			formationBox.removeItem("Tzaangor Warherd (TS)");
			formationBox.removeItem("Sekhmet Conclave (TS)");
			formationBox.removeItem("Ahriman's Exiles (TS)");
			formationBox.removeItem("Rehati War Sect (TS)");
			formationBox.removeItem("Plaque Colony (DG)");
			formationBox.removeItem("The Bringers of Despair (BL)");
			formationBox.removeItem("The Chosen of Abaddon (BL)");
			formationBox.removeItem("The Hounds of Abaddon (BL)");
			formationBox.removeItem("Daemon Engine Pack (BL)");
			formationBox.removeItem("Cyclopia Cabal (BL)");
			formationBox.removeItem("The Tormented (BL)");
			formationBox.removeItem("Black Legion Warband (BL)");
			formationBox.removeItem("Kakophoni (EC)");
			
			formationBox.addItem("Iron Warriors Grand Company");
		} else if(getCountFromInformationVector("Night Lords")>0){
			formationBox.removeItem("The Ravagers (CS)");
			formationBox.removeItem("Disciples of Mannon (CS)");
			formationBox.removeItem("Brethren of the Dark Covenant (CS)");
			formationBox.removeItem("Cult of Slaughter (CS)");
			formationBox.removeItem("Lords of Slaughter (CS)");
			formationBox.removeItem("Kanon's Helguard (CS)");
			formationBox.removeItem("The Red Onslaught (CS)");
			formationBox.removeItem("Chaos Warband (TL)");
			formationBox.removeItem("Maelstrom of Gore (TL)");
			formationBox.removeItem("The Lost And The Damned (TL)");
			formationBox.removeItem("Helforged Warpack (TL)");
			formationBox.removeItem("Heldrake Terror Pack (TL)");
			formationBox.removeItem("Cult Of Destruction (TL)");
			formationBox.removeItem("Fist Of The Gods (TL)");
			formationBox.removeItem("Raptor Talon (TL)");
			formationBox.removeItem("Terminator Annihilation Force (TL)");
			formationBox.removeItem("Favoured Of Chaos (TL)");
			formationBox.removeItem("Trinity Of Blood (TL)");
			formationBox.removeItem("War Cabal (TS)");
			formationBox.removeItem("War Coven (TS)");
			formationBox.removeItem("Tzaangor Warherd (TS)");
			formationBox.removeItem("Sekhmet Conclave (TS)");
			formationBox.removeItem("Ahriman's Exiles (TS)");
			formationBox.removeItem("Rehati War Sect (TS)");
			formationBox.removeItem("Plaque Colony (DG)");
			formationBox.removeItem("The Bringers of Despair (BL)");
			formationBox.removeItem("The Chosen of Abaddon (BL)");
			formationBox.removeItem("The Hounds of Abaddon (BL)");
			formationBox.removeItem("Daemon Engine Pack (BL)");
			formationBox.removeItem("Cyclopia Cabal (BL)");
			formationBox.removeItem("The Tormented (BL)");
			formationBox.removeItem("Black Legion Warband (BL)");
			formationBox.removeItem("Kakophoni (EC)");
			
			formationBox.addItem("Night Lords Murder Talon");
		} else if(getCountFromInformationVector("Word Bearers")>0){
			formationBox.removeItem("The Ravagers (CS)");
			formationBox.removeItem("Disciples of Mannon (CS)");
			formationBox.removeItem("Brethren of the Dark Covenant (CS)");
			formationBox.removeItem("Cult of Slaughter (CS)");
			formationBox.removeItem("Lords of Slaughter (CS)");
			formationBox.removeItem("Kanon's Helguard (CS)");
			formationBox.removeItem("The Red Onslaught (CS)");
			formationBox.removeItem("Chaos Warband (TL)");
			formationBox.removeItem("Maelstrom of Gore (TL)");
			formationBox.removeItem("The Lost And The Damned (TL)");
			formationBox.removeItem("Helforged Warpack (TL)");
			formationBox.removeItem("Heldrake Terror Pack (TL)");
			formationBox.removeItem("Cult Of Destruction (TL)");
			formationBox.removeItem("Fist Of The Gods (TL)");
			formationBox.removeItem("Raptor Talon (TL)");
			formationBox.removeItem("Terminator Annihilation Force (TL)");
			formationBox.removeItem("Favoured Of Chaos (TL)");
			formationBox.removeItem("Trinity Of Blood (TL)");
			formationBox.removeItem("War Cabal (TS)");
			formationBox.removeItem("War Coven (TS)");
			formationBox.removeItem("Tzaangor Warherd (TS)");
			formationBox.removeItem("Sekhmet Conclave (TS)");
			formationBox.removeItem("Ahriman's Exiles (TS)");
			formationBox.removeItem("Rehati War Sect (TS)");
			formationBox.removeItem("Plaque Colony (DG)");
			formationBox.removeItem("The Bringers of Despair (BL)");
			formationBox.removeItem("The Chosen of Abaddon (BL)");
			formationBox.removeItem("The Hounds of Abaddon (BL)");
			formationBox.removeItem("Daemon Engine Pack (BL)");
			formationBox.removeItem("Cyclopia Cabal (BL)");
			formationBox.removeItem("The Tormented (BL)");
			formationBox.removeItem("Black Legion Warband (BL)");
			formationBox.removeItem("Kakophoni (EC)");
			
			formationBox.addItem("Word Bearers Grand Host");
		} else if(getCountFromInformationVector("World Eaters")>0){
			formationBox.removeItem("The Ravagers (CS)");
			formationBox.removeItem("Disciples of Mannon (CS)");
			formationBox.removeItem("Brethren of the Dark Covenant (CS)");
			formationBox.removeItem("Cult of Slaughter (CS)");
			formationBox.removeItem("Lords of Slaughter (CS)");
			formationBox.removeItem("Kanon's Helguard (CS)");
			formationBox.removeItem("The Red Onslaught (CS)");
			formationBox.removeItem("Chaos Warband (TL)");
			formationBox.removeItem("Maelstrom of Gore (TL)");
			formationBox.removeItem("The Lost And The Damned (TL)");
			formationBox.removeItem("Helforged Warpack (TL)");
			formationBox.removeItem("Heldrake Terror Pack (TL)");
			formationBox.removeItem("Cult Of Destruction (TL)");
			formationBox.removeItem("Fist Of The Gods (TL)");
			formationBox.removeItem("Raptor Talon (TL)");
			formationBox.removeItem("Terminator Annihilation Force (TL)");
			formationBox.removeItem("Favoured Of Chaos (TL)");
			formationBox.removeItem("Trinity Of Blood (TL)");
			formationBox.removeItem("War Cabal (TS)");
			formationBox.removeItem("War Coven (TS)");
			formationBox.removeItem("Tzaangor Warherd (TS)");
			formationBox.removeItem("Sekhmet Conclave (TS)");
			formationBox.removeItem("Ahriman's Exiles (TS)");
			formationBox.removeItem("Rehati War Sect (TS)");
			formationBox.removeItem("Plaque Colony (DG)");
			formationBox.removeItem("The Bringers of Despair (BL)");
			formationBox.removeItem("The Chosen of Abaddon (BL)");
			formationBox.removeItem("The Hounds of Abaddon (BL)");
			formationBox.removeItem("Daemon Engine Pack (BL)");
			formationBox.removeItem("Cyclopia Cabal (BL)");
			formationBox.removeItem("The Tormented (BL)");
			formationBox.removeItem("Black Legion Warband (BL)");
			formationBox.removeItem("Kakophoni (EC)");
			
			formationBox.addItem("World Eaters Butcherhorde");
		} else{
			formationBox.removeItem("The Ravagers (CS)");
			formationBox.removeItem("Disciples of Mannon (CS)");
			formationBox.removeItem("Brethren of the Dark Covenant (CS)");
			formationBox.removeItem("Cult of Slaughter (CS)");
			formationBox.removeItem("Lords of Slaughter (CS)");
			formationBox.removeItem("Kanon's Helguard (CS)");
			formationBox.removeItem("The Red Onslaught (CS)");
			formationBox.removeItem("The Bringers of Despair (BL)");
			formationBox.removeItem("The Chosen of Abaddon (BL)");
			formationBox.removeItem("The Hounds of Abaddon (BL)");
			formationBox.removeItem("Daemon Engine Pack (BL)");
			formationBox.removeItem("Cyclopia Cabal (BL)");
			formationBox.removeItem("The Tormented (BL)");
			formationBox.removeItem("Black Legion Warband (BL)");
			formationBox.removeItem("War Cabal (TS)");
			formationBox.removeItem("War Coven (TS)");
			formationBox.removeItem("Tzaangor Warherd (TS)");
			formationBox.removeItem("Sekhmet Conclave (TS)");
			formationBox.removeItem("Ahriman's Exiles (TS)");
			formationBox.removeItem("Rehati War Sect (TS)");
			formationBox.removeItem("Kakophoni (EC)");
			formationBox.removeItem("Plaque Colony (DG)");
			
			formationBox.addItem("Chaos Warband (TL)");
			formationBox.addItem("Maelstrom of Gore (TL)");
			formationBox.addItem("The Lost And The Damned (TL)");
			formationBox.addItem("Helforged Warpack (TL)");
			formationBox.addItem("Heldrake Terror Pack (TL)");
			formationBox.addItem("Cult Of Destruction (TL)");
			formationBox.addItem("Fist Of The Gods (TL)");
			formationBox.addItem("Raptor Talon (TL)");
			formationBox.addItem("Terminator Annihilation Force (TL)");
			formationBox.addItem("Favoured Of Chaos (TL)");
			formationBox.addItem("Trinity Of Blood (TL)");
		}
		
		if(getCountFromInformationVector("Black Legion Speartip")>0){		
			formationBox.removeItem("The Ravagers (CS)");
			formationBox.removeItem("Disciples of Mannon (CS)");
			formationBox.removeItem("Brethren of the Dark Covenant (CS)");
			formationBox.removeItem("Cult of Slaughter (CS)");
			formationBox.removeItem("Lords of Slaughter (CS)");
			formationBox.removeItem("Kanon's Helguard (CS)");
			formationBox.removeItem("The Red Onslaught (CS)");
			formationBox.removeItem("Chaos Warband (TL)");
			formationBox.removeItem("Maelstrom of Gore (TL)");
			formationBox.addItem("The Lost And The Damned (TL)");
			formationBox.addItem("Helforged Warpack (TL)");
			formationBox.addItem("Heldrake Terror Pack (TL)");
			formationBox.addItem("Cult Of Destruction (TL)");
			formationBox.addItem("Fist Of The Gods (TL)");
			formationBox.addItem("Raptor Talon (TL)");
			formationBox.addItem("Terminator Annihilation Force (TL)");
			formationBox.removeItem("Favoured Of Chaos (TL)");
			formationBox.removeItem("Trinity Of Blood (TL)");
			formationBox.removeItem("War Cabal (TS)");
			formationBox.removeItem("War Coven (TS)");
			formationBox.removeItem("Tzaangor Warherd (TS)");
			formationBox.removeItem("Sekhmet Conclave (TS)");
			formationBox.removeItem("Ahriman's Exiles (TS)");
			formationBox.removeItem("Rehati War Sect (TS)");
			formationBox.removeItem("Plaque Colony (DG)");
			formationBox.addItem("The Bringers of Despair (BL)");
			formationBox.addItem("The Chosen of Abaddon (BL)");
			formationBox.addItem("The Hounds of Abaddon (BL)");
			formationBox.addItem("Daemon Engine Pack (BL)");
			formationBox.addItem("Cyclopia Cabal (BL)");
			formationBox.removeItem("The Tormented (BL)");
			formationBox.addItem("Black Legion Warband (BL)");
			formationBox.removeItem("Kakophoni (EC)");
			formationBox.addItem("Lord Of The Legion");
			formationBox.addItem("Spawn");
		}
		
		if(getCountFromInformationVector("Alpha Legion Insurgency Force")>0 || 
				getCountFromInformationVector("Iron Warriors Grand Company")>0 || 
				getCountFromInformationVector("Night Lords Murder Talon")>0 ||
				getCountFromInformationVector("Word Bearers Grand Host")>0 ||
				getCountFromInformationVector("World Eaters Butcherhorde")>0){		
			formationBox.removeItem("The Ravagers (CS)");
			formationBox.removeItem("Disciples of Mannon (CS)");
			formationBox.removeItem("Brethren of the Dark Covenant (CS)");
			formationBox.removeItem("Cult of Slaughter (CS)");
			formationBox.removeItem("Lords of Slaughter (CS)");
			formationBox.removeItem("Kanon's Helguard (CS)");
			formationBox.removeItem("The Red Onslaught (CS)");
			formationBox.addItem("Chaos Warband (TL)");
			if(getCountFromInformationVector("World Eaters Butcherhorde")>0)
				formationBox.addItem("Maelstrom of Gore (TL)");
			else
				formationBox.removeItem("Maelstrom of Gore (TL)");
			formationBox.addItem("The Lost And The Damned (TL)");
			formationBox.addItem("Helforged Warpack (TL)");
			formationBox.addItem("Heldrake Terror Pack (TL)");
			formationBox.addItem("Cult Of Destruction (TL)");
			formationBox.addItem("Fist Of The Gods (TL)");
			formationBox.addItem("Raptor Talon (TL)");
			formationBox.addItem("Terminator Annihilation Force (TL)");
			formationBox.addItem("Favoured Of Chaos (TL)");
			if(getCountFromInformationVector("Iron Warriors")>0)
				formationBox.addItem("Strongholds Of Chaos (TL)");
			else
				formationBox.removeItem("Strongholds Of Chaos (TL)");
			if(getCountFromInformationVector("World Eaters Butcherhorde")>0)
				formationBox.addItem("Trinity Of Blood (TL)");
			else
				formationBox.removeItem("Trinity Of Blood (TL)");
			formationBox.removeItem("War Cabal (TS)");
			formationBox.removeItem("War Coven (TS)");
			formationBox.removeItem("Tzaangor Warherd (TS)");
			formationBox.removeItem("Sekhmet Conclave (TS)");
			formationBox.removeItem("Ahriman's Exiles (TS)");
			formationBox.removeItem("Rehati War Sect (TS)");
			formationBox.removeItem("Plaque Colony (DG)");
			formationBox.removeItem("The Bringers of Despair (BL)");
			formationBox.removeItem("The Chosen of Abaddon (BL)");
			formationBox.removeItem("The Hounds of Abaddon (BL)");
			formationBox.removeItem("Daemon Engine Pack (BL)");
			formationBox.removeItem("Cyclopia Cabal (BL)");
			formationBox.removeItem("The Tormented (BL)");
			formationBox.removeItem("Black Legion Warband (BL)");
			formationBox.removeItem("Kakophoni (EC)");
			formationBox.addItem("Lord Of The Legion");
			formationBox.addItem("Spawn");
		}
		
		if(getCountFromInformationVector("Thousand Sons Grand Coven")>0){		
			formationBox.removeItem("The Ravagers (CS)");
			formationBox.removeItem("Disciples of Mannon (CS)");
			formationBox.removeItem("Brethren of the Dark Covenant (CS)");
			formationBox.removeItem("Cult of Slaughter (CS)");
			formationBox.removeItem("Lords of Slaughter (CS)");
			formationBox.removeItem("Kanon's Helguard (CS)");
			formationBox.removeItem("The Red Onslaught (CS)");
			formationBox.removeItem("Chaos Warband (TL)");
			formationBox.removeItem("Maelstrom of Gore (TL)");
			formationBox.removeItem("The Lost And The Damned (TL)");
			formationBox.removeItem("Helforged Warpack (TL)");
			formationBox.removeItem("Heldrake Terror Pack (TL)");
			formationBox.removeItem("Cult Of Destruction (TL)");
			formationBox.removeItem("Fist Of The Gods (TL)");
			formationBox.removeItem("Raptor Talon (TL)");
			formationBox.removeItem("Terminator Annihilation Force (TL)");
			formationBox.removeItem("Favoured Of Chaos (TL)");
			formationBox.removeItem("Trinity Of Blood (TL)");
			formationBox.addItem("War Cabal (TS)");
			formationBox.addItem("War Coven (TS)");
			formationBox.addItem("Tzaangor Warherd (TS)");
			formationBox.addItem("Sekhmet Conclave (TS)");
			formationBox.addItem("Ahriman's Exiles (TS)");
			formationBox.addItem("Rehati War Sect (TS)");
			formationBox.removeItem("Plaque Colony (DG)");
			formationBox.removeItem("The Bringers of Despair (BL)");
			formationBox.removeItem("The Chosen of Abaddon (BL)");
			formationBox.removeItem("The Hounds of Abaddon (BL)");
			formationBox.removeItem("Daemon Engine Pack (BL)");
			formationBox.removeItem("Cyclopia Cabal (BL)");
			formationBox.removeItem("The Tormented (BL)");
			formationBox.removeItem("Black Legion Warband (BL)");
			formationBox.removeItem("Kakophoni (EC)");
			formationBox.addItem("Lord Of The Legion");
			formationBox.removeItem("Spawn");
			formationBox.addItem("Daemon Engines");
			formationBox.addItem("Legion Armoury");
		}
		
		if(getCountFromInformationVector("Death Guard Vectorium")>0){		
			formationBox.removeItem("The Ravagers (CS)");
			formationBox.removeItem("Disciples of Mannon (CS)");
			formationBox.removeItem("Brethren of the Dark Covenant (CS)");
			formationBox.removeItem("Cult of Slaughter (CS)");
			formationBox.removeItem("Lords of Slaughter (CS)");
			formationBox.removeItem("Kanon's Helguard (CS)");
			formationBox.removeItem("The Red Onslaught (CS)");
			formationBox.addItem("Chaos Warband (TL)");
			formationBox.removeItem("Maelstrom of Gore (TL)");
			formationBox.addItem("The Lost And The Damned (TL)");
			formationBox.addItem("Helforged Warpack (TL)");
			formationBox.addItem("Heldrake Terror Pack (TL)");
			formationBox.addItem("Cult Of Destruction (TL)");
			formationBox.addItem("Fist Of The Gods (TL)");
			formationBox.addItem("Raptor Talon (TL)");
			formationBox.addItem("Terminator Annihilation Force (TL)");
			formationBox.addItem("Favoured Of Chaos (TL)");
			formationBox.removeItem("Trinity Of Blood (TL)");
			formationBox.removeItem("War Cabal (TS)");
			formationBox.removeItem("War Coven (TS)");
			formationBox.removeItem("Tzaangor Warherd (TS)");
			formationBox.removeItem("Sekhmet Conclave (TS)");
			formationBox.removeItem("Ahriman's Exiles (TS)");
			formationBox.removeItem("Rehati War Sect (TS)");
			formationBox.addItem("Plaque Colony (DG)");
			formationBox.removeItem("The Bringers of Despair (BL)");
			formationBox.removeItem("The Chosen of Abaddon (BL)");
			formationBox.removeItem("The Hounds of Abaddon (BL)");
			formationBox.removeItem("Daemon Engine Pack (BL)");
			formationBox.removeItem("Cyclopia Cabal (BL)");
			formationBox.removeItem("The Tormented (BL)");
			formationBox.removeItem("Black Legion Warband (BL)");
			formationBox.removeItem("Kakophoni (EC)");
			formationBox.addItem("Lord Of The Legion");
			formationBox.addItem("Spawn");
		}
		
		if(getCountFromInformationVector("Emperors Children Rapture Battalion")>0){		
			formationBox.removeItem("The Ravagers (CS)");
			formationBox.removeItem("Disciples of Mannon (CS)");
			formationBox.removeItem("Brethren of the Dark Covenant (CS)");
			formationBox.removeItem("Cult of Slaughter (CS)");
			formationBox.removeItem("Lords of Slaughter (CS)");
			formationBox.removeItem("Kanon's Helguard (CS)");
			formationBox.removeItem("The Red Onslaught (CS)");
			formationBox.addItem("Chaos Warband (TL)");
			formationBox.removeItem("Maelstrom of Gore (TL)");
			formationBox.addItem("The Lost And The Damned (TL)");
			formationBox.addItem("Helforged Warpack (TL)");
			formationBox.addItem("Heldrake Terror Pack (TL)");
			formationBox.addItem("Cult Of Destruction (TL)");
			formationBox.addItem("Fist Of The Gods (TL)");
			formationBox.addItem("Raptor Talon (TL)");
			formationBox.addItem("Terminator Annihilation Force (TL)");
			formationBox.addItem("Favoured Of Chaos (TL)");
			formationBox.removeItem("Trinity Of Blood (TL)");
			formationBox.removeItem("War Cabal (TS)");
			formationBox.removeItem("War Coven (TS)");
			formationBox.removeItem("Tzaangor Warherd (TS)");
			formationBox.removeItem("Sekhmet Conclave (TS)");
			formationBox.removeItem("Ahriman's Exiles (TS)");
			formationBox.removeItem("Rehati War Sect (TS)");
			formationBox.removeItem("Plaque Colony (DG)");
			formationBox.removeItem("The Bringers of Despair (BL)");
			formationBox.removeItem("The Chosen of Abaddon (BL)");
			formationBox.removeItem("The Hounds of Abaddon (BL)");
			formationBox.removeItem("Daemon Engine Pack (BL)");
			formationBox.removeItem("Cyclopia Cabal (BL)");
			formationBox.removeItem("The Tormented (BL)");
			formationBox.removeItem("Black Legion Warband (BL)");
			formationBox.addItem("Kakophoni (EC)");
			formationBox.addItem("Lord Of The Legion");
			formationBox.addItem("Spawn");
		}
	}
	
	@Override
	public void volkRefresh() {
		
		//BL
		//The Bringers of Despair: Abaddon, Chaos Terminators
		//The Chosen of Abaddon: 1-4 Chaos Lords or Sorcerers,//TODO  1 Chosen or Chaos Terminators per Lord/Sorcerer
		//The Hounds of Abaddon: 1 Chaos Lord, 1-3 Khorne Berzerkes, 1-3 Chaos Space Marines, 1-3 Raptors, Warps Talons, Bikers //Must take Marks of Khorne, at no cost
		//Daemon Engine Pack: 1 Warpsmith, 2 Forgefiends or Maulerfiends
		//Cyclopia Cabal: 3-5 Sorcerers
		//The Tormented: 1 Daemon Prince, 2-5 Possessed
		//Black Legion Warband: 1 Chaos Lord, 0-1 Sorcerer, 2-6 Chosen or CSM, 1-3 Chaos Terminators or Possessed, 1-3 Raptor or Warp Talons or Bikers, 1-3 Havocs or Helbrutes
				
		//CS
		//The Ravagers: 1 Chosen, 1 Possessed
		//Disciples of Mannon: 1 Sorcerer, 1 Possessed
		//Brethren of the Dark Covenant: 1 Dark Apostle, 1 Possessed, 1-3 CSM
		//Cult of Slaughter: 1 Dark Apostle, 2-8 Chaos Cultists
		//Lords of Slaughter: 1 Chaos Lord, 1 Possessed, 1 Chaos Terminators, 1-3 CSM
		//Kanon's Helguard: 1 Chaos Lord, 1 Chosen, 1 Chaos Terminators, 2 Chaos Cultists, 1 Raptors, 1 Chaos Land Raider, 1 Helbrute
		//The Red Onslaught: All Formations from above
		
		if(getKontingentTyp().equals("The Red Onslaught (CS)")){ //Superformation))
			superformation = new Superformation(getPanel(), 0);
			superformation.reflectionKennungLokal=reflectionKennungLokal;
			superformation.volkFile=getClass().getName();
			superformation.tA=buildatextArea;
			superformation.buildaVater=this;
			
			superformation.minCommand=0;
			superformation.maxCommand=0;
			superformation.minCore=6;
			superformation.maxCore=6;
			superformation.minAuxiliary=0;
			superformation.maxAuxiliary=0;

			superformation.namenCommand.add("");

			superformation.namenCore.add("");
			superformation.namenCore.add("The Ravagers (CS)");
			superformation.namenCore.add("Disciples of Mannon (CS)");
			superformation.namenCore.add("Brethren of the Dark Covenant (CS)");
			superformation.namenCore.add("Cult of Slaughter (CS)");
			superformation.namenCore.add("Lords of Slaughter (CS)");
			superformation.namenCore.add("Kanon's Helguard (CS)");

			superformation.namenAuxiliary.add("");

			for(int i=0;i<myChooserGruppen.size();i++){
				myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
			}

			superformation.refreshControlPanel();

			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);

			for(int i=1;i<7;i++){
				superformation.comboCore.setSelectedIndex(i);
			}
			
			superformation.comboCore.setEnabled(false);
			superformation.comboAuxiliary.setEnabled(false);
			superformation.comboCommand.setEnabled(false);
			
			RefreshListener.fireRefresh();
		}else if(getKontingentTyp().equals("Black Legion Speartip")){ //Superformation))
			setInformationVectorValue("Black Legion Speartip", 1);
			
			superformation = new Superformation(getPanel(), 0);
			superformation.reflectionKennungLokal=reflectionKennungLokal;
			superformation.volkFile=getClass().getName();
			superformation.tA=buildatextArea;
			superformation.buildaVater=this;
			
			superformation.minCommand=0;
			superformation.maxCommand=5;
			superformation.minCore=1;
			superformation.maxCore=Integer.MAX_VALUE;
			superformation.minAuxiliary=1;
			superformation.maxAuxiliary=Integer.MAX_VALUE;

			superformation.namenCommand.add("");
			superformation.namenCommand.add("The Bringers of Despair (BL)");
			superformation.namenCommand.add("Cyclopia Cabal (BL)");
			superformation.namenCommand.add("The Chosen of Abaddon (BL)");
			superformation.namenCommand.add("Lord Of The Legion");

			superformation.namenCore.add("");
			superformation.namenCore.add("Black Legion Warband (BL)");
			superformation.namenCore.add("The Hounds of Abaddon (BL)");

			superformation.namenAuxiliary.add("");
			superformation.namenAuxiliary.add("The Lost And The Damned (TL)");
			superformation.namenAuxiliary.add("Helforged Warpack (TL)");
			superformation.namenAuxiliary.add("Daemon Engine Pack (BL)");
			superformation.namenAuxiliary.add("Heldrake Terror Pack (TL)");
			superformation.namenAuxiliary.add("Cult Of Destruction (TL)");
			superformation.namenAuxiliary.add("Fist Of The Gods (TL)");
			superformation.namenAuxiliary.add("Raptor Talon (TL)");
			superformation.namenAuxiliary.add("Terminator Annihilation Force (TL)");
			superformation.namenAuxiliary.add("Spawn");

			for(int i=0;i<myChooserGruppen.size();i++){
				myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
			}

			superformation.refreshControlPanel();

			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
			
			superformation.comboCore.setEnabled(true);
			superformation.comboAuxiliary.setEnabled(true);
			superformation.comboCommand.setEnabled(true);
			
			RefreshListener.fireRefresh();
		} else if(getKontingentTyp().equals("Alpha Legion Insurgency Force")){ //Superformation))
			setInformationVectorValue("Alpha Legion Insurgency Force", 1);
			
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
			superformation.namenCommand.add("Lord Of The Legion");

			superformation.namenCore.add("");
			superformation.namenCore.add("Chaos Warband (TL)");

			superformation.namenAuxiliary.add("");
			superformation.namenAuxiliary.add("The Lost And The Damned (TL)");
			superformation.namenAuxiliary.add("Helforged Warpack (TL)");
			superformation.namenAuxiliary.add("Heldrake Terror Pack (TL)");
			superformation.namenAuxiliary.add("Cult Of Destruction (TL)");
			superformation.namenAuxiliary.add("Fist Of The Gods (TL)");
			superformation.namenAuxiliary.add("Raptor Talon (TL)");
			superformation.namenAuxiliary.add("Terminator Annihilation Force (TL)");
			superformation.namenAuxiliary.add("Favoured Of Chaos (TL)");
			superformation.namenAuxiliary.add("Spawn");

			for(int i=0;i<myChooserGruppen.size();i++){
				myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
			}

			superformation.refreshControlPanel();

			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
			
			superformation.comboCore.setEnabled(true);
			superformation.comboAuxiliary.setEnabled(true);
			superformation.comboCommand.setEnabled(true);
			
			RefreshListener.fireRefresh();
		} else if(getKontingentTyp().equals("Iron Warriors Grand Company")){ //Superformation))
			setInformationVectorValue("Iron Warriors Grand Company", 1);
			
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
			superformation.namenCommand.add("Lord Of The Legion");

			superformation.namenCore.add("");
			superformation.namenCore.add("Chaos Warband (TL)");

			superformation.namenAuxiliary.add("");
			superformation.namenAuxiliary.add("Strongholds Of Chaos (TL)");
			superformation.namenAuxiliary.add("The Lost And The Damned (TL)");
			superformation.namenAuxiliary.add("Helforged Warpack (TL)");
			superformation.namenAuxiliary.add("Heldrake Terror Pack (TL)");
			superformation.namenAuxiliary.add("Cult Of Destruction (TL)");
			superformation.namenAuxiliary.add("Fist Of The Gods (TL)");
			superformation.namenAuxiliary.add("Raptor Talon (TL)");
			superformation.namenAuxiliary.add("Terminator Annihilation Force (TL)");
			superformation.namenAuxiliary.add("Favoured Of Chaos (TL)");
			superformation.namenAuxiliary.add("Spawn");

			for(int i=0;i<myChooserGruppen.size();i++){
				myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
			}

			superformation.refreshControlPanel();

			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
			
			superformation.comboCore.setEnabled(true);
			superformation.comboAuxiliary.setEnabled(true);
			superformation.comboCommand.setEnabled(true);
			
			RefreshListener.fireRefresh();
		} else if(getKontingentTyp().equals("Night Lord Murder Talon")){ //Superformation))
			setInformationVectorValue("Night Lord Murder Talon", 1);
			
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
			superformation.namenCommand.add("Lord Of The Legion");

			superformation.namenCore.add("");
			superformation.namenCore.add("Chaos Warband (TL)");
			superformation.namenCore.add("Raptor Talon (TL)");

			superformation.namenAuxiliary.add("");
			superformation.namenAuxiliary.add("The Lost And The Damned (TL)");
			superformation.namenAuxiliary.add("Helforged Warpack (TL)");
			superformation.namenAuxiliary.add("Heldrake Terror Pack (TL)");
			superformation.namenAuxiliary.add("Cult Of Destruction (TL)");
			superformation.namenAuxiliary.add("Fist Of The Gods (TL)");
			superformation.namenAuxiliary.add("Terminator Annihilation Force (TL)");
			superformation.namenAuxiliary.add("Favoured Of Chaos (TL)");
			superformation.namenAuxiliary.add("Spawn");

			for(int i=0;i<myChooserGruppen.size();i++){
				myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
			}

			superformation.refreshControlPanel();

			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
			
			superformation.comboCore.setEnabled(true);
			superformation.comboAuxiliary.setEnabled(true);
			superformation.comboCommand.setEnabled(true);
			
			RefreshListener.fireRefresh();
		} else if(getKontingentTyp().equals("Word Bearers Grand Host")){ //Superformation))
			setInformationVectorValue("Word Bearers Grand Host", 1);
			
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
			superformation.namenCommand.add("Lord Of The Legion");

			superformation.namenCore.add("");
			superformation.namenCore.add("Chaos Warband (TL)");
			superformation.namenCore.add("The Lost And The Damned (TL)");

			superformation.namenAuxiliary.add("");
			superformation.namenAuxiliary.add("Helforged Warpack (TL)");
			superformation.namenAuxiliary.add("Heldrake Terror Pack (TL)");
			superformation.namenAuxiliary.add("Cult Of Destruction (TL)");
			superformation.namenAuxiliary.add("Fist Of The Gods (TL)");
			superformation.namenAuxiliary.add("Raptor Talon (TL)");
			superformation.namenAuxiliary.add("Terminator Annihilation Force (TL)");
			superformation.namenAuxiliary.add("Favoured Of Chaos (TL)");
			superformation.namenAuxiliary.add("Spawn");

			for(int i=0;i<myChooserGruppen.size();i++){
				myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
			}

			superformation.refreshControlPanel();

			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
			
			superformation.comboCore.setEnabled(true);
			superformation.comboAuxiliary.setEnabled(true);
			superformation.comboCommand.setEnabled(true);
			
			RefreshListener.fireRefresh();
		} else if(getKontingentTyp().equals("World Eaters Butcherhorde")){ //Superformation))
			setInformationVectorValue("World Eaters Butcherhorde", 1);
			
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
			superformation.namenCommand.add("Lord Of The Legion");

			superformation.namenCore.add("");
			superformation.namenCore.add("Chaos Warband (TL)");
			superformation.namenCore.add("Maelstrom Of Gore (TL)");

			superformation.namenAuxiliary.add("");
			superformation.namenAuxiliary.add("The Lost And The Damned (TL)");
			superformation.namenAuxiliary.add("Helforged Warpack (TL)");
			superformation.namenAuxiliary.add("Heldrake Terror Pack (TL)");
			superformation.namenAuxiliary.add("Cult Of Destruction (TL)");
			superformation.namenAuxiliary.add("Fist Of The Gods (TL)");
			superformation.namenAuxiliary.add("Raptor Talon (TL)");
			superformation.namenAuxiliary.add("Terminator Annihilation Force (TL)");
			superformation.namenAuxiliary.add("Favoured Of Chaos (TL)");
			superformation.namenAuxiliary.add("Trinity Of Blood (TL)");
			superformation.namenAuxiliary.add("Spawn");

			for(int i=0;i<myChooserGruppen.size();i++){
				myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
			}

			superformation.refreshControlPanel();

			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
			
			superformation.comboCore.setEnabled(true);
			superformation.comboAuxiliary.setEnabled(true);
			superformation.comboCommand.setEnabled(true);
			
			RefreshListener.fireRefresh();
		} else if(getKontingentTyp().equals("Thousand Sons Grand Coven")){ //Superformation))
			setInformationVectorValue("Thousand Sons Grand Coven", 1);
			
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
			superformation.namenCommand.add("Lord Of The Legion");
			superformation.namenCommand.add("Rehati War Sect (TS)");
			superformation.namenCommand.add("Ahriman's Exiles (TS)");
			
			superformation.namenCore.add("");
			superformation.namenCore.add("War Cabal (TS)");
			superformation.namenCore.add("Sekhmet Conclave (TS)");

			superformation.namenAuxiliary.add("");
			superformation.namenAuxiliary.add("War Coven (TS)");
			superformation.namenAuxiliary.add("Tzaangor Warherd (TS)");
			superformation.namenAuxiliary.add("Daemon Engines");
			superformation.namenAuxiliary.add("Legion Armoury");

			for(int i=0;i<myChooserGruppen.size();i++){
				myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
			}

			superformation.refreshControlPanel();

			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
			
			superformation.comboCore.setEnabled(true);
			superformation.comboAuxiliary.setEnabled(true);
			superformation.comboCommand.setEnabled(true);
			
			RefreshListener.fireRefresh();
		} else if(getKontingentTyp().equals("Death Guard Vectorium")){ //Superformation))
			setInformationVectorValue("Death Guard Vectorium", 1);
			
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
			superformation.namenCommand.add("Lord Of The Legion");

			superformation.namenCore.add("");
			superformation.namenCore.add("Chaos Warband (TL)");
			superformation.namenCore.add("Plaque Colony (DG)");

			superformation.namenAuxiliary.add("");
			superformation.namenAuxiliary.add("The Lost And The Damned (TL)");
			superformation.namenAuxiliary.add("Helforged Warpack (TL)");
			superformation.namenAuxiliary.add("Heldrake Terror Pack (TL)");
			superformation.namenAuxiliary.add("Cult Of Destruction (TL)");
			superformation.namenAuxiliary.add("Fist Of The Gods (TL)");
			superformation.namenAuxiliary.add("Raptor Talon (TL)");
			superformation.namenAuxiliary.add("Terminator Annihilation Force (TL)");
			superformation.namenAuxiliary.add("Favoured Of Chaos (TL)");
			superformation.namenAuxiliary.add("Spawn");

			for(int i=0;i<myChooserGruppen.size();i++){
				myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
			}

			superformation.refreshControlPanel();

			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
			
			superformation.comboCore.setEnabled(true);
			superformation.comboAuxiliary.setEnabled(true);
			superformation.comboCommand.setEnabled(true);
			
			RefreshListener.fireRefresh();
		} else if(getKontingentTyp().equals("Emperors Children Rapture Battalion")){ //Superformation))
			setInformationVectorValue("Emperors Children Rapture Battalion", 1);
			
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
			superformation.namenCommand.add("Lord Of The Legion");

			superformation.namenCore.add("");
			superformation.namenCore.add("Chaos Warband (TL)");
			superformation.namenCore.add("Kakophoni (EC)");

			superformation.namenAuxiliary.add("");
			superformation.namenAuxiliary.add("The Lost And The Damned (TL)");
			superformation.namenAuxiliary.add("Helforged Warpack (TL)");
			superformation.namenAuxiliary.add("Heldrake Terror Pack (TL)");
			superformation.namenAuxiliary.add("Cult Of Destruction (TL)");
			superformation.namenAuxiliary.add("Fist Of The Gods (TL)");
			superformation.namenAuxiliary.add("Raptor Talon (TL)");
			superformation.namenAuxiliary.add("Terminator Annihilation Force (TL)");
			superformation.namenAuxiliary.add("Favoured Of Chaos (TL)");
			superformation.namenAuxiliary.add("Spawn");

			for(int i=0;i<myChooserGruppen.size();i++){
				myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
			}

			superformation.refreshControlPanel();

			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
			
			superformation.comboCore.setEnabled(true);
			superformation.comboAuxiliary.setEnabled(true);
			superformation.comboCommand.setEnabled(true);
			
			RefreshListener.fireRefresh();
		} else if(getKontingentTyp().equals("The Ravagers (CS)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Auserkorene"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "Besessene"});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Auserkorene"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Besessene"}, 1, 1));
			
			if(!isLoading){
				addUnitNotLocked(1,"Auserkorene");
				addUnitNotLocked(2,"Besessene");
			}
			
			supplementBox.setEnabled(false);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("Disciples of Mannon (CS)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Hexer"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "Besessene"});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Hexer"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Besessene"}, 1, 1));
			
			if(!isLoading){
				addUnitNotLocked(0,"Hexer");
				addUnitNotLocked(2,"Besessene");
			}
			
			supplementBox.setEnabled(false);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("Brethren of the Dark Covenant (CS)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Dunkler Apostel"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "Besessene", "Chaos Space Marines"});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Dunkler Apostel"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Besessene"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Chaos Space Marines"}, 1, 3));
			
			if(!isLoading){
				addUnitNotLocked(0,"Dunkler Apostel");
				addUnitNotLocked(2,"Besessene");
				addUnitNotLocked(2,"Chaos Space Marines");
			}
			
			supplementBox.setEnabled(false);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("Cult of Slaughter (CS)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Dunkler Apostel"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "Chaoskultisten"});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Dunkler Apostel"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Chaoskultisten"}, 2, 8));
			
			if(!isLoading){
				addUnitNotLocked(0,"Dunkler Apostel");
				addUnitNotLocked(2,"Chaoskultisten");
			}
			
			supplementBox.setEnabled(false);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("Lords of Slaughter (CS)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Chaosgeneral"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Chaosterminatoren"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "Besessene", "Chaos Space Marines"});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Chaosgeneral"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Besessene"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Chaosterminatoren"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Chaos Space Marines"}, 1, 3));
			
			if(!isLoading){
				addUnitNotLocked(0,"Chaosgeneral");
				addUnitNotLocked(2,"Besessene");
				addUnitNotLocked(1,"Chaosterminatoren");
				addUnitNotLocked(2,"Chaos Space Marines");
			}
			
			supplementBox.setEnabled(false);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("Kanon's Helguard (CS)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Chaosgeneral"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Auserkorene", "Chaosterminatoren", "Höllenschlächter"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "Chaoskultisten"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "Raptoren"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "Land Raider des Chaos"});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Chaosgeneral"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Auserkorene"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Chaosterminatoren"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Chaoskultisten"}, 2, 2));
			formation.entries.add(new FormationEntry(new String[]{"Raptoren"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Land Raider des Chaos"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Höllenschlächter"}, 1, 1));
			
			if(!isLoading){
				addUnitNotLocked(0,"Chaosgeneral");
				addUnitNotLocked(1,"Auserkorene");
				addUnitNotLocked(1,"Chaosterminatoren");
				addUnitNotLocked(2,"Chaoskultisten");
				addUnitNotLocked(3,"Raptoren");
				addUnitNotLocked(4,"Land Raider des Chaos");
				addUnitNotLocked(1,"Höllenschlächter");
			}
			
			supplementBox.setEnabled(false);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("The Bringers of Despair (BL)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Abaddon der Vernichter"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Chaosterminatoren"});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Abaddon der Vernichter"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Chaosterminatoren"}, 1, 1));
			formation.infoLabel.setText("<html>Info:<br>"
					+ "1x Auserkorene/Chaosterminatoren per Chaosgeneral/Hexer.<html>");
			
			if(!isLoading){
				addUnitNotLocked(0,"Abaddon der Vernichter");
				addUnitNotLocked(1,"Chaosterminatoren");
			}
			
			supplementBox.setEnabled(false);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("The Chosen of Abaddon (BL)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Chaosgeneral", "Hexer"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Chaosterminatoren"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "Auserkorene"});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Chaosgeneral", "Hexer"}, 1, 4));
			formation.entries.add(new FormationEntry(new String[]{"Chaosterminatoren", "Auserkorene"}, 1, 4));
			formation.infoLabel.setText("<html>Info:<br>"
					+ "1x Auserkorene/Chaosterminatoren per Chaosgeneral/Hexer.<html>");
			
			supplementBox.setEnabled(false);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("The Hounds of Abaddon (BL)")){
			addToInformationVector("Formation", 1);
			addToInformationVector("The Hounds of Abaddon (BL)", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Chaosgeneral"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"","Khorne-Berserker","Chaos Space Marines"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "Chaosbiker", "Raptoren", "Warpkrallen"});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Chaosgeneral"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Khorne-Berserker"}, 1, 3));
			formation.entries.add(new FormationEntry(new String[]{"Chaos Space Marines"}, 1, 3));
			formation.entries.add(new FormationEntry(new String[]{"Chaosbiker", "Raptoren", "Warpkrallen"}, 1, 3));
			
			if(!isLoading){
				addUnitNotLocked(0,"Chaosgeneral");
			}
			
			supplementBox.setEnabled(false);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("Daemon Engine Pack (BL)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Warpschmied"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"","Schmiedemonstrum", "Klauenmonstrum"});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Warpschmied"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Schmiedemonstrum", "Klauenmonstrum"}, 2, 2));
			
			if(!isLoading){
				addUnitNotLocked(0,"Warpschmied");
			}
			
			supplementBox.setEnabled(false);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("Cyclopia Cabal (BL)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Hexer"});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Hexer"}, 3, 5));
			
			if(!isLoading){
				addUnitNotLocked(0,"Hexer");
			}
			
			supplementBox.setEnabled(false);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("The Tormented (BL)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Dämonenprinz"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Besessene"});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Dämonenprinz"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Besessene"}, 2, 5));
			
			if(!isLoading){
				addUnitNotLocked(0,"Dämonenprinz");
				addUnitNotLocked(1,"Besessene");
			}
			
			supplementBox.setEnabled(false);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("Black Legion Warband (BL)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Chaosgeneral", "Hexer"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Besessene", "Chaosterminatoren", "Höllenschlächter"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "Auserkorene", "Chaos Space Marines"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "Chaosbiker", "Raptoren", "Warpkrallen"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "Havocs"});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Chaosgeneral"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Hexer"}, 0, 1));
			formation.entries.add(new FormationEntry(new String[]{"Auserkorene", "Chaos Space Marines"}, 2, 6));
			formation.entries.add(new FormationEntry(new String[]{"Besessene", "Chaosterminatoren"}, 1, 3));
			formation.entries.add(new FormationEntry(new String[]{"Chaosbiker", "Raptoren", "Warpkrallen"}, 1, 3));
			formation.entries.add(new FormationEntry(new String[]{"Havocs", "Höllenschlächter"}, 1, 3));
			
			if(!isLoading){
				addUnitNotLocked(0,"Chaosgeneral");
			}
			
			supplementBox.setEnabled(false);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("Chaos Warband (TL)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Chaosgeneral", "Hexer", "Abaddon der Vernichter", "Ahriman", "Fabius Gallus", "Huron Schwarzherz", "Kharn der Verräter", "Lucius der Ewige", "Typhus"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Besessene", "Chaosterminatoren", "Auserkorene"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "Chaos Space Marines"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "Chaosbiker", "Raptoren", "Warpkrallen"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "Havocs", "Höllenschlächter"});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Chaosgeneral"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Hexer"}, 0, 1));
			formation.entries.add(new FormationEntry(new String[]{"Chaos Space Marines"}, 2, 6));
			formation.entries.add(new FormationEntry(new String[]{"Auserkorene", "Besessene", "Chaosterminatoren"}, 1, 3));
			formation.entries.add(new FormationEntry(new String[]{"Chaosbiker", "Raptoren", "Warpkrallen"}, 1, 3));
			formation.entries.add(new FormationEntry(new String[]{"Havocs", "Höllenschlächter"}, 1, 3));
			
			if(!isLoading){
				addUnitNotLocked(0,"Chaosgeneral");
				addUnit(2,"Chaos Space Marines");
				addUnit(2,"Chaos Space Marines");
			}
			
			supplementBox.setEnabled(false);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("Maelstrom of Gore (TL)")){
			addToInformationVector("Maelstrom of Gore (TL)", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Chaosgeneral", "Kharn der Verräter"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Khorne Berserker"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Chaosgeneral", "Kharn der Verräter"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Khorne Berserker"}, 4, 8));
			
			if(!isLoading){
				addUnitNotLocked(0,"Chaosgeneral");
				addUnit(1,"Khorne Berserker");
				addUnit(1,"Khorne Berserker");
				addUnit(1,"Khorne Berserker");
				addUnit(1,"Khorne Berserker");
			}
			
			supplementBox.setEnabled(false);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("The Lost And The Damned (TL)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Dunkler Apostel"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "Chaoskultisten"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Dunkler Apostel"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Chaoskultisten"}, 4, 9));
			
			if(!isLoading){
				addUnit(0,"Dunkler Apostel");
				addUnit(2,"Chaoskultisten");
				addUnit(2,"Chaoskultisten");
				addUnit(2,"Chaoskultisten");
				addUnit(2,"Chaoskultisten");
			}
			
			supplementBox.setEnabled(false);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("Strongholds Of Chaos (TL)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{"", "[BK] Aegis-Verteidigungslinie", "[BK] Himmelsschild-Landeplattform", "[BK] Imperiale Bastion", "[BK] Festung der Erlösung", "[BK] Vergelter Waffenbatterie","[BK] Feuersturm Abwehrstellung",
							"[BK] Aquilla-Artilleriebunker", "[BK] Deflektor-Relaisnetzwerk", "[BK] Deflektor-Schildgenerator","[BK] Ehrwürdiges Imperium 1","[BK] Befestigte Stellung","[BK] Imperialer Bunker",
							"[BK] Imperiale Verteidigungslinie","[BK] Imperiale Verteidigungsstellung","[BK] Promethium-Relaisleitungen","[BK] Imperiales Verteidigungsnetzwerk",
							"", "Plasma Obliterator"});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"[BK] Aegis-Verteidigungslinie", "[BK] Himmelsschild-Landeplattform", "[BK] Imperiale Bastion", "[BK] Festung der Erlösung", "[BK] Vergelter Waffenbatterie","[BK] Feuersturm Abwehrstellung",
							"[BK] Aquilla-Artilleriebunker", "[BK] Deflektor-Relaisnetzwerk", "[BK] Deflektor-Schildgenerator","[BK] Ehrwürdiges Imperium 1","[BK] Befestigte Stellung","[BK] Imperialer Bunker",
							"[BK] Imperiale Verteidigungslinie","[BK] Imperiale Verteidigungsstellung","[BK] Promethium-Relaisleitungen","[BK] Imperiales Verteidigungsnetzwerk",
							"Plasma Obliterator"}, 1, 3));
			
			if(!isLoading){
			}
			
			supplementBox.setEnabled(false);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		} else if(getKontingentTyp().equals("Helforged Warpack (TL)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Warpschmied"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "Höllenschlächter", "Schmiedemonstrum", "Klauenmonstrum", "Geißel" });
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Warpschmied"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Höllenschlächter", "Schmiedemonstrum", "Klauenmonstrum", "Geißel"}, 3, 5));
			
			if(!isLoading){
				addUnit(0,"Warpschmied");
			}
		} else if(getKontingentTyp().equals("Heldrake Terror Pack (TL)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "Höllendrache"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Höllendrache"}, 2, 4));
			
			if(!isLoading){
				addUnit(FA,"Höllendrache");
				addUnit(FA,"Höllendrache");
			}
		}else if(getKontingentTyp().equals("Cult Of Destruction (TL)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Warpschmied"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Mutilator"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "Kyborg" });
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Warpschmied"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Mutilator", "Kyborg"}, 3, 5));
			
			if(!isLoading){
				addUnit(0,"Warpschmied");
			}
		} else if(getKontingentTyp().equals("Fist Of The Gods (TL)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Warpschmied"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "Land Raider des Chaos", "Vindicator des Chaos", "Predator des Chaos" });
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Warpschmied"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Land Raider des Chaos", "Vindicator des Chaos", "Predator des Chaos"}, 3, 5));
			
			if(!isLoading){
				addUnit(0,"Warpschmied");
			}
		} else if(getKontingentTyp().equals("Raptor Talon (TL)")){
			addToInformationVector("Raptor Talon (TL)", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Chaosgeneral"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "Raptoren", "Warpkrallen"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Warpschmied"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Raptoren", "Warpkrallen"}, 3, 5));
			
			if(!isLoading){
				addUnit(0,"Chaosgeneral");
			}
		} else if(getKontingentTyp().equals("Terminator Annihilation Force (TL)")){
			addToInformationVector("Terminator Annihilation Force (TL)", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Chaosgeneral", "Hexer"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Chaosterminatoren"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Chaosgeneral", "Hexer"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Chaosterminatoren"}, 3, 5));
			
			if(!isLoading){
				addUnitNotLocked(0,"Chaosgeneral");
				addUnit(1,"Chaosterminatoren");
				addUnit(1,"Chaosterminatoren");
				addUnit(1,"Chaosterminatoren");
			}
		} else if(getKontingentTyp().equals("Favoured Of Chaos (TL)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Dämonenprinz"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Besessene"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Dämonenprinz"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Besessene"}, 3, 5));
			
			if(!isLoading){
				addUnitNotLocked(0,"Dämonenprinz");
				addUnit(1,"Besessene");
				addUnit(1,"Besessene");
				addUnit(1,"Besessene");
			}
		} else if(getKontingentTyp().equals("Trinity Of Blood (TL)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{"", "Schädelherrscher des Khorne"});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Schädelherrscher des Khorne"}, 3, 3));
			
			if(!isLoading){
				addUnit(LOW,"Schädelherrscher des Khorne");
				addUnit(LOW,"Schädelherrscher des Khorne");
				addUnit(LOW,"Schädelherrscher des Khorne");
			}
		} else if(getKontingentTyp().equals("War Cabal (TS)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Ahriman", "Dämonenprinz", "Exalted Sorcerer", "Hexer"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Scarab Occult Terminators"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "Rubric Marines"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Ahriman", "Dämonenprinz"}, 0, 1));
			formation.entries.add(new FormationEntry(new String[]{"Exalted Sorcerer", "Hexer"}, 1, 4));
			formation.entries.add(new FormationEntry(new String[]{"Rubric Marines"}, 1, 3));
			formation.entries.add(new FormationEntry(new String[]{"Scarab Occult Terminators"}, 1, 3));
			
			if(!isLoading){
				addUnitNotLocked(HQ,"Ahriman");
				addUnitNotLocked(HQ,"Exalted Sorcerer");
				addUnit(TR,"Rubric Marines");
				addUnit(EL,"Scarab Occult Terminators");
			}
		} else if(getKontingentTyp().equals("War Coven (TS)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Dämonenprinz", "Exalted Sorcerer", "Hexer"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Scarab Occult Terminators"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "Rubric Marines"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Dämonenprinz"}, 0, 1));
			formation.entries.add(new FormationEntry(new String[]{"Exalted Sorcerer", "Hexer"}, 3, 10));
			
			if(!isLoading){
				addUnitNotLocked(HQ,"Dämonenprinz");
				addUnitNotLocked(HQ,"Exalted Sorcerer");
				addUnitNotLocked(HQ,"Exalted Sorcerer");
				addUnitNotLocked(HQ,"Exalted Sorcerer");
			}
		} else if(getKontingentTyp().equals("Tzaangor Warherd (TS)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Exalted Sorcerer", "Hexer"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "Tzaangors"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "Chaosbrut"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Exalted Sorcerer", "Hexer"}, 1, 1));
			
			if(!isLoading){
				addUnitNotLocked(HQ,"Exalted Sorcerer");
				addUnit(TR,"Tzaangors");
				addUnit(TR,"Tzaangors");
				addUnit(TR,"Tzaangors");
			}
		} else if(getKontingentTyp().equals("Sekhmet Conclave (TS)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Ahriman", "Dämonenprinz", "Exalted Sorcerer", "Hexer"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Scarab Occult Terminators"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{"", "Magnus The Red"});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Ahriman", "Dämonenprinz", "Exalted Sorcerer", "Hexer", "Magnus The Red"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Scarab Occult Terminators"}, 3, 9));
			
			if(!isLoading){
				addUnitNotLocked(HQ,"Exalted Sorcerer");
				addUnit(EL,"Scarab Occult Terminators");
				addUnit(EL,"Scarab Occult Terminators");
				addUnit(EL,"Scarab Occult Terminators");
			}
		} else if(getKontingentTyp().equals("Ahriman's Exiles (TS)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Ahriman", "Exalted Sorcerer"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Ahriman"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Exalted Sorcerer"}, 3, 9));
			
			if(!isLoading){
				addUnit(HQ,"Ahriman");
				addUnit(HQ,"Exalted Sorcerer");
				addUnit(HQ,"Exalted Sorcerer");
				addUnit(HQ,"Exalted Sorcerer");
			}
		} else if(getKontingentTyp().equals("Rehati War Sect (TS)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Dämonenprinz", "Exalted Sorcerer"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{"", "Magnus The Red"});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Magnus The Red"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Dämonenprinz", "Exalted Sorcerer"}, 3, 9));
			
			if(!isLoading){
				addUnit(LOW,"Magnus The Red");
				addUnitNotLocked(HQ,"Exalted Sorcerer");
				addUnitNotLocked(HQ,"Exalted Sorcerer");
				addUnitNotLocked(HQ,"Exalted Sorcerer");
			}
		} else if(getKontingentTyp().equals("Plaque Colony (DG)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Chaosgeneral", "Typhus"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "Seuchenmarines"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Chaosgeneral", "Typhus"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Seuchenmarines"}, 3, 7));
			
			if(!isLoading){
				addUnitNotLocked(HQ,"Chaosgeneral");
				addUnitNotLocked(TR,"Seuchenmarines");
				addUnitNotLocked(TR,"Seuchenmarines");
				addUnitNotLocked(TR,"Seuchenmarines");
			}
		} else if(getKontingentTyp().equals("Kakophoni (EC)")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Chaosgeneral", "Lucius der Ewige"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "Noisemarines"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Chaosgeneral", "Lucius der Ewige"}, 1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Noisemarines"}, 3, 6));
			
			if(!isLoading){
				addUnitNotLocked(HQ,"Chaosgeneral");
				addUnitNotLocked(TR,"Noisemarines");
				addUnitNotLocked(TR,"Noisemarines");
				addUnitNotLocked(TR,"Noisemarines");
			}
		} else if(getKontingentTyp().equals("Lord Of The Legion")){
			addToInformationVector("Formation", 1);
			clearCombo();
			
			formation=new Formation(this);
			if(getCountFromInformationVector("BlackLegion")==1)
			{
				myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Chaosgeneral", "Hexer", "Dämonenprinz", "Dunkler Apostel", "Abaddon der Vernichter"});
				formation.entries.add(new FormationEntry(new String[]{"Chaosgeneral", "Hexer", "Dämonenprinz", "Dunkler Apostel", "Abaddon der Vernichter"}, 1, 1));
			}
			else if(getCountFromInformationVector("World Eaters")==1)
			{
				myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Chaosgeneral", "Dämonenprinz", "Dunkler Apostel"});
				formation.entries.add(new FormationEntry(new String[]{"Chaosgeneral", "Dämonenprinz", "Dunkler Apostel"}, 1, 1));
			}
			else if(getCountFromInformationVector("Thousand Sons")==1)
			{
				myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Ahriman", "Dämonenprinz", "Dunkler Apostel"});
				formation.entries.add(new FormationEntry(new String[]{"Ahriman", "Dämonenprinz", "Dunkler Apostel", "Magnus The Red"}, 1, 1));
			}
			else
			{
				myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Chaosgeneral", "Hexer", "Dämonenprinz", "Dunkler Apostel"});
				formation.entries.add(new FormationEntry(new String[]{"Chaosgeneral", "Hexer", "Dämonenprinz", "Dunkler Apostel"}, 1, 1));
			}
				
				
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
			
			if(getCountFromInformationVector("Thousand Sons")==1)
				myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{"", "Magnus The Red"});
		} else if(getKontingentTyp().equals("Spawn")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "Chaosbrut"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Chaosbrut"}, 1, 3));
			
			if(!isLoading){
				addUnitNotLocked(FA,"Chaosbrut");
			}
		} else if(getKontingentTyp().equals("Daemon Engines")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "Höllendrache"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "Höllenschlächter", "Schmiedemonstrum", "Klauenmonstrum", "Geißel"});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Höllendrache", "Höllenschlächter", "Schmiedemonstrum", "Klauenmonstrum", "Geißel"}, 1, 3));
			
			if(!isLoading){
			}
		} else if(getKontingentTyp().equals("Legion Armoury")){
			addToInformationVector("Formation", 1);
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "Land Raider des Chaos", "Vindicator des Chaos", "Predator des Chaos"});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
			
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Land Raider des Chaos", "Vindicator des Chaos", "Predator des Chaos"}, 1, 3));
			
			if(!isLoading){
			}
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