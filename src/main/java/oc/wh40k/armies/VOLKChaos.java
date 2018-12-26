package oc.wh40k.armies;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import oc.BuildaVater;
import oc.Eintrag;
import oc.wh40k.units.ch.*;

import java.util.List;
import java.util.Set;

import static oc.utils.EvenMoreCollections.concat;
import static oc.utils.ResourceUtils.loadPoints;

public class VOLKChaos extends BuildaVater {

    private static final List<List<Class<? extends Eintrag>>> HQeinträge_Chaos_Space_Marines_FW = ImmutableList.of(
            ImmutableList.of(
                    CHZhuforTheImpaler.class,
                    CHLordArkos.class,
                    CHChaosHellwright.class,
                    CHChaosHellwrightOnDarkAbeyant.class));
    private static final List<List<Class<? extends Eintrag>>> Eliteeinträge_Chaos_Space_Marines_FW = ImmutableList.of(
            ImmutableList.of(
                    CHChaosDecimator.class,
                    CHHellforgedContemptorDreadnought.class,
                    CHHellforgedPredator.class));
    private static final List<List<Class<? extends Eintrag>>> Standardeinträge_Chaos_Space_Marines_FW = ImmutableList.of();
    private static final List<List<Class<? extends Eintrag>>> Sturmeinträge_Chaos_Space_Marines_FW = ImmutableList.of(
            ImmutableList.of(
                    CHBloodSlaughtererofKhorne.class,
                    CHGreaterBlightDrone.class,
                    CHHellforgedDreadclawDropPod.class,
                    CHHellforgedKharybdisAssaultClaw.class));
    private static final List<List<Class<? extends Eintrag>>> Unterstützungseinträge_Chaos_Space_Marines_FW = ImmutableList.of(
            ImmutableList.of(
                    CHHellforgedLandRaiderProteus.class,
                    CHHellforgedLandRaiderAchilles.class,
                    CHHellforgedScorpius.class,
                    CHHellforgedSicarian.class,
                    CHHellforgedSicarianVenator.class,
                    CHHellforgedDeredeoDreadnought.class,
                    CHHellforgedRapierBattery.class,
                    CHHellforgedLeviathanDreadnought.class,
                    CHSpinedChaosBeast.class));
    private static final List<List<Class<? extends Eintrag>>> Transporteinträge_Chaos_Space_Marines_FW = ImmutableList.of(
            ImmutableList.of(
                    CHTerraxPatternTermiteAssaultDrill.class));
    private static final List<List<Class<? extends Eintrag>>> Fliegereinträge_Chaos_Space_Marines_FW = ImmutableList.of(
            ImmutableList.of(
                    CHChaosHellBlade.class,
                    CHChaosHellTalon.class,
                    CHChaosStormEagleAssaultGunship.class,
                    CHChaosFireRaptorAssaultGunship.class,
                    CHChaosXiphonInterceptor.class));
    private static final List<List<Class<? extends Eintrag>>> Befestigungseinträge_Chaos_Space_Marines_FW = ImmutableList.of();
    private static final List<List<Class<? extends Eintrag>>> LOWeinträge_Chaos_Space_Marines_FW = ImmutableList.of(
            ImmutableList.of(
                    CHKytanRavager.class,
                    CHGreaterBrassScorpionOfKhorne.class,
                    CHHellforgedSpartanAssaultTank.class,
                    CHHellforgedCerberusHeavyDestroyer.class,
                    CHHellforgedTyphonHeavySiegeTank.class,
                    CHHellforgedFellblade.class,
                    CHHellforgedFalchion.class,
                    CHHellforgedMastodon.class,
                    CHChaosThunderhawkAssaultGunship.class,
                    CHChaosSokarPatternStormbirdGunship.class,
                    CHRenegadeKnightAcheron.class,
                    CHRenegadeKnightLancer.class,
                    CHRenegadeKnightCastigator.class,
                    CHRenegadeKnightAtropos.class,
                    CHRenegadeKnightMagaera.class,
                    CHRenegadeKnightPorphyrion.class,
                    CHRenegadeKnightStyrix.class),
            ImmutableList.of(
                    CHChaosWarlordBattleTitan.class,
                    CHChaosReaverBattleTitan.class,
                    CHChaosWarhoundScoutTitan.class));

    private static final List<List<Class<? extends Eintrag>>> HQeinträge_Daemons_FW = ImmutableList.of(
            ImmutableList.of(
                    CHUrakaTheWarfiend.class,
                    CHSamus.class,
                    CHMamonTransfigured.class,
                    CHCorbaxUtterblight.class));
    private static final List<List<Class<? extends Eintrag>>> Sturmeinträge_Daemons_FW = ImmutableList.of(
            ImmutableList.of(
                    CHPlagueToadsOfNurgle.class,
                    CHPoxRidersOfNurgle.class));
    private static final List<List<Class<? extends Eintrag>>> Unterstützungseinträge_Daemons_FW = ImmutableList.of(
            ImmutableList.of(CHPlagueHulkOfNurgle.class));
    private static final List<List<Class<? extends Eintrag>>> LOWeinträge_Daemons_FW = ImmutableList.of(
            ImmutableList.of(
                    CHAnggrathTheUnbound.class,
                    CHZarakynel.class,
                    CHAetaosraukeres.class,
                    CHScabeiathraxTheBloated.class));

