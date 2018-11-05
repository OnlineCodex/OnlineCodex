package oc.wh40k.units.ae;



import oc.Eintrag;



public class AEFuegan extends Eintrag {



    public AEFuegan() {

        name = "Fuegan";

        grundkosten = getPts("Fuegan");

        power = 8;

        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        setUnikat(true);

    }

}