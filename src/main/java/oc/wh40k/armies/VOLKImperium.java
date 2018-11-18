package oc.wh40k.armies;


import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.stream.Stream;

public class VOLKImperium extends BuildaVater {

    private static final Logger LOGGER = LoggerFactory.getLogger(VOLKImperium.class);

    private static final String[] HQeinträge_AM = new String[]{"", "Company Commander", "Tank Commander"};
    private static final String[] Standardeinträge_AM = new String[]{"", "Infantry Squad", "Conscripts"};
    private static final String[] Eliteeinträge_AM = new String[]{"", "Master of Ordnance", "Platoon Commander", "Command Squad", "Special Weapons Squad", "Veterans", "Tech-Priest Enginseer", "Servitors"};
    private static final String[] Sturmeinträge_AM = new String[]{"", "Rough Riders", "Scout Sentinels", "Armoured Sentinels", "Hellhounds"};
    private static final String[] Unterstützungeinträge_AM = new String[]{"", "Heavy Weapons Squad", "Basilisks", "Hydras", "Wyverns", "Manticore", "Deathstrike",
            "Leman Russ Battle Tanks"};
    private static final String[] Transporteinträge_AM = new String[]{"", "Chimera", "Taurox"};
    private static final String[] Fliegereinträge_AM = new String[]{"",};
    private static final String[] LordofWar_AM = new String[]{"", "Baneblade", "Banehammer", "Banesword", "Doomhammer", "Hellhammer", "Shadowsword", "Stormlord", "Stormsword"};
    //CADIAN
    private static final String[] HQeinträge_Cadian = new String[]{"", "Lord Castellan Creed", "Knight Commander Pask"};
    private static final String[] Eliteeinträge_Cadian = new String[]{"", "Colour Sergeant Kell"};
    //CATACHAN
    private static final String[] HQeinträge_Catachan = new String[]{"", "Colonel 'Iron Hand' Straken", "Sly Marbo"};
    private static final String[] Eliteeinträge_Catachan = new String[]{"", "Sergeant Harker"};
    //OFFICIO PREFECTUS
    private static final String[] HQeinträge_Officio_Prefectus = new String[]{"", "Lord Commissar", "Commissar Yarrick"};
    private static final String[] Eliteeinträge_Officio_Prefectus = new String[]{"", "Commissar"};
    //MILITARUM TEMPESTUS
    private static final String[] HQeinträge_Militarum_Tempestus = new String[]{"", "Tempestor Prime"};
    private static final String[] Eliteeinträge_Militarum_Tempestus = new String[]{"", "Militarum Tempestus Command Squad"};
    private static final String[] Standardeinträge_Militarum_Tempestus = new String[]{"", "Militarum Tempestus Scions"};
    private static final String[] Transporteinträge_Militarum_Tempestus = new String[]{"", "Taurox Prime"};
    //MILITARUM AUXILIA
    private static final String[] Eliteeinträge_Militarum_Auxilia = new String[]{"", "Ogryns", "Ogryn Bodyguard", "Bullgryns", "Ratlings", "Nork Deddog"};
    //AERONAUTICA IMPERIALIS
    private static final String[] Eliteeinträge_Aeronautica_Imperialis = new String[]{"", "Officer of the Fleet"};
    private static final String[] Fliegereinträge_Aeronautica_Imperialis = new String[]{"", "Valkyries"};
    //SCHOLASTICA PSYKANA
    private static final String[] HQeinträge_Scholastica_Psykana = new String[]{"", "Primaris Psyker"};
    private static final String[] Eliteeinträge_Scholastica_Psykana = new String[]{"", "Wyrdvane Psykers", "Astropath"};
    //ADEPTUS MINISTORUM-PART OF ASTRA MILITARUM
    private static final String[] Eliteeinträge_Astra_Militarum_Adeptus_Ministorum = new String[]{"", "Ministorum Priest", "Crusaders"};

    //AM KOMPLETT
    private static final String[] HQeinträge_AM_komplett = uniteUnitList(uniteUnitList(uniteUnitList(uniteUnitList(uniteUnitList
                    (HQeinträge_AM, HQeinträge_Cadian), HQeinträge_Catachan),
            HQeinträge_Officio_Prefectus), HQeinträge_Militarum_Tempestus),
            HQeinträge_Scholastica_Psykana);
    private static final String[] Standardeinträge_AM_komplett = uniteUnitList(Standardeinträge_AM, Standardeinträge_Militarum_Tempestus);
    private static final String[] Eliteeinträge_AM_komplett = uniteUnitList(uniteUnitList(uniteUnitList(uniteUnitList(uniteUnitList(uniteUnitList(uniteUnitList(uniteUnitList(
            Eliteeinträge_AM, Eliteeinträge_Cadian), Eliteeinträge_Catachan), Eliteeinträge_Officio_Prefectus),
            Eliteeinträge_Militarum_Tempestus), Eliteeinträge_Militarum_Auxilia), Eliteeinträge_Aeronautica_Imperialis),
            Eliteeinträge_Scholastica_Psykana), Eliteeinträge_Astra_Militarum_Adeptus_Ministorum);
    private static final String[] Sturmeinträge_AM_komplett = Sturmeinträge_AM;
    private static final String[] Unterstützungeinträge_AM_komplett = Unterstützungeinträge_AM;
    private static final String[] Transporteinträge_AM_komplett = uniteUnitList(Transporteinträge_AM, Transporteinträge_Militarum_Tempestus);
    private static final String[] Fliegereinträge_AM_komplett = uniteUnitList(Fliegereinträge_AM, Fliegereinträge_Aeronautica_Imperialis);
    private static final String[] LordofWar_AM_komplett = LordofWar_AM;

    //ADEPTUS MECHANICUS ///////////////////////////////////////////////////////////////////////////////////////////////////////

    //CULT MECHANICUS
    private static final String[] HQeinträge_Cult_Mechanicus = new String[]{"", "Belisarius Cawl", "Tech-Priest Dominus", "Tech-Priest Enginseer AME"};
    private static final String[] Eliteeinträge_Cult_Mechanicus = new String[]{"", "Fulgurite Electro-Priests",
            "Corpuscarii Electro-Priests", "Cybernetica Datasmith"};
    private static final String[] Standardeinträge_Cult_Mechanicus = new String[]{"", "Kataphron Breachers", "Kataphron Destroyers"};
    private static final String[] Unterstützungseinträge_Cult_Mechanicus = new String[]{"", "Kastelan Robots"};