    private static final List<List<Class<? extends Eintrag>>> HQeinträge_Chaos_Space_Marines = ImmutableList.of(
            ImmutableList.of(
                    CHAbaddontheDespoiler.class,
                    CHHuronBlackheart.class,
                    CHCypher.class,
                    CHFabiusBile.class,
                    CHKharntheBetrayer.class,
                    CHLuciustheEternal.class,
                    CHChaosLord.class,
                    CHChaosLordinTerminatorArmour.class,
                    CHDarkApostle.class,
                    CHExaltedChampion.class,
                    CHDaemonPrinceofChaosCSM.class,
                    CHDaemonPrinceofChaoswithWingsCSM.class,
                    CHSorcerer.class,
                    CHSorcererinTerminatorArmour.class,
                    CHWarpsmith.class),
            ImmutableList.of(
                    CHChaosLordonBike.class,
                    CHChaosLordonJuggernautofKhorne.class,
                    CHChaosLordonDiscofTzeentch.class,
                    CHChaosLordonPalanquinofNurgle.class,
                    CHChaosLordonSteedofSlaanesh.class,
                    CHSorcereronBike.class,
                    CHSorcereronDiscofTzeentch.class,
                    CHSorcereronPalanquinofNurgle.class,
                    CHSorcereronPalanquinofNurgle.class));
    private static final List<List<Class<? extends Eintrag>>> Eliteeinträge_Chaos_Space_Marines = ImmutableList.of(
            ImmutableList.of(
                    CHFallen.class,
                    CHChaosTerminators.class,
                    CHKhorneBerzerkers.class,
                    CHRubricMarines.class,
                    CHPlagueMarinesCSM.class,
                    CHNoiseMarines.class,
                    CHChosen.class,
                    CHPossessed.class,
                    CHHelbrute.class,
                    CHMutilators.class));
    private static final List<List<Class<? extends Eintrag>>> Standardeinträge_Chaos_Space_Marines = ImmutableList.of(
            ImmutableList.of(
                    CHChaosSpaceMarines.class,
                    CHChaosCultists.class,
                    CHBloodletters.class,
                    CHHorrors.class,
                    CHPlaguebearers.class,
                    CHDaemonettes.class));
    private static final List<List<Class<? extends Eintrag>>> Sturmeinträge_Chaos_Space_Marines = ImmutableList.of(
            ImmutableList.of(
                    CHChaosBikers.class,
                    CHRaptors.class,
                    CHWarpTalons.class,
                    CHChaosSpawn.class));
    private static final List<List<Class<? extends Eintrag>>> Unterstützungseinträge_Chaos_Space_Marines = ImmutableList.of(
            ImmutableList.of(
                    CHChaosLandRaider.class,
                    CHChaosPredator.class,
                    CHChaosVindicator.class,
                    CHObliterators.class,
                    CHHavocs.class,
                    CHForgefiend.class,
                    CHMaulerfiend.class,
                    CHDefiler.class));
    private static final List<List<Class<? extends Eintrag>>> Transporteinträge_Chaos_Space_Marines = ImmutableList.of(
            ImmutableList.of(
                    CHChaosRhino.class));
    private static final List<List<Class<? extends Eintrag>>> Fliegereinträge_Chaos_Space_Marines = ImmutableList.of(
            ImmutableList.of(
                    CHHeldrake.class));
    private static final List<List<Class<? extends Eintrag>>> Befestigungseinträge_Chaos_Space_Marines = ImmutableList.of(
            ImmutableList.of(
                    CHChaosBastions.class));
    private static final List<List<Class<? extends Eintrag>>> LOWeinträge_Chaos_Space_Marines = ImmutableList.of(
            ImmutableList.of(
                    CHKhorneLordofSkulls.class));

    private static final List<List<Class<? extends Eintrag>>> HQeinträge_Other_Legions = ImmutableList.of(
            ImmutableList.of(
                    CHCypher.class,
                    CHFabiusBile.class),
            ImmutableList.of(
                    CHChaosLord.class,
                    CHChaosLordinTerminatorArmour.class,
                    CHDarkApostle.class,
                    CHExaltedChampion.class,
                    CHDaemonPrinceofChaosCSM.class,
                    CHDaemonPrinceofChaoswithWingsCSM.class,
                    CHSorcerer.class,
                    CHSorcererinTerminatorArmour.class,
                    CHWarpsmith.class),
            ImmutableList.of(
                    CHChaosLordonBike.class,
                    CHChaosLordonJuggernautofKhorne.class,
                    CHChaosLordonDiscofTzeentch.class,
                    CHChaosLordonPalanquinofNurgle.class,
                    CHChaosLordonSteedofSlaanesh.class,
                    CHSorcereronBike.class,
                    CHSorcereronDiscofTzeentch.class,
                    CHSorcereronPalanquinofNurgle.class,
                    CHSorcereronPalanquinofNurgle.class));

    private static final List<List<Class<? extends Eintrag>>> HQeinträge_Black_Legion = ImmutableList.of(
            ImmutableList.of(
                    CHAbaddontheDespoiler.class,
                    CHCypher.class,
                    CHFabiusBile.class),
            ImmutableList.of(
                    CHChaosLord.class,
                    CHChaosLordinTerminatorArmour.class,
                    CHDarkApostle.class,
                    CHExaltedChampion.class,
                    CHDaemonPrinceofChaosCSM.class,
                    CHDaemonPrinceofChaoswithWingsCSM.class,
                    CHSorcerer.class,
                    CHSorcererinTerminatorArmour.class,
                    CHWarpsmith.class),
            ImmutableList.of(
                    CHChaosLordonBike.class,
                    CHChaosLordonJuggernautofKhorne.class,
                    CHChaosLordonDiscofTzeentch.class,
                    CHChaosLordonPalanquinofNurgle.class,
                    CHChaosLordonSteedofSlaanesh.class,
                    CHSorcereronBike.class,
                    CHSorcereronDiscofTzeentch.class,
                    CHSorcereronPalanquinofNurgle.class,
                    CHSorcereronPalanquinofNurgle.class));

