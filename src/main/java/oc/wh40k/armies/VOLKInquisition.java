package oc.wh40k.armies;

import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKInquisition extends BuildaVater {

    public VOLKInquisition() {

        reflectionKennung = "IN";

        HQeinträge = new String[]{"", "Inquisitor des Ordo Malleus", "Inquisitor des Ordo Hereticus", "Inquisitor des Ordo Xenos", "", "Inquisitor Coteaz", "Inquisitor Karamasov", "",
                "Belisarius Cawl", "Celestine", "Inquisitor Greyfax",
                "", "[IA5 2nd Ed] Inquisitor-Lord Hector Rex", "[IA4 2nd Ed] Ordo Xenos Inquisitor Solomon Lok"};
        Eliteeinträge = new String[]{"", "Gefolge des Inquisitors"};
        Standardeinträge = new String[]{""};
        Sturmeinträge = new String[]{"", "[IA2 2nd Ed] Inquisitorial Valkyrie Squadron"};//Über das FAQ möglich
        Unterstützungeinträge = new String[]{""};
        Befestigungen = new String[]{""};
        LordofWar = new String[]{""};

        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 1, HQeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 2, Eliteeinträge));
        adden(new ChooserGruppe(this, reflectionKennung, outOfPanel, 0, 3, Standardeinträge));
        adden(new ChooserGruppe(this, reflectionKennung, outOfPanel, 0, 4, Sturmeinträge));
        adden(new ChooserGruppe(this, reflectionKennung, outOfPanel, 0, 5, Unterstützungeinträge));
//		adden(new ChooserGruppe(this,"FO", outOfPanel, 0, 6, Befestigungen));
        adden(new ChooserGruppe(this, reflectionKennung, outOfPanel, 0, 6, Befestigungen));
        adden(new ChooserGruppe(this, reflectionKennung, outOfPanel, 0, 7, LordofWar));
        cnt += 480;

        nameDerArtDerArmee = "Inquisition";
        nameDerArtDerArmeeDekliniert = "Inquisition";
        textAreaUeberschrift = "Inquisition";

        noAllies.clear();

        noAllies.add("IN");

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

        //Es gibt nur das Inquisitionskontingent
        kontingente.clear();
        kontingente.add(0, "Inquisitionskontingent");

        //Min/max-Auswahlen je Spezialkontingent
        int[] arr1 = {1, 0, 0, 0, 0, 0, 0, 0};
        minAuswahlen.put("Inquisitionskontingent", arr1);
        int[] arr2 = {2, 3, 0, 1, 0, 0, 0, 0};
        maxAuswahlen.put("Inquisitionskontingent", arr2);

        complete();
    }

    @Override
    public void volkRefresh() {
        //Es gibt nur das Inquisitionskontingent
        kontingente.clear();
        kontingente.add("Inquisitionskontingent");

        fillChooserSpace();
    }

    @Override
    protected void finalize() {
        System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
    }

}