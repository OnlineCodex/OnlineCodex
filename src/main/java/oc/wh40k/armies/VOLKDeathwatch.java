package oc.wh40k.armies;

import oc.BuildaVater;
import oc.ChooserGruppe;
import oc.RefreshListener;
import oc.Superformation;

public class VOLKDeathwatch extends BuildaVater {

    public VOLKDeathwatch() {
        reflectionKennung = "DW";

        HQeinträge = new String[]{"", "Watch Master", "Chaplain", "Watch Captain", "Librarian", "", "Watch Captain Artemis", "Orthan Cassius", "Jensus Natorian"};
        Eliteeinträge = new String[]{"", "Terminators", "Dreadnought", "Venerable Dreadnought", "Vanguard Veterans", "", "Squad Galatael", "Venerable Dreadnought Nihilus", "Edryc Setorax", "Antor Delassio", "Garran Branatar"};
        Standardeinträge = new String[]{"", "Veterans", "Squad Donatus", "Squad Crull"};
        Sturmeinträge = new String[]{"", "Bikers", "Razorback", "Corvus Blackstar", "Drop Pod", "Rhino", "Jetek Suberei"};
        Unterstützungeinträge = new String[]{"", "Land Raider", "Land Raider Crusader", "Land Raider Redeemer"};
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
        adden(new ChooserGruppe(this, "APO", cnt, 0, 7, LordofWar));
        cnt += 480;

        nameDerArtDerArmee = "Deathwatch";
        nameDerArtDerArmeeDekliniert = "Deathwatch";
        textAreaUeberschrift = "Deathwatch";

        noAllies.clear();
        noAllies.add("DW");

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
        kontingente.add("");
        kontingente.add("Black Spear Strike Force"); //Superformation
        kontingente.add("Strategium Command Team"); //Superformation
        kontingente.add("Watch Company"); //Superformation

        //Formationen
        formationen.add("Kill Team Cassius");

        minAuswahlen.put("Kill Team Cassius", new int[]{2, 3, 1, 1, 0, 0, 0, 0});
        maxAuswahlen.put("Kill Team Cassius", new int[]{2, 3, 1, 1, 0, 0, 0, 0});

        formationen.add("Watch Force Artemis");

        minAuswahlen.put("Watch Force Artemis", new int[]{1, 2, 1, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Watch Force Artemis", new int[]{1, 2, 1, 0, 0, 0, 0, 0});

        formationen.add("Aquila Kill Team");

        minAuswahlen.put("Aquila Kill Team", new int[]{0, 0, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Aquila Kill Team", new int[]{5, 5, 1, 5, 0, 0, 0, 0});

        formationen.add("Venator Kill Team");

        minAuswahlen.put("Venator Kill Team", new int[]{0, 0, 1, 1, 0, 0, 0, 0});
        maxAuswahlen.put("Venator Kill Team", new int[]{5, 5, 5, 5, 0, 0, 0, 0});

        formationen.add("Purgatus Kill Team");

        minAuswahlen.put("Purgatus Kill Team", new int[]{1, 1, 1, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Purgatus Kill Team", new int[]{5, 5, 5, 5, 0, 0, 0, 0});

        formationen.add("Dominatus Kill Team");

        minAuswahlen.put("Dominatus Kill Team", new int[]{0, 1, 1, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Dominatus Kill Team", new int[]{5, 5, 5, 5, 0, 0, 0, 0});

        formationen.add("Furor Kill Team");

        minAuswahlen.put("Furor Kill Team", new int[]{0, 1, 1, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Furor Kill Team", new int[]{5, 5, 5, 5, 0, 0, 0, 0});

        formationen.add("Malleus Kill Team");

        minAuswahlen.put("Malleus Kill Team", new int[]{0, 1, 1, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Malleus Kill Team", new int[]{5, 5, 5, 5, 0, 0, 0, 0});

        formationen.add("Dropship Wing");

        minAuswahlen.put("Dropship Wing", new int[]{0, 0, 0, 3, 0, 0, 0, 0});
        maxAuswahlen.put("Dropship Wing", new int[]{0, 0, 0, 3, 0, 0, 0, 0});

        minAuswahlen.put("Black Spear Strike Force", new int[]{0, 0, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Black Spear Strike Force", new int[]{0, 0, 0, 0, 0, 0, 0, 0});

        complete();

    }

    @Override
    public void volkRefresh() {

        setInformationVectorValue("Black Spear", 0);
        setInformationVectorValue("Watch Commander", 0);
        setInformationVectorValue("Strategium Command", 0);
        setInformationVectorValue("Watch Company", 0);

        if (getKontingentTyp().equals("Kill Team Cassius")) {
            if (!isLoading) {
                addUnit(0, "Orthan Cassius");
                addUnit(0, "Jensus Natorian");
                addUnit(0, "");
                addUnit(1, "Edryc Setorax");
                addUnit(1, "Antor Delassio");
                addUnit(1, "Garran Branatar");
                addUnit(1, "");
                addUnit(2, "Squad Donatus");
                addUnit(2, "");
                addUnit(3, "Jetek Suberei");
                addUnit(3, "");
            }

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        }

        if (getKontingentTyp().equals("Watch Force Artemis")) {

            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Watch Captain Artemis"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Squad Galatael", "Venerable Dreadnought Nihilus"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Squad Crull"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnit(0, "Watch Captain Artemis");
                addUnit(0, "");
                addUnit(1, "Squad Galatael");
                addUnit(1, "Venerable Dreadnought Nihilus");
                addUnit(1, "");
                addUnit(2, "Squad Crull");
                addUnit(2, "");
                addUnit(3, "");
            }

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        }

        if (getKontingentTyp().equals("Aquila Kill Team")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Librarian"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Vanguard Veterans", "Terminators"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Veterans"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Bikers"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnit(2, "Veterans");
                addUnit(2, "");
            }

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        }

        if (getKontingentTyp().equals("Venator Kill Team")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Librarian"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Vanguard Veterans", "Terminators"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Veterans"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Bikers"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnit(2, "Veterans");
                addUnit(2, "");
                addUnit(3, "Bikers");
                addUnit(3, "");
            }

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        }

        if (getKontingentTyp().equals("Purgatus Kill Team")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Librarian"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Vanguard Veterans", "Terminators"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Veterans"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Bikers"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnit(0, "Librarian");
                addUnit(1, "Terminators");
                addUnit(2, "Veterans");
                addUnit(2, "");
            }

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        }

        if (getKontingentTyp().equals("Dominatus Kill Team")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Librarian"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Vanguard Veterans", "Terminators"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Veterans"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Bikers"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnit(1, "Vanguard Veterans");
                addUnit(2, "Veterans");
                addUnit(2, "");
            }

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        }

        if (getKontingentTyp().equals("Furor Kill Team")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Librarian"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Vanguard Veterans", "Terminators"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Veterans"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Bikers"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnit(1, "Terminators");
                addUnit(2, "Veterans");
                addUnit(2, "");
            }

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        }

        if (getKontingentTyp().equals("Malleus Kill Team")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Librarian"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Vanguard Veterans", "Terminators"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Veterans"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Bikers"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnit(1, "Terminators");
                addUnit(2, "Veterans");
                addUnit(2, "");
            }

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        }

        if (getKontingentTyp().equals("Dropship Wing")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Corvus Blackstar"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnit(3, "Corvus Blackstar");
                addUnit(3, "Corvus Blackstar");
                addUnit(3, "Corvus Blackstar");
                addUnit(3, "");
            }

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        }

        if (getKontingentTyp().equals("Dropship")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Corvus Blackstar"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnit(3, "Corvus Blackstar");
                addUnit(3, "");
            }

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        }

        if (getKontingentTyp().equals("Ancient")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Dreadnought", "Venerable Dreadnought"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnitNotLocked(1, "Dreadnought");
                addUnit(1, "");
            }

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        }

        if (getKontingentTyp().equals("Armour")) {
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Land Raider", "Land Raider Redeemer", "Land Raider Crusader"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnitNotLocked(4, "Land Raider");
                addUnit(4, "");
            }

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        }

        if (getKontingentTyp().equals("Black Spear Strike Force")) { //Superformation))
            setInformationVectorValue("Black Spear", 1);
            superformation = new Superformation(getPanel(), 0);
            superformation.reflectionKennungLokal = reflectionKennungLokal;
            superformation.volkFile = getClass().getName();
            superformation.tA = buildatextArea;
            superformation.buildaVater = this;

            superformation.minCommand = 1;
            superformation.maxCommand = 3;
            superformation.minCore = 1;
            superformation.maxCore = Integer.MAX_VALUE;
            superformation.minAuxiliary = 1;
            superformation.maxAuxiliary = Integer.MAX_VALUE;

            superformation.namenCommand.add("");
            superformation.namenCommand.add("Watch Commander");
            superformation.namenCommand.add("");

            superformation.namenCore.add("");
            superformation.namenCore.add("Kill Team");
            superformation.namenCore.add("Aquila Kill Team");
            superformation.namenCore.add("Furor Kill Team");
            superformation.namenCore.add("Venator Kill Team");
            superformation.namenCore.add("Malleus Kill Team");
            superformation.namenCore.add("Dominatus Kill Team");
            superformation.namenCore.add("Purgatos Kill Team");

            superformation.namenAuxiliary.add("");
            superformation.namenAuxiliary.add("Dropship");
            superformation.namenAuxiliary.add("Ancient");
            superformation.namenAuxiliary.add("Armour");
            superformation.namenAuxiliary.add("Dropship Wing");


            for (int i = 0; i < myChooserGruppen.size(); i++) {
                myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
            }

            superformation.refreshControlPanel();

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);

            RefreshListener.fireRefresh();
        }

        if (getKontingentTyp().equals("Strategium Command Team")) { //Superformation))
            setInformationVectorValue("Strategium Command", 1);
            superformation = new Superformation(getPanel(), 0);
            superformation.reflectionKennungLokal = reflectionKennungLokal;
            superformation.volkFile = getClass().getName();
            superformation.tA = buildatextArea;
            superformation.buildaVater = this;

            superformation.minCommand = 1;
            superformation.maxCommand = 1;
            superformation.minCore = 1;
            superformation.maxCore = 1;
            superformation.minAuxiliary = 0;
            superformation.maxAuxiliary = 0;

            superformation.namenCommand.add("");
            superformation.namenCommand.add("Strategium Command");
            superformation.namenCommand.add("");

            superformation.namenCore.add("");
            superformation.namenCore.add("Kill Team");
            superformation.namenCore.add("Aquila Kill Team");
            superformation.namenCore.add("Furor Kill Team");
            superformation.namenCore.add("Venator Kill Team");
            superformation.namenCore.add("Malleus Kill Team");
            superformation.namenCore.add("Dominatus Kill Team");
            superformation.namenCore.add("Purgatos Kill Team");

            for (int i = 0; i < myChooserGruppen.size(); i++) {
                myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
            }

            superformation.refreshControlPanel();

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);

            RefreshListener.fireRefresh();
        }

        if (getKontingentTyp().equals("Watch Company")) { //Superformation))
            setInformationVectorValue("Watch Company", 1);
            superformation = new Superformation(getPanel(), 0);
            superformation.reflectionKennungLokal = reflectionKennungLokal;
            superformation.volkFile = getClass().getName();
            superformation.tA = buildatextArea;
            superformation.buildaVater = this;

            superformation.minCommand = 1;
            superformation.maxCommand = 1;
            superformation.minCore = 4;
            superformation.maxCore = 4;
            superformation.minAuxiliary = 0;
            superformation.maxAuxiliary = 0;

            superformation.namenCommand.add("");
            superformation.namenCommand.add("Watch Captain");
            superformation.namenCommand.add("");

            superformation.namenCore.add("");
            superformation.namenCore.add("Kill Team");
            superformation.namenCore.add("Aquila Kill Team");
            superformation.namenCore.add("Furor Kill Team");
            superformation.namenCore.add("Venator Kill Team");
            superformation.namenCore.add("Malleus Kill Team");
            superformation.namenCore.add("Dominatus Kill Team");
            superformation.namenCore.add("Purgatos Kill Team");

            for (int i = 0; i < myChooserGruppen.size(); i++) {
                myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
            }

            superformation.refreshControlPanel();

            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);

            RefreshListener.fireRefresh();
        }

        if (getKontingentTyp().equals("Watch Commander")) {
            setInformationVectorValue("Watch Commander", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Watch Master", "Watch Captain", "Chaplain", "Librarian"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Dreadnought", "Venerable Dreadnought"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(0, "Watch Master");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        }

        if (getKontingentTyp().equals("Strategium Command")) {
            setInformationVectorValue("Strategium Command", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Watch Captain", "Chaplain", "Librarian"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnitNotLocked(0, "Watch Captain");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        }

        if (getKontingentTyp().equals("Kill Team")) {
            setInformationVectorValue("Kill Team", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Veterans"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(2, "Veterans");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        }

        fillChooserSpace();
    }

    public void changeFormations() {
        if (getCountFromInformationVector("Black Spear") > 0) {
            formationBox.addItem("Watch Commander");

            minAuswahlen.put("Watch Commander", new int[]{0, 0, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Watch Commander", new int[]{1, 1, 0, 0, 0, 0, 0, 0});

            formationBox.addItem("Kill Team");

            minAuswahlen.put("Kill Team", new int[]{0, 0, 1, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Kill Team", new int[]{0, 0, 1, 0, 0, 0, 0, 0});

            formationBox.addItem("Dropship");

            minAuswahlen.put("Dropship", new int[]{0, 0, 0, 1, 0, 0, 0, 0});
            maxAuswahlen.put("Dropship", new int[]{0, 0, 0, 1, 0, 0, 0, 0});

            formationBox.addItem("Ancient");

            minAuswahlen.put("Ancient", new int[]{0, 1, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Ancient", new int[]{0, 1, 0, 0, 0, 0, 0, 0});

            formationBox.addItem("Armour");

            minAuswahlen.put("Armour", new int[]{0, 0, 0, 0, 1, 0, 0, 0});
            maxAuswahlen.put("Armour", new int[]{0, 0, 0, 0, 1, 0, 0, 0});
        } else if (getCountFromInformationVector("Strategium Command") > 0) {
            formationBox.addItem("Strategium Command");

            minAuswahlen.put("Strategium Command", new int[]{1, 0, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Strategium Command", new int[]{1, 0, 0, 0, 0, 0, 0, 0});

            formationBox.addItem("Kill Team");

            minAuswahlen.put("Kill Team", new int[]{0, 0, 1, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Kill Team", new int[]{0, 0, 1, 0, 0, 0, 0, 0});
        } else if (getCountFromInformationVector("Watch Company") > 0) {
            formationBox.addItem("Strategium Command");

            minAuswahlen.put("Strategium Command", new int[]{1, 0, 0, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Strategium Command", new int[]{1, 0, 0, 0, 0, 0, 0, 0});
            addUnit(0, "Watch Captain");
            addUnit(0, "");

            formationBox.addItem("Kill Team");

            minAuswahlen.put("Kill Team", new int[]{0, 0, 1, 0, 0, 0, 0, 0});
            maxAuswahlen.put("Kill Team", new int[]{0, 0, 1, 0, 0, 0, 0, 0});
        }
    }
}