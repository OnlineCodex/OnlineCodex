package oc.wh40k.units.im;



import oc.BuildaVater;

import oc.OptionsGruppeEintrag;

import oc.RuestkammerElement;



import java.util.Vector;



public class IMSpaceMarinesTerminatorHeavyWeapons extends RuestkammerElement {



    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv) {

        Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();

        addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);

        addElement("Heavy flamer", "Heavy flamer (SM)", defaultWeapon, ogE, bv);

        addElement("Assault cannon", "Assault cannon", defaultWeapon, ogE, bv);

        addElement("Cyclone ML + SB", "Cyclone Missile launcher + Storm bolter", (double) (getPts("Cyclone Missile launcher", bv) + getPts("Storm bolter (SM)", bv)), defaultWeapon, ogE, bv);

//		addElement("Plasma cannon", "Plasma cannon (SM)", defaultWeapon, ogE, bv);

        return ogE;

    }



}





