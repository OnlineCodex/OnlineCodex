package oc.wh40k.units.necrons;



import oc.Eintrag;



public class NEGaussPylon extends Eintrag {



    public NEGaussPylon() {

        name = "Gauss Pylon";

        grundkosten = getPts("Gauss Pylon") + getPts("Gauss annihilator") + getPts("Tesla arc");

        power = 24;

        seperator();



        complete();

    }



    @Override

    public void refreshen() {

    }

}