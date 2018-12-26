package oc.wh40k.armies;

import com.google.common.collect.ImmutableList;
import oc.BuildaHQ;
import oc.BuildaVater;
import oc.Eintrag;
import oc.utils.ResourceUtils;
import oc.wh40k.units.ta.*;

import java.util.List;

public class VOLKTauEmpire extends BuildaVater {

    //T'au Empire Vanilla //////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final List<Class<? extends Eintrag>> HQeinträge_Tau = ImmutableList.of(
            TACommanderinXV8CrisisBattlesuit.class,
            TACommanderinXV85EnforcerBattlesuit.class,
            TACommanderinXV86ColdstarBattlesuit.class,
            TACadreFireblade.class);
    private static final List<Class<? extends Eintrag>> HQeinträge_Tau_Ethereal = ImmutableList.of(
            TAEthereal.class);
    private static final List<Class<? extends Eintrag>> Standardeinträge_Tau = ImmutableList.of(
            TAStrikeTeam.class,
            TABreacherTeam.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Tau = ImmutableList.of(
            TAXV25StealthBattlesuits.class,
            TAXV8CrisisBattlesuits.class,
            TAXV8CrisisBodyguards.class,
            TAXV95GhostkeelBattlesuits.class,
            TAXV104RiptideBattlesuits.class,
            TAFiresightMarksman.class);
    private static final List<Class<? extends Eintrag>> Sturmeinträge_Tau = ImmutableList.of(
            TAPathfinderTeam.class,
            TATX4Piranhas.class,
            TATacticalDrones.class);
    private static final List<Class<? extends Eintrag>> Unterstützungeinträge_Tau = ImmutableList.of(
            TAMV71SniperDrones.class,
            TATX78SkyRayGunships.class,
            TATX7HammerheadGunships.class,
            TAXV88BroadsideBattlesuits.class);
    private static final List<Class<? extends Eintrag>> Transporteinträge_Tau = ImmutableList.of(
            TATY7Devilfish.class);
    private static final List<Class<? extends Eintrag>> Fliegereinträge_Tau = ImmutableList.of(
            TAAX3RazorsharkStrikeFighter.class,
            TAAX39SunSharkBomber.class);
    private static final List<Class<? extends Eintrag>> Befestigungseinträge_Tau = ImmutableList.of(
            TATidewallDroneport.class,
            TATidewallShieldline.class,
            TATidewallGunrig.class);
    private static final List<Class<? extends Eintrag>> LordofWar_Tau = ImmutableList.of(
            TAKV128Stormsurge.class);

    //T'au Empire Vanilla (FW) /////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final List<Class<? extends Eintrag>> HQeinträge_IA_Tau = ImmutableList.of();
    private static final List<Class<? extends Eintrag>> Eliteeinträge_IA_Tau = ImmutableList.of(

            TADX4TechnicalDrones.class);
    private static final List<Class<? extends Eintrag>> Sturmeinträge_IA_Tau = ImmutableList.of(

            TATetraScoutSpeederTeam.class);
    private static final List<Class<? extends Eintrag>> Unterstützungeinträge_IA_Tau = ImmutableList.of();
    private static final List<Class<? extends Eintrag>> Fliegereinträge_IA_Tau = ImmutableList.of(

            TABarracudaAX52.class,
            TAOrcaDropship.class);
    private static final List<Class<? extends Eintrag>> Befestigungseinträge_IA_Tau = ImmutableList.of(

            TARemoteSensorTower.class);
    private static final List<Class<? extends Eintrag>> LordofWar_IA_Tau = ImmutableList.of(

            TAMantaSuperheavyDropship.class);

    //T'auSept ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final List<Class<? extends Eintrag>> HQeinträge_Tau_Sept = ImmutableList.of(

            TACommanderShadowsun.class,
            TAAunva.class,
            TADarkstrider.class,
            TALongstrike.class);

    //Farsight Enclaves ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final List<Class<? extends Eintrag>> HQeinträge_Farsight_Enclaves = ImmutableList.of(

            TACommanderFarsight.class);

    //Voir'laSept /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final List<Class<? extends Eintrag>> HQeinträge_Voirla_Sept = ImmutableList.of(

            TAAunshi.class);

    //Dal'ythSept (FW) ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final List<Class<? extends Eintrag>> HQeinträge_IA_Dalyth_Sept = ImmutableList.of(

            TAShasoRmyr.class);

    //Ke'lshanSept (FW) ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final List<Class<? extends Eintrag>> HQeinträge_IA_Kelshan_Sept = ImmutableList.of(

            TAShasoRalai.class);

    //Kroot ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final List<Class<? extends Eintrag>> Standardeinträge_Kroot = ImmutableList.of(

            TAKrootCarnivores.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Kroot = ImmutableList.of(

            TAKrootShaper.class,
            TAKrootoxRiders.class);
    private static final List<Class<? extends Eintrag>> Sturmeinträge_Kroot = ImmutableList.of(

            TAKrootHounds.class);

    //Vespid ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final List<Class<? extends Eintrag>> Sturmeinträge_Vespid = ImmutableList.of(

            TAVespidStingwings.class);

    public VOLKTauEmpire() {
        super("TA", ResourceUtils.loadPoints(
                "/oc/wh40k/indices/ta.yaml",
                "/oc/wh40k/indices/taaa.yaml"));

        nameDerArtDerArmee = BuildaHQ.translate("T'au Empire");
        nameDerArtDerArmeeDekliniert = BuildaHQ.translate("T'au Empire");
        textAreaUeberschrift = BuildaHQ.translate("Mein") + " " + BuildaHQ.translate("T'au Empire");

        formationen.add("T'AU EMPIRE");
        formationen.add("T'auSept");
        formationen.add("Vior'laSept");
        formationen.add("Dal'ythSept");
        formationen.add("Sa'ceaSept");
        formationen.add("Bork'anSept");
        formationen.add("Farsight Enclaves");
        formationen.add("Ke'lshan");
        formationen.add("Kroot");
        formationen.add("Vespid");

        complete();
    }

    @Override
    public void volkRefresh() {

        if (getFormationType().equals("T'AU EMPIRE")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(HQeinträge_Tau, HQeinträge_Tau_Ethereal, HQeinträge_IA_Tau,
                    HQeinträge_Tau_Sept, HQeinträge_Farsight_Enclaves, HQeinträge_Voirla_Sept, HQeinträge_IA_Dalyth_Sept, HQeinträge_IA_Kelshan_Sept));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(Transporteinträge_Tau));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("T'auSept")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(HQeinträge_Tau, HQeinträge_Tau_Ethereal, HQeinträge_IA_Tau, HQeinträge_Tau_Sept));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(Transporteinträge_Tau));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("Vior'laSept")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(HQeinträge_Tau, HQeinträge_Tau_Ethereal, HQeinträge_IA_Tau, HQeinträge_Voirla_Sept));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(Transporteinträge_Tau));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("Dal'ythSept")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(HQeinträge_Tau, HQeinträge_Tau_Ethereal, HQeinträge_IA_Tau, HQeinträge_IA_Dalyth_Sept));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(Transporteinträge_Tau));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("Sa'ceaSept")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(HQeinträge_Tau, HQeinträge_Tau_Ethereal, HQeinträge_IA_Tau));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(Transporteinträge_Tau));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("Bork'anSept")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(HQeinträge_Tau, HQeinträge_Tau_Ethereal, HQeinträge_IA_Tau));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(Transporteinträge_Tau));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("Farsight Enclaves")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(HQeinträge_Tau, HQeinträge_IA_Tau, HQeinträge_Farsight_Enclaves));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(Transporteinträge_Tau));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("Ke'lshan")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(HQeinträge_Tau, HQeinträge_Tau_Ethereal, HQeinträge_IA_Tau, HQeinträge_IA_Kelshan_Sept));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(Standardeinträge_Tau, Standardeinträge_Kroot));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(Eliteeinträge_Tau, Eliteeinträge_IA_Tau, Eliteeinträge_Kroot));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(Sturmeinträge_Tau, Sturmeinträge_IA_Tau, Sturmeinträge_Kroot, Sturmeinträge_Vespid));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(Unterstützungeinträge_Tau, Unterstützungeinträge_IA_Tau));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(Transporteinträge_Tau));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(Fliegereinträge_Tau, Fliegereinträge_IA_Tau));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of(Befestigungseinträge_Tau, Befestigungseinträge_IA_Tau));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(LordofWar_Tau, LordofWar_IA_Tau));
        } else if (getFormationType().equals("Kroot")) {
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(Standardeinträge_Kroot));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(Eliteeinträge_Kroot));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(Sturmeinträge_Kroot));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of());
        } else if (getFormationType().equals("Vespid")) {
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(Sturmeinträge_Vespid));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of());
        }

        fillChooserSpace();
    }
}