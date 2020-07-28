package oc.wh40k.units.im;

import java.util.Vector;

import oc.BuildaVater;
import oc.OptionsGruppeEintrag;
import oc.RuestkammerElement;

public class IMSpaceMarinesTerminatorHeavyWeapons extends RuestkammerElement {
    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv) {
        final Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
        addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);
        addElement("Heavy flamer", "Heavy flamer (SM INFANTRY)", defaultWeapon, ogE, bv);
        addElement("Assault cannon", "Assault cannon (INFANTRY)", defaultWeapon, ogE, bv);
        addElement("Cyclone ML + SB", "Cyclone Missile launcher + Storm bolter", bv.getPts("Cyclone Missile launcher") + bv.getPts("Storm bolter (SM)"), defaultWeapon, ogE, bv);
        return ogE;
    }
}
