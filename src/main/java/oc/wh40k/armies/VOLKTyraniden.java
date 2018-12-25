package oc.wh40k.armies;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;
import oc.wh40k.units.ty.*;

import java.util.Set;

import static oc.utils.ResourceUtils.loadPoints;

public class VOLKTyraniden extends BuildaVater {

    private static final Set<String> HIVEFLEETS = ImmutableSet.of("Behemoth", "Kraken", "Leviathan", "Gorgon", "Jormungandr", "Hydra", "Kronos");
	
    public VOLKTyraniden() {
        super("TY", loadPoints( "/oc/wh40k/indices/ty.yaml"));

        AdditionalInformation = ImmutableList.of(null);
        HQeinträge = ImmutableList.of(null);
        Eliteeinträge = ImmutableList.of(null);
        Standardeinträge = ImmutableList.of(null);
        Sturmeinträge = ImmutableList.of(null);
        Unterstützungeinträge = ImmutableList.of(null);
        Transporteinträge = ImmutableList.of(null);
        Fliegereinträge = ImmutableList.of(null);
        Befestigungen = ImmutableList.of(null);
        LordofWar = ImmutableList.of(null);

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

        nameDerArtDerArmee = BuildaHQ.translate("Tyraniden");
        nameDerArtDerArmeeDekliniert = BuildaHQ.translate("Tyraniden");
        textAreaUeberschrift = BuildaHQ.translate("Meine") + " " + BuildaHQ.translate("Tyraniden");

        formationen.add("TYRANIDS");
        HIVEFLEETS.forEach(formationen::add);
        formationen.add(null);
        formationen.add("Genestealer Cults");

        complete();
    }
    
    @Override
    public void volkRefresh() {
        if (getFormationType().equals("TYRANIDS")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYHiveTyrant.class,
                    TYBroodlord.class,
                    TYTyranidPrime.class,
                    TYTervigon.class,
                    TYMalanthrope.class,
                    TYNeurotrophe.class,
                    null,
                    TYTheSwarmlord.class,
                    TYOldOneEye.class,
                    null,
                    TYPatriarch.class,
                    TYMagus.class,
                    TYPrimus.class,
                    TYAcolyteIconward.class));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYTyranidWarriors.class,
                    TYGenestealers.class,
                    TYTermagants.class,
                    TYHormagaunts.class,
                    TYRipperSwarm.class,
                    null,
                    TYAcolyteHybrids.class,
                    TYNeophyteHybrids.class));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYTyrantGuard.class,
                    TYHiveGuard.class,
                    TYLictor.class,
                    TYMaleceptor.class,
                    TYZoanthropes.class,
                    TYVenomthropes.class,
                    TYPyrovores.class,
                    TYHaruspex.class,
                    null,
                    TYDeathleaper.class,
                    TYTheRedTerror.class,
                    null,
                    TYHybridMetamorphs.class,
                    TYAberrants.class,
                    TYPurestrainGenestealers.class));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYTyranidShrikes.class,
                    TYRaveners.class,
                    TYSkySlasherSwarm.class,
                    TYGargoyles.class,
                    TYMucolidSpores.class,
                    TYSporenmines.class,
                    TYDimachaeron.class,
                    TYMeioticSpores.class,
                    null,
                    TYCultScoutSentinels.class,
                    TYCultArmouredSentinels.class));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYHarpy.class,
                    TYHiveCrone.class));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYCarnifexes.class,
                    TYScreamerKillers.class,
                    TYThornbacks.class,
                    TYBiovores.class,
                    TYTrygonPrime.class,
                    TYTrygon.class,
                    TYMawloc.class,
                    TYExocrine.class,
                    TYToxicrene.class,
                    TYTyrannofex.class,
                    TYStonecrusherCarnifexBrood.class,
                    null,
                    TYCultLemanRuss.class,
                    TYGoliathRockgrinder.class));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYTyrannocyte.class,
                    null,
                    TYGoliathTruck.class,
                    TYCultChimera.class));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of(null,
                    TYSporocyst.class));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYBarbedHierodule.class,
                    TYScythedHierodule.class,
                    TYHarridan.class,
                    TYHierophantBiotitan.class));
        } else if (HIVEFLEETS.contains(getFormationType())) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYHiveTyrant.class,
                    TYBroodlord.class,
                    TYTyranidPrime.class,
                    TYTervigon.class,
                    TYMalanthrope.class,
                    TYNeurotrophe.class,
                    null,
                    TYTheSwarmlord.class,
                    TYOldOneEye.class));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYTyranidWarriors.class,
                    TYGenestealers.class,
                    TYTermagants.class,
                    TYHormagaunts.class,
                    TYRipperSwarm.class));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYTyrantGuard.class,
                    TYHiveGuard.class,
                    TYLictor.class,
                    TYMaleceptor.class,
                    TYZoanthropes.class,
                    TYVenomthropes.class,
                    TYPyrovores.class,
                    TYHaruspex.class,
                    null,
                    TYDeathleaper.class,
                    TYTheRedTerror.class));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYTyranidShrikes.class,
                    TYRaveners.class,
                    TYSkySlasherSwarm.class,
                    TYGargoyles.class,
                    TYMucolidSpores.class,
                    TYSporenmines.class,
                    TYDimachaeron.class,
                    TYMeioticSpores.class));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYHarpy.class,
                    TYHiveCrone.class));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYCarnifexes.class,
                    TYScreamerKillers.class,
                    TYThornbacks.class,
                    TYBiovores.class,
                    TYTrygonPrime.class,
                    TYTrygon.class,
                    TYMawloc.class,
                    TYExocrine.class,
                    TYToxicrene.class,
                    TYTyrannofex.class,
                    TYStonecrusherCarnifexBrood.class));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYTyrannocyte.class));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of(null,
                    TYSporocyst.class));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYBarbedHierodule.class,
                    TYScythedHierodule.class,
                    TYHarridan.class,
                    TYHierophantBiotitan.class));
        } else if (getFormationType().equals("Genestealer Cults")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYPatriarch.class,
                    TYMagus.class,
                    TYPrimus.class,
                    TYAcolyteIconward.class));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYAcolyteHybrids.class,
                    TYNeophyteHybrids.class));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYHybridMetamorphs.class,
                    TYAberrants.class,
                    TYPurestrainGenestealers.class));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYCultScoutSentinels.class,
                    TYCultArmouredSentinels.class));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYCultLemanRuss.class,
                    TYGoliathRockgrinder.class));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(null));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
                    TYGoliathTruck.class,
                    TYCultChimera.class));
        }

        if (formation != null) {
            formation.refreshControlPanel();
        }

        fillChooserSpace();
    }
}