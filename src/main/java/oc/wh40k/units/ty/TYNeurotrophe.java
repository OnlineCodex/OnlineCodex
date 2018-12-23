package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.HIVE_MIND;

public class TYNeurotrophe extends Eintrag {

    private final RuestkammerStarter psychicPowers;
	private final RuestkammerStarter waffen;

    public TYNeurotrophe() {
        name = "Neurotrophe";
        grundkosten = getPts("Neurotrophe");
        power = 13;

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(1, HIVE_MIND), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

        seperator();
        
        waffen = new RuestkammerStarter(ID, randAbstand, cnt, new TYRuestkammer("Broodlord"));
        waffen.setButtonText("Wargear");
        waffen.setAbwaehlbar(false);
        add(waffen);

        seperator();
        
		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
    	waffen.getPanel().setLocation(
                (int) waffen.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    	
    	warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) waffen.getPanel().getLocation().getY() + waffen.getPanel().getSize().height + 5
        );
    }
}