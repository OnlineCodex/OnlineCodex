package oc.wh40k.armies;

import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKAdeptusSororitas2013 extends BuildaVater {

    public VOLKAdeptusSororitas2013() {
        reflectionKennung = "AS";

        HQeinträge = new String[]{"", "Sankt Celestine", "Uriah Jacobus", "", "Principalis", "Ekklesiarchie KampfKonklave", "Ministorum Priest", "Kommandotrupp", "", "Belisarius Cawl", "Celestine", "Inquisitor Greyfax"};
        Eliteeinträge = new String[]{"", "Celestiatrupp", "Repentiatrupp"};
        Standardeinträge = new String[]{"", "Sororitastrupp"};
        Sturmeinträge = new String[]{"", "Seraphimtrupp", "Dominatortrupp",
                "", "[IA Aeronautica] Aquila Lander", "[IA Aeronautica] Arvus Lighter"};
        Unterstützungeinträge = new String[]{"", "Exorzist", "Läuterer", "Retributortrupp",
                "", "[IA Aeronautica] Avenger Strike Fighter"};
        LordofWar = new String[]{"", "[APO2 Armageddon] Reaver Battle Titan", "[APO2 Armageddon] Warhound-Scouttitan"};

        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, HQ, HQeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, EL, Eliteeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, TR, Standardeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, FA, Sturmeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, HS, Unterstützungeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, "FO", cnt, 0, FORT, Befestigungen));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, "APO", cnt, 0, LOW, LordofWar));

        cnt += 480;

        nameDerArtDerArmee = "Adeptus Sororitas";
        nameDerArtDerArmeeDekliniert = "Adeptus Sororitas";
        textAreaUeberschrift = "Adeptus Sororitas";

        noAllies.clear();
        noAllies.add("AS");

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

        complete();
    }
}