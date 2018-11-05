package oc.wh40k.units.ae;



import oc.Eintrag;



public class AEMedusae extends Eintrag {



    public AEMedusae() {

        name = "Medusae";

        grundkosten = getPts("Medusae") + getPts("Eyeburst");

        power = 2;

        seperator();



        complete();

    }



    @Override

    public void refreshen() {

    }

}