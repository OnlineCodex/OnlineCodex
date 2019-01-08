package oc.wh40k.units.ae;

import oc.wh40k.units.Source;

import static oc.wh40k.units.Publication.IMPERIAL_ARMOUR_XENOS;

@Source(value = IMPERIAL_ARMOUR_XENOS, page = 63)
public class AEWaspAssaultWalkers extends AEWalkers {

    public static final String WASP_ASSAULT_WALKERS_FW = "Wasp Assault Walkers [FW]";

    public AEWaspAssaultWalkers() {
        super(WASP_ASSAULT_WALKERS_FW, 6);
    }
}
