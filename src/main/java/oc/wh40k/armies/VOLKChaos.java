package oc.wh40k.armies;


import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;
import oc.utils.ResourceUtils;

import java.io.InputStream;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import static oc.utils.ResourceUtils.loadPoints;

public class VOLKChaos extends BuildaVater {

    private static final String[] HQeinträge_Chaos_Space_Marines_FW = new String[]{"", "Zhufor The Impaler [FW]", "Lord Arkos [FW]", "Chaos Hellwright [FW]", "Chaos Hellwright On Dark Abeyant [FW]"};
    private static final String[] Eliteeinträge_Chaos_Space_Marines_FW = new String[]{"", "Chaos Decimator [FW]", "Hellforged Contemptor Dreadnought [FW]", "Hellforged Predator [FW]"};
    private static final String[] Standardeinträge_Chaos_Space_Marines_FW = new String[]{""};
    private static final String[] Sturmeinträge_Chaos_Space_Marines_FW = new String[]{"", "Blood Slaughterer of Khorne [FW]", "Greater Blight Drone [FW]", "Hellforged Dreadclaw Drop Pod [FW]", "Hellforged Kharybdis Assault Claw [FW]"};
    private static final String[] Unterstützungseinträge_Chaos_Space_Marines_FW = new String[]{"", "Hellforged Land Raider Proteus [FW]", "Hellforged Land Raider Achilles [FW]", "Hellforged Scorpius [FW]", "Hellforged Sicarian [FW]", 
    		"Hellforged Sicarian Venator [FW]","Hellforged Deredeo Dreadnought [FW]","Hellforged Rapier Battery [FW]","Hellforged Leviathan Dreadnought [FW]","Spined Chaos Beast [FW]"};
    private static final String[] Transporteinträge_Chaos_Space_Marines_FW = new String[]{""};
    private static final String[] Fliegereinträge_Chaos_Space_Marines_FW = new String[]{"","Chaos Hell Blade [FW]","Chaos Hell Talon [FW]","Chaos Storm Eagle Assault Gunship [FW]","Chaos Fire Raptor Assault Gunship [FW]","Chaos Xiphon Interceptor [FW]"};
    private static final String[] Befestigungseinträge_Chaos_Space_Marines_FW = new String[]{""};
    private static final String[] LOWeinträge_Chaos_Space_Marines_FW = new String[]{"","Kytan Ravager [FW]","Greater Brass Scorpion Of Khorne [FW]","Hellforged Spartan Assault Tank [FW]","Hellforged Cerberus Heavy Destroyer [FW]","Hellforged Typhon Heavy Siege Tank [FW]","Hellforged Fellblade [FW]",
            "Hellforged Falchion [FW]","Hellforged Mastodon [FW]","Chaos Thunderhawk Assault Gunship [FW]","Chaos Sokar Pattern Stormbird Gunship [FW]","Anggrath The Unbound [FW]","Zarakynel [FW]","Aetaos'rau'keres [FW]","Scabeiathrax The Bloated [FW]",
            "Renegade Knight Acheron [FW]","Renegade Knight Lancer [FW]","Renegade Knight Castigator [FW]","Renegade Knight Atropos [FW]","Renegade Knight Magaera [FW]","Renegade Knight Porphyrion [FW]","Renegade Knight Styrix [FW]","","Chaos Warlord Battle Titan [FW]","Chaos Reaver Battle Titan [FW]", "Chaos Warhound Scout Titan [FW]"};

    private static final String[] HQeinträge_Daemons_FW = new String[]{"","Uraka The Warfiend [FW]","Samus [FW]","Mamon Transfigured [FW]","Corbax Utterblight [FW]"};
    private static final String[] Sturmeinträge_Daemons_FW = new String[]{"","Plague Toads Of Nurgle [FW]","Pox Riders Of Nurgle [FW]"};
    private static final String[] Unterstützungseinträge_Daemons_FW = new String[]{"","Plague Hulk Of Nurgle [FW]"};