    //SKITARII
    private static final String[] Standardeinträge_Skitarii = new String[]{"", "Skitarii Rangers", "Skitarii Vanguard"};
    private static final String[] Eliteeinträge_Skitarii = new String[]{"", "Sicarian Infiltrators", "Sicarian Ruststalkers"};
    private static final String[] Sturmeinträge_Skitarii = new String[]{"", "Ironstrider Ballistarii", "Sydonian Dragoons"};
    private static final String[] Unterstützungseinträge_Skitarii = new String[]{"", "Onager Dunecrawler"};

    //ADEPTUS MECHANICUS Komplett
    private static final String[] HQeinträge_Adeptus_Mechanicus = HQeinträge_Cult_Mechanicus;
    private static final String[] Standardeinträge_Adeptus_Mechanicus = uniteUnitList(Standardeinträge_Cult_Mechanicus, Standardeinträge_Skitarii);
    private static final String[] Eliteeinträge_Adeptus_Mechanicus = uniteUnitList(uniteUnitList(
            Eliteeinträge_Cult_Mechanicus, Eliteeinträge_Skitarii), new String[]{"", "Servitors"});
    private static final String[] Sturmeinträge_Adeptus_Mechanicus = Sturmeinträge_Skitarii;
    private static final String[] Unterstützungseinträge_Adeptus_Mechanicus = uniteUnitList(Unterstützungseinträge_Cult_Mechanicus, Unterstützungseinträge_Skitarii);

    //Questor Imperialis
    private static final String[] AdditionalInformation_Questor_Imperialis = new String[]{"", "Household Tradition", "Imperial Knight Warlordtraits", "Imperial Knight Heirlooms"};
    private static final String[] LordofWar_Questor_Imperialis = new String[]{"", "Armiger Helverin", "Armiger Warglaive", "Knight Preceptor", "Knight Paladin", "Knight Errant", "Knight Gallant", "Knight Warden", "Knight Crusader", "Canis Rex", "Knight Castellan", "Knight Valiant"};
    private static final String[] Befestigung_Questor_Imperialis = new String[]{"", "Sacristan Forgeshrine"};

    //Adepta Sororitas
    private static final String[] HQeinträge_Adepta_Sororitas = new String[]{"", "Celestine", "Canoness"};
    private static final String[] Standardeinträge_Adepta_Sororitas = new String[]{"", "Battle Sisters Squad"};
    private static final String[] Eliteeinträge_Adepta_Sororitas = new String[]{"", "Imagifier", "Hospitaller", "Dialogus", "Celestian Squad",
            "Mistress Of Repentance", "Repentia Squad"};
    private static final String[] Sturmeinträge_Adepta_Sororitas = new String[]{"", "Seraphim Squad", "Dominion Squad"};
    private static final String[] Unterstützungseinträge_Adepta_Sororitas = new String[]{"", "Retributor Squad", "Exorcist"};
    private static final String[] Transporteinträge_Adepta_Sororitas = new String[]{"", "Sororitas Rhino", "Immolator"};

    //Adeptus Ministorum
    private static final String[] HQeinträge_Adeptus_Ministorum = uniteUnitList(new String[]{"", "Uriah Jacobus"}, HQeinträge_Adepta_Sororitas);
    private static final String[] Standardeinträge_Adeptus_Ministorum = Standardeinträge_Adepta_Sororitas;
    private static final String[] Eliteeinträge_Adeptus_Ministorum_Only = new String[]{"Death Cult Assassins", "Arco Flagellants", "Ministorum Priest Adeptus Ministorum"};
    private static final String[] Eliteeinträge_Adeptus_Ministorum = uniteUnitList(uniteUnitList(Eliteeinträge_Astra_Militarum_Adeptus_Ministorum, Eliteeinträge_Adeptus_Ministorum_Only), Eliteeinträge_Adepta_Sororitas);
    private static final String[] Sturmeinträge_Adeptus_Ministorum = Sturmeinträge_Adepta_Sororitas;
    private static final String[] Unterstützungseinträge_Adeptus_Ministorum = uniteUnitList(new String[]{"", "Penitent Engines"},
            Unterstützungseinträge_Adepta_Sororitas);
    private static final String[] Transporteinträge_Adeptus_Ministorum = Transporteinträge_Adepta_Sororitas;

    //Sisters of Silence
    private static final String[] Eliteeinträge_Sisters_of_Silence = new String[]{"", "Prosecutors", "Vigilators", "Witchseekers"};
    private static final String[] Transporteinträge_Sisters_of_Silence = {"", "Null-Maiden Rhino"};

    //Adeptus Astra Telepathica -> Gesamtliste
    private static final String[] HQeinträge_Adeptus_Astra_Telepathica = HQeinträge_Scholastica_Psykana;
    private static final String[] Eliteeinträge_Adeptus_Astra_Telepathica = uniteUnitList(Eliteeinträge_Scholastica_Psykana, Eliteeinträge_Sisters_of_Silence);
    private static final String[] Transporteinträge_Adeptus_Astra_Telepathica = Transporteinträge_Sisters_of_Silence;

    //Officio Assassinorum
    private static final String[] Eliteeinträge_Officio_Assassinorum = new String[]{"", "Vindicare Assassin", "Callidus Assassin", "Eversor Assassin", "Culexus Assassin"};

    //Inquisition
    public String[] Eliteeinträge_Inquisition = new String[]{"", /*TODO:"Daemonhost",*/};

    //<Ordo>
    public String[] HQeinträge_Ordo = new String[]{"", /*TODO:"Inquisitor",*/};
    public String[] Eliteeinträge_Ordo = new String[]{"", /*TODO:"Acolytes", /*TODO:"Jokaero Weaponsmith",*/};

    //Ordo Hereticus
    public String[] HQeinträge_Ordo_Hereticus = new String[]{"", /*TODO:"Inquisitor Greyfax", /*TODO:"Inquisitor Karamazov", */};

    //Ordo Malleus
    public String[] HQeinträge_Ordo_Malleus = new String[]{"", /*TODO:"Ordo Malleus Inquisitor", /*TODO:"Inquisitor Coteaz", */};

