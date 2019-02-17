package oc.wh40k.units.ne;



import oc.Eintrag;



public class NEGaussPylon extends Eintrag {



    public NEGaussPylon() {

        name = "Gauss Pylon";

        grundkosten = getPts("Gauss Pylon") + getPts("Gauss annihilator") + getPts("Tesla arc");

        power = 24;

        seperator();



        complete();

    }




}