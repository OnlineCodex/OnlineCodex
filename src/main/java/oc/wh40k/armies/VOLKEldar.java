package oc.wh40k.armies;

import oc.*;

public class VOLKEldar extends BuildaVater {

    public VOLKEldar() {
        reflectionKennung = "EL";

        HQeinträge = new String[]{"", "Eldrad Ulthran", "Prince Yriel", "Illic Nightspear", "Asurmen", "Jain Zar", "Karandras", "Fuegan", "Baharroth", "Maugan Ra",
                "", "Autarch", "Farseer", "Warlock Conclave", "Spiritseer",
                "", "[IA11 2nd Ed] Wraithseer", "[IA11 2nd Ed] Irillyth", "[IA11 2nd Ed] Bel-Annath",
                "", "[Iyanden] Spiritseers"};
        Eliteeinträge = new String[]{"", "Howling Banshees", "Striking Scorpions", "Fire Dragons", "Wraithguard", "Wraithblades"};
        Standardeinträge = new String[]{"", "Guardian Defenders", "Storm Guardians", "Windriders", "Rangers", "Dire Avengers"};
        Sturmeinträge = new String[]{"", "Wave Serpent", "Swooping Hawks", "Warp Spiders", "Shining Spears", "Crimson Hunter", "Vyper Squadron", "Hemlock Wraithfigther",
                "", "[IA11 2nd Ed] Shadow Spectres", "[IA11 2nd Ed] Wasp Assault Walker Squadron", "[IA11 2nd Ed] Hornet Squadron",
                "[IA11 2nd Ed] Nightwing", "[IA11 2nd Ed] Phoenix Bomber"};
        Unterstützungeinträge = new String[]{
                "", "Dark Reapers", "Vauls Wrath Support Battery", "Falcons", "Fire Prisms", "Night Spinners", "War Walkers", "Wraithlord",
                "", "[IA11 2nd Ed] Warp Hunter", "[IA11 2nd Ed] Lynx",
                "", "[Forgeworld] Fire Storm", "[Forgeworld] Night Spinner"
        };
        LordofWar = new String[]{"", "Wraithknight", "Avatar of Khaine", "The Yncarne", "",
                "", "[IA11 2nd Ed] Skathach Wraithknight", "[IA11 2nd Ed] Revenant Titan", "[IA11 2nd Ed] Phantom Titan",
                "[IA11 2nd Ed] Vampire Raider", "[IA11 2nd Ed] Cobra", "[IA11 2nd Ed] Scorpion",
                "", "[IA Apo 2013] Vampire Hunter"};

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
        cnt += 480;

        nameDerArtDerArmee = "Eldar";
        nameDerArtDerArmeeDekliniert = "Eldar";
        textAreaUeberschrift = BuildaHQ.translate("Meine") + " Eldar " + BuildaHQ.translate("Armee");

        noAllies.clear();

        noAllies.add("EC");
        noAllies.add("EL");

        battleBrothers.add("EC");
        battleBrothers.add("EL");
        battleBrothers.add("DE");
        battleBrothers.add("HQ");

        alliesOfConvenience.add("AB");
        alliesOfConvenience.add("AM");
        alliesOfConvenience.add("AS");
        alliesOfConvenience.add("BA");
        alliesOfConvenience.add("CR");
        alliesOfConvenience.add("DA");
        alliesOfConvenience.add("DK");
        alliesOfConvenience.add("DKAB");
        alliesOfConvenience.add("ED");
        alliesOfConvenience.add("GK");
        alliesOfConvenience.add("IN");
        alliesOfConvenience.add("IR");
        alliesOfConvenience.add("MT");
        alliesOfConvenience.add("SF");
        alliesOfConvenience.add("SM");
        alliesOfConvenience.add("TL");
        alliesOfConvenience.add("TA");
        alliesOfConvenience.add("FE");
        alliesOfConvenience.add("DW");

        desperateAllies.add("OR");
        desperateAllies.add("DM");

        comeTheApocalypse.add("BL");
        comeTheApocalypse.add("CD");
        comeTheApocalypse.add("CM");
        comeTheApocalypse.add("CS");
        comeTheApocalypse.add("DH");
        comeTheApocalypse.add("NE");
        comeTheApocalypse.add("RH");
        comeTheApocalypse.add("TY");
        comeTheApocalypse.add("SY");

        //Verschiedene Spezialkontingente der Eldar
        kontingente.add("");
        kontingente.add("Craftworld Warhost");
        kontingente.add("Warhost of the Pale Courts (IA11 2nd Ed)");

        //Formationen
        formationen.add("Guardian Battlehost");
        formationen.add("Windrider Host");
        formationen.add("Guardian Stormhost");
        formationen.add("Seer Council");
        formationen.add("Aspect Host");
        formationen.add("Dire Avenger Shrine");
        formationen.add("Crimson Death");
        formationen.add("Wraith Host");
        formationen.add("");
        formationen.add("Mymeara Guardian Battlehost (IA11 2nd Ed)");

        //Min/max-Auswahlen je Spezialkontingent/Formation
        int[] arr1 = {1, 0, 3, 1, 2, 0, 0, 0};
        minAuswahlen.put("Guardian Battlehost", arr1);
        int[] arr2 = {2, 0, 3, 1, 2, 0, 0, 0};
        maxAuswahlen.put("Guardian Battlehost", arr2);

        int[] arr3 = {2, 0, 3, 1, 0, 0, 0, 0};
        minAuswahlen.put("Windrider Host", arr3);
        maxAuswahlen.put("Windrider Host", arr3);

        int[] arr4 = {1, 0, 3, 1, 2, 0, 0, 0};
        minAuswahlen.put("Guardian Stormhost", arr4);
        int[] arr5 = {2, 0, 3, 1, 2, 0, 0, 0};
        maxAuswahlen.put("Guardian Stormhost", arr5);

        int[] arr6 = {3, 0, 0, 0, 0, 0, 0, 0};
        minAuswahlen.put("Seer Council", arr6);
        maxAuswahlen.put("Seer Council", arr6);

        int[] arr7 = {0, 0, 0, 0, 0, 0, 0, 0};
        minAuswahlen.put("Aspect Host", arr7);
        int[] arr8 = {0, 3, 3, 3, 3, 0, 0, 0};
        maxAuswahlen.put("Aspect Host", arr8);

        int[] arr9 = {0, 0, 3, 0, 0, 0, 0, 0};
        minAuswahlen.put("Dire Avenger Shrine", arr9);
        maxAuswahlen.put("Dire Avenger Shrine", arr9);

        int[] arr10 = {0, 0, 0, 3, 0, 0, 0, 0};
        minAuswahlen.put("Crimson Death", arr10);
        maxAuswahlen.put("Crimson Death", arr10);

        int[] arr11 = {1, 3, 0, 0, 1, 0, 1, 0};
        minAuswahlen.put("Wraith Host", arr11);
        maxAuswahlen.put("Wraith Host", arr11);

        minAuswahlen.put("Craftworld Warhost", new int[]{0, 0, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Craftworld Warhost", new int[]{0, 0, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("Mymeara Guardian Battlehost (IA11 2nd Ed)", new int[]{1, 0, 4, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Mymeara Guardian Battlehost (IA11 2nd Ed)", new int[]{2, 0, 6, 1, 3, 0, 0, 0});

        minAuswahlen.put("Warhost of the Pale Courts (IA11 2nd Ed)", new int[]{0, 0, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Warhost of the Pale Courts (IA11 2nd Ed)", new int[]{0, 0, 0, 0, 0, 0, 0, 0});

        complete();
    }

    public void changeFormations() {
        if (getCountFromInformationVector("Super-Warhost") > 0) {
            formationen.add("Heroes of the Craftworlds");
            formationen.add("Living Legends");
            formationen.add("Outcasts");
            formationen.add("Engines of Vaul");
            formationen.add("Wraith Constructs");

            minAuswahlen.put("Heroes of the Craftworlds", new int[]{1, 0, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Heroes of the Craftworlds", new int[]{1, 0, 0, 0, 0, 0, 0, 0});

            minAuswahlen.put("Living Legends", new int[]{0, 0, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Living Legends", new int[]{1, 0, 0, 0, 0, 0, 1, 0});

            minAuswahlen.put("Outcasts", new int[]{0, 0, 1, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Outcasts", new int[]{0, 0, 1, 0, 0, 0, 0, 0});

            minAuswahlen.put("Engines of Vaul", new int[]{0, 0, 0, 0, 1, 0, 0, 0});
            maxAuswahlen.put("Engines of Vaul", new int[]{0, 0, 0, 0, 1, 0, 0, 0});

            minAuswahlen.put("Wraith Constructs", new int[]{0, 0, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Wraith Constructs", new int[]{0, 0, 0, 1, 1, 0, 1, 0});

            formationen.add("Lord of the Undying Host (IA11 2nd Ed)");

            minAuswahlen.put("Lord of the Undying Host (IA11 2nd Ed)", new int[]{1, 1, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Lord of the Undying Host (IA11 2nd Ed)", new int[]{1, 3, 0, 0, 0, 0, 0, 0});

            formationen.add("Pale Courts Battlehost (IA11 2nd Ed)");

            minAuswahlen.put("Pale Courts Battlehost (IA11 2nd Ed)", new int[]{1, 0, 3, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Pale Courts Battlehost (IA11 2nd Ed)", new int[]{2, 0, 3, 0, 0, 0, 0, 0});

            formationen.add("Wasp Phalanx (IA11 2nd Ed)");

            minAuswahlen.put("Wasp Phalanx (IA11 2nd Ed)", new int[]{0, 0, 0, 1, 0, 0, 0, 0});
            maxAuswahlen.put("Wasp Phalanx (IA11 2nd Ed)", new int[]{0, 0, 0, 1, 0, 0, 0, 0});

            formationen.add("Hornet Swarm (IA11 2nd Ed)");

            minAuswahlen.put("Hornet Swarm (IA11 2nd Ed)", new int[]{0, 0, 0, 1, 0, 0, 0, 0});
            maxAuswahlen.put("Hornet Swarm (IA11 2nd Ed)", new int[]{0, 0, 0, 1, 0, 0, 0, 0});

            formationen.add("Fist of Vaul (IA11 2nd Ed)");

            minAuswahlen.put("Fist of Vaul (IA11 2nd Ed)", new int[]{0, 0, 0, 0, 1, 0, 0, 0});
            maxAuswahlen.put("Fist of Vaul (IA11 2nd Ed)", new int[]{0, 0, 0, 0, 1, 0, 0, 0});

            formationen.add("Fires of the Phoenix (IA11 2nd Ed)");

            minAuswahlen.put("Fires of the Phoenix (IA11 2nd Ed)", new int[]{0, 0, 0, 1, 0, 0, 0, 0});
            maxAuswahlen.put("Fires of the Phoenix (IA11 2nd Ed)", new int[]{0, 0, 0, 1, 0, 0, 0, 0});

            formationen.add("Khaine's Hawks Squadron (IA11 2nd Ed)");

            minAuswahlen.put("Khaine's Hawks Squadron (IA11 2nd Ed)", new int[]{0, 0, 0, 1, 0, 0, 0, 0});
            maxAuswahlen.put("Khaine's Hawks Squadron (IA11 2nd Ed)", new int[]{0, 0, 0, 1, 0, 0, 0, 0});

            formationen.add("Shadow Spectres Shrine (IA11 2nd Ed)");

            minAuswahlen.put("Shadow Spectres Shrine (IA11 2nd Ed)", new int[]{0, 0, 0, 3, 0, 0, 0, 0});
            maxAuswahlen.put("Shadow Spectres Shrine (IA11 2nd Ed)", new int[]{0, 0, 0, 3, 0, 0, 0, 0});

            formationen.add("Wraith Titans (IA11 2nd Ed)");

            minAuswahlen.put("Wraith Titans (IA11 2nd Ed)", new int[]{0, 0, 0, 0, 0, 0, 1, 0});
            maxAuswahlen.put("Wraith Titans (IA11 2nd Ed)", new int[]{0, 0, 0, 0, 0, 0, 3, 0});

            formationen.add("Skyreaver Raiding Echelon (IA11 2nd Ed)");

            minAuswahlen.put("Skyreaver Raiding Echelon (IA11 2nd Ed)", new int[]{1, 0, 1, 0, 1, 0, 1, 0});
            maxAuswahlen.put("Skyreaver Raiding Echelon (IA11 2nd Ed)", new int[]{1, 0, 99, 0, 1, 0, 1, 0});

            formationen.add("Skyhunters Squadron (IA11 2nd Ed)");

            minAuswahlen.put("Skyhunters Squadron (IA11 2nd Ed)", new int[]{0, 0, 0, 0, 1, 0, 0, 0});
            maxAuswahlen.put("Skyhunters Squadron (IA11 2nd Ed)", new int[]{0, 0, 0, 0, 1, 0, 0, 0});

            formationen.add("Hammers of Vaul (IA11 2nd Ed)");

            minAuswahlen.put("Hammers of Vaul (IA11 2nd Ed)", new int[]{0, 0, 0, 0, 0, 0, 1, 0});
            maxAuswahlen.put("Hammers of Vaul (IA11 2nd Ed)", new int[]{0, 0, 0, 0, 0, 0, 1, 0});
        }
    }

    @Override
    public void volkRefresh() {
        setInformationVectorValue("Guardian Battlehost", 0);
        setInformationVectorValue("Windrider Host", 0);
        setInformationVectorValue("Guardian Stormhost", 0);

        formationen.add("Pale Courts Battlehost (IA11 2nd Ed)");

        if (getKontingentTyp().equals("Craftworld Warhost") || getKontingentTyp().equals("Warhost of the Pale Courts (IA11 2nd Ed)")) { //Superformation))
            setInformationVectorValue("Super-Warhost", 1);
            superformation = new Superformation(getPanel(), 0);
            superformation.reflectionKennungLokal = reflectionKennungLokal;
            superformation.volkFile = getClass().getName();
            superformation.tA = buildatextArea;
            superformation.buildaVater = this;

            superformation.showSupport = true;
            superformation.minSupport = 0;
            superformation.maxSupport = 1;
            superformation.minCommand = 0;
            superformation.maxCommand = 3;
            superformation.minCore = 1;
            superformation.maxCore = 3;
            superformation.minAuxiliary = 1;
            superformation.maxAuxiliary = 12;
            superformation.multiplyerAuxiliaryByCore = true;// 1-12 per Core
            superformation.multiplyerCommandByCore = true;// 0-3 per Core
            superformation.multiplyerSupportByCore = true;// 0-1 per Core

            superformation.namenCommand.add("");
            superformation.namenCommand.add("Heroes of the Craftworlds");
            superformation.namenCommand.add("Seer Council");
            superformation.namenCommand.add("Living Legends");
            superformation.namenCommand.add("Lord of the Undying Host (IA11 2nd Ed)");

            superformation.namenCore.add("");
            if (getKontingentTyp().equals("Craftworld Warhost")) {
                superformation.namenCore.add("Guardian Battlehost");
                superformation.namenCore.add("Windrider Host");
                superformation.namenCore.add("Guardian Stormhost");
                superformation.namenCore.add("Mymeara Guardian Battlehost (IA11 2nd Ed)");
            } else if (getKontingentTyp().equals("Warhost of the Pale Courts (IA11 2nd Ed)")) {
                superformation.namenCore.add("Pale Courts Battlehost (IA11 2nd Ed)");
            }

            superformation.namenAuxiliary.add("");
            superformation.namenAuxiliary.add("Outcasts");
            superformation.namenAuxiliary.add("Aspect Host");
            superformation.namenAuxiliary.add("Crimson Death");
            superformation.namenAuxiliary.add("Dire Avenger Shrine");
            superformation.namenAuxiliary.add("Engines of Vaul");
            superformation.namenAuxiliary.add("Wraith Host");
            superformation.namenAuxiliary.add("Wraith Constructs");
            superformation.namenAuxiliary.add("Shadow Spectres Shrine (IA11 2nd Ed)");
            superformation.namenAuxiliary.add("Khaine's Hawks Squadron (IA11 2nd Ed)");
            superformation.namenAuxiliary.add("Fires of the Phoenix (IA11 2nd Ed)");
            superformation.namenAuxiliary.add("Fist of Vaul (IA11 2nd Ed)");
            superformation.namenAuxiliary.add("Hornet Swarm (IA11 2nd Ed)");
            superformation.namenAuxiliary.add("Wasp Phalanx (IA11 2nd Ed)");

            superformation.namenSupport.add("");
            superformation.namenSupport.add("Hammers of Vaul (IA11 2nd Ed)");
            superformation.namenSupport.add("Skyhunters Squadron (IA11 2nd Ed)");
            superformation.namenSupport.add("Skyreaver Raiding Echelon (IA11 2nd Ed)");
            superformation.namenSupport.add("Wraith Titans (IA11 2nd Ed)");


            for (int i = 0; i < myChooserGruppen.size(); i++) {
                myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
            }

            superformation.refreshControlPanel();

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);

            RefreshListener.fireRefresh();
        } else if (getKontingentTyp().equals("Hammers of Vaul (IA11 2nd Ed)")) {
            clearCombo();
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{"", "[IA11 2nd Ed] Cobra", "[IA11 2nd Ed] Scorpion"});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"[IA11 2nd Ed] Cobra", "[IA11 2nd Ed] Scorpion"}, 1, 1));

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Skyhunters Squadron (IA11 2nd Ed)")) {
            clearCombo();
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "[IA11 2nd Ed] Lynx"});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"[IA11 2nd Ed] Lynx"}, 1, 3));

            formation.infoLabel.setText("<html>Info:<br>"
                    + "All Lynx must take the same upgrades.<html>");

            if (!isLoading) {
                addUnitNotLocked(6, "[IA11 2nd Ed] Lynx");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Skyreaver Raiding Echelon (IA11 2nd Ed)")) {
            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Autarch"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{"", "[IA11 2nd Ed] Vampire Raider"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "Storm Guardians", "Guardian Defenders"});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "Vauls Wrath Support Battery"});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"Autarch"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"[IA11 2nd Ed] Vampire Raider"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"Storm Guardians", "Guardian Defenders"}, 1, Integer.MAX_VALUE));
            formation.entries.add(new FormationEntry(new String[]{"Vauls Wrath Support Battery"}, 1, 1));


            formation.infoLabel.setText("<html>Info:<br>"
                    + "Nicht mehr Vauls Wrath Support Batteries als Guardian Defenders.<html>");//TODO vauls Wrath <= Guardian Defenders

            if (!isLoading) {
                addUnitNotLocked(0, "Autarch");
                addUnitNotLocked(6, "[IA11 2nd Ed] Vampire Raider");
                addUnitNotLocked(2, "Guardian Defenders");
                addUnitNotLocked(3, "Vauls Wrath Support Battery");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Wraith Titans (IA11 2nd Ed)")) {
            clearCombo();
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{"", "Wraithknight", "[IA11 2nd Ed] Revenant Titan", "[IA11 2nd Ed] Phantom Titan"});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"[IA11 2nd Ed] Revenant Titan", "[IA11 2nd Ed] Phantom Titan"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"Wraithknight"}, 0, 2));

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Shadow Spectres Shrine (IA11 2nd Ed)")) {
            clearCombo();
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "[IA11 2nd Ed] Shadow Spectres"});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"[IA11 2nd Ed] Shadow Spectres"}, 3, 3));

