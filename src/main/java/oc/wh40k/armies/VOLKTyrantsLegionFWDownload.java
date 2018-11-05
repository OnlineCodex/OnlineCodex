package oc.wh40k.armies;

import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKTyrantsLegionFWDownload extends BuildaVater {

    public VOLKTyrantsLegionFWDownload() {
        reflectionKennung = "TL";

        HQeinträge = new String[]{"", "Legion Centurion", "Legion Auxilia Command Detachment",
                "", "Lugft Huron", "Arch-Centurion Carnac Commodus"};//"", "[?]Ehrengarde"
        //TODO Centurion (Commodus) muss genommen werden, wenn 1500+ Punkte
        //TODO Commodus erlaubt eine einzelne Retaliator-Einheit im Standard
        Eliteeinträge = new String[]{"", "Corpse Taker", "Renegade Marauders", "Legion Retaliators"};
        Standardeinträge = new String[]{"", "Legion Space Marine Cohort", "Legion Auxilia", "Auxilia Armsmen Cadre"};
        Sturmeinträge = new String[]{"", "Legion Iron Hunters", "Auxilia Hellhound Flame Tank Squadron", "Legion Sentry Gun Battery",
                "Maelstrom Fleet Lighters",};
        Unterstützungeinträge = new String[]{"", "Auxilia Battle Tank Squadron", "Auxilia Air Defence Squadron", "Auxilia Siege Defence Squadron",
                "Auxilia Fire Support Cohort", "Maelstrom Fleet Gunship Detachment",
                "Maelstrom Fleet Naval Detachment", "Auxilia Heavy Ordnance Battery",
                "Auxilia Rapier Laser Destroyer Battery"};
        LordofWar = new String[]{
                "", "[WZ Mont'ka] Baneblade", "[WZ Mont'ka] Banehammer", "[WZ Mont'ka] Banesword", "[WZ Mont'ka] Doomhammer", "[WZ Mont'ka] Hellhammer",
                "[WZ Mont'ka] Shadowsword", "[WZ Mont'ka] Stormlord", "[WZ Mont'ka] Stormsword",
                "", "[IA1 2nd Ed] Macharius Heavy Tank", "[IA1 2nd Ed] Macharius Vanquisher",
                "[IA1 2nd Ed] Macharius Vulcan", "[IA1 2nd Ed] Gorgon Heavy Transporter",
                "[IA1 2nd Ed] Malcador Heavy Tank", "[IA1 2nd Ed] Malcador Annihilator",
                "[IA1 2nd Ed] Malcador Defender", "[IA1 2nd Ed] Malcador Infernus",
                "[IA1 2nd Ed] Minotaur Artillery Tank"
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

        nameDerArtDerArmee = "Tyrants Legion";
        nameDerArtDerArmeeDekliniert = "Tyrants Legion";
        textAreaUeberschrift = "Tyrants Legion";

        noAllies.clear();
        noAllies.add("CR");
        noAllies.add("SM");
        noAllies.add("TL");
        noAllies.add("SF");

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

    @Override
    public void refreshAction() {
        myChooserGruppen.get(LOW).getPanel().setVisible(Hauptkontingent.isSelected());
        super.refreshAction();
    }
}