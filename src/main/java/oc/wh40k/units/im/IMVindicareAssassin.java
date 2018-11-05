package oc.wh40k.units.im;



import oc.Eintrag;



public class IMVindicareAssassin extends Eintrag {



    public IMVindicareAssassin() {

        name = "Vindicare Assassin";

        grundkosten = getPts("Vindicare Assassin");

        power = 5;



        complete();

    }



    @Override

    public void refreshen() {

    }

}

