package oc.wh40k.armies;

import oc.*;

public class VOLKGatheringStormII extends BuildaVater {

    public VOLKGatheringStormII() {
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

        kontingente.add("");
        kontingente.add("Reborn Warhost");
        kontingente.add("Forces Of Ulthwé");

        formationen.add("");
        formationen.add("Triumvirate Of Ynnead");
        formationen.add("Soulbound Vanguard");
        formationen.add("Aeldari Bladehost");
        formationen.add("Ynnead's Net");
        formationen.add("Whispering Ghost Hall");

        minAuswahlen.put("Triumvirate Of Ynnead", new int[]{3, 0, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Triumvirate Of Ynnead", new int[]{3, 0, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("Soulbound Vanguard", new int[]{0, 1, 3, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Soulbound Vanguard", new int[]{0, 1, 3, 0, 0, 0, 0, 0});

        minAuswahlen.put("Aeldari Bladehost", new int[]{0, 0, 6, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Aeldari Bladehost", new int[]{0, 0, 6, 0, 0, 0, 0, 0});

        minAuswahlen.put("Ynnead's Net", new int[]{1, 0, 1, 2, 0, 0, 0, 0});
        maxAuswahlen.put("Ynnead's Net", new int[]{1, 0, 1, 2, 0, 0, 0, 0});

        minAuswahlen.put("Whispering Ghost Hall", new int[]{2, 6, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Whispering Ghost Hall", new int[]{2, 6, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("Forces Of Ulthwé", new int[]{0, 1, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Forces Of Ulthwé", new int[]{0, 4, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("Reborn Warhost", new int[]{1, 0, 2, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Reborn Warhost", new int[]{2, 3, 6, 3, 3, 0, 1, 0});

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
    }

    @Override
    public void volkRefresh() {

        if (getKontingentTyp().equals("Forces Of Ulthwé")) {

            addToInformationVector("Forces Of Ulthwé", 1);

            clearCombo();

            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "EL Black Guardians", "EL Black Guardian Windriders", "EL Black Guardian Vyper Squadron", "EL Black Guardian War Walkers"});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"EL Black Guardians", "EL Black Guardian Windriders", "EL Black Guardian Vyper Squadron", "EL Black Guardian War Walkers"}, 1, 4));

            if (!isLoading) {
                addUnitNotLocked(EL, "EL Black Guardians");
            }

        } else if (getKontingentTyp().equals("Reborn Warhost")) {

            addToInformationVector("Reborn Warhost", 1);

            clearCombo();

            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Yvraine", "The Visarch", "", "EL Eldrad Ulthran", "EL Prince Yriel", "EL Illic Nightspear", "EL Asurmen", "EL Jain Zar", "EL Karandras", "EL Fuegan", "EL Baharroth", "EL Maugan Ra",
                    "EL Autarch", "EL Farseer", "EL Warlock Conclave", "EL Spiritseer", "", "DE Archon", "DE Court of the Archon", "DE Succubus", "DE Lelith Hesperax"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "EL Howling Banshees", "EL Striking Scorpions", "EL Fire Dragons", "EL Wraithguard", "EL Wraithblades",
                    "EL Black Guardians", "EL Black Guardian Windriders", "EL Black Guardian Vyper Squadron", "EL Black Guardian War Walkers", "", "DE Incubi", "DE Kabalite Trueborn", "DE Bloodbrides", "", "HQ Death Jester", "HQ Shadowseer", "HQ Solitaire"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "EL Guardian Defenders", "EL Storm Guardians", "EL Windriders", "EL Rangers", "EL Dire Avengers", "", "DE Kabalite Warriors", "DE Wyches", "", "HQ Troupe"});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "EL Wave Serpent", "EL Swooping Hawks", "EL Warp Spiders", "EL Shining Spears", "EL Crimson Hunter", "EL Vyper Squadron", "EL Hemlock Wraithfigther", "",
                    "DE Beastmaster", "DE Raider", "DE Venom", "DE Reavers", "DE Hellions", "DE Razorwing Jetfighter", "DE Scourges", "", "HQ Skyweaver", "HQ Starweaver"});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{"", "EL Dark Reapers", "EL Vauls Wrath Support Battery", "EL Falcons", "EL Fire Prisms", "EL Night Spinners", "EL War Walkers", "EL Wraithlord", "", "DE Ravager", "DE Voidraven Bomber", "", "HQ Voidweaver"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{"", "EL Wraithknight", "The Yncarne"});

            if (!isLoading) {
            }

        } else if (getKontingentTyp().equals("Triumvirate Of Ynnead")) {
            addToInformationVector("Triumvirate Of Ynnead", 1);

            clearCombo();

            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "Yvraine", "The Visarch", "The Yncarne"});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"Yvraine"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"The Visarch"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"The Yncarne"}, 1, 1));

            if (!isLoading) {
                addUnit(0, "Yvraine");
                addUnit(0, "The Visarch");
                addUnit(0, "The Yncarne");
            }

        } else if (getKontingentTyp().equals("Soulbound Vanguard")) {
            addToInformationVector("Soulbound Vanguard", 1);
            addToInformationVector("Formation", 1);
            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "DE Incubi"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "EL Dire Avengers", "DE Wyches"});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"DE Incubi"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"EL Dire Avengers"}, 2, 2));
            formation.entries.add(new FormationEntry(new String[]{"DE Wyches"}, 1, 1));

            if (!isLoading) {
                addUnit(EL, "DE Incubi");
                addUnit(TR, "EL Dire Avengers");
                addUnit(TR, "EL Dire Avengers");
                addUnit(TR, "DE Wyches");
            }

            supplementBox.setEnabled(false);
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Aeldari Bladehost")) {
            addToInformationVector("Soulbound Vanguard", 1);
            addToInformationVector("Formation", 1);
            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "EL Black Guardians"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "DE Wyches", "EL Storm Guardians", "HQ Troupe"});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"DE Wyches"}, 2, 2));
            formation.entries.add(new FormationEntry(new String[]{"EL Storm Guardians", "EL Black Guardians"}, 2, 2));
            formation.entries.add(new FormationEntry(new String[]{"HQ Troupe"}, 2, 2));

            if (!isLoading) {
                addUnit(TR, "DE Wyches");
                addUnit(TR, "DE Wyches");
                addUnitNotLocked(TR, "EL Storm Guardians");
                addUnitNotLocked(TR, "EL Storm Guardians");
                addUnit(TR, "HQ Troupe");
                addUnit(TR, "HQ Troupe");
            }

            supplementBox.setEnabled(false);
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Ynnead's Net")) {
            addToInformationVector("Ynnead's Net", 1);
            addToInformationVector("Formation", 1);
            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "EL Warlock Conclave"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{"", "EL Windriders"});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{"", "DE Reavers", "HQ Skyweaver"});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"EL Warlock Conclave"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"EL Windriders"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"DE Reavers"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"HQ Skyweaver"}, 1, 1));

            if (!isLoading) {
                addUnit(HQ, "EL Warlock Conclave");
                addUnit(TR, "EL Windriders");
                addUnit(FA, "DE Reavers");
                addUnit(FA, "HQ Skyweaver");
            }

            supplementBox.setEnabled(false);
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Whispering Ghost Hall")) {
            addToInformationVector("Whispering Ghost Hall", 1);
            addToInformationVector("Formation", 1);
            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{"", "EL Farseer", "EL Spiritseer"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "HQ Shadowseer", "EL Wraithlord", "EL Wraithguard", "EL Wraithblades"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{""});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"EL Farseer"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"EL Spiritseer"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"HQ Shadowseer"}, 1, 1));
            formation.entries.add(new FormationEntry(new String[]{"EL Wraithlord"}, 2, 2));
            formation.entries.add(new FormationEntry(new String[]{"EL Wraithguard", "EL Wraithblades"}, 3, 3));

            if (!isLoading) {
                addUnit(HQ, "EL Farseer");
                addUnit(HQ, "EL Spiritseer");
                addUnit(EL, "HQ Shadowseer");
                addUnit(EL, "EL Wraithlord");
                addUnit(EL, "EL Wraithlord");
                addUnitNotLocked(EL, "EL Wraithguard");
                addUnitNotLocked(EL, "EL Wraithguard");
                addUnitNotLocked(EL, "EL Wraithguard");
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