package oc.wh40k.units.im;



import oc.BuildaVater;

import oc.OptionsGruppeEintrag;

import oc.RuestkammerElement;



import java.util.Vector;



public class IMAstraMilitarumRangedWeapons extends RuestkammerElement {



    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv) {

        Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();

        addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);

        addElement("Bolt pistol", "Bolt pistol (AM)", defaultWeapon, ogE, bv);

        addElement("Boltgun", "Boltgun (AM)", defaultWeapon, ogE, bv);

        addElement("Plasma pistol", "Plasma pistol (AM)", defaultWeapon, ogE, bv);

        return ogE;

    }



}





