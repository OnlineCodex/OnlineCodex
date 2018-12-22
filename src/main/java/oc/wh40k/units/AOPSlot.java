package oc.wh40k.units;

import com.google.common.collect.ImmutableList;
import oc.ShadowType;

import java.util.List;

public abstract class AOPSlot extends ShadowType {
    private AOPSlot() {}

    public static final List<Class<? extends AOPSlot>> APO_SLOTS = ImmutableList.of(
            Hq.class,
            Troops.class,
            Elite.class,
            FastAttack.class,
            HeavySupport.class,
            DedicatedTransport.class,
            Flier.class,
            Fortification.class,
            LordOfWar.class);

    public static final class Hq extends AOPSlot {}
    public static final class Troops extends AOPSlot {}
    public static final class Elite extends AOPSlot {}
    public static final class FastAttack extends AOPSlot {}
    public static final class HeavySupport extends AOPSlot {}
    public static final class DedicatedTransport extends AOPSlot {}
    public static final class Flier extends AOPSlot {}
    public static final class LordOfWar extends AOPSlot {}
    public static final class Fortification extends AOPSlot {}
}
