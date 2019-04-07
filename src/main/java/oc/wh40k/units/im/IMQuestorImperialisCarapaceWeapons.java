package oc.wh40k.units.im;



import java.util.Vector;

import oc.BuildaVater;
import oc.OptionsGruppeEintrag;
import oc.RuestkammerElement;



public class IMQuestorImperialisCarapaceWeapons extends RuestkammerElement {



    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv) {

        final Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();

        addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);

        addElement("Twin icarus autocannon", "Twin icarus autocannon", defaultWeapon, ogE, bv);

        addElement("Stormspear rocket pod", "Stormspear rocket pod", defaultWeapon, ogE, bv);

        addElement("Ironstorm missile pod", "Ironstorm missile pod", defaultWeapon, ogE, bv);

        return ogE;

    }



}





