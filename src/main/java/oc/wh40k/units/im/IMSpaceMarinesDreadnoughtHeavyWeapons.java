package oc.wh40k.units.im;

import java.util.Vector;

import oc.BuildaVater;
import oc.OptionsGruppeEintrag;
import oc.RuestkammerElement;

public class IMSpaceMarinesDreadnoughtHeavyWeapons extends RuestkammerElement {

    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv) {
        final Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
        addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);
        addElement("Twin heavy flamer", "Twin heavy flamer (SM)", defaultWeapon, ogE, bv);
        addElement("Twin autocannon", "Twin autocannon", defaultWeapon, ogE, bv);
        addElement("Twin heavy bolter", "Twin heavy bolter (SM)", defaultWeapon, ogE, bv);
        addElement("Twin lascannon", "Twin lascannon", defaultWeapon, ogE, bv);
        addElement("Assault cannon", "Assault cannon (SM)", defaultWeapon, ogE, bv);
        addElement("Heavy plasma cannon", "Heavy plasma cannon", defaultWeapon, ogE, bv);
        addElement("Multi-melta", "Multi-melta (SM)", defaultWeapon, ogE, bv);
        return ogE;
    }
}
