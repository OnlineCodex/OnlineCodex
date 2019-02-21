package oc.wh40k.units.ae;



import oc.Eintrag;



public class AETantalus extends Eintrag {



    public AETantalus() {

        name = "Tantalus";

        grundkosten = getPts("Tantalus") + 2 * getPts("Pulse-disintegrator") + getPts("Dire scythe blade");

        power = 18;

        seperator();



        complete();

    }

}