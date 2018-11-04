package oc.wh40k.armies;

import oc.*;

public class VOLKGatheringStormI extends BuildaVater {

    public VOLKGatheringStormI() {
        reflectionKennung = "";

        HQeinträge = new String[]{"", ""};
        Eliteeinträge = new String[]{"", ""};
        Standardeinträge = new String[]{"", ""};
        Sturmeinträge = new String[]{"", ""};
        Unterstützungeinträge = new String[]{"", ""};
        LordofWar = new String[]{"", ""};
//        Formationen = new String[] {"", ""};

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

        nameDerArtDerArmee = "Imperial Forces";
        nameDerArtDerArmeeDekliniert = "Imperial Forces";
        textAreaUeberschrift = BuildaHQ.translate("Meine") + " Imperial Forces";
        volk = "Imperial Forces";

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

        kontingente.add("");
        kontingente.add("Grand Convocation Detachement");
        kontingente.add("Castellans Of The Imperium");
        kontingente.add("Conclave Aquisitorius");

        formationen.add("");
        formationen.add("Triumvirate Of The Imperium");
        formationen.add("Wrathful Crusade");

        minAuswahlen.put("Triumvirate Of The Imperium", new int[]{3, 0, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Triumvirate Of The Imperium", new int[]{3, 0, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("Wrathful Crusade", new int[]{3, 1, 2, 1, 0, 0, 0, 0});
        maxAuswahlen.put("Wrathful Crusade", new int[]{3, 2, 4, 2, 0, 0, 0, 0});

        minAuswahlen.put("Grand Convocation Detachement", new int[]{2, 0, 4, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Grand Convocation Detachement", new int[]{4, 6, 99, 6, 6, 0, 3, 0});

        minAuswahlen.put("Castellans Of The Imperium", new int[]{2, 0, 4, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Castellans Of The Imperium", new int[]{2, 6, 99, 6, 6, 0, 3, 0});

        minAuswahlen.put("Conclave Aquisitorius", new int[]{0, 0, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Conclave Aquisitorius", new int[]{0, 0, 0, 0, 0, 0, 0, 0});

        complete();

        //TODO: Ecclesiarchy Relics - Gathering Storm
        //Alle, die Celestine enthalten, und alle in "Castellans of the Imps" und "Wrathful Crusade"
        //Skull of Petronella the Pious - 30
        //Blade of the Worthy - 30 //replaces a melee weapon
        //Castigator - 15
        //The Font of Fury - 10
        //Shroud of the Anti-Martyr - 35
        //Desvalles's Holy Circle - 35

//		formationBox.addItem("");
    }

    @Override
    public void refreshSupplements() {
    }

    public void changeFormations() {
        if (getCountFromInformationVector("Conclave Aquisitorius") > 0) {
            formationBox.addItem("Belisarius Cawl");

            minAuswahlen.put("Belisarius Cawl", new int[]{1, 0, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Belisarius Cawl", new int[]{1, 0, 0, 0, 0, 0, 0, 0});
        }
    }

    @Override
    public void volkRefresh() {

        if (getKontingentTyp().equals("Conclave Aquisitorius")) { //Superformation))
            setInformationVectorValue("Conclave Aquisitorius", 1);
            addToInformationVector("ArcanaMechanicum", 1);
            superformation = new Superformation(getPanel(), 1);
            superformation.reflectionKennungLokal = reflectionKennungLokal;
            superformation.volkFile = getClass().getName();
            superformation.tA = buildatextArea;
            superformation.buildaVater = this;

//			TODO: SPECIAL RULES:
//				- Canticles of the Omnissiah (pg 121)
//				Armoury of the Archmagos: During army selection, each Character from a Conclave Acquisitorius may upgrade one of their weapons (including one purchased as an upgrade, but not including a relic or equivalent) to have the Master-crafted special rule.
//				Synchronised Data Network: If the Conclave Acquisitorius contains the maximum number of units, then all units in this Formation gain the Doctrina Imperatives special rule (see Codex: Skitarii)

            superformation.createKategorieDynamisch(1, 1);
            superformation.addEintragDynamisch("", "");
            superformation.addEintragDynamisch("", "Belisarius Cawl"); //1

            superformation.createKategorieDynamisch(1, 2);
            superformation.addEintragDynamisch("", "");
            superformation.addEintragDynamisch("SK", "Battle Maniple"); //(1-2)
            superformation.addEintragDynamisch("SK", "War Cohort");        //oder 1 //TODO Gewichtung für Formationen auswerten

            superformation.createKategorieDynamisch(1, 1);
            superformation.addEintragDynamisch("", "");
            superformation.addEintragDynamisch("CU", "Holy Requisitioner"); //(1)

            superformation.createKategorieDynamisch(0, 1);
            superformation.addEintragDynamisch("", "");
            superformation.addEintragDynamisch("CU", "Cohort Cybernetica"); //(0-1)

            superformation.createKategorieDynamisch(0, 1);
            superformation.addEintragDynamisch("", "");
            superformation.addEintragDynamisch("CU", "Numinous Conclave"); //(0-1)

            superformation.createKategorieDynamisch(0, 1);
            superformation.addEintragDynamisch("", "");
            superformation.addEintragDynamisch("IR", "Imperial Knights"); //(1-2)
            superformation.addEintragDynamisch("IR", "Baronial Court"); //oder 1 //TODO Gewichtung für Formationen auswerten


            for (int i = 0; i < myChooserGruppen.size(); i++) {
                myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
            }

            superformation.refreshControlPanel();

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);

            RefreshListener.fireRefresh();
        } else if (getKontingentTyp().equals("Belisarius Cawl")) {

            clearCombo();

            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Belisarius Cawl"});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"Belisarius Cawl"}, 1, 1));

            if (!isLoading) {
                addUnit(0, "Belisarius Cawl");
            }

        } else if (getKontingentTyp().equals("Grand Convocation Detachement")) { //Superformation))

            addToInformationVector("Grand Convocation Detachement", 1);
            addToInformationVector("ArcanaMechanicum", 1);

            clearCombo();

            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Belisarius Cawl", "AM Enginseer", "IA Tech Priest Enginseer", "CU Tech-Priest Dominus"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "CU Corpuscarii Electro Priests", "CU Fulgurite Electro Priests", "SK Sicarian Infiltrators", "SK Sicarian Ruststalkers"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "CU Kataphron Breachers", "CU Kataphron Destroyers", "SK Skitarii Rangers", "SK Skitarii Vanguard"});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "SK Sydonian Dragoons"});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "CU Kastelan Robot Maniple", "SK Ironstrider Ballistarii", "SK Onager Dunecrawlers"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{"", "IR Knight Crusader", "IR Knight Errant", "IR Knight Gallant", "IR Knight Paladin", "IR Knight Warden"});

            if (!isLoading) {
            }

        } else if (getKontingentTyp().equals("Castellans Of The Imperium")) { //Superformation))

            addToInformationVector("Castellans Of The Imperium", 1);
            addToInformationVector("EcclesiarchyRelics", 1);

            clearCombo();

            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Inquisitor Greyfax", "Celestine", "Terminator Captain", "",
                    "AM Commissar", "AM Commissar Yarrik", "AM Company Command Squad", "AM Enginseer", "AM Tank Commander Squadron", "AM Lord Commissar", "AM Ministorum Priest", "AM Primaris Psyker", "", "MT Commissar", "MT Militarum Tempestus CommandSquad", "",
                    "IA Tech Priest Enginseer", "IA Ministorum Priest", "IA Primaris Psyker", "IA Canoness", "IA Sororitas Command Squad", "IA Uriah Jacobus", "IA Inquisitor Coteaz", "IA Inquisitor Karamazov", "IA Ordo Malleus Inquisitor", "IA Ordo Hereticus Inquisitor", "IA Ordo Xenos Inquisitor", "",
                    "AS Ministorum Priest", "AS Principalis", "AS Ekklesiarchie KampfKonklave", "AS Kommandotrupp", "AS Uriah Jacobus", "",
                    "IN Inquisitor des Ordo Malleus", "IN Inquisitor des Ordo Hereticus", "IN Inquisitor des Ordo Xenos", "IN Inquisitor Coteaz", "IN Inquisitor Karamasov", "",
                    "SM Captain", "SM Chaplain", "SM Chaplain Grimaldus", "SM The Emperor's Champion", "SM High Marshal Helbrecht", "SM Librarian", "SM Techmarine"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "IA Vindicare Assassin", "IA Callidus Assassin", "IA Eversor Assassin", "IA Culexus Assassin", "IA Repentiatrupp", "IA Celestian Squad", "",
                    "AM Ogryns", "AM Bullgryns", "AM Ratlings", "AM Wyrdvane Psykers", "AM Militarum Tempestus Platoon", "",
                    "AS Celestiatrupp", "AS Repentiatrupp", "",
                    "IN Gefolge des Inquisitors", "",
                    "SM Cataphractii Terminator Squad", "SM Command Squad", "SM Honour Guard", "SM Centurion Assault Squad", "SM Vanguard Veteran Squad", "SM Sternguard Veteran Squad",
                    "SM Dreadnoughts", "SM Venerable Dreadnoughts", "SM Ironclad Dreadnoughts", "SM Terminator Squad", "SM Terminator Assault Squad"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "AM Infantry Platoon", "AM Veterans", "",
                    "IA Battle Sisters Squad", "",
                    "AS Sororitastrupp", "",
                    "MT Militarum Tempestus Scions", "",
                    "SM Crusader Squad", "SM Scout Squad", "SM Tactical Squad"});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "AM Scout Sentinel Squadron", "AM Armoured Sentinel Squadron", "AM Rough Riders", "AM Hellhound Squadron", "AM Valkyrie Squadron", "AM Vendetta Squadron", "",
                    "MT Valkyrie Squadron", "MT Taurox Prime", "",
                    "AS Seraphimtrupp", "AS Dominatortrupp", "",
                    "IA Dominion Squad", "IA Seraphim Squad", "",
                    "SM Assault Squad", "SM Scout Bike Squad", "SM Bike Squad", "SM Attack Bike Squad", "SM Land Speeders", "SM Land Speeder Storm", "SM Rhino", "SM Razorback", "SM Drop Pod", "SM Stormtalon Gunship"
            });
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "AM Leman Russ Squadron", "AM Hydra Battery", "AM Basilisk Battery", "AM Wyvern Battery", "AM Manticore", "AM Deathstrike", "",
                    "AS Exorzist", "AS Läuterer", "AS Retributortrupp", "",
                    "IA Retributor Squad", "IA Exorcist", "IA Penitent Engines", "",
                    "SM Contemptor Dreadnought", "SM Devastator Squad", "SM Centurion Devastator Squad", "SM Thunderfire-Cannons", "SM Predators",
                    "SM Whirlwinds", "SM Vindicators", "SM Hunters", "SM Stalkers", "SM Stormraven Gunship", "SM Land Raider",
                    "SM Land Raider Crusader", "SM Land Raider Redeemer"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{"", "IR Knight Crusader", "IR Knight Errant", "IR Knight Gallant", "IR Knight Paladin", "IR Knight Warden", "",
                    "APO [WZ Mont'ka] Baneblade", "APO [WZ Mont'ka] Banehammer", "APO [WZ Mont'ka] Banesword", "APO [WZ Mont'ka] Doomhammer", "APO [WZ Mont'ka] Hellhammer", "APO [WZ Mont'ka] Shadowsword", "APO [WZ Mont'ka] Stormlord", "APO [WZ Mont'ka] Stormsword"});

            if (!isLoading) {
            }

        } else if (getKontingentTyp().equals("Triumvirate Of The Imperium")) {
            addToInformationVector("Triumvirate Of The Imperium", 1);

            clearCombo();

            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Belisarius Cawl", "Celestine", "Inquisitor Greyfax"});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"Belisarius Cawl"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"Celestine"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"Inquisitor Greyfax"}, 1, 1));

            if (!isLoading) {
                addUnit(0, "Belisarius Cawl");
                addUnit(0, "Celestine");
                addUnit(0, "Inquisitor Greyfax");
            }

        } else if (getKontingentTyp().equals("Wrathful Crusade")) {
            addToInformationVector("Wrathful Crusade", 1);
            addToInformationVector("EcclesiarchyRelics", 1);
            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Celestine", "Inquisitor Greyfax", "SM Captain"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "SM Sternguard Veteran Squad", "AM Militarum Tempestus Platoon"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "SM Crusader Squad"});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "SM Assault Squad"});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"Celestine"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"Inquisitor Greyfax"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"SM Captain"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"SM Sternguard Veteran Squad"}, 0, 1));
            formation.entries.add(new FormationEntry(new String[]{"SM Crusader Squad"}, 2, 4));
            formation.entries.add(new FormationEntry(new String[]{"SM Assault Squad"}, 1, 2));
            formation.entries.add(new FormationEntry(new String[]{"AM Militarum Tempestus Platoon"}, 1, 1));

            if (!isLoading) {
                addUnit(0, "Celestine");
                addUnit(0, "Inquisitor Greyfax");
                addUnit(0, "SM Captain");
                addUnit(2, "SM Crusader Squad");
                addUnit(2, "SM Crusader Squad");
                addUnit(3, "SM Assault Squad");
                addUnit(1, "AM Militarum Tempestus Platoon");
            }

            supplementBox.setEnabled(false);
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        }

        if (formation != null) {
            formation.refreshControlPanel();
        }

        fillChooserSpace();
    }

    @Override
    protected void finalize() {
        System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
    }

}