package oc.wh40k.units.ty;



import oc.Eintrag;



public class TYClamavus extends Eintrag {



    public TYClamavus() {

        name = "Clamavus";

        grundkosten = getPts("Clamavus") + getPts("Autopistol");

        power = 3;

        complete();

    }

}

