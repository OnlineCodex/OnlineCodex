package oc.wh40k.units.ty;



import oc.Eintrag;

public class TYNexos extends Eintrag {


    public TYNexos() {

        name = "Nexos";

        grundkosten = getPts("Nexos") + getPts("Autopistol");

        power = 3;

        complete();

    }

}