            formation.infoLabel.setText("<html>Info:<br>"
                    + "Only one Exarch.<html>"); //TODO only one Exarch

            if (!isLoading) {
                addUnitNotLocked(3, "[IA11 2nd Ed] Shadow Spectres");
                addUnitNotLocked(3, "[IA11 2nd Ed] Shadow Spectres");
                addUnitNotLocked(3, "[IA11 2nd Ed] Shadow Spectres");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Khaine's Hawks Squadron (IA11 2nd Ed)")) {
            clearCombo();
            addToInformationVector("Khaines's Hawks Squadron (IA11 2nd Ed)", +1);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "[IA11 2nd Ed] Nightwing"});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"[IA11 2nd Ed] Nightwing"}, 1, 1));

            if (!isLoading) {
                addUnitNotLocked(3, "[IA11 2nd Ed] Nightwing");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Fires of the Phoenix (IA11 2nd Ed)")) {
            clearCombo();
            addToInformationVector("Fires of the Phoenix (IA11 2nd Ed)", +1);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "[IA11 2nd Ed] Phoenix Bomber"});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"[IA11 2nd Ed] Phoenix Bomber"}, 1, 1));

            formation.infoLabel.setText("<html>Info:<br>"
                    + "All Phoenix Bombers must take the same upgrades.<html>");

            if (!isLoading) {
                addUnitNotLocked(3, "[IA11 2nd Ed] Phoenix Bomber");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Fist of Vaul (IA11 2nd Ed)")) {
            clearCombo();
            addToInformationVector("Fist of Vaul (IA11 2nd Ed)", +1);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "[IA11 2nd Ed] Warp Hunter"});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"[IA11 2nd Ed] Warp Hunter"}, 1, 1));
            formation.infoLabel.setText("<html>Info:<br>"
                    + "All Warp Hunters must take the same upgrades.<html>");


            if (!isLoading) {
                addUnitNotLocked(4, "[IA11 2nd Ed] Warp Hunter");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Hornet Swarm (IA11 2nd Ed)")) {
            clearCombo();
            addToInformationVector("Hornet Swarm (IA11 2nd Ed)", +1);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "[IA11 2nd Ed] Hornet Squadron"});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"[IA11 2nd Ed] Hornet Squadron"}, 1, 1));
            formation.infoLabel.setText("<html>Info:<br>"
                    + "All Hornets must take the same upgrades.<html>");

            if (!isLoading) {
                addUnitNotLocked(3, "[IA11 2nd Ed] Hornet Squadron");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Wasp Phalanx (IA11 2nd Ed)")) {
            clearCombo();
            addToInformationVector("Wasp Phalanx (IA11 2nd Ed)", +1);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "[IA11 2nd Ed] Wasp Assault Walker Squadron"});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"[IA11 2nd Ed] Wasp Assault Walker Squadron"}, 1, 1));

            if (!isLoading) {
                addUnitNotLocked(3, "[IA11 2nd Ed] Wasp Assault Walker Squadron");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Pale Courts Battlehost (IA11 2nd Ed)")) {

            boolean b1 = getCountFromInformationVector("Children of Khaine") == 1;
            boolean b2 = getCountFromInformationVector("On Lonely paths") == 1;
            boolean b3 = getCountFromInformationVector("Crossroads of Eternity") == 1;
            boolean b4 = getCountFromInformationVector("Disciples of Vaul") == 1;
            boolean b5 = getCountFromInformationVector("Graveyard of Dreams") == 1;
            boolean b6 = getCountFromInformationVector("Tomb-ship of Fallen Heroes") == 1;
            boolean b7 = getCountFromInformationVector("Aspect Lord-shrine") == 1;
            boolean b8 = getCountFromInformationVector("Fortress of Discipline") == 1;
            boolean b9 = getCountFromInformationVector("Swift to Anger") == 1;
            boolean b10 = getCountFromInformationVector("Halls of Martial Splendour") == 1;
            boolean b11 = getCountFromInformationVector("The Strong Stand Alone") == 1;

            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Warhost Traits", "Farseer", "Warlock Conclave"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "Guardian Defenders"});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});

            if (formation == null) {
                formation = new Formation(this);
            }
            formation.entries.clear();
            formation.entries.add(new FormationEntry(new String[]{"Warhost Traits"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"Warlock Conclave"}, 0, 1));
            formation.infoLabel.setText("<html>Info:<br>");
            if (b2) {
                myChooserGruppen.get(TR).addComboBoxAuswahl("Rangers");
                formation.entries.add(new FormationEntry(new String[]{"Rangers"}, 1, 3));
            }
            if (b3) {
                myChooserGruppen.get(TR).addComboBoxAuswahl("Harlequin Troupe");
                myChooserGruppen.get(TR).addComboBoxAuswahl("Corsair Reaver Band");
                formation.entries.add(new FormationEntry(new String[]{"Harlequin Troupe"}, 0, 1));
                formation.entries.add(new FormationEntry(new String[]{"Corsair Reaver Band"}, 0, 1));
            }
            if (b4) {
                myChooserGruppen.get(HS).addComboBoxAuswahl("Vauls Wrath Support Battery");
                formation.entries.add(new FormationEntry(new String[]{"Vauls Wrath Support Battery"}, 1, 3));
            }
            if (b5) {
                myChooserGruppen.get(EL).addComboBoxAuswahl("Wraithblades");
                formation.entries.add(new FormationEntry(new String[]{"Wraithblades"}, 3, 3));
            }
            if (b6) {
                myChooserGruppen.get(HQ).addComboBoxAuswahl("Spiritseer");
                myChooserGruppen.get(HQ).addComboBoxAuswahl("[IA11 2nd Ed] Wraithseer");
                formation.entries.add(new FormationEntry(new String[]{"Spiritseer", "[IA11 2nd Ed] Wraithseer"}, 1, 1));
                myChooserGruppen.get(HS).addComboBoxAuswahl("Wraithlord");
                formation.entries.add(new FormationEntry(new String[]{"Wraithlord"}, 0, 1));
            }
            if (b7) {
                myChooserGruppen.get(EL).addComboBoxAuswahl("Howling Banshees");
                myChooserGruppen.get(EL).addComboBoxAuswahl("Striking Scorpions");
                myChooserGruppen.get(EL).addComboBoxAuswahl("Fire Dragons");
                myChooserGruppen.get(TR).addComboBoxAuswahl("Dire Avengers");
                myChooserGruppen.get(FA).addComboBoxAuswahl("Swooping Hawks");
                myChooserGruppen.get(FA).addComboBoxAuswahl("Warp Spiders");
                myChooserGruppen.get(FA).addComboBoxAuswahl("Shining Spears");
                myChooserGruppen.get(FA).addComboBoxAuswahl("Dark Reapers");
                myChooserGruppen.get(HS).addComboBoxAuswahl("[IA11 2nd Ed] Shadow Spectres");
                formation.entries.add(new FormationEntry(new String[]{"Howling Banshees", "Striking Scorpions", "Fire Dragons", "Dire Avengers", "Swooping Hawks",
                        "Warp Spiders", "Shining Spears", "Dark Reapers", "[IA11 2nd Ed] Shadow Spectres"}, 3, 3));
                formation.infoLabel.setText(formation.infoLabel.getText()
                        + "The same aspect must be chosen for all 3 aspect warrior units.<br>"
                        + "Aspect also counts for other Pale Court Battlehosts.<br>"
                        + "No Dire Avengers Shrine Formation, if those chosen aspect is not Dire Avengers.<br>");
                //TODO The same aspect must be chosen for all 3 aspect warrior units
                //TODO Aspect also counts for other Pale Court Battlehosts
                //TODO No Dire Avengers Shrine Formation, if the chosen aspect warrior units are not also Dire Avengers
            }
            if (b5 || b7) {
                if (b1) {
                    myChooserGruppen.get(TR).removeComboBoxAuswahl("Guardian Defenders");
                    myChooserGruppen.get(TR).addComboBoxAuswahl("Storm Guardians");
                    formation.entries.add(new FormationEntry(new String[]{"Storm Guardians"}, 0, 3));
                } else {
                    formation.entries.add(new FormationEntry(new String[]{"Guardian Defenders"}, 0, 3));
                }
            } else {
                if (b1) {
                    myChooserGruppen.get(TR).removeComboBoxAuswahl("Guardian Defenders");
                    myChooserGruppen.get(TR).addComboBoxAuswahl("Storm Guardians");
                    formation.entries.add(new FormationEntry(new String[]{"Storm Guardians"}, 3, 3));
                } else {
                    formation.entries.add(new FormationEntry(new String[]{"Guardian Defenders"}, 3, 3));
                }
            }
            if (b8) {
                myChooserGruppen.get(FA).addComboBoxAuswahl("[IA11 2nd Ed] Wasp Assault Walker Squadron");
                myChooserGruppen.get(HS).addComboBoxAuswahl("War Walkers");
                formation.entries.add(new FormationEntry(new String[]{"War Walkers", "[IA11 2nd Ed] Wasp Assault Walker Squadron"}, 1, 3));
                formation.infoLabel.setText(formation.infoLabel.getText()
                        + "1-3 War Walkers oder 1 Wasp Assault Walkers.<br>"); //TODO Unit Count für Formationen. Wasp Assault Walkers dann = 3
            }
            if (b9) {
                myChooserGruppen.get(FA).addComboBoxAuswahl("Vyper Squadron");
                myChooserGruppen.get(FA).addComboBoxAuswahl("[IA11 2nd Ed] Hornet Squadron");
                formation.entries.add(new FormationEntry(new String[]{"Vyper Squadron", "[IA11 2nd Ed] Hornet Squadron"}, 1, 3));

                formation.infoLabel.setText(formation.infoLabel.getText()
                        + "1-3 Vyper Squadrons oder 1 Hornet Squadron.<br>"); //TODO Unit Count für Formationen. Hornet Squadron dann = 3
            }
            if (b6 || b10) {
                myChooserGruppen.get(HQ).removeComboBoxAuswahl("Farseer");
            } else {
                formation.entries.add(new FormationEntry(new String[]{"Farseer"}, 1, 1));
            }
            if (b10) {
                myChooserGruppen.get(HQ).addComboBoxAuswahl("Autarch");
                formation.entries.add(new FormationEntry(new String[]{"Autarch"}, 1, 1));
            }
            if (b11) {
                myChooserGruppen.get(LOW).addComboBoxAuswahl("Fire Prisms");
                myChooserGruppen.get(LOW).addComboBoxAuswahl("Night Spinners");
                myChooserGruppen.get(LOW).addComboBoxAuswahl("[IA11 2nd Ed] Warp Hunter");
                formation.entries.add(new FormationEntry(new String[]{"Fire Prisms", "Night Spinners", "[IA11 2nd Ed] Warp Hunter"}, 0, 1));
                formation.infoLabel.setText(formation.infoLabel.getText()
                        + "No other Formations are allowed, only other Pale Court Battlehosts.<br>");//TODO No other Formations are allowed,only other Pale Court Battlehosts
            }

            formation.infoLabel.setText(formation.infoLabel.getText() + "</html>");

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Lord of the Undying Host (IA11 2nd Ed)")) {
            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "[IA11 2nd Ed] Wraithseer"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Wraithblades"});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"[IA11 2nd Ed] Wraithseer"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"Wraithblades"}, 1, 3));

            if (!isLoading) {
                addUnitNotLocked(0, "[IA11 2nd Ed] Wraithseer");
                addUnitNotLocked(1, "Wraithblades");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Mymeara Guardian Battlehost (IA11 2nd Ed)")) {
            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Farseer", "[IA11 2nd Ed] Bel-Annath", "Warlock Conclave"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "Guardian Defenders", "Rangers"});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "[IA11 2nd Ed] Wasp Assault Walker Squadron"});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "War Walkers"});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"Farseer", "[IA11 2nd Ed] Bel-Annath"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"Guardian Defenders"}, 3, 3));
            formation.entries.add(new FormationEntry(new String[]{"Rangers"}, 1, 3));
            formation.entries.add(new FormationEntry(new String[]{"War Walkers", "[IA11 2nd Ed] Wasp Assault Walker Squadron"}, 1, 3));
            formation.entries.add(new FormationEntry(new String[]{"Warlock Conclave"}, 0, 1));
            formation.infoLabel.setText("<html>Info:<br>"
                    + "1-3 War Walkers oder 1 Wasp Assault Walkers.<html>"); //TODO Unit Count für Formationen. Wasp Assault Walkers dann = 3

            if (!isLoading) {
                addUnitNotLocked(0, "Farseer");
                addUnitNotLocked(2, "Guardian Defenders");
                addUnitNotLocked(2, "Guardian Defenders");
                addUnitNotLocked(2, "Guardian Defenders");
                addUnitNotLocked(2, "Rangers");
                addUnitNotLocked(4, "War Walkers");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().contains("Guardian Battlehost")) {
            setInformationVectorValue("Guardian Battlehost", 1);

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Farseer", "Warlock Conclave"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Guardian Defenders"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Vyper Squadron"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "War Walkers", "Vauls Wrath Support Battery"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Farseer");

                addUnit(2, "Guardian Defenders");
                addUnit(2, "Guardian Defenders");
                addUnit(2, "Guardian Defenders");

                addUnit(3, "Vyper Squadron");

                addUnit(4, "War Walkers");
                addUnit(4, "Vauls Wrath Support Battery");
            }
        } else if (getKontingentTyp().contains("Windrider Host")) {
            setInformationVectorValue("Windrider Host", 1);

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Farseer", "Warlock Conclave"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Windriders"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Vyper Squadron"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Farseer");
                addUnit(0, "Warlock Conclave");

                addUnit(2, "Windriders");
                addUnit(2, "Windriders");
                addUnit(2, "Windriders");

                addUnit(3, "Vyper Squadron");
            }
        } else if (getKontingentTyp().contains("Guardian Stormhost")) {
            setInformationVectorValue("Guardian Stormhost", 1);

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Farseer", "Warlock Conclave"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Storm Guardians"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Vyper Squadron"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "War Walkers", "Vauls Wrath Support Battery"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Farseer");

                addUnit(2, "Storm Guardians");
                addUnit(2, "Storm Guardians");
                addUnit(2, "Storm Guardians");

                addUnit(3, "Vyper Squadron");

                addUnit(4, "War Walkers");
                addUnit(4, "Vauls Wrath Support Battery");
            }
        } else if (getKontingentTyp().contains("Seer Council")) {

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Farseer", "Eldrad Ulthran", "Warlock Conclave"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(0, "Farseer");
                addUnit(0, "Farseer");
                addUnit(0, "Warlock Conclave");
            }
        } else if (getKontingentTyp().contains("Aspect Host")) {

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Howling Banshees", "Striking Scorpions", "Fire Dragons"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Dire Avengers"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Swooping Hawks", "Warp Spiders", "Shining Spears"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Dark Reapers"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});

        } else if (getKontingentTyp().contains("Dire Avenger Shrine")) {

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Dire Avengers"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(2, "Dire Avengers");
                addUnit(2, "Dire Avengers");
                addUnit(2, "Dire Avengers");
            }
        } else if (getKontingentTyp().contains("Crimson Death")) {

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Crimson Hunter"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(3, "Crimson Hunter");
                addUnit(3, "Crimson Hunter");
                addUnit(3, "Crimson Hunter");
            }
        } else if (getKontingentTyp().contains("Wraith Host")) {

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Spiritseer"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Wraithguard", "Wraithblades"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Wraithlord"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{"", "Wraithknight"});
            if (!isLoading) {
                addUnit(0, "Spiritseer");
                addUnit(0, "");

                addUnitNotLocked(1, "Wraithguard");
                addUnitNotLocked(1, "Wraithguard");
                addUnitNotLocked(1, "Wraithguard");
                addUnit(1, "");

                addUnit(4, "Wraithlord");
                addUnit(4, "");

                addUnit(6, "Wraithknight");
                addUnit(6, "");
            }
        } else if (getKontingentTyp().contains("Heroes of the Craftworlds")) {

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Autarch", "Prince Yriel", "Eldrad Ulthran", "Illic Nightspear"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});

        } else if (getKontingentTyp().contains("Living Legends")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Asurmen", "Jain Zar", "Karandras", "Fuegan", "Baharroth", "Maugan Ra"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{"", "Avatar of Khaine"});
        } else if (getKontingentTyp().contains("Outcasts")) {

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Rangers"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(2, "Rangers");
            }
        } else if (getKontingentTyp().contains("Engines of Vaul")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Night Spinners", "Fire Prisms", "Falcons"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
        } else if (getKontingentTyp().contains("Wraith Constructs")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Hemlock Wraithfigther"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Wraithlord"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{"", "Wraithknight"});
        } else {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(HQeinträge);
            myChooserGruppen.get(1).changeComboBoxAuswahlen(Eliteeinträge);
            myChooserGruppen.get(2).changeComboBoxAuswahlen(Standardeinträge);
            myChooserGruppen.get(3).changeComboBoxAuswahlen(Sturmeinträge);
            myChooserGruppen.get(4).changeComboBoxAuswahlen(Unterstützungeinträge);
            myChooserGruppen.get(5).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(6).changeComboBoxAuswahlen(LordofWar);
        }

        if (formation != null) {
            formation.refreshControlPanel();
        }

        fillChooserSpace();
    }
}