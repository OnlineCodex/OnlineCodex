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
        add(ico = new oc.Picture("oc/wh40k/images/TYDerSchwarmherrscher.jpg"));

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableHiveMind();
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
