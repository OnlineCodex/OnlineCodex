package oc.wh40k.armies;


import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;
import oc.utils.ResourceUtils;

import java.util.Set;

import com.google.common.collect.ImmutableSet;


public class VOLKAeldari extends BuildaVater {

	private static final Set<String> CRAFTWORLDS = ImmutableSet.of("Alaitoc", "Biel-Tan", "Iyanden", "Saim-Hann", "Ulthwe");

    public VOLKAeldari() {
        super("AE", ResourceUtils.loadPoints(
                "/oc/wh40k/indices/ae.yaml",
                "/oc/wh40k/indices/de.yaml"));

        AdditionalInformation = new String[]{""};
        HQeinträge = new String[]{""};
        Eliteeinträge = new String[]{"", "Custodian Guard Squad"};
        Standardeinträge = new String[]{""};
        Sturmeinträge = new String[]{""};
        Unterstützungeinträge = new String[]{""};
        Transporteinträge = new String[]{""};
        Fliegereinträge = new String[]{""};
        Befestigungen = new String[]{""};
        LordofWar = new String[]{""};

        adden(new ChooserGruppe(this, getId(), cnt, 0, AI, AdditionalInformation));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, HQ, HQeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, TROOPS, Standardeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, ELITE, Eliteeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, FAST_ATTACK, Sturmeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, HEAVY_SUPPORT, Unterstützungeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, DEDICATED_TRANSPORT, Transporteinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, FLIER, Fliegereinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, FORTIFICATION, Befestigungen));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, LORD_OF_WAR, LordofWar));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;

        cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

        nameDerArtDerArmee = BuildaHQ.translate("AELDARI");
        nameDerArtDerArmeeDekliniert = BuildaHQ.translate("AELDARI");
        textAreaUeberschrift = BuildaHQ.translate("Meine") + " " + BuildaHQ.translate("AELDARI");
        
        formationen.add("AELDARI");
        formationen.add("");
        formationen.add("ASURYANI");
        CRAFTWORLDS.forEach(craftworld -> formationen.add(craftworld));
        formationen.add("Warhost");
        formationen.add("Spirit Host");
        formationen.add("Aspect Warrior");
        formationen.add("");
        formationen.add("Drukhari");
        formationen.add("Kabal of the Black Heart");
        formationen.add("Kabal of the Flayed Skull");
        formationen.add("Kabal of the Poisoned Tongue");
        formationen.add("Kabal of the Obsidan Rose");
        formationen.add("Cult of Strife");
        formationen.add("Cult of the Cursed Blade");
        formationen.add("Cult of the Red Grief");
        formationen.add("The Prophets of Flesh");
        formationen.add("The Dark Creed");
        formationen.add("Coven of Twelve");
        formationen.add("Incubi");
        formationen.add("");
        formationen.add("Harlequins");
        formationen.add("");
        formationen.add("Ynnari");

        complete();
    }

    @Override
    public void volkRefresh() {
        if (getFormationType().equals("AELDARI")) {
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
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{
                    "", "Guardian Defenders", "Storm Guardians", "Rangers", "Dire Avengers",
                    "", "Kabalite Warriors", "Wyches", "Wracks",
                    "", "Troupe"});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(new String[]{
                    "", "Howling Banshees", "Striking Scorpions", "Fire Dragons", "Wraithguard", "Wraithblades", "Bonesinger",

                    "", "Lhamaean", "Medusae", "Sslyth", "Ur-Ghul", "Kabalite Trueborn", "Hekatrix Bloodbrides", "Incubi",
                    "Mandrakes", "Grotesques", "Beastmaster",

                    "", "Death Jester", "Solitaire"});
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{
                    "", "Windriders", "Swooping Hawks", "Warp Spiders", "Shining Spears", "Vypers",
                    "", "Clawed Fiends", "Khymerae", "Razorwing Flocks", "Reavers", "Hellions", "Scourges",

                    "", "Skyweavers"});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Dark Reapers", "Vaul's Wrath Support Battery", "Falcon", "Fire Prism", "Night Spinner", "War Walkers",
                    "Wraithlord",

                    "", "Talos", "Cronos", "Ravager",
                    "", "Reaper [FW]", "Tantalus [FW]",
                    "", "Voidweavers"});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Wave Serpent",
                    "", "Raider", "Venom",
                    "", "Starweaver"});
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{
                    "", "Wraithknight"});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{
                    "", "Crimson Hunter", "Crimson Hunter Exarch", "Hemlock Wraithfighter",
                    "", "Razorwing Jetfighter", "Voidraven"});
        } else if (getFormationType().equals("ASURYANI")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Autarch", "Autarch with Swooping Hawk Wings", "Autarch Skyrunner",
                    "Farseer", "Farseer Skyrunner", "Warlock", "Warlock Conclave", "Warlock Skyrunner",
                    "Warlock Skyrunner Conclave", "Spiritseer",
                    "", "Eldrad Ulthran", "Prince Yriel", "Illic Nightspear", "Asurmen", "Jain Zar", "Karandras", "Fuegan",
                    "Baharroth", "Maugan Ra", "Avatar of Khaine",
                    "", "Autarch Index", "Autarch with Swooping Hawk Wings Index", "Autarch with Warp Jump Generator Index", "Autarch Skyrunner Index"});
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{
                    "", "Guardian Defenders", "Storm Guardians", "Rangers", "Dire Avengers"});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(new String[]{
                    "", "Howling Banshees", "Striking Scorpions", "Fire Dragons", "Wraithguard", "Wraithblades", "Bonesinger"});
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{
                    "", "Windriders", "Swooping Hawks", "Warp Spiders", "Shining Spears", "Vypers"});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Dark Reapers", "Vaul's Wrath Support Battery", "Falcon", "Fire Prism", "Night Spinner", "War Walkers",
                    "Wraithlord"});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Wave Serpent"});
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{
                    "", "Wraithknight"});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{
                    "", "Crimson Hunter", "Crimson Hunter Exarch", "Hemlock Wraithfighter"});
        } else if (getFormationType().equals("Warhost")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Autarch", "Autarch with Swooping Hawk Wings", "Autarch Skyrunner",
                    "Farseer", "Farseer Skyrunner", "Warlock", "Warlock Conclave", "Warlock Skyrunner",
                    "Warlock Skyrunner Conclave",
                    "", "Eldrad Ulthran", "Prince Yriel", "Illic Nightspear",
                    "", "Autarch Index", "Autarch with Swooping Hawk Wings Index", "Autarch with Warp Jump Generator Index", "Autarch Skyrunner Index"});
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{
                    "", "Guardian Defenders", "Storm Guardians", "Rangers"});
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{
                    "", "Windriders", "Vypers"});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Vaul's Wrath Support Battery", "Falcon", "Fire Prism", "Night Spinner", "War Walkers"});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Wave Serpent"});
        } else if (getFormationType().equals("Spirit Host")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Spiritseer"});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(new String[]{
                    "", "Wraithguard", "Wraithblades"});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Wraithlord"});
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{
                    "", "Wraithknight"});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{
                    "", "Hemlock Wraithfighter"});
        } else if (getFormationType().equals("Aspect Warrior")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Asurmen", "Jain Zar", "Karandras", "Fuegan", "Baharroth", "Maugan Ra", "Avatar of Khaine"});
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{
                    "", "Dire Avengers"});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(new String[]{
                    "", "Howling Banshees", "Striking Scorpions", "Fire Dragons"});
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{
                    "", "Swooping Hawks", "Warp Spiders", "Shining Spears"});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Dark Reapers"});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{
                    "", "Crimson Hunter", "Crimson Hunter Exarch"});
        } else if (getFormationType().equals("Ulthwe")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Autarch", "Autarch with Swooping Hawk Wings", "Autarch Skyrunner",
                    "Farseer", "Farseer Skyrunner", "Warlock", "Warlock Conclave", "Warlock Skyrunner",
                    "Warlock Skyrunner Conclave", "Spiritseer",
                    "", "Eldrad Ulthran", "Avatar of Khaine",
                    "", "Autarch Index", "Autarch with Swooping Hawk Wings Index", "Autarch with Warp Jump Generator Index", "Autarch Skyrunner Index"});
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{
                    "", "Guardian Defenders", "Storm Guardians", "Rangers", "Dire Avengers"});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(new String[]{
                    "", "Howling Banshees", "Striking Scorpions", "Fire Dragons", "Wraithguard", "Wraithblades", "Bonesinger"});
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{
                    "", "Windriders", "Swooping Hawks", "Warp Spiders", "Shining Spears", "Vypers"});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Dark Reapers", "Vaul's Wrath Support Battery", "Falcon", "Fire Prism", "Night Spinner", "War Walkers",
                    "Wraithlord"});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Wave Serpent"});
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{
                    "", "Wraithknight"});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{
                    "", "Crimson Hunter", "Crimson Hunter Exarch", "Hemlock Wraithfighter"});
        } else if (getFormationType().equals("Iyanden")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Autarch", "Autarch with Swooping Hawk Wings", "Autarch Skyrunner",
                    "Farseer", "Farseer Skyrunner", "Warlock", "Warlock Conclave", "Warlock Skyrunner",
                    "Warlock Skyrunner Conclave", "Spiritseer",
                    "", "Prince Yriel", "Avatar of Khaine"});
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{
                    "", "Guardian Defenders", "Storm Guardians", "Rangers", "Dire Avengers"});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(new String[]{
                    "", "Howling Banshees", "Striking Scorpions", "Fire Dragons", "Wraithguard", "Wraithblades"});
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{
                    "", "Windriders", "Swooping Hawks", "Warp Spiders", "Shining Spears", "Vypers"});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Dark Reapers", "Vaul's Wrath Support Battery", "Falcon", "Fire Prism", "Night Spinner", "War Walkers",
                    "Wraithlord"});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Wave Serpent"});
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{
                    "", "Wraithknight"});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{
                    "", "Crimson Hunter", "Crimson Hunter Exarch", "Hemlock Wraithfighter"});
        } else if (getFormationType().equals("Alaitoc")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Autarch", "Autarch with Swooping Hawk Wings", "Autarch Skyrunner",
                    "Farseer", "Farseer Skyrunner", "Warlock", "Warlock Conclave", "Warlock Skyrunner",
                    "Warlock Skyrunner Conclave", "Spiritseer",

                    "", "Illic Nightspear", "Avatar of Khaine",
                    "", "Autarch Index", "Autarch with Swooping Hawk Wings Index", "Autarch with Warp Jump Generator Index", "Autarch Skyrunner Index"});
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{
                    "", "Guardian Defenders", "Storm Guardians", "Rangers", "Dire Avengers"});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(new String[]{
                    "", "Howling Banshees", "Striking Scorpions", "Fire Dragons", "Wraithguard", "Wraithblades"});
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{
                    "", "Windriders", "Swooping Hawks", "Warp Spiders", "Shining Spears", "Vypers"});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Dark Reapers", "Vaul's Wrath Support Battery", "Falcon", "Fire Prism", "Night Spinner", "War Walkers",
                    "Wraithlord"});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Wave Serpent"});
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{
                    "", "Wraithknight"});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{
                    "", "Crimson Hunter", "Crimson Hunter Exarch", "Hemlock Wraithfighter"});
        } else if (getFormationType().equals("Drukhari")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Archon", "Succubus", "Haemonculus",
                    "", "Lelith Hesperax", "Urien Rakarth", "Drazhar"});
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{
                    "", "Kabalite Warriors", "Wyches", "Wracks"});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(new String[]{
                    "", "Lhamaean", "Medusae", "Sslyth", "Ur-Ghul", "Kabalite Trueborn [INDEX]", "Hekatrix Bloodbrides [INDEX]", "Incubi",
                    "Mandrakes", "Grotesques", "Beastmaster"});
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{
                    "", "Clawed Fiends", "Khymerae", "Razorwing Flocks", "Reavers", "Hellions", "Scourges"});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Talos", "Cronos", "Ravager",
                    "", "Reaper [FW]", "Tantalus [FW]"});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Raider", "Venom"});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{
                    "", "Razorwing Jetfighter", "Voidraven"});
        } else if (getFormationType().equals("Kabal of the Black Heart")
        		|| getFormationType().equals("Flayed Skull")
        		|| getFormationType().equals("Poisoned Tongue")
        		|| getFormationType().equals("Kabal of the Obsidan Rose")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Archon",
                    "", "Drazhar"});
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{
                    "", "Kabalite Warriors"});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(new String[]{
                    "", "Kabalite Trueborn [INDEX]", "Lhamaean", "Medusae", "Sslyth", "Ur-Ghul", "Incubi",
                    "Mandrakes"});
        	myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{
                    "", "Clawed Fiends", "Khymerae", "Razorwing Flocks", "Scourges"});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Ravager",
                    "", "Reaper [FW]", "Tantalus [FW]"});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Raider", "Venom"});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{
                    "", "Razorwing Jetfighter", "Voidraven"});
        } else if (getFormationType().equals("Cult of Strife")
        		|| getFormationType().equals("Cult of the Cursed Blade")
        		|| getFormationType().equals("Cult of the Red Grief")) {
        	if(getFormationType().equals("Cult of Strife")) {
        		myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
        				"", "Succubus",
        				"", "Drazhar", "Lelith Hesperax"});
        	} else {
        		myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                        "", "Succubus",
                        "", "Drazhar"});
        	}
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{
                    "", "Wyches"});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(new String[]{
                    "", "Hekatrix Bloodbrides [INDEX]", "Incubi", "Mandrakes", "Beastmaster"});
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{
                    "", "Clawed Fiends", "Khymerae", "Razorwing Flocks", "Reavers", "Hellions", "Scourges"});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Reaper [FW]", "Tantalus [FW]"});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Raider", "Venom"});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{
                    "", "Razorwing Jetfighter", "Voidraven"});
        } else if (getFormationType().equals("The Prophets of Flesh")
        		|| getFormationType().equals("The Dark Creed")
        		|| getFormationType().equals("Coven of Twelve")) {
        	if(getFormationType().equals("The Prophets of Flesh")){
	            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
	                    "", "Haemonculus",
	                    "", "Urien Rakarth", "Drazhar"});
        	} else {
        		myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
	                    "", "Haemonculus",
	                    "", "Drazhar"});
        	}
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{
                    "", "Wracks"});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(new String[]{
                    "", "Incubi", "Mandrakes", "Grotesques"});
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{
                    "", "Clawed Fiends", "Khymerae", "Razorwing Flocks", "Scourges"});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Talos", "Cronos",
                    "", "Reaper [FW]", "Tantalus [FW]"});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Raider", "Venom"});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{""});
        } else if (getFormationType().equals("Incubi")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Drazhar"});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(new String[]{
                    "", "Incubi"});
        } else if (getFormationType().equals("Harlequins")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Troupe Master", "Shadowseer"});
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{
                    "", "Troupe"});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(new String[]{
                    "", "Death Jester", "Solitaire"});
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{
                    "", "Skyweavers"});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Voidweavers"});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Starweaver"});
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(new String[]{
                    "", "Webway Gate"});
        } else if (getFormationType().equals("Ynnari")) {
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
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{
                    "", "Guardian Defenders", "Storm Guardians", "Rangers", "Dire Avengers",
                    "", "Kabalite Warriors", "Wyches",
                    "", "Troupe"});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(new String[]{
                    "", "Howling Banshees", "Striking Scorpions", "Fire Dragons", "Wraithguard", "Wraithblades",
                    "", "Lhamaean", "Medusae", "Sslyth", "Ur-Ghul", "Kabalite Trueborn", "Hekatrix Bloodbrides", "Incubi",
                    "Beastmaster",
                    "", "Death Jester", "Solitaire"});
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{
                    "", "Windriders", "Swooping Hawks", "Warp Spiders", "Shining Spears", "Vypers",
                    "", "Clawed Fiends", "Khymerae", "Razorwing Flocks", "Reavers", "Hellions", "Scourges",
                    "", "Skyweavers"});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Dark Reapers", "Vaul's Wrath Support Battery", "Falcon", "Fire Prism", "Night Spinner", "War Walkers",
                    "Wraithlord",
                    "", "Ravager",
                    "", "Voidweavers"});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Wave Serpent",
                    "", "Raider", "Venom",
                    "", "Starweaver"});
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{
                    "", "Wraithknight"});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{
                    "", "Crimson Hunter", "Crimson Hunter Exarch", "Hemlock Wraithfighter",
                    "", "Razorwing Jetfighter", "Voidraven"});
        }

        if (formation != null) {
            formation.refreshControlPanel();
        }

        fillChooserSpace();
    }
}