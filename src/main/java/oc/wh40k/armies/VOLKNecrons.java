package oc.wh40k.armies;

import com.google.common.collect.ImmutableList;
import oc.BuildaVater;
import oc.ChooserGruppe;
import oc.reflection.FactionDescription;
import oc.utils.Classes;
import oc.wh40k.units.AOPSlot;
import oc.wh40k.units.SupportFaction;
import oc.wh40k.units.necrons.Necrons;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static oc.reflection.FactionIndexer.indexFaction;
import static oc.utils.Classes.subClasses;
import static oc.utils.ResourceUtils.loadPoints;

public class VOLKNecrons extends BuildaVater {

    private final Map<Class<? extends Necrons>, FactionDescription<? extends Necrons>> subFactions;

    public VOLKNecrons() {
        super("NE", loadPoints(
                "/oc/wh40k/indices/ne.yaml",
                "/oc/wh40k/indices/iane.yaml"));

        subFactions = indexFaction("oc.wh40k.units.necrons", Necrons.class);

        AdditionalInformation = new String[]{""};
        HQeinträge = new String[]{""};
        Eliteeinträge = new String[]{""};
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
        adden(new ChooserGruppe(this, getId(), cnt, 0, TROOPS, Transporteinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, FLIER, Fliegereinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, FORTIFICATION, Befestigungen));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, LORD_OF_WAR, LordofWar));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;

        cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

        Map<Integer, List<Class<? extends Necrons>>> groups = subFactions.keySet()
                .stream()
                .collect(groupingBy(f ->
                        f == Necrons.class ? 0 :
                        f.getAnnotation(SupportFaction.class) == null ? 1 :
                        2));

        final int min = groups.keySet().stream().mapToInt(Integer::intValue).min().getAsInt();
        final int max = groups.keySet().stream().mapToInt(Integer::intValue).max().getAsInt();

        boolean firstIteration = true;
        for (int i = min; i <= max; i++) {
            if (firstIteration) {
                firstIteration = false;
            } else {
                formationen.add(null);
            }

            formationen.addAll(groups.getOrDefault(i, ImmutableList.of()));
        }

        complete();
    }

    @Override
    public void volkRefresh() {
        FactionDescription<? extends Necrons> faction = this.subFactions.get(getFormationType());

        if (faction != null) {
            for (int i=0; i < AOPSlot.APO_SLOTS.size(); i++) {
                final Class<? extends AOPSlot> aopSlot = AOPSlot.APO_SLOTS.get(i);
                myChooserGruppen.get(i + 1).setChoices(
                        subClasses("oc.wh40k", faction.getType())
                                .map(subFactions::get)
                                .filter(Objects::nonNull)
                                .map(f -> f.getUnits().get(aopSlot))
                                .filter(e -> !e.isEmpty())
                                .collect(toList()));
            }
        }

        if (formation != null) {
            formation.refreshControlPanel();
        }

        fillChooserSpace();
    }
}