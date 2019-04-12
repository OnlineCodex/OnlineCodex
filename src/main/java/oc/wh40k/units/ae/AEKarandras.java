package oc.wh40k.units.ae;



import oc.Eintrag;



public class AEKarandras extends Eintrag {



    public AEKarandras() {

        name = "Karandras";

        grundkosten = getPts("Karandras");

        power = 9;

        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        setUnique(true);

    }

}