    private static final String[] HQeinträge_Chaos_Space_Marines = new String[]{"", "Legion", "", "Abaddon the Despoiler", "Huron Blackheart", "Cypher", "Fabius Bile", "Kharn the Betrayer",
            "Lucius the Eternal", "Chaos Lord", "Chaos Lord in Terminator Armour",
            "Dark Apostle", "Exalted Champion", "Daemon Prince of Chaos CSM", "Daemon Prince of Chaos with Wings CSM",
            "Sorcerer", "Sorcerer in Terminator Armour",
            "Warpsmith",
            "", "Chaos Lord on Bike [INDEX]", "Chaos Lord on Juggernaut of Khorne [INDEX]", "Chaos Lord on Disc of Tzeentch [INDEX]", "Chaos Lord on Palanquin of Nurgle [INDEX]", "Chaos Lord on Steed of Slaanesh [INDEX]", 
                "Sorcerer on Bike [INDEX]", "Sorcerer on Disc of Tzeentch [INDEX]", "Sorcerer on Palanquin of Nurgle [INDEX]", "Sorcerer on Palanquin of Nurgle [INDEX]"};
    private static final String[] Eliteeinträge_Chaos_Space_Marines = new String[]{"", "Fallen", "Chaos Terminators", "Khorne Berzerkers", "Rubric Marines", "Plague Marines CSM", "Noise Marines", "Chosen", "Possessed", "Helbrute", "Mutilators"};
    private static final String[] Standardeinträge_Chaos_Space_Marines = new String[]{"", "Chaos Space Marines", "Chaos Cultists", "Bloodletters", "Horrors", "Plaguebearers", "Daemonettes"};
    private static final String[] Sturmeinträge_Chaos_Space_Marines = new String[]{"", "Chaos Bikers", "Raptors", "Warp Talons", "Chaos Spawn"};
    private static final String[] Unterstützungseinträge_Chaos_Space_Marines = new String[]{"", "Chaos Land Raider", "Chaos Predator", "Chaos Vindicator", "Obliterators", "Havocs", "Forgefiend", "Maulerfiend", "Defiler"};
    private static final String[] Transporteinträge_Chaos_Space_Marines = new String[]{"", "Chaos Rhino"};
    private static final String[] Fliegereinträge_Chaos_Space_Marines = new String[]{"", "Heldrake"};
    private static final String[] Befestigungseinträge_Chaos_Space_Marines = new String[]{"", "Chaos Bastions"};
    private static final String[] LOWeinträge_Chaos_Space_Marines = new String[]{"", "Khorne Lord of Skulls"};

