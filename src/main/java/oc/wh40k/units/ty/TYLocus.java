package oc.wh40k.units.ty;



import oc.Eintrag;



public class TYLocus extends Eintrag {



    public TYLocus() {

        name = "Locus";

        grundkosten = getPts("Locus") + getPts("Locus blades") + getPts("Hypermorph tail");

        power = 2;

        complete();

    }

}

