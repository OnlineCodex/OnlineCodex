package oc.wh40k.units.ty;



import oc.Eintrag;
import oc.OptionsEinzelZaehler;



public class TYGoliathTruck extends Eintrag {



    public TYGoliathTruck() {

        name = "Goliath Truck";

        grundkosten = getPts("Goliath Truck") + getPts("Heavy stubber") + getPts("Twin autocannon");

        power = 4;



        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Cache of demolition charges", 1, getPts("Cache of demolition charges")));



        complete();

    }



    @Override

    public void refreshen() {

    }

}