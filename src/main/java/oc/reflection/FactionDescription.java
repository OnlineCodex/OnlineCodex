package oc.reflection;

import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import oc.Eintrag;
import oc.wh40k.units.AOPSlot;
import oc.wh40k.units.AOPSlot.*;
import oc.wh40k.units.Faction;

import java.util.Map;
import java.util.Set;

import static java.util.Objects.requireNonNull;

public final class FactionDescription<F extends Faction> {

    private final Class<F> type;
    private final SetMultimap<Class<? extends AOPSlot>, Class<? extends Eintrag<F, ?>>> units;

    public static <F extends Faction> FactionDescription<F> of(Class<F> type, Multimap<Class<? extends AOPSlot>, Class<? extends Eintrag<F, ?>>> units) {
        return new FactionDescription<>(type, units);
    }

    private FactionDescription(Class<F> type, Multimap<Class<? extends AOPSlot>, Class<? extends Eintrag<F, ?>>> units) {
        this.type = requireNonNull(type, "type");
        this.units = ImmutableSetMultimap.copyOf(units);
    }

    @SuppressWarnings({
            "unchecked", "rawtypes",
    })
    public static <F extends Faction> FactionDescription<F> of(Class<F> faction, Map<Class<? extends AOPSlot>, Set<Class<?>>> map) {
        ImmutableSetMultimap.Builder<Class<? extends AOPSlot>, Class<? extends Eintrag<F, ?>>> builder = ImmutableSetMultimap.builder();

        map.entrySet().forEach(e -> builder.putAll(e.getKey(), (Iterable) e.getValue()));

        return new FactionDescription<>(faction, builder.build());
    }

    public Class<F> getType() {
        return type;
    }

    public SetMultimap<Class<? extends AOPSlot>, Class<? extends Eintrag<F, ?>>> getUnits() {
        return units;
    }

    @SuppressWarnings({
            "unchecked", // access to heterogeneous map
    })
    public Set<Class<? extends Eintrag<F, Hq>>> getHq() {
        return (Set) units.get(Hq.class);
    }

    @SuppressWarnings({
            "unchecked", // access to heterogeneous map
    })
    public Set<Class<? extends Eintrag<F, Troops>>> getTroops() {
        return (Set) units.get(Troops.class);
    }

    @SuppressWarnings({
            "unchecked", // access to heterogeneous map
    })
    public Set<Class<? extends Eintrag<F, Elite>>> getElite() {
        return (Set) units.get(Elite.class);
    }

    @SuppressWarnings({
            "unchecked", // access to heterogeneous map
    })
    public Set<Class<? extends Eintrag<F, FastAttack>>> getFastAttack() {
        return (Set) units.get(FastAttack.class);
    }

    @SuppressWarnings({
            "unchecked", // access to heterogeneous map
    })
    public Set<Class<? extends Eintrag<F, HeavySupport>>> getHeavySupport() {
        return (Set) units.get(HeavySupport.class);
    }

    @SuppressWarnings({
            "unchecked", // access to heterogeneous map
    })
    public Set<Class<? extends Eintrag<F, DedicatedTransport>>> getDedicatedTransport() {
        return (Set) units.get(DedicatedTransport.class);
    }

    @SuppressWarnings({
            "unchecked", // access to heterogeneous map
    })
    public Set<Class<? extends Eintrag<F, Flier>>> getFlier() {
        return (Set) units.get(Flier.class);
    }

    @SuppressWarnings({
            "unchecked", // access to heterogeneous map
    })
    public Set<Class<? extends Eintrag<F, LordOfWar>>> getLordOfWar() {
        return (Set) units.get(LordOfWar.class);
    }

    @SuppressWarnings({
            "unchecked", // access to heterogeneous map
    })
    public Set<Class<? extends Eintrag<F, Fortification>>> getFortification() {
        return (Set) units.get(Fortification.class);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactionDescription that = (FactionDescription) o;
        return type.equals(that.type) && units.equals(that.units);
    }

    @Override
    public int hashCode() {
        return type.hashCode() * 31 + units.hashCode();
    }

    @Override
    public String toString() {
        return "FactionDescription{type=" + type + ", units=" + units + '}';
    }
}