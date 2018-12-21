package oc.wh40k.units;

import oc.ShadowType;

public abstract class UnitType extends ShadowType {
    private UnitType() {}

    public static final class Infantry extends UnitType {}
    public static final class Vehicle extends UnitType {}
    public static final class Beasts extends UnitType {}
    public static final class Swarm extends UnitType {}
    public static final class Biker extends  UnitType {}
    public static final class Monster extends UnitType {}
}
