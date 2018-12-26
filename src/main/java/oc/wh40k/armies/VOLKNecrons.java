package oc.wh40k.armies;

import com.google.common.collect.ImmutableList;
import oc.BuildaVater;
import oc.Eintrag;
import oc.wh40k.units.ne.*;

import java.util.List;

import static oc.utils.ResourceUtils.loadPoints;

public class VOLKNecrons extends BuildaVater {

    //Vanilla Necrons
    private static final List<Class<? extends Eintrag>> HQeinträge_NE = ImmutableList.of(
            NEOverlord.class,
            NELord.class,
            NECryptek.class,
            NEDestroyerLord.class,
            NECatacombCommandBarge.class);
    private static final List<Class<? extends Eintrag>> Standardeinträge_NE = ImmutableList.of(
            NENecronWarriors.class,
            NEImmortals.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_NE = ImmutableList.of(
            NELychguard.class,
            NEDeathmarks.class,
            NEFlayedOnes.class);
    private static final List<Class<? extends Eintrag>> Sturmeinträge_NE = ImmutableList.of(
            NETombBlades.class,
            NEDestroyers.class);
    private static final List<Class<? extends Eintrag>> Unterstützungeinträge_NE = ImmutableList.of(
            NEHeavyDestroyers.class,
            NEMonolith.class,
            NEAnnihilationBarge.class,
            NEDoomsdayArk.class);
    private static final List<Class<? extends Eintrag>> Transporteinträge_NE = ImmutableList.of(
            NEGhostArk.class);
    private static final List<Class<? extends Eintrag>> Fliegereinträge_NE = ImmutableList.of(
            NEDoomScythe.class,
            NENightScythe.class);
    private static final List<Class<? extends Eintrag>>LordofWareinträge_NE = ImmutableList.of(
            NEObelisk.class);

    //ohne Dynasty
    private static final List<Class<? extends Eintrag>> HQeinträge_Vanilla_only = ImmutableList.of(
            NEIlluminorSzeras.class,
            NEAnrakyrtheTraveller.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Vanilla_only = ImmutableList.of(
            NETriarchPraetorians.class,
            NETriarchStalker.class);

    //Sautekh Dynasty
    private static final List<Class<? extends Eintrag>> HQeinträge_Sautekh = ImmutableList.of(
            NEImotekhtheStormlord.class,
            NENemesorZahndrekh.class,
            NEVargardObyron.class,
            NEOrikantheDiviner.class);

    //Nihilakh Dynasty
    private static final List<Class<? extends Eintrag>> HQeinträge_Nihilakh = ImmutableList.of(
            NETrazyntheInfinite.class);

    //C'tan Shards
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Ctan_Shards = ImmutableList.of(
            NECtanShardoftheDeceiver.class,
            NECtanShardoftheNightbringer.class);
    private static final List<Class<? extends Eintrag>> Unterstützungeinträge_Ctan_Shards = ImmutableList.of(
            NETranscendentCtan.class);

    //C'tan Shards & Dynasty
    private static final List<Class<? extends Eintrag>>LordofWareinträge_Ctan_Shards_Dynasty = ImmutableList.of(
            NETesseractVault.class);

    //Canoptek
    private static final List<Class<? extends Eintrag>> Sturmeinträge_Canoptek = ImmutableList.of(
            NECanoptekWraiths.class,
            NECanoptekScarabs.class);
    private static final List<Class<? extends Eintrag>> Unterstützungeinträge_Canoptek = ImmutableList.of(
            NECanoptekSpyders.class);

    //Imperial Armour Xenos Vanilla
    private static final List<Class<? extends Eintrag>> Unterstützungeinträge_IA_NE = ImmutableList.of(
            NESentryPylon.class,
            NETesseractArk.class);
    private static final List<Class<? extends Eintrag>> Fliegereinträge_IA_NE = ImmutableList.of(
            NENightShroud.class);
    private static final List<Class<? extends Eintrag>>LordofWareinträge_IA_NE = ImmutableList.of(
            NEGaussPylon.class);
    private static final List<Class<? extends Eintrag>> Befestigungen_IA_NE = ImmutableList.of(
            NETombCitadel.class);

    //Imperial Armour Xenos Maynarkh Dynasty
    private static final List<Class<? extends Eintrag>> HQeinträge_IA_Maynarkh = ImmutableList.of(
            NEKutlakhtheWorldKiller.class,
            NEToholktheBlinded.class);

    //Imperial Armour Xenos Canoptek
    private static final List<Class<? extends Eintrag>> Eliteeinträge_IA_Canoptek = ImmutableList.of(
            NECanoptekTombStalker.class);
    private static final List<Class<? extends Eintrag>> Sturmeinträge_IA_Canoptek = ImmutableList.of(
            NECanoptekAcanthrites.class,
            NECanoptekTombSentinel.class);

    public VOLKNecrons() {
        super("NE", loadPoints("/oc/wh40k/indices/ne.yaml", "/oc/wh40k/indices/iane.yaml"));

        //Formationen
        formationen.add("NECRONS");
        formationen.add(null);
        formationen.add("Sautekh");
        formationen.add("Nihilakh");
        formationen.add("Novokh");
        formationen.add("Mephrit");
        formationen.add("Nephrekh");
        formationen.add("Maynarkh");
        formationen.add(null);
        formationen.add("C'tan Shards");
        formationen.add("Canoptek");

        complete();
    }

    @Override
    public void volkRefresh() {
        if (getFormationType().equals("NECRONS")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(HQeinträge_NE, HQeinträge_Vanilla_only, HQeinträge_Sautekh, HQeinträge_Nihilakh, HQeinträge_IA_Maynarkh));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(Standardeinträge_NE));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(Transporteinträge_NE));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(Fliegereinträge_NE, Fliegereinträge_IA_NE));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of(Befestigungen_IA_NE));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(LordofWareinträge_NE,LordofWareinträge_Ctan_Shards_Dynasty,LordofWareinträge_IA_NE));
        } else if (getFormationType().equals("Sautekh")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(HQeinträge_NE, HQeinträge_Vanilla_only, HQeinträge_Sautekh));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(Standardeinträge_NE));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(Transporteinträge_NE));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(Fliegereinträge_NE, Fliegereinträge_IA_NE));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of(Befestigungen_IA_NE));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(LordofWareinträge_NE,LordofWareinträge_Ctan_Shards_Dynasty,LordofWareinträge_IA_NE));
        } else if (getFormationType().equals("Nihilakh")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(HQeinträge_NE, HQeinträge_Vanilla_only, HQeinträge_Nihilakh));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(Standardeinträge_NE));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(Transporteinträge_NE));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(Fliegereinträge_NE, Fliegereinträge_IA_NE));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of(Befestigungen_IA_NE));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(LordofWareinträge_NE,LordofWareinträge_Ctan_Shards_Dynasty,LordofWareinträge_IA_NE));
        } else if (getFormationType().equals("Novokh")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(HQeinträge_NE, HQeinträge_Vanilla_only));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(Standardeinträge_NE));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(Transporteinträge_NE));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(Fliegereinträge_NE, Fliegereinträge_IA_NE));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of(Befestigungen_IA_NE));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(LordofWareinträge_NE,LordofWareinträge_Ctan_Shards_Dynasty,LordofWareinträge_IA_NE));
        } else if (getFormationType().equals("Mephrit")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(HQeinträge_NE, HQeinträge_Vanilla_only));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(Standardeinträge_NE));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(Transporteinträge_NE));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(Fliegereinträge_NE, Fliegereinträge_IA_NE));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of(Befestigungen_IA_NE));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(LordofWareinträge_NE,LordofWareinträge_Ctan_Shards_Dynasty,LordofWareinträge_IA_NE));
        } else if (getFormationType().equals("Nephrekh")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(HQeinträge_NE, HQeinträge_Vanilla_only));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(Standardeinträge_NE));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(Transporteinträge_NE));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(Fliegereinträge_NE, Fliegereinträge_IA_NE));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of(Befestigungen_IA_NE));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(LordofWareinträge_NE,LordofWareinträge_Ctan_Shards_Dynasty,LordofWareinträge_IA_NE));
        } else if (getFormationType().equals("Maynarkh")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(HQeinträge_NE, HQeinträge_Vanilla_only, HQeinträge_IA_Maynarkh));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(Standardeinträge_NE));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(Transporteinträge_NE));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(Fliegereinträge_NE, Fliegereinträge_IA_NE));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of(Befestigungen_IA_NE));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(LordofWareinträge_NE,LordofWareinträge_Ctan_Shards_Dynasty,LordofWareinträge_IA_NE));
        } else if (getFormationType().equals("C'tan Shards")) {
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(Eliteeinträge_Ctan_Shards));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(Unterstützungeinträge_Ctan_Shards));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(LordofWareinträge_Ctan_Shards_Dynasty));
        } else if (getFormationType().equals("Canoptek")) {
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(Unterstützungeinträge_Canoptek));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of());
        }

        if (formation != null) {
            formation.refreshControlPanel();
        }

        fillChooserSpace();
    }
}