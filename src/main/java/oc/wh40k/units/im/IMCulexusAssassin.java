package oc.wh40k.units.im;



import oc.Eintrag;



public class IMCulexusAssassin extends Eintrag {



    public IMCulexusAssassin() {

        name = "Culexus Assassin";

        grundkosten = getPts("Culexus Assassin");

        power = 5;



        complete();

    }



    @Override

    public void refreshen() {

    }

}

