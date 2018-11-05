package oc.wh40k.armies;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKDarkEldar extends BuildaVater {

    public VOLKDarkEldar() {

        reflectionKennung = "DE";

        HQeinträge = new String[]{"", "Archon", "Court of the Archon", "Succubus", "Lelith Hesperax", "Haemonculus", "Urien Rakarth", "Drazhar"};
        Eliteeinträge = new String[]{"", "Incubi", "Mandrakes", "Wracks", "Grotesques", "Kabalite Trueborn", "Bloodbrides"};
        Standardeinträge = new String[]{"", "Kabalite Warriors", "Wyches"};
        Sturmeinträge = new String[]{"", "Beastmaster", "Raider", "Venom", "Reavers", "Hellions", "Razorwing Jetfighter", "Scourges",
                "", "[IA Aeronautica] Raven Strike Fighter"};
        Unterstützungeinträge = new String[]{"", "Talos", "Cronos", "Ravager", "Voidraven Bomber",
                "", "[IA Apo 2013] Reaper", "[Forgeworld] Void Dragon Phoenix", "[IA Apo 2013] Tantalus"};
        LordofWar = new String[]{""};

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

        nameDerArtDerArmee = "Dark Eldar";
        nameDerArtDerArmeeDekliniert = "Dark Eldar";
        textAreaUeberschrift = BuildaHQ.translate("Meine") + " Dark Eldar";

        noAllies.clear();
        noAllies.add("DE");

        battleBrothers.add("EC");
        battleBrothers.add("EL");
        battleBrothers.add("DE");
        battleBrothers.add("HQ");

        desperateAllies.add("AB");
        desperateAllies.add("AM");
        desperateAllies.add("AS");
        desperateAllies.add("BA");
        desperateAllies.add("CR");
        desperateAllies.add("DA");
        desperateAllies.add("DK");
        desperateAllies.add("DKAB");
        desperateAllies.add("ED");
        desperateAllies.add("GK");
        desperateAllies.add("IN");
        desperateAllies.add("IR");
        desperateAllies.add("MT");
        desperateAllies.add("SF");
        desperateAllies.add("SM");
        desperateAllies.add("TL");
        desperateAllies.add("BL");
        desperateAllies.add("CD");
        desperateAllies.add("CM");
        desperateAllies.add("CS");
        desperateAllies.add("RH");
        desperateAllies.add("DM");
        desperateAllies.add("FE");
        desperateAllies.add("OR");
        desperateAllies.add("TA");
        desperateAllies.add("DW");

        comeTheApocalypse.add("DH");
        comeTheApocalypse.add("NE");
        comeTheApocalypse.add("TY");
        comeTheApocalypse.add("SY");

        //Verschiedene Spezialkontingente der DE
        formationen.add("Kabalite Raiding Party");

        kontingente.add("");
        kontingente.add("Realspace Raider");

        //Min/max-Auswahlen je Spezialkontingent
        int[] arr1 = {1, 1, 6, 2, 1, 0, 0, 0};
        minAuswahlen.put("Kabalite Raiding Party", arr1);
        maxAuswahlen.put("Kabalite Raiding Party", arr1);

        int[] arr2 = {1, 0, 2, 1, 0, 0, 0, 0};
        minAuswahlen.put("Realspace Raider", arr2);
        int[] arr3 = {2, 3, 6, 6, 3, 0, 0, 0};
        maxAuswahlen.put("Realspace Raider", arr3);

        /*
         * HAEMONCULUS COVENS
         */

        kontingente.add("");
        kontingente.add("Haemonculus Covens");

        int[] arr4 = {2, 2, 0, 0, 0, 0, 0, 0};
        minAuswahlen.put("Haemonculus Covens", arr4);
        int[] arr5 = {6, 8, 0, 0, 4, 0, 0, 0};
        maxAuswahlen.put("Haemonculus Covens", arr5);

        formationen.add("");
        formationen.add("Grotesquerie (Haemonculus Covens)");
        formationen.add("Scarlet Epicureans (Haemonculus Covens)");
        formationen.add("Scalpel Squadron (Haemonculus Covens)");
        formationen.add("Corpsethief Claw (Haemonculus Covens)");
        formationen.add("Dark Artisan (Haemonculus Covens)");
        formationen.add("Covenite Fleshcorps (Haemonculus Covens)");
        formationen.add("");
        formationen.add("Skyscythe Slaughter Host [IA Apo 2013]");

        minAuswahlen.put("Grotesquerie (Haemonculus Covens)", new int[]{1, 2, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Grotesquerie (Haemonculus Covens)", new int[]{1, 2, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("Scarlet Epicureans (Haemonculus Covens)", new int[]{1, 2, 0, 0, 1, 0, 0, 0});
        maxAuswahlen.put("Scarlet Epicureans (Haemonculus Covens)", new int[]{1, 2, 0, 0, 1, 0, 0, 0});

        minAuswahlen.put("Scalpel Squadron (Haemonculus Covens)", new int[]{0, 2, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Scalpel Squadron (Haemonculus Covens)", new int[]{0, 2, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("Corpsethief Claw (Haemonculus Covens)", new int[]{0, 0, 0, 0, 1, 0, 0, 0});
        maxAuswahlen.put("Corpsethief Claw (Haemonculus Covens)", new int[]{0, 0, 0, 0, 1, 0, 0, 0});

        minAuswahlen.put("Dark Artisan (Haemonculus Covens)", new int[]{1, 0, 0, 0, 2, 0, 0, 0});
        maxAuswahlen.put("Dark Artisan (Haemonculus Covens)", new int[]{1, 0, 0, 0, 2, 0, 0, 0});

        minAuswahlen.put("Covenite Fleshcorps (Haemonculus Covens)", new int[]{1, 3, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Covenite Fleshcorps (Haemonculus Covens)", new int[]{1, 3, 0, 0, 0, 0, 0, 0});

        minAuswahlen.put("Skyscythe Slaughter Host [IA Apo 2013]", new int[]{0, 0, 2, 0, 1, 0, 0, 0});
        maxAuswahlen.put("Skyscythe Slaughter Host [IA Apo 2013]", new int[]{0, 0, 99, 0, 99, 0, 0, 0});

//		Carnival of Pain // TODO: Formation mit Unterformationen
//		- Grotesquerie
//		- Scarlet Epicureans
//		- Scalpel Squadron
//		- Corpsethief Claw
//		- Dark Artisan
//		- Covenite Fleshcorps
//		RESTRICTIONS:
//		The units in this Formation must adhere to all of the restrictions detailed in each of the corresponding Formation datasheets.

        complete();
    }


    @Override
    public void volkRefresh() {

        setInformationVectorValue("Haemonculus Covens", 0);
        setInformationVectorValue("RaidingParty", 0);
        setInformationVectorValue("Scalpel Squadron", 0);
        setInformationVectorValue("HaemonculusCovensArtifacts", 0);
        setInformationVectorValue("Corpsethief Claw", 0);
        setInformationVectorValue("Covenite Fleshcorps", 0);
        setInformationVectorValue("Skyscythe Slaughter Host", 0);

        if (getKontingentTyp().equals("Skyscythe Slaughter Host [IA Apo 2013]")) {
            setInformationVectorValue("Skyscythe Slaughter Host", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Kabalite Warriors"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "[IA Apo 2013] Reaper"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(2, "Kabalite Warriors");
                addUnit(2, "Kabalite Warriors");
                addUnit(4, "[IA Apo 2013] Reaper");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Skyscythe Slaughter Host [IA Apo 2013]")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Archon", "Court of the Archon"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Incubi"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Kabalite Warriors"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Scourges", "Hellions"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Ravager"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Archon");
                addUnit(0, "Court of the Archon");
                addUnit(0, "");
                addUnit(1, "Incubi");
                addUnit(1, "");
                addUnit(2, "Kabalite Warriors");
                addUnit(2, "Kabalite Warriors");
                addUnit(2, "Kabalite Warriors");
                addUnit(2, "Kabalite Warriors");
                addUnit(2, "Kabalite Warriors");
                addUnit(2, "Kabalite Warriors");
                addUnit(2, "");
                addUnit(3, "Scourges");
                addUnit(3, "Hellions");
                addUnit(3, "");
                addUnit(4, "Ravager");
                addUnit(4, "");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Kabalite Raiding Party")) {
            setInformationVectorValue("RaidingParty", 1);
            setInformationVectorValue("HaemonculusCovensArtifacts", 0);
            setInformationVectorValue("Haemonculus Covens", 0);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Archon", "Court of the Archon"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Incubi"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Kabalite Warriors"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Scourges", "Hellions"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Ravager"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Archon");
                addUnit(0, "Court of the Archon");
                addUnit(0, "");
                addUnit(1, "Incubi");
                addUnit(1, "");
                addUnit(2, "Kabalite Warriors");
                addUnit(2, "Kabalite Warriors");
                addUnit(2, "Kabalite Warriors");
                addUnit(2, "Kabalite Warriors");
                addUnit(2, "Kabalite Warriors");
                addUnit(2, "Kabalite Warriors");
                addUnit(2, "");
                addUnit(3, "Scourges");
                addUnit(3, "Hellions");
                addUnit(3, "");
                addUnit(4, "Ravager");
                addUnit(4, "");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Haemonculus Covens")) {
            setInformationVectorValue("Haemonculus Covens", 1);
            setInformationVectorValue("HaemonculusCovensArtifacts", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Haemonculus", "Urien Rakarth"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Wracks", "Grotesques"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Talos", "Cronos"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
        } else if (getKontingentTyp().equals("Grotesquerie (Haemonculus Covens)")) {
            setInformationVectorValue("HaemonculusCovensArtifacts", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Haemonculus", "Urien Rakarth"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Grotesques"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(0, "Haemonculus");
                addUnit(0, "");
                addUnit(1, "Grotesques");
                addUnit(1, "Grotesques");
                addUnit(1, "");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Scarlet Epicureans (Haemonculus Covens)")) {
            setInformationVectorValue("HaemonculusCovensArtifacts", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Haemonculus"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Wracks"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Cronos"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Haemonculus");
                addUnit(0, "");
                addUnit(1, "Wracks");
                addUnit(1, "Wracks");
                addUnit(1, "");
                addUnit(4, "Cronos");
                addUnit(4, "");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Scalpel Squadron (Haemonculus Covens)")) {
            setInformationVectorValue("Scalpel Squadron", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Wracks"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(1, "Wracks");
                addUnit(1, "Wracks");
                addUnit(1, "");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Corpsethief Claw (Haemonculus Covens)")) {
            setInformationVectorValue("Corpsethief Claw", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Talos"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(4, "Talos");
                addUnit(4, "");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Dark Artisan (Haemonculus Covens)")) {
            setInformationVectorValue("HaemonculusCovensArtifacts", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Haemonculus"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Talos", "Cronos"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Haemonculus");
                addUnit(0, "");
                addUnit(4, "Talos");
                addUnit(4, "Cronos");
                addUnit(4, "");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().equals("Covenite Fleshcorps (Haemonculus Covens)")) {
            setInformationVectorValue("Covenite Fleshcorps", 1);
            setInformationVectorValue("HaemonculusCovensArtifacts", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Haemonculus"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Wracks"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Haemonculus");
                addUnit(0, "");
                addUnit(1, "Wracks");
                addUnit(1, "Wracks");
                addUnit(1, "Wracks");
                addUnit(1, "");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(HQeinträge);
            myChooserGruppen.get(1).changeComboBoxAuswahlen(Eliteeinträge);
            myChooserGruppen.get(2).changeComboBoxAuswahlen(Standardeinträge);
            myChooserGruppen.get(3).changeComboBoxAuswahlen(Sturmeinträge);
            myChooserGruppen.get(4).changeComboBoxAuswahlen(Unterstützungeinträge);
            myChooserGruppen.get(5).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(6).changeComboBoxAuswahlen(LordofWar);
        }

        fillChooserSpace();
    }
}
