package oc.wh40k.armies;

import oc.*;

public class VOLKSkitarii extends BuildaVater {

    public VOLKSkitarii() {
        reflectionKennung = "SK";

        HQeinträge = new String[]{"", "Belisarius Cawl", "Celestine", "Inquisitor Greyfax"};
        Eliteeinträge = new String[]{"", "Sicarian Ruststalkers", "Sicarian Infiltrators"};
        Standardeinträge = new String[]{"", "Skitarii Vanguard", "Skitarii Rangers"};
        Sturmeinträge = new String[]{"", "Sydonian Dragoons"};
        Unterstützungeinträge = new String[]{"", "Ironstrider Ballistarii", "Onager Dunecrawlers"};
        LordofWar = new String[]{""};

        adden(new ChooserGruppe(this, reflectionKennung, outOfPanel, 0, 1, HQeinträge));
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 2, Eliteeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 3, Standardeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 4, Sturmeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 5, Unterstützungeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, "FO", cnt, 0, 6, Befestigungen));
        adden(new ChooserGruppe(this, "APO", outOfPanel, 0, 7, LordofWar));

        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

        nameDerArtDerArmee = "Skitarii";
        nameDerArtDerArmeeDekliniert = "Skitarii";
        textAreaUeberschrift = BuildaHQ.translate("Skitarii");

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

        //Verschiedene Spezialkontingente der Skitarii
        kontingente.add("");
        kontingente.add("Skitarii Maniple");
        kontingente.add("");
        kontingente.add("Adeptus Mechanicus War Convocation");

        //Formationen
        formationen.add("Battle Maniple");
        formationen.add("War Cohort");
        formationen.add("Sicarian Killclade");
        formationen.add("Ironstrider Cavaliers");
        formationen.add("");
        formationen.add("Dominus Maniple (Start Collecting)");

        //Min/max-Auswahlen je Spezialkontingent/Formation
        int[] arr1 = {0, 0, 2, 0, 0, 0, 0, 0};
        minAuswahlen.put("Skitarii Maniple", arr1);
        int[] arr2 = {0, 4, 8, 2, 4, 1, 0, 0};
        maxAuswahlen.put("Skitarii Maniple", arr2);

        int[] arr3 = {0, 2, 2, 0, 1, 0, 0, 0};
        minAuswahlen.put("Battle Maniple", arr3);
        int[] arr4 = {0, 2, 2, 1, 2, 0, 0, 0};
        maxAuswahlen.put("Battle Maniple", arr4);

        int[] arr5 = {0, 6, 6, 0, 3, 0, 0, 0};
        minAuswahlen.put("War Cohort", arr5);
        int[] arr6 = {0, 6, 6, 3, 6, 0, 0, 0};
        maxAuswahlen.put("War Cohort", arr6);

        int[] arr7 = {0, 4, 0, 0, 0, 0, 0, 0};
        minAuswahlen.put("Sicarian Killclade", arr7);
        maxAuswahlen.put("Sicarian Killclade", arr7);

        int[] arr8 = {0, 0, 0, 2, 1, 0, 0, 0};
        minAuswahlen.put("Ironstrider Cavaliers", arr8);
        maxAuswahlen.put("Ironstrider Cavaliers", arr8);

        minAuswahlen.put("Dominus Maniple (Start Collecting)", new int[]{1, 0, 1, 0, 1, 0, 0, 0});
        maxAuswahlen.put("Dominus Maniple (Start Collecting)", new int[]{1, 0, 1, 0, 1, 0, 0, 0});

        int[] arr10 = {0, 0, 0, 0, 0, 0, 0, 0};
        minAuswahlen.put("Adeptus Mechanicus War Convocation", arr10);
        minAuswahlen.put("Adeptus Mechanicus War Convocation", arr10);


        complete();
    }

    @Override
    public void volkRefresh() {
        //TODO Auswahlliste Einfügen


        if (getKontingentTyp().equals("Adeptus Mechanicus War Convocation")) { //Superformation))
            setInformationVectorValue("Adeptus Mechanicus War Convocation", 1);
            superformation = new Superformation(getPanel(), 1);
            superformation.reflectionKennungLokal = "";
            superformation.volkFile = getClass().getName();
            superformation.tA = buildatextArea;
            superformation.buildaVater = this;

            superformation.createKategorieDynamisch(1, 1);
            superformation.addEintragDynamisch("", "");
            superformation.addEintragDynamisch("CU", "Battle Congregation"); //1

            superformation.createKategorieDynamisch(1, 1);
            superformation.addEintragDynamisch("", "");
            superformation.addEintragDynamisch("SK", "Battle Maniple"); //1

            superformation.createKategorieDynamisch(1, 1);
            superformation.addEintragDynamisch("", "");
            superformation.addEintragDynamisch("IR", "Eidgebundenen-Kontingent"); //1

            for (int i = 0; i < myChooserGruppen.size(); i++) {
                myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
            }

            superformation.refreshControlPanel();

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);

            RefreshListener.fireRefresh();
        } else if (getKontingentTyp().contains("Dominus Maniple (Start Collecting)")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Tech-Priest Dominus"});
            myChooserGruppen.get(0).setReflectionKennung("CU");
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Skitarii Vanguard"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Onager Dunecrawlers"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Tech-Priest Dominus");
                addUnit(0, "");
                addUnit(2, "Skitarii Vanguard");
                addUnit(2, "");
                addUnit(4, "Onager Dunecrawlers");
                addUnit(4, "");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else if (getKontingentTyp().contains("Battle Maniple")) {
            if (!isLoading) {
                addUnit(1, "Sicarian Ruststalkers");
                addUnit(1, "Sicarian Infiltrators");

                addUnit(2, "Skitarii Vanguard");
                addUnit(2, "Skitarii Rangers");

                addUnit(4, "Onager Dunecrawlers");
            }
        } else if (getKontingentTyp().contains("War Cohort")) {
            if (!isLoading) {
                addUnit(1, "Sicarian Ruststalkers");
                addUnit(1, "Sicarian Ruststalkers");
                addUnit(1, "Sicarian Ruststalkers");
                addUnit(1, "Sicarian Infiltrators");
                addUnit(1, "Sicarian Infiltrators");
                addUnit(1, "Sicarian Infiltrators");

                addUnit(2, "Skitarii Vanguard");
                addUnit(2, "Skitarii Vanguard");
                addUnit(2, "Skitarii Vanguard");
                addUnit(2, "Skitarii Rangers");
                addUnit(2, "Skitarii Rangers");
                addUnit(2, "Skitarii Rangers");

                addUnit(4, "Onager Dunecrawlers");
                addUnit(4, "Onager Dunecrawlers");
                addUnit(4, "Onager Dunecrawlers");
            }
        } else if (getKontingentTyp().contains("Sicarian Killclade")) {
            if (!isLoading) {
                addUnit(1, "Sicarian Ruststalkers");
                addUnit(1, "Sicarian Ruststalkers");
                addUnit(1, "Sicarian Ruststalkers");
                addUnit(1, "Sicarian Infiltrators");
            }
        } else if (getKontingentTyp().contains("Ironstrider Cavaliers")) {
            if (!isLoading) {
                addUnit(3, "Sydonian Dragoons");
                addUnit(3, "Sydonian Dragoons");
                addUnit(4, "Ironstrider Ballistarii");
            }
        }

        fillChooserSpace();
    }

    @Override
    protected void finalize() {
        System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
    }
}

