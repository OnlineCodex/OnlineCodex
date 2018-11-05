package oc.wh40k.units.im;



import oc.Eintrag;



public class IMDeathwingChampion extends Eintrag {



    public IMDeathwingChampion() {

        name = "Deathwing Champion";

        grundkosten = getPts("Deathwing Champion") + getPts("Halberd of Caliban");

        power = 6;

        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        setUnikat(true);

    }

}

