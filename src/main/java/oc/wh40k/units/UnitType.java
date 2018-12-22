package oc.wh40k.units;

import oc.Tag;

public interface UnitType extends Tag {
    interface Infantry extends UnitType {}
    interface Vehicle extends UnitType {}
    interface Beasts extends UnitType {}
    interface Swarm extends UnitType {}
    interface Biker extends  UnitType {}
    interface Monster extends UnitType {}
    interface Artillery extends UnitType {}
    interface Transport extends UnitType {}
}
