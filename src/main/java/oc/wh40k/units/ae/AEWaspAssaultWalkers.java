package oc.wh40k.units.ae;

import oc.wh40k.units.Source;

import static oc.wh40k.units.Publication.IMPERIAL_ARMOUR_XENOS;

@Source(value = IMPERIAL_ARMOUR_XENOS, page = 63)
public class AEWaspAssaultWalkers extends AEWalkers {

    public AEWaspAssaultWalkers() {
        super("Wasp Assault Walkers [FW]", 6);
    }
}
