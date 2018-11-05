package oc.wh40k.units.ae;



import oc.Eintrag;



public class AETheYncarne extends Eintrag {



    public AETheYncarne() {

        name = "The Yncarne";

        grundkosten = getPts("The Yncarne");

        power = 17;

        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        setUnikat(true);

    }

}