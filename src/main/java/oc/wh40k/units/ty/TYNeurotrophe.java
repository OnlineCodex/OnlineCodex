//IA Xenos + FAQ 1.0

package oc.wh40k.units.ty;



import oc.AnzahlPanel;

import oc.Eintrag;

import oc.RuestkammerStarter;

import oc.wh40k.units.PsychicPowers;



public class TYNeurotrophe extends Eintrag {



    AnzahlPanel squad;

    RuestkammerStarter psychicPowers;



    public TYNeurotrophe() {

        name = "Neurotrophe";

        grundkosten = getPts("Neurotrophe");



        seperator();



        add(ico = new oc.Picture("oc/wh40k/images/TYMalanthrope.jpg"));



        seperator();



        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");

        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);

        ((PsychicPowers) psychicPowers.getKammer()).enableHiveMind();

        psychicPowers.initKammer();

        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);

        add(psychicPowers);

        psychicPowers.setAbwaehlbar(true);



        complete();

    }



    @Override

    public void refreshen() {

        power = 13;

    }



}

