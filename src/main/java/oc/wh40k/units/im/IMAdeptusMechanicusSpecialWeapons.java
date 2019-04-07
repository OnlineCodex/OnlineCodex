package oc.wh40k.units.im;



import java.util.Vector;

import oc.BuildaVater;
import oc.OptionsGruppeEintrag;
import oc.RuestkammerElement;



public class IMAdeptusMechanicusSpecialWeapons extends RuestkammerElement {



    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv) {

        final Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();

        addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);

        addElement("Arc rifle", "Arc rifle", defaultWeapon, ogE, bv);

        addElement("Plasma caliver", "Plasma caliver", defaultWeapon, ogE, bv);

        addElement("Transuranic arquebus", "Transuranic arquebus", defaultWeapon, ogE, bv);

        return ogE;

    }



}





