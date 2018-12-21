package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class TYTheSwarmlord extends Eintrag {

    RuestkammerStarter psychicPowers;

    public TYTheSwarmlord() {
        name = "The Swarmlord";
        grundkosten = getPts("TheSwarmlord");
        power = 15;

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableHiveMind();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        seperator();
        
		addWarlordTraits("Alien Cunning", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
