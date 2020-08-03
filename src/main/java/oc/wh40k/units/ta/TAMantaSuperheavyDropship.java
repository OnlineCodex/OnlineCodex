package oc.wh40k.units.ta;



import oc.Eintrag;



public class TAMantaSuperheavyDropship extends Eintrag {



    public TAMantaSuperheavyDropship() {



        name = "Manta Super-heavy Dropship";



        grundkosten = getPts("Manta Super-heavy Dropship") + 2 * getPts("Heavy rail cannon") + 6 * getPts("Long-barrelled ion cannon") + 2 * getPts("Missile pod")

                + 16 * getPts("Long-barrelled burst cannon (anderes Modell)") + 10 * getPts("Seeker missile");



        complete();



    }



    //@OVERRIDE

    @Override
	public void refreshen() {

        power = 100;

    }

}