package oc.wh40k.armies;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKCrimsonSlaughter extends BuildaVater {

    public VOLKCrimsonSlaughter() {
        reflectionKennung = "CS";

        HQeinträge = new String[]{"", "Chaosgeneral", "Hexer", "Dämonenprinz", "Warpschmied", "Dunkler Apostel", "", "Abaddon der Vernichter", "Ahriman", "Fabius Gallus",
                "Huron Schwarzherz", "Kharn der Verräter", "Lucius der Ewige", "Typhus", "BeLakor",
                "", "[IA Apo 2013] Zhufor", "[Forgeworld] Necrosius"};

        Eliteeinträge = new String[]{"", "Chaosterminatoren", "Höllenschlächter", "Mutilator",
                "", "[IA Experimental] Land Raider Proteus",
                "", "[IA Apo 2013] Chaos Contemptor Dreadnought", "[IA Apo 2013] Giant Chaos Spawn", "[IA Apo 2013] Chaos Decimator Daemon Engine", ""};
        Standardeinträge = new String[]{"", "Besessene", "Chaos Space Marines", "Chaoskultisten"};
        Sturmeinträge = new String[]{"", "Chaosbiker", "Raptoren", "Warpkrallen", "Chaosbrut", "[DftS] Höllendrache",
                "", "[IA Apo 2013] Chaos Storm Eagle", "[IA Aeronautica] Dreadclaw", "[IA Aeronautica] Hell Blade", "[IA Aeronautica] Hell Talon"};

        Unterstützungeinträge = new String[]{"", "Havocs", "Kyborg", "Geissel", "Schmiedemonstrum", "Klauenmonstrum", "Land Raider des Chaos", "Vindicator des Chaos",
                "Predator des Chaos",
                "", "[IA Apo 2013] Chaos Spartan Assault Tank", "[IA Apo 2013] Chaos Relic Predator", "[IA Apo 2013] Spined Chaos Beast"
        };
        LordofWar = new String[]{
                "", "Schädelherrscher des Khorne",
                "", "[IA Apo 2013] Chaos Warhound Titan", "[IA Apo 2013] Chaos Reaver Battle Titan", "[IA Apo 2013] Greater Brass Scorpion of Khorne",
                "[IA Apo 2013] Thunderhawk Gunship",
                "", "[IA Experimental] Chaos Knight Paladin", "[IA Experimental] Chaos Knight Errant", "[IA Experimental] Kytan Daemon Engine of Khorne",
        };
//        Formationen = new String[] {
//                "", "[DataSlate] Cypher - Fallen Champions", "[DataSlate] Helbrute Mayhem Pack", "[DataSlate] Helcult", "[DataSlate] Helfist Murderpack"
//            };

        /**LoW
         Chaos Reaver Battle Titan IA: Apoc
         Chaos Warhound Titan IA: Apoc
         Chaos Space Marine Thunderhawk Gunship IA: Apoc
         Greater Brass Scorpion of Khorne IA: Apoc
         */
        
        /*
			CULT OF DESTRUCTION
			1 + Obliterator units
			1 + Mutilator units
			FORMATION RESTRICTIONS
			Each unit must consist of three models.
			
			HELDRAKE FEAR SQUADRON
			3-5 Heldrakes

			LEGIONNAIRE WARBAND
			1 Chaos Lord
			3 + Troops units
			2 + Elites units
			Any number of units
			from the following:
			- HQ
			- Fast attack
			- Heavy support
			FORMATION RESTRICTIONS
			All models in the Legionnaire Warband must have the Veterans of the Long War upgrade. If the Chaos Lord
			has a Mark of Chaos, all other units that are able to, must have the same Mark of Chaos as the Chaos Lord

			LORDS OF THE BLACK CRUSADE ?? Nochmal mit Bildern ansehn
			Abaddon the Despoiler
			1 Chaos Lord with the Mark of Khorne or Kharn the Betrayer
			1 Chaos Sorcerer with the Mark of Tzeentch or Ahriman
			1 Chaos Lord with Mark of Slaanesh or Lucius the Eternal
			
			THE LOST AND THE DAMNED
			1 + Dark Apostle
			6+ units of Chaos Cultists
			
			THOUSAND SONS WAR COVEN
			1 Chaos Sorcerer (Mastery Level 3) or Ahriman
			3 + Chaos Sorcerers (Mastery Level 1)

'			TIDE OF SPAWN
			5+ Chaos Spawn
			
			COHORT OF BLOOD
			Skull taker
			1 + Heralds of Khorne
			8 units of Bloodletters of Khorne
			FORMATION RESTRICTIONS
			Each of the Bloodletter units must have eight models.
			
			THE FLAMING HOST OF TZEENTCH
			1 Herald of Tzeentch or the Changeling
			9 units, in any combination, from the following:
			Pink Horrors of Tzeentch
			Flamers of Tzeentch
			Burning Chariot of Tzeentch
			
			THE GREAT PROMENADE OF EXQUISITE EXCESS
			The Masque of Slaanesh
			6 units, in any combination, from the following:
			Daemonettes of Slaanesh
			Seekers of Slaanesh
			
			THE TALLYMEN OF NURGLE
			Epidemius the Tallyman
			7 units, in any combination,from the following:
			Plague bearers of Nurgle
			Plague Drones of Nurgle
			
			TETRAGON OF DARKNESS
			1 Bloodthirster
			1 Lord of Change
			1 Great Unclean One
			1 Keeper of Secrets
			1 unit of Bloodletters of Khorne
			1 unit of Pink Horrors of Tzeentch
			1 unit of Plague bearers of Nurgle
			1 unit of Daemonettes of Slaanesh
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
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 7, LordofWar));
//        cnt += CHOOSERGRUPPEN_X_ABSTAND;
//        adden(new ChooserGruppe(this,"FORM", cnt, 0, 8, Formationen));
        cnt += 480;

        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Auserkorene");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Khorne-Berserker");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Thousand Sons");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Seuchenmarines");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Noisemarines");

        nameDerArtDerArmee = "Chaos Space Marines";
        nameDerArtDerArmeeDekliniert = "Chaos Space Marines";
        textAreaUeberschrift = BuildaHQ.translate("Meine") + " Chaos Space Marines";

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

        complete();
    }

    @Override
    protected void finalize() {
        System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
    }

}