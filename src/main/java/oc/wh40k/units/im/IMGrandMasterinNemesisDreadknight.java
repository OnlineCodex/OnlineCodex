package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.GRAND_MASTER;
import static oc.KeyWord.GREY_KNIGHTS;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.NEMESIS_DREADKNIGHT;
import static oc.KeyWord.PSYKER;
import static oc.KeyWord.VEHICLE;

import oc.*;
import oc.wh40k.units.PsychicPowers;

public class IMGrandMasterinNemesisDreadknight extends Eintrag {

	private final RuestkammerStarter psychicPowers;

    public IMGrandMasterinNemesisDreadknight() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, GREY_KNIGHTS, CHARACTER, VEHICLE, NEMESIS_DREADKNIGHT, PSYKER, GRAND_MASTER);
    	
        name = "Grand Master in Nemesis Dreadknight";
        grundkosten = getPts("Grand Master in Nemesis Dreadknight");

        add(ico = new oc.Picture("oc/wh40k/images/GKNemesisRitter.jpg"));

        seperator();
        
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dreadknight teleporter", getPts("Dreadknight teleporter")));

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
        power = 14;
        
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }

}
