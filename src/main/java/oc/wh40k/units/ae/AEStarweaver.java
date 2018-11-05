package oc.wh40k.units.ae;



import oc.Eintrag;



public class AEStarweaver extends Eintrag {



    public AEStarweaver() {

        name = "Starweaver";

        grundkosten = getPts("Starweaver") + 2 * getPts("Shuriken cannon (Harlequins)");

        power = 5;

        seperator();



        complete();

    }



    @Override

    public void refreshen() {

    }

}