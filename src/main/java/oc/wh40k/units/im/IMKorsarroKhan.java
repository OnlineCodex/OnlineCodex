package oc.wh40k.units.im;



import oc.Eintrag;



public class IMKorsarroKhan extends Eintrag {



    public IMKorsarroKhan() {

        name = "Kor'sarro Khan";

        grundkosten = getPts("Kor'sarro Khan");

        power = 6;

        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        setUnikat(true);

    }

}