    private static final List<List<Class<? extends Eintrag>>> HQeinträge_Red_Corsairs = ImmutableList.of(
            ImmutableList.of(
                    CHHuronBlackheart.class,
                    CHCypher.class,
                    CHFabiusBile.class),
            ImmutableList.of(
                    CHChaosLord.class,
                    CHChaosLordinTerminatorArmour.class,
                    CHDarkApostle.class,
                    CHExaltedChampion.class,
                    CHDaemonPrinceofChaosCSM.class,
                    CHDaemonPrinceofChaoswithWingsCSM.class,
                    CHSorcerer.class,
                    CHSorcererinTerminatorArmour.class,
                    CHWarpsmith.class),
            ImmutableList.of(
                    CHChaosLordonBike.class,
                    CHChaosLordonJuggernautofKhorne.class,
                    CHChaosLordonDiscofTzeentch.class,
                    CHChaosLordonPalanquinofNurgle.class,
                    CHChaosLordonSteedofSlaanesh.class,
                    CHSorcereronBike.class,
                    CHSorcereronDiscofTzeentch.class,
                    CHSorcereronPalanquinofNurgle.class,
                    CHSorcereronPalanquinofNurgle.class));

    private static final List<List<Class<? extends Eintrag>>> HQeinträge_World_Eaters = ImmutableList.of(
            ImmutableList.of(
                    CHKharntheBetrayer.class,
                    CHChaosLord.class,
                    CHChaosLordinTerminatorArmour.class,
                    CHExaltedChampion.class,
                    CHDarkApostle.class,
                    CHDaemonPrinceofChaos.class,
                    CHDaemonPrinceofChaoswithWings.class,
                    CHWarpsmith.class),
            ImmutableList.of(
                    CHChaosLordonBike.class,
                    CHChaosLordonJuggernautofKhorne.class));
    private static final List<List<Class<? extends Eintrag>>> Eliteeinträge_World_Eaters = ImmutableList.of(
            ImmutableList.of(
                    CHFallen.class,
                    CHPlagueMarines.class,
                    CHNoiseMarines.class,
                    CHRubricMarines.class,
                    CHChaosTerminators.class,
                    CHChosen.class,
                    CHPossessed.class,
                    CHHelbrute.class,
                    CHMutilators.class));
    private static final List<List<Class<? extends Eintrag>>> Standardeinträge_World_Eaters = ImmutableList.of(
            ImmutableList.of(
                    CHKhorneBerzerkers.class,
                    CHChaosSpaceMarines.class,
                    CHChaosCultists.class));
    private static final List<List<Class<? extends Eintrag>>> Sturmeinträge_World_Eaters = ImmutableList.of(
            ImmutableList.of(
                    CHChaosBikers.class,
                    CHRaptors.class,
                    CHWarpTalons.class,
                    CHChaosSpawn.class));
    private static final List<List<Class<? extends Eintrag>>> Unterstützungseinträge_World_Eaters = ImmutableList.of(
            ImmutableList.of(
                    CHChaosLandRaider.class,
                    CHChaosPredator.class,
                    CHChaosVindicator.class,
                    CHObliterators.class,
                    CHHavocs.class,
                    CHForgefiend.class,
                    CHMaulerfiend.class,
                    CHDefiler.class));
    private static final List<List<Class<? extends Eintrag>>> Transporteinträge_World_Eaters = ImmutableList.of(
            ImmutableList.of(
                    CHChaosRhino.class));
    private static final List<List<Class<? extends Eintrag>>> Fliegereinträge_World_Eaters = ImmutableList.of(
            ImmutableList.of(
                    CHHeldrake.class));
    private static final List<List<Class<? extends Eintrag>>> LOWeinträge_World_Eaters = ImmutableList.of(
            ImmutableList.of(
                    CHKhorneLordofSkulls.class));

    private static final List<List<Class<? extends Eintrag>>> HQeinträge_ThousandSons = ImmutableList.of(
            ImmutableList.of(
                    CHAhriman.class,
                    CHAhrimanonDiscofTzeentch.class,
                    CHDaemonPrinceofTzeentch.class,
                    CHDaemonPrinceofTzeentchwithWings.class,
                    CHExaltedSorcerer.class,
                    CHExaltedSorcereronDiscofTzeentch.class,
                    CHThousandSonsSorcerer.class,
                    CHTSSorcererinTerminatorArmour.class),
            ImmutableList.of(
                    CHSorcereronDiscofTzeentch.class));
    private static final List<List<Class<? extends Eintrag>>> Eliteeinträge_ThousandSons = ImmutableList.of(
            ImmutableList.of(
                    CHTzaangorShaman.class,
                    CHFlamers.class,
                    CHScarabOccultTerminators.class,
                    CHHelbrute.class));
    private static final List<List<Class<? extends Eintrag>>> Standardeinträge_ThousandSons = ImmutableList.of(
            ImmutableList.of(
                    CHTSRubricMarines.class,
                    CHTzaangors.class,
                    CHChaosCultists.class,
                    CHHorrors.class));
    private static final List<List<Class<? extends Eintrag>>> Sturmeinträge_ThousandSons = ImmutableList.of(
            ImmutableList.of(
                    CHTzaangorEnlightened.class,
                    CHScreamers.class,
                    CHChaosSpawn.class));
    private static final List<List<Class<? extends Eintrag>>> Unterstützungseinträge_ThousandSons = ImmutableList.of(
            ImmutableList.of(
                    CHMutalithVortexBeast.class,
                    CHChaosLandRaider.class,
                    CHChaosPredator.class,
                    CHChaosVindicator.class,
                    CHForgefiend.class,
                    CHMaulerfiend.class,
                    CHDefiler.class));
    private static final List<List<Class<? extends Eintrag>>> Transporteinträge_ThousandSons = ImmutableList.of(
            ImmutableList.of(
                    CHChaosRhino.class));
    private static final List<List<Class<? extends Eintrag>>> Fliegereinträge_ThousandSons = ImmutableList.of(
            ImmutableList.of(
                    CHHeldrake.class));
    private static final List<List<Class<? extends Eintrag>>> LOWeinträge_ThousandSons = ImmutableList.of(
            ImmutableList.of(
                    CHMagnustheRed.class));

