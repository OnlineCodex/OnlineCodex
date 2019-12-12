package oc.wh40k.armies;

import static oc.utils.ResourceUtils.loadPoints;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKChaos extends BuildaVater {

    private static final String[] HQeinträge_Chaos_Space_Marines_FW = new String[]{"", "Zhufor The Impaler [FW]", "Lord Arkos [FW]", "Chaos Hellwright [FW]", "Chaos Hellwright On Dark Abeyant [FW]"};
    private static final String[] Eliteeinträge_Chaos_Space_Marines_FW = new String[]{"", "Chaos Decimator [FW]", "Hellforged Contemptor Dreadnought [FW]", "Hellforged Predator [FW]", "Hellforged Sicaran [FW]"};
    private static final String[] Standardeinträge_Chaos_Space_Marines_FW = new String[]{""};
    private static final String[] Sturmeinträge_Chaos_Space_Marines_FW = new String[]{"", "Blood Slaughterer of Khorne [FW]", "Greater Blight Drone [FW]", "Hellforged Dreadclaw Drop Pod [FW]", "Hellforged Kharybdis Assault Claw [FW]"};
    private static final String[] Unterstützungseinträge_Chaos_Space_Marines_FW = new String[]{"", "Hellforged Land Raider Proteus [FW]", "Hellforged Land Raider Achilles [FW]", "Hellforged Scorpius [FW]",
    		"Hellforged Sicarian Venator [FW]","Hellforged Deredeo Dreadnought [FW]","Hellforged Rapier Battery [FW]","Hellforged Leviathan Dreadnought [FW]","Spined Chaos Beast [FW]"};
    private static final String[] Transporteinträge_Chaos_Space_Marines_FW = new String[]{"Terrax-Pattern Termite Assault Drill"};
    private static final String[] Fliegereinträge_Chaos_Space_Marines_FW = new String[]{"","Chaos Hell Blade [FW]","Chaos Hell Talon [FW]","Chaos Storm Eagle Assault Gunship [FW]","Chaos Fire Raptor Assault Gunship [FW]","Chaos Xiphon Interceptor [FW]"};
    private static final String[] Befestigungseinträge_Chaos_Space_Marines_FW = new String[]{""};
    private static final String[] LOWeinträge_Chaos_Space_Marines_FW = new String[]{"","Kytan Ravager [FW]","Greater Brass Scorpion Of Khorne [FW]","Hellforged Spartan Assault Tank [FW]","Hellforged Cerberus Heavy Destroyer [FW]","Hellforged Typhon Heavy Siege Tank [FW]","Hellforged Fellblade [FW]",
            "Hellforged Falchion [FW]","Hellforged Mastodon [FW]","Chaos Thunderhawk Assault Gunship [FW]","Chaos Sokar Pattern Stormbird Gunship [FW]",
            "Cerastus Knight Acheron [FW]","Cerastus Knight Lancer [FW]","Cerastus Knight Castigator [FW]","Cerasatus Knight Atropos [FW]","Questoris Knight Magaera [FW]","Acastus Knight Porphyrion [FW]","Questoris Knight Styrix [FW]","","Chaos Warlord Battle Titan [FW]","Chaos Reaver Battle Titan [FW]", "Chaos Warhound Scout Titan [FW]"};

    private static final String[] HQeinträge_Daemons_FW = new String[]{"","Uraka The Warfiend [FW]","Samus [FW]","Mamon Transfigured [FW]","Corbax Utterblight [FW]"};
    private static final String[] Sturmeinträge_Daemons_FW = new String[]{"","Plague Toads Of Nurgle [FW]","Pox Riders Of Nurgle [FW]"};
    private static final String[] Unterstützungseinträge_Daemons_FW = new String[]{"", "Giant Chaos Spawn [FW]"};
    private static final String[] LOWeinträge_Daemons_FW = new String[]{"","Anggrath The Unbound [FW]","Zarakynel [FW]","Aetaos'rau'keres [FW]","Scabeiathrax The Bloated [FW]"};

    private static final String[] HQeinträge_Chaos_Space_Marines = new String[]{"", "Abaddon the Despoiler", "Huron Blackheart", "Cypher", "Fabius Bile", "Kharn the Betrayer",
            "Lucius the Eternal", "Haarken Worldclaimer", "Lord Discordant on Helstalker", "Chaos Lord", "Chaos Lord in Terminator Armour",
            "Dark Apostle", "Exalted Champion", "Daemon Prince of Chaos CSM", "Daemon Prince of Chaos with Wings CSM",
            "Sorcerer", "Sorcerer in Terminator Armour", "Master of Possession", "Master of Executions",
            "Warpsmith",
            "", "Chaos Lord on Bike [INDEX]", "Chaos Lord on Juggernaut of Khorne [INDEX]", "Chaos Lord on Disc of Tzeentch [INDEX]", "Chaos Lord on Palanquin of Nurgle [INDEX]", "Chaos Lord on Steed of Slaanesh [INDEX]",
                "Sorcerer on Bike [INDEX]", "Sorcerer on Disc of Tzeentch [INDEX]", "Sorcerer on Palanquin of Nurgle [INDEX]", "Sorcerer on Palanquin of Nurgle [INDEX]"};
    private static final String[] Eliteeinträge_Chaos_Space_Marines = new String[]{"", "Fallen", "Chaos Terminators", "Khorne Berzerkers", "Rubric Marines", "Plague Marines CSM", "Noise Marines", "Chosen", "Greater Possessed", "Possessed", "Helbrute", "Mutilators", "Dark Disciples"};
    private static final String[] Standardeinträge_Chaos_Space_Marines = new String[]{"", "Chaos Space Marines", "Chaos Cultists", "Bloodletters", "Horrors", "Plaguebearers", "Daemonettes"};
    private static final String[] Sturmeinträge_Chaos_Space_Marines = new String[]{"", "Chaos Bikers", "Raptors", "Warp Talons", "Chaos Spawn"};
    private static final String[] Unterstützungseinträge_Chaos_Space_Marines = new String[]{"", "Chaos Land Raider", "Chaos Predator", "Chaos Vindicator", "Obliterators", "Havocs", "Forgefiend", "Maulerfiend", "Defiler", "Venomcrawler"};
    private static final String[] Transporteinträge_Chaos_Space_Marines = new String[]{"", "Chaos Rhino"};
    private static final String[] Fliegereinträge_Chaos_Space_Marines = new String[]{"", "Heldrake"};
    private static final String[] Befestigungseinträge_Chaos_Space_Marines = new String[]{"", "Chaos Bastions", "Noctilith Crown", "Skull Altar"};
    private static final String[] LOWeinträge_Chaos_Space_Marines = new String[]{"", "Khorne Lord of Skulls"};

    private static final String[] HQeinträge_Other_Legions = new String[]{"", "Cypher", "Fabius Bile",
            "", "Lord Discordant on Helstalker", "Chaos Lord", "Chaos Lord in Terminator Armour",
            "Dark Apostle", "Exalted Champion", "Daemon Prince of Chaos CSM", "Daemon Prince of Chaos with Wings CSM",
            "Sorcerer", "Sorcerer in Terminator Armour",
            "Warpsmith", "Master of Possession", "Master of Executions",
            "", "Chaos Lord on Bike [INDEX]", "Chaos Lord on Juggernaut of Khorne [INDEX]", "Chaos Lord on Disc of Tzeentch [INDEX]", "Chaos Lord on Palanquin of Nurgle [INDEX]", "Chaos Lord on Steed of Slaanesh [INDEX]",
                "Sorcerer on Bike [INDEX]", "Sorcerer on Disc of Tzeentch [INDEX]", "Sorcerer on Palanquin of Nurgle [INDEX]", "Sorcerer on Palanquin of Nurgle [INDEX]"};

    private static final String[] HQeinträge_Black_Legion = new String[]{"", "Abaddon the Despoiler", "Cypher", "Fabius Bile", "Haarken Worldclaimer",
            "", "Lord Discordant on Helstalker", "Chaos Lord", "Chaos Lord in Terminator Armour",
            "Dark Apostle", "Exalted Champion", "Daemon Prince of Chaos CSM", "Daemon Prince of Chaos with Wings CSM",
            "Sorcerer", "Sorcerer in Terminator Armour",
            "Warpsmith", "Master of Possession", "Master of Executions",
            "", "Chaos Lord on Bike [INDEX]", "Chaos Lord on Juggernaut of Khorne [INDEX]", "Chaos Lord on Disc of Tzeentch [INDEX]", "Chaos Lord on Palanquin of Nurgle [INDEX]", "Chaos Lord on Steed of Slaanesh [INDEX]",
                "Sorcerer on Bike [INDEX]", "Sorcerer on Disc of Tzeentch [INDEX]", "Sorcerer on Palanquin of Nurgle [INDEX]", "Sorcerer on Palanquin of Nurgle [INDEX]"};

    private static final String[] HQeinträge_Red_Corsairs = new String[]{"", "Huron Blackheart", "Cypher", "Fabius Bile",
            "", "Lord Discordant on Helstalker", "Chaos Lord", "Chaos Lord in Terminator Armour",
            "Dark Apostle", "Exalted Champion", "Daemon Prince of Chaos CSM", "Daemon Prince of Chaos with Wings CSM",
            "Sorcerer", "Sorcerer in Terminator Armour",
            "Warpsmith", "Master of Possession", "Master of Executions",
            "", "Chaos Lord on Bike [INDEX]", "Chaos Lord on Juggernaut of Khorne [INDEX]", "Chaos Lord on Disc of Tzeentch [INDEX]", "Chaos Lord on Palanquin of Nurgle [INDEX]", "Chaos Lord on Steed of Slaanesh [INDEX]",
                "Sorcerer on Bike [INDEX]", "Sorcerer on Disc of Tzeentch [INDEX]", "Sorcerer on Palanquin of Nurgle [INDEX]", "Sorcerer on Palanquin of Nurgle [INDEX]"};

    private static final String[] HQeinträge_World_Eaters = new String[]{"", "Kharn the Betrayer", "Lord Discordant on Helstalker", "Chaos Lord", "Chaos Lord in Terminator Armour", "Exalted Champion",
            "Dark Apostle", "Daemon Prince of Chaos", "Daemon Prince of Chaos with Wings", "Warpsmith", "Master of Possession", "Master of Executions",
            "", "Chaos Lord on Bike [INDEX]", "Chaos Lord on Juggernaut of Khorne [INDEX]"};
    private static final String[] Eliteeinträge_World_Eaters = new String[]{"", "Fallen", "Plague Marines", "Noise Marines", "Rubric Marines", "Chaos Terminators", "Chosen", "Possessed", "Helbrute", "Mutilators", "Dark Disciples", "Greater Possessed"};
    private static final String[] Standardeinträge_World_Eaters = new String[]{"", "Khorne Berzerkers", "Chaos Space Marines", "Chaos Cultists"};
    private static final String[] Sturmeinträge_World_Eaters = new String[]{"", "Chaos Bikers", "Raptors", "Warp Talons", "Chaos Spawn"};
    private static final String[] Unterstützungseinträge_World_Eaters = new String[]{"", "Chaos Land Raider", "Chaos Predator", "Chaos Vindicator", "Obliterators", "Havocs", "Forgefiend", "Maulerfiend", "Defiler", "Venomcrawler"};
    private static final String[] Transporteinträge_World_Eaters = new String[]{"", "Chaos Rhino"};
    private static final String[] Fliegereinträge_World_Eaters = new String[]{"", "Heldrake"};
    private static final String[] LOWeinträge_World_Eaters = new String[]{"", "Khorne Lord of Skulls"};

    private static final String[] HQeinträge_ThousandSons = new String[]{"", "Ahriman", "Ahriman on Disc of Tzeentch", "Daemon Prince of Tzeentch", "Daemon Prince of Tzeentch with Wings",
            "Exalted Sorcerer", "Exalted Sorcerer on Disc of Tzeentch", "Thousand Sons Sorcerer", "TS Sorcerer in Terminator Armour", "", "Sorcerer on Disc of Tzeentch [INDEX]"};
    private static final String[] Eliteeinträge_ThousandSons = new String[]{"", "Tzaangor Shaman", "Flamers", "Scarab Occult Terminators", "Helbrute"};
    private static final String[] Standardeinträge_ThousandSons = new String[]{"", "TS Rubric Marines", "Tzaangors", "Chaos Cultists", "Horrors"};
    private static final String[] Sturmeinträge_ThousandSons = new String[]{"", "Tzaangor Enlightened", "Screamers", "Chaos Spawn"};
    private static final String[] Unterstützungseinträge_ThousandSons = new String[]{"", "Mutalith Vortex Beast", "Chaos Land Raider", "Chaos Predator", "Chaos Vindicator", "Forgefiend", "Maulerfiend", "Defiler"};
    private static final String[] Transporteinträge_ThousandSons = new String[]{"", "Chaos Rhino"};
    private static final String[] Fliegereinträge_ThousandSons = new String[]{"", "Heldrake"};
    private static final String[] LOWeinträge_ThousandSons = new String[]{"", "Magnus the Red"};

    private static final String[] HQeinträge_Death_Guard = new String[]{"", "Typhus", "Lord of Contagion", "Malignant Plaguecaster", "Daemon Prince of Nurgle", "Daemon Prince of Nurgle with Wings",
            "DG Chaos Lord", "DG Chaos Lord in Terminator Armour", "DG Sorcerer", "DG Sorcerer in Terminator Armour", "", "Necrosius the Undying [FW]"};
    private static final String[] Eliteeinträge_Death_Guard = new String[]{"", "Noxious Blightbringer", "Foul Blightspawn", "Biologus Putrifier", "Plague Surgeon", "Tallyman", "Deathshroud Terminators", "Blightlord Terminators", "Helbrute", "Beasts of Nurgle", "Possessed"};
    private static final String[] Standardeinträge_Death_Guard = new String[]{"", "Plague Marines", "Poxwalkers", "Chaos Cultists", "Plaguebearers", "Nurglings"};
    private static final String[] Sturmeinträge_Death_Guard = new String[]{"", "Foetid Bloat Drone", "Myphitic Blight-Haulers", "Chaos Spawn", "Plague Drones"};
    private static final String[] Unterstützungseinträge_Death_Guard = new String[]{"", "Chaos Land Raider", "Plagueburst Crawler", "Defiler", "Chaos Predator"};
    private static final String[] Transporteinträge_Death_Guard = new String[]{"", "Chaos Rhino"};
    private static final String[] Fliegereinträge_Death_Guard = new String[]{""};
    private static final String[] LOWeinträge_Death_Guard = new String[]{"", "Mortarion"};

    private static final String[] HQeinträge_Emperors_Children = new String[]{"", "Lucius the Eternal", "Lord Discordant on Helstalker", "Chaos Lord", "Chaos Lord in Terminator Armour",
            "Dark Apostle", "Daemon Prince of Chaos", "Daemon Prince of Chaos with Wings",
            "Sorcerer", "Sorcerer in Terminator Armour",
            "Warpsmith", "Master of Possession", "Master of Executions",
            "", "Chaos Lord on Bike [INDEX]", "Chaos Lord on Juggernaut of Khorne [INDEX]", "Chaos Lord on Disc of Tzeentch [INDEX]", "Chaos Lord on Palanquin of Nurgle [INDEX]", "Chaos Lord on Steed of Slaanesh [INDEX]",
                "Sorcerer on Bike [INDEX]", "Sorcerer on Disc of Tzeentch [INDEX]", "Sorcerer on Palanquin of Nurgle [INDEX]"};
    private static final String[] Eliteeinträge_Emperors_Children = new String[]{"", "Fallen", "Plague Marines", "Khorne Berzerkers", "Rubric Marines", "Chaos Terminators", "Chosen", "Possessed", "Helbrute", "Mutilators", "Dark Disciples"};
    private static final String[] Standardeinträge_Emperors_Children = new String[]{"", "Noise Marines", "Chaos Space Marines", "Chaos Cultists"};
    private static final String[] Sturmeinträge_Emperors_Children = new String[]{"", "Chaos Bikers", "Raptors", "Warp Talons", "Chaos Spawn"};
    private static final String[] Unterstützungseinträge_Emperors_Children = new String[]{"", "Chaos Land Raider", "Chaos Predator", "Chaos Vindicator", "Obliterators", "Havocs", "Forgefiend", "Maulerfiend", "Defiler"};
    private static final String[] Transporteinträge_Emperors_Children = new String[]{"", "Chaos Rhino"};
    private static final String[] Fliegereinträge_Emperors_Children = new String[]{"", "Heldrake"};
    private static final String[] LOWeinträge_Emperors_Children = new String[]{"", "Khorne Lord of Skulls"};

    private static final String[] HQeinträge_Questor_Traitoris = new String[]{""};
    private static final String[] Eliteeinträge_Questor_Traitoris = new String[]{""};
    private static final String[] Standardeinträge_Questor_Traitoris = new String[]{""};
    private static final String[] Sturmeinträge_Questor_Traitoris = new String[]{""};
    private static final String[] Unterstüzungseinträge_Questor_Traitoris = new String[]{""};
    private static final String[] Fliegereinträge_Questor_Traitoris = new String[]{""};
    private static final String[] Transporteinträge_Questor_Traitoris = new String[]{""};
    private static final String[] LOWeinträge_Questor_Traitoris = new String[]{"", "Knight Desecrator", "Knight Despoiler", "Knight Rampager", "Knight Tyrant", "War Dogs", "War Dogs Moirax"};

    //CHAOSDAEMONS
    private static final String[] HQ_Daemons_No_God = new String[]{"", "Be'Lakor"};
    private static final String[] HQ_Daemons_All_Gods = new String[]{"", "Daemon Prince of Chaos", "Daemon Prince of Chaos with Wings"};
    private static final String[] Sturm_Daemons_All_Gods = new String[]{"", "Furies"};
    private static final String[] Unterstuezung_Daemons_All_Gods = new String[]{"", "Soulgrinder"};

    //KHORNE
    private static final String[] HQ_Daemons_Khorne = new String[]{"", "Skarbrand", "Bloodthirster of Insensate Rage", "Wrath of Khorne Bloodthirster", "Bloodthirster of Unfettered Fury", "Skulltaker", "Bloodmaster", "Skullmaster", "Blood Throne", "Karanak"};
    private static final String[] Elite_Daemons_Khorne = new String[]{"", "Bloodcrushers"};
    private static final String[] Standard_Daemons_Khorne = new String[]{"", "Bloodletters"};
    private static final String[] Sturm_Daemons_Khorne = new String[]{"", "Flesh Hounds"};
    private static final String[] Unterstuezung_Daemons_Khorne = new String[]{"", "Skull Cannon",};
    private static final String[] Befestigung_Daemons_Khorne = new String[]{"", "Skull Altar"};

    //Tzeentch
    private static final String[] HQ_Daemons_Tzeentch = new String[]{"", "", "Kairos Fateweaver", "Lord of Change", "The Changeling", "The Blue Scribes", "Changecaster", "Fateskimmer", "Fluxmaster"};
    private static final String[] Elite_Daemons_Tzeentch = new String[]{"", "Flamers", "Exalted Flamer"};
    private static final String[] Standard_Daemons_Tzeentch = new String[]{"", "Horrors"};
    private static final String[] Sturm_Daemons_Tzeentch = new String[]{"", "Screamers"};
    private static final String[] Unterstuezung_Daemons_Tzeentch = new String[]{"", "Burning Chariot"};

    //Nurgle
    private static final String[] HQ_Daemons_Nurgle = new String[]{"", "Rotigus", "Great Unclean One", "Epidemius", "Horticulous Slimux", "Poxbringer", "Sloppity Bilepiper", "Spoilpox Scrivener"};
    private static final String[] Elite_Daemons_Nurgle = new String[]{"", "Beasts of Nurgle"};
    private static final String[] Standard_Daemons_Nurgle = new String[]{"", "Plaguebearers", "Nurglings"};
    private static final String[] Sturm_Daemons_Nurgle = new String[]{"", "Plague Drones"};
    private static final String[] Befestigung_Daemons_Nurgle = new String[]{"", "Feculent Gnarlmaws"};

    //Slaanesh
    private static final String[] HQ_Daemons_Slaanesh = new String[]{"", "Keeper of Secrets", "Shalaxi Helbane", "The Masque of Slaanesh", "Herald of Slaanesh", "Infernal Enrapturess", "Syll'Esske", "The Contorted Epitome", "Herald of Slaanesh on Steed [INDEX]", "Herald of Slaanesh on Seeker Chariot [INDEX]", "Herald of Slaanesh on Exalted Seeker Chariot [INDEX]"};
    private static final String[] Elite_Daemons_Slaanesh = new String[]{"", "Fiends of Slaanesh"};
    private static final String[] Standard_Daemons_Slaanesh = new String[]{"", "Daemonettes"};
    private static final String[] Sturm_Daemons_Slaanesh = new String[]{"", "Seekers", "Hellflayer"};
    private static final String[] Unterstuezung_Daemons_Slaanesh = new String[]{"", "Seeker Chariot", "Exalted Seeker Chariot"};

    //All Daemons
    private static final String[] HQeinträge_Daemons = uniteUnitList(HQ_Daemons_No_God, HQ_Daemons_All_Gods, HQ_Daemons_Khorne, HQ_Daemons_Tzeentch, HQ_Daemons_Nurgle, HQ_Daemons_Slaanesh);
    private static final String[] Standardeinträge_Daemons = uniteUnitList(Standard_Daemons_Khorne, Standard_Daemons_Tzeentch, Standard_Daemons_Nurgle, Standard_Daemons_Slaanesh);
    private static final String[] Eliteeinträge_Daemons = uniteUnitList(Elite_Daemons_Khorne, Elite_Daemons_Tzeentch, Elite_Daemons_Nurgle, Elite_Daemons_Slaanesh);
    private static final String[] Sturmeinträge_Daemons = uniteUnitList(Sturm_Daemons_Khorne, Sturm_Daemons_Tzeentch, Sturm_Daemons_Nurgle, Sturm_Daemons_Slaanesh, Sturm_Daemons_All_Gods);
    private static final String[] Unterstüzungseinträge_Daemons = uniteUnitList(Unterstuezung_Daemons_Khorne, Unterstuezung_Daemons_Tzeentch, Unterstuezung_Daemons_Slaanesh, Unterstuezung_Daemons_All_Gods);
    private static final String[] Befestigungseinträge_Daemons =  uniteUnitList(Befestigung_Daemons_Nurgle, Befestigung_Daemons_Khorne);

    private static final Set<String> LEGIONS = ImmutableSet.of("Alpha Legion", "Black Legion", "Emperor's Children", "Iron Warriors", "Night Lords", "World Eaters", "Word Bearers", "", "Red Corsairs", "Crimons Slaughter", "The Purge", "The Scourged", "Brazen Beasts", "Flawless Host", "Renegade Chapters");
    private static final Set<String> CHAOS_GODS = ImmutableSet.of("Khorne", "Tzeentch", "Nurgle", "Slaanesh");
    public static final Set<String> CHAOS_SPECIAL_DETACHEMENTS = ImmutableSet.of("", "Bringers of Despair", "Devastation Battery", "Cult of the Damned", "Daemonkin Ritualists", "Soulforged Pack", "Host Raptorial", "Fallen Angels", "Legion of Skulls");

    public static Set<String> getLegions() {
    	return LEGIONS;
    }

    public VOLKChaos() {
        super("CH", loadPoints("/oc/wh40k/indices/chaos.yaml"));

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
        comeTheApocalypse.add("ELITE");
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
        LEGIONS.forEach(legion -> formationen.add(legion));
        formationen.add("Death Guard");
        formationen.add("Thousand Sons");
        formationen.add("");
        formationen.add("Chaosdaemons");
        CHAOS_GODS.forEach(god -> formationen.add(god));
        formationen.add("");
        formationen.add("Questor Traitoris");
        formationen.add("");
        formationen.add("The Tainted");

        CHAOS_SPECIAL_DETACHEMENTS.forEach(legion -> specialDetachments.add(legion));

        complete();
    }

    @Override
    public void volkRefresh() {
        if (getFormationType().equals("CHAOS")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Chaos_Space_Marines, HQeinträge_Death_Guard, HQeinträge_ThousandSons, HQeinträge_Daemons, HQeinträge_Chaos_Space_Marines_FW, HQeinträge_Daemons_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(uniteUnitList(uniteUnitList(uniteUnitList(
                    Eliteeinträge_Chaos_Space_Marines, Eliteeinträge_Death_Guard), Eliteeinträge_ThousandSons), Eliteeinträge_Daemons), Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(uniteUnitList(
                    new String[]{"", "Chaos Space Marines", "Chaos Cultists", "Tzaangors", "Poxwalkers"}, Standardeinträge_Daemons), Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Chaos_Space_Marines, Sturmeinträge_Death_Guard, Sturmeinträge_ThousandSons, Sturmeinträge_Daemons, Sturmeinträge_Chaos_Space_Marines_FW, Sturmeinträge_Daemons_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungseinträge_Chaos_Space_Marines, Unterstützungseinträge_Death_Guard, Unterstützungseinträge_ThousandSons, Unterstüzungseinträge_Daemons, Unterstützungseinträge_Chaos_Space_Marines_FW, Unterstützungseinträge_Daemons_FW, new String[]{"", "Plague Hulk Of Nurgle [FW]"}));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(
                    Transporteinträge_Chaos_Space_Marines, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(
                    Fliegereinträge_Chaos_Space_Marines, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(uniteUnitList(
                    Befestigungseinträge_Chaos_Space_Marines, Befestigungseinträge_Daemons), Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(uniteUnitList(uniteUnitList(uniteUnitList(
                    LOWeinträge_Chaos_Space_Marines, LOWeinträge_Death_Guard), LOWeinträge_ThousandSons), LOWeinträge_Questor_Traitoris), LOWeinträge_Chaos_Space_Marines_FW));
        } else if (getFormationType().equals("Heretic Astartes")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(uniteUnitList(uniteUnitList(
                    HQeinträge_Chaos_Space_Marines, HQeinträge_Death_Guard), HQeinträge_ThousandSons), HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(uniteUnitList(uniteUnitList(
                    Eliteeinträge_Chaos_Space_Marines, Eliteeinträge_Death_Guard), Eliteeinträge_ThousandSons), Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(
                    new String[]{"", "Chaos Space Marines", "Chaos Cultists", "Tzaangors", "Poxwalkers"}, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(uniteUnitList(uniteUnitList(
                    Sturmeinträge_Chaos_Space_Marines, Sturmeinträge_Death_Guard), Sturmeinträge_ThousandSons), Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(uniteUnitList(uniteUnitList(
                    Unterstützungseinträge_Chaos_Space_Marines, Unterstützungseinträge_Death_Guard), Unterstützungseinträge_ThousandSons), Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(
                    Transporteinträge_Chaos_Space_Marines, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(
                    Fliegereinträge_Chaos_Space_Marines, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(
                    Befestigungseinträge_Chaos_Space_Marines, Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(uniteUnitList(uniteUnitList(uniteUnitList(
                    LOWeinträge_Chaos_Space_Marines, LOWeinträge_Death_Guard), LOWeinträge_ThousandSons), LOWeinträge_Questor_Traitoris), LOWeinträge_Chaos_Space_Marines_FW));
        } else if (getFormationType().equals("World Eaters")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(
                    HQeinträge_World_Eaters, HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(
                    Eliteeinträge_World_Eaters, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(
                    Standardeinträge_World_Eaters, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(
                    Sturmeinträge_World_Eaters, Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(
                    Unterstützungseinträge_World_Eaters, Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(
                    Transporteinträge_World_Eaters, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(
                    Fliegereinträge_World_Eaters, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(
                    new String[]{""}, Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(
                    LOWeinträge_World_Eaters, LOWeinträge_Chaos_Space_Marines_FW));
        } else if (getFormationType().equals("Thousand Sons")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(
                    HQeinträge_ThousandSons, HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(
                    Eliteeinträge_ThousandSons, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(
                    Standardeinträge_ThousandSons, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(
                    Sturmeinträge_ThousandSons, Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(
                    Unterstützungseinträge_ThousandSons, Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(
                    Transporteinträge_ThousandSons, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(
                    Fliegereinträge_ThousandSons, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(
                    new String[]{""}, Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(
                    LOWeinträge_ThousandSons, LOWeinträge_Chaos_Space_Marines_FW));
        } else if (getFormationType().equals("Death Guard")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Death_Guard, HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Death_Guard, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_Death_Guard, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Death_Guard, Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungseinträge_Death_Guard, Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(Transporteinträge_Death_Guard, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_Death_Guard, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(new String[]{""}, Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LOWeinträge_Death_Guard);
        } else if (getFormationType().equals("Emperor's Children")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Emperors_Children, HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Emperors_Children, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_Emperors_Children, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Emperors_Children, Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungseinträge_Emperors_Children, Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(Transporteinträge_Emperors_Children, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_Emperors_Children, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(new String[]{""}, Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LOWeinträge_Emperors_Children, LOWeinträge_Chaos_Space_Marines_FW));
        } else if (getFormationType().equals("Chaos Space Marines")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(
                    HQeinträge_Chaos_Space_Marines, HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(
                    uniteUnitList(Eliteeinträge_Chaos_Space_Marines, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(
                    Standardeinträge_Chaos_Space_Marines, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(
                    Sturmeinträge_Chaos_Space_Marines, Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(
                    Unterstützungseinträge_Chaos_Space_Marines, Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(
                    Transporteinträge_Chaos_Space_Marines, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(
                    Fliegereinträge_Chaos_Space_Marines, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(
                    Befestigungseinträge_Chaos_Space_Marines, Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(
                    LOWeinträge_Chaos_Space_Marines, LOWeinträge_Chaos_Space_Marines_FW));
        } else if (getFormationType().equals("Chaos Space Marines")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(
                    HQeinträge_Chaos_Space_Marines, HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(
                    uniteUnitList(Eliteeinträge_Chaos_Space_Marines, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(
                    Standardeinträge_Chaos_Space_Marines, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(
                    Sturmeinträge_Chaos_Space_Marines, Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(
                    Unterstützungseinträge_Chaos_Space_Marines, Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(
                    Transporteinträge_Chaos_Space_Marines, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(
                    Fliegereinträge_Chaos_Space_Marines, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(
                    Befestigungseinträge_Chaos_Space_Marines, Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(
                    LOWeinträge_Chaos_Space_Marines, LOWeinträge_Chaos_Space_Marines_FW));
        } else if (getFormationType().equals("Red Corsairs")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(
                    HQeinträge_Red_Corsairs, HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(
                    uniteUnitList(Eliteeinträge_Chaos_Space_Marines, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(
                    Standardeinträge_Chaos_Space_Marines, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(
                    Sturmeinträge_Chaos_Space_Marines, Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(
                    Unterstützungseinträge_Chaos_Space_Marines, Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(
                    Transporteinträge_Chaos_Space_Marines, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(
                    Fliegereinträge_Chaos_Space_Marines, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(
                    Befestigungseinträge_Chaos_Space_Marines, Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(
                    LOWeinträge_Chaos_Space_Marines, LOWeinträge_Chaos_Space_Marines_FW));
        } else if (getFormationType().equals("Black Legion")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(
                    HQeinträge_Black_Legion, HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(
                    uniteUnitList(Eliteeinträge_Chaos_Space_Marines, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(
                    Standardeinträge_Chaos_Space_Marines, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(
                    Sturmeinträge_Chaos_Space_Marines, Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(
                    Unterstützungseinträge_Chaos_Space_Marines, Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(
                    Transporteinträge_Chaos_Space_Marines, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(
                    Fliegereinträge_Chaos_Space_Marines, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(
                    Befestigungseinträge_Chaos_Space_Marines, Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(
                    LOWeinträge_Chaos_Space_Marines, LOWeinträge_Chaos_Space_Marines_FW));
        } else if (LEGIONS.contains(getFormationType())) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(
                    HQeinträge_Other_Legions, HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(
                    uniteUnitList(Eliteeinträge_Chaos_Space_Marines, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(
                    Standardeinträge_Chaos_Space_Marines, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(
                    Sturmeinträge_Chaos_Space_Marines, Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(
                    Unterstützungseinträge_Chaos_Space_Marines, Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(
                    Transporteinträge_Chaos_Space_Marines, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(
                    Fliegereinträge_Chaos_Space_Marines, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(
                    Befestigungseinträge_Chaos_Space_Marines, Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(
                    LOWeinträge_Chaos_Space_Marines, LOWeinträge_Chaos_Space_Marines_FW));
        } else if (getFormationType().equals("Questor Traitoris")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Questor_Traitoris);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Questor_Traitoris);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Questor_Traitoris);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_Questor_Traitoris);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstüzungseinträge_Questor_Traitoris);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Questor_Traitoris);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(Fliegereinträge_Questor_Traitoris);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LOWeinträge_Questor_Traitoris);
        } else if (getFormationType().equals("Chaosdaemons")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Daemons, HQeinträge_Daemons_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Daemons);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Daemons);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Daemons, Sturmeinträge_Daemons_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstüzungseinträge_Daemons, Unterstützungseinträge_Daemons_FW, new String[]{"", "Spined Chaos Beast [FW]"}));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungseinträge_Daemons);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LOWeinträge_Daemons_FW);
        } else if (getFormationType().equals("Khorne")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQ_Daemons_Khorne, HQ_Daemons_All_Gods, new String[]{"","Uraka The Warfiend [FW]", "Samus [FW]"}));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Elite_Daemons_Khorne, new String[]{"", "Chaos Decimator [FW]"}));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standard_Daemons_Khorne);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturm_Daemons_Khorne, Sturm_Daemons_All_Gods, new String[]{"", "Blood Slaughterer of Khorne [FW]"}));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstuezung_Daemons_Khorne, Unterstuezung_Daemons_All_Gods, new String[]{"", "Giant Chaos Spawn [FW]", "Spined Chaos Beast [FW]"}));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{"", "Anggrath The Unbound [FW]"});
        }  else if (getFormationType().equals("Tzeentch")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQ_Daemons_Tzeentch, HQ_Daemons_All_Gods));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Elite_Daemons_Tzeentch, new String[]{"", "Chaos Decimator [FW]"}));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standard_Daemons_Tzeentch);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturm_Daemons_Tzeentch, Sturm_Daemons_All_Gods));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstuezung_Daemons_Tzeentch, Unterstuezung_Daemons_All_Gods, new String[]{"", "Giant Chaos Spawn [FW]", "Spined Chaos Beast [FW]"}));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{"", "Aetaos'rau'keres [FW]"});
        }  else if (getFormationType().equals("Slaanesh")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQ_Daemons_Slaanesh, HQ_Daemons_All_Gods));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Elite_Daemons_Slaanesh, new String[]{"", "Chaos Decimator [FW]"}));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standard_Daemons_Slaanesh);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturm_Daemons_Slaanesh, Sturm_Daemons_All_Gods));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstuezung_Daemons_Slaanesh, Unterstuezung_Daemons_All_Gods, new String[]{"", "Giant Chaos Spawn [FW]", "Spined Chaos Beast [FW]"}));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{"", "Zarakynel [FW]"});
        }  else if (getFormationType().equals("Nurgle")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQ_Daemons_Nurgle, HQ_Daemons_All_Gods, new String[]{"","Mamon Transfigured [FW]", "Corbax Utterblight [FW]"}));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Elite_Daemons_Nurgle, new String[]{"", "Chaos Decimator [FW]"}));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standard_Daemons_Nurgle);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturm_Daemons_Nurgle, Sturm_Daemons_All_Gods, new String[]{"","Greater Blight Drone [FW]", "Plague Toads Of Nurgle [FW]","Pox Riders Of Nurgle [FW]"}));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstuezung_Daemons_All_Gods, new String[]{"", "Giant Chaos Spawn [FW]", "Spined Chaos Beast [FW]", "Plague Hulk Of Nurgle [FW]"}));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigung_Daemons_Nurgle);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{"", "Scabeiathrax The Bloated [FW]"});
        } else if (getFormationType().equals("The Tainted")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Chaos_Space_Marines, new String[]{"", "Necrosius the Undying [FW]", "Mamon Transfigured [FW]"}, HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Chaos_Space_Marines, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_Chaos_Space_Marines, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Chaos_Space_Marines, Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungseinträge_Chaos_Space_Marines, Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(Transporteinträge_Chaos_Space_Marines, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_Chaos_Space_Marines, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(Befestigungseinträge_Chaos_Space_Marines, Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LOWeinträge_Chaos_Space_Marines, LOWeinträge_Chaos_Space_Marines_FW));
        }

        if (formation != null) {
            formation.refreshControlPanel();
        }

        fillChooserSpace();
    }
}