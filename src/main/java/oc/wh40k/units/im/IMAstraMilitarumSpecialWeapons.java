package oc.wh40k.units.im;



import java.util.Vector;

import oc.BuildaVater;
import oc.OptionsGruppeEintrag;
import oc.RuestkammerElement;



public class IMAstraMilitarumSpecialWeapons extends RuestkammerElement {



    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv) {

        final Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();

        addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);

        addElement("Sniper Rifle", "Sniper Rifle (AM)", defaultWeapon, ogE, bv);

        addElement("Flamer", "Flamer (AM)", defaultWeapon, ogE, bv);

        addElement("Grenade Launcher", "Grenade Launcher", defaultWeapon, ogE, bv);

        addElement("Meltagun", "Meltagun (AM)", defaultWeapon, ogE, bv);

        addElement("Plasma gun", "Plasma gun (AM)", defaultWeapon, ogE, bv);

        return ogE;

    }



}