    private static final List<List<Class<? extends Eintrag>>> HQeinträge_Death_Guard = ImmutableList.of(
            ImmutableList.of(
                    CHTyphus.class,
                    CHLordofContagion.class,
                    CHMalignantPlaguecaster.class,
                    CHDaemonPrinceofNurgle.class,
                    CHDaemonPrinceofNurglewithWings.class,
                    CHChaosLord.class,
                    CHChaosLordinTerminatorArmour.class,
                    CHSorcerer.class,
                    CHSorcererinTerminatorArmour.class),
            ImmutableList.of(
                    CHNecrosiustheUndying.class));
    private static final List<List<Class<? extends Eintrag>>> Eliteeinträge_Death_Guard = ImmutableList.of(
            ImmutableList.of(
                    CHNoxiousBlightbringer.class,
                    CHFoulBlightspawn.class,
                    CHBiologusPutrifier.class,
                    CHPlagueSurgeon.class,
                    CHTallyman.class,
                    CHDeathshroudTerminators.class,
                    CHBlightlordTerminators.class,
                    CHHelbrute.class,
                    CHBeastsofNurgle.class,
                    CHPossessed.class));
    private static final List<List<Class<? extends Eintrag>>> Standardeinträge_Death_Guard = ImmutableList.of(
            ImmutableList.of(
                    CHPlagueMarines.class,
                    CHPoxwalkers.class,
                    CHChaosCultists.class,
                    CHPlaguebearers.class,
                    CHNurglings.class));
    private static final List<List<Class<? extends Eintrag>>> Sturmeinträge_Death_Guard = ImmutableList.of(
            ImmutableList.of(
                    CHFoetidBloatDrone.class,
                    CHMyphiticBlightHaulers.class,
                    CHChaosSpawn.class,
                    CHPlagueDrones.class));
    private static final List<List<Class<? extends Eintrag>>> Unterstützungseinträge_Death_Guard = ImmutableList.of(
            ImmutableList.of(
                    CHChaosLandRaider.class,
                    CHPlagueburstCrawler.class,
                    CHDefiler.class,
                    CHChaosPredator.class));
    private static final List<List<Class<? extends Eintrag>>> Transporteinträge_Death_Guard = ImmutableList.of(
            ImmutableList.of(
                    CHChaosRhino.class));
    private static final List<List<Class<? extends Eintrag>>> Fliegereinträge_Death_Guard = ImmutableList.of();
    private static final List<List<Class<? extends Eintrag>>> LOWeinträge_Death_Guard = ImmutableList.of(
            ImmutableList.of(
                    CHMortarion.class));

    private static final List<List<Class<? extends Eintrag>>> HQeinträge_Emperors_Children = ImmutableList.of(
            ImmutableList.of(
                    CHLuciustheEternal.class,
                    CHChaosLord.class,
                    CHChaosLordinTerminatorArmour.class,
                    CHDarkApostle.class,
                    CHDaemonPrinceofChaos.class,
                    CHDaemonPrinceofChaoswithWings.class,
                    CHSorcerer.class,
                    CHSorcererinTerminatorArmour.class,
                    CHWarpsmith.class),
            ImmutableList.of(
                    CHChaosLordonBike.class,
                    CHChaosLordonJuggernautofKhorne.class,
                    CHChaosLordonDiscofTzeentch.class,
                    CHChaosLordonPalanquinofNurgle.class,
                    CHChaosLordonSteedofSlaanesh.class,
                    CHSorcereronBike.class,
                    CHSorcereronDiscofTzeentch.class,
                    CHSorcereronPalanquinofNurgle.class));
    private static final List<List<Class<? extends Eintrag>>> Eliteeinträge_Emperors_Children = ImmutableList.of(
            ImmutableList.of(
                    CHFallen.class,
                    CHPlagueMarines.class,
                    CHKhorneBerzerkers.class,
                    CHRubricMarines.class,
                    CHChaosTerminators.class,
                    CHChosen.class,
                    CHPossessed.class,
                    CHHelbrute.class,
                    CHMutilators.class));
    private static final List<List<Class<? extends Eintrag>>> Standardeinträge_Emperors_Children = ImmutableList.of(
            ImmutableList.of(
                    CHNoiseMarines.class,
                    CHChaosSpaceMarines.class,
                    CHChaosCultists.class));
    private static final List<List<Class<? extends Eintrag>>> Sturmeinträge_Emperors_Children = ImmutableList.of(
            ImmutableList.of(
                    CHChaosBikers.class,
                    CHRaptors.class,
                    CHWarpTalons.class,
                    CHChaosSpawn.class));
    private static final List<List<Class<? extends Eintrag>>> Unterstützungseinträge_Emperors_Children = ImmutableList.of(
            ImmutableList.of(
                    CHChaosLandRaider.class,
                    CHChaosPredator.class,
                    CHChaosVindicator.class,
                    CHObliterators.class,
                    CHHavocs.class,
                    CHForgefiend.class,
                    CHMaulerfiend.class,
                    CHDefiler.class));
    private static final List<List<Class<? extends Eintrag>>> Transporteinträge_Emperors_Children = ImmutableList.of(
            ImmutableList.of(
                    CHChaosRhino.class));
    private static final List<List<Class<? extends Eintrag>>> Fliegereinträge_Emperors_Children = ImmutableList.of(
            ImmutableList.of(
                    CHHeldrake.class));
    private static final List<List<Class<? extends Eintrag>>> LOWeinträge_Emperors_Children = ImmutableList.of(
            ImmutableList.of(
                    CHKhorneLordofSkulls.class));