    //Adeptus Custodes
    private static final String[] HQeinträge_Adeptus_Custodes = new String[]{"", "Captain-General Trajann Valoris", "Shield-Captain", "Shield-Captain in Allarus Terminator Armour", "Shield-Captain on Dawneagle Jetbike"};
    private static final String[] Standardeinträge_Adeptus_Custodes = new String[]{"", "Custodian Guard"};
    private static final String[] Eliteeinträge_Adeptus_Custodes = new String[]{"", "Custodian Wardens", "Vexilus Praetor in Allarus Terminator Armour", "Vexilus Praetor", "Allarus Custodians",
            "Venerable Contemptor Dreadnought", "Contemptor-Achillus Dreadnought", "Contemptor-Exemplar Dreadnought"};
    private static final String[] Sturmeinträge_Adeptus_Custodes = new String[]{"", "Vertus Praetors", "Caladius Grav-tank"};
    private static final String[] Unterstützungseinträge_Adeptus_Custodes = new String[]{"", "Venerable Land Raider", "Coronus Grav-carrier"};

    private static final String[] Befestigungen = new String[]{""};

    private static final String[] HQeinträge_SM = new String[]{"", "Captain", "Captain in Terminator Armour", "Captain in Cataphractii Armour",
            "Captain in Gravis Armour", "Captain on Bike", "Librarian", "Librarian in Terminator Armour", "Librarian on Bike",
            "Techmarine", "Techmarine on Bike", "Chaplain", "Chaplain in Terminator Armour", "Master", "Master in Terminator Armour", "Master in Cataphractii Armour", "Master in Gravis Armour",
            "Chaplain on Bike", "Lieutenants", "", "Primaris Chaplain", "Primaris Librarian", "Primaris Lieutenants", "Primaris Master", "Primaris Captain",
            "Rhino Primaris", "Land Raider Excelsior"};
    private static final String[] Standardeinträge_SM = new String[]{"", "Tactical Squad", "Scout Squad", "Intercessor Squad"};
    private static final String[] Eliteeinträge_SM = new String[]{"", "Servitors", "Apothecary", "Apothecary on Bike", "Primaris Apothecary",
            "Company Ancient", "Company Ancient on Bike",
            "Primaris Ancient", "Company Champion", "Company Champion on Bike", "Company Veterans", "Company Veterans on Bikes",
            "Imperial Space Marine", "Honour Guard", "Chapter Ancient", "Chapter Champion", "Centurion Assault Squad",
            "Sternguard Veteran Squad", "Vanguard Veteran Squad", "Dreadnought", "Venerable Dreadnought", "Contemptor Dreadnought",
            "Redemptor Dreadnought", "Ironclad Dreadnought", "Terminator Squad", "Terminator Assault Squad", "Cataphractii Terminator Squad",
            "Tartaros Terminator Squad", "Aggressor Squad", "Reiver Squad"};
    private static final String[] Sturmeinträge_SM = new String[]{"", "Assault Squad", "Inceptor Squad", "Scout Bike Squad", "Bike Squad",
            "Attack Bike Squad", "Land Speeders"};
    private static final String[] Unterstützungeinträge_SM = new String[]{"", "Devastator Squad", "Centurion Devastator Squad", "Hellblaster Squad",
            "Thunderfire Cannon", "Predator", "Whirlwind", "Vindicator", "Hunter", "Stalker", "Land Raider",
            "Land Raider Crusader", "Land Raider Redeemer"};
    private static final String[] Transporteinträge_SM = new String[]{"", "Rhino", "Razorback", "Drop Pod", "Land Speeder Storm", "Repulsor",};
    private static final String[] Fliegereinträge_SM = new String[]{"", "Stormhawk Interceptor", "Stormtalon Gunship", "Stormraven Gunship",};
    private static final String[] LordOfWar_SM = new String[]{"", "AstraeusSuperHeavyTank"};

    //Ultramarines
    private static final String[] HQeinträge_Ultramarines = new String[]{"", "Marneus Calgar", "Marneus Calgar in Artificer Armour",
            "Captain Sicarius", "Chief Librarian Tigurius", "Chaplain Cassius", "Sergeant Telion", "Sergeant Chronus"};
    private static final String[] Eliteeinträge_Ultramarines = new String[]{"", "Tyrannic War Veterans",};
    private static final String[] LordofWar_Ultramarines = new String[]{"", "Roboute Guilliman", "Terminus Ultra",};

    //Imperial Fists
    private static final String[] HQeinträge_Imperial_Fists = new String[]{"", "Captain Lysander"};

    //Crimson Fists
    private static final String[] HQeinträge_Crimson_Fists = new String[]{"", "Pedro Kantor"};

    //Black Templars
    private static final String[] HQeinträge_Black_Templars = new String[]{"", "High Marshal Helbrecht", "The Emperor's Champion", "Chaplain Grimaldus"};
    private static final String[] Eliteeinträge_Black_Templars = new String[]{"", "Cenobyte Servitors"};
    private static final String[] Standardeinträge_Black_Templars = new String[]{"", "Crusader Squad"};

    //Raven Guard
    private static final String[] HQeinträge_Raven_Guard = new String[]{"", "Kayvaan Shrike"};

    //Salamanders
    private static final String[] HQeinträge_Salamanders = new String[]{"", "Vulkan He'stan"};

    //White Scars
    private static final String[] HQeinträge_White_Scars = new String[]{"", "Kor'sarro Khan", "Kor'sarro Khan on Moondrakkan"};

    //Legion of the Damned
    private static final String[] Eliteeinträge_Legion_of_the_Damned = new String[]{"", "Damned Legionnaires"};

    //Blood Angels
    private static final String[] HQeinträge_Blood_Angels = new String[]{"", "Commander Dante", "Gabriel Seth", "Captain Tycho", "Tycho the Lost",
            "Librarian Dreadnought", "Chief Librarian Mephiston", "The Sanguinor",
            "Astorath", "Sanguinary Priest", "Sanguinary Priest on Bike",
            "Brother Corbulo", "Lemartes",};
    private static final String[] Eliteeinträge_Blood_Angels = new String[]{"", "Sanguinary Guard Ancient", "Terminator Ancient", "Death Company",
            "Sanguinary Guard", "Death Company Dreadnought", "Furioso Dreadnought"};
    private static final String[] Unterstützungseinträge_Blood_Angels = new String[]{"", "Baal Predator"};

    private static final String[] Sturmeinträge_Blood_Angels = new String[]{"", "Assault Squad BA", "Inceptor Squad", "Scout Bike Squad", "Bike Squad",
            "Attack Bike Squad", "Land Speeders"};

