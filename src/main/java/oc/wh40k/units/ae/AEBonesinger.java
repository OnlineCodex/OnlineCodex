package oc.wh40k.units.ae;



import oc.Eintrag;


public class AEBonesinger extends Eintrag {



    public AEBonesinger() {

        name = "Bonesinger";

        grundkosten = getPts("Bonesinger");

        power = 4;



        complete();

    }



    @Override

    public void refreshen() {

    }

}