    private static final List<List<Class<? extends Eintrag>>> HQeinträge_Questor_Traitoris = ImmutableList.of();
    private static final List<List<Class<? extends Eintrag>>> Eliteeinträge_Questor_Traitoris = ImmutableList.of();
    private static final List<List<Class<? extends Eintrag>>> Standardeinträge_Questor_Traitoris = ImmutableList.of();
    private static final List<List<Class<? extends Eintrag>>> Sturmeinträge_Questor_Traitoris = ImmutableList.of();
    private static final List<List<Class<? extends Eintrag>>> Unterstüzungseinträge_Questor_Traitoris = ImmutableList.of();
    private static final List<List<Class<? extends Eintrag>>> Fliegereinträge_Questor_Traitoris = ImmutableList.of();
    private static final List<List<Class<? extends Eintrag>>> Transporteinträge_Questor_Traitoris = ImmutableList.of();
    private static final List<List<Class<? extends Eintrag>>> LOWeinträge_Questor_Traitoris = ImmutableList.of(
            ImmutableList.of(
                    CHRenegadeKnight.class,
                    CHRenegadeKnightDominus.class,
                    CHRenegadeArmiger.class));

    //CHAOSDAEMONS
    private static final List<List<Class<? extends Eintrag>>> HQ_Daemons_No_God = ImmutableList.of(
            ImmutableList.of(CHBeLakor.class));
    private static final List<List<Class<? extends Eintrag>>> HQ_Daemons_All_Gods = ImmutableList.of(
            ImmutableList.of(
                    CHDaemonPrinceofChaos.class,
                    CHDaemonPrinceofChaoswithWings.class));
    private static final List<List<Class<? extends Eintrag>>> Sturm_Daemons_All_Gods = ImmutableList.of(
            ImmutableList.of(CHFuries.class));
    private static final List<List<Class<? extends Eintrag>>> Unterstuezung_Daemons_All_Gods = ImmutableList.of(
            ImmutableList.of(CHSoulgrinder.class));

    //KHORNE
    private static final List<List<Class<? extends Eintrag>>> HQ_Daemons_Khorne = ImmutableList.of(
            ImmutableList.of(
                    CHSkarbrand.class,
                    CHBloodthirsterofInsensateRage.class,
                    CHWrathofKhorneBloodthirster.class,
                    CHBloodthirsterofUnfetteredFury.class,
                    CHSkulltaker.class,
                    CHBloodmaster.class,
                    CHSkullmaster.class,
                    CHBloodThrone.class,
                    CHKaranak.class));
    private static final List<List<Class<? extends Eintrag>>> Elite_Daemons_Khorne = ImmutableList.of(
            ImmutableList.of(CHBloodcrushers.class));
    private static final List<List<Class<? extends Eintrag>>> Standard_Daemons_Khorne = ImmutableList.of(
            ImmutableList.of(CHBloodletters.class));
    private static final List<List<Class<? extends Eintrag>>> Sturm_Daemons_Khorne = ImmutableList.of(
            ImmutableList.of(CHFleshHounds.class));
    private static final List<List<Class<? extends Eintrag>>> Unterstuezung_Daemons_Khorne = ImmutableList.of(
            ImmutableList.of(CHSkullCannon.class));

    //Tzeentch
    private static final List<List<Class<? extends Eintrag>>> HQ_Daemons_Tzeentch = ImmutableList.of(
            ImmutableList.of(
                    CHKairosFateweaver.class,
                    CHLordofChange.class,
                    CHTheChangeling.class,
                    CHTheBlueScribes.class,
                    CHChangecaster.class,
                    CHFateskimmer.class,
                    CHFluxmaster.class));
    private static final List<List<Class<? extends Eintrag>>> Elite_Daemons_Tzeentch = ImmutableList.of(
            ImmutableList.of(CHFlamers.class, CHExaltedFlamer.class));
    private static final List<List<Class<? extends Eintrag>>> Standard_Daemons_Tzeentch = ImmutableList.of(
            ImmutableList.of(CHHorrors.class));
    private static final List<List<Class<? extends Eintrag>>> Sturm_Daemons_Tzeentch = ImmutableList.of(
            ImmutableList.of(CHScreamers.class));
    private static final List<List<Class<? extends Eintrag>>> Unterstuezung_Daemons_Tzeentch = ImmutableList.of(
            ImmutableList.of(CHBurningChariot.class));

    //Nurgle
    private static final List<List<Class<? extends Eintrag>>> HQ_Daemons_Nurgle = ImmutableList.of(
            ImmutableList.of(
                    CHRotigus.class,
                    CHGreatUncleanOne.class,
                    CHEpidemius.class,
                    CHHorticulousSlimux.class,
                    CHPoxbringer.class,
                    CHSloppityBilepiper.class,
                    CHSpoilpoxScrivener.class));
    private static final List<List<Class<? extends Eintrag>>> Elite_Daemons_Nurgle = ImmutableList.of(
            ImmutableList.of(CHBeastsofNurgle.class));
    private static final List<List<Class<? extends Eintrag>>> Standard_Daemons_Nurgle = ImmutableList.of(
            ImmutableList.of(CHPlaguebearers.class, CHNurglings.class));
    private static final List<List<Class<? extends Eintrag>>> Sturm_Daemons_Nurgle = ImmutableList.of(
            ImmutableList.of(CHPlagueDrones.class));
    private static final List<List<Class<? extends Eintrag>>> Befestigung_Daemons_Nurgle = ImmutableList.of(
            ImmutableList.of(CHFeculentGnarlmaws.class));

