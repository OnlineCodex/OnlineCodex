package oc.wh40k.units.ch;

import static oc.KeyWord.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DISCIPLINE_OF_TZEENTCH;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHTheChangeling extends Eintrag {

    public CHTheChangeling() {
        super(CHAOS, TZEENTCH, DAEMON, CHARACTER, INFANTRY, PSYKER, HERALD_OF_TZEENTCH, HORROR, THE_CHANGELING);

        name = "The Changeling";
        grundkosten = getPts("The Changeling");
        power = 5;

        seperator();

        RuestkammerStarter psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(1, DISCIPLINE_OF_TZEENTCH), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

        seperator();
        
        addWarlordTraits("Tzeentch: Incorporeal Form", TZEENTCH);

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
