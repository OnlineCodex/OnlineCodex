package oc.wh40k.armies;


import oc.*;

public class VOLKDarkAngels extends BuildaVater {

    public VOLKDarkAngels() {

        reflectionKennung = "DA";

        HQeinträge = new String[]{"", "Belial", "Sammael", "Sableclaw", "Interrogator-Chaplain", "Asmodai", "Librarian", "Ezekiel", "Company Master", "Chaplain", "Techmarine", "Seraphicus", "",
                "Belisarius Cawl", "Celestine", "Inquisitor Greyfax",
                "", "[IA2 2nd Ed] Damocles Command Vehicle",
                "", "[Forgeworld] Damocles Rhino"};
        Eliteeinträge = new String[]{"", "Company Veterans Squad", "Command Squad", "Dreadnoughts", "Venerable Dreadnoughts", "Deathwing Terminator Squad", "Deathwing Command Squad", "Deathwing Knights",
                "Ravenwing Command Squad",
                "", "[IA2 2nd Ed] Land Raider Prometheus", "[IA 2nd Ed] Contemptor Mortis Pattern Dreadnought", "[IA2 2nd Ed] Chaplain Dreadnought",
                "[IA2 2nd Ed] Contemptor Dreadnought", "[IA2 2nd Ed] Siege Dreadnought", "[IA2 2nd Ed] Mark V Mortis Pattern Dreadnought"};
        Standardeinträge = new String[]{"", "Tactical Squad", "Scout Squad"};
        Sturmeinträge = new String[]{"", "Rhino", "Razorback", "Drop Pod", "Assault Squad", "Ravenwing Bike Squad", "Ravenwing Attack Bike Squad", "Ravenwing Land Speeders", "Ravenwing Darkshroud", "Nephilim Jetfighter", "Ravenwing Dark Talon", "Ravenwing Black Knights",
                "", "[IA2 2nd Ed] Caestus Assault Ram", "[IA2 2nd Ed] Land Speeder Tempest Squadron", "[IA2 2nd Ed] Javelin Attack Speeder",
                "", "[IA Experimental] Xiphon Pattern Interceptor"};
        Unterstützungeinträge = new String[]{"", "Ravenwing Land Speeder Vengeance", "Devastor Squad", "Predators", "Whirlwinds", "Vindicators", "Land Raider", "Land Raider Crusader", "Land Raider Redeemer",
                "", "[IA Experimental] Quad Mortar Support Battery",
                "", "[FW online] Deimos Pattern Vindicator Tank Destroyer",
                "", "[IA2 2nd Ed] Land Raider Helios", "[IA2 2nd Ed] Land Raider Proteus", "[IA2 2nd Ed] Land Raider Achilles",
                "[IA2 2nd Ed] Deimos Predator", "[IA2 2nd Ed] Relic Sicaran Battle Tank", "[IA2 2nd Ed] Whirlwind Hyperios",
                "[IA2 2nd Ed] Relic Whirlwind Scorpius", "[IA2 2nd Ed] Spartan Assault Tank", "[IA2 2nd Ed] Storm Eagle",
                "[IA2 2nd Ed] Tarantula-Batterie", "[IA2 2nd Ed] Rapier Carrier Battery", "[IA2 2nd Ed] Deathstorm Drop Pod",
                "", "[IA12] SentryGunBattery", "[IA12] Predator Infernus", "[IA2 2nd Ed] Fire Raptor Gunship"};
        LordofWar = new String[]{"", "Azrael", "[APO2 Armageddon] Reaver Battle Titan", "[APO2 Armageddon] Warhound-Scouttitan",
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

        nameDerArtDerArmee = "Dark Angels";
        nameDerArtDerArmeeDekliniert = "Dark Angels";
        textAreaUeberschrift = BuildaHQ.translate("Meine") + " Dark Angels";

        noAllies.clear();
        noAllies.add("DA");

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

        //Kontingente
        kontingente.add("Lion's Blade Strike Force"); //Superformtaion
        kontingente.add("Deathwing Strike Force");
        kontingente.add("Ravenwing Strike Force");

        //Formationen
        formationen.add("Deathwing Redemption Force [APO2]");
        formationen.add("Ravenwing Huntmasters [APO2]");

        minAuswahlen.put("Deathwing Redemption Force [APO2]", new int[]{1, 10, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Deathwing Redemption Force [APO2]", new int[]{1, 10, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("Ravenwing Huntmasters [APO2]", new int[]{0, 0, 0, 5, 0, 0, 0, 0});
        maxAuswahlen.put("Ravenwing Huntmasters [APO2]", new int[]{0, 0, 0, 99, 0, 0, 0, 0});

        //Formationen
        formationen.add("Battle Demi-Company");
        formationen.add("Deathwing Redemption Force");
        formationen.add("Ravenwing Attack Squadron");
        formationen.add("Ravenwing Support Squadron");
        formationen.add("Ravenwing Silence Squadron");
        formationen.add("The Hammer of Caliban");
        formationen.add("Inner Circle");
        formationen.add("");
        formationen.add("Librarius Conclave (e-book)");

        //Min/max-Auswahlen je Spezialkontingent/Formation
        minAuswahlen.put("Battle Demi-Company", new int[]{1, 0, 3, 1, 1, 0, 0, 0});
        maxAuswahlen.put("Battle Demi-Company", new int[]{1, 3, 3, 1, 1, 0, 0, 0});

        minAuswahlen.put("Deathwing Redemption Force", new int[]{1, 2, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Deathwing Redemption Force", new int[]{1, 8, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("Ravenwing Attack Squadron", new int[]{0, 0, 0, 2, 0, 0, 0, 0});
        maxAuswahlen.put("Ravenwing Attack Squadron", new int[]{0, 0, 0, 2, 0, 0, 0, 0});

        minAuswahlen.put("Ravenwing Support Squadron", new int[]{0, 0, 0, 2, 0, 0, 0, 0});
        maxAuswahlen.put("Ravenwing Support Squadron", new int[]{0, 0, 0, 2, 0, 0, 0, 0});

        minAuswahlen.put("Ravenwing Silence Squadron", new int[]{0, 0, 0, 3, 0, 0, 0, 0});
        maxAuswahlen.put("Ravenwing Silence Squadron", new int[]{0, 0, 0, 3, 0, 0, 0, 0});

        minAuswahlen.put("The Hammer of Caliban", new int[]{1, 0, 0, 0, 2, 0, 0, 0});
        maxAuswahlen.put("The Hammer of Caliban", new int[]{1, 0, 0, 0, 2, 0, 0, 0});

        minAuswahlen.put("Inner Circle", new int[]{0, 0, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Inner Circle", new int[]{1, 0, 0, 0, 0, 0, 1, 0});

        minAuswahlen.put("Deathwing Strike Force", new int[]{1, 2, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Deathwing Strike Force", new int[]{3, 10, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("Ravenwing Strike Force", new int[]{1, 0, 0, 2, 0, 0, 0, 0});
        maxAuswahlen.put("Ravenwing Strike Force", new int[]{3, 1, 0, 10, 3, 0, 0, 0});

        minAuswahlen.put("Librarius Conclave (e-book)", new int[]{3, 0, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Librarius Conclave (e-book)", new int[]{5, 0, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("Lion's Blade Strike Force", new int[]{0, 0, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Lion's Blade Strike Force", new int[]{0, 0, 0, 0, 0, 0, 0, 0});

        complete();
    }

    public void changeFormations() {
        if (getCountFromInformationVector("Lion's Blade Strike Force") > 0) {
            formationen.add("Battle Company");
            formationen.add("10th Company Support");

            minAuswahlen.put("Battle Company", new int[]{2, 0, 6, 2, 2, 0, 0, 0});
            maxAuswahlen.put("Battle Company", new int[]{2, 4, 6, 2, 2, 0, 0, 0});

            minAuswahlen.put("10th Company Support", new int[]{0, 0, 1, 0, 0, 0, 0, 0});
            maxAuswahlen.put("10th Company Support", new int[]{0, 0, 5, 0, 0, 0, 0, 0});
        }
    }

    @Override
    public void volkRefresh() {
        setInformationVectorValue("Ravenwing Huntmasters", 0);
        setInformationVectorValue("Battle Demi-Company", 0);
        setInformationVectorValue("Deathwing Redemption Force", 0);
        setInformationVectorValue("Strike Force Ultra", 0);
        setInformationVectorValue("Reclusiam Command Squad", 0);
        setInformationVectorValue("Librarius Conclave", 0);
        setInformationVectorValue("Centurion Siegebreaker Cohort", 0);
        setInformationVectorValue("10th Company Task Force", 0);
        setInformationVectorValue("Strike Force Command", 0);
        setInformationVectorValue("Armoured Task Force", 0);
        setInformationVectorValue("Skyhammer Annihilation Force (Webstore)", 0);
        setInformationVectorValue("Battle Company", 0);


        if (getKontingentTyp().equals("Lion's Blade Strike Force")) { //Superformation))
            setInformationVectorValue("Lion's Blade Strike Force", 1);
            superformation = new Superformation(getPanel(), 0);
            superformation.reflectionKennungLokal = reflectionKennungLokal;
            superformation.volkFile = getClass().getName();
            superformation.tA = buildatextArea;
            superformation.buildaVater = this;

            superformation.minCommand = 0;
            superformation.maxCommand = 1;
            superformation.minCore = 1;
            superformation.maxCore = Integer.MAX_VALUE;
            superformation.minAuxiliary = 1;
            superformation.maxAuxiliary = Integer.MAX_VALUE;
            ;
            superformation.multiplyerCommandByCore = true;// 0-1 per Core

            superformation.namenCommand.add("");
            superformation.namenCommand.add("Inner Circle");

            superformation.namenCore.add("");
            superformation.namenCore.add("Battle Demi-Company");
            superformation.namenCore.add("Battle Company"); //counts as 2 //Nur in Superformation

            superformation.namenAuxiliary.add("");
            superformation.namenAuxiliary.add("The Hammer of Caliban");
            superformation.namenAuxiliary.add("Deathwing Redemption Force");
            superformation.namenAuxiliary.add("10th Company Support"); //Nur in Superformation?
            superformation.namenAuxiliary.add("Ravenwing Silence Squadron");
            superformation.namenAuxiliary.add("Ravenwing Attack Squadron");
            superformation.namenAuxiliary.add("Ravenwing Support Squadron");

            for (int i = 0; i < myChooserGruppen.size(); i++) {
                myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
            }

            superformation.refreshControlPanel();

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);

            RefreshListener.fireRefresh();
        }

        if (getKontingentTyp().equals("Librarius Conclave (e-book)")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Ezekiel", "Librarian"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"Ezekiel"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"Librarian"}, 2, 4));

            if (!isLoading) {
                addUnitNotLocked(0, "Ezekiel");
                addUnitNotLocked(0, "Librarian");
                addUnitNotLocked(0, "Librarian");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Deathwing Redemption Force [APO2]")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Belial"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Deathwing-Terminatortrupp", "Deathwing Ritter"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Belial");
                addUnit(0, "");
                addUnit(1, "Deathwing-Terminatortrupp");
                addUnit(1, "Deathwing-Terminatortrupp");
                addUnit(1, "Deathwing-Terminatortrupp");
                addUnit(1, "Deathwing-Terminatortrupp");
                addUnit(1, "Deathwing-Terminatortrupp");
                addUnit(1, "Deathwing-Terminatortrupp");
                addUnit(1, "Deathwing Ritter");
                addUnit(1, "Deathwing Ritter");
                addUnit(1, "Deathwing Ritter");
                addUnit(1, "Deathwing Ritter");
                addUnit(1, "");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Ravenwing Huntmasters [APO2]")) {
            setInformationVectorValue("Ravenwing Huntmasters", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Schwarze Ritter Des Ravenwing", "Ravenwing-Angriffsschwadron", "Landspeeder Darkshroud"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(3, "Schwarze Ritter Des Ravenwing");
                addUnit(3, "Ravenwing-Angriffsschwadron");
                addUnit(3, "Ravenwing-Angriffsschwadron");
                addUnit(3, "Ravenwing-Angriffsschwadron");
                addUnit(3, "Landspeeder Darkshroud");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Battle Company")) {
            setInformationVectorValue("Battle Company", 1);

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Company Master", "Chaplain"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Command Squad", "Dreadnoughts", "Company Veterans Squad"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Tactical Squad"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Assault Squad"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Devastor Squad"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"Company Master"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"Chaplain"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"Command Squad"}, 0, 2));
            formation.entries.add(new FormationEntry(new String[]{"Company Veterans Squad"}, 0, 2));
            formation.entries.add(new FormationEntry(new String[]{"Tactical Squad"}, 6, 6));
            formation.entries.add(new FormationEntry(new String[]{"Assault Squad"}, 2, 2));
            formation.entries.add(new FormationEntry(new String[]{"Devastor Squad"}, 2, 2));
            formation.entries.add(new FormationEntry(new String[]{"Dreadnoughts"}, 0, 2));
            fcount = 2;
            formation.infoLabel.setText("<html>Info:<br>"
                    + "Diese Formation ist die Kombination aus 2 Battle Demi-Companies.<html>");

            if (!isLoading) {
                addUnitNotLocked(0, "Company Master");
                addUnitNotLocked(0, "Chaplain");
                addUnitNotLocked(2, "Tactical Squad");
                addUnitNotLocked(2, "Tactical Squad");
                addUnitNotLocked(2, "Tactical Squad");
                addUnitNotLocked(2, "Tactical Squad");
                addUnitNotLocked(2, "Tactical Squad");
                addUnitNotLocked(2, "Tactical Squad");
                addUnitNotLocked(3, "Assault Squad");
                addUnitNotLocked(3, "Assault Squad");
                addUnitNotLocked(4, "Devastor Squad");
                addUnitNotLocked(4, "Devastor Squad");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("10th Company Support")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Scout Squad"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(2, "Scout Squad");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Inner Circle")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Belial", "Sammael", "Sableclaw", "Company Master", "Interrogator Chaplain", "Asmodai", "Librarian", "Ezekiel"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{"", "Azrael"});
            if (!isLoading) {
                addUnitNotLocked(0, "Belial");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("The Hammer of Caliban")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Techmarine"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Land Raider", "Land Raider Redeemer", "Land Raider Crusader", "Predators", "Whirlwinds", "Vindicators"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Techmarine");
                addUnitNotLocked(4, "Land Raider");
                addUnitNotLocked(4, "Predators");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Ravenwing Silence Squadron")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Nephilim Jetfighter", "Ravenwing Dark Talon"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(3, "Nephilim Jetfighter");
                addUnit(3, "Nephilim Jetfighter");
                addUnit(3, "Ravenwing Dark Talon");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Ravenwing Support Squadron")) {
            setInformationVectorValue("Ravenwing Support Squadron", 1);

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Ravenwing Land Speeders", "Ravenwing Land Speeder Vengeance", "Ravenwing Darkshroud"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(3, "Ravenwing Land Speeders");
                addUnitNotLocked(3, "Ravenwing Land Speeder Vengeance");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Ravenwing Attack Squadron")) {
            setInformationVectorValue("Ravenwing Attack Squadron", 1);

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});//Captain must have Termi
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Ravenwing Bike Squad", "Ravenwing Attack Bike Squad", "Ravenwing Land Speeders", "Ravenwing Land Speeder Vengeance"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(3, "Ravenwing Bike Squad");
                addUnitNotLocked(3, "Ravenwing Land Speeders");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Battle Demi-Company")) {
            setInformationVectorValue("Battle Demi-Company", 1);

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Company Master", "Chaplain"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Command Squad", "Dreadnoughts", "Company Veterans Squad"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Tactical Squad"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Assault Squad"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Devastor Squad"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"Company Master", "Chaplain"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"Command Squad"}, 0, 1));
            formation.entries.add(new FormationEntry(new String[]{"Company Veterans Squad"}, 0, 1));
            formation.entries.add(new FormationEntry(new String[]{"Tactical Squad"}, 3, 3));
            formation.entries.add(new FormationEntry(new String[]{"Assault Squad"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"Devastor Squad"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"Dreadnoughts"}, 0, 1));

            if (!isLoading) {
                addUnitNotLocked(0, "Company Master");
                addUnitNotLocked(2, "Tactical Squad");
                addUnitNotLocked(2, "Tactical Squad");
                addUnitNotLocked(2, "Tactical Squad");
                addUnitNotLocked(3, "Assault Squad");
                addUnitNotLocked(4, "Devastor Squad");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Deathwing Redemption Force")) {
            setInformationVectorValue("Deathwing Redemption Force", 1);

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Belial", "Company Master", "Interrogator-Chaplain", "Librarian"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Deathwing Terminator Squad", "Deathwing Command Squad", "Deathwing Knights", "Venerable Dreadnoughts"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(0, "Belial");
                addUnit(1, "Deathwing Terminator Squad");
                addUnit(1, "Deathwing Terminator Squad");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Deathwing Strike Force")) {
            setInformationVectorValue("Deathwing Redemption Force", 1);

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Belial", "Asmodai", "Ezekiel", "Company Master", "Interrogator-Chaplain", "Librarian"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Deathwing Terminator Squad", "Deathwing Command Squad", "Deathwing Knights", "Venerable Dreadnoughts"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(0, "Belial");
                addUnitNotLocked(1, "Deathwing Terminator Squad");
                addUnitNotLocked(1, "Deathwing Terminator Squad");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Ravenwing Strike Force")) {
            setInformationVectorValue("Ravenwing Strike Force", 1);

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Sammael", "Sableclaw", "Company Master", "Interrogator-Chaplain", "Librarian", "Chaplain"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Ravenwing Command Squad"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Ravenwing Bike Squad", "Ravenwing Attack Bike Squad", "Ravenwing Land Speeders", "Ravenwing Darkshroud", "Nephilim Jetfighter", "Ravenwing Dark Talon", "Ravenwing Black Knights"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Ravenwing Land Speeder Vengeance"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(0, "Sammael");
                addUnitNotLocked(3, "Ravenwing Bike Squad");
                addUnitNotLocked(3, "Ravenwing Bike Squad");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        }

        if (formation != null) {
            formation.refreshControlPanel();
        }

        fillChooserSpace();
    }
}