    //Slaanesh
    private static final List<List<Class<? extends Eintrag>>> HQ_Daemons_Slaanesh = ImmutableList.of(
            ImmutableList.of(
                    CHKeeperofSecrets.class,
                    CHTheMasqueofSlaanesh.class,
                    CHHeraldofSlaanesh.class,
                    CHHeraldofSlaaneshonSteed.class,
                    CHHeraldofSlaaneshonSeekerChariot.class,
                    CHHeraldofSlaaneshonExaltedSeekerChariot.class));
    private static final List<List<Class<? extends Eintrag>>> Elite_Daemons_Slaanesh = ImmutableList.of(
            ImmutableList.of(CHFiendsofSlaanesh.class));
    private static final List<List<Class<? extends Eintrag>>> Standard_Daemons_Slaanesh = ImmutableList.of(
            ImmutableList.of(CHDaemonettes.class));
    private static final List<List<Class<? extends Eintrag>>> Sturm_Daemons_Slaanesh = ImmutableList.of(
            ImmutableList.of(
                    CHSeekers.class,
                    CHHellflayer.class));
    private static final List<List<Class<? extends Eintrag>>> Unterstuezung_Daemons_Slaanesh = ImmutableList.of(
            ImmutableList.of(
                    CHSeekerChariot.class,
                    CHExaltedSeekerChariot.class));

    //All Daemons
    private static final List<List<Class<? extends Eintrag>>> HQeinträge_Daemons = concat(HQ_Daemons_No_God, HQ_Daemons_All_Gods, HQ_Daemons_Khorne, HQ_Daemons_Tzeentch, HQ_Daemons_Nurgle, HQ_Daemons_Slaanesh);
    private static final List<List<Class<? extends Eintrag>>> Standardeinträge_Daemons = concat(Standard_Daemons_Khorne, Standard_Daemons_Tzeentch, Standard_Daemons_Nurgle, Standard_Daemons_Slaanesh);
    private static final List<List<Class<? extends Eintrag>>> Eliteeinträge_Daemons = concat(Elite_Daemons_Khorne, Elite_Daemons_Tzeentch, Elite_Daemons_Nurgle, Elite_Daemons_Slaanesh);
    private static final List<List<Class<? extends Eintrag>>> Sturmeinträge_Daemons = concat(Sturm_Daemons_Khorne, Sturm_Daemons_Tzeentch, Sturm_Daemons_Nurgle, Sturm_Daemons_Slaanesh, Sturm_Daemons_All_Gods);
    private static final List<List<Class<? extends Eintrag>>> Unterstüzungseinträge_Daemons = concat(Unterstuezung_Daemons_Khorne, Unterstuezung_Daemons_Tzeentch, Unterstuezung_Daemons_Slaanesh, Unterstuezung_Daemons_All_Gods);
    private static final List<List<Class<? extends Eintrag>>> Befestigungseinträge_Daemons = Befestigung_Daemons_Nurgle;

    private static final Set<String> LEGIONS = ImmutableSet.of("Alpha Legion", "Black Legion", "Emperor's Children", "Iron Warriors", "NightLords", "World Eaters", "WordBearers", "Red Corsairs", "Renegade Chapters");
    private static final Set<String> CHAOS_GODS = ImmutableSet.of("Khorne", "Tzeentch", "Nurgle", "Slaanesh");

    public VOLKChaos() {
        super("CH", loadPoints("/oc/wh40k/indices/chaos.yaml"));

        volk = "CHAOS";
        nameDerArtDerArmee = "CHAOS";
        nameDerArtDerArmeeDekliniert = "CHAOS";

        //Verschiedene Spezialkontingente
        kontingente.add(null);
        kontingente.add("Daemonicincursion Detachment (CotW)");
        kontingente.add("Daemon LegionsofTzeentch");

        //Formationen
        formationen.add("CHAOS");
        formationen.add("Heretic Astartes");
        formationen.add("ChaosSpaceMarines");
        LEGIONS.forEach(formationen::add);
        formationen.add("Death Guard");
        formationen.add("ThousandSons");
        formationen.add(null);
        formationen.add("Chaosdaemons");
        CHAOS_GODS.forEach(formationen::add);
        formationen.add(null);
        formationen.add("Questor Traitoris");
        formationen.add(null);
        formationen.add("The Tainted");

        complete();
    }

