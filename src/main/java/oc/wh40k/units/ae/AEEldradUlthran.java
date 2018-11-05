package oc.wh40k.units.ae;



import oc.Eintrag;

import oc.RuestkammerStarter;

import oc.wh40k.units.PsychicPowers;



public class AEEldradUlthran extends Eintrag {



    RuestkammerStarter psychicPowers;



    public AEEldradUlthran() {

        name = "Eldrad Ulthran";

        grundkosten = getPts("Eldrad Ulthran");

        power = 9;



        seperator();



        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");

        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(3);

        ((PsychicPowers) psychicPowers.getKammer()).enableRunesOfFate();

        psychicPowers.initKammer();

        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);

        add(psychicPowers);

        psychicPowers.setAbwaehlbar(true);



        complete();

    }



    @Override

    public void refreshen() {

        setUnikat(true);

    }

}