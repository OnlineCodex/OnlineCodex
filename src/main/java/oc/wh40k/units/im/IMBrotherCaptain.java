package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.*;
import oc.wh40k.units.PsychicPowers;

public class IMBrotherCaptain extends Eintrag {
    private final RuestkammerStarter psychicPowers;

    public IMBrotherCaptain() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, GREY_KNIGHTS, CHARACTER, INFANTRY, PSYKER, BROTHER_CAPTAIN);
    	
        name = "Brother Captain";
        grundkosten = getPts("Brother Captain") + getPts("Frag grenades (SM)") + getPts("Krak grenades (SM)") + getPts("Psyk-out grenades (SM)");

        add(ico = new oc.Picture("oc/wh40k/images/GKBruderCaptainderGreyKnights.jpg"));

        seperator();

        addWeapons(IMGreyKnightsRuestkammer.class, true);
        
        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
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
        power = 9;
        
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}
