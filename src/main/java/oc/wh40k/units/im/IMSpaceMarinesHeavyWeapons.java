package oc.wh40k.units.im;



import java.util.Vector;

import oc.BuildaVater;
import oc.OptionsGruppeEintrag;
import oc.RuestkammerElement;



public class IMSpaceMarinesHeavyWeapons extends RuestkammerElement {
    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv) {

        final Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
        addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);
        addElement("Missile launcher", "Missile launcher (SM INFANTRY)", defaultWeapon, ogE, bv);
        addElement("Heavy bolter", "Heavy bolter (SM INFANTRY)", defaultWeapon, ogE, bv);
        addElement("Multi-melta", "Multi-melta (SM INFANTRY)", defaultWeapon, ogE, bv);
        addElement("Lascannon", "Lascannon (SM INFANTRY)", defaultWeapon, ogE, bv);
        addElement("Grav-cannon", "Grav-cannon and grav amp", defaultWeapon, ogE, bv);
        addElement("Plasma cannon", "Plasma cannon (SM)", defaultWeapon, ogE, bv);
        return ogE;
    }
}