//Enhanced data-tether= Verbesserte Dataverbindung
//Arc rifle= Lichtbogen-Gewehr
//Transuranic arquebus= Transuranische Arkebuse
//Plasma Caliver= Plasma-Kaliver
//Radium Carbine= Radium-Karabiner
//Phosphor blast pistol= Phosphorblast-Pistole
//Radium pistol= Radium-Pistole
//Arc pistol= Lichtbogen-Pistole
//Taser goad= Taserstab
//Power Sword= Energieschwert
//Arc maul= Lichtbogen-Streikolben
//Refractor field= Refraktorfeld
//Conversion field= Konverterfeld
//Digital weapon= Digitalwaffen
//Arkhan's Divinator= Arkhans Divinator
//The Phase Taser= Phasentaser
//The Omniscent Mask= Maske der Allwissenheit
//Phosphoenix= Phosphönix
//The Skull of Elder Nikola= Schädel des Ältesten Nikola
//Galvanic rifle= Galvanisches Gewehr
//Taser lance= Taserlanze
//Radium jezzail= Radium-Jezzail
//Phosphor Serpenta= Phosphor-Serpenta
//sync. Cognis autocannon= sync. Cognis-Maschinenkanone
//sync. Cognis lascannon= sync. Cognis-Laserkanone
//Eradiction beamer= Vernichtungsstrahler
//sync. schwerer phosphor blaster= sync. schwerer Phosphorblaster
//Neutron Laser and cognis heavy stubber=
//Neutronenlaser und Cognis-Maschinengewehr
//Icarus array= Ikarus-Waffenstation
//Cognis heavy stubber= Cognis-Maschinengewehr
//Smoke launchers= Nebelwerfer
//Mindscanner probe= Geistscannersonde
//Cognis manipulator= Cognis-Manipulator
