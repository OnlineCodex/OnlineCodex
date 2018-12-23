package oc.wh40k.units.ch;

import static oc.KeyWord.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DARK_HERETICUS;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHBeLakor extends Eintrag {

    private final RuestkammerStarter psychicPowers;

    public CHBeLakor() {
        super(CHAOS, DAEMON, CHARACTER, MONSTER, DAEMON_PRINCE, FLY, PSYKER, BE_LAKOR);
        name = "Be'Lakor";
        grundkosten = getPts("Be'Lakor");
        power = 12;

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(2, DARK_HERETICUS), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

        seperator();
        
        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
        
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}
