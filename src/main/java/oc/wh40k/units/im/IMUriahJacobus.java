package oc.wh40k.units.im;



import oc.Eintrag;



public class IMUriahJacobus extends Eintrag {



    public IMUriahJacobus() {

        name = "UriahJacobus";

        grundkosten = getPts("UriahJacobus");

        power = 5;



        complete();

    }



    @Override

    public void refreshen() {

        setUnikat(true);

    }

}

