package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.HIVE_MIND;

public class TYBroodlord extends Eintrag {

    private final RuestkammerStarter waffen;

    public TYBroodlord() {
        name = "Broodlord";
        grundkosten = getPts("Broodlord");
        power = 8;

        add(ico = new oc.Picture("oc/wh40k/images/TYBroodlord.jpg"));

        seperator();

        addPsychicPowers(1, HIVE_MIND);

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
