package oc.wh40k.units.ae;



import java.util.Vector;

import oc.BuildaVater;
import oc.OptionsGruppeEintrag;
import oc.RuestkammerElement;



public class AEHeavyWeapons extends RuestkammerElement {



    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv) {

        final Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();

        addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);

        addElement("Aeldari missile launcher", "Aeldari missile launcher", defaultWeapon, ogE, bv);

        addElement("Bright lance", "Bright lance", defaultWeapon, ogE, bv);

        addElement("Scatter laser", "Scatter laser", defaultWeapon, ogE, bv);

        addElement("Shuriken cannon", "Shuriken cannon", defaultWeapon, ogE, bv);

        addElement("Starcannon", "Starcannon", defaultWeapon, ogE, bv);

        return ogE;

    }



}





