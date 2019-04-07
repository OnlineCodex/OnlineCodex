package oc.wh40k.units.im;



import java.util.Vector;

import oc.BuildaVater;
import oc.OptionsGruppeEintrag;
import oc.RuestkammerElement;



public class IMSpaceMarinesTerminatorMeleeWeapons extends RuestkammerElement {



    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv) {

        final Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();

        addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);

        addElement("Lightning claw", "Lightning claw (single)", defaultWeapon, ogE, bv);

        addElement("Power fist", "Power fist (SM)", defaultWeapon, ogE, bv);

        addElement("Thunder hammer", "Thunder hammer (others)", defaultWeapon, ogE, bv);

        addElement("Storm shield", "Storm shield (others)", defaultWeapon, ogE, bv);

        return ogE;

    }



}





