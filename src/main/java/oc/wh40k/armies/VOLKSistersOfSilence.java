package oc.wh40k.armies;

import oc.BuildaVater;
import oc.ChooserGruppe;
import oc.Formation;
import oc.FormationEntry;

public class VOLKSistersOfSilence extends BuildaVater {

    public VOLKSistersOfSilence() {
        reflectionKennung = "SO";

        HQeinträge = new String[]{""};
        Eliteeinträge = new String[]{"", "Sisters Of Silence Squad"};
        Standardeinträge = new String[]{""};
        Sturmeinträge = new String[]{""};
        Unterstützungeinträge = new String[]{""};
        Befestigungen = new String[]{""};
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

        nameDerArtDerArmee = "Sister of Silence";
        nameDerArtDerArmeeDekliniert = "Sister of Silence";
        textAreaUeberschrift = "Sister of Silence";

        noAllies.clear();
        noAllies.add("SO");

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
        battleBrothers.add("DW");
        battleBrothers.add("SO");
        battleBrothers.add("AC");

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

        //Formationen
        formationen.add("Null-Maiden Task Force");

        minAuswahlen.put("Null-Maiden Task Force", new int[]{0, 1, 0, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Null-Maiden Task Force", new int[]{0, 3, 0, 0, 0, 0, 0, 0});

        complete();
    }

    @Override
    public void volkRefresh() {

        if (getKontingentTyp().equals("Null-Maiden Task Force")) {

            clearCombo();

            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{"", "Sisters Of Silence Squad"});

            formation = new Formation(this);
            formation.entries.add(new FormationEntry(new String[]{"Sisters Of Silence Squad"}, 1, 3));

            if (!isLoading) {
                addUnit(1, "Sisters Of Silence Squad");
            }

        }
    }
}