package oc;



import java.util.Vector;



public class RuestkammerElement {



    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, BuildaVater bv) {

        Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();

        return ogE;

    }



    static public int getPts(String s, BuildaVater buildaVater) {

        s = s.replaceAll(" ", "");

        s = s.replaceAll("-", "");

        s = s.toLowerCase();



        if (buildaVater.pointValues.get(s) == null) {

            System.err.println("getPts - " + s);

            return 0;

        } else {

            return buildaVater.pointValues.get(s);

        }

    }



    static public void addElement(String s, String s2, String defaultWeapon, Vector<OptionsGruppeEintrag> ogE, BuildaVater bv) {

        if (!s.equals(defaultWeapon)) {

            ogE.addElement(new OptionsGruppeEintrag(s, getPts(s2, bv)));

        }

    }



    static public void addElement(String s, String s2, double pts, String defaultWeapon, Vector<OptionsGruppeEintrag> ogE, BuildaVater bv) {

        if (!s.equals(defaultWeapon)) {

            ogE.addElement(new OptionsGruppeEintrag(s, s2, pts));

        }

    }



    static public void addDefault(String s, String s2, Vector<OptionsGruppeEintrag> ogE, BuildaVater bv) {

        if (!s.equals("")) {

            ogE.addElement(new OptionsGruppeEintrag(s, getPts(s2, bv)));

        }

    }

}