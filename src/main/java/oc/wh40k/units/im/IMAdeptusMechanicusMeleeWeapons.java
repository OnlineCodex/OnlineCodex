package oc.wh40k.units.im;



import java.util.Vector;

import oc.BuildaVater;
import oc.OptionsGruppeEintrag;
import oc.RuestkammerElement;



public class IMAdeptusMechanicusMeleeWeapons extends RuestkammerElement {



    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv) {

        final Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();

        addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);

        addElement("Arc maul", "Arc maul", defaultWeapon, ogE, bv);

        addElement("Power sword", "Power sword (AME)", defaultWeapon, ogE, bv);

        addElement("Taser goad", "Taser goad", defaultWeapon, ogE, bv);

        return ogE;

    }



}





