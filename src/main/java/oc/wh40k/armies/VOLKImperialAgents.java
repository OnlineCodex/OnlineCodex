package oc.wh40k.armies;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKImperialAgents extends BuildaVater {

    public VOLKImperialAgents() {
        reflectionKennung = "IA";

        HQeinträge = new String[]{
                "", "Belisarius Cawl", "Celestine", "Inquisitor Greyfax"};
        Eliteeinträge = new String[]{
                "", ""};
        Standardeinträge = new String[]{
                "", ""};
        Sturmeinträge = new String[]{
                "", ""};
        Unterstützungeinträge = new String[]{
                "", ""};
        LordofWar = new String[]{
                "", ""
        };
//		Formationen = new String[] {
//				"","",
//				/*"", "[APO2 Armageddon NEW] Heroes of Armageddon", "[APO2 Armageddon NEW] Armageddon Stompa Hunters",
//    			"[APO2 Armageddon NEW] 'Imperial Vengeance' Mechanised Company", "[APO2 Armageddon NEW] Firestorm Nexus",
//    			"[APO2 Armageddon NEW] Imperial Stronghold",*/
//				//"", "[Forgeworld] Praetor Sky Killer Aerial Suppression Force",
//		};


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

        nameDerArtDerArmee = "Imperial Agents";
        nameDerArtDerArmeeDekliniert = "Imperial Agents";
        textAreaUeberschrift = BuildaHQ.translate("Imperial Agents");

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

        supplements.add("");
        supplements.add("Enginseer Congregation");
        supplements.add("Imperial Navy Section");
        supplements.add("Psykana Division");
        supplements.add("Ministorum Delegation");
        supplements.add("Vestal Task Force");
        supplements.add("Deathwatch Kill Team");
        supplements.add("Daemonhunter Strike Force");
        supplements.add("Spectral Host");
        supplements.add("Assassinorum Operative");
        supplements.add("Inquisitorial Representative");

        formationen.add("Ecclesiarchy Battle Conclave");
        minAuswahlen.put("Ecclesiarchy Battle Conclave", new int[]{1, 3, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Ecclesiarchy Battle Conclave", new int[]{1, 10, 0, 0, 0, 0, 0, 0});

        formationen.add("Execution Force");
        minAuswahlen.put("Execution Force", new int[]{0, 4, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Execution Force", new int[]{0, 4, 0, 0, 0, 0, 0, 0});

        formationen.add("Inquisitorial Henchmen Warband");
        minAuswahlen.put("Inquisitorial Henchmen Warband", new int[]{1, 1, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Inquisitorial Henchmen Warband", new int[]{4, 16, 0, 0, 0, 0, 0, 0});

        complete();
    }

    @Override
    public void refreshSupplements() {
        if (getSupplementTyp().contains("Enginseer Congregation")) {
            setInformationVectorValue("Enginseer Congregation", 1);
            minAuswahlen.put("Enginseer Congregation", new int[]{1, 0, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Enginseer Congregation", new int[]{1, 1, 0, 0, 0, 0, 0, 0});
        } else {
            setInformationVectorValue("Enginseer Congregation", 0);
        }

        if (getSupplementTyp().contains("Imperial Navy Section")) {
            setInformationVectorValue("Imperial Navy Section", 1);
            minAuswahlen.put("Imperial Navy Section", new int[]{1, 0, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Imperial Navy Section", new int[]{1, 0, 0, 1, 0, 0, 0, 0});
        } else {
            setInformationVectorValue("Imperial Navy Section", 0);
        }

        if (getSupplementTyp().contains("Psykana Division")) {
            setInformationVectorValue("Psykana Division", 1);
            minAuswahlen.put("Psykana Division", new int[]{1, 0, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Psykana Division", new int[]{1, 3, 0, 0, 0, 0, 0, 0});
        } else {
            setInformationVectorValue("Psykana Division", 0);
        }

        if (getSupplementTyp().contains("Ministorum Delegation")) {
            setInformationVectorValue("Ministorum Delegation", 1);
            minAuswahlen.put("Ministorum Delegation", new int[]{1, 0, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Ministorum Delegation", new int[]{1, 1, 0, 0, 0, 0, 0, 0});
        } else {
            setInformationVectorValue("Ministorum Delegation", 0);
        }

        if (getSupplementTyp().contains("Vestal Task Force")) {
            setInformationVectorValue("Vestal Task Force", 1);
            minAuswahlen.put("Vestal Task Force", new int[]{1, 1, 2, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Vestal Task Force", new int[]{2, 3, 6, 3, 3, 0, 0, 0});
        } else {
            setInformationVectorValue("Vestal Task Force", 0);
        }

        if (getSupplementTyp().contains("Deathwatch Kill Team")) {
            setInformationVectorValue("Deathwatch Kill Team", 1);
            minAuswahlen.put("Deathwatch Kill Team", new int[]{0, 0, 1, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Deathwatch Kill Team", new int[]{0, 0, 1, 0, 0, 0, 0, 0});
        } else {
            setInformationVectorValue("Deathwatch Kill Team", 0);
        }

        if (getSupplementTyp().contains("Daemonhunter Strike Force")) {
            setInformationVectorValue("Daemonhunter Strike Force", 1);
            minAuswahlen.put("Daemonhunter Strike Force", new int[]{0, 0, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Daemonhunter Strike Force", new int[]{0, 0, 1, 1, 1, 0, 0, 0});
        } else {
            setInformationVectorValue("Daemonhunter Strike Force", 0);
        }

        if (getSupplementTyp().contains("Spectral Host")) {
            setInformationVectorValue("Spectral Host", 1);
            minAuswahlen.put("Spectral Host", new int[]{0, 1, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Spectral Host", new int[]{0, 4, 0, 0, 0, 0, 0, 0});
        } else {
            setInformationVectorValue("Spectral Host", 0);
        }

        if (getSupplementTyp().contains("Assassinorum Operative")) {
            setInformationVectorValue("Assassinorum Operative", 1);
            minAuswahlen.put("Assassinorum Operative", new int[]{0, 1, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Assassinorum Operative", new int[]{0, 1, 0, 0, 0, 0, 0, 0});
        } else {
            setInformationVectorValue("Assassinorum Operative", 0);
        }

        if (getSupplementTyp().contains("Inquisitorial Representative")) {
            setInformationVectorValue("Inquisitorial Representative", 1);
            minAuswahlen.put("Inquisitorial Representative", new int[]{1, 0, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Inquisitorial Representative", new int[]{1, 3, 0, 0, 0, 0, 0, 0});
        } else {
            setInformationVectorValue("Inquisitorial Representative", 0);
        }

        changeFormations();
    }

    @Override
    public void changeFormations() {
        if (getCountFromInformationVector("Enginseer Congregation") > 0) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Tech Priest Enginseer"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Servitors"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnit(0, "Tech Priest Enginseer");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getCountFromInformationVector("Imperial Navy Section") > 0) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Officer of the Fleet"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Valkyries"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(3, "Valkyries");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getCountFromInformationVector("Psykana Division") > 0) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Primaris Psyker", "Astropath"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Wyrdvane Psykers"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(0, "Primaris Psyker");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getCountFromInformationVector("Ministorum Delegation") > 0) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Ministorum Priest"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Repentiatrupp", "Sororitas Command Squad", "Arco Flagellants", "Crusaders", "Death Cult Assassins", "Celestian Squad"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Ministorum Priest");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getCountFromInformationVector("Vestal Task Force") > 0) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Canoness", "Ministorum Priest", "Uriah Jacobus"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Repentiatrupp", "Sororitas Command Squad", "Arco Flagellants", "Crusaders", "Death Cult Assassins", "Celestian Squad"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Battle Sisters Squad"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Dominion Squad", "Seraphim Squad", "Sororitas Rhino", "Immolator"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Retributor Squad", "Exorcist", "Penitent Engines"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(2, "Battle Sisters Squad");
                addUnit(2, "Battle Sisters Squad");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getCountFromInformationVector("Deathwatch Kill Team") > 0) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"",});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Veterans"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(2, "Veterans");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getCountFromInformationVector("Daemonhunter Strike Force") > 0) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Terminator Squad"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Interceptor Squad"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Nemesis Dreadknight", "Land Raider", "Land Raider Crusader", "Land Raider Redeemer"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getCountFromInformationVector("Spectral Host") > 0) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Damned Legionnaires"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(1, "Damned Legionnaires");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getCountFromInformationVector("Assassinorum Operative") > 0) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Vindicare Assassin", "Callidus Assassin", "Eversor Assassin", "Culexus Assassin"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getCountFromInformationVector("Inquisitorial Representative") > 0) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Inquisitor Coteaz", "Inquisitor Karamazov", "Inquisitor Greyfax", "Ordo Malleus Inquisitor", "Ordo Hereticus Inquisitor", "Ordo Xenos Inquisitor"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Acolytes", "Daemonhost", "Jokaero Weaponsmith"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Chimera"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(7).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        }
    }

    @Override
    public void volkRefresh() {

        if (getKontingentTyp().contains("Ecclesiarchy Battle Conclave")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Ministorum Priest"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Arco Flagellants", "Crusaders", "Death Cult Assassins"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Ministorum Priest");
            }
        } else if (getKontingentTyp().contains("Execution Force")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Vindicare Assassin", "Callidus Assassin", "Eversor Assassin", "Culexus Assassin"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(1, "Vindicare Assassin");
                addUnit(1, "Callidus Assassin");
                addUnit(1, "Eversor Assassin");
                addUnit(1, "Culexus Assassin");
            }
        } else if (getKontingentTyp().contains("Inquisitorial Henchmen Warband")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Inquisitor Coteaz", "Inquisitor Karamazov", "Inquisitor Greyfax", "Ordo Malleus Inquisitor", "Ordo Hereticus Inquisitor", "Ordo Xenos Inquisitor", "Ministorum Priest", "Tech-Priest Enginseer", "Astropath"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Acolytes", "Crusaders", "Daemonhost", "Arco Flagellants", "Death Culst Assassins", "Jokaero Waeponsmith"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(0, "Inquisitor Coteaz");
                addUnit(1, "Acolytes");
            }
        }

        fillChooserSpace();
    }
}
