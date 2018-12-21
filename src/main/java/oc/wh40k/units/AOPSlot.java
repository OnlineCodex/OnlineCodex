package oc.wh40k.units;

import oc.Tag;

public interface AOPSlot extends Tag {
    interface Hq extends AOPSlot {}
    interface Assault extends AOPSlot {}
    interface Elite extends AOPSlot {}
    interface FastAttack extends AOPSlot {}
    interface HeavySupport extends  AOPSlot {}
}