    //Dark Angels
    private static final String[] HQeinträge_Dark_Angels = new String[]{"", "Azrael", "Belial", "Sammael on Corvex", "Sammael in Sableclaw", "Interrogator-Chaplain", "Ravenwing Talonmaster",
            "Interrogator-Chaplain in Terminator Armour", "Interrogator-Chaplain on Bike", "Asmodai", "Ezekiel"};
    private static final String[] Eliteeinträge_Dark_Angels = new String[]{"", "Deathwing Apothecary", "Deathwing Ancient", "Deathwing Champion", "Deathwing Terminator Squad", "Deathwing Cataphractii Terminator Squad",
            "Deathwing Tartaros Terminator Squad", "Deathwing Knights", "Ravenwing Apothecary", "Ravenwing Ancient", "Ravenwing Champion",};
    private static final String[] Sturmeinträge_Dark_Angels = new String[]{"", "Ravenwing Bike Squad", "Ravenwing Attack Bike Squad", "Ravenwing Land Speeders", "Ravenwing Darkshroud",
            "Ravenwing Black Knights", "Ravenwing Land Speeder Vengeance",};
    private static final String[] Fliegereinträge_Dark_Angels = new String[]{"", "Nephilim Jetfighter", "Ravenwing Dark Talon", "Stormraven Gunship"};
    private static final String[] Befestigungen_Dark_Angels = new String[]{"", "Fortress of Redemption",};

    //Space Wolves
    private static final String[] HQeinträge_Space_Wolves = new String[]{"", "Logan Grimnar", "Logan Grimnar on Stormrider", "Arjac Rockfist", "Bjorn the Fell-Handed", "Njal Stormcaller", "Njal Stormcaller in Runic Terminator Armour",  
    		"", "Rune Priest in Terminator Armour", "Primaris Rune Priest", "Rune Priest",
    		"", "Ulrik the Slayer", "Wolf Priest in Terminator Armour", "Primaris Wolf Priest", "Wolf Priest",
    		"", "Ragnar Blackmane", "Krom Dragongaze", "Harald Deathwolf", "Wolf Lord", "Wolf Lord on Thunderwolf", "Wolf Lord in Terminator Armour", "Wolf Lord in Cataphractii Armour", "Primaris Wolf Lord", "Wolf Lord in Gravis Armour", 
    		"", "Canis Wolfborn", "Wolf Guard Battle Leader", "Primaris Battle Leader", "Wolf Guard Battle Leader in Terminator Armour", "Wolf Guard Battle Leader on Thunderwolf",
            "", "Iron Priest",
            "", "Rune Priest on Bike[INDEX]", "Wolf Priest on Bike[INDEX]", "Wolf Lord on Bike[INDEX]", "Wolf Guard Battle Leader on Bike[INDEX]", "Iron Priest on Bike[INDEX]", "Iron Priest on Thunderwolf[INDEX]"};
    private static final String[] Standardeinträge_Space_Wolves = new String[]{"", "Blood Claws", "Grey Hunters"};
    private static final String[] Eliteeinträge_Space_Wolves = new String[]{"", "Wolf Scouts", "Lukas the Trickster", "Wulfen Dreadnought", "Wolf Guard",  "Wolf Guard Terminators",
    		 "Wolf Guard Cataphractii Terminators", "Wolf Guard Tartaros Terminators", "Wulfen", "Murderfang",  
            "", "SW Venerable Dreadnought[INDEX]", "Wolf Guard on Bikes[INDEX]", "Lone Wolf[INDEX]", "Lone Wolf in Terminator Armour[INDEX]"};
    private static final String[] Sturmeinträge_Space_Wolves = new String[]{"", "Cyberwolves", "Swiftclaws", "Swiftclaw Attack Bikes", "Thunderwolf Cavalry", "Fenrisian Wolves", "Skyclaws", "Wolf Scout Bikers"};
    private static final String[] Fliegereinträge_Space_Wolves = new String[]{"", "Stormwolf", "Stormfang Gunship", "Stormhawk Interceptor"};
    private static final String[] Unterstützungseinträge_Space_Wolves = new String[]{"", "Long Fangs"};

    //Deathwatch
    private static final String[] HQeinträge_Deathwatch = new String[]{"", "Watch Master", "Watch Captain Artemis", "Watch Captain", "Watch Captain in Terminator Armour", "Primaris Watch Captain", "Deathwatch Librarian", "Deathwatch Librarian in Terminator Armour", "Deathwatch Primaris Librarian", "Deathwatch Chaplain", "Deathwatch Chaplain in Terminator Armour", "Deathwatch Primaris Chaplain"};
    private static final String[] Standardeinträge_Deathwatch = new String[]{"", "Deathwatch Veterans", "Deathwatch Intercessors"};
    private static final String[] Eliteeinträge_Deathwatch = new String[]{"", "Deathwatch Primaris Apothecary", "Venerable Dreadnought", "Dreadnought", "Redemptor Dreadnought", "Deathwatch Terminator Squad", "Deathwatch Reiver Squad", "Aggressor Squad", "Deathwatch Vanguard Veterans"};
    private static final String[] Sturmeinträge_Deathwatch = new String[]{"", "Deathwatch Bikers", "Inceptor Squad"};
    private static final String[] Unterstützungseinträge_Deathwatch = new String[]{"", "Hellblaster Squad", "Land Raider", "Land Raider Crusader", "Land Raider Redeemer"};
    private static final String[] Transporteinträge_Deathwatch = new String[]{"", "Razorback", "Rhino", "Drop Pod", "Repulsor"};
    private static final String[] Fliegereinträge_Deathwatch = new String[]{"", "Corvus Blackstar"};

    //Grey Knights
    private static final String[] HQeinträge_Grey_Knights = new String[]{"", "Lord Kaldor Draigo", "Grand Master Voldus", "Grand Master", "Grand Master in Nemesis Dreadknight",
            "Castellan Crowe", "Brother Captain Stern", "Brother-Captain", "Librarian GK", "Techmarine GK", "Chaplain GK", "Brotherhood Champion"};
    private static final String[] Standardeinträge_Grey_Knights = new String[]{"", "Grey Knight Terminator Squad", "Strike Squad"};
    private static final String[] Eliteeinträge_Grey_Knights = new String[]{"", "Brotherhood Ancient", "Purifier Squad", "Paladin Squad",
            "Paladin Ancient", "Grey Knight Apothecary", "Dreadnought GK", "Venerable Dreadnought GK", "Servitors"};
    private static final String[] Sturmeinträge_Grey_Knights = new String[]{"", "Interceptor Squad"};
    private static final String[] Unterstützungseinträge_Grey_Knights = new String[]{"", "Purgation Squad", "Nemesis Dreadknight", "Land Raider", "Land Raider Crusader", "Land Raider Redeemer"};
    private static final String[] Transporteinträge_Grey_Knights = new String[]{"", "Razorback", "Rhino"};
    private static final String[] Fliegereinträge_Grey_Knights = new String[]{"", "Stormhawk Interceptor", "Stormraven Gunship", "Stormtalon Gunship"};

