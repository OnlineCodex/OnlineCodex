package oc.wh40k.units.ae;



import oc.Eintrag;



public class AETheVisarch extends Eintrag {



    public AETheVisarch() {

        name = "The Visarch";

        grundkosten = getPts("The Visarch");

        power = 7;

        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        setUnikat(true);

    }

}