package oc.wh40k.units.im;

import oc.BuildaVater;
import oc.OptionsGruppeEintrag;
import oc.RuestkammerElement;

import java.util.Vector;

public class IMSpaceWolvesHeavyWeapons extends RuestkammerElement {

    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv) {
        Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
        addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);
        addElement("Missile launcher", "Missile launcher (SM)", defaultWeapon, ogE, bv);
        addElement("Heavy bolter", "Heavy bolter (SM)", defaultWeapon, ogE, bv);
        addElement("Multi-melta", "Multi-melta (SM)", defaultWeapon, ogE, bv);
        addElement("Lascannon", "Lascannon (SM)", defaultWeapon, ogE, bv);
        addElement("Plasma cannon", "Plasma cannon (SM)", defaultWeapon, ogE, bv);
        return ogE;
    }

}


