package oc.wh40k.armies;

import com.google.common.collect.ImmutableList;
import oc.BuildaVater;
import oc.ChooserGruppe;
import oc.Eintrag;
import oc.wh40k.units.ne.*;

import java.util.List;

import static oc.utils.EvenMoreCollections.concat;
import static oc.utils.ResourceUtils.loadPoints;

public class VOLKNecrons extends BuildaVater {

    //Vanilla Necrons
    private static final List<Class<? extends Eintrag>> HQeinträge_NE = ImmutableList.of(
            null,
            NEOverlord.class,
            NELord.class,
            NECryptek.class,
            NEDestroyerLord.class,
            NECatacombCommandBarge.class);
    private static final List<Class<? extends Eintrag>> Standardeinträge_NE = ImmutableList.of(
            null,
            NENecronWarriors.class,
            NEImmortals.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_NE = ImmutableList.of(
            null,
            NELychguard.class,
            NEDeathmarks.class,
            NEFlayedOnes.class);
    private static final List<Class<? extends Eintrag>> Sturmeinträge_NE = ImmutableList.of(
            null,
            NETombBlades.class,
            NEDestroyers.class);
    private static final List<Class<? extends Eintrag>> Unterstützungeinträge_NE = ImmutableList.of(
            null,
            NEHeavyDestroyers.class,
            NEMonolith.class,
            NEAnnihilationBarge.class,
            NEDoomsdayArk.class);
    private static final List<Class<? extends Eintrag>> Transporteinträge_NE = ImmutableList.of(
            null,
            NEGhostArk.class);
    private static final List<Class<? extends Eintrag>> Fliegereinträge_NE = ImmutableList.of(
            null,
            NEDoomScythe.class,
            NENightScythe.class);
    private static final List<Class<? extends Eintrag>>LordofWareinträge_NE = ImmutableList.of(
            null,
            NEObelisk.class);

    //ohne Dynasty
    private static final List<Class<? extends Eintrag>> HQeinträge_Vanilla_only = ImmutableList.of(
            null,
            NEIlluminorSzeras.class,
            NEAnrakyrtheTraveller.class);
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Vanilla_only = ImmutableList.of(
            null,
            NETriarchPraetorians.class,
            NETriarchStalker.class);

    //Sautekh Dynasty
    private static final List<Class<? extends Eintrag>> HQeinträge_Sautekh = ImmutableList.of(
            null,
            NEImotekhtheStormlord.class,
            NENemesorZahndrekh.class,
            NEVargardObyron.class,
            NEOrikantheDiviner.class);

    //Nihilakh Dynasty
    private static final List<Class<? extends Eintrag>> HQeinträge_Nihilakh = ImmutableList.of(
            null,
            NETrazyntheInfinite.class);

    //C'tan Shards
    private static final List<Class<? extends Eintrag>> Eliteeinträge_Ctan_Shards = ImmutableList.of(
            null,
            NECtanShardoftheDeceiver.class,
            NECtanShardoftheNightbringer.class);
    private static final List<Class<? extends Eintrag>> Unterstützungeinträge_Ctan_Shards = ImmutableList.of(
            null,
            NETranscendentCtan.class);

    //C'tan Shards & Dynasty
    private static final List<Class<? extends Eintrag>>LordofWareinträge_Ctan_Shards_Dynasty = ImmutableList.of(
            null,
            NETesseractVault.class);

    //Canoptek
    private static final List<Class<? extends Eintrag>> Sturmeinträge_Canoptek = ImmutableList.of(
            null,
            NECanoptekWraiths.class,
            NECanoptekScarabs.class);
    private static final List<Class<? extends Eintrag>> Unterstützungeinträge_Canoptek = ImmutableList.of(
            null,
            NECanoptekSpyders.class);

    //Imperial Armour Xenos Vanilla
    private static final List<Class<? extends Eintrag>> Unterstützungeinträge_IA_NE = ImmutableList.of(
            null,
            NESentryPylon.class,
            NETesseractArk.class);
    private static final List<Class<? extends Eintrag>> Fliegereinträge_IA_NE = ImmutableList.of(
            null,
            NENightShroud.class);
    private static final List<Class<? extends Eintrag>>LordofWareinträge_IA_NE = ImmutableList.of(
            null,
            NEGaussPylon.class);
    private static final List<Class<? extends Eintrag>> Befestigungen_IA_NE = ImmutableList.of(
            null,
            NETombCitadel.class);

    //Imperial Armour Xenos Maynarkh Dynasty
    private static final List<Class<? extends Eintrag>> HQeinträge_IA_Maynarkh = ImmutableList.of(
            null,
            NEKutlakhtheWorldKiller.class,
            NEToholktheBlinded.class);

    //Imperial Armour Xenos Canoptek
    private static final List<Class<? extends Eintrag>> Eliteeinträge_IA_Canoptek = ImmutableList.of(
            null,
            NECanoptekTombStalker.class);
    private static final List<Class<? extends Eintrag>> Sturmeinträge_IA_Canoptek = ImmutableList.of(
            null,
            NECanoptekAcanthrites.class,
            NECanoptekTombSentinel.class);

    public VOLKNecrons() {
        super("NE", loadPoints("/oc/wh40k/indices/ne.yaml", "/oc/wh40k/indices/iane.yaml"));

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
        adden(new ChooserGruppe(this, getId(), cnt, 0, LORD_OF_WAR,LordofWar));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;

        cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

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
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_NE, HQeinträge_Vanilla_only, HQeinträge_Sautekh, HQeinträge_Nihilakh, HQeinträge_IA_Maynarkh));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(concat(Standardeinträge_NE));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(concat(Transporteinträge_NE));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_NE, Fliegereinträge_IA_NE));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(concat(Befestigungen, Befestigungen_IA_NE));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(LordofWareinträge_NE,LordofWareinträge_Ctan_Shards_Dynasty,LordofWareinträge_IA_NE));
        } else if (getFormationType().equals("Sautekh")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_NE, HQeinträge_Vanilla_only, HQeinträge_Sautekh));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_NE);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_NE);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_NE, Fliegereinträge_IA_NE));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(concat(Befestigungen, Befestigungen_IA_NE));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(LordofWareinträge_NE,LordofWareinträge_Ctan_Shards_Dynasty,LordofWareinträge_IA_NE));
        } else if (getFormationType().equals("Nihilakh")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_NE, HQeinträge_Vanilla_only, HQeinträge_Nihilakh));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_NE);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_NE);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_NE, Fliegereinträge_IA_NE));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(concat(Befestigungen, Befestigungen_IA_NE));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(LordofWareinträge_NE,LordofWareinträge_Ctan_Shards_Dynasty,LordofWareinträge_IA_NE));
        } else if (getFormationType().equals("Novokh")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_NE, HQeinträge_Vanilla_only));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_NE);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_NE);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_NE, Fliegereinträge_IA_NE));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(concat(Befestigungen, Befestigungen_IA_NE));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(LordofWareinträge_NE,LordofWareinträge_Ctan_Shards_Dynasty,LordofWareinträge_IA_NE));
        } else if (getFormationType().equals("Mephrit")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_NE, HQeinträge_Vanilla_only));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_NE);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_NE);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_NE, Fliegereinträge_IA_NE));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(concat(Befestigungen, Befestigungen_IA_NE));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(LordofWareinträge_NE,LordofWareinträge_Ctan_Shards_Dynasty,LordofWareinträge_IA_NE));
        } else if (getFormationType().equals("Nephrekh")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_NE, HQeinträge_Vanilla_only));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_NE);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_NE);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_NE, Fliegereinträge_IA_NE));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(concat(Befestigungen, Befestigungen_IA_NE));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(LordofWareinträge_NE,LordofWareinträge_Ctan_Shards_Dynasty,LordofWareinträge_IA_NE));
        } else if (getFormationType().equals("Maynarkh")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(concat(HQeinträge_NE, HQeinträge_Vanilla_only, HQeinträge_IA_Maynarkh));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_NE);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(concat(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(concat(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_NE);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(concat(Fliegereinträge_NE, Fliegereinträge_IA_NE));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(concat(Befestigungen, Befestigungen_IA_NE));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(concat(LordofWareinträge_NE,LordofWareinträge_Ctan_Shards_Dynasty,LordofWareinträge_IA_NE));
        } else if (getFormationType().equals("C'tan Shards")) {
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Ctan_Shards);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungeinträge_Ctan_Shards);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWareinträge_Ctan_Shards_Dynasty);
        } else if (getFormationType().equals("Canoptek")) {
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_IA_Canoptek);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(concat(Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungeinträge_Canoptek);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
        }

        if (formation != null) {
            formation.refreshControlPanel();
        }

        fillChooserSpace();
    }
}