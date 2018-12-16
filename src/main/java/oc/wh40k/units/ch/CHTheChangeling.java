package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHTheChangeling extends Eintrag {

    RuestkammerStarter psychicPowers;

    public CHTheChangeling() {
        super(CHAOS, TZEENTCH, DAEMON, CHARACTER, INFANTRY, PSYKER, HERALD_OF_TZEENTCH, HORROR, THE_CHANGELING);

        name = "The Changeling";
        grundkosten = getPts("The Changeling");
        power = 5;

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).enableTzeentch();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();
        
        addWarlordTraits("Tzeentch: Incorporeal Form", TZEENTCH);

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
