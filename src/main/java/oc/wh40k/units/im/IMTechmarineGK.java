package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMTechmarineGK extends Eintrag {

	private final RuestkammerStarter psychicPowers;

    public IMTechmarineGK() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, GREY_KNIGHTS, CHARACTER, INFANTRY, PSYKER, TECHMARINE);
    	
        name = "Techmarine GK";
        grundkosten = getPts("Techmarine (GK)") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

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
        power = 5;
        
    	psychicPowers.getPanel().setLocation(
                (int) psychicPowers.getPanel().getLocation().getX(),
                (int) getWeapons().getPanel().getLocation().getY() + getWeapons().getPanel().getSize().height + 5
        );
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}
