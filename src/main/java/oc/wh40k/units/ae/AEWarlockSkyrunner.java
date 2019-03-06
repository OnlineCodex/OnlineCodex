package oc.wh40k.units.ae;

import static oc.KeyWord.*;

import oc.Eintrag;

import oc.RuestkammerStarter;

import oc.wh40k.units.PsychicPowers;

public class AEWarlockSkyrunner extends Eintrag {
	private final RuestkammerStarter psychicPowers;

    public AEWarlockSkyrunner() {
       	super(AELDARI, ASURYANI, CHARACTER, INFANTRY, PSYKER, WARLOCK, WARLOCK_SKYRUNNER, BIKER);
       	
        name = "Warlock Skyrunner";
        grundkosten = getPts("Warlock Skyrunner") + getPts("Twin shuriken catapult");

        seperator();

        addWeapons(AECraftworldRuestkammer.class, true);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).enableRunesOfBattle();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();

        addWarlordTraits("", true);

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

