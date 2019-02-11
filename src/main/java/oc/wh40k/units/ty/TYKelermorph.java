package oc.wh40k.units.ty;



import oc.Eintrag;

public class TYKelermorph extends Eintrag {


    public TYKelermorph() {

        name = "Kelermorph";

        grundkosten = getPts("Kelermorph") + 3 * getPts("Liberator autostub") + getPts("Cultist knife");

        power = 3;

        complete();

    }

}

