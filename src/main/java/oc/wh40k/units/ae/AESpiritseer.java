package oc.wh40k.units.ae;

import static oc.KeyWord.*;

import oc.Eintrag;

import oc.RuestkammerStarter;

import oc.wh40k.units.PsychicPowers;

public class AESpiritseer extends Eintrag {
	private final RuestkammerStarter psychicPowers;

    public AESpiritseer() {
    	super(AELDARI, ASURYANI, CHARACTER, INFANTRY, AUTARCH, PSYKER, SPIRITSEER);
    	 
        name = "Spiritseer";
        grundkosten = getPts("Spiritseer");
        power = 4;

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