    @Override
    public void volkRefresh() {
        if (getFormationType().equals("CHAOS")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_Chaos_Space_Marines, HQeinträge_Death_Guard, HQeinträge_ThousandSons, HQeinträge_Daemons, HQeinträge_Chaos_Space_Marines_FW, HQeinträge_Daemons_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(
                    Eliteeinträge_Chaos_Space_Marines, Eliteeinträge_Death_Guard, Eliteeinträge_ThousandSons, Eliteeinträge_Daemons, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(concat(
                    ImmutableList.of(ImmutableList.of(CHChaosSpaceMarines.class, CHChaosCultists.class, CHTzaangors.class, CHPoxwalkers.class)),
                    Standardeinträge_Daemons, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_Chaos_Space_Marines, Sturmeinträge_Death_Guard, Sturmeinträge_ThousandSons, Sturmeinträge_Daemons, Sturmeinträge_Chaos_Space_Marines_FW, Sturmeinträge_Daemons_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungseinträge_Chaos_Space_Marines, Unterstützungseinträge_Death_Guard, Unterstützungseinträge_ThousandSons, Unterstüzungseinträge_Daemons, Unterstützungseinträge_Chaos_Space_Marines_FW, Unterstützungseinträge_Daemons_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(
                    Transporteinträge_Chaos_Space_Marines, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(
                    Fliegereinträge_Chaos_Space_Marines, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(concat(
                    Befestigungseinträge_Chaos_Space_Marines, Befestigungseinträge_Daemons, Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(
                    LOWeinträge_Chaos_Space_Marines, LOWeinträge_Death_Guard, LOWeinträge_ThousandSons, LOWeinträge_Questor_Traitoris, LOWeinträge_Chaos_Space_Marines_FW));
        } else if (getFormationType().equals("Heretic Astartes")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(
                    HQeinträge_Chaos_Space_Marines, HQeinträge_Death_Guard, HQeinträge_ThousandSons, HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(
                    Eliteeinträge_Chaos_Space_Marines, Eliteeinträge_Death_Guard, Eliteeinträge_ThousandSons, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(concat(
                    ImmutableList.of(ImmutableList.of(CHChaosSpaceMarines.class, CHChaosCultists.class, CHTzaangors.class, CHPoxwalkers.class)),
                    Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(
                    Sturmeinträge_Chaos_Space_Marines, Sturmeinträge_Death_Guard, Sturmeinträge_ThousandSons, Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(
                    Unterstützungseinträge_Chaos_Space_Marines, Unterstützungseinträge_Death_Guard, Unterstützungseinträge_ThousandSons, Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(
                    Transporteinträge_Chaos_Space_Marines, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(
                    Fliegereinträge_Chaos_Space_Marines, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(concat(
                    Befestigungseinträge_Chaos_Space_Marines, Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(
                    LOWeinträge_Chaos_Space_Marines, LOWeinträge_Death_Guard, LOWeinträge_ThousandSons, LOWeinträge_Questor_Traitoris, LOWeinträge_Chaos_Space_Marines_FW));
        } else if (getFormationType().equals("World Eaters")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(
                    HQeinträge_World_Eaters, HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(
                    Eliteeinträge_World_Eaters, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(concat(
                    Standardeinträge_World_Eaters, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(
                    Sturmeinträge_World_Eaters, Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(
                    Unterstützungseinträge_World_Eaters, Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(
                    Transporteinträge_World_Eaters, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(
                    Fliegereinträge_World_Eaters, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(concat(
                    ImmutableList.of(), Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(
                    LOWeinträge_World_Eaters, LOWeinträge_Chaos_Space_Marines_FW));
        } else if (getFormationType().equals("ThousandSons")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(
                    HQeinträge_ThousandSons, HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(
                    Eliteeinträge_ThousandSons, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(concat(
                    Standardeinträge_ThousandSons, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(
                    Sturmeinträge_ThousandSons, Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(
                    Unterstützungseinträge_ThousandSons, Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(
                    Transporteinträge_ThousandSons, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(
                    Fliegereinträge_ThousandSons, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(concat(
                    ImmutableList.of(), Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(
                    LOWeinträge_ThousandSons, LOWeinträge_Chaos_Space_Marines_FW));
        } else if (getFormationType().equals("Death Guard")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_Death_Guard, HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_Death_Guard, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(concat(Standardeinträge_Death_Guard, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_Death_Guard, Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungseinträge_Death_Guard, Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(Transporteinträge_Death_Guard, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_Death_Guard, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(concat(ImmutableList.of(), Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LOWeinträge_Death_Guard);
        } else if (getFormationType().equals("Emperor's Children")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_Emperors_Children, HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_Emperors_Children, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(concat(Standardeinträge_Emperors_Children, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_Emperors_Children, Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungseinträge_Emperors_Children, Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(Transporteinträge_Emperors_Children, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_Emperors_Children, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(concat(ImmutableList.of(), Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(LOWeinträge_Emperors_Children, LOWeinträge_Chaos_Space_Marines_FW));
        } else if (getFormationType().equals("ChaosSpaceMarines")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(
                    HQeinträge_Chaos_Space_Marines, HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(
                    concat(Eliteeinträge_Chaos_Space_Marines, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(concat(
                    Standardeinträge_Chaos_Space_Marines, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(
                    Sturmeinträge_Chaos_Space_Marines, Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(
                    Unterstützungseinträge_Chaos_Space_Marines, Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(
                    Transporteinträge_Chaos_Space_Marines, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(
                    Fliegereinträge_Chaos_Space_Marines, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(concat(
                    Befestigungseinträge_Chaos_Space_Marines, Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(
                    LOWeinträge_Chaos_Space_Marines, LOWeinträge_Chaos_Space_Marines_FW));
        } else if (getFormationType().equals("ChaosSpaceMarines")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(
                    HQeinträge_Chaos_Space_Marines, HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(
                    concat(Eliteeinträge_Chaos_Space_Marines, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(concat(
                    Standardeinträge_Chaos_Space_Marines, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(
                    Sturmeinträge_Chaos_Space_Marines, Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(
                    Unterstützungseinträge_Chaos_Space_Marines, Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(
                    Transporteinträge_Chaos_Space_Marines, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(
                    Fliegereinträge_Chaos_Space_Marines, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(concat(
                    Befestigungseinträge_Chaos_Space_Marines, Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(
                    LOWeinträge_Chaos_Space_Marines, LOWeinträge_Chaos_Space_Marines_FW));
        } else if (getFormationType().equals("Red Corsairs")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(
                    HQeinträge_Red_Corsairs, HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(
                    concat(Eliteeinträge_Chaos_Space_Marines, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(concat(
                    Standardeinträge_Chaos_Space_Marines, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(
                    Sturmeinträge_Chaos_Space_Marines, Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(
                    Unterstützungseinträge_Chaos_Space_Marines, Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(
                    Transporteinträge_Chaos_Space_Marines, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(
                    Fliegereinträge_Chaos_Space_Marines, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(concat(
                    Befestigungseinträge_Chaos_Space_Marines, Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(
                    LOWeinträge_Chaos_Space_Marines, LOWeinträge_Chaos_Space_Marines_FW));
        } else if (getFormationType().equals("Black Legion")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(
                    HQeinträge_Black_Legion, HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(
                    concat(Eliteeinträge_Chaos_Space_Marines, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(concat(
                    Standardeinträge_Chaos_Space_Marines, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(
                    Sturmeinträge_Chaos_Space_Marines, Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(
                    Unterstützungseinträge_Chaos_Space_Marines, Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(
                    Transporteinträge_Chaos_Space_Marines, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(
                    Fliegereinträge_Chaos_Space_Marines, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(concat(
                    Befestigungseinträge_Chaos_Space_Marines, Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(
                    LOWeinträge_Chaos_Space_Marines, LOWeinträge_Chaos_Space_Marines_FW));
        } else if (LEGIONS.contains(getFormationType())) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(
                    HQeinträge_Other_Legions, HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(
                    concat(Eliteeinträge_Chaos_Space_Marines, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(concat(
                    Standardeinträge_Chaos_Space_Marines, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(
                    Sturmeinträge_Chaos_Space_Marines, Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(
                    Unterstützungseinträge_Chaos_Space_Marines, Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(
                    Transporteinträge_Chaos_Space_Marines, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(
                    Fliegereinträge_Chaos_Space_Marines, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(concat(
                    Befestigungseinträge_Chaos_Space_Marines, Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(
                    LOWeinträge_Chaos_Space_Marines, LOWeinträge_Chaos_Space_Marines_FW));
        } else if (getFormationType().equals("Questor Traitoris")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Questor_Traitoris);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Questor_Traitoris);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Questor_Traitoris);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_Questor_Traitoris);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstüzungseinträge_Questor_Traitoris);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Questor_Traitoris);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(Fliegereinträge_Questor_Traitoris);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of());
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LOWeinträge_Questor_Traitoris);
        } else if (getFormationType().equals("Chaosdaemons")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_Daemons, HQeinträge_Daemons_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Daemons);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Daemons);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_Daemons, Sturmeinträge_Daemons_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstüzungseinträge_Daemons, Unterstützungseinträge_Daemons_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of());
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of());
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungseinträge_Daemons);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LOWeinträge_Daemons_FW);
        } else if (getFormationType().equals("Khorne")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQ_Daemons_Khorne, HQ_Daemons_All_Gods,
                    ImmutableList.of(ImmutableList.of(CHUrakaTheWarfiend.class, CHSamus.class))));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Elite_Daemons_Khorne);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standard_Daemons_Khorne);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturm_Daemons_Khorne, Sturm_Daemons_All_Gods));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstuezung_Daemons_Khorne, Unterstuezung_Daemons_All_Gods));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of());
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of());
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of());
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(ImmutableList.of(CHAnggrathTheUnbound.class)));
        } else if (getFormationType().equals("Tzeentch")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQ_Daemons_Tzeentch, HQ_Daemons_All_Gods));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Elite_Daemons_Tzeentch);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standard_Daemons_Tzeentch);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturm_Daemons_Tzeentch, Sturm_Daemons_All_Gods));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstuezung_Daemons_Tzeentch, Unterstuezung_Daemons_All_Gods));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of());
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of());
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of());
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(
                    ImmutableList.of(ImmutableList.of(CHAetaosraukeres.class)));
        } else if (getFormationType().equals("Slaanesh")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQ_Daemons_Slaanesh, HQ_Daemons_All_Gods));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Elite_Daemons_Slaanesh);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standard_Daemons_Slaanesh);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturm_Daemons_Slaanesh, Sturm_Daemons_All_Gods));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstuezung_Daemons_Slaanesh, Unterstuezung_Daemons_All_Gods));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of());
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of());
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of());
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(
                    ImmutableList.of(ImmutableList.of(CHZarakynel.class)));
        } else if (getFormationType().equals("Nurgle")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQ_Daemons_Nurgle, HQ_Daemons_All_Gods,
                    ImmutableList.of(ImmutableList.of(CHMamonTransfigured.class, CHCorbaxUtterblight.class))));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Elite_Daemons_Nurgle);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standard_Daemons_Nurgle);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturm_Daemons_Nurgle, Sturm_Daemons_All_Gods,
                    ImmutableList.of(ImmutableList.of(CHPlagueToadsOfNurgle.class, CHPoxRidersOfNurgle.class))));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstuezung_Daemons_All_Gods,
                    ImmutableList.of(ImmutableList.of(CHPlagueHulkOfNurgle.class))));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of());
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of());
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigung_Daemons_Nurgle);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(
                    ImmutableList.of(CHScabeiathraxTheBloated.class)));
        } else if (getFormationType().equals("The Tainted")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(
                    HQeinträge_Chaos_Space_Marines,
                    ImmutableList.of(ImmutableList.of(CHNecrosiustheUndying.class, CHMamonTransfigured.class)),
                    HQeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_Chaos_Space_Marines, Eliteeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(concat(Standardeinträge_Chaos_Space_Marines, Standardeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_Chaos_Space_Marines, Sturmeinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungseinträge_Chaos_Space_Marines, Unterstützungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(Transporteinträge_Chaos_Space_Marines, Transporteinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_Chaos_Space_Marines, Fliegereinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(concat(Befestigungseinträge_Chaos_Space_Marines, Befestigungseinträge_Chaos_Space_Marines_FW));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(LOWeinträge_Chaos_Space_Marines, LOWeinträge_Chaos_Space_Marines_FW));
        }

        if (formation != null) {
            formation.refreshControlPanel();
        }

        fillChooserSpace();
    }
}