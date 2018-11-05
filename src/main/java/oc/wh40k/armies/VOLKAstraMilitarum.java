package oc.wh40k.armies;

import oc.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VOLKAstraMilitarum extends BuildaVater {

    public JCheckBox Cadian = new JCheckBox("Cadians");
    private ActionListener cadianActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {

            if (Cadian.isSelected()) {
                setInformationVectorValue("Cadian Detachment", 1);
            } else {
                setInformationVectorValue("Cadian Detachment", 0);
            }
            RefreshListener.fireRefresh();
        }

    };

    public VOLKAstraMilitarum() {
        reflectionKennung = "AM";

        HQeinträge = new String[]{
                "", "Commissar Yarrick", "Company Command Squad", "Tank Commander Squadron", "Lord Commissar", "Commissar", "Ministorum Priest", "Primaris Psyker",
                "Enginseer", "", "Belisarius Cawl", "Celestine", "Inquisitor Greyfax",
                "", "[IA 8] Captain Thanstadt", "[IA 8] Sword Force Command Squad",
                "", "[Forgeworld] General Myndoras Odon"};
        Eliteeinträge = new String[]{
                "", "Ogryns", "Bullgryns", "Ratlings", "Wyrdvane Psykers", "Militarum Tempestus Platoon",
                "", "[IA1 2nd Ed] Salamander Command Vehicle", "[IA1 2nd Ed] Hades Breaching Drill", "[IA1 2nd Ed] Atlas Recovery Tank"};
        Standardeinträge = new String[]{
                "", "Infantry Platoon", "Veterans"};
        Sturmeinträge = new String[]{
                "", "Scout Sentinel Squadron", "Armoured Sentinel Squadron", "Rough Riders", "Hellhound Squadron",
                "Valkyrie Squadron", "Vendetta Squadron",
                "", "[IA1 2nd Ed] Centaur Squadron", "[IA1 2nd Ed] Salamander Recon Squadron", "[IA1 2nd Ed] Drop Sentinel Squadron",
                "[IA1 2nd Ed] Tauros Squadron",
                "", "[IA Aeronautica] Aquila Lander", "[IA Aeronautica] Vulture", "[IA Aeronautica] Arvus Lighter"};
        Unterstützungeinträge = new String[]{
                "", "Leman Russ Squadron", "Hydra Battery", "Basilisk Battery", "Wyvern Battery", "Manticore", "Deathstrike",
                "", "[IA1 2nd Ed] Destroyer Tank Hunter Squadron", "[IA1 2nd Ed] Thunderer Siege Tank Squadron", "[IA1 2nd Ed] Manticore Battery",
                "[IA1 2nd Ed] Hydra Platform Battery", "[IA1 2nd Ed] Manticore Platform Battery", "[IA1 2nd Ed] Earthshaker Platform Battery",
                "[IA1 2nd Ed] Heavy Artillery Battery", "[IA1 2nd Ed] Field Artillery Battery", "[IA1 2nd Ed] Sentry Gun Battery",
                "[IA1 2nd Ed] Rapier Carrier with Laser Destroyer", "[IA1 2nd Ed] Cyclops Demolition Squad",
                "[IA1 2nd Ed] Sentinel Powerlifter Squadron", "[IA1 2nd Ed] Ordnance Battery",
                "", "[IA Aeronautica] Thunderbolt Fighter", "[IA Aeronautica] Lightning", "[IA Aeronautica] Avenger Strike Fighter",
                "[IA Aeronautica] Valkyre Sky Talon Transport", "[IA Aeronautica] Manticore Launcher Tank (Air Defence)"};
        LordofWar = new String[]{
                "", "[FW Download] Arkurian Pattern Stormblade",
                "", "[WZ Mont'ka] Baneblade", "[WZ Mont'ka] Banehammer", "[WZ Mont'ka] Banesword", "[WZ Mont'ka] Doomhammer", "[WZ Mont'ka] Hellhammer",
                "[WZ Mont'ka] Shadowsword", "[WZ Mont'ka] Stormlord", "[WZ Mont'ka] Stormsword",
                "", "[APO2 Armageddon] Reaver Battle Titan", "[APO2 Armageddon] Warhound-Scouttitan", "[APO2 Armageddon] Festung der Arroganz",
                "", "[IA1 2nd Ed] Stormblade", "[IA1 2nd Ed] Macharius Heavy Tank", "[IA1 2nd Ed] Macharius Vanquisher",
                "[IA1 2nd Ed] Macharius Vulcan", "[IA1 2nd Ed] Macharius Omega", "[IA1 2nd Ed] Crassus Armoured Assault Transport",
                "[IA1 2nd Ed] Praetor Armoured Assault Launcher", "[IA1 2nd Ed] Dominus Armoured Siege Bombard",
                "[IA1 2nd Ed] Gorgon Heavy Transporter", "[IA1 2nd Ed] Malcador Heavy Tank", "[IA1 2nd Ed] Malcador Annihilator",
                "[IA1 2nd Ed] Malcador Defender", "[IA1 2nd Ed] Malcador Infernus", "[IA1 2nd Ed] Valdor Tank Hunter",
                "[IA1 2nd Ed] Minotaur Artillery Tank",
                "", "[IA Aeronautica] Marauder Bomber", "[IA Aeronautica] Marauder Destroyer",
                "[IA Aeronautica] Praetor Armoured Assault Launcher (Air Defence)",
                "", "[Alt] Imperator-Kampftitan", "[Alt] Warlord-Kampftitan"
        };
//		Formationen = new String[] {
//				"","Imperiale Ritter",
//				"", "[APO2] Catachanisches Guerilliakomando","[APO2] 'Faust des Imperators' - Panzerkompanie","[APO2] 'Krallen des Imperators' - Aufklärungskompanie",
//				"[APO2] 'Zorn des Imperators' - Artilleriekompanie", "[APO2] 'Imperialer Schild' - Infanteriekompanie",
//				"[APO2] 'Imperiales Schwert' - Unterstützungskompanie", "[APO2] Oberster Komandostab des Grosskastellans",
//				"[APO2] Kampfchor sanktionierter Psioniker", "[APO2] 'Stählerne Wut' - Baneblade-Kompanie",
//				/*"", "[APO2 Armageddon NEW] Heroes of Armageddon", "[APO2 Armageddon NEW] Armageddon Stompa Hunters",
//    			"[APO2 Armageddon NEW] 'Imperial Vengeance' Mechanised Company", "[APO2 Armageddon NEW] Firestorm Nexus",
//    			"[APO2 Armageddon NEW] Imperial Stronghold",*/
//				//"", "[Forgeworld] Praetor Sky Killer Aerial Suppression Force",
//		};

		/*
    Heroes of Armageddon
	Commissar Yarrick
	1 Company Command Squad
	High Marshal Helbrecht
	1 Command Squad (Black Templars)
	Captain Tycho
	1 Honour Guard

	Armageddon Stompa Hunters
	3-5 Armoured Sentinels

	Imperial Vengeance Mechanised Company
	1 Company Command Squad
	3 Infantry Platoons
	Each Infantry Platoon must have one Platoon Command Squad and 2 Infantry
	Squads. All Squads, including the Company Command Squad, must have Chimera
	Dedicated Transport vehicles.

	FIRESTORM NEXUS
	3 Firestorm Redoubts

	IMPERIAL STRONGHOLD
	1 Macrocannon Aquila Strongpoint or Vortex Missile Aquila Strongpoint
	1 Firestorm Redoubt
	1+ Imperial Defence Lines
	1+ Imperial Defence Emplacements
	1+ Imperial Bunkers
	1 + Vengeance Weapon Batteries

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
        if (oc.OnlineCodex.getInstance().isApo()) {
            cnt += CHOOSERGRUPPEN_X_ABSTAND;
            adden(new ChooserGruppe(this, "APO", cnt, 0, 7, LordofWar));
//			cnt += CHOOSERGRUPPEN_X_ABSTAND;
//			adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 8, Formationen));
        }

        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

        nameDerArtDerArmee = "Astra Militarum";
        nameDerArtDerArmeeDekliniert = "Astra Militarum";
        textAreaUeberschrift = BuildaHQ.translate("Astra Militarum");

        noAllies.clear();
        noAllies.add("MT");
        noAllies.add("AM");
        noAllies.add("ED");
        noAllies.add("AB");
        noAllies.add("DK");
        noAllies.add("DKAB");

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

        //Verschiedene Spezialkontingente des AM
        formationen.add("The Steel Host (Sanctus Reach)");
        formationen.add("Rampart Detachment (Sanctus Reach)");
        formationen.add("");
        formationen.add("'Emperor's Shield' Infantry Platoon (Warzone Mont'ka)");
        formationen.add("'Emperor's Shield' Infantry Company (Warzone Mont'ka)");
        formationen.add("'Emperor's Talon' Recon Company (Warzone Mont'ka)");
        formationen.add("'Emperor's Blade' Assault Company (Warzone Mont'ka)");
        formationen.add("'Emperor's Wrath' Artillery Company (Warzone Mont'ka)");
        formationen.add("'Emperor's Fist' Armoured Company (Warzone Mont'ka)");
        formationen.add("Ogryn Auxilia (Warzone Mont'ka)");
        formationen.add("Psykana Division (Warzone Mont'ka)");
        formationen.add("'Emperor's Fury' Super-Heavy Company (Warzone Mont'ka)");
        formationen.add("'Emperor's Spear' Aerial Company (Warzone Mont'ka)");
//		formationen.add("");
//		formationen.add("The Armoured Shield (Start collecting)");//TODO The Armoured Shield (Start collecting) - Infantry Squad als eigene Einheit
//		Officio Prefect Commissar, 1 Infantry Squad, 1 Leman Russ

        kontingente.add("Cadian Battle Group (Warzone Mont'ka)"); //Superformation


        //Min/max-Auswahlen je Spezialkontingent
        minAuswahlen.put("The Steel Host (Sanctus Reach)", new int[]{1, 0, 0, 0, 4, 0, 0, 0});
        maxAuswahlen.put("The Steel Host (Sanctus Reach)", new int[]{1, 0, 0, 0, 4, 0, 0, 0});

        minAuswahlen.put("Rampart Detachment (Sanctus Reach)", new int[]{0, 2, 1, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Rampart Detachment (Sanctus Reach)", new int[]{0, 2, 1, 0, 0, 0, 0, 0});

        minAuswahlen.put("'Emperor's Shield' Infantry Platoon (Warzone Mont'ka)", new int[]{0, 0, 1, 1, 0, 0, 0, 0});
        maxAuswahlen.put("'Emperor's Shield' Infantry Platoon (Warzone Mont'ka)", new int[]{0, 0, 1, 3, 0, 0, 0, 0});

        minAuswahlen.put("'Emperor's Shield' Infantry Company (Warzone Mont'ka)", new int[]{1, 0, 3, 3, 0, 0, 0, 0});
        maxAuswahlen.put("'Emperor's Shield' Infantry Company (Warzone Mont'ka)", new int[]{1, 0, 3, 9, 0, 0, 0, 0});

        minAuswahlen.put("'Emperor's Talon' Recon Company (Warzone Mont'ka)", new int[]{0, 0, 0, 2, 0, 0, 0, 0});
        maxAuswahlen.put("'Emperor's Talon' Recon Company (Warzone Mont'ka)", new int[]{0, 0, 0, 4, 0, 0, 0, 0});

        minAuswahlen.put("'Emperor's Blade' Assault Company (Warzone Mont'ka)", new int[]{1, 0, 3, 1, 0, 0, 0, 0});
        maxAuswahlen.put("'Emperor's Blade' Assault Company (Warzone Mont'ka)", new int[]{1, 0, 3, 3, 0, 0, 0, 0});

        minAuswahlen.put("'Emperor's Wrath' Artillery Company (Warzone Mont'ka)", new int[]{2, 0, 0, 0, 3, 0, 0, 0});
        maxAuswahlen.put("'Emperor's Wrath' Artillery Company (Warzone Mont'ka)", new int[]{4, 0, 0, 0, 3, 0, 0, 0});

        minAuswahlen.put("'Emperor's Fist' Armoured Company (Warzone Mont'ka)", new int[]{2, 0, 0, 0, 3, 0, 0, 0});
        maxAuswahlen.put("'Emperor's Fist' Armoured Company (Warzone Mont'ka)", new int[]{4, 0, 0, 0, 3, 0, 0, 0});

        minAuswahlen.put("Ogryn Auxilia (Warzone Mont'ka)", new int[]{1, 4, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Ogryn Auxilia (Warzone Mont'ka)", new int[]{1, 4, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("Psykana Division (Warzone Mont'ka)", new int[]{2, 3, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Psykana Division (Warzone Mont'ka)", new int[]{4, 3, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("'Emperor's Fury' Super-Heavy Company (Warzone Mont'ka)", new int[]{1, 0, 0, 0, 0, 0, 3, 0});
        maxAuswahlen.put("'Emperor's Fury' Super-Heavy Company (Warzone Mont'ka)", new int[]{1, 0, 0, 0, 0, 0, 3, 0});

        minAuswahlen.put("'Emperor's Spear' Aerial Company (Warzone Mont'ka)", new int[]{0, 0, 0, 3, 0, 0, 0, 0});
        maxAuswahlen.put("'Emperor's Spear' Aerial Company (Warzone Mont'ka)", new int[]{0, 0, 0, 3, 0, 0, 0, 0});

        minAuswahlen.put("Cadian Battle Group (Warzone Mont'ka)", new int[]{0, 0, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Cadian Battle Group (Warzone Mont'ka)", new int[]{0, 0, 0, 0, 0, 0, 0, 0});

//		minAuswahlen.put("The Armoured Shield (Start collecting)",new int[]{1,0,1,0,1,0,0,0});
//		maxAuswahlen.put("The Armoured Shield (Start collecting)",new int[]{1,0,1,0,1,0,0,0});

        //TODO Cadian Detachment (all detachments without special characters Creed, Kell, Pask are allowed)

        complete();

        panel.add(Cadian);
        Cadian.addActionListener(cadianActionListener);
        Cadian.setBounds(710, 5, 130, 20);
        Cadian.setBackground(Color.WHITE);

    }

    public void changeFormations() {
        if (getCountFromInformationVector("Cadian Detachment") > 0) {

            formationBox.addItem("Battle Group Command (Warzone Mont'ka)");
            formationBox.addItem("Infantry Platoon (Warzone Mont'ka)");
            formationBox.addItem("Militarum Tempestus Platoon (Warzone Mont'ka)");
            formationBox.addItem("Super Heavy Element (Warzone Mont'ka)");

            minAuswahlen.put("Battle Group Command (Warzone Mont'ka)", new int[]{1, 0, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Battle Group Command (Warzone Mont'ka)", new int[]{2, 0, 0, 0, 0, 0, 0, 0});

            minAuswahlen.put("Infantry Platoon (Warzone Mont'ka)", new int[]{0, 0, 1, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Infantry Platoon (Warzone Mont'ka)", new int[]{0, 0, 1, 0, 0, 0, 0, 0});

            minAuswahlen.put("Militarum Tempestus Platoon (Warzone Mont'ka)", new int[]{0, 1, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Militarum Tempestus Platoon (Warzone Mont'ka)", new int[]{0, 1, 0, 0, 0, 0, 0, 0});

            minAuswahlen.put("Super Heavy Element (Warzone Mont'ka)", new int[]{0, 0, 0, 0, 0, 0, 1, 0});
            maxAuswahlen.put("Super Heavy Element (Warzone Mont'ka)", new int[]{0, 0, 0, 0, 0, 0, 1, 0});
        }
    }

    @Override
    public void volkRefresh() {
        setInformationVectorValue("TheSteelHost", 0);
        setInformationVectorValue("RampartDetachment", 0);
        setInformationVectorValue("AMTakesHQSlot", 0);
        setInformationVectorValue("AMNoCommissarWarning", 0);
        setInformationVectorValue("AMTauroxOrChimera", 0);
        setInformationVectorValue("'Emperor's Shield' Infantry Platoon (Warzone Mont'ka)", 0);
        setInformationVectorValue("'Emperor's Talon' Recon Company (Warzone Mont'ka)", 0);


        formationen.add("The Armoured Shield (Start collecting)");
		
		
		/*if(getKontingentTyp().equals("The Armoured Shield (Start collecting)")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"","Commissar"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
			
			if(!isLoading){
				addUnit(0,"Commissar");
				addUnit(0,"");
			}
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else */
        if (getKontingentTyp().equals("Cadian Battle Group (Warzone Mont'ka)")) { //Superformation))

            setInformationVectorValue("Cadian Detachment", 1);
            Cadian.setSelected(true);
            Cadian.setEnabled(false);

            superformation = new Superformation(getPanel(), 0);
            superformation.reflectionKennungLokal = reflectionKennungLokal;
            superformation.volkFile = getClass().getName();
            superformation.tA = buildatextArea;
            superformation.buildaVater = this;

            superformation.minCommand = 1;
            superformation.maxCommand = Integer.MAX_VALUE;
            superformation.minCore = 0;
            superformation.maxCore = 3;
            superformation.minAuxiliary = 0;
            superformation.maxAuxiliary = 3;

            superformation.multiplyerAuxiliaryByCore = true;
            superformation.multiplyerCoreByCommand = true;

            superformation.namenCommand.add("");
            superformation.namenCommand.add("Battle Group Command (Warzone Mont'ka)");

            superformation.namenCore.add("");
            superformation.namenCore.add("'Emperor's Shield' Infantry Company (Warzone Mont'ka)");
            superformation.namenCore.add("'Emperor's Fist' Armoured Company (Warzone Mont'ka)");

            superformation.namenAuxiliary.add("");
            superformation.namenAuxiliary.add("'Emperor's Shield' Infantry Platoon (Warzone Mont'ka)");
            superformation.namenAuxiliary.add("Infantry Platoon (Warzone Mont'ka)");
            superformation.namenAuxiliary.add("Super Heavy Element (Warzone Mont'ka)");
            superformation.namenAuxiliary.add("'Emperor's Fury' Super-Heavy Company (Warzone Mont'ka)");
            superformation.namenAuxiliary.add("'Emperor's Blade' Assault Company (Warzone Mont'ka)");
            superformation.namenAuxiliary.add("'Emperor's Spear' Aerial Company (Warzone Mont'ka)");
            superformation.namenAuxiliary.add("Ogryn Auxilia (Warzone Mont'ka)");
            superformation.namenAuxiliary.add("'Emperor's Wrath' Artillery Company (Warzone Mont'ka)");
            superformation.namenAuxiliary.add("'Emperor's Talon' Recon Company (Warzone Mont'ka)");
            superformation.namenAuxiliary.add("Psykana Division (Warzone Mont'ka)");
            superformation.namenAuxiliary.add("Militarum Tempestus Platoon (Warzone Mont'ka)");

            for (int i = 0; i < myChooserGruppen.size(); i++) {
                myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
            }

            superformation.refreshControlPanel();

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);

            RefreshListener.fireRefresh();
        } else if (getKontingentTyp().equals("Super Heavy Element (Warzone Mont'ka)")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{"", "[WZ Mont'ka] Baneblade", "[WZ Mont'ka] Banehammer", "[WZ Mont'ka] Banesword",
                    "[WZ Mont'ka] Doomhammer", "[WZ Mont'ka] Hellhammer",
                    "[WZ Mont'ka] Shadowsword", "[WZ Mont'ka] Stormlord", "[WZ Mont'ka] Stormsword"});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(6, "[WZ Mont'ka] Baneblade");
            }
            //			1 of the heavy tanks
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Militarum Tempestus Platoon (Warzone Mont'ka)")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Militarum Tempestus Platoon"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(1, "Militarum Tempestus Platoon");
                addUnit(1, "");
            }
            //			1 "Infantry Platoon"
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Infantry Platoon (Warzone Mont'ka)")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Infantry Platoon"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(2, "Infantry Platoon");
                addUnit(2, "");
            }
            //			1 "Infantry Platoon"
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Battle Group Command (Warzone Mont'ka)")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Company Command Squad", "Tank Commander Squadron", "Lord Commissar"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(0, "Company Command Squad");
            }
            //			1 Company command Squad (//TODO with Creed and Kell) or Tank Commander (or //TODO Pask)
            //			0-1 Lord Commissar
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("'Emperor's Spear' Aerial Company (Warzone Mont'ka)")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Valkyrie Squadron", "Vendetta Squadron"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(3, "Valkyrie Squadron");
                addUnitNotLocked(3, "Valkyrie Squadron");
                addUnitNotLocked(3, "Valkyrie Squadron");
            }
            //			3 of : Valkyrie, Vendetta
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("'Emperor's Fury' Super-Heavy Company (Warzone Mont'ka)")) {
            setInformationVectorValue("AMTakesHQSlot", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Enginseer"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{"", "[WZ Mont'ka] Baneblade", "[WZ Mont'ka] Banehammer", "[WZ Mont'ka] Banesword",
                    "[WZ Mont'ka] Doomhammer", "[WZ Mont'ka] Hellhammer",
                    "[WZ Mont'ka] Shadowsword", "[WZ Mont'ka] Stormlord", "[WZ Mont'ka] Stormsword"});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Enginseer");
                addUnit(0, "");
                addUnitNotLocked(6, "[WZ Mont'ka] Baneblade");
                addUnitNotLocked(6, "[WZ Mont'ka] Baneblade");
                addUnitNotLocked(6, "[WZ Mont'ka] Baneblade");
            }
            //			3 of the heavy tanks
            //			1 Enginseer
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Psykana Division (Warzone Mont'ka)")) {
            setInformationVectorValue("AMTakesHQSlot", 1);
            setInformationVectorValue("AMNoCommissarWarning", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Commissar", "Primaris Psyker"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Wyrdvane Psykers"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Primaris Psyker");
                addUnit(0, "Commissar");
                addUnit(1, "Wyrdvane Psykers");
                addUnit(1, "Wyrdvane Psykers");
                addUnit(1, "Wyrdvane Psykers");
                addUnit(1, "");
            }
            //			1 Primaris Psyker
            //			3 Wyrdvane Psykers
            //			1-3 Commissars
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Ogryn Auxilia (Warzone Mont'ka)")) {
            setInformationVectorValue("AMTakesHQSlot", 1);
            setInformationVectorValue("AMNoCommissarWarning", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Commissar"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Ogryns", "Bullgryns"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Commissar");
                addUnit(0, "");
                addUnit(1, "Ogryns");
                addUnit(1, "Ogryns");
                addUnit(1, "Bullgryns");
                addUnit(1, "Bullgryns");
                addUnit(1, "");
            }
            //			1 Commissar
            //			2 Ogryns
            //			2 Bullgryns
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("'Emperor's Fist' Armoured Company (Warzone Mont'ka)")) {
            setInformationVectorValue("AMTakesHQSlot", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Tank Commander Squadron", "Enginseer"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Veterans"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Leman Russ Squadron"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Tank Commander Squadron");
                addUnit(0, "Enginseer");
                addUnit(4, "Leman Russ Squadron");
                addUnit(4, "Leman Russ Squadron");
                addUnit(4, "Leman Russ Squadron");
                addUnit(4, "");
            }
            //			1 Tank Commander
            //			3 Leman Russ Squadrons
            //			1-3 Enginseers
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("'Emperor's Wrath' Artillery Company (Warzone Mont'ka)")) {
            setInformationVectorValue("AMTakesHQSlot", 1);
            setInformationVectorValue("AMTauroxOrChimera", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Company Command Squad", "Enginseer"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Veterans"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Hydra Battery", "Basilisk Battery", "Wyvern Battery", "Manticore", "Deathstrike"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Company Command Squad");
                addUnit(0, "Enginseer");
                addUnitNotLocked(4, "Basilisk Battery");
                addUnitNotLocked(4, "Basilisk Battery");
                addUnitNotLocked(4, "Manticore");
            }
            //			1 company command squad (taurox or chimera)
            //			2 of : Basilisk, Hydra, Wyvern
            //			1 of : Manticore, Deathstrike
            //			1-3 Enginseers
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("'Emperor's Blade' Assault Company (Warzone Mont'ka)")) {
            setInformationVectorValue("AMTauroxOrChimera", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Company Command Squad"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Veterans"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Hellhound Squadron"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Company Command Squad");
                addUnit(0, "");
                addUnit(2, "Veterans");
                addUnit(2, "Veterans");
                addUnit(2, "Veterans");
                addUnit(2, "");
                addUnitNotLocked(3, "Hellhound Squadron");
            }
            //			1 company command squad (taurox or chimera)
            //			3 veterans (taurox or chimera)
            //			1-3 Hellhound Squadron
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("'Emperor's Talon' Recon Company (Warzone Mont'ka)")) {
            setInformationVectorValue("'Emperor's Talon' Recon Company (Warzone Mont'ka)", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Scout Sentinel Squadron", "Armoured Sentinel Squadron"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(3, "Scout Sentinel Squadron");
                addUnitNotLocked(3, "Scout Sentinel Squadron");
            }
            //			2-4 of : Scout Sentinel Squadron, Armoured Sentinel Squadron (3 models each)
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("'Emperor's Shield' Infantry Company (Warzone Mont'ka)")) {
            setInformationVectorValue("'Emperor's Shield' Infantry Platoon (Warzone Mont'ka)", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Company Command Squad"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Infantry Platoon"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Scout Sentinel Squadron", "Armoured Sentinel Squadron"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Company Command Squad");
                addUnit(0, "");
                addUnit(2, "Infantry Platoon");
                addUnit(2, "Infantry Platoon");
                addUnit(2, "Infantry Platoon");
                addUnit(2, "");
                addUnitNotLocked(3, "Scout Sentinel Squadron");
                addUnitNotLocked(3, "Scout Sentinel Squadron");
                addUnitNotLocked(3, "Scout Sentinel Squadron");
            }
            //			1 company command squad
            //			3 emperor's shield infantry platoons // aufschlüsseln 3 infantry platoons 3-9 sentinels
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("'Emperor's Shield' Infantry Platoon (Warzone Mont'ka)")) {
            setInformationVectorValue("'Emperor's Shield' Infantry Platoon (Warzone Mont'ka)", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Infantry Platoon"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Scout Sentinel Squadron", "Armoured Sentinel Squadron"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(2, "Infantry Platoon");
                addUnit(2, "");
                addUnitNotLocked(3, "Scout Sentinel Squadron");
            }
            //			1 infantry platoon (5+ Inf. Sqads, no trans)
            //			1-3 of : Scout Sentinel Squadron, Armoured Sentinel Squadron
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("The Steel Host (Sanctus Reach)")) {
            setInformationVectorValue("TheSteelHost", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Tank Commander Squadron"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Leman Russ Squadron", "Hydra Battery"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Tank Commander Squadron");//Nur Tank Commander
                addUnit(4, "Leman Russ Squadron");
                addUnit(4, "Leman Russ Squadron");
                addUnit(4, "Leman Russ Squadron");
                addUnit(4, "Hydra Battery");//Nur 1 Hydra
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Rampart Detachment (Sanctus Reach)")) {
            setInformationVectorValue("RampartDetachment", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Bullgryns"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Infantry Platoon"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(1, "Bullgryns");
                addUnit(1, "Bullgryns");
                addUnit(2, "Infantry Platoon"); // Nur Platoon Command Suad
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        }

        fillChooserSpace();
    }

    public void hideVolkCheckboxes() {
        if (getCountFromInformationVector("Cadian Detachment") > 0) {
            Cadian.doClick();
        }
        Cadian.setVisible(false);
    }
}
