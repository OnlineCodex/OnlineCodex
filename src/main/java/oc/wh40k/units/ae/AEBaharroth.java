package oc.wh40k.units.ae;



import oc.Eintrag;



public class AEBaharroth extends Eintrag {



    public AEBaharroth() {

        name = "Baharroth";

        grundkosten = getPts("Baharroth");

        power = 6;

        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        setUnikat(true);

    }

}