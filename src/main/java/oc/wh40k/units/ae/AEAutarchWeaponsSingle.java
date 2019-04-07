package oc.wh40k.units.ae;



import java.util.Vector;

import oc.BuildaVater;
import oc.OptionsGruppeEintrag;
import oc.RuestkammerElement;



public class AEAutarchWeaponsSingle extends RuestkammerElement {



    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv) {

        final Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();

        addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);

        addElement("Fusion gun", "Fusion gun", defaultWeapon, ogE, bv);

        addElement("Lasblaster", "Lasblaster", defaultWeapon, ogE, bv);

        addElement("Reaper launcher", "Reaper launcher", defaultWeapon, ogE, bv);

        return ogE;

    }

}





