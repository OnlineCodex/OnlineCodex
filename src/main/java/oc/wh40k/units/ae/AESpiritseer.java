package oc.wh40k.units.ae;

import static oc.KeyWord.AELDARI;
import static oc.KeyWord.ASURYANI;
import static oc.KeyWord.AUTARCH;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.PSYKER;
import static oc.KeyWord.SPIRITSEER;

import oc.BuildaHQ;
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

        if(BuildaHQ.aktBuildaVater.getFormationType().equals("Ynnari"))
        	addWeapons(AEYnnariRuestkammer.class, true);
        else
        	addWeapons(AECraftworldRuestkammer.class, true);
        
        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        if(BuildaHQ.aktBuildaVater.getFormationType().equals("Ynnari"))
        	((PsychicPowers) psychicPowers.getKammer()).enableRevenant();
        else
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