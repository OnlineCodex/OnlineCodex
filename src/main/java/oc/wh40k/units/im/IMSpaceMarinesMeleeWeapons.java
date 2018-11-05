package oc.wh40k.units.im;



import oc.BuildaVater;

import oc.OptionsGruppeEintrag;

import oc.RuestkammerElement;



import java.util.Vector;



public class IMSpaceMarinesMeleeWeapons extends RuestkammerElement {



    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv) {

        Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();

        addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);

        addElement("Chainsword", "Chainsword (SM)", defaultWeapon, ogE, bv);

        addElement("Power sword", "Power sword (SM)", defaultWeapon, ogE, bv);

        addElement("Power axe", "Power axe (SM)", defaultWeapon, ogE, bv);

        addElement("Power maul", "Power maul (SM)", defaultWeapon, ogE, bv);

        addElement("Power lance", "Power lance (SM)", defaultWeapon, ogE, bv);

        addElement("Power fist", "Power fist (SM)", defaultWeapon, ogE, bv);

        addElement("Lightning claw", "Lightning claw (single)", defaultWeapon, ogE, bv);

        addElement("Thunder hammer", "Thunder hammer (others)", defaultWeapon, ogE, bv);

        return ogE;

    }



}





