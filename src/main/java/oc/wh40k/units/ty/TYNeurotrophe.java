package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;
public class TYNeurotrophe extends Eintrag {

    RuestkammerStarter psychicPowers;
	private RuestkammerStarter waffen;

    public TYNeurotrophe() {
        name = "Neurotrophe";
        grundkosten = getPts("Neurotrophe");
        power = 13;

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).enableHiveMind();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();
        
        waffen = new RuestkammerStarter(ID, randAbstand, cnt, TYRuestkammer.class, "");
        ((TYRuestkammer) waffen.getKammer()).setType("Broodlord");
        waffen.initKammer();
        add(waffen);
        waffen.setButtonText("Wargear");
        waffen.setAbwaehlbar(false);

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

