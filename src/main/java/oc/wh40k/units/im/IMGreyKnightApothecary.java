package oc.wh40k.units.im;

import static oc.KeyWord.*;
import oc.*;
import oc.wh40k.units.PsychicPowers;

public class IMGreyKnightApothecary extends Eintrag {
	private final RuestkammerStarter psychicPowers;

    public IMGreyKnightApothecary() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, GREY_KNIGHTS, CHARACTER, INFANTRY, PSYKER, APOTHECARY, TERMINATOR);
    	
        name = "Apothecary";
        grundkosten = getPts("Apothecary (GK)");

        seperator();
        
        addWeapons(IMGreyKnightsRuestkammer.class, true);
        
        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableSanctic();
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
        power = 5;
        
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}
