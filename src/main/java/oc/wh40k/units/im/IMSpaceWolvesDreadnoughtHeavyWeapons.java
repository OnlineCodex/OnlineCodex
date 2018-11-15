package oc.wh40k.units.im;

import oc.BuildaVater;

import oc.OptionsGruppeEintrag;

import oc.RuestkammerElement;



import java.util.Vector;

public class IMSpaceWolvesDreadnoughtHeavyWeapons extends RuestkammerElement {

    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv) {
        Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
        addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);
        addElement("Heavy plasma cannon", "Heavy plasma cannon", defaultWeapon, ogE, bv);
        addElement("Helfrost cannon", "Helfrost cannon", defaultWeapon, ogE, bv);
        addElement("Multi-melta", "Multi-melta (SM)", defaultWeapon, ogE, bv);
        addElement("Twin lascannon", "Twin lascannon", defaultWeapon, ogE, bv);
        return ogE;
    }
}
