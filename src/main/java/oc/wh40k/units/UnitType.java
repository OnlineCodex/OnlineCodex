package oc.wh40k.units;

public interface UnitType {
    interface Infantry extends UnitType {}
    interface Vehicle extends UnitType {}
    interface Beasts extends UnitType {}
    interface Swarm extends UnitType {}
    interface Biker extends  UnitType {}
    interface Monster extends UnitType {}
}
