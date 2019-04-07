package oc.wh40k.units.im;

import java.util.Vector;

import oc.BuildaVater;
import oc.OptionsGruppeEintrag;
import oc.RuestkammerElement;

public class IMSpaceWolvesDreadnoughtHeavyWeapons extends RuestkammerElement {

    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv) {
        final Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
        addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);
        addElement("Heavy plasma cannon", "Heavy plasma cannon", defaultWeapon, ogE, bv);
        addElement("Helfrost cannon", "Helfrost cannon", defaultWeapon, ogE, bv);
        addElement("Multi-melta", "Multi-melta (SM)", defaultWeapon, ogE, bv);
        addElement("Twin lascannon", "Twin lascannon", defaultWeapon, ogE, bv);
        return ogE;
    }
}
