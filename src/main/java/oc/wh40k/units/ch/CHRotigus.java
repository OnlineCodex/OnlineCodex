package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHRotigus extends Eintrag {

    RuestkammerStarter psychicPowers;

    public CHRotigus() {
        super(CHAOS, NURGLE, DAEMON, CHARACTER, MONSTER, PSYKER, GREAT_UNCLEAN_ONE, ROTIGUS);

        name = "Rotigus";
        grundkosten = getPts("Rotigus");
        power = 17;

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(3);
        ((PsychicPowers) psychicPowers.getKammer()).enableNurgle();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();
        
        addWarlordTraits("Nurgle: Pestilent Miasma", NURGLE);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
