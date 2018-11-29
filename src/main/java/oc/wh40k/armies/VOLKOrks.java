package oc.wh40k.armies;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;
import oc.utils.ResourceUtils;

import java.io.InputStream;

public class VOLKOrks extends BuildaVater {

    public VOLKOrks() {
        super("OR", ResourceUtils.loadPoints("/oc/wh40k/indices/or.yaml"));

        AdditionalInformation = new String[]{""};
        HQeinträge = new String[]{""};
        Eliteeinträge = new String[]{"", "Custodian Guard Squad"};
        Standardeinträge = new String[]{""};
        Sturmeinträge = new String[]{""};
        Unterstützungeinträge = new String[]{""};
        Transporteinträge = new String[]{""};
        Fliegereinträge = new String[]{""};
        Befestigungen = new String[]{""};
        LordofWar = new String[]{""};

        adden(new ChooserGruppe(this, getId(), cnt, 0, AI, AdditionalInformation));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, HQ, HQeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, TROOPS, Standardeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, ELITE, Eliteeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, FAST_ATTACK, Sturmeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, HEAVY_SUPPORT, Unterstützungeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, DEDICATED_TRANSPORT, Transporteinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, FLIER, Fliegereinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, FORTIFICATION, Befestigungen));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, LORD_OF_WAR, LordofWar));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;

        cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

        volk = "Orks";
        nameDerArtDerArmee = "Orks";
        nameDerArtDerArmeeDekliniert = "der Orks";

        textAreaUeberschrift = BuildaHQ.translate("Mein") + " Waaagh!";

        noAllies.clear();
        noAllies.add("OR");
        noAllies.add("DM");

        battleBrothers.add("OR");
        battleBrothers.add("DM");

        alliesOfConvenience.add("BL");
        alliesOfConvenience.add("CM");
        alliesOfConvenience.add("CS");
        alliesOfConvenience.add("RH");

        desperateAllies.add("CD");
        desperateAllies.add("DE");
        desperateAllies.add("DH");
        desperateAllies.add("EC");
        desperateAllies.add("ELITE");
        desperateAllies.add("HQ");
        desperateAllies.add("FE");
        desperateAllies.add("NE");
        desperateAllies.add("TA");

        comeTheApocalypse.add("AB");
        comeTheApocalypse.add("AM");
        comeTheApocalypse.add("AS");
        comeTheApocalypse.add("BA");
        comeTheApocalypse.add("CR");
        comeTheApocalypse.add("DA");
        comeTheApocalypse.add("DK");
        comeTheApocalypse.add("DKAB");
        comeTheApocalypse.add("ED");
        comeTheApocalypse.add("GK");
        comeTheApocalypse.add("IN");
        comeTheApocalypse.add("IR");
        comeTheApocalypse.add("MT");
        comeTheApocalypse.add("SF");
        comeTheApocalypse.add("SM");
        comeTheApocalypse.add("TL");
        comeTheApocalypse.add("TY");
        comeTheApocalypse.add("SY");
        comeTheApocalypse.add("DW");

        formationen.add("ORK");
        formationen.add("Goff");
        formationen.add("Blood Axe");
        formationen.add("Deathskulls");
        formationen.add("Evil Sunz");
        formationen.add("Snakebites");
        formationen.add("Bad Moonz");
        formationen.add("Freebooterz");

        complete();
    }

    public void changeFormations() {
    }

    @Override
    public void volkRefresh() {

        if (getFormationType().equals("ORK")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Warboss", "Deffkilla Wartrike",
                    "", "Big Mek in Mega Armour", "Big Mek with Shokk Attack Gun",
                    "", "Weirdboy",
                    "", "Ghazghkull Thraka", "Kaptin Badrukk", "Boss Zagstruk", "Boss Snikrot",
                    "", "Warboss in Mega Armour [Index]", "Warboss on Warbike [Index]", "Big Mek [Index]", "Big Mek on Warbike [Index]",
                    "", "Zhadsnark da Rippa [FW]", "Ork Mek Boss Buzzgob [FW]"});
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{
                    "", "Boyz", "Gretchin"});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(new String[]{
                    "", "Mek", "Painboy", "Runtherd",
                    "", "Burna Boyz", "Tankbustas", "Kommandos",
                    "", "Nobz", "Nob with Waaagh Banner", "Nobz on Warbikes", "Meganobz",
                    "", "Mad Dok Grotsnik",
                    "", "Painboy on Warbike [Index]"});
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{
                    "", "Stormboyz", "Deffkoptas", "Warbikers",
                    "", "Kustom Boosta-Blastas", "Shokkjump Dragstas", "Boomdakka Snazzwagons", "Rukkatrukk Squigbuggys", "Megatrakk Scrapjet",
                    "", "Wartrakks [Index]", "Skorchas [Index]", "Warbuggies [Index]",
                    "", "Grot Tanks [FW]", "Grot Mega-Tank [FW]",});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Deff Dreads", "Killa Kans",
                    "", "Gorkanaut", "Morkanaut",
                    "", "Battlewagon", "Gunwagon", "Bonebreaka",
                    "", "Mek Gunz", "Lootas", "Flash Gitz",
                    "", "Big Gunz [Index]",
                    "", "Squiggoth [FW]", "Meka-Dread [FW]", "Lifta Wagon [FW]", "Big Trakk [FW]",
                    "Battlewagon with Supa-Kannon [FW]",});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Trukk",
                    "", "'Chinork' Warkopta [FW]"});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{
                    "", "Dakkajet", "Burna-Bommer", "Blitza-Bommer", "Wazbom Blastajet"});
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{
                    "", "Stompa",
                    "", "Kill Tank [FW]", "Kustom Stompa [FW]", "Gargantuan Squiggoth [FW]",});
        } else if (getFormationType().equals("Goff")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Warboss", "Deffkilla Wartrike",
                    "", "Big Mek in Mega Armour", "Big Mek with Shokk Attack Gun",
                    "", "Weirdboy",
                    "", "Kaptin Badrukk", "Ghazghkull Thraka", "Boss Zagstruk",
                    "", "Warboss in Mega Armour [Index]", "Warboss on Warbike [Index]", "Big Mek [Index]", "Big Mek on Warbike [Index]",
                    "", "Ork Mek Boss Buzzgob [FW]"});
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{
                    "", "Boyz", "Gretchin"});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(new String[]{
                    "", "Mek", "Painboy", "Painboy on Warbike [Index]", "Runtherd",
                    "", "Burna Boyz", "Tankbustas", "Nobz", "Nob with Waaagh Banner", "Nobz on Warbikes", "Meganobz", "Kommandos"});
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{
                    "", "Stormboyz", "Deffkoptas", "Warbikers", "Kustom Boosta-Blastas", "Shokkjump Dragstas", "Boomdakka Snazzwagons", "Rukkatrukk Squigbuggys", "Megatrakk Scrapjet", "", "Wartrakks [Index]", "Skorchas [Index]", "Warbuggies [Index]",
                    "", "Grot Tanks [FW]", "Grot Mega-Tank [FW]"});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Deff Dreads", "Killa Kans", "Gorkanaut", "Morkanaut", "Battlewagon", "Gunwagon", "Bonebreaka", "Big Gunz [Index]", "Mek Gunz", "Lootas", "Flash Gitz",
                    "", "Squiggoth [FW]", "Meka-Dread [FW]", "Lifta Wagon [FW]", "Big Trakk [FW]", "Battlewagon with Supa-Kannon [FW]"});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Trukk"});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{
                    "", "Dakkajet", "Burna-Bommer", "Blitza-Bommer", "Wazbom Blastajet"});
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{
                    "", "Stompa"});
        } else if (getFormationType().equals("Blood Axe")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Warboss", "Deffkilla Wartrike",
                    "", "Big Mek in Mega Armour", "Big Mek with Shokk Attack Gun",
                    "", "Weirdboy",
                    "", "Kaptin Badrukk", "Boss Snikrot",
                    "", "Warboss in Mega Armour [Index]", "Warboss on Warbike [Index]", "Big Mek [Index]", "Big Mek on Warbike [Index]"});
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{
                    "", "Boyz", "Gretchin"});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(new String[]{
                    "", "Mek", "Painboy", "Painboy on Warbike [Index]", "Runtherd",
                    "", "Burna Boyz", "Tankbustas", "Nobz", "Nob with Waaagh Banner", "Nobz on Warbikes", "Meganobz", "Kommandos"});
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{
                    "", "Stormboyz", "Deffkoptas", "Warbikers", "Kustom Boosta-Blastas", "Shokkjump Dragstas", "Boomdakka Snazzwagons", "Rukkatrukk Squigbuggys", "Megatrakk Scrapjet", "", "Wartrakks [Index]", "Skorchas [Index]", "Warbuggies [Index]",
                    "", "Grot Tanks [FW]", "Grot Mega-Tank [FW]"});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Deff Dreads", "Killa Kans", "Gorkanaut", "Morkanaut", "Battlewagon", "Gunwagon", "Bonebreaka", "Big Gunz [Index]", "Mek Gunz", "Lootas", "Flash Gitz",
                    "", "Squiggoth [FW]", "Meka-Dread [FW]", "Lifta Wagon [FW]", "Big Trakk [FW]", "Battlewagon with Supa-Kannon [FW]"});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Trukk"});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{
                    "", "Dakkajet", "Burna-Bommer", "Blitza-Bommer", "Wazbom Blastajet"});
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{
                    "", "Stompa"});
        } else if (getFormationType().equals("Deathskulls")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Warboss", "Deffkilla Wartrike",
                    "", "Big Mek in Mega Armour", "Big Mek with Shokk Attack Gun",
                    "", "Weirdboy", 
                    "", "Kaptin Badrukk",
                    "", "Warboss in Mega Armour [Index]", "Warboss on Warbike [Index]", "Big Mek [Index]", "Big Mek on Warbike [Index]"});
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{
                    "", "Boyz", "Gretchin"});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(new String[]{
                    "", "Mek", "Painboy", "Painboy on Warbike [Index]", "Runtherd",
                    "", "Burna Boyz", "Tankbustas", "Nobz", "Nob with Waaagh Banner", "Nobz on Warbikes", "Meganobz", "Kommandos",
                    "", "Mad Dok Grotsnik"});
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{
                    "", "Stormboyz", "Deffkoptas", "Warbikers", "Kustom Boosta-Blastas", "Shokkjump Dragstas", "Boomdakka Snazzwagons", "Rukkatrukk Squigbuggys", "Megatrakk Scrapjet", "", "Wartrakks [Index]", "Skorchas [Index]", "Warbuggies [Index]",
                    "", "Grot Tanks [FW]", "Grot Mega-Tank [FW]"});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Deff Dreads", "Killa Kans", "Gorkanaut", "Morkanaut", "Battlewagon", "Gunwagon", "Bonebreaka", "Big Gunz [Index]", "Mek Gunz", "Lootas", "Flash Gitz",
                    "", "Squiggoth [FW]", "Meka-Dread [FW]", "Lifta Wagon [FW]", "Big Trakk [FW]", "Battlewagon with Supa-Kannon [FW]"});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Trukk"});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{
                    "", "Dakkajet", "Burna-Bommer", "Blitza-Bommer", "Wazbom Blastajet"});
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{
                    "", "Stompa"});
        } else if (getFormationType().equals("Evil Sunz")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Warboss", "Deffkilla Wartrike",
                    "", "Big Mek in Mega Armour", "Big Mek with Shokk Attack Gun",
                    "", "Weirdboy",
                    "", "Kaptin Badrukk",
                    "", "Warboss in Mega Armour [Index]", "Warboss on Warbike [Index]", "Big Mek [Index]", "Big Mek on Warbike [Index]",
                    "", "Zhadsnark da Rippa [FW]"});
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{
                    "", "Boyz", "Gretchin"});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(new String[]{
                    "", "Mek", "Painboy", "Painboy on Warbike [Index]", "Runtherd",
                    "", "Burna Boyz", "Tankbustas", "Nobz", "Nob with Waaagh Banner", "Nobz on Warbikes", "Meganobz", "Kommandos"});
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{
                    "", "Stormboyz", "Deffkoptas", "Warbikers", "Kustom Boosta-Blastas", "Shokkjump Dragstas", "Boomdakka Snazzwagons", "Rukkatrukk Squigbuggys", "Megatrakk Scrapjet", "", "Wartrakks [Index]", "Skorchas [Index]", "Warbuggies [Index]",
                    "", "Grot Tanks [FW]", "Grot Mega-Tank [FW]"});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Deff Dreads", "Killa Kans", "Gorkanaut", "Morkanaut", "Battlewagon", "Gunwagon", "Bonebreaka", "Big Gunz [Index]", "Mek Gunz", "Lootas", "Flash Gitz",
                    "", "Squiggoth [FW]", "Meka-Dread [FW]", "Lifta Wagon [FW]", "Big Trakk [FW]", "Battlewagon with Supa-Kannon [FW]"});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Trukk"});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{
                    "", "Dakkajet", "Burna-Bommer", "Blitza-Bommer", "Wazbom Blastajet"});
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{
                    "", "Stompa"});
        } else if (getFormationType().equals("Snakebites") || getFormationType().equals("Bad Moonz") || getFormationType().equals("Freebooterz")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
            		"", "Warboss", "Deffkilla Wartrike",
                    "", "Big Mek in Mega Armour", "Big Mek with Shokk Attack Gun",
                    "", "Weirdboy",
                    "", "Kaptin Badrukk",
                    "", "Warboss in Mega Armour [Index]", "Warboss on Warbike [Index]", "Big Mek [Index]", "Big Mek on Warbike [Index]"});
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{
                    "", "Boyz", "Gretchin"});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(new String[]{
                    "", "Mek", "Painboy", "Painboy on Warbike [Index]", "Runtherd",
                    "", "Burna Boyz", "Tankbustas", "Nobz", "Nob with Waaagh Banner", "Nobz on Warbikes", "Meganobz", "Kommandos"});
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{
                    "", "Stormboyz", "Deffkoptas", "Warbikers", "Kustom Boosta-Blastas", "Shokkjump Dragstas", "Boomdakka Snazzwagons", "Rukkatrukk Squigbuggys", "Megatrakk Scrapjet", "", "Wartrakks [Index]", "Skorchas [Index]", "Warbuggies [Index]",
                    "", "Grot Tanks [FW]", "Grot Mega-Tank [FW]"});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Deff Dreads", "Killa Kans", "Gorkanaut", "Morkanaut", "Battlewagon", "Gunwagon", "Bonebreaka", "Big Gunz [Index]", "Mek Gunz", "Lootas", "Flash Gitz",
                    "", "Squiggoth [FW]", "Meka-Dread [FW]", "Lifta Wagon [FW]", "Big Trakk [FW]", "Battlewagon with Supa-Kannon [FW]"});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Trukk"});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{
                    "", "Dakkajet", "Burna-Bommer", "Blitza-Bommer", "Wazbom Blastajet"});
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{
                    "", "Stompa"});
        }

        if (formation != null) {
            formation.refreshControlPanel();
        }

        fillChooserSpace();
    }

    @Override
    public void refreshAction() {
        if (BuildaHQ.getCountFromInformationVectorGlobal("ORZhadsnark") > 0) {
            myChooserGruppen.get(TROOPS).addSpezialAuswahl("Warbikers");
        } else {
            myChooserGruppen.get(TROOPS).removeSpezialAuswahl("Warbikers");
        }
        super.refreshAction();
    }
}