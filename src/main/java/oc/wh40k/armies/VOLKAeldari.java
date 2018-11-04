package oc.wh40k.armies;

import java.io.InputStream;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VOLKAeldari extends BuildaVater {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VOLKAeldari.class);	

	public VOLKAeldari() {

		reflectionKennung = "AE";
		InputStream is = this.getClass().getResourceAsStream("/oc/wh40k/indices/ae.csv");
		pointValues = BuildaHQ.loadindexFile(is);
		
		System.err.println("File: " + "/oc/wh40k/indices/de.csv");
		is = this.getClass().getResourceAsStream("/oc/wh40k/indices/de.csv");
		appendPointList(BuildaHQ.loadindexFile(is));
		
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
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, DT, Transporteinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, FL, Fliegereinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, FORT, Befestigungen));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, LOW, LordofWar));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		
		cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

		nameDerArtDerArmee = BuildaHQ.translate("AELDARI");
		nameDerArtDerArmeeDekliniert = BuildaHQ.translate("AELDARI");
		textAreaUeberschrift = BuildaHQ.translate("Meine") + " " + BuildaHQ.translate("AELDARI");		
		
		formationen.add("AELDARI");
		formationen.add("Asuryani");
		formationen.add("Warhost");
		formationen.add("Spirit Host");
		formationen.add("Aspect Warrior");
		formationen.add("Ulthwe");
		formationen.add("Iyanden");
		formationen.add("Alaitoc");
		formationen.add("");
		formationen.add("Drukhari");
		formationen.add("Wych Cult of Strife");
		formationen.add("Prophets of Flesh");
		formationen.add("Incubi");
		formationen.add("");
		formationen.add("Harlequins");
		formationen.add("");
		formationen.add("Ynnari");
		
		complete();
	}

	@Override
	public void volkRefresh() {
		if(getFormationType().equals("AELDARI")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
					"", "Autarch", "Autarch with Swooping Hawk Wings", "Autarch Skyrunner", 
					"Farseer", "Farseer Skyrunner", "Warlock", "Warlock Conclave", "Warlock Skyrunner", 
					"Warlock Skyrunner Conclave", "Spiritseer",

					"", "Eldrad Ulthran", "Prince Yriel", "Illic Nightspear", "Asurmen", "Jain Zar", "Karandras", "Fuegan", 
					"Baharroth", "Maugan Ra", "Avatar of Khaine",

					"", "Archon", "Succubus", "Haemonculus",

					"", "Lelith Hesperax", "Urien Rakarth", "Drazhar",

					"", "Troupe Master", "Shadowseer",

					"", "Yvraine", "The Visarch", "The Yncarne",
					"", "Autarch Index", "Autarch with Swooping Hawk Wings Index", "Autarch with Warp Jump Generator Index", "Autarch Skyrunner Index"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
					"", "Guardian Defenders", "Storm Guardians", "Rangers", "Dire Avengers", 

					"", "Kabalite Warriors", "Wyches", "Wracks",

					"", "Troupe"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
					"", "Howling Banshees", "Striking Scorpions", "Fire Dragons", "Wraithguard", "Wraithblades", "Bonesinger",

					"", "Lhamaean", "Medusae", "Sslyth", "Ur-Ghul", "Kabalite Trueborn", "Hekatrix Bloodbrides", "Incubi", 
					"Mandrakes", "Grotesques", "Beastmaster",

					"", "Death Jester", "Solitaire"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{
					"", "Windriders", "Swooping Hawks", "Warp Spiders", "Shining Spears", "Vypers",

					"", "Clawed Fiends", "Khymerae", "Razorwing Flocks", "Reavers", "Hellions", "Scourges",

					"", "Skyweavers"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
					"", "Dark Reapers", "Vaul's Wrath Support Battery", "Falcon", "Fire Prism", "Night Spinner", "War Walkers", 
					"Wraithlord",

					"", "Talos", "Cronos", "Ravager",
					
					"", "Reaper", "Tantalus",

					"", "Voidweavers"});
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{
					"", "Wave Serpent",

					"", "Raider", "Venom",

					"", "Starweaver"});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{
					"", "Wraithknight"});
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{
					"", "Crimson Hunter", "Crimson Hunter Exarch", "Hemlock Wraithfighter",

					"", "Razorwing Jetfighter", "Voidraven"});
		} else if(getFormationType().equals("Asuryani")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
					"", "Autarch", "Autarch with Swooping Hawk Wings", "Autarch Skyrunner", 
					"Farseer", "Farseer Skyrunner", "Warlock", "Warlock Conclave", "Warlock Skyrunner", 
					"Warlock Skyrunner Conclave", "Spiritseer",

					"", "Eldrad Ulthran", "Prince Yriel", "Illic Nightspear", "Asurmen", "Jain Zar", "Karandras", "Fuegan", 
					"Baharroth", "Maugan Ra", "Avatar of Khaine",
					"", "Autarch Index", "Autarch with Swooping Hawk Wings Index", "Autarch with Warp Jump Generator Index", "Autarch Skyrunner Index"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
					"", "Guardian Defenders", "Storm Guardians", "Rangers", "Dire Avengers"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
					"", "Howling Banshees", "Striking Scorpions", "Fire Dragons", "Wraithguard", "Wraithblades", "Bonesinger"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{
					"", "Windriders", "Swooping Hawks", "Warp Spiders", "Shining Spears", "Vypers"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
					"", "Dark Reapers", "Vaul's Wrath Support Battery", "Falcon", "Fire Prism", "Night Spinner", "War Walkers", 
					"Wraithlord"});
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{
					"", "Wave Serpent"});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{
					"", "Wraithknight"});
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{
					"", "Crimson Hunter", "Crimson Hunter Exarch", "Hemlock Wraithfighter"});
		} else if(getFormationType().equals("Warhost")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
					"", "Autarch", "Autarch with Swooping Hawk Wings", "Autarch Skyrunner", 
					"Farseer", "Farseer Skyrunner", "Warlock", "Warlock Conclave", "Warlock Skyrunner", 
					"Warlock Skyrunner Conclave",

					"", "Eldrad Ulthran", "Prince Yriel", "Illic Nightspear",
					"", "Autarch Index", "Autarch with Swooping Hawk Wings Index", "Autarch with Warp Jump Generator Index", "Autarch Skyrunner Index"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
					"", "Guardian Defenders", "Storm Guardians", "Rangers"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{
					"", "Windriders", "Vypers"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
					"", "Vaul's Wrath Support Battery", "Falcon", "Fire Prism", "Night Spinner", "War Walkers"});
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{
					"", "Wave Serpent"});
		} else if(getFormationType().equals("Spirit Host")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
				"", "Spiritseer"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
					"", "Wraithguard", "Wraithblades"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
					"", "Wraithlord"});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{
					"", "Wraithknight"});
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{
					"", "Hemlock Wraithfighter"});
		} else if(getFormationType().equals("Aspect Warrior")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
					"", "Asurmen", "Jain Zar", "Karandras", "Fuegan", "Baharroth", "Maugan Ra", "Avatar of Khaine"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
					"", "Dire Avengers"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
					"", "Howling Banshees", "Striking Scorpions", "Fire Dragons"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{
					"", "Swooping Hawks", "Warp Spiders", "Shining Spears"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
					"", "Dark Reapers"});
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{
					"", "Crimson Hunter", "Crimson Hunter Exarch"});
		} else if(getFormationType().equals("Ulthwe")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
					"", "Autarch", "Autarch with Swooping Hawk Wings", "Autarch Skyrunner",
					"Farseer", "Farseer Skyrunner", "Warlock", "Warlock Conclave", "Warlock Skyrunner", 
					"Warlock Skyrunner Conclave", "Spiritseer",

					"", "Eldrad Ulthran", "Avatar of Khaine",
					"", "Autarch Index", "Autarch with Swooping Hawk Wings Index", "Autarch with Warp Jump Generator Index", "Autarch Skyrunner Index"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
					"", "Guardian Defenders", "Storm Guardians", "Rangers", "Dire Avengers"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
					"", "Howling Banshees", "Striking Scorpions", "Fire Dragons", "Wraithguard", "Wraithblades", "Bonesinger"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{
					"", "Windriders", "Swooping Hawks", "Warp Spiders", "Shining Spears", "Vypers"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
					"", "Dark Reapers", "Vaul's Wrath Support Battery", "Falcon", "Fire Prism", "Night Spinner", "War Walkers",
					"Wraithlord"});
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{
					"", "Wave Serpent"});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{
					"", "Wraithknight"});
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{
					"", "Crimson Hunter", "Crimson Hunter Exarch", "Hemlock Wraithfighter"});
		} else if(getFormationType().equals("Iyanden")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
					"", "Autarch", "Autarch with Swooping Hawk Wings", "Autarch Skyrunner",
					"Farseer", "Farseer Skyrunner", "Warlock", "Warlock Conclave", "Warlock Skyrunner", 
					"Warlock Skyrunner Conclave", "Spiritseer",

					"", "Prince Yriel", "Avatar of Khaine"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
					"", "Guardian Defenders", "Storm Guardians", "Rangers", "Dire Avengers"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
					"", "Howling Banshees", "Striking Scorpions", "Fire Dragons", "Wraithguard", "Wraithblades"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{
					"", "Windriders", "Swooping Hawks", "Warp Spiders", "Shining Spears", "Vypers"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
					"", "Dark Reapers", "Vaul's Wrath Support Battery", "Falcon", "Fire Prism", "Night Spinner", "War Walkers",
					"Wraithlord"});
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{
					"", "Wave Serpent"});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{
					"", "Wraithknight"});
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{
					"", "Crimson Hunter", "Crimson Hunter Exarch", "Hemlock Wraithfighter"});
		} else if(getFormationType().equals("Alaitoc")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
					"", "Autarch", "Autarch with Swooping Hawk Wings", "Autarch Skyrunner",
					"Farseer", "Farseer Skyrunner", "Warlock", "Warlock Conclave", "Warlock Skyrunner", 
					"Warlock Skyrunner Conclave", "Spiritseer",

					"", "Illic Nightspear", "Avatar of Khaine",
					"", "Autarch Index", "Autarch with Swooping Hawk Wings Index", "Autarch with Warp Jump Generator Index", "Autarch Skyrunner Index"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
					"", "Guardian Defenders", "Storm Guardians", "Rangers", "Dire Avengers"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
					"", "Howling Banshees", "Striking Scorpions", "Fire Dragons", "Wraithguard", "Wraithblades"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{
					"", "Windriders", "Swooping Hawks", "Warp Spiders", "Shining Spears", "Vypers"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
					"", "Dark Reapers", "Vaul's Wrath Support Battery", "Falcon", "Fire Prism", "Night Spinner", "War Walkers",
					"Wraithlord"});
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{
					"", "Wave Serpent"});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{
					"", "Wraithknight"});
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{
					"", "Crimson Hunter", "Crimson Hunter Exarch", "Hemlock Wraithfighter"});
		} else if(getFormationType().equals("Drukhari")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
					"", "Archon", "Succubus", "Haemonculus",

					"", "Lelith Hesperax", "Urien Rakarth", "Drazhar"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
					"", "Kabalite Warriors", "Wyches", "Wracks"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
					"", "Lhamaean", "Medusae", "Sslyth", "Ur-Ghul", "Kabalite Trueborn", "Hekatrix Bloodbrides", "Incubi",
					"Mandrakes", "Grotesques", "Beastmaster"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{
					"", "Clawed Fiends", "Khymerae", "Razorwing Flocks", "Reavers", "Hellions", "Scourges"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
					"", "Talos", "Cronos", "Ravager",
					
					"", "Reaper", "Tantalus"});
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{
					"", "Raider", "Venom"});
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{
					"", "Razorwing Jetfighter", "Voidraven"});
		}  else if(getFormationType().equals("Wych Cult of Strife")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
					"", "Succubus",
					"", "Lelith Hesperax"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
					"", "Wyches"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
					"", "Hekatrix Bloodbrides", "Beastmaster"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{
					"", "Clawed Fiends", "Khymerae", "Razorwing Flocks", "Reavers", "Hellions"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
					"", "Reaper", "Tantalus"});
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{
					"", "Raider", "Venom"});
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{
					"", "Razorwing Jetfighter", "Voidraven"});
		} else if(getFormationType().equals("Prophets of Flesh")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
					"", "Haemonculus",
					"", "Urien Rakarth"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
					"", "Wracks"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
					"", "Grotesques"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
					"", "Talos", "Cronos",
					
					"", "Reaper", "Tantalus"});
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{
					"", "Raider", "Venom"});
		} else if(getFormationType().equals("Incubi")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
					"", "Drazhar"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
					"", "Incubi"});
		} else if(getFormationType().equals("Harlequins")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
					"", "Troupe Master", "Shadowseer"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
					"", "Troupe"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
					"", "Death Jester", "Solitaire"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{
					"", "Skyweavers"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
					"", "Voidweavers"});
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{
					"", "Starweaver"});
			myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{
					"", "Webway Gate"});
		} else if(getFormationType().equals("Ynnari")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
					"", "Yvraine", "The Visarch", "The Yncarne",

					"", "Autarch", "Autarch with Swooping Hawk Wings", "Autarch Skyrunner",
					"Farseer", "Farseer Skyrunner", "Warlock", "Warlock Conclave", "Warlock Skyrunner",
					"Warlock Skyrunner Conclave", "Spiritseer",
					"", "Eldrad Ulthran", "Prince Yriel", "Illic Nightspear", "Asurmen", "Jain Zar", "Karandras", "Fuegan",
					"Baharroth", "Maugan Ra",

					"", "Archon", "Succubus",
					"", "Lelith Hesperax",

					"", "Troupe Master", "Shadowseer",
					"", "Autarch Index", "Autarch with Swooping Hawk Wings Index", "Autarch with Warp Jump Generator Index", "Autarch Skyrunner Index"});
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
					"", "Guardian Defenders", "Storm Guardians", "Rangers", "Dire Avengers",

					"", "Kabalite Warriors", "Wyches",

					"", "Troupe"});
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
					"", "Howling Banshees", "Striking Scorpions", "Fire Dragons", "Wraithguard", "Wraithblades",

					"", "Lhamaean", "Medusae", "Sslyth", "Ur-Ghul", "Kabalite Trueborn", "Hekatrix Bloodbrides", "Incubi",
					"Beastmaster",

					"", "Death Jester", "Solitaire"});
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{
					"", "Windriders", "Swooping Hawks", "Warp Spiders", "Shining Spears", "Vypers",

					"", "Clawed Fiends", "Khymerae", "Razorwing Flocks", "Reavers", "Hellions", "Scourges",

					"", "Skyweavers"});
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
					"", "Dark Reapers", "Vaul's Wrath Support Battery", "Falcon", "Fire Prism", "Night Spinner", "War Walkers",
					"Wraithlord",

					"", "Ravager",

					"", "Voidweavers"});
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{
					"", "Wave Serpent",

					"", "Raider", "Venom",

					"", "Starweaver"});
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{
					"", "Wraithknight"});
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{
					"", "Crimson Hunter", "Crimson Hunter Exarch", "Hemlock Wraithfighter", 

					"", "Razorwing Jetfighter", "Voidraven"});
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