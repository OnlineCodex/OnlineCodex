package oc.wh40k.units.im;

import oc.BuildaVater;

import oc.OptionsGruppeEintrag;

import oc.RuestkammerElement;



import java.util.Vector;

public class IMSpaceMarinesCombiWeapons extends RuestkammerElement {

    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv) {
        Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
        addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);
        addElement("Combi-flamer", "Combi-flamer", defaultWeapon, ogE, bv);
        addElement("Combi-grav", "Combi-grav", defaultWeapon, ogE, bv);
        addElement("Combi-melta", "Combi-melta", defaultWeapon, ogE, bv);
        addElement("Combi-plasma", "Combi-plasma", defaultWeapon, ogE, bv);
        addElement("Storm bolter", "Storm bolter (SM)", defaultWeapon, ogE, bv);
        return ogE;
    }
}