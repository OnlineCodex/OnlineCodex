package oc.wh40k.units.ae;



import oc.Eintrag;



public class AEUrGhul extends Eintrag {



    public AEUrGhul() {

        name = "Ur-Ghul";

        grundkosten = getPts("Ur-Ghul") + getPts("Claws and talons");

        power = 2;

        seperator();



        complete();

    }



    @Override

    public void refreshen() {

    }

}