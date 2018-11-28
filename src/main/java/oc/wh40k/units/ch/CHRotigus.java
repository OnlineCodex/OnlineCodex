package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHRotigus extends Eintrag {

    RuestkammerStarter psychicPowers;

    public CHRotigus() {

        name = "Rotigus";
        grundkosten = getPts("Rotigus");
        power = 17;
        complete();

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(3);
        ((PsychicPowers) psychicPowers.getKammer()).enableNurgle();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
