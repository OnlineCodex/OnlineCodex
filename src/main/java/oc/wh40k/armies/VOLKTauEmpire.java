package oc.wh40k.armies;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class VOLKTauEmpire extends BuildaVater {

    private static final Logger LOGGER = LoggerFactory.getLogger(VOLKTauEmpire.class);

    //T'au Empire Vanilla //////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String[] HQeinträge_Tau = new String[]{"", "Commander in XV8 Crisis Battlesuit"/*nicht komplett*/, "Commander in XV85 Enforcer Battlesuit"/*nicht komplett*/, "Commander in XV86 Coldstar Battlesuit"/*nicht komplett*/, "Cadre Fireblade"};
    public String[] HQeinträge_Tau_Ethereal = new String[]{"Ethereal"};
    public String[] Standardeinträge_Tau = new String[]{"", "Strike Team"/*nicht komplett*/, "Breacher Team"/*nicht komplett*/};
    public String[] Eliteeinträge_Tau = new String[]{"", "XV25 Stealth Battlesuits", "XV8 Crisis Battlesuits"/*ist noch alt*/, "XV8 Crisis Bodyguards"/*ist noch alt*/, "XV95 Ghostkeel Battlesuits", "XV104 Riptide Battlesuits", "Firesight Marksman"};
    public String[] Sturmeinträge_Tau = new String[]{"", "Pathfinder Team", "TX4 Piranhas", "Tactical Drones"};
    public String[] Unterstützungeinträge_Tau = new String[]{"", "MV71 Sniper Drones", "TX78 Sky Ray Gunships", "TX7 Hammerhead Gunships", "XV88 Broadside Battlesuits" /*Broadside-Drohnen sind noch falsch*/};
    public String[] Transporteinträge_Tau = new String[]{"", "TY7 Devilfish"};
    public String[] Fliegereinträge_Tau = new String[]{"", "AX3 Razorshark Strike Fighter", "AX39 Sun Shark Bomber"};
    public String[] Befestigungseinträge_Tau = new String[]{"", "Tidewall Droneport", "Tidewall Shieldline", "Tidewall Gunrig"};
    public String[] LordofWar_Tau = new String[]{"", "KV128 Stormsurge"};

    //T'au Empire Vanilla (FW) /////////////////////////////////////////////////////////////////////////////////////////////////////
    public String[] HQeinträge_IA_Tau = new String[]{"", /*"Commander in XV81 Crisis Battlesuit",*/ /*"Commander in XV84 Crisis Battlesuit"*/};
    public String[] Eliteeinträge_IA_Tau = new String[]{"", "DX-4 Technical Drones"/*, "XV9 Hazard Support Team"*/};
    public String[] Sturmeinträge_IA_Tau = new String[]{""/*, "XV109 Y'vahra Battlesuit"*/, "Tetra Scout Speeder Team"/*, "Piranha TX-42 Light Skimmer"*/};
    public String[] Unterstützungeinträge_IA_Tau = new String[]{""/*, "XV107 R'varna Battlesuit"*//*, "Heavy Gun Drone Squadron"*//*, "TX7 Heavy Bombardment Hammerdead Gunship"*//*, "TX7 Fire Support Hammerdead Gunship"*/};
    public String[] Fliegereinträge_IA_Tau = new String[]{""/*, "DX-6 Remora Stealth Drone Squadron"*//*, "Barracuda AX-5-2"*//*, "Tiger Shark"*//*, "Tiger Shark AX-1-0"*/, "Orca Dropship"};
    public String[] Befestigungseinträge_IA_Tau = new String[]{"", "Remote Sensor Tower"/*, "Drone Sentry Turret"*/};
    public String[] LordofWar_IA_Tau = new String[]{""/*, "KX139 Ta'unar Supremacy Armour"*/, "Manta Super-heavy Dropship"};

    //T'au Sept ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String[] HQeinträge_Tau_Sept = new String[]{"", "Commander Shadowsun", "Aun'va", "Darkstrider", "Longstrike"};

    //Farsight Enclaves ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String[] HQeinträge_Farsight_Enclaves = new String[]{"", "Commander Farsight"};

    //Voir'la Sept /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String[] HQeinträge_Voirla_Sept = new String[]{"", "Aun'shi"};

    //Dal'yth Sept (FW) ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String[] HQeinträge_IA_Dalyth_Sept = new String[]{"", "Shas'o R'myr"};

    //Ke'lshan Sept (FW) ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String[] HQeinträge_IA_Kelshan_Sept = new String[]{"", "Shas'o R'alai"};

    //Kroot ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String[] Standardeinträge_Kroot = new String[]{"", "Kroot Carnivores"};
    public String[] Eliteeinträge_Kroot = new String[]{"", "Kroot Shaper", "Krootox Riders"};
    public String[] Sturmeinträge_Kroot = new String[]{"", "Kroot Hounds"};

    //Vespid ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String[] Sturmeinträge_Vespid = new String[]{"", "Vespid Stingwings"};

    public VOLKTauEmpire() {
        reflectionKennung = "TA";
        InputStream is = this.getClass().getResourceAsStream("/oc/wh40k/indices/ta.csv");
        pointValues = BuildaHQ.loadindexFile(is);

        LOGGER.error("File: " + "/oc/wh40k/indices/taaa.csv");
        is = this.getClass().getResourceAsStream("/oc/wh40k/indices/taaa.csv");
        appendPointList(BuildaHQ.loadindexFile(is));

        AdditionalInformation = new String[]{""};
        HQeinträge = new String[]{""};
        Eliteeinträge = new String[]{"", "Custodian Guard Squad"};
        Standardeinträge = new String[]{""};
        Sturmeinträge = new String[]{""};
        Unterstützungeinträge = new String[]{""};
        Fliegereinträge = new String[]{""};
        Befestigungen = new String[]{""};
        Transporteinträge = new String[]{""};
        LordofWar = new String[]{""};

        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, AI, AdditionalInformation));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, HQ, HQeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, TR, Standardeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, EL, Eliteeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, FA, Sturmeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, HS, Unterstützungeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, DT, Transporteinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, FL, Fliegereinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, FORT, Befestigungen));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, LOW, LordofWar));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;

        cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

        nameDerArtDerArmee = BuildaHQ.translate("T'au Empire");
        nameDerArtDerArmeeDekliniert = BuildaHQ.translate("T'au Empire");
        textAreaUeberschrift = BuildaHQ.translate("Mein") + " " + BuildaHQ.translate("T'au Empire");

        formationen.add("T'AU EMPIRE");
        formationen.add("T'au Sept");
        formationen.add("Vior'la Sept");
        formationen.add("Dal'yth Sept");
        formationen.add("Sa'cea Sept");
        formationen.add("Bork'an Sept");
        formationen.add("Farsight Enclaves");
        formationen.add("Ke'lshan");
        formationen.add("Kroot");
        formationen.add("Vespid");

        complete();
    }

    @Override
    public void volkRefresh() {

        if (getFormationType().equals("T'AU EMPIRE")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Tau, HQeinträge_Tau_Ethereal, HQeinträge_IA_Tau,
                    HQeinträge_Tau_Sept, HQeinträge_Farsight_Enclaves, HQeinträge_Voirla_Sept, HQeinträge_IA_Dalyth_Sept, HQeinträge_IA_Kelshan_Sept));
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_Tau);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(uniteUnitList(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau, Befestigungen));
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(uniteUnitList(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("T'au Sept")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Tau, HQeinträge_Tau_Ethereal, HQeinträge_IA_Tau, HQeinträge_Tau_Sept));
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_Tau);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(uniteUnitList(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau, Befestigungen));
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(uniteUnitList(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("Vior'la Sept")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Tau, HQeinträge_Tau_Ethereal, HQeinträge_IA_Tau, HQeinträge_Voirla_Sept));
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_Tau);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(uniteUnitList(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau, Befestigungen));
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(uniteUnitList(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("Dal'yth Sept")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Tau, HQeinträge_Tau_Ethereal, HQeinträge_IA_Tau, HQeinträge_IA_Dalyth_Sept));
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_Tau);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(uniteUnitList(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau, Befestigungen));
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(uniteUnitList(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("Sa'cea Sept")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Tau, HQeinträge_Tau_Ethereal, HQeinträge_IA_Tau));
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_Tau);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(uniteUnitList(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau, Befestigungen));
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(uniteUnitList(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("Bork'an Sept")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Tau, HQeinträge_Tau_Ethereal, HQeinträge_IA_Tau));
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_Tau);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(uniteUnitList(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau, Befestigungen));
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(uniteUnitList(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("Farsight Enclaves")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Tau, HQeinträge_IA_Tau, HQeinträge_Farsight_Enclaves));
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_Tau);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(uniteUnitList(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau, Befestigungen));
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(uniteUnitList(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("Ke'lshan")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Tau, HQeinträge_Tau_Ethereal, HQeinträge_IA_Tau, HQeinträge_IA_Kelshan_Sept));
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_Tau);
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(uniteUnitList(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau, Befestigungen));
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(uniteUnitList(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("Kroot")) {
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_Kroot);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Kroot);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_Kroot);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
        } else if (getFormationType().equals("Vespid")) {
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge_Vespid);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
        }

        fillChooserSpace();
    }
}