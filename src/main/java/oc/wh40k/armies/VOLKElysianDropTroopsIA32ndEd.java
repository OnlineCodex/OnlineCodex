package oc.wh40k.armies;


import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKElysianDropTroopsIA32ndEd extends BuildaVater {

    public VOLKElysianDropTroopsIA32ndEd() {
        reflectionKennung = "ED";

        HQeinträge = new String[]{"", "Company Command Squad", "Lord Commissar",
                "", "[IA8] Captain Thanstadt", "[IA8] Sword Force Command Squad", "[IA8] A-Company Command Tauros"};
        Eliteeinträge = new String[]{"", "Storm Trooper Squad", "Drop Sentinel Squadron"};
        Standardeinträge = new String[]{"", "Drop Infantry Platoon", "Veteran Squad"};
        Sturmeinträge = new String[]{"", "Tauros Squadron", "Vendetta Gunship Squadron", "Vulture Gunship Squadron"};
        Unterstützungeinträge = new String[]{"", "Sentry Gun Battery", "Cyclops Demolition Squad", "Thunderbolt", "Lightning", "Avenger"};
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

        nameDerArtDerArmee = "Elysian Drop Troop";
        nameDerArtDerArmeeDekliniert = "Elysian Drop Troop";
        textAreaUeberschrift = "Elysian Drop Troop";

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

    protected void finalize() {
        System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
    }

}
