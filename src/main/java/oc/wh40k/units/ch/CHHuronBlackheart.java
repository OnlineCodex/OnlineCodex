package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DARK_HERETICUS;

public class CHHuronBlackheart extends Eintrag {

    private final RuestkammerStarter psychicPowers;

    public CHHuronBlackheart() {
        name = "Huron Blackheart";
        grundkosten = getPts("Huron Blackheart");
        power = 7;

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(1, DARK_HERETICUS), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

        seperator();

        addWarlordTraits("Eternal Vendetta", true);

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