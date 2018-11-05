package oc.wh40k.armies;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKHarlequins extends BuildaVater {

    String[] HQeinträge;
    String[] Eliteeinträge;
    String[] Standardeinträge;
    String[] Sturmeinträge;
    String[] Unterstützungeinträge;
    String[] Befestigungen;
    String[] LordofWar;

    public VOLKHarlequins() {
        reflectionKennung = "HQ";

        HQeinträge = new String[]{"", "Eldrad Ulthran"};
        Eliteeinträge = new String[]{"", "Death Jester", "Shadowseer", "Solitaire", "", "InriamsSpectre"};
        Standardeinträge = new String[]{"", "Troupe", "", "Deaths Companions", "Company Of The Threefold Stranger"};
        Sturmeinträge = new String[]{"", "Skyweaver", "Starweaver", "", "The Blades Of Fate"};
        Unterstützungeinträge = new String[]{"", "Voidweaver", "", "The Serpents Breath"};
        Befestigungen = new String[]{""};
        LordofWar = new String[]{""};


        adden(new ChooserGruppe(this, reflectionKennung, outOfPanel, 0, 1, HQeinträge));
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 2, Eliteeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 3, Standardeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 4, Sturmeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 5, Unterstützungeinträge));
        adden(new ChooserGruppe(this, "FO", outOfPanel, 0, 6, Befestigungen));
        adden(new ChooserGruppe(this, reflectionKennung, outOfPanel, 0, 7, LordofWar));

        cnt += 480;

        nameDerArtDerArmee = "Harlequins";
        nameDerArtDerArmeeDekliniert = "Harlequins";
        textAreaUeberschrift = BuildaHQ.translate("Meine") + " Harlequins " + BuildaHQ.translate("Armee");

        noAllies.clear();

        noAllies.add("HQ");

        battleBrothers.add("DE");
        battleBrothers.add("EC");
        battleBrothers.add("EL");
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


        //Verschiedene Spezialkontingente der Orks
