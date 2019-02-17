package oc.wh40k.units.ne;



import oc.Eintrag;



public class NENightShroud extends Eintrag {



    public NENightShroud() {

        name = "Night Shroud";

        grundkosten = getPts("Night Shroud") + getPts("Twin tesla destructor");

        power = 13;

        seperator();



        complete();

    }



}