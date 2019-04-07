package oc.wh40k.units.ta;



import oc.Eintrag;



public class TAOrcaDropship extends Eintrag {



    public TAOrcaDropship() {



        name = "Orca Dropship";



        grundkosten = getPts("Orca Dropship") + 2 * getPts("Long-barrelled burst cannon") + getPts("Missile pod");



        complete();



    }



    //@OVERRIDE

    @Override
	public void refreshen() {

        power = 14;

    }

}