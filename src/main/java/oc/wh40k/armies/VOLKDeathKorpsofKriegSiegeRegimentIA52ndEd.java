/* Regeln aus Imperial Armour Volume Five 2nd Edition
 */

package oc.wh40k.armies;


import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKDeathKorpsofKriegSiegeRegimentIA52ndEd extends BuildaVater {

    public VOLKDeathKorpsofKriegSiegeRegimentIA52ndEd() {
        reflectionKennung = "DKSR";

        HQeinträge = new String[]{"", "Company Command Squad", "Commissar-General", "Quartermaster Cadre"};
        Eliteeinträge = new String[]{"", "Grenadier Squad", "Hydra Flakk Platform", "Rapier Laser Destroyer Battery", "Field Artillery Battery"};
        Standardeinträge = new String[]{"", "Infantry Platoon", "Engineer Squad"};
        Sturmeinträge = new String[]{"", "Cyclops Demolition Squadron", "Hellhound Squadron", "Death Rider Platoon"};
        Unterstützungeinträge = new String[]{"", "Thunderer Siege Tank Squadron", "Leman Russ Squadron", "Heavy Weapons Platoon", "Bombard Battery", "Heavy Artillery Battery"};//,"Thunderbolt","Lightning","Avenger"
        LordofWar = new String[]{
                "", "Death Korps Macharius Heavy Tank", "Death Korps Macharius Vulcan", "Death Korps Macharius Vanquisher",
                "", "[WZ Mont'ka] Baneblade",
                "", "[IA1 2nd Ed] Valdor Tank Hunter", "[IA1 2nd Ed] Crassus Armoured Assault Transport",
                "[IA1 2nd Ed] Praetor Armoured Assault Launcher", "[IA1 2nd Ed] Gorgon Heavy Transporter", "[IA1 2nd Ed] Malcador Heavy Tank",
                "[IA1 2nd Ed] Malcador Annihilator", "[IA1 2nd Ed] Malcador Defender", "[IA1 2nd Ed] Malcador Infernus",
                "", "[IA Aeronautica] Marauder Bomber"
        };

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

        cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

        nameDerArtDerArmee = "Death Korps of Krieg Siege Regiment";
        nameDerArtDerArmeeDekliniert = "Death Korps of Krieg Siege Regiment";
        textAreaUeberschrift = "Death Korps of Krieg Siege Regiment";

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

        //Krieg Death Rider Squadron
        //HQ 1-2 EL 0-4 TR 0-2 FA 2-6 HS 0-4 FORT 0 LOW 0-1 FORM 0
        //Death Rider Colonel (1 Upgrade in bel. Death Rider Command Squad) +50 Gleiche Optionen, wie Squadron Commander
        //Death Rider Command Squad kann eine DK Regimental Standard mitnehmen +0
        //2+ Death Riders

        //Krieg Gorgon Assault Squadron
        //HQ 1-2 EL 1-3 TR 1-10 FA 0-2 HS 0-2 FORT 0 LOW 1-3 FORM 0


        //Verschiedene Spezialkontingente der Orks
        kontingente.add("");
        kontingente.add("Krieg Death Rider Squadron");
        kontingente.add("Krieg Gorgon Assault Squadron");

        //Min/max-Auswahlen je Spezialkontingent/Formation
        minAuswahlen.put("Krieg Death Rider Squadron", new int[]{1, 0, 0, 2, 0, 0, 0, 0});
        maxAuswahlen.put("Krieg Death Rider Squadron", new int[]{2, 4, 2, 6, 4, 0, 1, 0});

        minAuswahlen.put("Krieg Gorgon Assault Squadron", new int[]{1, 1, 1, 0, 0, 0, 1, 0});
        maxAuswahlen.put("Krieg Gorgon Assault Squadron", new int[]{2, 3, 10, 2, 2, 0, 3, 0});

        complete();
    }

    @Override
    public void volkRefresh() {

        if (getKontingentTyp().equals("Krieg Death Rider Squadron")) {
            setInformationVectorValue("Krieg Death Rider Squadron", 1);

            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});

            if (!isLoading) {
                addUnitNotLocked(3, "Death Rider Platoon");
                addUnitNotLocked(3, "Death Rider Platoon");
            }
        } else {
            setInformationVectorValue("Krieg Death Rider Squadron", 0);
        }

        if (formation != null) {
            formation.refreshControlPanel();
        }

        fillChooserSpace();
    }
}
