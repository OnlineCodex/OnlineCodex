package oc.reflection;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import oc.Eintrag;
import oc.wh40k.units.AOPSlot;
import oc.wh40k.units.Faction;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static com.google.common.collect.ImmutableMap.toImmutableMap;
import static com.google.common.collect.ImmutableTable.toImmutableTable;
import static java.util.function.Function.identity;
import static java.util.stream.Stream.concat;
import static net.jodah.typetools.TypeResolver.resolveRawArguments;

public class FactionIndexer {

    public static <F extends Faction> Map<Class<? extends F>, FactionDescription<? extends F>> indexFaction(String basePackage, Class<F> faction) {
        Reflections r = new Reflections(basePackage);

        Table<Class<? extends Faction>, Class<? extends AOPSlot>, Set<Class<?>>> units = r.getSubTypesOf(Eintrag.class)
                .stream()
                .collect(toImmutableTable(
                        FactionIndexer::faction,
                        FactionIndexer::aopSlot,
                        ImmutableSet::of,
                        Sets::union));

        return concat(r.getSubTypesOf(faction).stream(), Stream.of(faction))
                .map(f -> FactionDescription.of(f, units.row(f)))
                .collect(toImmutableMap(FactionDescription::getType, identity()));
    }

    @SuppressWarnings({
            "unchecked", // resolveRawArguments weakens the return type
    })
    private static Class<? extends Faction> faction(Class<?> cls) {
        return (Class<? extends Faction>) resolveRawArguments(Eintrag.class, cls)[0];
    }

    @SuppressWarnings({
            "unchecked", // resolveRawArguments weakens the return type
    })
    private static Class<? extends AOPSlot> aopSlot(Class<?> cls) {
        return (Class<? extends AOPSlot>) resolveRawArguments(Eintrag.class, cls)[1];
    }
}