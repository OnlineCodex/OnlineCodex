package oc.wh40k.units.im;



import java.util.Vector;

import oc.BuildaVater;
import oc.OptionsGruppeEintrag;
import oc.RuestkammerElement;



public class IMAdeptusMechanicusPistolWeapons extends RuestkammerElement {



    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv) {

        final Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();

        addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);

        addElement("Arc pistol", "Arc pistol", defaultWeapon, ogE, bv);

        addElement("Phosphor blast pistol", "Phosphor blast pistol", defaultWeapon, ogE, bv);

        addElement("Radium pistol", "Radium pistol", defaultWeapon, ogE, bv);

        return ogE;

    }



}





