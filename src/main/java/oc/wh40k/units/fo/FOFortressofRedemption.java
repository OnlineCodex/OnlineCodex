package oc.wh40k.units.fo;



import oc.Eintrag;



public class FOFortressofRedemption extends Eintrag {



    public FOFortressofRedemption() {

        name = "Fortress of Redemption";

        grundkosten = getPts("Fortress of Redemption") + getPts("Twin Icarus lascannon") + getPts("Redemption missile silo");

        power = 20;

        seperator();



        complete();

    }



    @Override

    public void refreshen() {

    }

}

