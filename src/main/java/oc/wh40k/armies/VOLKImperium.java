package oc.wh40k.armies;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import oc.BuildaVater;
import oc.Eintrag;
import oc.utils.ResourceUtils;
import oc.wh40k.units.im.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static oc.utils.EvenMoreCollections.concat;

public class VOLKImperium extends BuildaVater {

    private static final List<Class<? extends Eintrag>> HQeinträge_AM = ImmutableList.of(null,
                    IMCompanyCommander.class,
                    IMTankCommander.class);
    private static final List<Class<? extends Eintrag>> Standardeinträge_AM = ImmutableList.of(null,
                    IMInfantrySquad.class,
                    IMConscripts.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_AM = ImmutableList.of(null,
                    IMMasterofOrdnance.class,
                    IMPlatoonCommander.class,
                    IMCommandSquad.class,
                    IMSpecialWeaponsSquad.class,
                    IMVeterans.class,
                    IMTechPriestEnginseer.class,
                    IMServitors.class);
    private static final List<Class<? extends Eintrag>> Sturmeinträge_AM = ImmutableList.of(null,
                    IMRoughRiders.class,
                    IMScoutSentinels.class,
                    IMArmouredSentinels.class,
                    IMHellhounds.class);
    private static final List<Class<? extends Eintrag>> Unterstützungeinträge_AM = ImmutableList.of(null,
                    IMHeavyWeaponsSquad.class,
                    IMBasilisks.class,
                    IMHydras.class,
                    IMWyverns.class,
                    IMManticore.class,
                    IMDeathstrike.class,
            IMLemanRussBattleTanks.class);
    private static final List<Class<? extends Eintrag>>Transporteinträge_AM = ImmutableList.of(null,
                    IMChimera.class,
                    IMTaurox.class);
    private static final List<Class<? extends Eintrag>> Fliegereinträge_AM = ImmutableList.of(null);
    private static final List<Class<? extends Eintrag>> LordofWar_AM = ImmutableList.of(null,
                    IMBaneblade.class,
                    IMBanehammer.class,
                    IMBanesword.class,
                    IMDoomhammer.class,
                    IMHellhammer.class,
                    IMShadowsword.class,
                    IMStormlord.class,
                    IMStormsword.class);
    //CADIAN
    private static final List<Class<? extends Eintrag>> HQeinträge_Cadian = ImmutableList.of(null,
                    IMLordCastellanCreed.class,
                    IMKnightCommanderPask.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Cadian = ImmutableList.of(null,
                    IMColourSergeantKell.class);
    //CATACHAN
    private static final List<Class<? extends Eintrag>> HQeinträge_Catachan = ImmutableList.of(null,
                    IMColonelIronHandStraken.class,
                    IMSlyMarbo.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Catachan = ImmutableList.of(null,
                    IMSergeantHarker.class);
    //OFFICIOPREFECTUS
    private static final List<Class<? extends Eintrag>> HQeinträge_Officio_Prefectus = ImmutableList.of(null,
                    IMLordCommissar.class,
                    IMCommissarYarrick.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Officio_Prefectus = ImmutableList.of(null,
                    IMCommissar.class);
    //MILITARUMTEMPESTUS
    private static final List<Class<? extends Eintrag>> HQeinträge_Militarum_Tempestus = ImmutableList.of(null,
                    IMTempestorPrime.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Militarum_Tempestus = ImmutableList.of(null,
                    IMMilitarumTempestusCommandSquad.class);
    private static final List<Class<? extends Eintrag>> Standardeinträge_Militarum_Tempestus = ImmutableList.of(null,
                    IMMilitarumTempestusScions.class);
    private static final List<Class<? extends Eintrag>>Transporteinträge_Militarum_Tempestus = ImmutableList.of(null,
                    IMTauroxPrime.class);
    //MILITARUMAUXILIA
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Militarum_Auxilia = ImmutableList.of(null,
                    IMOgryns.class,
                    IMOgrynBodyguard.class,
                    IMBullgryns.class,
                    IMRatlings.class,
                    IMNorkDeddog.class);
    //AERONAUTICA IMPERIALIS
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Aeronautica_Imperialis = ImmutableList.of(null,
                    IMOfficeroftheFleet.class);
    private static final List<Class<? extends Eintrag>> Fliegereinträge_Aeronautica_Imperialis = ImmutableList.of(null,
                    IMValkyries.class);
    //SCHOLASTICAPSYKANA
    private static final List<Class<? extends Eintrag>> HQeinträge_Scholastica_Psykana = ImmutableList.of(null,
                    IMPrimarisPsyker.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Scholastica_Psykana = ImmutableList.of(null,
                    IMWyrdvanePsykers.class,
                    IMAstropath.class);
    //ADEPTUS MINISTORUM-PART OFASTRA MILITARUM
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Astra_Militarum_Adeptus_Ministorum = ImmutableList.of(null,
                    IMMinistorumPriest.class,
                    IMCrusaders.class);

    //AM KOMPLETT
    private static final List<Class<? extends Eintrag>> HQeinträge_AM_komplett = concat(concat(concat(concat(concat
                    (HQeinträge_AM, HQeinträge_Cadian), HQeinträge_Catachan),
            HQeinträge_Officio_Prefectus), HQeinträge_Militarum_Tempestus),
            HQeinträge_Scholastica_Psykana);
    private static final List<Class<? extends Eintrag>> Standardeinträge_AM_komplett = concat(Standardeinträge_AM, Standardeinträge_Militarum_Tempestus);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_AM_komplett = concat(concat(concat(concat(concat(concat(concat(concat(
            Eliteeinträge_AM, Eliteeinträge_Cadian), Eliteeinträge_Catachan), Eliteeinträge_Officio_Prefectus),
            Eliteeinträge_Militarum_Tempestus), Eliteeinträge_Militarum_Auxilia), Eliteeinträge_Aeronautica_Imperialis),
            Eliteeinträge_Scholastica_Psykana), Eliteeinträge_Astra_Militarum_Adeptus_Ministorum);
    private static final List<Class<? extends Eintrag>> Sturmeinträge_AM_komplett = Sturmeinträge_AM;
    private static final List<Class<? extends Eintrag>> Unterstützungeinträge_AM_komplett = Unterstützungeinträge_AM;
    private static final List<Class<? extends Eintrag>>Transporteinträge_AM_komplett = concat(Transporteinträge_AM,Transporteinträge_Militarum_Tempestus);
    private static final List<Class<? extends Eintrag>> Fliegereinträge_AM_komplett = concat(Fliegereinträge_AM, Fliegereinträge_Aeronautica_Imperialis);
    private static final List<Class<? extends Eintrag>>LordofWar_AM_komplett =LordofWar_AM;

    //ADEPTUS MECHANICUS ///////////////////////////////////////////////////////////////////////////////////////////////////////

    //CULT MECHANICUS
    private static final List<Class<? extends Eintrag>> HQeinträge_Cult_Mechanicus = ImmutableList.of(null,
                    IMBelisariusCawl.class,
                    IMTechPriestDominus.class,
                    IMTechPriestEnginseer.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Cult_Mechanicus = ImmutableList.of(null,
                    IMFulguriteElectroPriests.class,
            IMCorpuscariiElectroPriests.class,
                    IMCyberneticaDatasmith.class);
    private static final List<Class<? extends Eintrag>> Standardeinträge_Cult_Mechanicus = ImmutableList.of(null,
                    IMKataphronBreachers.class,
                    IMKataphronDestroyers.class);
    private static final List<Class<? extends Eintrag>> Unterstützungseinträge_Cult_Mechanicus = ImmutableList.of(null,
                    IMKastelanRobots.class);

    //SKITARII
    private static final List<Class<? extends Eintrag>> Standardeinträge_Skitarii = ImmutableList.of(null,
                    IMSkitariiRangers.class,
                    IMSkitariiVanguard.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Skitarii = ImmutableList.of(null,
                    IMSicarianInfiltrators.class,
                    IMSicarianRuststalkers.class,
            null,
                    IMSecutariiHoplites.class,
                    IMSecutariiPeltasts.class);
    private static final List<Class<? extends Eintrag>> Sturmeinträge_Skitarii = ImmutableList.of(null,
                    IMIronstriderBallistarii.class,
                    IMSydonianDragoons.class);
    private static final List<Class<? extends Eintrag>> Unterstützungseinträge_Skitarii = ImmutableList.of(null,
                    IMOnagerDunecrawler.class);

    //ADEPTUS MECHANICUS Komplett
    private static final List<Class<? extends Eintrag>> HQeinträge_Adeptus_Mechanicus = HQeinträge_Cult_Mechanicus;
    private static final List<Class<? extends Eintrag>> Standardeinträge_Adeptus_Mechanicus = concat(Standardeinträge_Cult_Mechanicus, Standardeinträge_Skitarii);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Adeptus_Mechanicus = concat(concat(
            Eliteeinträge_Cult_Mechanicus, Eliteeinträge_Skitarii), ImmutableList.of(null,
                    IMServitors.class));
    private static final List<Class<? extends Eintrag>> Sturmeinträge_Adeptus_Mechanicus = Sturmeinträge_Skitarii;
    private static final List<Class<? extends Eintrag>> Unterstützungseinträge_Adeptus_Mechanicus = concat(Unterstützungseinträge_Cult_Mechanicus, Unterstützungseinträge_Skitarii);
    private static final List<Class<? extends Eintrag>>Transporteinträge_Adeptus_Mechanicus = ImmutableList.of(null,
                    IMTerraxPatternTermiteAssaultDrill.class);
    
    //Questor Imperialis
    private static final List<Class<? extends Eintrag>>AdditionalInformation_Questor_Imperialis = ImmutableList.of(null,
                    IMHouseholdTradition.class,
                    IMImperialKnightWarlordtraits.class,
                    IMImperialKnightHeirlooms.class);
    private static final List<Class<? extends Eintrag>>LordofWar_Questor_Imperialis = ImmutableList.of(null,
                    IMArmigerHelverin.class,
                    IMArmigerWarglaive.class,
                    IMKnightPreceptor.class,
                    IMKnightPaladin.class,
                    IMKnightErrant.class,
                    IMKnightGallant.class,
                    IMKnightWarden.class,
                    IMKnightCrusader.class,
                    IMCanisRex.class,
                    IMKnightCastellan.class,
                    IMKnightValiant.class);
    private static final List<Class<? extends Eintrag>> Befestigung_Questor_Imperialis = ImmutableList.of(null);

    //Adepta Sororitas
    private static final List<Class<? extends Eintrag>> HQeinträge_Adepta_Sororitas = ImmutableList.of(null,
                    IMCelestine.class,
                    IMUriahJacobus.class,
                    IMCanoness.class,
                    IMMissionary.class);
    private static final List<Class<? extends Eintrag>> Standardeinträge_Adepta_Sororitas = ImmutableList.of(null,
                    IMBattleSistersSquad.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Adepta_Sororitas = ImmutableList.of(null,
                    IMArcoFlagellants.class,
                    IMCelestianSquad.class,
                    IMCrusaders.class,
                    IMDeathCultAssassins.class,
                    IMDialogus.class,
                    IMGeminaeSuperia.class,
                    IMHospitaller.class,
                    IMMistressOfRepentance.class,
                    IMPreacher.class,
                    IMRepentiaSquad.class,
                    IMImagifier.class);        																		
    private static final List<Class<? extends Eintrag>> Sturmeinträge_Adepta_Sororitas = ImmutableList.of(null,
                    IMSeraphimSquad.class,
                    IMDominionSquad.class);
    private static final List<Class<? extends Eintrag>> Unterstützungseinträge_Adepta_Sororitas = ImmutableList.of(null,
                    IMRetributorSquad.class,
                    IMExorcist.class,
                    IMPenitentEngines.class);
    private static final List<Class<? extends Eintrag>>Transporteinträge_Adepta_Sororitas = ImmutableList.of(null,
                    IMSororitasRhino.class,
                    IMImmolator.class);

    //Adeptus Ministorum
    private static final List<Class<? extends Eintrag>> HQeinträge_Adeptus_Ministorum = concat(ImmutableList.of(null, IMUriahJacobus.class), HQeinträge_Adepta_Sororitas);
    private static final List<Class<? extends Eintrag>> Standardeinträge_Adeptus_Ministorum = Standardeinträge_Adepta_Sororitas;
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Adeptus_Ministorum_Only = ImmutableList.of(IMDeathCultAssassins.class, IMArcoFlagellants.class, IMMinistorumPriestAdeptusMinistorum.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Adeptus_Ministorum = concat(concat(Eliteeinträge_Astra_Militarum_Adeptus_Ministorum, Eliteeinträge_Adeptus_Ministorum_Only), Eliteeinträge_Adepta_Sororitas);
    private static final List<Class<? extends Eintrag>> Sturmeinträge_Adeptus_Ministorum = Sturmeinträge_Adepta_Sororitas;
    private static final List<Class<? extends Eintrag>> Unterstützungseinträge_Adeptus_Ministorum = concat(ImmutableList.of(null, IMPenitentEngines.class), Unterstützungseinträge_Adepta_Sororitas);
    private static final List<Class<? extends Eintrag>>Transporteinträge_Adeptus_Ministorum =Transporteinträge_Adepta_Sororitas;

    //SistersofSilence
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Sisters_of_Silence = ImmutableList.of(null,
                    IMProsecutors.class,
                    IMVigilators.class,
                    IMWitchseekers.class);
    private static final List<Class<? extends Eintrag>>Transporteinträge_Sisters_of_Silence = ImmutableList.of(null, IMNullMaidenRhino.class);

    //AdeptusAstraTelepathica -> Gesamtliste
    private static final List<Class<? extends Eintrag>> HQeinträge_Adeptus_Astra_Telepathica = HQeinträge_Scholastica_Psykana;
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Adeptus_Astra_Telepathica = concat(Eliteeinträge_Scholastica_Psykana, Eliteeinträge_Sisters_of_Silence);
    private static final List<Class<? extends Eintrag>>Transporteinträge_Adeptus_Astra_Telepathica =Transporteinträge_Sisters_of_Silence;

    //OfficioAssassinorum
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Officio_Assassinorum = ImmutableList.of(null,
                    IMVindicareAssassin.class,
                    IMCallidusAssassin.class,
                    IMEversorAssassin.class,
                    IMCulexusAssassin.class);

    //Inquisition
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Inquisition= ImmutableList.of(null);

    //<Ordo>
    private static final List<Class<? extends Eintrag>> HQeinträge_Ordo = ImmutableList.of(null);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Ordo = ImmutableList.of(null);

    //Ordo Hereticus
    private static final List<Class<? extends Eintrag>> HQeinträge_Ordo_Hereticus = ImmutableList.of(null);

    //OrdoMalleus
    private static final List<Class<? extends Eintrag>> HQeinträge_Ordo_Malleus = ImmutableList.of(null);

    //AdeptusCustodes
    private static final List<Class<? extends Eintrag>> HQeinträge_Adeptus_Custodes = ImmutableList.of(null,
                    IMCaptainGeneralTrajannValoris.class,
                    IMShieldCaptain.class,
                    IMShieldCaptaininAllarusTerminatorArmour.class,
                    IMShieldCaptainonDawneagleJetbike.class);
    private static final List<Class<? extends Eintrag>> Standardeinträge_Adeptus_Custodes = ImmutableList.of(null,
                    IMCustodianGuard.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Adeptus_Custodes = ImmutableList.of(null,
                    IMCustodianWardens.class,
                    IMVexilusPraetorinAllarusTerminatorArmour.class,
                    IMVexilusPraetor.class,
                    IMAllarusCustodians.class,
                    IMVenerableContemptorDreadnought.class,
                    IMContemptorAchillusDreadnought.class,
                    IMContemptorExemplarDreadnought.class);
    private static final List<Class<? extends Eintrag>> Sturmeinträge_Adeptus_Custodes = ImmutableList.of(null,
                    IMVertusPraetors.class,
                    IMCaladiusGravTank.class);
    private static final List<Class<? extends Eintrag>> Unterstützungseinträge_Adeptus_Custodes = ImmutableList.of(null,
                    IMVenerableLandRaider.class,
                    IMCoronusGravCarrier.class,
                    IMTelemonHeavyDreadnought.class);

    private static final List<Class<? extends Eintrag>> Befestigungen = ImmutableList.of(null);

    private static final List<Class<? extends Eintrag>> HQeinträge_SM = ImmutableList.of(null,
                    IMCaptain.class,
                    IMCaptaininTerminatorArmour.class,
                    IMCaptaininCataphractiiArmour.class,
                    IMCaptaininGravisArmour.class,
                    IMCaptainonBike.class,
                    IMLibrarian.class,
                    IMLibrarianinTerminatorArmour.class,
                    IMLibrarianonBike.class,
                    IMTechmarine.class,
                    IMTechmarineonBike.class,
                    IMChaplain.class,
                    IMChaplaininTerminatorArmour.class,
                    IMMaster.class,
                    IMMasterinTerminatorArmour.class,
                    IMMasterinCataphractiiArmour.class,
                    IMMasterinGravisArmour.class,
                    IMChaplainonBike.class,
                    IMLieutenants.class,
            null,
                    IMPrimarisChaplain.class,
                    IMPrimarisLibrarian.class,
                    IMPrimarisLieutenants.class,
                    IMPrimarisMaster.class,
                    IMPrimarisCaptain.class,
                    IMRhinoPrimaris.class,
                    IMLandRaiderExcelsior.class);
    private static final List<Class<? extends Eintrag>> Standardeinträge_SM = ImmutableList.of(null,
                    IMTacticalSquad.class,
                    IMScoutSquad.class,
                    IMIntercessorSquad.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_SM = ImmutableList.of(null,
                    IMServitors.class,
                    IMApothecary.class,
                    IMApothecaryonBike.class,
                    IMPrimarisApothecary.class,
                    IMCompanyAncient.class,
                    IMCompanyAncientonBike.class,
                    IMPrimarisAncient.class,
                    IMCompanyChampion.class,
                    IMCompanyChampiononBike.class,
                    IMCompanyVeterans.class,
                    IMCompanyVeteransonBikes.class,
                    IMImperialSpaceMarine.class,
                    IMHonourGuard.class,
                    IMChapterAncient.class,
                    IMChapterChampion.class,
                    IMCenturionAssaultSquad.class,
                    IMSternguardVeteranSquad.class,
                    IMVanguardVeteranSquad.class,
                    IMDreadnought.class,
                    IMVenerableDreadnought.class,
                    IMContemptorDreadnought.class,
                    IMRedemptorDreadnought.class,
                    IMIroncladDreadnought.class,
                    IMTerminatorSquad.class,
                    IMTerminatorAssaultSquad.class,
                    IMCataphractiiTerminatorSquad.class,
                    IMTartarosTerminatorSquad.class,
                    IMAggressorSquad.class,
                    IMReiverSquad.class);
    private static final List<Class<? extends Eintrag>> Sturmeinträge_SM = ImmutableList.of(null,
                    IMAssaultSquad.class,
                    IMInceptorSquad.class,
                    IMScoutBikeSquad.class,
                    IMBikeSquad.class,
                    IMAttackBikeSquad.class,
                    IMLandSpeeders.class);
    private static final List<Class<? extends Eintrag>> Unterstützungeinträge_SM = ImmutableList.of(null,
                    IMDevastatorSquad.class,
                    IMCenturionDevastatorSquad.class,
                    IMHellblasterSquad.class,
                    IMThunderfireCannon.class,
                    IMPredator.class,
                    IMWhirlwind.class,
                    IMVindicator.class,
                    IMHunter.class,
                    IMStalker.class,
                    IMLandRaider.class,
                    IMLandRaiderCrusader.class,
                    IMLandRaiderRedeemer.class);
    private static final List<Class<? extends Eintrag>>Transporteinträge_SM = ImmutableList.of(null,
                    IMRhino.class,
                    IMRazorback.class,
                    IMDropPod.class,
                    IMLandSpeederStorm.class,
                    IMRepulsor.class,
                    IMTerraxPatternTermiteAssaultDrill.class);
    private static final List<Class<? extends Eintrag>> Fliegereinträge_SM = ImmutableList.of(null,
                    IMStormhawkInterceptor.class,
                    IMStormtalonGunship.class,
                    IMStormravenGunship.class);
    private static final List<Class<? extends Eintrag>>LordOfWar_SM = ImmutableList.of(null,
                    IMAstraeusSuperHeavyTank.class);

    //Ultramarines
    private static final List<Class<? extends Eintrag>> HQeinträge_Ultramarines = ImmutableList.of(null,
                    IMMarneusCalgar.class,
                    IMMarneusCalgarinArtificerArmour.class,
                    IMCaptainSicarius.class,
                    IMChiefLibrarianTigurius.class,
                    IMChaplainCassius.class,
                    IMSergeantTelion.class,
                    IMSergeantChronus.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Ultramarines = ImmutableList.of(null,
                    IMTyrannicWarVeterans.class);
    private static final List<Class<? extends Eintrag>>LordofWar_Ultramarines = ImmutableList.of(null,
                    IMRobouteGuilliman.class,
                    IMTerminusUltra.class);

    //Imperial Fists
    private static final List<Class<? extends Eintrag>> HQeinträge_Imperial_Fists = ImmutableList.of(null,
                    IMCaptainLysander.class);

    //CrimsonFists
    private static final List<Class<? extends Eintrag>> HQeinträge_Crimson_Fists = ImmutableList.of(null,
                    IMPedroKantor.class);

    //BlackTemplars
    private static final List<Class<? extends Eintrag>> HQeinträge_Black_Templars = ImmutableList.of(null,
                    IMHighMarshalHelbrecht.class,
                    IMTheEmperorsChampion.class,
                    IMChaplainGrimaldus.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Black_Templars = ImmutableList.of(null,
                    IMCenobyteServitors.class);
    private static final List<Class<? extends Eintrag>> Standardeinträge_Black_Templars = ImmutableList.of(null,
                    IMCrusaderSquad.class);

    //Raven Guard
    private static final List<Class<? extends Eintrag>> HQeinträge_Raven_Guard = ImmutableList.of(null, IMKayvaanShrike.class);

    //Salamanders
    private static final List<Class<? extends Eintrag>> HQeinträge_Salamanders = ImmutableList.of(null, IMVulkanHestan.class);

    //White Scars
    private static final List<Class<? extends Eintrag>> HQeinträge_White_Scars = ImmutableList.of(null, IMKorsarroKhan.class, IMKorsarroKhanonMoondrakkan.class);

    //LegionoftheDamned
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Legion_of_the_Damned = ImmutableList.of(null, IMDamnedLegionnaires.class);

    //BloodAngels
    private static final List<Class<? extends Eintrag>> HQeinträge_Blood_Angels = ImmutableList.of(null,
                    IMCommanderDante.class,
                    IMGabrielSeth.class,
                    IMCaptainTycho.class,
                    IMTychotheLost.class,
                    IMLibrarianDreadnought.class,
                    IMChiefLibrarianMephiston.class,
                    IMTheSanguinor.class,
                    IMAstorath.class,
                    IMSanguinaryPriest.class,
                    IMSanguinaryPriestonBike.class,
                    IMBrotherCorbulo.class,
                    IMLemartes.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Blood_Angels = ImmutableList.of(null,
                    IMSanguinaryGuardAncient.class,
                    IMTerminatorAncient.class,
                    IMDeathCompany.class,
                    IMSanguinaryGuard.class,
                    IMDeathCompanyDreadnought.class,
                    IMFuriosoDreadnought.class);
    private static final List<Class<? extends Eintrag>> Unterstützungseinträge_Blood_Angels = ImmutableList.of(null,
                    IMBaalPredator.class);

    private static final List<Class<? extends Eintrag>> Sturmeinträge_Blood_Angels = ImmutableList.of(null,
                    IMAssaultSquadBA.class,
                    IMInceptorSquad.class,
                    IMScoutBikeSquad.class,
                    IMBikeSquad.class,
                    IMAttackBikeSquad.class,
                    IMLandSpeeders.class);

    //DarkAngels
    private static final List<Class<? extends Eintrag>> HQeinträge_Dark_Angels = ImmutableList.of(null,
                    IMAzrael.class,
                    IMBelial.class,
                    IMSammaelonCorvex.class,
                    IMSammaelinSableclaw.class,
                    IMInterrogatorChaplain.class,
                    IMRavenwingTalonmaster.class,
                    IMInterrogatorChaplaininTerminatorArmour.class,
                    IMInterrogatorChaplainonBike.class,
                    IMAsmodai.class,
                    IMEzekiel.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Dark_Angels = ImmutableList.of(null,
                    IMDeathwingApothecary.class,
                    IMDeathwingAncient.class,
                    IMDeathwingChampion.class,
                    IMDeathwingTerminatorSquad.class,
                    IMDeathwingCataphractiiTerminatorSquad.class,
                    IMDeathwingTartarosTerminatorSquad.class,
                    IMDeathwingKnights.class,
                    IMRavenwingApothecary.class,
                    IMRavenwingAncient.class,
                    IMRavenwingChampion.class);
    private static final List<Class<? extends Eintrag>> Sturmeinträge_Dark_Angels = ImmutableList.of(null,
                    IMRavenwingBikeSquad.class,
                    IMRavenwingAttackBikeSquad.class,
                    IMRavenwingLandSpeeders.class,
                    IMRavenwingDarkshroud.class,
                    IMRavenwingBlackKnights.class,
                    IMRavenwingLandSpeederVengeance.class);
    private static final List<Class<? extends Eintrag>> Fliegereinträge_Dark_Angels = ImmutableList.of(null,
                    IMNephilimJetfighter.class,
                    IMRavenwingDarkTalon.class,
                    IMStormravenGunship.class);
    private static final List<Class<? extends Eintrag>> Befestigungen_Dark_Angels = ImmutableList.of(null);

    //Space Wolves
    private static final List<Class<? extends Eintrag>> HQeinträge_Space_Wolves = ImmutableList.of(null,
                    IMLoganGrimnar.class,
                    IMLoganGrimnaronStormrider.class,
                    IMArjacRockfist.class,
                    IMBjorntheFellHanded.class,
                    IMNjalStormcaller.class,
                    IMNjalStormcallerinRunicTerminatorArmour.class,
    		null,
                    IMRunePriestinTerminatorArmour.class,
                    IMPrimarisRunePriest.class,
                    IMRunePriest.class,
    		null,
                    IMUlriktheSlayer.class,
                    IMWolfPriestinTerminatorArmour.class,
                    IMPrimarisWolfPriest.class,
                    IMWolfPriest.class,
    		null,
                    IMRagnarBlackmane.class,
                    IMKromDragongaze.class,
                    IMHaraldDeathwolf.class,
                    IMWolfLord.class,
                    IMWolfLordonThunderwolf.class,
                    IMWolfLordinTerminatorArmour.class,
                    IMWolfLordinCataphractiiArmour.class,
                    IMPrimarisWolfLord.class,
                    IMWolfLordinGravisArmour.class,
    		null,
                    IMCanisWolfborn.class,
                    IMWolfGuardBattleLeader.class,
                    IMPrimarisBattleLeader.class,
                    IMWolfGuardBattleLeaderinTerminatorArmour.class,
                    IMWolfGuardBattleLeaderonThunderwolf.class,
            null,
                    IMIronPriest.class,
            null,
                    IMRunePriestonBike.class,
                    IMWolfPriestonBike.class,
                    IMWolfLordonBike.class,
                    IMWolfGuardBattleLeaderonBike.class,
                    IMIronPriestonBike.class,
                    IMIronPriestonThunderwolf.class);
    private static final List<Class<? extends Eintrag>> Standardeinträge_Space_Wolves = ImmutableList.of(null,
                    IMBloodClaws.class,
                    IMGreyHunters.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Space_Wolves = ImmutableList.of(null,
                    IMWolfScouts.class,
                    IMLukastheTrickster.class,
                    IMWulfenDreadnought.class,
                    IMWolfGuard.class,
                    IMWolfGuardTerminators.class,
                    IMWolfGuardCataphractiiTerminators.class,
                    IMWolfGuardTartarosTerminators.class,
                    IMWulfen.class,
                    IMMurderfang.class,
            null,
                    IMSWVenerableDreadnought.class,
                    IMWolfGuardonBikes.class,
                    IMLoneWolf.class,
                    IMLoneWolfinTerminatorArmour.class);
    private static final List<Class<? extends Eintrag>> Sturmeinträge_Space_Wolves = ImmutableList.of(null,
                    IMCyberwolves.class,
                    IMSwiftclaws.class,
                    IMSwiftclawAttackBikes.class,
                    IMThunderwolfCavalry.class,
                    IMFenrisianWolves.class,
                    IMSkyclaws.class,
                    IMWolfScoutBikers.class);
    private static final List<Class<? extends Eintrag>> Fliegereinträge_Space_Wolves = ImmutableList.of(null,
                    IMStormwolf.class,
                    IMStormfangGunship.class,
                    IMStormhawkInterceptor.class);
    private static final List<Class<? extends Eintrag>> Unterstützungseinträge_Space_Wolves = ImmutableList.of(null,
                    IMLongFangs.class);

    //Deathwatch
    private static final List<Class<? extends Eintrag>> HQeinträge_Deathwatch = ImmutableList.of(null,
                    IMWatchMaster.class,
                    IMWatchCaptainArtemis.class,
                    IMWatchCaptain.class,
                    IMWatchCaptaininTerminatorArmour.class,
                    IMPrimarisWatchCaptain.class,
                    IMDeathwatchLibrarian.class,
                    IMDeathwatchLibrarianinTerminatorArmour.class,
                    IMDeathwatchPrimarisLibrarian.class,
                    IMDeathwatchChaplain.class,
                    IMDeathwatchChaplaininTerminatorArmour.class,
                    IMDeathwatchPrimarisChaplain.class);
    private static final List<Class<? extends Eintrag>> Standardeinträge_Deathwatch = ImmutableList.of(null,
                    IMDeathwatchVeterans.class,
                    IMDeathwatchIntercessors.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Deathwatch = ImmutableList.of(null,
                    IMDeathwatchPrimarisApothecary.class,
                    IMVenerableDreadnought.class,
                    IMDreadnought.class,
                    IMRedemptorDreadnought.class,
                    IMDeathwatchTerminatorSquad.class,
                    IMDeathwatchReiverSquad.class,
                    IMAggressorSquad.class,
                    IMDeathwatchVanguardVeterans.class);
    private static final List<Class<? extends Eintrag>> Sturmeinträge_Deathwatch = ImmutableList.of(null,
                    IMDeathwatchBikers.class,
                    IMInceptorSquad.class);
    private static final List<Class<? extends Eintrag>> Unterstützungseinträge_Deathwatch = ImmutableList.of(null,
                    IMHellblasterSquad.class,
                    IMLandRaider.class,
                    IMLandRaiderCrusader.class,
                    IMLandRaiderRedeemer.class);
    private static final List<Class<? extends Eintrag>>Transporteinträge_Deathwatch = ImmutableList.of(null,
                    IMRazorback.class,
                    IMRhino.class,
                    IMDropPod.class,
                    IMRepulsor.class);
    private static final List<Class<? extends Eintrag>> Fliegereinträge_Deathwatch = ImmutableList.of(null,
                    IMCorvusBlackstar.class);

    //Grey Knights
    private static final List<Class<? extends Eintrag>> HQeinträge_Grey_Knights = ImmutableList.of(null,
                    IMLordKaldorDraigo.class,
                    IMGrandMasterVoldus.class,
                    IMGrandMaster.class,
                    IMGrandMasterinNemesisDreadknight.class,
                    IMCastellanCrowe.class,
                    IMBrotherCaptainStern.class,
                    IMBrotherCaptain.class,
                    IMLibrarianGK.class,
                    IMTechmarineGK.class,
                    IMChaplainGK.class,
                    IMBrotherhoodChampion.class);
    private static final List<Class<? extends Eintrag>> Standardeinträge_Grey_Knights = ImmutableList.of(null,
                    IMGreyKnightTerminatorSquad.class,
                    IMStrikeSquad.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Grey_Knights = ImmutableList.of(null,
                    IMBrotherhoodAncient.class,
                    IMPurifierSquad.class,
                    IMPaladinSquad.class,
                    IMPaladinAncient.class,
                    IMGreyKnightApothecary.class,
                    IMDreadnoughtGK.class,
                    IMVenerableDreadnoughtGK.class,
                    IMServitors.class);
    private static final List<Class<? extends Eintrag>> Sturmeinträge_Grey_Knights = ImmutableList.of(null,
                    IMInterceptorSquad.class);
    private static final List<Class<? extends Eintrag>> Unterstützungseinträge_Grey_Knights = ImmutableList.of(null,
                    IMPurgationSquad.class,
                    IMNemesisDreadknight.class,
                    IMLandRaider.class,
                    IMLandRaiderCrusader.class,
                    IMLandRaiderRedeemer.class);
    private static final List<Class<? extends Eintrag>>Transporteinträge_Grey_Knights = ImmutableList.of(null,
                    IMRazorback.class,
                    IMRhino.class);
    private static final List<Class<? extends Eintrag>> Fliegereinträge_Grey_Knights = ImmutableList.of(null,
                    IMStormhawkInterceptor.class,
                    IMStormravenGunship.class,
                    IMStormtalonGunship.class);

    //ImperialArmourAdeptusAstartes
    private static final List<Class<? extends Eintrag>> HQeinträge_IA_AA = ImmutableList.of(null,
                    IMChaplainVenerableDreadnought.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_IA_AA = ImmutableList.of(null,
                    IMDeimosPatternRelicPredator.class,
                    IMRelicSicaranBattleTank.class,
                    IMRelicSicaranVenatorTankDestroyer.class,
                    IMRelicSicaranPunisherAssaultTank.class,
                    IMRelicSicaranArcusStrikeTank.class,
                    IMRelicSicaranOmegaTankDestroyer.class,
                    IMRelicContemptorDreadnought.class,
                    IMRelicDeredeoDreadnought.class,
                    IMRelicJavelinAttackSpeeder.class);
    private static final List<Class<? extends Eintrag>> Sturmeinträge_IA_AA = ImmutableList.of(null,
                    IMLandSpeederTempest.class,
                    IMTarantulaSentryGun.class,
                    IMTarantulaAirDefenceBattery.class,
                    IMDeathstormDropPod.class);
    private static final List<Class<? extends Eintrag>> Unterstützungseinträge_IA_AA = ImmutableList.of(null,
                    IMDeimosPatternVindicatorLaserDestroyer.class,
                    IMRelicLandRaiderProteus.class,
                    IMLandRaiderHelios.class,
                    IMLandRaiderPrometheus.class,
                    IMLandRaiderAchilles.class,
                    IMMortisDreadnought.class,
                    IMSiegeDreadnought.class,
                    IMContemptorMortisDreadnought.class,
                    IMRelicLeviathanDreadnought.class,
                    IMRapierCarrier.class);
    private static final List<Class<? extends Eintrag>>Transporteinträge_IA_AA = ImmutableList.of(null,
                    IMInfernumPatternRazorback.class,
                    IMLuciusPatternDreadnoughtDropPod.class);
    private static final List<Class<? extends Eintrag>> Fliegereinträge_IA_AA = ImmutableList.of(null,
                    IMXiphonInterceptor.class,
                    IMStormEagleAssaultGunship.class,
                    IMFireRaptorAssaultGunship.class,
                    IMCaestusAssaultRam.class);
    private static final List<Class<? extends Eintrag>>LordofWar_IA_AA = ImmutableList.of(null,
                    IMRelicSpartanAssaultTank.class,
                    IMRelicTyphonHeavySiegeTank.class,
                    IMRelicCerberusHeavyTankDestroyer.class,
                    IMRelicFellbladeSuperheavyTank.class,
                    IMRelicFalchionSuperheavyTankDestroyer.class,
                    IMRelicMastodonSuperheavySiegeTransport.class);

    private static final List<Class<? extends Eintrag>> Fliegereinträge_IA_Minotaurs = ImmutableList.of(null, IMStormEagleAssaultGunshipROCPattern.class);

    //AdeptusAstartes
    private static final List<Class<? extends Eintrag>> HQeinträge_AA_komplett = concat(HQeinträge_SM, HQeinträge_Ultramarines, HQeinträge_Imperial_Fists,
            HQeinträge_Crimson_Fists, HQeinträge_Black_Templars, HQeinträge_Raven_Guard, HQeinträge_Salamanders,
            HQeinträge_White_Scars, HQeinträge_Blood_Angels, HQeinträge_Dark_Angels, HQeinträge_Space_Wolves,
            HQeinträge_Deathwatch, HQeinträge_Grey_Knights, HQeinträge_IA_AA);
    private static final List<Class<? extends Eintrag>> Standardeinträge_AA_komplett = concat(Standardeinträge_SM, Standardeinträge_Black_Templars,
            Standardeinträge_Space_Wolves, Standardeinträge_Deathwatch, Standardeinträge_Grey_Knights);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_AA_komplett = concat(Eliteeinträge_SM, Eliteeinträge_Ultramarines, Eliteeinträge_Black_Templars,
            Eliteeinträge_Legion_of_the_Damned, Eliteeinträge_Blood_Angels, Eliteeinträge_Dark_Angels, Eliteeinträge_Space_Wolves,
            Eliteeinträge_Deathwatch, Eliteeinträge_Grey_Knights, Eliteeinträge_IA_AA);
    private static final List<Class<? extends Eintrag>> Sturmeinträge_AA_komplett = concat(Sturmeinträge_SM, Sturmeinträge_Blood_Angels, Sturmeinträge_Dark_Angels, Sturmeinträge_Space_Wolves,
            Sturmeinträge_Deathwatch, Sturmeinträge_Grey_Knights, Sturmeinträge_IA_AA);
    private static final List<Class<? extends Eintrag>> Unterstützungeinträge_AA_komplett = concat(Unterstützungeinträge_SM, Unterstützungseinträge_Blood_Angels,
            Unterstützungseinträge_Space_Wolves, Unterstützungseinträge_Deathwatch, Unterstützungseinträge_Grey_Knights, Unterstützungseinträge_IA_AA);
    private static final List<Class<? extends Eintrag>>Transporteinträge_AA_komplett = concat(Transporteinträge_SM,Transporteinträge_IA_AA);
    private static final List<Class<? extends Eintrag>> Fliegereinträge_AA_komplett = concat(Fliegereinträge_SM, Fliegereinträge_Dark_Angels,
            Fliegereinträge_Space_Wolves, Fliegereinträge_Deathwatch, Fliegereinträge_IA_AA, Fliegereinträge_IA_Minotaurs);
    private static final List<Class<? extends Eintrag>>LordofWar_AA_komplett = concat(LordOfWar_SM,LordofWar_Ultramarines,LordofWar_IA_AA);

  //Subfactions
    private static final Set<String> FORGEWORLDS = ImmutableSet.of("Forge WorldMars", "Forge World Graia", "Forge World Metalica", "Forge World Lucius", "Forge WorldAgripinaa", "Forge World Stygies VIII", "Forge WorldRyza");
    private static final Set<String> SM_CHAPTERS = ImmutableSet.of("Ultramarines", "White Scars", "Imperial Fists", "CrimsonFists", "BlackTemplars", "Salamanders", "Raven Guard", "IronHands");
    private static final Set<String>ASTRA_MILITARUM = ImmutableSet.of("Cadian", "Catachan", "Valhallan", "Vostroyan", "Armageddon", "Tallarn", "MilitarumTempestus", "Mordian");
    private static final Set<String>AS_ORDERS = ImmutableSet.of("OrderoftheValorous Heart", "OrderofOurMartyred Lady", "OrderoftheEbonChalice", "OrderoftheArgent Shroud", "OrderoftheBloodyRose", "OrderoftheSacredRose");

    public static Set<String> getSmChapters(){
    	return SM_CHAPTERS;
    }
    
    public VOLKImperium() {
        super("IM",ResourceUtils.loadPoints(
                Stream.of("sm", "ba", "da", "sw", "dw", "gk", "am", "ame", "qi", "ami", "oa", "ac", "iaaa")
                   .map(name -> String.format("/oc/wh40k/indices/%s.yaml", name))));

        //Formationen
        formationen.add("IMPERIUM");
        formationen.add(null);
        formationen.add("Adepta Sororitas");
        formationen.addAll(AS_ORDERS);
        formationen.add(null);
        formationen.add("AdeptusCustodes");
        formationen.add(null);
        formationen.add("AdeptusAstartes");
        formationen.addAll(SM_CHAPTERS);
        formationen.add(null);
        formationen.add("BloodAngels");
        formationen.add("DarkAngels");
        formationen.add("Deathwatch");
        formationen.add("Grey Knights");
        formationen.add("LegionoftheDamned");
        formationen.add("Space Wolves");
        formationen.add(null);
        formationen.add("AstralClaws");
        formationen.add("BloodRavens");
        formationen.add("Carcharodons");
        formationen.add("Executioners");
        formationen.add("Exorcists");
        formationen.add("FireAngels");
        formationen.add("Fire Hawks");
        formationen.add("Howling Griffons");
        formationen.add("Lamenters");
        formationen.add("Mantis Warriors");
        formationen.add("Marines Errant");
        formationen.add("Minotaurs");
        formationen.add("Novamarines");
        formationen.add("Raptors");
        formationen.add("Red Scorpions");
        formationen.add("SonsofMedusa");
        formationen.add("StarPhantoms");
        formationen.add("TigerClaws");
        formationen.add(null);
        formationen.add("ASTRA MILITARUM.");
        formationen.addAll(ASTRA_MILITARUM);
        formationen.add("OfficioPrefectus");
        formationen.add("MilitarumAuxilia");
        formationen.add("Aeronautica Imperialis");
        formationen.add("ScholasticaPsykana");
        formationen.add(null);
        formationen.add("Adeptus Mechanicus");
        formationen.addAll(FORGEWORLDS);
        formationen.add("Cult Mechanicus");
        formationen.add("Skitarii");
        formationen.add(null);
        formationen.add("Questor Imperialis");
        formationen.add(null);
        formationen.add("Adeptus Ministorum");
        formationen.add("OfficioAssassinorum");
        formationen.add("AdeptusAstraTelepathica");
        formationen.add("ScholasticaPsykana");
        formationen.add("SistersofSilence");

        complete();
    }


    @Override
    public void volkRefresh() {

        if (getFormationType().equals("IMPERIUM")) {
            clearCombo();

            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_AA_komplett,
                    HQeinträge_AM_komplett,
                    HQeinträge_Adeptus_Mechanicus,
                    HQeinträge_Adeptus_Ministorum,
                    HQeinträge_Adeptus_Astra_Telepathica,
                    HQeinträge_Adeptus_Custodes));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(concat(Standardeinträge_AA_komplett,
                    Standardeinträge_AM_komplett,
                    Standardeinträge_Adeptus_Mechanicus,
                    Standardeinträge_Adeptus_Ministorum,
                    Standardeinträge_Adeptus_Custodes));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_AA_komplett,
                    Eliteeinträge_AM_komplett,
                    Eliteeinträge_Adeptus_Mechanicus,
                    Eliteeinträge_Adeptus_Ministorum,
                    Eliteeinträge_Officio_Assassinorum,
                    Eliteeinträge_Adeptus_Astra_Telepathica,
                    Eliteeinträge_Adeptus_Custodes));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_AA_komplett,
                    Sturmeinträge_AM_komplett,
                    Sturmeinträge_Adeptus_Mechanicus,
                    Sturmeinträge_Adeptus_Ministorum,
                    Sturmeinträge_Adeptus_Custodes));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungeinträge_AA_komplett,
                    Unterstützungeinträge_AM_komplett,
                    Unterstützungseinträge_Adeptus_Mechanicus,
                    Unterstützungseinträge_Adeptus_Ministorum,
                    Unterstützungseinträge_Adeptus_Custodes));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(Transporteinträge_AA_komplett,
                   Transporteinträge_AM_komplett,
                   Transporteinträge_Adeptus_Mechanicus,
                   Transporteinträge_Adeptus_Ministorum,
                   Transporteinträge_Adeptus_Astra_Telepathica));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_AA_komplett,
                    Fliegereinträge_AM_komplett));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(concat(Befestigungen, Befestigung_Questor_Imperialis));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(LordofWar_AA_komplett,
                   LordofWar_AM_komplett,
                   LordofWar_Questor_Imperialis));
        } else if (getFormationType().equals("AdeptusAstartes")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_AA_komplett);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_AA_komplett);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_AA_komplett);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_AA_komplett);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungeinträge_AA_komplett);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_AA_komplett);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(Fliegereinträge_AA_komplett);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_AA_komplett);
        } else if (getFormationType().equals("Ultramarines")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_SM, HQeinträge_Ultramarines, HQeinträge_IA_AA));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_SM, Eliteeinträge_Ultramarines, Eliteeinträge_IA_AA));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_SM, Sturmeinträge_IA_AA));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungeinträge_SM, Unterstützungseinträge_IA_AA));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(Transporteinträge_SM,Transporteinträge_IA_AA));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_SM, Fliegereinträge_IA_AA));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(LordOfWar_SM,LordofWar_Ultramarines,LordofWar_IA_AA));
        } else if (getFormationType().equals("Imperial Fists")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_SM, HQeinträge_Imperial_Fists, HQeinträge_IA_AA));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_SM, Eliteeinträge_IA_AA));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_SM, Sturmeinträge_IA_AA));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungeinträge_SM, Unterstützungseinträge_IA_AA));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(Transporteinträge_SM,Transporteinträge_IA_AA));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_SM, Fliegereinträge_IA_AA));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(LordOfWar_SM,LordofWar_IA_AA));
        } else if (getFormationType().equals("CrimsonFists")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_SM, HQeinträge_Crimson_Fists, HQeinträge_IA_AA));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_SM, Eliteeinträge_IA_AA));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_SM, Sturmeinträge_IA_AA));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungeinträge_SM, Unterstützungseinträge_IA_AA));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(Transporteinträge_SM,Transporteinträge_IA_AA));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_SM, Fliegereinträge_IA_AA));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(LordOfWar_SM,LordofWar_IA_AA));
        } else if (getFormationType().equals("BlackTemplars")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_SM, HQeinträge_Black_Templars, HQeinträge_IA_AA));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(concat(Standardeinträge_SM, Standardeinträge_Black_Templars));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_SM, Eliteeinträge_Black_Templars, Eliteeinträge_IA_AA));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_SM, Sturmeinträge_IA_AA));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungeinträge_SM, Unterstützungseinträge_IA_AA));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(Transporteinträge_SM,Transporteinträge_IA_AA));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_SM, Fliegereinträge_IA_AA));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(LordOfWar_SM,LordofWar_IA_AA));
        } else if (getFormationType().equals("Raven Guard")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_SM, HQeinträge_Raven_Guard, HQeinträge_IA_AA));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_SM, Eliteeinträge_IA_AA));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_SM, Sturmeinträge_IA_AA));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungeinträge_SM, Unterstützungseinträge_IA_AA));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(Transporteinträge_SM,Transporteinträge_IA_AA));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_SM, Fliegereinträge_IA_AA));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(LordOfWar_SM,LordofWar_IA_AA));
        } else if (getFormationType().equals("Salamanders")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_SM, HQeinträge_Salamanders, HQeinträge_IA_AA));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_SM, Eliteeinträge_IA_AA));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_SM, Sturmeinträge_IA_AA));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungeinträge_SM, Unterstützungseinträge_IA_AA));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(Transporteinträge_SM,Transporteinträge_IA_AA));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_SM, Fliegereinträge_IA_AA));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(LordOfWar_SM,LordofWar_IA_AA));
        } else if (getFormationType().equals("White Scars")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_SM, HQeinträge_White_Scars, HQeinträge_IA_AA));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_SM, Eliteeinträge_IA_AA));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_SM, Sturmeinträge_IA_AA));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungeinträge_SM, Unterstützungseinträge_IA_AA));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(Transporteinträge_SM,Transporteinträge_IA_AA));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_SM, Fliegereinträge_IA_AA));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(LordOfWar_SM,LordofWar_IA_AA));
        } else if (getFormationType().equals("LegionoftheDamned")) {
            clearCombo();
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Legion_of_the_Damned);
        } else if (getFormationType().equals("BloodAngels")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_Blood_Angels,
                    ImmutableList.of(null,
                    IMCaptain.class,
                    IMCaptaininTerminatorArmour.class,
                    IMCaptaininGravisArmour.class,
                    IMLibrarian.class,
                    IMPrimarisLibrarian.class,
                    IMLibrarianinTerminatorArmour.class,
                    IMLibrarianonBike.class,
                    IMTechmarine.class,
                    IMTechmarinewithJumpPack.class,
                    IMTechmarineonBike.class,
                    IMChaplain.class,
                    IMChaplaininTerminatorArmour.class,
                    IMChaplainonBike.class,
                    IMPrimarisChaplain.class,
                    IMMaster.class,
                    IMMasterinTerminatorArmour.class,
                    IMMasterinCataphractiiArmour.class,
                    IMMasterinGravisArmour.class,
                    IMPrimarisMaster.class,
                    IMLieutenants.class,
                    IMTechmarine.class,
                    IMPrimarisLieutenants.class,
                    IMRhinoPrimaris.class,
                    IMLandRaiderExcelsior.class), HQeinträge_IA_AA));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_Blood_Angels,
                    ImmutableList.of(null,
                    IMServitors.class,
                    IMSanguinaryNovitiate.class,
                    IMCompanyAncient.class,
                    IMCompanyAncientwithJumpPack.class,
                    IMPrimarisAncient.class,
                    IMCompanyChampion.class,
                    IMCompanyChampionwithJumpPack.class,
                    IMCompanyVeterans.class,
                    IMCompanyVeteranswithJumpPacks.class,
                    IMImperialSpaceMarine.class,
                    IMSternguardVeteranSquad.class,
                    IMVanguardVeteranSquad.class,
                    IMDreadnought.class,
                    IMTerminatorSquad.class,
                    IMTerminatorAssaultSquad.class,
                            null,
                    IMPrimarisApothecary.class,
                    IMApothecary.class,
                    IMCompanyAncient.class,
                    IMChapterAncient.class,
                    IMImperialSpaceMarine.class,
                    IMDreadnought.class,
                    IMVenerableDreadnought.class,
                    IMContemptorDreadnought.class,
                    IMRedemptorDreadnought.class,
                    IMAggressorSquad.class,
                    IMReiverSquad.class), Eliteeinträge_IA_AA));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_Blood_Angels,
                    ImmutableList.of(null, IMInceptorSquad.class), Sturmeinträge_IA_AA));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungseinträge_Blood_Angels,
                    ImmutableList.of(null,
                    IMDevastatorSquad.class,
                    IMHellblasterSquad.class,
                    IMPredator.class,
                    IMHunter.class,
                    IMStalker.class,
                    IMWhirlwind.class,
                    IMVindicator.class,
                    IMLandRaider.class,
                    IMLandRaiderCrusader.class,
                    IMLandRaiderRedeemer.class), Unterstützungseinträge_IA_AA));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(ImmutableList.of(null,
                    IMRhino.class,
                    IMRazorback.class,
                    IMDropPod.class,
                    IMLandSpeederStorm.class,
                    IMRepulsor.class),Transporteinträge_IA_AA));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_SM, Fliegereinträge_IA_AA));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_IA_AA);
        } else if (getFormationType().equals("DarkAngels")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_Dark_Angels,
                    ImmutableList.of(null,
                    IMCaptain.class,
                    IMCaptaininTerminatorArmour.class,
                    IMCaptaininGravisArmour.class,
                    IMLibrarian.class,
                    IMPrimarisLibrarian.class,
                    IMLibrarianinTerminatorArmour.class,
                    IMLibrarianonBike.class,
                    IMTechmarine.class,
                    IMTechmarineonBike.class,
                    IMChaplain.class,
                    IMChaplainonBike.class,
                    IMPrimarisChaplain.class,
                    IMMaster.class,
                    IMMasterinTerminatorArmour.class,
                    IMMasterinCataphractiiArmour.class,
                    IMMasterinGravisArmour.class,
                    IMPrimarisMaster.class,
                    IMLieutenants.class,
                    IMTechmarine.class,
                    IMPrimarisLieutenants.class,
                    IMRhinoPrimaris.class,
                    IMLandRaiderExcelsior.class), HQeinträge_IA_AA));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_SM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_Dark_Angels, ImmutableList.of(null,
                    IMPrimarisApothecary.class,
                    IMApothecary.class,
                    IMCompanyAncient.class,
                    IMPrimarisAncient.class,
                    IMCompanyChampion.class,
                    IMCompanyVeterans.class,
                    IMChapterAncient.class,
                    IMImperialSpaceMarine.class,
                    IMDreadnought.class,
                    IMVenerableDreadnought.class,
                    IMContemptorDreadnought.class,
                    IMRedemptorDreadnought.class,
                    IMAggressorSquad.class,
                    IMServitors.class,
                    IMReiverSquad.class), Eliteeinträge_IA_AA));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_Dark_Angels, ImmutableList.of(null,
                    IMScoutBikeSquad.class,
                    IMAssaultSquad.class,
                    IMInceptorSquad.class), Sturmeinträge_IA_AA));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(ImmutableList.of(null,
                    IMDevastatorSquad.class,
                    IMHellblasterSquad.class,
                    IMPredator.class,
                    IMHunter.class,
                    IMStalker.class,
                    IMWhirlwind.class,
                    IMVindicator.class,
                    IMLandRaider.class,
                    IMLandRaiderCrusader.class,
                    IMLandRaiderRedeemer.class), Unterstützungseinträge_IA_AA));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(ImmutableList.of(null,
                    IMRhino.class,
                    IMRazorback.class,
                    IMDropPod.class,
                    IMLandSpeederStorm.class,
                    IMRepulsor.class),Transporteinträge_IA_AA));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_Dark_Angels, Fliegereinträge_IA_AA));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen_Dark_Angels);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_IA_AA);
        } else if (getFormationType().equals("Space Wolves")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_Space_Wolves, ImmutableList.of(null,
                    IMPrimarisLieutenants.class,
                    IMRhinoPrimaris.class,
                    IMLandRaiderExcelsior.class), HQeinträge_IA_AA));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(concat(Standardeinträge_Space_Wolves, ImmutableList.of(null,
                    IMIntercessors.class)));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_Space_Wolves, ImmutableList.of(null,
                    IMReivers.class,
                    IMAggressors.class,
                    IMServitors.class,
                    IMGreatCompanyAncient.class,
                    IMPrimarisAncient.class,
                    IMGreatCompanyChampion.class,
                    null,
                    IMDreadnought.class,
                    IMVenerableDreadnought.class,
                    IMContemptorDreadnought.class,
                    IMRedemptorDreadnought.class,
                    null,
                    IMImperialSpaceMarine.class), Eliteeinträge_IA_AA));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_Space_Wolves, ImmutableList.of(null,
                    IMInceptors.class,
                    IMLandSpeeders.class), Sturmeinträge_IA_AA));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungseinträge_Space_Wolves, ImmutableList.of(null,
                    IMHellblasters.class,
                    IMHunter.class,
                    IMStalker.class,
                    null,
                    IMPredator.class,
                    IMWhirlwind.class,
                    IMVindicator.class,
                    null,
                    IMLandRaider.class,
                    IMLandRaiderCrusader.class,
                    IMLandRaiderRedeemer.class), Unterstützungseinträge_IA_AA));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(ImmutableList.of(null,
                    IMRhino.class,
                    IMRazorback.class,
                    IMDropPod.class,
                    IMLandSpeederStorm.class,
                    IMRepulsor.class),
                    Transporteinträge_IA_AA));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_Space_Wolves, Fliegereinträge_IA_AA));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_IA_AA);
        } else if (getFormationType().equals("Deathwatch")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_Deathwatch, HQeinträge_IA_AA));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Deathwatch);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_Deathwatch, Eliteeinträge_IA_AA));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_Deathwatch, Sturmeinträge_IA_AA));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungseinträge_Deathwatch, Unterstützungseinträge_IA_AA));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(Transporteinträge_Deathwatch,Transporteinträge_IA_AA));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_Deathwatch, Fliegereinträge_IA_AA));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of(null));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_IA_AA);
        } else if (getFormationType().equals("Grey Knights")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Grey_Knights);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Grey_Knights);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Grey_Knights);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_Grey_Knights);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungseinträge_Grey_Knights);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Grey_Knights);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(Fliegereinträge_Grey_Knights);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(null));
        } else if (getFormationType().equals("ASTRA MILITARUM")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_AM_komplett);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_AM_komplett);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_AM_komplett);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_AM_komplett);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungeinträge_AM_komplett);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_AM_komplett);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(Fliegereinträge_AM_komplett);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_AM_komplett);
        } else if (getFormationType().equals("Cadian")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_AM, HQeinträge_Cadian, HQeinträge_Officio_Prefectus, HQeinträge_Scholastica_Psykana));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_AM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_AM, Eliteeinträge_Cadian, Eliteeinträge_Officio_Prefectus, Eliteeinträge_Militarum_Auxilia, Eliteeinträge_Aeronautica_Imperialis,
            Eliteeinträge_Scholastica_Psykana, Eliteeinträge_Astra_Militarum_Adeptus_Ministorum));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_AM);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungeinträge_AM);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_AM);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_AM, Fliegereinträge_Aeronautica_Imperialis));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_AM);
        } else if (getFormationType().equals("Catachan")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_AM, HQeinträge_Catachan, HQeinträge_Officio_Prefectus, HQeinträge_Scholastica_Psykana));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_AM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_AM, Eliteeinträge_Catachan, Eliteeinträge_Officio_Prefectus, Eliteeinträge_Militarum_Auxilia, Eliteeinträge_Aeronautica_Imperialis,
                    Eliteeinträge_Scholastica_Psykana, Eliteeinträge_Astra_Militarum_Adeptus_Ministorum));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_AM);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungeinträge_AM);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_AM);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_AM, Fliegereinträge_Aeronautica_Imperialis));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_AM);
        } else if (getFormationType().equals("MilitarumTempestus")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Militarum_Tempestus);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Militarum_Tempestus);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Militarum_Tempestus);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(null));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(null));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Militarum_Tempestus);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(null));
        } else if (ASTRA_MILITARUM.contains(getFormationType())) {
        	myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_AM, HQeinträge_Officio_Prefectus, HQeinträge_Scholastica_Psykana));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_AM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_AM, Eliteeinträge_Officio_Prefectus, Eliteeinträge_Militarum_Auxilia, Eliteeinträge_Aeronautica_Imperialis,
                    Eliteeinträge_Scholastica_Psykana, Eliteeinträge_Astra_Militarum_Adeptus_Ministorum));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_AM);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungeinträge_AM);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_AM);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_AM, Fliegereinträge_Aeronautica_Imperialis));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_AM);
    	} else if (getFormationType().equals("OfficioPrefectus")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_AM, HQeinträge_Officio_Prefectus));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_AM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_AM, Eliteeinträge_Officio_Prefectus, Eliteeinträge_Officio_Prefectus));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_AM);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungeinträge_AM);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_AM);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(Fliegereinträge_AM);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_AM);
        } else if (getFormationType().equals("MilitarumAuxilia")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_AM);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_AM);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_AM, Eliteeinträge_Militarum_Auxilia));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_AM);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungeinträge_AM);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_AM);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(Fliegereinträge_AM);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_AM);
        } else if (getFormationType().equals("Aeronautica Imperialis")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_AM);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(concat(Standardeinträge_AM, Standardeinträge_Militarum_Tempestus));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_AM, Eliteeinträge_Aeronautica_Imperialis));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_AM);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungeinträge_AM);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(Transporteinträge_AM,Transporteinträge_Militarum_Tempestus));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_AM, Fliegereinträge_Aeronautica_Imperialis));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_AM);
        } else if (getFormationType().equals("ScholasticaPsykana")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Scholastica_Psykana);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(null));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Scholastica_Psykana);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(null));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(null));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(null));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(null));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(null));
        } else if (getFormationType().equals("Adeptus Mechanicus") || FORGEWORLDS.contains(getFormationType())) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Adeptus_Mechanicus);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Adeptus_Mechanicus);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Adeptus_Mechanicus);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_Adeptus_Mechanicus);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungseinträge_Adeptus_Mechanicus);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Adeptus_Mechanicus);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(null));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(null));
        } else if (getFormationType().equals("Cult Mechanicus")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Cult_Mechanicus);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Cult_Mechanicus);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Cult_Mechanicus);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(null));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungseinträge_Cult_Mechanicus);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(null));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(null));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(null));
        } else if (getFormationType().equals("Skitarii")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(null));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Skitarii);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Skitarii);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_Skitarii);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungseinträge_Skitarii);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(null));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(null));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(null));
        } else if (getFormationType().equals("Questor Imperialis")) {
            clearCombo();
            kontingentBox.setSelectedItem("Super-Heavy Detachment");
            myChooserGruppen.get(AI).changeComboBoxAuswahlen(AdditionalInformation_Questor_Imperialis);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWar_Questor_Imperialis);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(concat(Befestigungen, Befestigung_Questor_Imperialis));
        } else if (getFormationType().equals("OfficioAssassinorum")) {
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Officio_Assassinorum);
        } else if (getFormationType().equals("AdeptusAstraTelepathica")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Adeptus_Astra_Telepathica);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(null));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Adeptus_Astra_Telepathica);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(null));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(null));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Adeptus_Astra_Telepathica);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(null));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(null));
        } else if (getFormationType().equals("ScholasticaPsykana")) {
            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Scholastica_Psykana);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Scholastica_Psykana);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
        } else if (getFormationType().equals("SistersofSilence")) {
            clearCombo();
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Sisters_of_Silence);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Sisters_of_Silence);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
        } else if (getFormationType().equals("AdeptusCustodes")) {
            clearCombo();
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Adeptus_Custodes);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Adeptus_Custodes);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Adeptus_Custodes);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_Adeptus_Custodes);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungseinträge_Adeptus_Custodes);
        } else if (getFormationType().equals("Adepta Sororitas") ||AS_ORDERS.contains(getFormationType())) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Adepta_Sororitas);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Adepta_Sororitas);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Adepta_Sororitas);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_Adepta_Sororitas);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungseinträge_Adepta_Sororitas);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Adepta_Sororitas);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(null));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(null));
        } else if (getFormationType().equals("Adeptus Ministorum")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_Adeptus_Ministorum);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_Adeptus_Ministorum);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Adeptus_Ministorum);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_Adeptus_Ministorum);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungseinträge_Adeptus_Ministorum);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_Adeptus_Ministorum);
        }

        if (formation!= null) {
            formation.refreshControlPanel();
        }

        fillChooserSpace();
    }
}
