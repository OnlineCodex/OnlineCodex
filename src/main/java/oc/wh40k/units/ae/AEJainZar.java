package oc.wh40k.units.ae;



import oc.Eintrag;



public class AEJainZar extends Eintrag {



    public AEJainZar() {

        name = "Jain Zar";

        grundkosten = getPts("Jain Zar");

        power = 7;

        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        setUnique(true);

    }

}