    private static final String[] HQeinträge_World_Eaters = new String[]{"", "Kharn the Betrayer", "Chaos Lord", "Chaos Lord in Terminator Armour", "Exalted Champion",
            "Dark Apostle", "Daemon Prince of Chaos", "Daemon Prince of Chaos with Wings", "Warpsmith",
            "", "Chaos Lord on Bike [INDEX]", "Chaos Lord on Juggernaut of Khorne [INDEX]"};
    private static final String[] Eliteeinträge_World_Eaters = new String[]{"", "Fallen", "Plague Marines", "Noise Marines", "Rubric Marines", "Chaos Terminators", "Chosen", "Possessed", "Helbrute", "Mutilators"};
    private static final String[] Standardeinträge_World_Eaters = new String[]{"", "Khorne Berzerkers", "Chaos Space Marines", "Chaos Cultists"};
    private static final String[] Sturmeinträge_World_Eaters = new String[]{"", "Chaos Bikers", "Raptors", "Warp Talons", "Chaos Spawn"};
    private static final String[] Unterstützungseinträge_World_Eaters = new String[]{"", "Chaos Land Raider", "Chaos Predator", "Chaos Vindicator", "Obliterators", "Havocs", "Forgefiend", "Maulerfiend", "Defiler"};
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
            "Chaos Lord", "Chaos Lord in Terminator Armour", "Sorcerer", "Sorcerer in Terminator Armour", "", "Necrosius the Undying [FW]"};
    private static final String[] Eliteeinträge_Death_Guard = new String[]{"", "Noxious Blightbringer", "Foul Blightspawn", "Biologus Putrifier", "Plague Surgeon", "Tallyman", "Deathshroud Terminators", "Blightlord Terminators", "Helbrute", "Beasts of Nurgle", "Possessed"};
    private static final String[] Standardeinträge_Death_Guard = new String[]{"", "Plague Marines", "Poxwalkers", "Chaos Cultists", "Plaguebearers", "Nurglings"};
    private static final String[] Sturmeinträge_Death_Guard = new String[]{"", "Foetid Bloat Drone", "Myphitic Blight-Haulers", "Chaos Spawn", "Plague Drones"};
    private static final String[] Unterstützungseinträge_Death_Guard = new String[]{"", "Chaos Land Raider", "Plagueburst Crawler", "Defiler", "Chaos Predator"};
    private static final String[] Transporteinträge_Death_Guard = new String[]{"", "Chaos Rhino"};
    private static final String[] Fliegereinträge_Death_Guard = new String[]{""};
    private static final String[] LOWeinträge_Death_Guard = new String[]{"", "Mortarion"};

    private static final String[] HQeinträge_Emperors_Children = new String[]{"", "Lucius the Eternal", "Chaos Lord", "Chaos Lord in Terminator Armour",
            "Dark Apostle", "Daemon Prince of Chaos", "Daemon Prince of Chaos with Wings",
            "Sorcerer", "Sorcerer in Terminator Armour",
            "Warpsmith",
            "", "Chaos Lord on Bike [INDEX]", "Chaos Lord on Juggernaut of Khorne [INDEX]", "Chaos Lord on Disc of Tzeentch [INDEX]", "Chaos Lord on Palanquin of Nurgle [INDEX]", "Chaos Lord on Steed of Slaanesh [INDEX]", 
                "Sorcerer on Bike [INDEX]", "Sorcerer on Disc of Tzeentch [INDEX]", "Sorcerer on Palanquin of Nurgle [INDEX]"};
    private static final String[] Eliteeinträge_Emperors_Children = new String[]{"", "Fallen", "Plague Marines", "Khorne Berzerkers", "Rubric Marines", "Chaos Terminators", "Chosen", "Possessed", "Helbrute", "Mutilators"};
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
    private static final String[] LOWeinträge_Questor_Traitoris = new String[]{"", "Renegade Knight", "Renegade Knight Dominus", "Renegade Armiger"};

    private static final String[] HQeinträge_Daemons = new String[]{
            "", "Skarbrand", "Bloodthirster of Insensate Rage", "Wrath of Khorne Bloodthirster", "Bloodthirster of Unfettered Fury", "Skulltaker", "Bloodmaster", "Skullmaster", "Blood Throne", "Karanak",
            "", "Kairos Fateweaver", "Lord of Change", "The Changeling", "The Blue Scribes", "Changecaster", "Fateskimmer", "Fluxmaster",
            "", "Rotigus", "Great Unclean One", "Epidemius", "Horticulous Slimux", "Poxbringer", "Sloppity Bilepiper", "Spoilpox Scrivener",
            "", "Keeper of Secrets", "The Masque of Slaanesh", "Herald of Slaanesh", "Herald of Slaanesh on Steed", "Herald of Slaanesh on Seeker Chariot", "Herald of Slaanesh on Exalted Seeker Chariot",
            "", "Be'Lakor", "Daemon Prince of Chaos", "Daemon Prince of Chaos with Wings"};
    private static final String[] Eliteeinträge_Daemons = new String[]{"", "Bloodcrushers", "", "Flamers", "Exalted Flamer", "", "Beasts of Nurgle", "", "Fiends of Slaanesh"};
    private static final String[] Standardeinträge_Daemons = new String[]{"", "Bloodletters", "", "Horrors", "", "Plaguebearers", "Nurglings", "", "Daemonettes"};
    private static final String[] Sturmeinträge_Daemons = new String[]{"", "Flesh Hounds", "", "Screamers", "", "Plague Drones", "", "Seekers", "Hellflayer", "", "Furies"};
    private static final String[] Unterstüzungseinträge_Daemons = new String[]{"", "Skull Cannon", "", "Burning Chariot", "", "Seeker Chariot", "Exalted Seeker Chariot", "", "Soulgrinder"};
    private static final String[] Befestigungseinträge_Daemons = new String[]{"", "Feculent Gnarlmaws"};


    private static final Set<String> LEGIONS = ImmutableSet.of("Alpha Legion", "Black Legion", "Emperor's Children", "Iron Warriors", "Night Lords", "World Eaters", "Word Bearers");
    private static final Set<String> CHAOS_GODS = ImmutableSet.of("Khorne", "Tzeentch", "Nurgle", "Slaanesh");
    
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
        adden(new ChooserGruppe(this, getId(), cnt, 0, TROOPS, Transporteinträge));
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
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungseinträge_Chaos_Space_Marines, Unterstützungseinträge_Death_Guard, Unterstützungseinträge_ThousandSons, Unterstüzungseinträge_Daemons, Unterstützungseinträge_Chaos_Space_Marines_FW, Unterstützungseinträge_Daemons_FW));
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
        } else if (getFormationType().equals("Chaosdaemons") || CHAOS_GODS.contains(getFormationType())) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Daemons, HQeinträge_Daemons_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Daemons);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Daemons);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Daemons, Sturmeinträge_Daemons_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstüzungseinträge_Daemons, Unterstützungseinträge_Daemons_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungseinträge_Daemons);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{""});
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