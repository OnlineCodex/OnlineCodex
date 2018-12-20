package oc.wh40k.armies;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;
import oc.utils.ResourceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class VOLKTauEmpire extends BuildaVater {

    private static final Logger LOGGER = LoggerFactory.getLogger(VOLKTauEmpire.class);

    //T'au Empire Vanilla //////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final String[] HQeinträge_Tau = new String[]{"", "Commander in XV8 Crisis Battlesuit"/*nicht komplett*/, "Commander in XV85 Enforcer Battlesuit"/*nicht komplett*/, "Commander in XV86 Coldstar Battlesuit"/*nicht komplett*/, "Cadre Fireblade"};
    private static final String[] HQeinträge_Tau_Ethereal = new String[]{"Ethereal"};
    private static final String[] Standardeinträge_Tau = new String[]{"", "Strike Team"/*nicht komplett*/, "Breacher Team"/*nicht komplett*/};
    private static final String[] Eliteeinträge_Tau = new String[]{"", "XV25 Stealth Battlesuits", "XV8 Crisis Battlesuits"/*ist noch alt*/, "XV8 Crisis Bodyguards"/*ist noch alt*/, "XV95 Ghostkeel Battlesuits", "XV104 Riptide Battlesuits", "Firesight Marksman"};
    private static final String[] Sturmeinträge_Tau = new String[]{"", "Pathfinder Team", "TX4 Piranhas", "Tactical Drones"};
    private static final String[] Unterstützungeinträge_Tau = new String[]{"", "MV71 Sniper Drones", "TX78 Sky Ray Gunships", "TX7 Hammerhead Gunships", "XV88 Broadside Battlesuits" /*Broadside-Drohnen sind noch falsch*/};
    private static final String[] Transporteinträge_Tau = new String[]{"", "TY7 Devilfish"};
    private static final String[] Fliegereinträge_Tau = new String[]{"", "AX3 Razorshark Strike Fighter", "AX39 Sun Shark Bomber"};
    private static final String[] Befestigungseinträge_Tau = new String[]{"", "Tidewall Droneport", "Tidewall Shieldline", "Tidewall Gunrig"};
    private static final String[] LordofWar_Tau = new String[]{"", "KV128 Stormsurge"};

    //T'au Empire Vanilla (FW) /////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final String[] HQeinträge_IA_Tau = new String[]{"", /*"Commander in XV81 Crisis Battlesuit",*/ /*"Commander in XV84 Crisis Battlesuit"*/};
    private static final String[] Eliteeinträge_IA_Tau = new String[]{"", "DX-4 Technical Drones"/*, "XV9 Hazard Support Team"*/};
    private static final String[] Sturmeinträge_IA_Tau = new String[]{""/*, "XV109 Y'vahra Battlesuit"*/, "Tetra Scout Speeder Team"/*, "Piranha TX-42 Light Skimmer"*/};
    private static final String[] Unterstützungeinträge_IA_Tau = new String[]{""/*, "XV107 R'varna Battlesuit"*//*, "Heavy Gun Drone Squadron"*//*, "TX7 Heavy Bombardment Hammerdead Gunship"*//*, "TX7 Fire Support Hammerdead Gunship"*/};
    private static final String[] Fliegereinträge_IA_Tau = new String[]{""/*, "DX-6 Remora Stealth Drone Squadron"*/, "Barracuda AX-5-2 [FW]"/*, "Tiger Shark"*//*, "Tiger Shark AX-1-0"*/, "Orca Dropship"};
    private static final String[] Befestigungseinträge_IA_Tau = new String[]{"", "Remote Sensor Tower"/*, "Drone Sentry Turret"*/};
    private static final String[] LordofWar_IA_Tau = new String[]{""/*, "KX139 Ta'unar Supremacy Armour"*/, "Manta Super-heavy Dropship"};

    //T'au Sept ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final String[] HQeinträge_Tau_Sept = new String[]{"", "Commander Shadowsun", "Aun'va", "Darkstrider", "Longstrike"};

    //Farsight Enclaves ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final String[] HQeinträge_Farsight_Enclaves = new String[]{"", "Commander Farsight"};

    //Voir'la Sept /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final String[] HQeinträge_Voirla_Sept = new String[]{"", "Aun'shi"};

    //Dal'yth Sept (FW) ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final String[] HQeinträge_IA_Dalyth_Sept = new String[]{"", "Shas'o R'myr"};

    //Ke'lshan Sept (FW) ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final String[] HQeinträge_IA_Kelshan_Sept = new String[]{"", "Shas'o R'alai"};

    //Kroot ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final String[] Standardeinträge_Kroot = new String[]{"", "Kroot Carnivores"};
    private static final String[] Eliteeinträge_Kroot = new String[]{"", "Kroot Shaper", "Krootox Riders"};
    private static final String[] Sturmeinträge_Kroot = new String[]{"", "Kroot Hounds"};

    //Vespid ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final String[] Sturmeinträge_Vespid = new String[]{"", "Vespid Stingwings"};

    public VOLKTauEmpire() {
        super("TA", ResourceUtils.loadPoints(
                "/oc/wh40k/indices/ta.yaml",
                "/oc/wh40k/indices/taaa.yaml"));

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
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Tau);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau, Befestigungen));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("T'au Sept")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Tau, HQeinträge_Tau_Ethereal, HQeinträge_IA_Tau, HQeinträge_Tau_Sept));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Tau);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau, Befestigungen));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("Vior'la Sept")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Tau, HQeinträge_Tau_Ethereal, HQeinträge_IA_Tau, HQeinträge_Voirla_Sept));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Tau);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau, Befestigungen));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("Dal'yth Sept")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Tau, HQeinträge_Tau_Ethereal, HQeinträge_IA_Tau, HQeinträge_IA_Dalyth_Sept));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Tau);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau, Befestigungen));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("Sa'cea Sept")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Tau, HQeinträge_Tau_Ethereal, HQeinträge_IA_Tau));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Tau);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau, Befestigungen));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("Bork'an Sept")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Tau, HQeinträge_Tau_Ethereal, HQeinträge_IA_Tau));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Tau);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau, Befestigungen));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("Farsight Enclaves")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Tau, HQeinträge_IA_Tau, HQeinträge_Farsight_Enclaves));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Tau);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau, Befestigungen));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("Ke'lshan")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_Tau, HQeinträge_Tau_Ethereal, HQeinträge_IA_Tau, HQeinträge_IA_Kelshan_Sept));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Tau);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau, Befestigungen));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("Kroot")) {
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Kroot);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Kroot);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_Kroot);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
        } else if (getFormationType().equals("Vespid")) {
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_Vespid);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
        }

        fillChooserSpace();
    }
}