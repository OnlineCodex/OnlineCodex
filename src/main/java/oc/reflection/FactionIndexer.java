package oc.reflection;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import oc.Eintrag;
import oc.wh40k.units.AOPSlot;
import oc.wh40k.units.AOPSlot.*;
import oc.wh40k.units.Faction;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import static com.google.common.collect.ImmutableMap.toImmutableMap;
import static com.google.common.collect.ImmutableTable.toImmutableTable;
import static net.jodah.typetools.TypeResolver.resolveRawArguments;

public class FactionIndexer {

    public static <F extends Faction> Map<Class<? extends F>, FactionDescription<? extends F>> indexFaction(String basePackage, Class<F> faction) {
        Reflections r = new Reflections(basePackage);
        Table<Class<? extends Faction>, Class<? extends AOPSlot>, Set<Class<?>>> table =  r.getSubTypesOf(Eintrag.class).stream()
                .collect(toImmutableTable(
                        cls -> (Class) resolveRawArguments(Eintrag.class, cls)[0],
                        cls -> (Class) resolveRawArguments(Eintrag.class, cls)[1],
                        ImmutableSet::of,
                        Sets::union));
        return Stream.concat(r.getSubTypesOf(faction).stream(), Stream.of(faction))
                .collect(toImmutableMap(
                        Function.identity(),
                        f -> toFactionDescription(f, table.row(f))));
    }

    private static FactionDescription toFactionDescription(Class faction, Map<Class<? extends AOPSlot>, Set<Class<?>>> map) {
        return new FactionDescription(
                faction,
                map.getOrDefault(Hq.class, ImmutableSet.of()),
                map.getOrDefault(Troops.class, ImmutableSet.of()),
                map.getOrDefault(Elite.class, ImmutableSet.of()),
                map.getOrDefault(FastAttack.class, ImmutableSet.of()),
                map.getOrDefault(HeavySupport.class, ImmutableSet.of()),
                map.getOrDefault(DedicatedTransport.class, ImmutableSet.of()),
                map.getOrDefault(Flier.class, ImmutableSet.of()),
                map.getOrDefault(LordOfWar.class, ImmutableSet.of()),
                map.getOrDefault(Fortification.class, ImmutableSet.of()));
    }

}
