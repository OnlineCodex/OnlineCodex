package oc.wh40k.units.ae;



import oc.Eintrag;



public class AEPrinceYriel extends Eintrag {



    public AEPrinceYriel() {

        name = "Prince Yriel";

        grundkosten = getPts("Prince Yriel");

        power = 5;

        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        setUnikat(true);

    }

}