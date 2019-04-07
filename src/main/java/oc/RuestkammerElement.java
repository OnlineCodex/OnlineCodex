package oc;

import java.util.Vector;

public class RuestkammerElement {

    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, BuildaVater bv) {
        final Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
        return ogE;
    }

    static public void addElement(String s, String s2, String defaultWeapon, Vector<OptionsGruppeEintrag> ogE, BuildaVater bv) {
        if (!s.equals(defaultWeapon)) {
            ogE.addElement(new OptionsGruppeEintrag(s, bv.getPts(s2)));
        }
    }

    static public void addElement(String s, String s2, double pts, String defaultWeapon, Vector<OptionsGruppeEintrag> ogE, BuildaVater bv) {
        if (!s.equals(defaultWeapon)) {
            ogE.addElement(new OptionsGruppeEintrag(s, s2, pts));
        }
    }

    static public void addDefault(String s, String s2, Vector<OptionsGruppeEintrag> ogE, BuildaVater bv) {
        if (!s.equals("")) {
            ogE.addElement(new OptionsGruppeEintrag(s, bv.getPts(s2)));
        }
    }

}