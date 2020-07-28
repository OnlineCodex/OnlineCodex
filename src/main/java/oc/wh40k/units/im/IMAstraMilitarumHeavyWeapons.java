package oc.wh40k.units.im;

import java.util.Vector;

import oc.BuildaVater;
import oc.OptionsGruppeEintrag;
import oc.RuestkammerElement;

public class IMAstraMilitarumHeavyWeapons extends RuestkammerElement {
    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv) {
        final Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
        addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);
        addElement("Mortar", "Mortar", defaultWeapon, ogE, bv);
        addElement("Autocannon", "Autocannon (AM infantry)", defaultWeapon, ogE, bv);
        addElement("Heavy bolter", "Heavy Bolter (AM)", defaultWeapon, ogE, bv);
        addElement("Missile launcher", "Missile launcher (AM)", defaultWeapon, ogE, bv);
        addElement("Lascannon", "Lascannon (AM)", defaultWeapon, ogE, bv);
        return ogE;
    }
}





