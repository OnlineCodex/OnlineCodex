package oc.wh40k.units.necrons;



import oc.Eintrag;



public class NEKutlakhtheWorldKiller extends Eintrag {



    public NEKutlakhtheWorldKiller() {

        name = "Kutlakh the World Killer";

        grundkosten = getPts("Kutlakh the World Killer");

        power = 10;

        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        setUnikat(true);

    }

}