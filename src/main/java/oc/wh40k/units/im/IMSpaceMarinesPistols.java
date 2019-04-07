package oc.wh40k.units.im;

import java.util.Vector;

import oc.BuildaVater;
import oc.OptionsGruppeEintrag;
import oc.RuestkammerElement;

public class IMSpaceMarinesPistols extends RuestkammerElement {

    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv) {
        final Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
        addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);
        addElement("Bolt pistol", "Bolt pistol (SM)", defaultWeapon, ogE, bv);
        addElement("Plasma pistol", "Plasma pistol (SM)", defaultWeapon, ogE, bv);
        addElement("Grav-pistol", "Grav-pistol", defaultWeapon, ogE, bv);
        return ogE;
    }
}
