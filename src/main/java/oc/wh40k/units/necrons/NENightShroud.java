package oc.wh40k.units.necrons;



import oc.Eintrag;



public class NENightShroud extends Eintrag {



    public NENightShroud() {

        name = "Night Shroud";

        grundkosten = getPts("Night Shroud") + getPts("Twin tesla destructor");

        power = 13;

        seperator();



        complete();

    }



    @Override

    public void refreshen() {

    }

}