package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHMagnustheRed extends Eintrag {

    RuestkammerStarter psychicPowers;

    public CHMagnustheRed() {

        name = "Magnus the Red";
        grundkosten = getPts("Magnus the Red");
        power = 21;

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(3);
        ((PsychicPowers) psychicPowers.getKammer()).enableChange();
        ((PsychicPowers) psychicPowers.getKammer()).enableDarkHereticus();
        ((PsychicPowers) psychicPowers.getKammer()).enableTzeentch();
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