    //Imperial Armour Adeptus Astartes
    private static final String[] HQeinträge_IA_AA = new String[]{"", "Chaplain Venerable Dreadnought", "Damocles Command Rhino",};
    private static final String[] Eliteeinträge_IA_AA = new String[]{"", "Deimos Pattern Relic Predator", "Relic Sicaran Battle Tank", "Relic Sicaran Venator Tank Destroyer",
            "Relic Sicaran Punisher Assault Tank", "Relic Sicaran Arcus Strike Tank", "Relic Sicaran Omega Tank Destroyer", "Relic Contemptor Dreadnought",
            "Relic Deredeo Dreadnought", "Relic Javelin Attack Speeder", "Relic Whirlwind Scorpius",};
    private static final String[] Sturmeinträge_IA_AA = new String[]{"", "Land Speeder Tempest", "Tarantula Sentry Gun", "Tarantula Air Defence Battery", "Deathstorm Drop Pod",};
    private static final String[] Unterstützungseinträge_IA_AA = new String[]{"", "Deimos Pattern Vindicator Laser Destroyer", "Relic Land Raider Proteus", "Land Raider Helios",
            "Land Raider Prometheus", "Land Raider Achilles", "Mortis Dreadnought", "Siege Dreadnought", "Contemptor Mortis Dreadnought", "Relic Leviathan Dreadnought",
            "Whirlwind Hyperios", "Rapier Carrier",};
    private static final String[] Transporteinträge_IA_AA = new String[]{"", "Infernum Pattern Razorback", "Lucius Pattern Dreadnought Drop Pod",};
    private static final String[] Fliegereinträge_IA_AA = new String[]{"", "Xiphon Interceptor", "Storm Eagle Assault Gunship", "Fire Raptor Assault Gunship", "Caestus Assault Ram",};
    private static final String[] LordofWar_IA_AA = new String[]{"", "Relic Spartan Assault Tank", "Relic Typhon Heavy Siege Tank", "Relic Cerberus Heavy Tank Destroyer",
            "Relic Fellblade Super-heavy Tank", "Relic Falchion Super-heavy Tank Destroyer", "Relic Mastodon Super-heavy Siege Transport",
            "Thunderhawk Assault Gunship", "Thunderhawk Transporter", "Sokar Pattern Stormbird",};

    private static final String[] Fliegereinträge_IA_Minotaurs = new String[]{"", "Storm Eagle Assault Gunship - ROC Pattern",};

    //Adeptus Astartes
    private static final String[] HQeinträge_AA_komplett = uniteUnitList(HQeinträge_SM, HQeinträge_Ultramarines, HQeinträge_Imperial_Fists,
            HQeinträge_Crimson_Fists, HQeinträge_Black_Templars, HQeinträge_Raven_Guard, HQeinträge_Salamanders,
            HQeinträge_White_Scars, HQeinträge_Blood_Angels, HQeinträge_Dark_Angels, HQeinträge_Space_Wolves,
            HQeinträge_Deathwatch, HQeinträge_Grey_Knights, HQeinträge_IA_AA);
    private static final String[] Standardeinträge_AA_komplett = uniteUnitList(Standardeinträge_SM, Standardeinträge_Black_Templars,
            Standardeinträge_Space_Wolves, Standardeinträge_Deathwatch, Standardeinträge_Grey_Knights);
    private static final String[] Eliteeinträge_AA_komplett = uniteUnitList(Eliteeinträge_SM, Eliteeinträge_Ultramarines, Eliteeinträge_Black_Templars,
            Eliteeinträge_Legion_of_the_Damned, Eliteeinträge_Blood_Angels, Eliteeinträge_Dark_Angels, Eliteeinträge_Space_Wolves,
            Eliteeinträge_Deathwatch, Eliteeinträge_Grey_Knights, Eliteeinträge_IA_AA);
    private static final String[] Sturmeinträge_AA_komplett = uniteUnitList(Sturmeinträge_SM, Sturmeinträge_Blood_Angels, Sturmeinträge_Dark_Angels, Sturmeinträge_Space_Wolves,
            Sturmeinträge_Deathwatch, Sturmeinträge_Grey_Knights, Sturmeinträge_IA_AA);
    private static final String[] Unterstützungeinträge_AA_komplett = uniteUnitList(Unterstützungeinträge_SM, Unterstützungseinträge_Blood_Angels,
            Unterstützungseinträge_Space_Wolves, Unterstützungseinträge_Deathwatch, Unterstützungseinträge_Grey_Knights, Unterstützungseinträge_IA_AA);
    private static final String[] Transporteinträge_AA_komplett = uniteUnitList(Transporteinträge_SM, Transporteinträge_IA_AA);
    private static final String[] Fliegereinträge_AA_komplett = uniteUnitList(Fliegereinträge_SM, Fliegereinträge_Dark_Angels,
            Fliegereinträge_Space_Wolves, Fliegereinträge_Deathwatch, Fliegereinträge_IA_AA, Fliegereinträge_IA_Minotaurs);
    private static final String[] LordofWar_AA_komplett = uniteUnitList(LordOfWar_SM, LordofWar_Ultramarines, LordofWar_IA_AA);

