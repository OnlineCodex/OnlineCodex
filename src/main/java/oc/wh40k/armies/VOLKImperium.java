package oc.wh40k.armies;


import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class VOLKImperium extends BuildaVater {

    private static final Logger LOGGER = LoggerFactory.getLogger(VOLKImperium.class);

    //AM /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String[] HQeinträge_AM = new String[]{"", "Company Commander", "Tank Commander"};
    public String[] Standardeinträge_AM = new String[]{"", "Infantry Squad", "Conscripts"};
    public String[] Eliteeinträge_AM = new String[]{"", "Master of Ordnance", "Platoon Commander", "Command Squad", "Special Weapons Squad", "Veterans", "Tech-Priest Enginseer", "Servitors"};
    public String[] Sturmeinträge_AM = new String[]{"", "Rough Riders", "Scout Sentinels", "Armoured Sentinels", "Hellhounds"};
    public String[] Unterstützungeinträge_AM = new String[]{"", "Heavy Weapons Squad", "Basilisks", "Hydras", "Wyverns", "Manticore", "Deathstrike",
            "Leman Russ Battle Tanks"};
    public String[] Transporteinträge_AM = new String[]{"", "Chimera", "Taurox"};
    public String[] Fliegereinträge_AM = new String[]{"",};
    public String[] LordofWar_AM = new String[]{"", "Baneblade", "Banehammer", "Banesword", "Doomhammer", "Hellhammer", "Shadowsword", "Stormlord", "Stormsword"};
    //CADIAN
    public String[] HQeinträge_Cadian = new String[]{"", "Lord Castellan Creed", "Knight Commander Pask"};
    public String[] Eliteeinträge_Cadian = new String[]{"", "Colour Sergeant Kell"};
    //CATACHAN
    public String[] HQeinträge_Catachan = new String[]{"", "Colonel 'Iron Hand' Straken", "Sly Marbo"};
    public String[] Eliteeinträge_Catachan = new String[]{"", "Sergeant Harker"};
    //OFFICIO PREFECTUS
    public String[] HQeinträge_Officio_Prefectus = new String[]{"", "Lord Commissar", "Commissar Yarrick"};
    public String[] Eliteeinträge_Officio_Prefectus = new String[]{"", "Commissar"};
    //MILITARUM TEMPESTUS
    public String[] HQeinträge_Militarum_Tempestus = new String[]{"", "Tempestor Prime"};
    public String[] Eliteeinträge_Militarum_Tempestus = new String[]{"", "Militarum Tempestus Command Squad"};
    public String[] Standardeinträge_Militarum_Tempestus = new String[]{"", "Militarum Tempestus Scions"};
    public String[] Transporteinträge_Militarum_Tempestus = new String[]{"", "Taurox Prime"};
    //MILITARUM AUXILIA
    public String[] Eliteeinträge_Militarum_Auxilia = new String[]{"", "Ogryns", "Ogryn Bodyguard", "Bullgryns", "Ratlings", "Nork Deddog"};
    //AERONAUTICA IMPERIALIS
    public String[] Eliteeinträge_Aeronautica_Imperialis = new String[]{"", "Officer of the Fleet"};
    public String[] Fliegereinträge_Aeronautica_Imperialis = new String[]{"", "Valkyries"};
    //SCHOLASTICA PSYKANA
    public String[] HQeinträge_Scholastica_Psykana = new String[]{"", "Primaris Psyker"};
    public String[] Eliteeinträge_Scholastica_Psykana = new String[]{"", "Wyrdvane Psykers", "Astropath"};
    //ADEPTUS MINISTORUM-PART OF ASTRA MILITARUM
    public String[] Eliteeinträge_Astra_Militarum_Adeptus_Ministorum = new String[]{"", "Ministorum Priest", "Crusaders"};


    //AM KOMPLETT
    public String[] HQeinträge_AM_komplett = uniteUnitList(uniteUnitList(uniteUnitList(uniteUnitList(uniteUnitList
                    (HQeinträge_AM, HQeinträge_Cadian), HQeinträge_Catachan),
            HQeinträge_Officio_Prefectus), HQeinträge_Militarum_Tempestus),
            HQeinträge_Scholastica_Psykana);
    public String[] Standardeinträge_AM_komplett = uniteUnitList(Standardeinträge_AM, Standardeinträge_Militarum_Tempestus);
    public String[] Eliteeinträge_AM_komplett = uniteUnitList(uniteUnitList(uniteUnitList(uniteUnitList(uniteUnitList(uniteUnitList(uniteUnitList(uniteUnitList(
            Eliteeinträge_AM, Eliteeinträge_Cadian), Eliteeinträge_Catachan), Eliteeinträge_Officio_Prefectus),
            Eliteeinträge_Militarum_Tempestus), Eliteeinträge_Militarum_Auxilia), Eliteeinträge_Aeronautica_Imperialis),
            Eliteeinträge_Scholastica_Psykana), Eliteeinträge_Astra_Militarum_Adeptus_Ministorum);
    public String[] Sturmeinträge_AM_komplett = Sturmeinträge_AM;
    public String[] Unterstützungeinträge_AM_komplett = Unterstützungeinträge_AM;
    public String[] Transporteinträge_AM_komplett = uniteUnitList(Transporteinträge_AM, Transporteinträge_Militarum_Tempestus);
    public String[] Fliegereinträge_AM_komplett = uniteUnitList(Fliegereinträge_AM, Fliegereinträge_Aeronautica_Imperialis);
    public String[] LordofWar_AM_komplett = LordofWar_AM;

    //ADEPTUS MECHANICUS ///////////////////////////////////////////////////////////////////////////////////////////////////////

    //CULT MECHANICUS
    public String[] HQeinträge_Cult_Mechanicus = new String[]{"", "Belisarius Cawl", "Tech-Priest Dominus", "Tech-Priest Enginseer AME"};
    public String[] Eliteeinträge_Cult_Mechanicus = new String[]{"", "Fulgurite Electro-Priests",
            "Corpuscarii Electro-Priests", "Cybernetica Datasmith"};
    public String[] Standardeinträge_Cult_Mechanicus = new String[]{"", "Kataphron Breachers", "Kataphron Destroyers"};
    public String[] Unterstützungseinträge_Cult_Mechanicus = new String[]{"", "Kastelan Robots"};

    //SKITARII
    public String[] Standardeinträge_Skitarii = new String[]{"", "Skitarii Rangers", "Skitarii Vanguard"};
    public String[] Eliteeinträge_Skitarii = new String[]{"", "Sicarian Infiltrators", "Sicarian Ruststalkers"};
    public String[] Sturmeinträge_Skitarii = new String[]{"", "Ironstrider Ballistarii", "Sydonian Dragoons"};
    public String[] Unterstützungseinträge_Skitarii = new String[]{"", "Onager Dunecrawler"};

    //ADEPTUS MECHANICUS Komplett
    public String[] HQeinträge_Adeptus_Mechanicus = HQeinträge_Cult_Mechanicus;
    public String[] Standardeinträge_Adeptus_Mechanicus = uniteUnitList(Standardeinträge_Cult_Mechanicus, Standardeinträge_Skitarii);
    public String[] Eliteeinträge_Adeptus_Mechanicus = uniteUnitList(uniteUnitList(
            Eliteeinträge_Cult_Mechanicus, Eliteeinträge_Skitarii), new String[]{"", "Servitors"});
    public String[] Sturmeinträge_Adeptus_Mechanicus = Sturmeinträge_Skitarii;
    public String[] Unterstützungseinträge_Adeptus_Mechanicus = uniteUnitList(Unterstützungseinträge_Cult_Mechanicus, Unterstützungseinträge_Skitarii);

    //Questor Imperialis
    public String[] AdditionalInformation_Questor_Imperialis = new String[]{"", "Household Tradition", "Imperial Knight Warlordtraits", "Imperial Knight Heirlooms"};
    public String[] LordofWar_Questor_Imperialis = new String[]{"", "Armiger Helverin", "Armiger Warglaive", "Knight Preceptor", "Knight Paladin", "Knight Errant", "Knight Gallant", "Knight Warden", "Knight Crusader", "Canis Rex", "Knight Castellan", "Knight Valiant"};
    public String[] Befestigung_Questor_Imperialis = new String[]{"", "Sacristan Forgeshrine"};

    //Adepta Sororitas
    public String[] HQeinträge_Adepta_Sororitas = new String[]{"", "Celestine", "Canoness"};
    public String[] Standardeinträge_Adepta_Sororitas = new String[]{"", "Battle Sisters Squad"};
    public String[] Eliteeinträge_Adepta_Sororitas = new String[]{"", "Imagifier", "Hospitaller", "Dialogus", "Celestian Squad",
            "Mistress Of Repentance", "Repentia Squad"};
    public String[] Sturmeinträge_Adepta_Sororitas = new String[]{"", "Seraphim Squad", "Dominion Squad"};
    public String[] Unterstützungseinträge_Adepta_Sororitas = new String[]{"", "Retributor Squad", "Exorcist"};
    public String[] Transporteinträge_Adepta_Sororitas = new String[]{"", "Sororitas Rhino", "Immolator"};

    //Adeptus Ministorum
    public String[] HQeinträge_Adeptus_Ministorum = uniteUnitList(new String[]{"", "Uriah Jacobus"}, HQeinträge_Adepta_Sororitas);
    public String[] Standardeinträge_Adeptus_Ministorum = Standardeinträge_Adepta_Sororitas;
    public String[] Eliteeinträge_Adeptus_Ministorum_Only = new String[]{"Death Cult Assassins", "Arco Flagellants", "Ministorum Priest Adeptus Ministorum"};
    public String[] Eliteeinträge_Adeptus_Ministorum = uniteUnitList(uniteUnitList(Eliteeinträge_Astra_Militarum_Adeptus_Ministorum, Eliteeinträge_Adeptus_Ministorum_Only), Eliteeinträge_Adepta_Sororitas);
    public String[] Sturmeinträge_Adeptus_Ministorum = Sturmeinträge_Adepta_Sororitas;
    public String[] Unterstützungseinträge_Adeptus_Ministorum = uniteUnitList(new String[]{"", "Penitent Engines"},
            Unterstützungseinträge_Adepta_Sororitas);
    public String[] Transporteinträge_Adeptus_Ministorum = Transporteinträge_Adepta_Sororitas;

    //Sisters of Silence
    public String[] Eliteeinträge_Sisters_of_Silence = new String[]{"", "Prosecutors", "Vigilators", "Witchseekers"};
    public String[] Transporteinträge_Sisters_of_Silence = {"", "Null-Maiden Rhino"};

    //Adeptus Astra Telepathica -> Gesamtliste
    public String[] HQeinträge_Adeptus_Astra_Telepathica = HQeinträge_Scholastica_Psykana;
    public String[] Eliteeinträge_Adeptus_Astra_Telepathica = uniteUnitList(Eliteeinträge_Scholastica_Psykana, Eliteeinträge_Sisters_of_Silence);
    public String[] Transporteinträge_Adeptus_Astra_Telepathica = Transporteinträge_Sisters_of_Silence;

    //Officio Assassinorum
    public String[] Eliteeinträge_Officio_Assassinorum = new String[]{"", "Vindicare Assassin", "Callidus Assassin", "Eversor Assassin", "Culexus Assassin"};

    //Inquisition TODO: Einfügen in Imperium
    public String[] Eliteeinträge_Inquisition = new String[]{"", /*TODO:"Daemonhost",*/};

    //<Ordo> TODO: Einfügen in Ordos
    public String[] HQeinträge_Ordo = new String[]{"", /*TODO:"Inquisitor",*/};
    public String[] Eliteeinträge_Ordo = new String[]{"", /*TODO:"Acolytes", /*TODO:"Jokaero Weaponsmith",*/};

    //Ordo Hereticus TODO: Einfügen in Inquisition TODO: Einfügen als eigene Fraktion
    public String[] HQeinträge_Ordo_Hereticus = new String[]{"", /*TODO:"Inquisitor Greyfax", /*TODO:"Inquisitor Karamazov", */};

    //Ordo Malleus TODO: Einfügen in Inquisition TODO: Einfügen als eigene Fraktion
    public String[] HQeinträge_Ordo_Malleus = new String[]{"", /*TODO:"Ordo Malleus Inquisitor", /*TODO:"Inquisitor Coteaz", */};

    //Adeptus Custodes TODO: Einfügen in Imperium
    public String[] HQeinträge_Adeptus_Custodes = new String[]{"", "Captain-General Trajann Valoris", "Shield-Captain", "Shield-Captain in Allarus Terminator Armour", "Shield-Captain on Dawneagle Jetbike"};
    public String[] Standardeinträge_Adeptus_Custodes = new String[]{"", "Custodian Guard"};
    public String[] Eliteeinträge_Adeptus_Custodes = new String[]{"", "Custodian Wardens", "Vexilus Praetor in Allarus Terminator Armour", "Vexilus Praetor", "Allarus Custodians",
            "Venerable Contemptor Dreadnought", "Contemptor-Achillus Dreadnought", "Contemptor-Exemplar Dreadnought"};
    public String[] Sturmeinträge_Adeptus_Custodes = new String[]{"", "Vertus Praetors", "Caladius Grav-tank"};
    public String[] Unterstützungseinträge_Adeptus_Custodes = new String[]{"", "Venerable Land Raider", "Coronus Grav-carrier"};

    //Fortifications TODO: In alle Armeen übernehmen
    public String[] Befestigungen = new String[]{"", /*TODO:"Aegis Defence Line", /*TODO:"Imperial Bastion", /*TODO:"Imperial Defence Line",
	/*TODO:"Imperial Bunker", /*TODO:"Vengeance Weapon Batteries", /*TODO:"Firestorm Redoubt", /*TODO:"Plasma Obliberator", 
	/*TODO:"Macro-Cannon Aquila Strongpoint", /*TODO:"Vortex Missile Aquila Strongpoint", /*TODO:"Void Shield Generator"
	 * , /*TODO:"Skyshield Landing Pad"*/};

    //SM TODO: In Chapter verteilen
    public String[] HQeinträge_SM = new String[]{"", "Captain", "Captain in Terminator Armour", "Captain in Cataphractii Armour",
            "Captain in Gravis Armour", "Captain on Bike", "Librarian", "Librarian in Terminator Armour", "Librarian on Bike",
            "Techmarine", "Techmarine on Bike", "Chaplain", "Chaplain in Terminator Armour", "Master", "Master in Terminator Armour", "Master in Cataphractii Armour", "Master in Gravis Armour",
            "Chaplain on Bike", "Lieutenants", "", "Primaris Chaplain", "Primaris Librarian", "Primaris Lieutenants", "Primaris Master", "Primaris Captain",
            "Rhino Primaris", "Land Raider Excelsior"};
    public String[] Standardeinträge_SM = new String[]{"", "Tactical Squad", "Scout Squad", "Intercessor Squad"};
    public String[] Eliteeinträge_SM = new String[]{"", "Servitors", "Apothecary", "Apothecary on Bike", "Primaris Apothecary",
            "Company Ancient", "Company Ancient on Bike",
            "Primaris Ancient", "Company Champion", "Company Champion on Bike", "Company Veterans", "Company Veterans on Bikes",
            "Imperial Space Marine", "Honour Guard", "Chapter Ancient", "Chapter Champion", "Centurion Assault Squad",
            "Sternguard Veteran Squad", "Vanguard Veteran Squad", "Dreadnought", "Venerable Dreadnought", "Contemptor Dreadnought",
            "Redemptor Dreadnought", "Ironclad Dreadnought", "Terminator Squad", "Terminator Assault Squad", "Cataphractii Terminator Squad",
            "Tartaros Terminator Squad", "Aggressor Squad", "Reiver Squad"};
    public String[] Sturmeinträge_SM = new String[]{"", "Assault Squad", "Inceptor Squad", "Scout Bike Squad", "Bike Squad",
            "Attack Bike Squad", "Land Speeders"};
    public String[] Unterstützungeinträge_SM = new String[]{"", "Devastator Squad", "Centurion Devastator Squad", "Hellblaster Squad",
            "Thunderfire Cannon", "Predator", "Whirlwind", "Vindicator", "Hunter", "Stalker", "Land Raider",
            "Land Raider Crusader", "Land Raider Redeemer"};
    public String[] Transporteinträge_SM = new String[]{"", "Rhino", "Razorback", "Drop Pod", "Land Speeder Storm", "Repulsor",};
    public String[] Fliegereinträge_SM = new String[]{"", "Stormhawk Interceptor", "Stormtalon Gunship", "Stormraven Gunship",};
    public String[] LordOfWar_SM = new String[]{"", "AstraeusSuperHeavyTank"};

    //Ultramarines
    public String[] HQeinträge_Ultramarines = new String[]{"", "Marneus Calgar", "Marneus Calgar in Artificer Armour",
            "Captain Sicarius", "Chief Librarian Tigurius", "Chaplain Cassius", "Sergeant Telion", "Sergeant Chronus"};
    public String[] Eliteeinträge_Ultramarines = new String[]{"", "Tyrannic War Veterans",};
    public String[] LordofWar_Ultramarines = new String[]{"", "Roboute Guilliman", "Terminus Ultra",};

    //Imperial Fists
    public String[] HQeinträge_Imperial_Fists = new String[]{"", "Captain Lysander"};

    //Crimson Fists
    public String[] HQeinträge_Crimson_Fists = new String[]{"", "Pedro Kantor"};

    //Black Templars
    public String[] HQeinträge_Black_Templars = new String[]{"", "High Marshal Helbrecht", "The Emperor's Champion", "Chaplain Grimaldus"};
    public String[] Eliteeinträge_Black_Templars = new String[]{"", "Cenobyte Servitors"};
    public String[] Standardeinträge_Black_Templars = new String[]{"", "Crusader Squad"};

    //Raven Guard
    public String[] HQeinträge_Raven_Guard = new String[]{"", "Kayvaan Shrike"};

    //Salamanders
    public String[] HQeinträge_Salamanders = new String[]{"", "Vulkan He'stan"};

    //White Scars
    public String[] HQeinträge_White_Scars = new String[]{"", "Kor'sarro Khan", "Kor'sarro Khan on Moondrakkan"};

    //Legion of the Damned
    public String[] Eliteeinträge_Legion_of_the_Damned = new String[]{"", "Damned Legionnaires"};

    //Blood Angels
    public String[] HQeinträge_Blood_Angels = new String[]{"", "Commander Dante", "Gabriel Seth", "Captain Tycho", "Tycho the Lost",
            "Librarian Dreadnought", "Chief Librarian Mephiston", "The Sanguinor",
            "Astorath", "Sanguinary Priest", "Sanguinary Priest on Bike",
            "Brother Corbulo", "Lemartes",};
    public String[] Eliteeinträge_Blood_Angels = new String[]{"", "Sanguinary Guard Ancient", "Terminator Ancient", "Death Company",
            "Sanguinary Guard", "Death Company Dreadnought", "Furioso Dreadnought"};
    public String[] Unterstützungseinträge_Blood_Angels = new String[]{"", "Baal Predator"};

    public String[] Sturmeinträge_Blood_Angels = new String[]{"", "Assault Squad BA", "Inceptor Squad", "Scout Bike Squad", "Bike Squad",
            "Attack Bike Squad", "Land Speeders"};

    //Dark Angels
    public String[] HQeinträge_Dark_Angels = new String[]{"", "Azrael", "Belial", "Sammael on Corvex", "Sammael in Sableclaw", "Interrogator-Chaplain", "Ravenwing Talonmaster",
            "Interrogator-Chaplain in Terminator Armour", "Interrogator-Chaplain on Bike", "Asmodai", "Ezekiel"};
    public String[] Eliteeinträge_Dark_Angels = new String[]{"", "Deathwing Apothecary", "Deathwing Ancient", "Deathwing Champion", "Deathwing Terminator Squad", "Deathwing Cataphractii Terminator Squad",
            "Deathwing Tartaros Terminator Squad", "Deathwing Knights", "Ravenwing Apothecary", "Ravenwing Ancient", "Ravenwing Champion",};
    public String[] Sturmeinträge_Dark_Angels = new String[]{"", "Ravenwing Bike Squad", "Ravenwing Attack Bike Squad", "Ravenwing Land Speeders", "Ravenwing Darkshroud",
            "Ravenwing Black Knights", "Ravenwing Land Speeder Vengeance",};
    public String[] Fliegereinträge_Dark_Angels = new String[]{"", "Nephilim Jetfighter", "Ravenwing Dark Talon", "Stormraven Gunship"};
    public String[] Befestigungen_Dark_Angels = new String[]{"", "Fortress of Redemption",};

    //Space Wolves
    public String[] HQeinträge_Space_Wolves = new String[]{"", "Logan Grimnar", "Logan Grimnar on Stormrider", "Wolf Lord",
            "Wolf Lord in Terminator Armour", "Wolf Lord in Gravis Armour", "Wolf Lord on Bike", "Wolf Lord on Thunderwolf",
            "Ragnar Blackmane", "Krom Dragongaze", "Harald Deathwolf", "Canis Wolfborn", "Rune Priest", "Rune Priest in Terminator Armour",
            "Rune Priest on Bike", "Njal Stormcaller", "Njal Stormcaller in Runic Terminator Armour", "Wolf Priest",
            "Wolf Priest in Terminator Armour", "Wolf Priest on Bike", "Ulrik the Slayer", "Wolf Guard Battle Leader",
            "Wolf Guard Battle Leader on Bike", "Wolf Guard Battle Leader in Terminator Armour", "Wolf Guard Battle Leader on Thunderwolf",
            "Bjorn the Fell-Handed", "Iron Priest", "Iron Priest on Bike", "Iron Priest on Thunderwolf", "Arjac Rockfist"};
    public String[] Standardeinträge_Space_Wolves = new String[]{"", "Blood Claws", "Grey Hunters"};
    public String[] Eliteeinträge_Space_Wolves = new String[]{"", "SW Venerable Dreadnought", "Lukas the Trickster", "Wolf Scouts", "Wulfen", "Lone Wolf",
            "Lone Wolf in Terminator Armour", "Murderfang", "Wolf Guard", "Wolf Guard on Bikes", "Wolf Guard in Terminator Armour"};
    public String[] Sturmeinträge_Space_Wolves = new String[]{"", "Cyberwolves", "Swiftclaws", "Swiftclaw Attack Bikes",
            "Thunderwolf Cavalry", "Fenrisian Wolves", "Skyclaws"};
    public String[] Fliegereinträge_Space_Wolves = new String[]{"", "Stormwolf", "Stormfang Gunship"};
    public String[] Unterstützungseinträge_Space_Wolves = new String[]{"", "Long Fangs"};

    //Deathwatch //TODO SM-Einheiten hinzufügen
    public String[] HQeinträge_Deathwatch = new String[]{"", "Watch Master", "Watch Captain Artemis", "Watch Captain", "Watch Captain in Terminator Armour", "Primaris Watch Captain", "Deathwatch Librarian", "Deathwatch Librarian in Terminator Armour", "Deathwatch Primaris Librarian", "Deathwatch Chaplain", "Deathwatch Chaplain in Terminator Armour", "Deathwatch Primaris Chaplain"};
    public String[] Standardeinträge_Deathwatch = new String[]{"", "Deathwatch Veterans", "Deathwatch Intercessors"};
    public String[] Eliteeinträge_Deathwatch = new String[]{"", "Deathwatch Primaris Apothecary", "Venerable Dreadnought", "Dreadnought", "Redemptor Dreadnought", "Deathwatch Terminator Squad", "Deathwatch Reiver Squad", "Aggressor Squad", "Deathwatch Vanguard Veterans"};
    public String[] Sturmeinträge_Deathwatch = new String[]{"", "Deathwatch Bikers", "Inceptor Squad"};
    public String[] Unterstützungseinträge_Deathwatch = new String[]{"", "Hellblaster Squad", "Land Raider", "Land Raider Crusader", "Land Raider Redeemer"};
    public String[] Transporteinträge_Deathwatch = new String[]{"", "Razorback", "Rhino", "Drop Pod", "Repulsor"};
    public String[] Fliegereinträge_Deathwatch = new String[]{"", "Corvus Blackstar"};

    //Grey Knights //TODO SM-Einheiten hinzufügen
    public String[] HQeinträge_Grey_Knights = new String[]{"", "Lord Kaldor Draigo", "Grand Master Voldus", "Grand Master", "Grand Master in Nemesis Dreadknight",
            "Castellan Crowe", "Brother Captain Stern", "Brother-Captain", "Librarian GK", "Techmarine GK", "Chaplain GK", "Brotherhood Champion"};
    public String[] Standardeinträge_Grey_Knights = new String[]{"", "Grey Knight Terminator Squad", "Strike Squad"};
    public String[] Eliteeinträge_Grey_Knights = new String[]{"", "Brotherhood Ancient", "Purifier Squad", "Paladin Squad",
            "Paladin Ancient", "Grey Knight Apothecary", "Dreadnought GK", "Venerable Dreadnought GK", "Servitors"};
    public String[] Sturmeinträge_Grey_Knights = new String[]{"", "Interceptor Squad"};
    public String[] Unterstützungseinträge_Grey_Knights = new String[]{"", "Purgation Squad", "Nemesis Dreadknight", "Land Raider", "Land Raider Crusader", "Land Raider Redeemer"};
    public String[] Transporteinträge_Grey_Knights = new String[]{"", "Razorback", "Rhino"};
    public String[] Fliegereinträge_Grey_Knights = new String[]{"", "Stormhawk Interceptor", "Stormraven Gunship", "Stormtalon Gunship"};

    //Imperial Armour Adeptus Astartes
    public String[] HQeinträge_IA_AA = new String[]{"", "Chaplain Venerable Dreadnought", "Damocles Command Rhino",};
    public String[] Eliteeinträge_IA_AA = new String[]{"", "Deimos Pattern Relic Predator", "Relic Sicaran Battle Tank", "Relic Sicaran Venator Tank Destroyer",
            "Relic Sicaran Punisher Assault Tank", "Relic Sicaran Arcus Strike Tank", "Relic Sicaran Omega Tank Destroyer", "Relic Contemptor Dreadnought",
            "Relic Deredeo Dreadnought", "Relic Javelin Attack Speeder", "Relic Whirlwind Scorpius",};
    public String[] Sturmeinträge_IA_AA = new String[]{"", "Land Speeder Tempest", "Tarantula Sentry Gun", "Tarantula Air Defence Battery", "Deathstorm Drop Pod",};
    public String[] Unterstützungseinträge_IA_AA = new String[]{"", "Deimos Pattern Vindicator Laser Destroyer", "Relic Land Raider Proteus", "Land Raider Helios",
            "Land Raider Prometheus", "Land Raider Achilles", "Mortis Dreadnought", "Siege Dreadnought", "Contemptor Mortis Dreadnought", "Relic Leviathan Dreadnought",
            "Whirlwind Hyperios", "Rapier Carrier",};
    public String[] Transporteinträge_IA_AA = new String[]{"", "Infernum Pattern Razorback", "Lucius Pattern Dreadnought Drop Pod",};
    public String[] Fliegereinträge_IA_AA = new String[]{"", "Xiphon Interceptor", "Storm Eagle Assault Gunship", "Fire Raptor Assault Gunship", "Caestus Assault Ram",};
    public String[] LordofWar_IA_AA = new String[]{"", "Relic Spartan Assault Tank", "Relic Typhon Heavy Siege Tank", "Relic Cerberus Heavy Tank Destroyer",
            "Relic Fellblade Super-heavy Tank", "Relic Falchion Super-heavy Tank Destroyer", "Relic Mastodon Super-heavy Siege Transport",
            "Thunderhawk Assault Gunship", "Thunderhawk Transporter", "Sokar Pattern Stormbird",};
    public String[] Befestigungen_IA_AA = new String[]{"", "Castellum Stronghold",};

    //FW Character Series Blood Ravens
    public String[] HQeinträge_FW_Blood_Ravens = new String[]{"", "Gabriel Angelos"};

    //Imperial Armour Adeptus Astartes Minotaurs
    public String[] HQeinträge_IA_Minotaurs = new String[]{"", "Lord Asterion Moloc", "Chaplain Ivanus Enkomi", "Hecaton Aiakos"};
    public String[] Fliegereinträge_IA_Minotaurs = new String[]{"", "Storm Eagle Assault Gunship - ROC Pattern",};

    //Imperial Armour Adeptus Astartes Red Scorpions
    public String[] HQeinträge_IA_Red_Scorpions = new String[]{"", "Lord High Commander Carab Culln", "Carab Culln the Risen", "Magister Sevrin Loth"};

    //Imperial Armour Adeptus Astartes Astral Claws
    public String[] HQeinträge_IA_Astral_Claws = new String[]{"", "Lugft Huron", "Armenneus Valthex", "Arch-Centurion Carnac Commodus"};

    //Imperial Armour Adeptus Astartes Astral Claws/Tiger Claws
    public String[] HQeinträge_IA_Astral_Claws_Tiger_Claws = new String[]{"", "Captain Corien Sumatris"};

    //Imperial Armour Adeptus Astartes Carcharodons
    public String[] HQeinträge_IA_Carcharodons = new String[]{"", "Tyberos The Red Wake"};

    //Imperial Armour Adeptus Astartes Howling Griffons
    public String[] HQeinträge_IA_HowlingGriffons = new String[]{"", "Chaplain Dreadnought Titus"};

    //Imperial Armour Adeptus Astartes Marines Errant
    public String[] HQeinträge_IA_Marines_Errant = new String[]{"", "Lieutenant Commander Anton Narvaez"};

    //Imperial Armour Adeptus Astartes Fire Angels
    public String[] HQeinträge_IA_Fire_Angels = new String[]{"", "Captain Tarnus Vale"};

    //Imperial Armour Adeptus Astartes Raptors
    public String[] HQeinträge_IA_Raptors = new String[]{"", "Lias Issodon"};

    //Imperial Armour Adeptus Astartes Lamenters
    public String[] HQeinträge_IA_Lamenters = new String[]{"", "Malakim Phoros"};

    //Imperial Armour Adeptus Astartes Novamarines
    public String[] HQeinträge_IA_Novamarines = new String[]{"", "Captain Mordaci Blaylock"};

    //Imperial Armour Adeptus Astartes Salamanders
    public String[] HQeinträge_IA_Salamanders = new String[]{"", "Captain Pellas Mir'san", "Bray'arth Ashmantle", "Harath Shen"};

    //Imperial Armour Adeptus Astartes Mantis Warriors
    public String[] HQeinträge_IA_Mantis_Warriors = new String[]{"", "Ahazra Redth"};

    //Imperial Armour Adeptus Astartes Executioners
    public String[] HQeinträge_IA_Executioners = new String[]{"", "High Chaplain Thulsa Kane"};

    //Imperial Armour Adeptus Astartes Exorcists
    public String[] HQeinträge_IA_Exorcists = new String[]{"", "Captain Silas Alberec"};

    //Imperial Armour Adeptus Astartes Fire Hawks
    public String[] HQeinträge_IA_Fire_Hawks = new String[]{"", "Knight-Captain Elam Courbray"};

    //Imperial Armour Adeptus Astartes Sons of Medusa
    public String[] HQeinträge_IA_Sons_of_Medusa = new String[]{"", "Vaylund Cal"};

    //Imperial Armour Adeptus Astartes Star Phantoms
    public String[] HQeinträge_IA_Star_Phantoms = new String[]{"", "Captain Zhrukhal Androcles"};

    //Imperial Armour Inquisition Ordo Malleus
    public String[] HQeinträge_IA_Ordo_Malleus = new String[]{"", "Inquisitor-Lord Hector Rex"};

    //Imperial Armour Inquisition Ordo Xenos
    public String[] HQeinträge_IA_Ordo_Xenos = new String[]{"", "Inquisitor-Lord Solomon Lok"};

    //Adeptus Astartes
    public String[] HQeinträge_AA_komplett = uniteUnitList(HQeinträge_SM, HQeinträge_Ultramarines, HQeinträge_Imperial_Fists,
            HQeinträge_Crimson_Fists, HQeinträge_Black_Templars, HQeinträge_Raven_Guard, HQeinträge_Salamanders,
            HQeinträge_White_Scars, HQeinträge_Blood_Angels, HQeinträge_Dark_Angels, HQeinträge_Space_Wolves,
            HQeinträge_Deathwatch, HQeinträge_Grey_Knights, HQeinträge_IA_AA);
    public String[] Standardeinträge_AA_komplett = uniteUnitList(Standardeinträge_SM, Standardeinträge_Black_Templars,
            Standardeinträge_Space_Wolves, Standardeinträge_Deathwatch, Standardeinträge_Grey_Knights);
    public String[] Eliteeinträge_AA_komplett = uniteUnitList(Eliteeinträge_SM, Eliteeinträge_Ultramarines, Eliteeinträge_Black_Templars,
            Eliteeinträge_Legion_of_the_Damned, Eliteeinträge_Blood_Angels, Eliteeinträge_Dark_Angels, Eliteeinträge_Space_Wolves,
            Eliteeinträge_Deathwatch, Eliteeinträge_Grey_Knights, Eliteeinträge_IA_AA);
    public String[] Sturmeinträge_AA_komplett = uniteUnitList(Sturmeinträge_SM, Sturmeinträge_Blood_Angels, Sturmeinträge_Dark_Angels, Sturmeinträge_Space_Wolves,
            Sturmeinträge_Deathwatch, Sturmeinträge_Grey_Knights, Sturmeinträge_IA_AA);
    public String[] Unterstützungeinträge_AA_komplett = uniteUnitList(Unterstützungeinträge_SM, Unterstützungseinträge_Blood_Angels,
            Unterstützungseinträge_Space_Wolves, Unterstützungseinträge_Deathwatch, Unterstützungseinträge_Grey_Knights, Unterstützungseinträge_IA_AA);
    public String[] Transporteinträge_AA_komplett = uniteUnitList(Transporteinträge_SM, Transporteinträge_IA_AA);
    public String[] Fliegereinträge_AA_komplett = uniteUnitList(Fliegereinträge_SM, Fliegereinträge_Dark_Angels,
            Fliegereinträge_Space_Wolves, Fliegereinträge_Deathwatch, Fliegereinträge_IA_AA, Fliegereinträge_IA_Minotaurs);
    public String[] LordofWar_AA_komplett = uniteUnitList(LordOfWar_SM, LordofWar_Ultramarines, LordofWar_IA_AA);

    public VOLKImperium() {
        reflectionKennung = "IM";
        InputStream is = this.getClass().getResourceAsStream("/oc/wh40k/indices/sm.csv");
        pointValues = BuildaHQ.loadindexFile(is);

        LOGGER.error("File: " + "/oc/wh40k/indices/ba.csv");
        is = this.getClass().getResourceAsStream("/oc/wh40k/indices/ba.csv");
        appendPointList(BuildaHQ.loadindexFile(is));

        LOGGER.error("File: " + "/oc/wh40k/indices/da.csv");
        is = this.getClass().getResourceAsStream("/oc/wh40k/indices/da.csv");
        appendPointList(BuildaHQ.loadindexFile(is));

        LOGGER.error("File: " + "/oc/wh40k/indices/sw.csv");
        is = this.getClass().getResourceAsStream("/oc/wh40k/indices/sw.csv");
        appendPointList(BuildaHQ.loadindexFile(is));

        LOGGER.error("File: " + "/oc/wh40k/indices/dw.csv");
        is = this.getClass().getResourceAsStream("/oc/wh40k/indices/dw.csv");
        appendPointList(BuildaHQ.loadindexFile(is));

        LOGGER.error("File: " + "/oc/wh40k/indices/gk.csv");
        is = this.getClass().getResourceAsStream("/oc/wh40k/indices/gk.csv");
        appendPointList(BuildaHQ.loadindexFile(is));

        LOGGER.error("File: " + "/oc/wh40k/indices/am.csv");
        is = this.getClass().getResourceAsStream("/oc/wh40k/indices/am.csv");
        appendPointList(BuildaHQ.loadindexFile(is));

        LOGGER.error("File: " + "/oc/wh40k/indices/ame.csv");
        is = this.getClass().getResourceAsStream("/oc/wh40k/indices/ame.csv");
        appendPointList(BuildaHQ.loadindexFile(is));

        LOGGER.error("File: " + "/oc/wh40k/indices/qi.csv");
        is = this.getClass().getResourceAsStream("/oc/wh40k/indices/qi.csv");
        appendPointList(BuildaHQ.loadindexFile(is));

        LOGGER.error("File: " + "/oc/wh40k/indices/ami.csv");
        is = this.getClass().getResourceAsStream("/oc/wh40k/indices/ami.csv");
        appendPointList(BuildaHQ.loadindexFile(is));

        LOGGER.error("File: " + "/oc/wh40k/indices/oa.csv");
        is = this.getClass().getResourceAsStream("/oc/wh40k/indices/oa.csv");
        appendPointList(BuildaHQ.loadindexFile(is));

        LOGGER.error("File: " + "/oc/wh40k/indices/ac.csv");
        is = this.getClass().getResourceAsStream("/oc/wh40k/indices/ac.csv");
        appendPointList(BuildaHQ.loadindexFile(is));

        LOGGER.error("File: " + "/oc/wh40k/indices/iaaa.csv");
        is = this.getClass().getResourceAsStream("/oc/wh40k/indices/iaaa.csv");
        appendPointList(BuildaHQ.loadindexFile(is));

        AdditionalInformation = new String[]{""};
        HQeinträge = new String[]{""};
        Eliteeinträge = new String[]{"", "Custodian Guard Squad"};
        Standardeinträge = new String[]{""};
        Sturmeinträge = new String[]{""};
        Unterstützungeinträge = new String[]{""};
        Fliegereinträge = new String[]{""};
        Befestigungen = new String[]{""};
        Transporteinträge = new String[]{""};
        LordofWar = new String[]{""};

        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, AI, LordofWar));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, HQ, HQeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, TR, Standardeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, EL, Eliteeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, FA, Sturmeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, HS, Unterstützungeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, DT, Transporteinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, FL, Fliegereinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, FORT, Befestigungen));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, LOW, LordofWar));
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
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_AA_komplett,
                    Standardeinträge_AM_komplett,
                    Standardeinträge_Adeptus_Mechanicus,
                    Standardeinträge_Adeptus_Ministorum,
                    Standardeinträge_Adeptus_Custodes));
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_AA_komplett,
                    Eliteeinträge_AM_komplett,
                    Eliteeinträge_Adeptus_Mechanicus,
                    Eliteeinträge_Adeptus_Ministorum,
                    Eliteeinträge_Officio_Assassinorum,
                    Eliteeinträge_Adeptus_Astra_Telepathica,
                    Eliteeinträge_Adeptus_Custodes));
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_AA_komplett,
                    Sturmeinträge_AM_komplett,
                    Sturmeinträge_Adeptus_Mechanicus,
                    Sturmeinträge_Adeptus_Ministorum,
                    Sturmeinträge_Adeptus_Custodes));
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_AA_komplett,
                    Unterstützungeinträge_AM_komplett,
                    Unterstützungseinträge_Adeptus_Mechanicus,
                    Unterstützungseinträge_Adeptus_Ministorum,
                    Unterstützungseinträge_Adeptus_Custodes));
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(uniteUnitList(Transporteinträge_AA_komplett,
                    Transporteinträge_AM_komplett,
                    Transporteinträge_Adeptus_Ministorum,
                    Transporteinträge_Adeptus_Astra_Telepathica));
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_AA_komplett,
                    Fliegereinträge_AM_komplett));
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(uniteUnitList(Befestigungen, Befestigung_Questor_Imperialis));
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(uniteUnitList(LordofWar_AA_komplett,
                    LordofWar_AM_komplett,
                    LordofWar_Questor_Imperialis));
        } else if (getFormationType().equals("Adeptus Astartes")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_AA_komplett);
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_AA_komplett);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_AA_komplett);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_AA_komplett);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungeinträge_AA_komplett);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_AA_komplett);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_AA_komplett);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LordofWar_AA_komplett);
        } else if (getFormationType().equals("Ultramarines")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_SM, HQeinträge_Ultramarines));
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_SM, Eliteeinträge_Ultramarines));
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_SM);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungeinträge_SM);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_SM);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_SM);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(uniteUnitList(LordOfWar_SM, LordofWar_Ultramarines));
        } else if (getFormationType().equals("Imperial Fists")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_SM, HQeinträge_Imperial_Fists));
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_SM);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_SM);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungeinträge_SM);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_SM);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_SM);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LordOfWar_SM);
        } else if (getFormationType().equals("Crimson Fists")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_SM, HQeinträge_Crimson_Fists));
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_SM);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_SM);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungeinträge_SM);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_SM);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_SM);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LordOfWar_SM);
        } else if (getFormationType().equals("Black Templars")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_SM, HQeinträge_Black_Templars));
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_SM, Standardeinträge_Black_Templars));
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_SM, Eliteeinträge_Black_Templars));
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_SM);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungeinträge_SM);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_SM);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_SM);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LordOfWar_SM);
        } else if (getFormationType().equals("Raven Guard")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_SM, HQeinträge_Raven_Guard));
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_SM);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_SM);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungeinträge_SM);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_SM);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_SM);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LordOfWar_SM);
        } else if (getFormationType().equals("Salamanders")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_SM, HQeinträge_Salamanders));
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_SM);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_SM);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungeinträge_SM);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_SM);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_SM);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LordOfWar_SM);
        } else if (getFormationType().equals("White Scars")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_SM, HQeinträge_White_Scars));
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_SM);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_SM);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungeinträge_SM);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_SM);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_SM);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LordOfWar_SM);
        } else if (getFormationType().equals("Legion of the Damned")) {
            clearCombo();
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Legion_of_the_Damned);
        } else if (getFormationType().equals("Blood Angels")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Blood_Angels,
                    new String[]{"", "Captain", "Captain in Terminator Armour", "Captain in Gravis Armour", "Librarian",
                            "Primaris Librarian", "Librarian in Terminator Armour", "Librarian on Bike", "Techmarine", "Techmarine with Jump Pack", "Techmarine on Bike", "Chaplain",
                            "Chaplain in Terminator Armour", "Chaplain on Bike", "Primaris Chaplain", "Master", "Master in Terminator Armour", "Master in Cataphractii Armour",
                            "Master in Gravis Armour", "Primaris Master", "Lieutenants", "Techmarine", "Primaris Lieutenants", "Rhino Primaris", "Land Raider Excelsior"}));
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Blood_Angels,
                    new String[]{"", "Servitors", "Sanguinary Novitiate",
                            "Company Ancient", "Company Ancient with Jump Pack",
                            "Primaris Ancient", "Company Champion", "Company Champion with Jump Pack", "Company Veterans", "Company Veterans with Jump Packs",
                            "Imperial Space Marine", "Sternguard Veteran Squad", "Vanguard Veteran Squad", "Dreadnought",
                            "Terminator Squad", "Terminator Assault Squad",
                            "", "Primaris Apothecary", "Apothecary", "Company Ancient",
                            "Chapter Ancient", "Imperial Space Marine", "Dreadnought",
                            "Venerable Dreadnought", "Contemptor Dreadnought", "Redemptor Dreadnought", "Aggressor Squad", "Reiver Squad"}));
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Blood_Angels,
                    new String[]{"", "Inceptor Squad"}));
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(uniteUnitList(Unterstützungseinträge_Blood_Angels,
                    new String[]{"", "Devastator Squad", "Hellblaster Squad", "Predator", "Hunter", "Stalker", "Whirlwind", "Vindicator", "Land Raider",
                            "Land Raider Crusader", "Land Raider Redeemer"}));
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{"", "Rhino", "Razorback", "Drop Pod", "Land Speeder Storm", "Repulsor"});
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_SM);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
        } else if (getFormationType().equals("Dark Angels")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Dark_Angels,
                    new String[]{"", "Captain", "Captain in Terminator Armour", "Captain in Gravis Armour", "Librarian",
                            "Primaris Librarian", "Librarian in Terminator Armour", "Librarian on Bike", "Techmarine", "Techmarine on Bike", "Chaplain",
                            "Chaplain on Bike", "Primaris Chaplain", "Master", "Master in Terminator Armour", "Master in Cataphractii Armour",
                            "Master in Gravis Armour", "Primaris Master", "Lieutenants", "Techmarine", "Primaris Lieutenants", "Rhino Primaris", "Land Raider Excelsior"}));
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Dark_Angels, new String[]{"", "Primaris Apothecary", "Apothecary", "Company Ancient", "Primaris Ancient",
                    "Company Champion", "Company Veterans", "Chapter Ancient", "Imperial Space Marine", "Dreadnought",
                    "Venerable Dreadnought", "Contemptor Dreadnought", "Redemptor Dreadnought", "Aggressor Squad", "Servitors", "Reiver Squad"}));
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Dark_Angels, new String[]{"", "Scout Bike Squad", "Assault Squad", "Inceptor Squad"}));
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "Devastator Squad", "Hellblaster Squad", "Predator", "Hunter", "Stalker", "Whirlwind", "Vindicator", "Land Raider",
                    "Land Raider Crusader", "Land Raider Redeemer"});
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{"", "Rhino", "Razorback", "Drop Pod", "Land Speeder Storm", "Repulsor"});
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_Dark_Angels);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen_Dark_Angels);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
        } else if (getFormationType().equals("Space Wolves")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Space_Wolves, new String[]{"", "Primaris Lieutenants", "Rhino Primaris", "Land Raider Excelsior"}));
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_Space_Wolves, new String[]{"", "Intercessor Squad"}));
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Space_Wolves, new String[]{"", "Servitors", "Imperial Space Marine", "Primaris Ancient", "Dreadnought", "Venerable Dreadnought"}));
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Space_Wolves, new String[]{"", "Inceptor Squad", "Land Speeders"}));
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(uniteUnitList(Unterstützungseinträge_Space_Wolves, new String[]{"", "Hellblaster Squad", "Predator", "Whirlwind", "Vindicator", "Land Raider", "Land Raider Crusader", "Land Raider Redeemer"}));
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{"", "Rhino", "Razorback", "Drop Pod"});
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_Space_Wolves);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
        } else if (getFormationType().equals("Deathwatch")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Deathwatch);
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_Deathwatch);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Deathwatch);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_Deathwatch);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungseinträge_Deathwatch);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_Deathwatch);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_Deathwatch);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
        } else if (getFormationType().equals("Grey Knights")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Grey_Knights);
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_Grey_Knights);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Grey_Knights);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_Grey_Knights);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungseinträge_Grey_Knights);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_Grey_Knights);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_Grey_Knights);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
        } else if (getFormationType().equals("Astra Militarum")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_AM_komplett);
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_AM_komplett);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_AM_komplett);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_AM_komplett);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungeinträge_AM_komplett);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_AM_komplett);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_AM_komplett);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LordofWar_AM_komplett);
        } else if (getFormationType().equals("Cadian")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_AM, HQeinträge_Cadian));
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_AM);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_AM, Eliteeinträge_Cadian));
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_AM);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungeinträge_AM);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_AM);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_AM);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LordofWar_AM);
        } else if (getFormationType().equals("Catachan")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_AM, HQeinträge_Catachan));
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_AM);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_AM, Eliteeinträge_Catachan));
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_AM);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungeinträge_AM);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_AM);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_AM);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LordofWar_AM);
        } else if (getFormationType().equals("Officio Prefectus")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_AM, HQeinträge_Officio_Prefectus));
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_AM);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_AM, Eliteeinträge_Officio_Prefectus));
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_AM);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungeinträge_AM);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_AM);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_AM);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LordofWar_AM);
        } else if (getFormationType().equals("Militarum Tempestus")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Militarum_Tempestus);
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_Militarum_Tempestus);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Militarum_Tempestus);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_Militarum_Tempestus);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
        } else if (getFormationType().equals("Militarum Auxilia")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_AM);
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_AM);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_AM, Eliteeinträge_Militarum_Auxilia));
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_AM);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungeinträge_AM);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_AM);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(Fliegereinträge_AM);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LordofWar_AM);
        } else if (getFormationType().equals("Aeronautica Imperialis")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_AM);
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_AM, Standardeinträge_Militarum_Tempestus));
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_AM, Eliteeinträge_Aeronautica_Imperialis));
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_AM);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungeinträge_AM);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(uniteUnitList(Transporteinträge_AM, Transporteinträge_Militarum_Tempestus));
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_AM, Fliegereinträge_Aeronautica_Imperialis));
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LordofWar_AM);
        } else if (getFormationType().equals("Scholastica Psykana")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Scholastica_Psykana);
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Scholastica_Psykana);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
        } else if (getFormationType().equals("Adeptus Mechanicus")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Adeptus_Mechanicus);
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_Adeptus_Mechanicus);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Adeptus_Mechanicus);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_Adeptus_Mechanicus);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungseinträge_Adeptus_Mechanicus);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
        } else if (getFormationType().equals("Cult Mechanicus")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Cult_Mechanicus);
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_Cult_Mechanicus);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Cult_Mechanicus);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungseinträge_Cult_Mechanicus);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
        } else if (getFormationType().equals("Skitarii")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_Skitarii);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Skitarii);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_Skitarii);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungseinträge_Skitarii);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
        } else if (getFormationType().equals("Questor Imperialis")) {
            clearCombo();
            kontingentBox.setSelectedItem("Super-Heavy Detachment");
            myChooserGruppen.get(AI).changeComboBoxAuswahlen(AdditionalInformation_Questor_Imperialis);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LordofWar_Questor_Imperialis);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(uniteUnitList(Befestigungen, Befestigung_Questor_Imperialis));
        } else if (getFormationType().equals("Officio Assassinorum")) {
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Officio_Assassinorum);
        } else if (getFormationType().equals("Adeptus Astra Telepathica")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Adeptus_Astra_Telepathica);
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Adeptus_Astra_Telepathica);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_Adeptus_Astra_Telepathica);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
        } else if (getFormationType().equals("Scholastica Psykana")) {
            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Scholastica_Psykana);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Scholastica_Psykana);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
        } else if (getFormationType().equals("Sisters of Silence")) {
            clearCombo();
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Sisters_of_Silence);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_Sisters_of_Silence);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
        } else if (getFormationType().equals("Adeptus Custodes")) {
            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Adeptus_Custodes);
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_Adeptus_Custodes);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Adeptus_Custodes);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_Adeptus_Custodes);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungseinträge_Adeptus_Custodes);
        } else if (getFormationType().equals("Adepta Sororitas")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Adepta_Sororitas);
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_Adepta_Sororitas);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Adepta_Sororitas);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_Adepta_Sororitas);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungseinträge_Adepta_Sororitas);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_Adepta_Sororitas);
        } else if (getFormationType().equals("Adeptus Ministorum")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Adeptus_Ministorum);
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_Adeptus_Ministorum);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Adeptus_Ministorum);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_Adeptus_Ministorum);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungseinträge_Adeptus_Ministorum);
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_Adeptus_Ministorum);
        }

        if (formation != null) {
            formation.refreshControlPanel();
        }

        fillChooserSpace();
    }
}