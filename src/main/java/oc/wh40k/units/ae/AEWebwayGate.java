package oc.wh40k.units.ae;



import oc.Eintrag;



public class AEWebwayGate extends Eintrag {



    public AEWebwayGate() {

        name = "Webway Gate";

        grundkosten = getPts("Webway Gates");

        power = 6;

        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        setUnique(true);

    }

}