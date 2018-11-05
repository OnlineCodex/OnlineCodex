package oc.wh40k.armies;


import oc.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VOLKSpaceMarines extends BuildaVater {

    public JCheckBox Raukaan = new JCheckBox("Clan Raukaan");
    public JCheckBox SoT = new JCheckBox("Sentinels of Terra");
    private ActionListener raukaanActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {

            if (Raukaan.isSelected()) {
                SoT.setSelected(false);
                setInformationVectorValue("Clan Raukaan", 1);
                BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Dreadnoughts");
                BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Venerable Dreadnoughts");
                BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Ironclad Dreadnoughts");
            } else {
                setInformationVectorValue("Clan Raukaan", 0);
                BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Dreadnoughts");
                BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Venerable Dreadnoughts");
                BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Ironclad Dreadnoughts");
            }
            RefreshListener.fireRefresh();
        }

    };
    private ActionListener SoTActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {

            if (SoT.isSelected()) {
                Raukaan.setSelected(false);
                setInformationVectorValue("Sentinels of Terra", 1);
                BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Centurion Devastator Squad");
                BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("Centurion Assault Squad");
                BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Tactical Squad (Garadon)");
            } else {
                setInformationVectorValue("Sentinels of Terra", 0);
                BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Centurion Devastator Squad");
                BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Centurion Assault Squad");
                BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Tactical Squad (Garadon)");
            }
            //Sergeant Garadon 75 pts instead of Tct Sergeant. Unit is HQ instead of Troops
            RefreshListener.fireRefresh();
        }

    };

    public VOLKSpaceMarines() {
        reflectionKennung = "SM";

        HQeinträge = new String[]{"", "Orden",
                "", "Captain", "Terminator Captain", "Librarian", "Techmarine", "Chaplain",
                "", "Captain Sicarius", "Chief Librarian Tigurius", "Chaplain Cassius", "Sergeant Telion", "Sergeant Chronus",
                "Kor'sarro Khan", "Vulkan He'stan", "Shadow Captain Shrike", "Captain Lysander", "Pedro Kantor",
                "High Marshal Helbrecht", "The Emperor's Champion", "Chaplain Grimaldus", "",
                "Belisarius Cawl", "Celestine", "Inquisitor Greyfax",
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
        Standardeinträge = new String[]{"", "Tactical Squad", "Scout Squad", "Crusader Squad"};
        Eliteeinträge = new String[]{"", "Command Squad", "Honour Guard", "Centurion Assault Squad", "Vanguard Veteran Squad", "Sternguard Veteran Squad",
                "Dreadnoughts", "Venerable Dreadnoughts", "Ironclad Dreadnoughts", "Legion of the Damned", "Cataphractii Terminator Squad", "Terminator Squad", "Terminator Assault Squad",
                "", "[IA2 2nd Ed] Land Raider Prometheus", "[IA2 2nd Ed] Contemptor Mortis Pattern Dreadnought", "[IA2 2nd Ed] Chaplain Dreadnought",
                "[IA2 2nd Ed] Contemptor Dreadnought", "[IA2 2nd Ed] Siege Dreadnought", "[IA2 2nd Ed] Mark V Mortis Pattern Dreadnought"};
        Sturmeinträge = new String[]{"", "Assault Squad", "Scout Bike Squad"/*, "Bike Squad"*/, "Attack Bike Squad", "Land Speeders", "Land Speeder Storm", "Rhino", "Razorback", "Drop Pod", "Stormtalon Gunship",
                "", "[IA2 2nd Ed] Caestus Assault Ram", "[IA2 2nd Ed] Land Speeder Tempest Squadron", "[IA2 2nd Ed] Javelin Attack Speeder",
                "", "[IA Aeronautica] Hyperios Air Defence Battery",
                "", "[IA Experimental] Xiphon Pattern Interceptor"};
        Unterstützungeinträge = new String[]{"", "Devastator Squad", "Centurion Devastator Squad", "Thunderfire-Cannons", "Predators",
                "Whirlwinds", "Vindicators", "Hunters", "Stalkers", "Stormraven Gunship", "Land Raider",
                "Land Raider Crusader", "Land Raider Redeemer", "Contemptor Dreadnoughts",
                "", "[IA Experimental] Quad Mortar Support Battery",
                "", "[FW online] Deimos Pattern Vindicator Tank Destroyer",
                "", "[IA2 2nd Ed] Land Raider Helios", "[IA2 2nd Ed] Land Raider Proteus", "[IA2 2nd Ed] Land Raider Achilles",
                "[IA2 2nd Ed] Deimos Predator", "[IA2 2nd Ed] Relic Sicaran Battle Tank", "[IA2 2nd Ed] Whirlwind Hyperios",
                "[IA2 2nd Ed] Relic Whirlwind Scorpius", "[IA2 2nd Ed] Spartan Assault Tank", "[IA2 2nd Ed] Storm Eagle",
                "[IA2 2nd Ed] Tarantula-Batterie", "[IA2 2nd Ed] Rapier Carrier Battery", "[IA2 2nd Ed] Storm Eagle Roc Pattern",
                "[IA2 2nd Ed] Deathstorm Drop Pod", "[IA2 2nd Ed] Fire Raptor Gunship",
                "", "[IA12] SentryGunBattery", "[IA12] Predator Infernus",
                "", "[IA Aeronautica] Land Raider Helios (Anti Aircraft)"};
        LordofWar = new String[]{"", "Roboute Guilliman", "Marneus Calgar",
                "", "[APO2 Armageddon] Reaver Battle Titan", "[APO2 Armageddon] Warhound-Scouttitan",
                "", "[IA2 2nd Ed] Fellblade", "[IA2 2nd Ed] Typhon", "[IA2 2nd Ed] Cerberus", "[IA2 2nd Ed] Thunderhawk Gunship",
                "[IA2 2nd Ed] Thunderhawk Transporter"
        };


/* TODO APO Formationen
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


        BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("Bike Squad");

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

//		Gladius Strike Force = Superformation
//		Battle Company
//		2* Demi Battle Company mit 1* Cap und 1* Chap, dann rhino razor drop kostenlos

        //Kontingente
        kontingente.add("");
        kontingente.add("Gladius Strike Force"); //Superformation
        kontingente.add("Scarblade Strike Force (WZ Kauyon)"); //Superformation
        kontingente.add("Talon Strike Force (WZ Kauyon)"); //Superformation
        kontingente.add("Anvil Strike Force (AoD)"); //Superformation
        kontingente.add("Sternhammer Strike Force (AoD)"); //Superformation
        kontingente.add("Fist of Medusa Strike Force (AoD)"); //Superformation
        kontingente.add("Sternhammer Strike Force (AoD)"); //Superformation
        kontingente.add("Flameblade Strike Force (AoD)"); //Superformation
        kontingente.add("Victrix Strike Force"); //Superformation
        kontingente.add("Legion of the Damned");

        //Formationen
        formationen.add("Librarius Conclave");
        formationen.add("Reclusiam Command Squad");
        formationen.add("Battle Demi-Company");
        formationen.add("1st Company Task Force");
        formationen.add("Strike Force Ultra");
        formationen.add("10th Company Task Force");
        formationen.add("Storm Wing");
        formationen.add("Centurion Siegebreaker Cohort");
        formationen.add("Land Raider Spearhead");
        formationen.add("Armoured Task Force");
        formationen.add("Suppression Force");
        formationen.add("Anti-Air Defence Force");
        formationen.add("");
        formationen.add("Skyhammer Annihilation Force (Webstore)");
        formationen.add("");
        formationen.add("Stormlance Battle Demi-Company (WZ Kauyon)"); //TODO MinMax
        formationen.add("Hunting Force (WZ Kauyon)");
        formationen.add("Stormbringer Squadron (WZ Kauyon)");
        formationen.add("Speartip Strike (WZ Kauyon)");
        formationen.add("");
        formationen.add("Pinion Battle Demi-Company (WZ Kauyon)"); //TODO MinMax
        formationen.add("Shadowstrike Killteam (WZ Kauyon)");
        formationen.add("Bladewing Assault Brotherhood (WZ Kauyon)");
        formationen.add("Skyhammer Orbital Strike Force (WZ Kauyon)");
        formationen.add("Ravenhawk Assault Group (WZ Kauyon)");
        formationen.add("Raptor Wing (WZ Kauyon)");
        formationen.add("Shadow Force (WZ Kauyon)");
        formationen.add("");
        formationen.add("The Legion Ascendant (LotD)");
        formationen.add("");
        formationen.add("Firespear Strike Force (Start Collecting)");

        //Min/max-Auswahlen je Spezialkontingent/Formation

        minAuswahlen.put("Reclusiam Command Squad", new int[]{1, 1, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Reclusiam Command Squad", new int[]{1, 1, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("Librarius Conclave", new int[]{3, 0, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Librarius Conclave", new int[]{5, 0, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("Gladius Strike Force", new int[]{0, 0, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Gladius Strike Force", new int[]{0, 0, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("Victrix Strike Force", new int[]{0, 0, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Victrix Strike Force", new int[]{0, 0, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("Battle Demi-Company", new int[]{1, 0, 3, 1, 1, 0, 0, 0});
        maxAuswahlen.put("Battle Demi-Company", new int[]{1, 2, 3, 1, 1, 0, 0, 0});

        minAuswahlen.put("1st Company Task Force", new int[]{0, 3, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("1st Company Task Force", new int[]{0, 5, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("Strike Force Ultra", new int[]{1, 5, 0, 0, 2, 0, 0, 0});
        maxAuswahlen.put("Strike Force Ultra", new int[]{1, 5, 0, 0, 2, 0, 0, 0});

        minAuswahlen.put("Storm Wing", new int[]{0, 0, 0, 2, 1, 0, 0, 0});
        maxAuswahlen.put("Storm Wing", new int[]{0, 0, 0, 2, 1, 0, 0, 0});

        minAuswahlen.put("Suppression Force", new int[]{0, 0, 0, 1, 1, 0, 0, 0});
        maxAuswahlen.put("Suppression Force", new int[]{0, 0, 0, 1, 1, 0, 0, 0});

        minAuswahlen.put("Anti-Air Defence Force", new int[]{0, 0, 0, 0, 2, 0, 0, 0});
        maxAuswahlen.put("Anti-Air Defence Force", new int[]{0, 0, 0, 0, 2, 0, 0, 0});

        minAuswahlen.put("Land Raider Spearhead", new int[]{0, 0, 0, 0, 3, 0, 0, 0});
        maxAuswahlen.put("Land Raider Spearhead", new int[]{0, 0, 0, 0, 3, 0, 0, 0});

        minAuswahlen.put("Centurion Siegebreaker Cohort", new int[]{0, 3, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Centurion Siegebreaker Cohort", new int[]{0, 5, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("10th Company Task Force", new int[]{0, 0, 3, 0, 0, 0, 0, 0});
        maxAuswahlen.put("10th Company Task Force", new int[]{1, 0, 5, 0, 0, 0, 0, 0});

        minAuswahlen.put("Armoured Task Force", new int[]{1, 0, 0, 0, 3, 0, 0, 0});
        maxAuswahlen.put("Armoured Task Force", new int[]{2, 0, 0, 0, 8, 0, 0, 0});

        minAuswahlen.put("Skyhammer Annihilation Force (Webstore)", new int[]{0, 0, 0, 2, 2, 0, 0, 0});
        maxAuswahlen.put("Skyhammer Annihilation Force (Webstore)", new int[]{0, 0, 0, 2, 2, 0, 0, 0});

        minAuswahlen.put("Scarblade Strike Force (WZ Kauyon)", new int[]{0, 0, 0, 0, 0, 0, 0, 0}); //Superformation
        maxAuswahlen.put("Scarblade Strike Force (WZ Kauyon)", new int[]{0, 0, 0, 0, 0, 0, 0, 0}); //Superformation

        minAuswahlen.put("Stormlance Battle Demi-Company (WZ Kauyon)", new int[]{1, 0, 3, 1, 1, 0, 0, 0});
        maxAuswahlen.put("Stormlance Battle Demi-Company (WZ Kauyon)", new int[]{2, 1, 3, 1, 1, 0, 0, 0});

        minAuswahlen.put("Hunting Force (WZ Kauyon)", new int[]{1, 0, 0, 4, 0, 0, 0, 0});
        maxAuswahlen.put("Hunting Force (WZ Kauyon)", new int[]{2, 1, 0, 11, 0, 0, 0, 0});

        minAuswahlen.put("Stormbringer Squadron (WZ Kauyon)", new int[]{0, 0, 1, 1, 0, 0, 0, 0});
        maxAuswahlen.put("Stormbringer Squadron (WZ Kauyon)", new int[]{0, 0, 3, 3, 0, 0, 0, 0});

        minAuswahlen.put("Speartip Strike (WZ Kauyon)", new int[]{0, 0, 0, 3, 0, 0, 0, 0});
        maxAuswahlen.put("Speartip Strike (WZ Kauyon)", new int[]{0, 0, 0, 5, 0, 0, 0, 0});

        minAuswahlen.put("Talon Strike Force (WZ Kauyon)", new int[]{0, 0, 0, 0, 0, 0, 0, 0}); //Superformation
        maxAuswahlen.put("Talon Strike Force (WZ Kauyon)", new int[]{0, 0, 0, 0, 0, 0, 0, 0}); //Superformation

        minAuswahlen.put("Anvil Strike Force (AoD)", new int[]{0, 0, 0, 0, 0, 0, 0, 0}); //Superformation
        maxAuswahlen.put("Anvil Strike Force (AoD)", new int[]{0, 0, 0, 0, 0, 0, 0, 0}); //Superformation

        minAuswahlen.put("Sternhammer Strike Force (AoD)", new int[]{0, 0, 0, 0, 0, 0, 0, 0}); //Superformation
        maxAuswahlen.put("Sternhammer Strike Force (AoD)", new int[]{0, 0, 0, 0, 0, 0, 0, 0}); //Superformation

        minAuswahlen.put("Fist of Medusa Strike Force (AoD)", new int[]{0, 0, 0, 0, 0, 0, 0, 0}); //Superformation
        maxAuswahlen.put("Fist of Medusa Strike Force (AoD)", new int[]{0, 0, 0, 0, 0, 0, 0, 0}); //Superformation

        minAuswahlen.put("Flameblade Strike Force (AoD)", new int[]{0, 0, 0, 0, 0, 0, 0, 0}); //Superformation
        maxAuswahlen.put("Flameblade Strike Force (AoD)", new int[]{0, 0, 0, 0, 0, 0, 0, 0}); //Superformation

        minAuswahlen.put("Pinion Battle Demi-Company (WZ Kauyon)", new int[]{1, 0, 3, 1, 1, 0, 0, 0});
        maxAuswahlen.put("Pinion Battle Demi-Company (WZ Kauyon)", new int[]{1, 1, 8, 6, 1, 0, 0, 0});

        minAuswahlen.put("Shadowstrike Killteam (WZ Kauyon)", new int[]{0, 1, 2, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Shadowstrike Killteam (WZ Kauyon)", new int[]{0, 3, 4, 0, 0, 0, 0, 0});

        minAuswahlen.put("Bladewing Assault Brotherhood (WZ Kauyon)", new int[]{1, 1, 0, 2, 0, 0, 0, 0});
        maxAuswahlen.put("Bladewing Assault Brotherhood (WZ Kauyon)", new int[]{1, 3, 0, 4, 0, 0, 0, 0});

        minAuswahlen.put("Skyhammer Orbital Strike Force (WZ Kauyon)", new int[]{0, 0, 3, 1, 0, 0, 0, 0});
        maxAuswahlen.put("Skyhammer Orbital Strike Force (WZ Kauyon)", new int[]{0, 0, 3, 3, 0, 0, 0, 0});

        minAuswahlen.put("Ravenhawk Assault Group (WZ Kauyon)", new int[]{0, 2, 0, 0, 1, 0, 0, 0});
        maxAuswahlen.put("Ravenhawk Assault Group (WZ Kauyon)", new int[]{0, 2, 0, 0, 1, 0, 0, 0});

        minAuswahlen.put("Raptor Wing (WZ Kauyon)", new int[]{0, 0, 0, 3, 0, 0, 0, 0});
        maxAuswahlen.put("Raptor Wing (WZ Kauyon)", new int[]{0, 0, 0, 3, 0, 0, 0, 0});

        minAuswahlen.put("Raptor Wing (WZ Kauyon)", new int[]{0, 0, 0, 3, 0, 0, 0, 0});
        maxAuswahlen.put("Raptor Wing (WZ Kauyon)", new int[]{0, 0, 0, 3, 0, 0, 0, 0});

        minAuswahlen.put("Shadow Force (WZ Kauyon)", new int[]{1, 2, 0, 1, 0, 0, 0, 0});
        maxAuswahlen.put("Shadow Force (WZ Kauyon)", new int[]{1, 2, 0, 1, 0, 0, 0, 0});

        minAuswahlen.put("Legion of the Damned", new int[]{0, 1, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Legion of the Damned", new int[]{0, 4, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("The Legion Ascendant (LotD)", new int[]{0, 2, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("The Legion Ascendant (LotD)", new int[]{0, Integer.MAX_VALUE, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("Firespear Strike Force (Start Collecting)", new int[]{1, 1, 1, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Firespear Strike Force (Start Collecting)", new int[]{1, 1, 1, 0, 0, 0, 0, 0});

        complete();

        panel.add(Raukaan);
        Raukaan.addActionListener(raukaanActionListener);
        Raukaan.setBounds(710, 5, 110, 20);
        Raukaan.setBackground(Color.WHITE);

        panel.add(SoT);
        SoT.addActionListener(SoTActionListener);
        SoT.setBounds(825, 5, 150, 20);
        SoT.setBackground(Color.WHITE);
    }

    public void changeFormations() {
        if (getCountFromInformationVector("Gladius") > 0 || getCountFromInformationVector("Talon") > 0 || getCountFromInformationVector("Scarblade") > 0) {
//			formationBox.addItem("Reclusiam Command Squad");
            formationBox.addItem("Strike Force Command");

            minAuswahlen.put("Strike Force Command", new int[]{0, 0, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Strike Force Command", new int[]{2, 2, 0, 0, 0, 0, 1, 0});

//			minAuswahlen.put("Reclusiam Command Squad", new int[] {1,1,0,0,0,0,0,0});
//			maxAuswahlen.put("Reclusiam Command Squad", new int[] {1,1,0,0,0,0,0,0});
        }

//		if(getCountFromInformationVector("Gladius")>0 || getCountFromInformationVector("Scarblade")>0){
//			formationen.add("Librarius Conclave");
//			
//			minAuswahlen.put("Librarius Conclave", new int[] {3,0,0,0,0,0,0,0});
//			maxAuswahlen.put("Librarius Conclave", new int[] {5,0,0,0,0,0,0,0});
//		}

        if (getCountFromInformationVector("Gladius") > 0) {
            formationBox.addItem("Battle Company");

            minAuswahlen.put("Battle Company", new int[]{2, 0, 6, 2, 2, 0, 0, 0});
            maxAuswahlen.put("Battle Company", new int[]{2, 4, 6, 2, 2, 0, 0, 0});
        }

        if (getCountFromInformationVector("Anvil") > 0) {
            formationen.add("Masters of the Armoury");
            formationen.add("Keepers of the Forge");
            formationen.add("Mechanised Infantry");
            formationen.add("Techmarine");
            formationen.add("Recon Outriders");
            formationen.add("Honoured Ancients");

            minAuswahlen.put("Masters of the Armoury", new int[]{0, 0, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Masters of the Armoury", new int[]{1, 0, 0, 0, 1, 0, 0, 0});

            minAuswahlen.put("Keepers of the Forge", new int[]{1, 0, 0, 1, 0, 0, 0, 0});
            maxAuswahlen.put("Keepers of the Forge", new int[]{1, 0, 0, 1, 0, 0, 0, 0});

            minAuswahlen.put("Mechanised Infantry", new int[]{0, 0, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Mechanised Infantry", new int[]{0, 1, 1, 1, 1, 0, 0, 0});

            minAuswahlen.put("Techmarine", new int[]{0, 0, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Techmarine", new int[]{1, 0, 0, 0, 1, 0, 0, 0});

            minAuswahlen.put("Recon Outriders", new int[]{0, 0, 0, 1, 0, 0, 0, 0});
            maxAuswahlen.put("Recon Outriders", new int[]{0, 0, 0, 1, 0, 0, 0, 0});

            minAuswahlen.put("Honoured Ancients", new int[]{0, 0, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Honoured Ancients", new int[]{0, 1, 0, 0, 1, 0, 0, 0});
        }

        if (getCountFromInformationVector("Sternhammer") > 0) {
            formationen.add("Devastators");
            formationen.add("Centurions");
            formationen.add("Line Breakers");
            formationen.add("Ordnance");
            formationen.add("Siege Ancients");

            minAuswahlen.put("Devastators", new int[]{0, 0, 0, 0, 1, 0, 0, 0});
            maxAuswahlen.put("Devastators", new int[]{0, 0, 0, 0, 1, 0, 0, 0});

            minAuswahlen.put("Centurions", new int[]{0, 0, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Centurions", new int[]{0, 1, 0, 0, 1, 0, 0, 0});

            minAuswahlen.put("Line Breakers", new int[]{0, 0, 0, 0, 1, 0, 0, 0});
            maxAuswahlen.put("Line Breakers", new int[]{0, 0, 0, 0, 1, 0, 0, 0});

            minAuswahlen.put("Ordnance", new int[]{0, 0, 0, 0, 1, 0, 0, 0});
            maxAuswahlen.put("Ordnance", new int[]{0, 0, 0, 0, 1, 0, 0, 0});

            minAuswahlen.put("Siege Ancients", new int[]{0, 0, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Siege Ancients", new int[]{0, 1, 0, 0, 1, 0, 0, 0});
        }

        if (getCountFromInformationVector("Medusa") > 0) {
            formationen.add("Iron Guardians");

            minAuswahlen.put("Iron Guardians", new int[]{0, 0, 1, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Iron Guardians", new int[]{0, 1, 1, 0, 1, 0, 0, 0});
        }

        if (getCountFromInformationVector("Flame") > 0) {
            formationen.add("Flamebringers");

            minAuswahlen.put("Flamebringers", new int[]{0, 0, 0, 0, 1, 0, 0, 0});
            maxAuswahlen.put("Flamebringers", new int[]{0, 0, 0, 0, 1, 0, 0, 0});
        }

        if (getCountFromInformationVector("Victrix") > 0) {
            formationen.add("Victrix Guard");

            minAuswahlen.put("Victrix Guard", new int[]{1, 5, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Victrix Guard", new int[]{1, 5, 0, 0, 0, 0, 0, 0});
        }
    }

    @Override
    public void volkRefresh() {

        setInformationVectorValue("Battle Demi-Company", 0);
        setInformationVectorValue("1st Company Task Force", 0);
        setInformationVectorValue("Strike Force Ultra", 0);
        setInformationVectorValue("Reclusiam Command Squad", 0);
        setInformationVectorValue("Librarius Conclave", 0);
        setInformationVectorValue("Centurion Siegebreaker Cohort", 0);
        setInformationVectorValue("10th Company Task Force", 0);
        setInformationVectorValue("Strike Force Command", 0);
        setInformationVectorValue("Armoured Task Force", 0);
        setInformationVectorValue("Skyhammer Annihilation Force (Webstore)", 0);
        setInformationVectorValue("Battle Company", 0);
        setInformationVectorValue("Sons of the Great Khan", 0);
        setInformationVectorValue("Hunting Force", 0);
        setInformationVectorValue("Sons of Corax", 0);
        setInformationVectorValue("Shadowstrike Killteam", 0);
        setInformationVectorValue("Bladewing Assault Brotherhood", 0);
        setInformationVectorValue("Stormbringer Squadron", 0);
        setInformationVectorValue("Skyhammer Orbital Strike Force", 0);
        setInformationVectorValue("Legion of the Damned", 0);
        setInformationVectorValue("Stormlance Battle Demi-Company (WZ Kauyon)", 0);
        setInformationVectorValue("Anti-Air Defence Force", 0);
        setInformationVectorValue("Suppression Force", 0);
        setInformationVectorValue("The Legion Ascendant (LotD)", 0);
        setInformationVectorValue("Gladius", 0);
        setInformationVectorValue("Talon", 0);
        setInformationVectorValue("Scarblade", 0);
        setInformationVectorValue("Anvil", 0);
        setInformationVectorValue("Sternhammer", 0);
        setInformationVectorValue("Medusa", 0);
        setInformationVectorValue("Victrix", 0);

        if (getKontingentTyp().equals("Firespear Strike Force (Start Collecting)")) {
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bike Squad");
            setInformationVectorValue("Firespear Strike Force (Start Collecting)", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Captain"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Venerable Dreadnoughts"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Tactical Squad"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Captain");
                addUnit(0, "");
                addUnit(1, "Venerable Dreadnoughts");
                addUnit(1, "");
                addUnit(2, "Tactical Squad");
                addUnit(2, "");
            }

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("The Legion Ascendant (LotD)")) {
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bike Squad");
            setInformationVectorValue("Legion of the Damned", 1);
            setInformationVectorValue("The Legion Ascendant (LotD)", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Legion of the Damned"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(1, "Legion of the Damned");
                addUnit(1, "Legion of the Damned");
            }

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Legion of the Damned")) {
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bike Squad");
            setInformationVectorValue("Legion of the Damned", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Legion of the Damned"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(1, "Legion of the Damned");
            }

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Gladius Strike Force")) { //Superformation))
            setInformationVectorValue("Gladius", 1);
            superformation = new Superformation(getPanel(), 0);
            superformation.reflectionKennungLokal = reflectionKennungLokal;
            superformation.volkFile = getClass().getName();
            superformation.tA = buildatextArea;
            superformation.buildaVater = this;

            superformation.minCommand = 0;
            superformation.maxCommand = 3;
            superformation.minCore = 1;
            superformation.maxCore = 2;
            superformation.minAuxiliary = 1;
            superformation.maxAuxiliary = Integer.MAX_VALUE;

            superformation.namenCommand.add("");
            superformation.namenCommand.add("Strike Force Command");
            superformation.namenCommand.add("Reclusiam Command Squad");
            superformation.namenCommand.add("Librarius Conclave");

            superformation.namenCore.add("");
            superformation.namenCore.add("Battle Demi-Company");
            superformation.namenCore.add("Battle Company");

            superformation.namenAuxiliary.add("");
            superformation.namenAuxiliary.add("Armoured Task Force");
            superformation.namenAuxiliary.add("1st Company Task Force");
            superformation.namenAuxiliary.add("Anit-Air Defence Force");
            superformation.namenAuxiliary.add("10th Company Task Force");
            superformation.namenAuxiliary.add("Storm Wing");
            superformation.namenAuxiliary.add("Suppression Force");
            superformation.namenAuxiliary.add("Centurion Siegebreaker Cohort");
            superformation.namenAuxiliary.add("Land Raider Spearhead");


            for (int i = 0; i < myChooserGruppen.size(); i++) {
                myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
            }

            superformation.refreshControlPanel();

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);

            RefreshListener.fireRefresh();
        } else if (getKontingentTyp().equals("Anvil Strike Force (AoD)")) { //Superformation))
            setInformationVectorValue("Anvil", 1);
            superformation = new Superformation(getPanel(), 0);
            superformation.reflectionKennungLokal = reflectionKennungLokal;
            superformation.volkFile = getClass().getName();
            superformation.tA = buildatextArea;
            superformation.buildaVater = this;

            superformation.minCommand = 0;
            superformation.maxCommand = 2;
            superformation.minCore = 1;
            superformation.maxCore = 2;
            superformation.minAuxiliary = 1;
            superformation.maxAuxiliary = Integer.MAX_VALUE;

            superformation.namenCommand.add("");
            superformation.namenCommand.add("Masters of the Armoury");
            superformation.namenCommand.add("Keepers of the Forge");

            superformation.namenCore.add("");
            superformation.namenCore.add("Armoured Task Force");
            superformation.namenCore.add("Land Raider Spearhead");

            superformation.namenAuxiliary.add("");
            superformation.namenAuxiliary.add("Suppression Force");
            superformation.namenAuxiliary.add("Anit-Air Defence Force");
            superformation.namenAuxiliary.add("Mechanised Infantry");
            superformation.namenAuxiliary.add("Raptor Wing (WZ Kauyon)");
            superformation.namenAuxiliary.add("Storm Wing");
            superformation.namenAuxiliary.add("Techmarine");
            superformation.namenAuxiliary.add("Recon Outriders");
            superformation.namenAuxiliary.add("Honoured Ancients");

            for (int i = 0; i < myChooserGruppen.size(); i++) {
                myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
            }

            superformation.refreshControlPanel();

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);

            RefreshListener.fireRefresh();
        } else if (getKontingentTyp().equals("Victrix Strike Force")) { //Superformation))
            setInformationVectorValue("Victrix", 1);
            superformation = new Superformation(getPanel(), 0);
            superformation.reflectionKennungLokal = reflectionKennungLokal;
            superformation.volkFile = getClass().getName();
            superformation.tA = buildatextArea;
            superformation.buildaVater = this;

            superformation.minCommand = 0;
            superformation.maxCommand = 2;
            superformation.minCore = 1;
            superformation.maxCore = 2;
            superformation.minAuxiliary = 1;
            superformation.maxAuxiliary = Integer.MAX_VALUE;

            superformation.namenCommand.add("");
            superformation.namenCommand.add("Strike Force Command");
            superformation.namenCommand.add("Reclusiam Command Squad");
            superformation.namenCommand.add("Librarius Conclave");

            superformation.namenCore.add("");
            superformation.namenCore.add("Battle Demi-Company");
            superformation.namenCore.add("Strike Force Ultra");

            superformation.namenAuxiliary.add("");
            superformation.namenAuxiliary.add("Victrix Guard");
            superformation.namenAuxiliary.add("Armoured Task Force");
            superformation.namenAuxiliary.add("1st Company Task Force");
            superformation.namenAuxiliary.add("Anti-Air Defence Force");
            superformation.namenAuxiliary.add("10th Company Task Force");
            superformation.namenAuxiliary.add("Storm Wing");
            superformation.namenAuxiliary.add("Suppression Force");
            superformation.namenAuxiliary.add("Land Raider Spearhead");
            superformation.namenAuxiliary.add("Centurion Siegebreaker Cohort");

            for (int i = 0; i < myChooserGruppen.size(); i++) {
                myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
            }

            superformation.refreshControlPanel();

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);

            RefreshListener.fireRefresh();
        } else if (getKontingentTyp().equals("Sternhammer Strike Force (AoD)")) { //Superformation))
            setInformationVectorValue("Sternhammer", 1);
            superformation = new Superformation(getPanel(), 0);
            superformation.reflectionKennungLokal = reflectionKennungLokal;
            superformation.volkFile = getClass().getName();
            superformation.tA = buildatextArea;
            superformation.buildaVater = this;

            superformation.minCommand = 0;
            superformation.maxCommand = 2;
            superformation.minCore = 1;
            superformation.maxCore = 2;
            superformation.minAuxiliary = 1;
            superformation.maxAuxiliary = Integer.MAX_VALUE;

            superformation.namenCommand.add("");
            superformation.namenCommand.add("Strike Force Command");
            superformation.namenCommand.add("Reclusiam Command Squad");
            superformation.namenCommand.add("Librarius Conclave");

            superformation.namenCore.add("");
            superformation.namenCore.add("Battle Demi-Company");
            superformation.namenCore.add("Centurion Siegebreaker Cohort");

            superformation.namenAuxiliary.add("");
            superformation.namenAuxiliary.add("Armoured Task Force");
            superformation.namenAuxiliary.add("1st Company Task Force");
            superformation.namenAuxiliary.add("10th Company Task Force");
            superformation.namenAuxiliary.add("Storm Wing");
            superformation.namenAuxiliary.add("Anti-Air Defence Force");
            superformation.namenAuxiliary.add("Suppression Force");
            superformation.namenAuxiliary.add("Land Raider Spearhead");
            superformation.namenAuxiliary.add("Strike Force Ultra");
            superformation.namenAuxiliary.add("Skyhammer Orbital Strike Force (WZ Kauyon)");
            superformation.namenAuxiliary.add("Skyhammer Annihilation Force (Webstore)");
            superformation.namenAuxiliary.add("Raptor Wing (WZ Kauyon)");
            superformation.namenAuxiliary.add("Devastators");
            superformation.namenAuxiliary.add("Centurions");
            superformation.namenAuxiliary.add("Line Breakers");
            superformation.namenAuxiliary.add("Ordnance");
            superformation.namenAuxiliary.add("Siege Ancients");

            for (int i = 0; i < myChooserGruppen.size(); i++) {
                myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
            }

            superformation.refreshControlPanel();

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);

            RefreshListener.fireRefresh();
        } else if (getKontingentTyp().equals("Fist of Medusa Strike Force (AoD)")) { //Superformation))
            setInformationVectorValue("Medusa", 1);
            superformation = new Superformation(getPanel(), 0);
            superformation.reflectionKennungLokal = reflectionKennungLokal;
            superformation.volkFile = getClass().getName();
            superformation.tA = buildatextArea;
            superformation.buildaVater = this;

            superformation.minCommand = 0;
            superformation.maxCommand = 2;
            superformation.minCore = 1;
            superformation.maxCore = 2;
            superformation.minAuxiliary = 1;
            superformation.maxAuxiliary = Integer.MAX_VALUE;

            superformation.namenCommand.add("");
            superformation.namenCommand.add("Strike Force Command");
            superformation.namenCommand.add("Reclusiam Command Squad");
            superformation.namenCommand.add("Librarius Conclave");

            superformation.namenCore.add("");
            superformation.namenCore.add("Stormlance Battle Demi-Company (WZ Kauyon)");
            superformation.namenCore.add("Armoured Task Force");
            superformation.namenCore.add("Battle Demi-Company");

            superformation.namenAuxiliary.add("");
            superformation.namenAuxiliary.add("1st Company Task Force");
            superformation.namenAuxiliary.add("10th Company Task Force");
            superformation.namenAuxiliary.add("Storm Wing");
            superformation.namenAuxiliary.add("Anti-Air Defence Force");
            superformation.namenAuxiliary.add("Suppression Force");
            superformation.namenAuxiliary.add("Centurion Siegebreaker Cohort");
            superformation.namenAuxiliary.add("Land Raider Spearhead");
            superformation.namenAuxiliary.add("Strike Force Ultra");
            superformation.namenAuxiliary.add("Skyhammer Orbital Strike Force (WZ Kauyon)");
            superformation.namenAuxiliary.add("Skyhammer Annihilation Force (Webstore)");
            superformation.namenAuxiliary.add("Raptor Wing (WZ Kauyon)");
            superformation.namenAuxiliary.add("Honoured Ancients");
            superformation.namenAuxiliary.add("Iron Guardians");

            for (int i = 0; i < myChooserGruppen.size(); i++) {
                myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
            }

            superformation.refreshControlPanel();

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);

            RefreshListener.fireRefresh();
        } else if (getKontingentTyp().equals("Flameblade Strike Force (AoD)")) { //Superformation))
            setInformationVectorValue("Flame", 1);
            superformation = new Superformation(getPanel(), 0);
            superformation.reflectionKennungLokal = reflectionKennungLokal;
            superformation.volkFile = getClass().getName();
            superformation.tA = buildatextArea;
            superformation.buildaVater = this;

            superformation.minCommand = 0;
            superformation.maxCommand = 2;
            superformation.minCore = 1;
            superformation.maxCore = 2;
            superformation.minAuxiliary = 1;
            superformation.maxAuxiliary = Integer.MAX_VALUE;

            superformation.namenCommand.add("");
            superformation.namenCommand.add("Strike Force Command");
            superformation.namenCommand.add("Reclusiam Command Squad");
            superformation.namenCommand.add("Librarius Conclave");

            superformation.namenCore.add("");
            superformation.namenCore.add("Stormlance Battle Demi-Company (WZ Kauyon)");
            superformation.namenCore.add("Battle Demi-Company");

            superformation.namenAuxiliary.add("");
            superformation.namenAuxiliary.add("Armoured Task Force");
            superformation.namenAuxiliary.add("1st Company Task Force");
            superformation.namenAuxiliary.add("10th Company Task Force");
            superformation.namenAuxiliary.add("Storm Wing");
            superformation.namenAuxiliary.add("Anti-Air Defence Force");
            superformation.namenAuxiliary.add("Suppression Force");
            superformation.namenAuxiliary.add("Centurion Siegebreaker Cohort");
            superformation.namenAuxiliary.add("Land Raider Spearhead");
            superformation.namenAuxiliary.add("Strike Force Ultra");
            superformation.namenAuxiliary.add("Raptor Wing (WZ Kauyon)");
            superformation.namenAuxiliary.add("Stormbringer Squadron (WZ Kauyon)");
            superformation.namenAuxiliary.add("Ravenhawk Assault Group (WZ Kauyon)");
            superformation.namenAuxiliary.add("Flamebringers");

            for (int i = 0; i < myChooserGruppen.size(); i++) {
                myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
            }

            superformation.refreshControlPanel();

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);

            RefreshListener.fireRefresh();
        } else if (getKontingentTyp().equals("Talon Strike Force (WZ Kauyon)")) { //Superformation))
            setInformationVectorValue("Talon", 1);
            superformation = new Superformation(getPanel(), 0);
            superformation.reflectionKennungLokal = reflectionKennungLokal;
            superformation.volkFile = getClass().getName();
            superformation.tA = buildatextArea;
            superformation.buildaVater = this;

            superformation.minCommand = 0;
            superformation.maxCommand = 2;
            superformation.minCore = 1;
            superformation.maxCore = 2;
            superformation.minAuxiliary = 1;
            superformation.maxAuxiliary = Integer.MAX_VALUE;

            superformation.namenCommand.add("");
            superformation.namenCommand.add("Strike Force Command");
            superformation.namenCommand.add("Reclusiam Command Squad");

            superformation.namenCore.add("");
            superformation.namenCore.add("Battle Demi-Company");
            superformation.namenCore.add("Pinion Battle Demi-Company (WZ Kauyon)");

            superformation.namenAuxiliary.add("");
            superformation.namenAuxiliary.add("Shadowstrike Killteam (WZ Kauyon)");
            superformation.namenAuxiliary.add("Bladewing Assault Brotherhood (WZ Kauyon)");
            superformation.namenAuxiliary.add("Skyhammer Orbital Strike Force (WZ Kauyon)");
            superformation.namenAuxiliary.add("Ravenhawk Assault Group (WZ Kauyon)");
            superformation.namenAuxiliary.add("Raptor Wing (WZ Kauyon)");
            superformation.namenAuxiliary.add("Shadow Force (WZ Kauyon)");
            superformation.namenAuxiliary.add("1st Company Task Force");
            superformation.namenAuxiliary.add("10th Company Task Force");
            superformation.namenAuxiliary.add("Storm Wing");
            superformation.namenAuxiliary.add("Anit-Air Defence Force");
            superformation.namenAuxiliary.add("Suppression Force");

            for (int i = 0; i < myChooserGruppen.size(); i++) {
                myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
            }

            superformation.refreshControlPanel();

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);

            RefreshListener.fireRefresh();
        } else if (getKontingentTyp().equals("Pinion Battle Demi-Company (WZ Kauyon)")) {
            setInformationVectorValue("Sons of Corax", 1);
//			formationen.add("Pinion Battle Demi-Company (WZ Kauyon)");
//			- 1 Captain or Chaplain *Captain Sicarius. Chaplain Cassius. Korsarro Khan. Vulkan Hestan, Shadow Captain Shrike. Pedro Kantor. High Marshal Helbrecht or Chaplain Grimaldus
//			- 0-1 Command Squad
//			- 3 Tactical Squad
//			- 1 Assault Squad
//			- 1 Devastator Squad
//			- 1-5 of : Scout, Scout Bike
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden", "Captain", "Chaplain", "Captain Sicarius", "Chaplain Cassius", "Kor'sarro Khan", "Vulkan He'stan", "Shadow Captain Shrike", "Pedro Kantor", "High Marshal Helbrecht", "Chaplain Grimaldus"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Command Squad"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Tactical Squad", "Scout Squad"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Assault Squad", "Scout Bike Squad"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Devastator Squad"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(0, "Captain");
                addUnit(2, "Tactical Squad");
                addUnit(2, "Tactical Squad");
                addUnit(2, "Tactical Squad");
                addUnitNotLocked(2, "Scout Squad");
                addUnit(3, "Assault Squad");
                addUnit(4, "Devastator Squad");
                addUnit(4, "");
            }

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Shadowstrike Killteam (WZ Kauyon)")) {
            setInformationVectorValue("Sons of Corax", 1);
            setInformationVectorValue("Shadowstrike Killteam", 1);
//			- 2-4 Scout 
//			- 1-3 Vanguard Veteran (Jump)
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Vanguard Veteran Squad"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Scout Squad"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(1, "Vanguard Veteran Squad");
                addUnit(2, "Scout Squad");
                addUnit(2, "Scout Squad");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Bladewing Assault Brotherhood (WZ Kauyon)")) {
            setInformationVectorValue("Sons of Corax", 1);
            setInformationVectorValue("Bladewing Assault Brotherhood", 1);
//			- 1 Captain or Chaplain or Shrike (Jump)
//			- 1-3 Vanguard Veteran (Jump)
//			- 2-4 Assault Squad
//			- TODO Max 30 models
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden", "Captain", "Chaplain", "Shadow Captain Shrike"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Vanguard Veteran Squad"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Assault Squad"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(0, "Captain");
                addUnit(1, "Vanguard Veteran Squad");
                addUnit(3, "Assault Squad");
                addUnit(3, "Assault Squad");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);

        } else if (getKontingentTyp().equals("Skyhammer Orbital Strike Force (WZ Kauyon)")) {
            setInformationVectorValue("Sons of Corax", 1);
            setInformationVectorValue("Skyhammer Orbital Strike Force", 1);
//			- 3 Tactical Squad (Drop Pod)
//			- 1-3 Land Speeders
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"",});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Tactical Squad"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Land Speeders"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {

                addUnit(2, "Tactical Squad");
                addUnit(2, "Tactical Squad");
                addUnit(2, "Tactical Squad");
                addUnit(2, "");
                addUnit(3, "Land Speeders");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);

        } else if (getKontingentTyp().equals("Ravenhawk Assault Group (WZ Kauyon)")) {
            setInformationVectorValue("Sons of Corax", 1);
//			- 1 Sternguard
//			- 1 Dread, Ironclad, Venerable
//			- 1 Stormraven
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Sternguard Veteran Squad", "Dreadnoughts", "Venerable Dreadnoughts", "Ironclad Dreadnoughts"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Stormraven Gunship"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {

                addUnit(1, "Sternguard Veteran Squad");
                addUnitNotLocked(1, "Dreadnoughts");
                addUnit(4, "Stormraven Gunship");
                addUnit(4, "");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);

        } else if (getKontingentTyp().equals("Raptor Wing (WZ Kauyon)")) {
            setInformationVectorValue("Sons of Corax", 1);
//			- 1 Lanspeeders
//			- 2 Stormtalon
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Land Speeders", "Stormtalon Gunship"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {

                addUnit(3, "Land Speeders");
                addUnit(3, "Stormtalon Gunship");
                addUnit(3, "Stormtalon Gunship");
                addUnit(3, "");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Raptor Wing (WZ Kauyon)")) {
            setInformationVectorValue("Shadow Force", 1);
//			- 1 Captain or Captain Sicarius. Korsarro Khan. Vulkan Hestan, Shadow Captain Shrike. Pedro Kantor. High Marshal Helbrecht
//			- 1 Sternguard
//			- 1 Vanguard
//			- 1 Landspeeders
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden", "Captain", "Captain Sicarius", "Chaplain Cassius", "Kor'sarro Khan", "Vulkan He'stan", "Shadow Captain Shrike", "Pedro Kantor", "High Marshal Helbrecht"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Sternguard Veteran Squad", "Vanguard Veteran Squad"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Land Speeders"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {

                addUnitNotLocked(0, "Captain");
                addUnit(1, "Sternguard Veteran Squad");
                addUnit(1, "Vanguard Veteran Squad");
                addUnit(1, "");
                addUnit(3, "Land Speeders");
                addUnit(3, "");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Scarblade Strike Force (WZ Kauyon)")) { //Superformation))
            setInformationVectorValue("Scarblade", 1);
            superformation = new Superformation(getPanel(), 0);
            superformation.reflectionKennungLokal = reflectionKennungLokal;
            superformation.volkFile = getClass().getName();
            superformation.tA = buildatextArea;
            superformation.buildaVater = this;

            superformation.minCommand = 0;
            superformation.maxCommand = 3;
            superformation.minCore = 1;
            superformation.maxCore = 2;
            superformation.minAuxiliary = 1;
            superformation.maxAuxiliary = Integer.MAX_VALUE;

            superformation.namenCommand.add("");
            superformation.namenCommand.add("Strike Force Command");
            superformation.namenCommand.add("Reclusiam Command Squad");
            superformation.namenCommand.add("Librarius Conclave");

            superformation.namenCore.add("");
            superformation.namenCore.add("Battle Demi-Company");
            superformation.namenCore.add("Stormlance Battle Demi-Company (WZ Kauyon)");
            superformation.namenCore.add("Hunting Force (WZ Kauyon)");

            superformation.namenAuxiliary.add("");
            superformation.namenAuxiliary.add("Stormbringer Squadron (WZ Kauyon)");
            superformation.namenAuxiliary.add("Speartip Strike (WZ Kauyon)");
            superformation.namenAuxiliary.add("Armoured Task Force");
            superformation.namenAuxiliary.add("1st Company Task Force");
            superformation.namenAuxiliary.add("Strike Force Ultra");
            superformation.namenAuxiliary.add("Storm Wing");
            superformation.namenAuxiliary.add("Land Raider Spearhead");
            superformation.namenAuxiliary.add("Anit-Air Defence Force");
            superformation.namenAuxiliary.add("Suppression Force");

            for (int i = 0; i < myChooserGruppen.size(); i++) {
                myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
            }

            superformation.refreshControlPanel();

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);

            RefreshListener.fireRefresh();
        } else if (getKontingentTyp().equals("Stormlance Battle Demi-Company (WZ Kauyon)")) {
            setInformationVectorValue("Sons of the Great Khan", 1);
            setInformationVectorValue("Stormlance Battle Demi-Company (WZ Kauyon)", 1);
            //TODO Stormlance-Beschränkungen Start aller Einheiten in Rhino/Razor/Jump/Bike
//			- 1 Captain or Chaplain *Captain Sicarius. Chaplain Cassius. Korsarro Khan. Vulkan Hestan, Shadow Captain Shrike. Pedro Kantor. High Marshal Helbrecht or Chaplain Grimaldus
//			- 0-1 Command Squad
//			- 3 Tactical Squad
//			- 1 Devastator Squad
//			- 1 of : Assault, Bike, Attack Bike, Land Speeder
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden", "Captain", "Chaplain", "Captain Sicarius", "Chaplain Cassius", "Kor'sarro Khan", "Vulkan He'stan", "Shadow Captain Shrike", "Pedro Kantor", "High Marshal Helbrecht", "Chaplain Grimaldus"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Command Squad"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Tactical Squad"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Assault Squad", "Bike Squad", "Attack Bike Squad", "Land Speeders"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Devastator Squad"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(0, "Captain");
                addUnit(2, "Tactical Squad");
                addUnit(2, "Tactical Squad");
                addUnit(2, "Tactical Squad");
                addUnit(2, "");
                addUnitNotLocked(3, "Assault Squad");
                addUnit(4, "Devastator Squad");
                addUnit(4, "");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Hunting Force (WZ Kauyon)")) {
            setInformationVectorValue("Sons of the Great Khan", 1);
            setInformationVectorValue("Hunting Force", 1);
//			- 1 Captain or Korsarro Khan(Bike)
//			- 0-1 Chaplain or Korsarro Khan
//			- 0-1 Command Squad(Bike)
//			- 2-5 Bike Squad
//			- 1-3 Attack Bike
//			- 1-3 Scout Bike
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden", "Captain", "Chaplain", "Kor'sarro Khan"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Command Squad"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Bike Squad", "Attack Bike Squad", "Scout Bike Squad"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(0, "Captain");
                addUnit(3, "Bike Squad");
                addUnit(3, "Bike Squad");
                addUnit(3, "Attack Bike Squad");
                addUnit(3, "Scout Bike Squad");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Stormbringer Squadron (WZ Kauyon)")) {
            setInformationVectorValue("Sons of the Great Khan", 1);
            setInformationVectorValue("Stormbringer Squadron", 1);
//			- 1-3 units of Land Speeder
//			- 1-3 Scout Squads (Land Speeder Storm)
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Scout Squad"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Land Speeders"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(2, "Scout Squad");
                addUnit(3, "Land Speeders");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Speartip Strike (WZ Kauyon)")) {
            setInformationVectorValue("Sons of the Great Khan", 1);
//			- 1-3 units of Land Speeder
//			- 2 of : Bike Squad, Attack Bike Squad, Scout Bike Squad
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Land Speeders", "Bike Squad", "Attack Bike Squad", "Scout Bike Squad"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(3, "Bike Squad");
                addUnitNotLocked(3, "Bike Squad");
                addUnit(3, "Land Speeders");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Battle Company")) {
            setInformationVectorValue("Battle Company", 1);

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden", "Captain", "Chaplain", "Captain Sicarius", "Chaplain Cassius", "Kor'sarro Khan", "Vulkan He'stan", "Shadow Captain Shrike", "Chaplain Grimaldus"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Command Squad", "Dreadnoughts", "Venerable Dreadnoughts", "Ironclad Dreadnoughts"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Tactical Squad"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Assault Squad", "Bike Squad", "Attack Bike Squad", "Land Speeders", "Centurion Assault Squad"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Devastator Squad", "Centurion Devastator Squad"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(0, "Captain");
                addUnitNotLocked(0, "Chaplain");
                addUnit(2, "Tactical Squad");
                addUnit(2, "Tactical Squad");
                addUnit(2, "Tactical Squad");
                addUnit(2, "Tactical Squad");
                addUnit(2, "Tactical Squad");
                addUnit(2, "Tactical Squad");
                addUnitNotLocked(3, "Assault Squad");
                addUnitNotLocked(3, "Assault Squad");
                addUnitNotLocked(4, "Devastator Squad");
                addUnitNotLocked(4, "Devastator Squad");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Skyhammer Annihilation Force (Webstore)")) {
            setInformationVectorValue("Skyhammer Annihilation Force (Webstore)", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Assault Squad"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Devastator Squad"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(3, "Assault Squad");
                addUnit(3, "Assault Squad");
                addUnit(3, "");
                addUnit(4, "Devastator Squad");
                addUnit(4, "Devastator Squad");
                addUnit(4, "");
            }
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bike Squad");
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Armoured Task Force")) {
            setInformationVectorValue("Armoured Task Force", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden", "Techmarine", "Sergeant Chronus"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Thunderfire-Cannons", "Vindicators", "Predators", "Whirlwinds"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Techmarine");
                setUnitList(4, new String[]{"Vindicators", "Predators", "Whirlwinds"});//addUnitNotLocked(4, "Vindicators");
                setUnitList(4, new String[]{"Vindicators", "Predators", "Whirlwinds"});//addUnitNotLocked(4, "Vindicators");
                setUnitList(4, new String[]{"Vindicators", "Predators", "Whirlwinds"});//addUnitNotLocked(4, "Vindicators");
            }
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bike Squad");
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Strike Force Command")) {
            setInformationVectorValue("Strike Force Command", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden", "Pedro Kantor", "High Marshal Helbrecht", "Captain", "Chaplain", "Captain Sicarius", "Chaplain Cassius", "Kor'sarro Khan", "Vulkan He'stan", "Shadow Captain Shrike", "Chaplain Grimaldus", "The Emperor's Champion"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Honour Guard", "Command Squad"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{"", "Marneus Calgar"});
            if (!isLoading) {
                addUnitNotLocked(0, "Captain");
            }
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bike Squad");
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("10th Company Task Force")) {
            setInformationVectorValue("10th Company Task Force", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden", "Sergeant Telion"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Scout Squad", "Scout Bike Squad"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(2, "Scout Squad");
                addUnitNotLocked(2, "Scout Squad");
                addUnitNotLocked(2, "Scout Squad");
            }
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bike Squad");
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Centurion Siegebreaker Cohort")) {
            setInformationVectorValue("Centurion Siegebreaker Cohort", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Centurion Assault Squad", "Ironclad Dreadnoughts"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(1, "Ironclad Dreadnoughts");
                addUnit(1, "Centurion Assault Squad");
                addUnit(1, "Centurion Assault Squad");
            }
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bike Squad");
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Land Raider Spearhead")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Land Raider", "Land Raider Crusader", "Land Raider Redeemer"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(4, "Land Raider");
                addUnitNotLocked(4, "Land Raider");
                addUnitNotLocked(4, "Land Raider");
            }
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bike Squad");
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Librarius Conclave")) {
            setInformationVectorValue("Librarius Conclave", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden", "Librarian", "Chief Librarian Tigurius"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(0, "Librarian");
                addUnitNotLocked(0, "Librarian");
                addUnitNotLocked(0, "Librarian");
            }
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bike Squad");
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Anti-Air Defence Force")) {
            addToInformationVector("Anti-Air Defence Force", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Hunters", "Stalkers"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(4, "Hunters");
                addUnit(4, "Stalkers");
                addUnit(4, "");
            }
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bike Squad");
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Suppression Force")) {
            addToInformationVector("Suppression Force", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Land Speeders"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Whirlwinds"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(3, "Land Speeders");
                addUnit(3, "");
                addUnit(4, "Whirlwinds");
                addUnit(4, "");
            }
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bike Squad");
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Storm Wing")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Stormtalon Gunship"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Stormraven Gunship"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(3, "Stormtalon Gunship");
                addUnit(3, "Stormtalon Gunship");
                addUnit(3, "");
                addUnit(4, "Stormraven Gunship");
                addUnit(4, "");
            }
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bike Squad");
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Reclusiam Command Squad")) {
            setInformationVectorValue("Reclusiam Command Squad", 1);

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden", "Chaplain", "Chaplain Cassius", "Chaplain Grimaluds"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Command Squad"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(0, "Chaplain");
                addUnit(1, "Command Squad");
                addUnit(1, "");
            }
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bike Squad");
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Strike Force Ultra")) {
            setInformationVectorValue("Strike Force Ultra", 1);

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden", "Captain", "Captain Lysander"});//Captain must have Termi
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Terminator Squad", "Terminator Assault Squad", "Venerable Dreadnoughts"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Stormraven Gunship", "Land Raider Crusader", "Land Raider Redeemer"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(0, "Captain");
                addUnit(1, "Terminator Squad");
                addUnit(1, "Terminator Squad");
                addUnit(1, "Terminator Assault Squad");
                addUnit(1, "Terminator Assault Squad");
                addUnit(1, "Venerable Dreadnoughts");
                addUnit(1, "");
                addUnit(4, "Stormraven Gunship");
                addUnitNotLocked(4, "Land Raider Crusader");
            }
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bike Squad");
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Battle Demi-Company")) {
            setInformationVectorValue("Battle Demi-Company", 1);

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden", "Captain", "Chaplain", "Captain Sicarius", "Chaplain Cassius", "Kor'sarro Khan", "Vulkan He'stan", "Shadow Captain Shrike", "Chaplain Grimaldus"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Command Squad", "Dreadnoughts", "Venerable Dreadnoughts", "Ironclad Dreadnoughts"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Tactical Squad"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Assault Squad", "Bike Squad", "Attack Bike Squad", "Land Speeders", "Centurion Assault Squad"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Devastator Squad", "Centurion Devastator Squad"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(0, "Captain");
                addUnit(2, "Tactical Squad");
                addUnit(2, "Tactical Squad");
                addUnit(2, "Tactical Squad");
                addUnitNotLocked(3, "Assault Squad");
                addUnitNotLocked(4, "Devastator Squad");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("1st Company Task Force")) {
            setInformationVectorValue("1st Company Task Force", 1);

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Orden"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Terminator Squad", "Terminator Assault Squad", "Sternguard Veteran Squad", "Vanguard Veteran Squad"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(1, "Terminator Squad");
                addUnitNotLocked(1, "Terminator Squad");
                addUnitNotLocked(1, "Terminator Squad");
            }
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bike Squad");
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Masters of the Armoury")) {
            addToInformationVector("Masters of the Armoury", 1);

            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Sergeant Chronus"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "Predators", "Vindicators", "Land Raider", "Land Raider Redeemer", "Land Raider Crusader"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
            }
        } else if (getKontingentTyp().equals("Keepers of the Forge")) {
            addToInformationVector("Keepers of the Forge", 1);

            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Techmarine"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "Rhino", "Razorback"});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnit(HQ, "Techmarine");
                addUnit(FA, "Rhino");
            }
        } else if (getKontingentTyp().equals("Mechanised Infantry")) {
            addToInformationVector("Mechanised Infantry", 1);

            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Terminator Squad", "Terminator Assault Squad", "Cataphractii Terminator Squad", "Sternguard Veteran Squad", "Vanguard Veteran Squad", "Centurion Assault Squad"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "Tactical Squad", "Scout Squad"});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "Assault Squad"});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "Devastator Squad", "Centurion Devastator Squad"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnitNotLocked(TR, "Tactical Squad");
            }
        } else if (getKontingentTyp().equals("Techmarine")) {
            addToInformationVector("Techmarine", 1);

            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Techmarine"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "Thunderfire-Cannons"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnitNotLocked(HQ, "Techmarine");
            }
        } else if (getKontingentTyp().equals("Recon Outriders")) {
            addToInformationVector("Recon Outriders", 1);

            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "Land Speeders"});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnit(FA, "Land Speeders");
            }
        } else if (getKontingentTyp().equals("Honoured Ancients")) {
            addToInformationVector("Honoured Ancients", 1);

            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Dreadnoughts", "Venerable Dreadnoughts", "Ironclad Dreadnoughts"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "Contemptor Dreadnoughts"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnitNotLocked(EL, "Dreadnoughts");
            }
        } else if (getKontingentTyp().equals("Siege Ancients")) {
            addToInformationVector("Siege Ancients", 1);

            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Ironclad Dreadnoughts"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "Contemptor Dreadnoughts"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnitNotLocked(EL, "Ironclad Dreadnoughts");
            }
        } else if (getKontingentTyp().equals("Ordnance")) {
            addToInformationVector("Ordnance", 1);

            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "Thunderfire-Cannons"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnit(HS, "Thunderfire-Cannons");
            }
        } else if (getKontingentTyp().equals("Line Breakers")) {
            addToInformationVector("Line Breakers", 1);

            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "Vindicators"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnit(HS, "Vindicators");
            }
        } else if (getKontingentTyp().equals("Devastators")) {
            addToInformationVector("Devastators", 1);

            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "Devastator Squad"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnit(HS, "Devastator Squad");
            }
        } else if (getKontingentTyp().equals("Centurions")) {
            addToInformationVector("Centurions", 1);

            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Centurion Assault Squad"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "Centurion Devastator Squad"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnitNotLocked(HS, "Centurion Devastator Squad");
            }
        } else if (getKontingentTyp().equals("Iron Guardians")) {
            addToInformationVector("Iron Guardians", 1);

            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Dreadnoughts", "Venerable Dreadnoughts", "Ironclad Dreadnoughts"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "Tactical Squad"});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "Contemptor Dreadnoughts"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnitNotLocked(EL, "Dreadnoughts");
                addUnit(TR, "Tactical Squad");
            }
        } else if (getKontingentTyp().equals("Flamebringers")) {
            addToInformationVector("Flamebringers", 1);

            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "Land Raider Redeemer"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnit(HS, "Land Raider Redeemer");
            }
        } else if (getKontingentTyp().equals("Victrix Guard")) {
            addToInformationVector("Victrix Guard", 1);
            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Captain Sicarius"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Honour Guard", "Vanguard Veteran Squad", "Sternguard Veteran Squad"});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"Captain Sicarius"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"Honour Guard"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"Sternguard Veteran Squad", "SM Vanguard Veteran Squad"}, 4, 4));

            if (!isLoading) {
                addUnit(0, "Captain Sicarius");
                addUnit(1, "Honour Guard");
                addUnitNotLocked(1, "Vanguard Veteran Squad");
                addUnitNotLocked(1, "Vanguard Veteran Squad");
                addUnitNotLocked(1, "Vanguard Veteran Squad");
                addUnitNotLocked(1, "Vanguard Veteran Squad");

            }

            supplementBox.setEnabled(false);
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        }

        fillChooserSpace();
    }

    @Override
    protected void finalize() {
        System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
    }

    @Override
    public void hideVolkCheckboxes() {
        if (getCountFromInformationVector("Clan Raukaan") > 0) {
            Raukaan.doClick();
        }
        if (getCountFromInformationVector("Sentinels of Terra") > 0) {
            SoT.doClick();
        }
        Raukaan.setVisible(false);
        SoT.setVisible(false);
    }
}