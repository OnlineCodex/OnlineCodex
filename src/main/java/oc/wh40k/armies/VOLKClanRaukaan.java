package oc.wh40k.armies;


import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKClanRaukaan extends BuildaVater {

    public VOLKClanRaukaan() {
        reflectionKennung = "CR";

        HQeinträge = new String[]{"", "Ordensmeister", "Captain", "Terminator-Captain", "Scriptor", "Ordenspriester", "Meister der Schmiede",
                "", "Ehrengarde", "Kommandotrupp", "Techmarine", "Servitoren",
                "",
                "", "[IA2 2nd Ed] Damocles Command Vehicle",
                "", "[IA12] Lord Asterion Moloc", "[IA12] Minotaurus Chaplain Ivanus Enkomi", "[IA12] Hecaton Aiakos",
                "", "[IA10] Bray'arth Ashmantle", "[IA10] Ahazra Redth", "[IA10] High Chaplain Thulsa Kane", "[IA10] Vaylund Cal",
                "[IA10] Captain Silas Alberec",
                "", "[IA9] Magister Sevrin Loth", "[IA9] Lord High Commander Carab Culln", "[IA9] Chaplain Dreadnought Titus",
                "[IA9] Lieutenant Commander Anton Narvaez", "[IA9] Captain Tarnus Vale", "[IA9] Captain Mordaci Blaylock",
                "[IA9] Captain Pellas Mir'san", "[IA9] Knight-Captain Elam Courbray", "[IA9] Captain Corien Sumatris", "[IA9] Armenneus Valthex",
                "", "[Forgeworld] Chapter Master Lias Issodon",
                "[Forgeworld] Chapter Master Lugft Huron", "[Forgeworld] Damocles Rhino", "[Forgeworld] Tyberos The Red Wake",
                "[Forgeworld] Master Harath Shen", "[Forgeworld] Arch-Centurion Carnac Commodus"};
        Standardeinträge = new String[]{"", "Taktischer Trupp", "Scouttrupp"};
        Eliteeinträge = new String[]{"", "Expugnatorgarde-Trupp", "Protektorgarde-Trupp", "Cybot", "Ironclad-Cybot",
                "Legion of the Damned", "Terminatortrupp", "Terminatorsturmtrupp",
                "Centurion-Sturmtrupp",
                "", "[IA2 2nd Ed] Land Raider Prometheus", "[IA2 2nd Ed] Contemptor Mortis Pattern Dreadnought", "[IA2 2nd Ed] Chaplain Dreadnought",
                "[IA2 2nd Ed] Contemptor Dreadnought", "[IA2 2nd Ed] Siege Dreadnought", "[IA2 2nd Ed] Mark V Mortis Pattern Dreadnought"};
        Sturmeinträge = new String[]{"", "Sturmtrupp", "Landspeeder-Schwadron", "Stormtalon-Angriffsschiff", "Bike-Schwadron",
                "Trikeschwadron", "Scoutbikeschwadron",
                "", "[IA2 2nd Ed] Caestus Assault Ram", "[IA2 2nd Ed] Land Speeder Tempest Squadron", "[IA2 2nd Ed] Javelin Attack Speeder",
                "", "[IA Aeronautica] Hyperios Air Defence Battery"};
        Unterstützungeinträge = new String[]{"", "Cybot", "Ironclad-Cybot", "Devastortrupp", "Centurion-Devastortrupp", "Salvenkanone", "Predator",
                "Whirlwind", "Vindicator", "Hunter", "Stalker", "Land Raider",
                "Land Raider Crusader", "Land Raider Redeemer", "Stormraven-Landungsschiff",
                "", "[IA2 2nd Ed] Land Raider Helios", "[IA2 2nd Ed] Land Raider Proteus", "[IA2 2nd Ed] Land Raider Achilles",
                "[IA2 2nd Ed] Deimos Predator", "[IA2 2nd Ed] Relic Sicaran Battle Tank", "[IA2 2nd Ed] Whirlwind Hyperios",
                "[IA2 2nd Ed] Relic Whirlwind Scorpius", "[IA2 2nd Ed] Spartan Assault Tank", "[IA2 2nd Ed] Storm Eagle",
                "[IA2 2nd Ed] Tarantula-Batterie", "[IA2 2nd Ed] Rapier Carrier Battery", "[IA2 2nd Ed] Storm Eagle Roc Pattern",
                "[IA2 2nd Ed] Deathstorm Drop Pod", "[IA2 2nd Ed] Fire Raptor Gunship",
                "", "[IA12] SentryGunBattery", "[IA12] Predator Infernus",
                "", "[IA Aeronautica] Land Raider Helios (Anti Aircraft)"};
        LordofWar = new String[]{"", "[APO2 Armageddon] Reaver Battle Titan", "[APO2 Armageddon] Warhound-Scouttitan",
                "", "[IA2 2nd Ed] Fellblade", "[IA2 2nd Ed] Typhon", "[IA2 2nd Ed] Cerberus", "[IA2 2nd Ed] Thunderhawk Gunship",
                "[IA2 2nd Ed] Thunderhawk Transporter"
        };
        		/*, "[APO2] Space Marine Company", "[APO2] 1st Company Veterans","[APO2] Imperial Fists Titanhammer Squad",
        							   "[APO2] Librarius", "[APO2] Masters of the Chapter", "[APO2] Predator Assasin Squadron",
        							   "[APO2] Scout Company",
        						   "", "[Alt] Gepanzerte Speerspitze"*/
/*LoW
	Thunderhawk Gunship WH40K: Esc, IA2 2nd ed
	Thunderhawk Transporter IA: Apoc, IA2 2nd ed
 */
        
        
/*
  	SPACE MARINE COMPANY
	1 Captain
	1 Chaplain
	3 Dreadnoughts(any type and in any combination)
	10 Space Marine squads
	1 Command Squad
	FORMATION RESTRICTIONS
	The formation can represent either a Battle Company or a Reserve Company.
	A Battle Company must have six Tactical Squads, two Assault Squads and two
	Devastator Squads. A Reserve Company must have 10 Squads of the same type
	(i.e. all Tactical, all Assault, or all Devastator). All Space Marine squads must
	have 10 models. The Command Squad must include the Company Standard.

   	1ST COMPANY VETERANS
	1 Terminator Captain or Captain Lysander
	1 Chaplain
	1 Command Squad
	3 Venerable Dreadnoughts
	10 units, in any combination, chosen from the following:
	Terminator Squad
	Terminator Assault Squad
	Vanguard Veteran Squad
	Sternguard Veteran Squad
	FORMATION RESTRICTIONS
	The formation must contain 100 models chosen from Terminator,
	Terminator Assault, Sternguard Veteran and/ or Vanguard Veteran
	Squads. The Command Squad must include the Company Standard.....?
	
	IMPERIAL FISTS TITANHAMMER SQUAD
	Captain Lysander
	3 + Terminator Assault Squads
	FORMATION RESTRICTIONS
	All Terminators must have thunder hammers and storm shields.
	
	LIBRARIUS
	5 Space Marine Librarians or
	5 Space Wolves Rune Priests.
	FORMATION RESTRICTIONS
	The following special character Psykers can be selected in place of one of the formation's
	Librarians or Rune Priests: Chief Librarian Tigurius, Mephiston, Ezekiel or Njal Stormcaller.
	However, all units in the formation must belong to the same Chapter of Space Marines.
	
	MASTERS OF THE CHAPTER
	1 Chapter Master
	0-1 Honour Guard Squad
	4-10 Captains
	FORMATION RESTRICTIONS
	All units in this formation must belong to the same Chapter of Space Marines.
	SPECIAL RULES:
	The following special characters may be selected in place of the formation's Chapter Master: 
	Marneus Calgar, Commander Dante, Azrael, High Marshal Helbrecht, Chapter Master Gabriel Seth, Pedro Kantor.
	As they are Space Marine Captains (or of equivalent rank), the following special characters can be selected in place...?
	
	PREDATOR ASSASSIN SQUADRON
	3-5 Predators
	
	SCOUT COMPANY
	1 Captain
	10 Scout Squads
	FORMATION RESTRICTIONS
	All Scout Squads must have 10 models .
	The Captain may not take a Command Squad, or be given Terminator Armour.

	THUNDERHAWK GUNSHIP
*/

        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 1, HQeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 2, Eliteeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 3, Standardeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 4, Sturmeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 5, Unterstützungeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, "FO", cnt, 0, 6, Befestigungen));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, "APO", cnt, 0, 7, LordofWar));
        cnt += 480;

        nameDerArtDerArmee = "Space Marines";
        nameDerArtDerArmeeDekliniert = "Space Marines";
        textAreaUeberschrift = "Space Marines Armee";

        noAllies.clear();

        noAllies.add("CR");
        noAllies.add("SM");
        noAllies.add("TL");
        noAllies.add("SF");

        battleBrothers.add("AB");
        battleBrothers.add("AM");
        battleBrothers.add("AS");
        battleBrothers.add("BA");
        battleBrothers.add("CR");
        battleBrothers.add("DA");
        battleBrothers.add("DK");
        battleBrothers.add("DKAB");
        battleBrothers.add("ED");
        battleBrothers.add("GK");
        battleBrothers.add("IN");
        battleBrothers.add("IR");
        battleBrothers.add("MT");
        battleBrothers.add("SF");
        battleBrothers.add("SM");
        battleBrothers.add("TL");
        battleBrothers.add("SK");
        battleBrothers.add("CU");
        battleBrothers.add("DW");

        alliesOfConvenience.add("EL");
        alliesOfConvenience.add("HQ");

        desperateAllies.add("DE");
        desperateAllies.add("TA");
        desperateAllies.add("FE");
        desperateAllies.add("EC");

        comeTheApocalypse.add("BL");
        comeTheApocalypse.add("CD");
        comeTheApocalypse.add("CM");
        comeTheApocalypse.add("CS");
        comeTheApocalypse.add("DH");
        comeTheApocalypse.add("DM");
        comeTheApocalypse.add("NE");
        comeTheApocalypse.add("OR");
        comeTheApocalypse.add("RH");
        comeTheApocalypse.add("TY");
        comeTheApocalypse.add("SY");

        complete();
    }

    @Override
    protected void finalize() {
        System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
    }

}