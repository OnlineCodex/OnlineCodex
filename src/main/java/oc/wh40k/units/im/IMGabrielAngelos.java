package oc.wh40k.units.im;



import oc.Eintrag;



public class IMGabrielAngelos extends Eintrag {



    public IMGabrielAngelos() {

        name = "Gabriel Angelos";

        grundkosten = getPts("Gabriel Angelos");

        power = 9;

        complete();

    }



    @Override

    public void refreshen() {

        setUnique(true);

    }



}

