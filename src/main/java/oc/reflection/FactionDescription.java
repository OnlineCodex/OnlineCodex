package oc.reflection;

import com.google.common.collect.ImmutableSet;
import oc.Eintrag;
import oc.wh40k.units.AOPSlot.*;
import oc.wh40k.units.Faction;

import java.util.Objects;
import java.util.Set;

import static java.util.Objects.requireNonNull;

public final class FactionDescription<F extends Faction> {

    private final Class<F> type;
    private final Set<Class<? extends Eintrag<F, Hq>>> hq;
    private final Set<Class<? extends Eintrag<F, Troops>>> troops;
    private final Set<Class<? extends Eintrag<F, Elite>>> elite;
    private final Set<Class<? extends Eintrag<F, FastAttack>>> fastAttack;
    private final Set<Class<? extends Eintrag<F, HeavySupport>>> heavySupport;
    private final Set<Class<? extends Eintrag<F, DedicatedTransport>>> dedicatedTransport;
    private final Set<Class<? extends Eintrag<F, Flier>>> flier;
    private final Set<Class<? extends Eintrag<F, LordOfWar>>> lordOfWar;
    private final Set<Class<? extends Eintrag<F, Fortification>>> fortification;

    public FactionDescription(
            Class<F> type,
            Set<Class<? extends Eintrag<F, Hq>>> hq,
            Set<Class<? extends Eintrag<F, Troops>>> troops,
            Set<Class<? extends Eintrag<F, Elite>>> elite,
            Set<Class<? extends Eintrag<F, FastAttack>>> fastAttack,
            Set<Class<? extends Eintrag<F, HeavySupport>>> heavySupport,
            Set<Class<? extends Eintrag<F, DedicatedTransport>>> dedicatedTransport,
            Set<Class<? extends Eintrag<F, Flier>>> flier,
            Set<Class<? extends Eintrag<F, LordOfWar>>> lordOfWar,
            Set<Class<? extends Eintrag<F, Fortification>>> fortification) {
        this.type = requireNonNull(type, "type");
        this.hq = ImmutableSet.copyOf(hq);
        this.troops = ImmutableSet.copyOf(troops);
        this.elite = ImmutableSet.copyOf(elite);
        this.fastAttack = ImmutableSet.copyOf(fastAttack);
        this.heavySupport = ImmutableSet.copyOf(heavySupport);
        this.dedicatedTransport = ImmutableSet.copyOf(dedicatedTransport);
        this.flier = ImmutableSet.copyOf(flier);
        this.lordOfWar = ImmutableSet.copyOf(lordOfWar);
        this.fortification = ImmutableSet.copyOf(fortification);
    }

    public Class<F> getType() {
        return type;
    }

    public Set<Class<? extends Eintrag<F, Hq>>> getHq() {
        return hq;
    }

    public Set<Class<? extends Eintrag<F, Troops>>> getTroops() {
        return troops;
    }

    public Set<Class<? extends Eintrag<F, Elite>>> getElite() {
        return elite;
    }

    public Set<Class<? extends Eintrag<F, FastAttack>>> getFastAttack() {
        return fastAttack;
    }

    public Set<Class<? extends Eintrag<F, HeavySupport>>> getHeavySupport() {
        return heavySupport;
    }

    public Set<Class<? extends Eintrag<F, DedicatedTransport>>> getDedicatedTransport() {
        return dedicatedTransport;
    }

    public Set<Class<? extends Eintrag<F, Flier>>> getFlier() {
        return flier;
    }

    public Set<Class<? extends Eintrag<F, LordOfWar>>> getLordOfWar() {
        return lordOfWar;
    }

    public Set<Class<? extends Eintrag<F, Fortification>>> getFortification() {
        return fortification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactionDescription that = (FactionDescription) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(hq, that.hq) &&
                Objects.equals(troops, that.troops) &&
                Objects.equals(elite, that.elite) &&
                Objects.equals(fastAttack, that.fastAttack) &&
                Objects.equals(heavySupport, that.heavySupport) &&
                Objects.equals(dedicatedTransport, that.dedicatedTransport) &&
                Objects.equals(flier, that.flier) &&
                Objects.equals(lordOfWar, that.lordOfWar) &&
                Objects.equals(fortification, that.fortification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, hq, troops, elite, fastAttack, heavySupport, dedicatedTransport, flier, lordOfWar, fortification);
    }

    @Override
    public String toString() {
        return "FactionDescription{" +
                "type=" + type +
                ", hq=" + hq +
                ", troops=" + troops +
                ", elite=" + elite +
                ", fastAttack=" + fastAttack +
                ", heavySupport=" + heavySupport +
                ", dedicatedTransport=" + dedicatedTransport +
                ", flier=" + flier +
                ", lordOfWar=" + lordOfWar +
                ", fortification=" + fortification +
                '}';
    }

}