//				kontingentBox.removeAllItems();
//				kontingente.clear();
        kontingente.add("");
        kontingente.add("Harlequin Detachment");

        //Formationen
        formationen.add("Cegorach's Revenge");
        formationen.add("The Serpent's Brood");
        formationen.add("Cast of Players");
        formationen.add("Cegorach's Jest");
        formationen.add("The Heroes' Path");
        formationen.add("Faolchús Blade");
        formationen.add("The Coherian Host");

        //Min/max-Auswahlen je Spezialkontingent/Formation
        int[] arr1 = {0, 0, 3, 2, 1, 0, 0, 0};
        minAuswahlen.put("Harlequin Detachment", arr1);
        int[] arr2 = {0, 7, 3, 2, 1, 0, 0, 0};
        maxAuswahlen.put("Harlequin Detachment", arr2);

        minAuswahlen.put("Cegorach's Revenge", arr2);
        maxAuswahlen.put("Cegorach's Revenge", arr2);

        int[] arr4 = {0, 0, 3, 2, 1, 0, 0, 0};
        minAuswahlen.put("The Serpent's Brood", arr4);
        maxAuswahlen.put("The Serpent's Brood", arr4);

        int[] arr5 = {0, 2, 1, 0, 0, 0, 0, 0};
        minAuswahlen.put("Cast of Players", arr5);
        maxAuswahlen.put("Cast of Players", arr5);

        int[] arr6 = {0, 0, 1, 1, 1, 0, 0, 1};
        minAuswahlen.put("Cegorach's Jest", arr6);
        maxAuswahlen.put("Cegorach's Jest", arr6);

        int[] arr7 = {0, 3, 0, 0, 0, 0, 0, 1};
        minAuswahlen.put("The Heroes' Path", arr7);
        maxAuswahlen.put("The Heroes' Path", arr7);

        int[] arr8 = {0, 0, 0, 2, 1, 0, 0, 1};
        minAuswahlen.put("Faolchús Blade", arr8);
        maxAuswahlen.put("Faolchús Blade", arr8);

        int[] arr9 = {1, 1, 2, 1, 1, 0, 0, 0};
        minAuswahlen.put("The Coherian Host", arr9);
        maxAuswahlen.put("The Coherian Host", arr9);


        complete();
    }

    @Override
    public void volkRefresh() {

        setInformationVectorValue("Serpents Brood", 0);

        if (getKontingentTyp().contains("Cegorach's Revenge")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Death Jester", "Shadowseer", "Solitaire", "Inriams Spectre"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Troupe", "Deaths Companions", "Company Of The Threefold Stranger"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Skyweaver", "Starweaver", "The Blades Of Fate"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Voidweaver"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(1, "Death Jester");
                addUnit(1, "Death Jester");
                addUnit(1, "Death Jester");
                addUnit(1, "Shadowseer");
                addUnit(1, "Shadowseer");
                addUnit(1, "Shadowseer");
                addUnit(1, "Solitaire");
                addUnit(1, "");

                addUnitNotLocked(2, "Troupe");
                addUnitNotLocked(2, "Troupe");
                addUnit(2, "Troupe");
                addUnit(2, "");

                addUnitNotLocked(3, "Skyweaver");
                addUnit(3, "Skyweaver");
                addUnit(3, "");

                addUnitNotLocked(4, "Voidweaver");
                addUnit(4, "");
            }

        } else if (getKontingentTyp().contains("The Serpent's Brood")) {
            setInformationVectorValue("Serpents Brood", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Troupe", "Deaths Companions", "Company Of The Threefold Stranger"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Skyweaver", "The Blades Of Fate"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Voidweaver", "The Serpents Breath"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(2, "Troupe");
                addUnitNotLocked(2, "Troupe");
                addUnit(2, "Troupe");
                addUnit(2, "");

                addUnitNotLocked(3, "Skyweaver");
                addUnit(3, "Skyweaver");
                addUnit(3, "");

                addUnitNotLocked(4, "Voidweaver");
                addUnit(4, "");
            }
        } else if (getKontingentTyp().contains("Cast of Players")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Death Jester", "Shadowseer", "Inriams Spectre"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Troupe", "Deaths Companions", "Company Of The Threefold Stranger"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(1, "Death Jester");
                addUnit(1, "Shadowseer");
                addUnit(1, "");
                addUnitNotLocked(2, "Troupe");
                addUnit(2, "");
            }
        } else if (getKontingentTyp().contains("Cegorach's Jest")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Troupe", "Deaths Companions", "Company Of The Threefold Stranger"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Skyweaver", "The Blades Of Fate"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Voidweaver", "The Serpents Breath"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(2, "Troupe");
                addUnit(2, "");
                addUnitNotLocked(3, "Skyweaver");
                addUnit(3, "");
                addUnitNotLocked(4, "Voidweaver");
                addUnit(4, "");
            }
        } else if (getKontingentTyp().contains("The Heroes' Path")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Death Jester", "Shadowseer", "Solitaire", "Inriams Spectre"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(1, "Death Jester");
                addUnit(1, "Shadowseer");
                addUnit(1, "Solitaire");
                addUnit(1, "");
            }
        } else if (getKontingentTyp().contains("Faolchús Blade")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Skyweaver", "The Blades Of Fate"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Voidweaver", "The Serpents Breath"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(3, "Skyweaver");
                addUnit(3, "Skyweaver");
                addUnit(3, "");
                addUnitNotLocked(4, "Voidweaver");
                addUnit(4, "");
            }
        } else if (getKontingentTyp().contains("The Coherian Host")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Eldrad Ulthran"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Inriams Spectre"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Deaths Companions", "Company Of The Threefold Stranger"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "The Blades Of Fate"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "The Serpents Breath"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Eldrad Ulthran");
                addUnit(0, "");
                addUnit(1, "Inriams Spectre");
                addUnit(1, "");
                addUnit(2, "Deaths Companions");
                addUnit(2, "Company Of The Threefold Stranger");
                addUnit(2, "");
                addUnit(3, "The Blades Of Fate");
                addUnit(3, "");
                addUnit(4, "The Serpents Breath");
                addUnit(4, "");
            }
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