    public VOLKImperium() {
        reflectionKennung = "IM";

        Stream.of("sm", "ba", "da", "sw", "dw", "gk", "am", "ame", "qi", "ami", "oa", "ac", "iaaa")
                .map(name -> String.format("/oc/wh40k/indices/%s.csv", name))
                .forEach(file -> {
                    LOGGER.info("loading file {}", file);
                    appendPointList(BuildaHQ.loadindexFile(this.getClass().getResourceAsStream(file)));
                });

        AdditionalInformation = new String[]{""};
        HQeinträge = new String[]{""};
        Eliteeinträge = new String[]{"", "Custodian Guard Squad"};
        Standardeinträge = new String[]{""};
        Sturmeinträge = new String[]{""};
        Unterstützungeinträge = new String[]{""};
        Fliegereinträge = new String[]{""};
        Transporteinträge = new String[]{""};
        LordofWar = new String[]{""};

        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, AI, LordofWar));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, HQ, HQeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, TROOPS, Standardeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, ELITE, Eliteeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, FAST_ATTACK, Sturmeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, HEAVY_SUPPORT, Unterstützungeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, DEDICATED_TRANSPORT, Transporteinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, FLIER, Fliegereinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, FORTIFICATION, Befestigungen));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, LORD_OF_WAR, LordofWar));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;

        cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

        //Formationen
        formationen.add("IMPERIUM");
        formationen.add("");
        formationen.add("Adeptus Custodes");
        formationen.add("");
        formationen.add("Adeptus Astartes");
        formationen.add("Black Templars");
        formationen.add("Blood Angels");
        formationen.add("Crimson Fists");
        formationen.add("Dark Angels");
        formationen.add("Imperial Fists");
        formationen.add("Legion of the Damned");
        formationen.add("Ultramarines");
        formationen.add("Raven Guard");
        formationen.add("Salamanders");
        formationen.add("Space Wolves");
        formationen.add("White Scars");
        formationen.add("");
        formationen.add("Deathwatch");
        formationen.add("Grey Knights");
        formationen.add("");
        formationen.add("Astral Claws");
        formationen.add("Blood Ravens");
        formationen.add("Carcharodons");
        formationen.add("Executioners");
        formationen.add("Exorcists");
        formationen.add("Fire Angels");
        formationen.add("Fire Hawks");
        formationen.add("Howling Griffons");
        formationen.add("Lamenters");
        formationen.add("Mantis Warriors");
        formationen.add("Marines Errant");
        formationen.add("Minotaurs");
        formationen.add("Novamarines");
        formationen.add("Raptors");
        formationen.add("Red Scorpions");
        formationen.add("Sons of Medusa");
        formationen.add("Star Phantoms");
        formationen.add("Tiger Claws");
        formationen.add("");
        formationen.add("Astra Militarum");
        formationen.add("Cadian");
        formationen.add("Catachan");
        formationen.add("Officio Prefectus");
        formationen.add("Militarum Tempestus");
        formationen.add("Militarum Auxilia");
        formationen.add("Aeronautica Imperialis");
        formationen.add("Scholastica Psykana");
        formationen.add("");
        formationen.add("Adeptus Mechanicus");
        formationen.add("Cult Mechanicus");
        formationen.add("Skitarii");
        formationen.add("");
        formationen.add("Questor Imperialis");
        formationen.add("");
        formationen.add("Adeptus Ministorum");
        formationen.add("Adepta Sororitas");
        formationen.add("Officio Assassinorum");
        formationen.add("Adeptus Astra Telepathica");
        formationen.add("Scholastica Psykana");
        formationen.add("Sisters of Silence");

        complete();
    }


    @Override
    public void volkRefresh() {

        if (getFormationType().equals("IMPERIUM")) {
            clearCombo();

            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_AA_komplett,
                    HQeinträge_AM_komplett,
                    HQeinträge_Adeptus_Mechanicus,
                    HQeinträge_Adeptus_Ministorum,
                    HQeinträge_Adeptus_Astra_Telepathica,
                    HQeinträge_Adeptus_Custodes));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_AA_komplett,
                    Standardeinträge_AM_komplett,
                    Standardeinträge_Adeptus_Mechanicus,
                    Standardeinträge_Adeptus_Ministorum,
                    Standardeinträge_Adeptus_Custodes));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_AA_komplett,
                    Eliteeinträge_AM_komplett,
                    Eliteeinträge_Adeptus_Mechanicus,
                    Eliteeinträge_Adeptus_Ministorum,
                    Eliteeinträge_Officio_Assassinorum,
                    Eliteeinträge_Adeptus_Astra_Telepathica,
                    Eliteeinträge_Adeptus_Custodes));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_AA_komplett,
                    Sturmeinträge_AM_komplett,
                    Sturmeinträge_Adeptus_Mechanicus,
                    Sturmeinträge_Adeptus_Ministorum,
                    Sturmeinträge_Adeptus_Custodes));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_AA_komplett,
                    Unterstützungeinträge_AM_komplett,
                    Unterstützungseinträge_Adeptus_Mechanicus,
                    Unterstützungseinträge_Adeptus_Ministorum,
                    Unterstützungseinträge_Adeptus_Custodes));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(Transporteinträge_AA_komplett,
                    Transporteinträge_AM_komplett,
                    Transporteinträge_Adeptus_Ministorum,
                    Transporteinträge_Adeptus_Astra_Telepathica));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_AA_komplett,
                    Fliegereinträge_AM_komplett));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(Befestigungen, Befestigung_Questor_Imperialis));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordofWar_AA_komplett,
                    LordofWar_AM_komplett,
                    LordofWar_Questor_Imperialis));
        } else if (getFormationType().equals("Adeptus Astartes")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_AA_komplett);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_AA_komplett);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_AA_komplett);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_AA_komplett);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungeinträge_AA_komplett);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_AA_komplett);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(Fliegereinträge_AA_komplett);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_AA_komplett);
        } else if (getFormationType().equals("Ultramarines")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_SM, HQeinträge_Ultramarines, HQeinträge_IA_AA));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_SM, Eliteeinträge_Ultramarines, Eliteeinträge_IA_AA));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_SM, Sturmeinträge_IA_AA));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_SM, Unterstützungseinträge_IA_AA));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(Transporteinträge_SM, Transporteinträge_IA_AA));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_SM, Fliegereinträge_IA_AA));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordOfWar_SM, LordofWar_Ultramarines, LordofWar_IA_AA));
        } else if (getFormationType().equals("Imperial Fists")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_SM, HQeinträge_Imperial_Fists, HQeinträge_IA_AA));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_SM, Eliteeinträge_IA_AA));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_SM, Sturmeinträge_IA_AA));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_SM, Unterstützungseinträge_IA_AA));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(Transporteinträge_SM, Transporteinträge_IA_AA));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_SM, Fliegereinträge_IA_AA));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordOfWar_SM, LordofWar_IA_AA));
        } else if (getFormationType().equals("Crimson Fists")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_SM, HQeinträge_Crimson_Fists, HQeinträge_IA_AA));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_SM, Eliteeinträge_IA_AA));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_SM, Sturmeinträge_IA_AA));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_SM, Unterstützungseinträge_IA_AA));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(Transporteinträge_SM, Transporteinträge_IA_AA));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_SM, Fliegereinträge_IA_AA));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordOfWar_SM, LordofWar_IA_AA));
        } else if (getFormationType().equals("Black Templars")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_SM, HQeinträge_Black_Templars, HQeinträge_IA_AA));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_SM, Standardeinträge_Black_Templars));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_SM, Eliteeinträge_Black_Templars, Eliteeinträge_IA_AA));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_SM, Sturmeinträge_IA_AA));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_SM, Unterstützungseinträge_IA_AA));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(Transporteinträge_SM, Transporteinträge_IA_AA));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_SM, Fliegereinträge_IA_AA));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordOfWar_SM, LordofWar_IA_AA));
        } else if (getFormationType().equals("Raven Guard")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_SM, HQeinträge_Raven_Guard, HQeinträge_IA_AA));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_SM, Eliteeinträge_IA_AA));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_SM, Sturmeinträge_IA_AA));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_SM, Unterstützungseinträge_IA_AA));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(Transporteinträge_SM, Transporteinträge_IA_AA));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_SM, Fliegereinträge_IA_AA));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordOfWar_SM, LordofWar_IA_AA));
        } else if (getFormationType().equals("Salamanders")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_SM, HQeinträge_Salamanders, HQeinträge_IA_AA));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_SM, Eliteeinträge_IA_AA));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_SM, Sturmeinträge_IA_AA));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_SM, Unterstützungseinträge_IA_AA));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(Transporteinträge_SM, Transporteinträge_IA_AA));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_SM, Fliegereinträge_IA_AA));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordOfWar_SM, LordofWar_IA_AA));
        } else if (getFormationType().equals("White Scars")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_SM, HQeinträge_White_Scars, HQeinträge_IA_AA));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_SM, Eliteeinträge_IA_AA));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_SM, Sturmeinträge_IA_AA));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_SM, Unterstützungseinträge_IA_AA));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(Transporteinträge_SM, Transporteinträge_IA_AA));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_SM, Fliegereinträge_IA_AA));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordOfWar_SM, LordofWar_IA_AA));
        } else if (getFormationType().equals("Legion of the Damned")) {
            clearCombo();
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Legion_of_the_Damned);
        } else if (getFormationType().equals("Blood Angels")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Blood_Angels,
                    new String[]{"", "Captain", "Captain in Terminator Armour", "Captain in Gravis Armour", "Librarian",
                            "Primaris Librarian", "Librarian in Terminator Armour", "Librarian on Bike", "Techmarine", "Techmarine with Jump Pack", "Techmarine on Bike", "Chaplain",
                            "Chaplain in Terminator Armour", "Chaplain on Bike", "Primaris Chaplain", "Master", "Master in Terminator Armour", "Master in Cataphractii Armour",
                            "Master in Gravis Armour", "Primaris Master", "Lieutenants", "Techmarine", "Primaris Lieutenants", "Rhino Primaris", "Land Raider Excelsior"}, HQeinträge_IA_AA));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Blood_Angels,
                    new String[]{"", "Servitors", "Sanguinary Novitiate",
                            "Company Ancient", "Company Ancient with Jump Pack",
                            "Primaris Ancient", "Company Champion", "Company Champion with Jump Pack", "Company Veterans", "Company Veterans with Jump Packs",
                            "Imperial Space Marine", "Sternguard Veteran Squad", "Vanguard Veteran Squad", "Dreadnought",
                            "Terminator Squad", "Terminator Assault Squad",
                            "", "Primaris Apothecary", "Apothecary", "Company Ancient",
                            "Chapter Ancient", "Imperial Space Marine", "Dreadnought",
                            "Venerable Dreadnought", "Contemptor Dreadnought", "Redemptor Dreadnought", "Aggressor Squad", "Reiver Squad"}, Eliteeinträge_IA_AA));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Blood_Angels,
                    new String[]{"", "Inceptor Squad"}, Sturmeinträge_IA_AA));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungseinträge_Blood_Angels,
                    new String[]{"", "Devastator Squad", "Hellblaster Squad", "Predator", "Hunter", "Stalker", "Whirlwind", "Vindicator", "Land Raider",
                            "Land Raider Crusader", "Land Raider Redeemer"}, Unterstützungseinträge_IA_AA));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(new String[]{"", "Rhino", "Razorback", "Drop Pod", "Land Speeder Storm", "Repulsor"}, Transporteinträge_IA_AA));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_SM, Fliegereinträge_IA_AA));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_IA_AA);
        } else if (getFormationType().equals("Dark Angels")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Dark_Angels,
                    new String[]{"", "Captain", "Captain in Terminator Armour", "Captain in Gravis Armour", "Librarian",
                            "Primaris Librarian", "Librarian in Terminator Armour", "Librarian on Bike", "Techmarine", "Techmarine on Bike", "Chaplain",
                            "Chaplain on Bike", "Primaris Chaplain", "Master", "Master in Terminator Armour", "Master in Cataphractii Armour",
                            "Master in Gravis Armour", "Primaris Master", "Lieutenants", "Techmarine", "Primaris Lieutenants", "Rhino Primaris", "Land Raider Excelsior"}, HQeinträge_IA_AA));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Dark_Angels, new String[]{"", "Primaris Apothecary", "Apothecary", "Company Ancient", "Primaris Ancient",
                    "Company Champion", "Company Veterans", "Chapter Ancient", "Imperial Space Marine", "Dreadnought",
                    "Venerable Dreadnought", "Contemptor Dreadnought", "Redemptor Dreadnought", "Aggressor Squad", "Servitors", "Reiver Squad"}, Eliteeinträge_IA_AA));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Dark_Angels, new String[]{"", "Scout Bike Squad", "Assault Squad", "Inceptor Squad"}, Sturmeinträge_IA_AA));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(new String[]{"", "Devastator Squad", "Hellblaster Squad", "Predator", "Hunter", "Stalker", "Whirlwind", "Vindicator", "Land Raider",
                    "Land Raider Crusader", "Land Raider Redeemer"}, Unterstützungseinträge_IA_AA));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(new String[]{"", "Rhino", "Razorback", "Drop Pod", "Land Speeder Storm", "Repulsor"}, Transporteinträge_IA_AA));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_Dark_Angels, Fliegereinträge_IA_AA));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen_Dark_Angels);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_IA_AA);
        } else if (getFormationType().equals("Space Wolves")) {
        	myChooserGruppen.get(AI).changeComboBoxAuswahlen(new String[]{"", "Warlordtraits"});
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Space_Wolves, new String[]{"", "Primaris Lieutenants[INDEX]", "Rhino Primaris[INDEX]", "Land Raider Excelsior"}, HQeinträge_IA_AA));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_Space_Wolves, new String[]{"", "Intercessors"}));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Space_Wolves, new String[]{"", "Reivers", "Agressors", "Servitors", "Great Company Ancient", "Primaris Ancient", "Great Company Champion", 
        																										   	   "", "Dreadnought", "Venerable Dreadnought", "Contemptor Dreadnought", "Redemptor Dreadnought",
        																										   	   "", "Imperial Space Marine[INDEX]"}, Eliteeinträge_IA_AA));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Space_Wolves, new String[]{"", "Inceptors", "Land Speeders"}, Sturmeinträge_IA_AA));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungseinträge_Space_Wolves, new String[]{"", "Hellblasters", "Hunter", "Stalker",
        																															"", "Predator", "Whirlwind", "Vindicator", 
        																															"", "Land Raider", "Land Raider Crusader", "Land Raider Redeemer"}, Unterstützungseinträge_IA_AA));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(new String[]{"", "Rhino", "Razorback", "Drop Pod", "Land Speeder Storm","Repulsor"}, Transporteinträge_IA_AA));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_Space_Wolves, Fliegereinträge_IA_AA));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_IA_AA);
        } else if (getFormationType().equals("Deathwatch")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Deathwatch);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Deathwatch);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Deathwatch);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_Deathwatch);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungseinträge_Deathwatch);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Deathwatch);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(Fliegereinträge_Deathwatch);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{""});
        } else if (getFormationType().equals("Grey Knights")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Grey_Knights);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Grey_Knights);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Grey_Knights);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_Grey_Knights);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungseinträge_Grey_Knights);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Grey_Knights);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(Fliegereinträge_Grey_Knights);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{""});
        } else if (getFormationType().equals("Astra Militarum")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_AM_komplett);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_AM_komplett);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_AM_komplett);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_AM_komplett);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungeinträge_AM_komplett);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_AM_komplett);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(Fliegereinträge_AM_komplett);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_AM_komplett);
        } else if (getFormationType().equals("Cadian")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_AM, HQeinträge_Cadian));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_AM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_AM, Eliteeinträge_Cadian));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_AM);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungeinträge_AM);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_AM);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(Fliegereinträge_AM);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_AM);
        } else if (getFormationType().equals("Catachan")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_AM, HQeinträge_Catachan));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_AM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_AM, Eliteeinträge_Catachan));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_AM);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungeinträge_AM);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_AM);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(Fliegereinträge_AM);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_AM);
        } else if (getFormationType().equals("Officio Prefectus")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_AM, HQeinträge_Officio_Prefectus));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_AM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_AM, Eliteeinträge_Officio_Prefectus));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_AM);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungeinträge_AM);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_AM);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(Fliegereinträge_AM);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_AM);
        } else if (getFormationType().equals("Militarum Tempestus")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Militarum_Tempestus);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Militarum_Tempestus);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Militarum_Tempestus);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Militarum_Tempestus);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{""});
        } else if (getFormationType().equals("Militarum Auxilia")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_AM);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_AM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_AM, Eliteeinträge_Militarum_Auxilia));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_AM);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungeinträge_AM);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_AM);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(Fliegereinträge_AM);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_AM);
        } else if (getFormationType().equals("Aeronautica Imperialis")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_AM);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_AM, Standardeinträge_Militarum_Tempestus));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_AM, Eliteeinträge_Aeronautica_Imperialis));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_AM);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungeinträge_AM);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(Transporteinträge_AM, Transporteinträge_Militarum_Tempestus));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_AM, Fliegereinträge_Aeronautica_Imperialis));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_AM);
        } else if (getFormationType().equals("Scholastica Psykana")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Scholastica_Psykana);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Scholastica_Psykana);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{""});
        } else if (getFormationType().equals("Adeptus Mechanicus")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Adeptus_Mechanicus);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Adeptus_Mechanicus);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Adeptus_Mechanicus);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_Adeptus_Mechanicus);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungseinträge_Adeptus_Mechanicus);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{""});
        } else if (getFormationType().equals("Cult Mechanicus")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Cult_Mechanicus);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Cult_Mechanicus);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Cult_Mechanicus);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungseinträge_Cult_Mechanicus);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{""});
        } else if (getFormationType().equals("Skitarii")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Skitarii);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Skitarii);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_Skitarii);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungseinträge_Skitarii);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{""});
        } else if (getFormationType().equals("Questor Imperialis")) {
            clearCombo();
            kontingentBox.setSelectedItem("Super-Heavy Detachment");
            myChooserGruppen.get(AI).changeComboBoxAuswahlen(AdditionalInformation_Questor_Imperialis);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_Questor_Imperialis);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(Befestigungen, Befestigung_Questor_Imperialis));
        } else if (getFormationType().equals("Officio Assassinorum")) {
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Officio_Assassinorum);
        } else if (getFormationType().equals("Adeptus Astra Telepathica")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Adeptus_Astra_Telepathica);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Adeptus_Astra_Telepathica);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Adeptus_Astra_Telepathica);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{""});
        } else if (getFormationType().equals("Scholastica Psykana")) {
            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Scholastica_Psykana);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Scholastica_Psykana);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
        } else if (getFormationType().equals("Sisters of Silence")) {
            clearCombo();
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Sisters_of_Silence);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Sisters_of_Silence);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
        } else if (getFormationType().equals("Adeptus Custodes")) {
            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Adeptus_Custodes);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Adeptus_Custodes);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Adeptus_Custodes);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_Adeptus_Custodes);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungseinträge_Adeptus_Custodes);
        } else if (getFormationType().equals("Adepta Sororitas")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Adepta_Sororitas);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Adepta_Sororitas);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Adepta_Sororitas);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_Adepta_Sororitas);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungseinträge_Adepta_Sororitas);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Adepta_Sororitas);
        } else if (getFormationType().equals("Adeptus Ministorum")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Adeptus_Ministorum);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Adeptus_Ministorum);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Adeptus_Ministorum);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_Adeptus_Ministorum);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungseinträge_Adeptus_Ministorum);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Adeptus_Ministorum);
        }

        if (formation != null) {
            formation.refreshControlPanel();
        }

        fillChooserSpace();
    }
}