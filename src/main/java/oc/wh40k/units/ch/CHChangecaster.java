package oc.wh40k.units.ch;

import static oc.KeyWord.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DISCIPLINE_OF_TZEENTCH;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHChangecaster extends Eintrag {

    private final RuestkammerStarter psychicPowers;

    public CHChangecaster() {
        super(CHAOS, TZEENTCH, DAEMON, CHARACTER, INFANTRY, HORROR, PSYKER, HERALD_OF_TZEENTCH, CHANGECASTER);
        name = "Changecaster";
        grundkosten = getPts("Changecaster");
        power = 4;

        addWeapons(new CHWaffenkammerCD(name, getKeywords()), false);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(2, DISCIPLINE_OF_TZEENTCH), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

        seperator();
        
        addWarlordTraits("", TZEENTCH);

        complete();

    }

    @Override
    public void refreshen() {
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}
