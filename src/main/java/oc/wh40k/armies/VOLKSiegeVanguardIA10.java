package oc.wh40k.armies;



import oc.BuildaVater;

import oc.ChooserGruppe;



public class VOLKSiegeVanguardIA10 extends BuildaVater {



    public VOLKSiegeVanguardIA10() {

        reflectionKennung = "SF";



        HQeinträge = new String[]{"", "Siege Master", "Space Marine Ordensmeister", "Space Marine Captain", "Space Marine Scriptor", "Space Marine Ordenspriester", "Meister der Schmiede", "", "Ehrengarde", "Kommandotrupp",

                "", "Marneus Calgar", "Captain Cato Sicarius", "Scriptor-Magister Tigurius", "Ordenspriester Cassius", "Ordensmeister Pedro Kantor", "Captain Darnath Lysander", "Schatten-Captain Kayvaan Shrike", "Schmiedevater Vulkan He'stan", "Kor'sarro Khan",

                "", "[IA2 2nd Ed] Damocles Command Vehicle",

                "", "[IA12] Lord Asterion Moloc", "[IA12] Minotaurus Chaplain Ivanus Enkomi", "[IA12] Hecaton Aiakos",

                "", "[IA10] Bray'arth Ashmantle", "[IA10] Ahazra Redth", "[IA10] High Chaplain Thulsa Kane", "[IA10] Vaylund Cal", "[IA10] Captain Silas Alberec",

                "", "[IA9] Chaplain Dreadnought Titus", "[IA9] Lieutenant Commander Anton Narvaez", "[IA9] Captain Tarnus Vale",

                "[IA9] Captain Mordaci Blaylock", "[IA9] Captain Pellas Mir'san", "[IA9] Knight-Captain Elam Courbray", "[IA9] Captain Corien Sumatris",

                "[IA9] Armenneus Valthex",

                "", "[Forgeworld] Chapter Master Lias Issodon", "[Forgeworld] Chapter Master Lugft Huron", /*"[Forgeworld] Damocles Rhino",*/ "[Forgeworld] Tyberos The Red Wake", "[Forgeworld] Master Harath Shen"};

        Standardeinträge = new String[]{"", "Siege Dreadnought Talon", "Taktischer Trupp", "Siege Assault Squad"};

        Eliteeinträge = new String[]{"", "Terminator-Trupp", "Terminator-Sturmtrupp", "Protektorgarde", "Cybot", "Techmarine", "Servitoren",

                "", "[IA2 2nd Ed] Land Raider Prometheus", "[IA2 2nd Ed] Contemptor Mortis Pattern Dreadnought", "[IA2 2nd Ed] Chaplain Dreadnought", "[IA2 2nd Ed] Siege Dreadnought", "[IA2 2nd Ed] Mark V Mortis Pattern Dreadnought"};

        Sturmeinträge = new String[]{"", "Sturmtrupp", "Expugnatorgarde",

                "", "[IA2 2nd Ed] Caestus Assault Ram", "[IA2 2nd Ed] Land Speeder Tempest Squadron"};

        Unterstützungeinträge = new String[]{"", "Devastor-Trupp", "Salvenkanone", "Predator Tank Squadron", "Whirlwind Support Squadron", "Vindicator Tank Squadron",

                "", "[IA Experimental] Quad Mortar Support Battery",

                "", "[IA2 2nd Ed] Land Raider Helios", "[IA2 2nd Ed] Land Raider Proteus", "[IA2 2nd Ed] Land Raider Achilles",

                "[IA2 2nd Ed] Deimos Predator", "[IA2 2nd Ed] Whirlwind Hyperios", "[IA2 2nd Ed] Relic Whirlwind Scorpius",

                "[IA2 2nd Ed] Spartan Assault Tank", "[IA2 2nd Ed] Storm Eagle", "[IA2 2nd Ed] Tarantula-Batterie",

                "[IA2 2nd Ed] Rapier Carrier Battery", "[IA2 2nd Ed] Storm Eagle Roc Pattern", "[IA2 2nd Ed] Deathstorm Drop Pod",

                "[IA2 2nd Ed] Fire Raptor Gunship",

                "", "[IA12] Predator Infernus"};

        Befestigungen = new String[]{""};

        LordofWar = new String[]{"", "[APO2 Armageddon] Reaver Battle Titan", "[APO2 Armageddon] Warhound-Scouttitan",

                "", "[IA2 2nd Ed] Fellblade", "[IA2 2nd Ed] Typhon", "[IA2 2nd Ed] Cerberus", "[IA2 2nd Ed] Thunderhawk Gunship",

                "[IA2 2nd Ed] Thunderhawk Transporter"};



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



        nameDerArtDerArmee = "Siege Assault Force";

        nameDerArtDerArmeeDekliniert = "Siege Assault Force";

        textAreaUeberschrift = "Siege Assault Force";



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
}