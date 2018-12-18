package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMLibrarianinTerminatorArmour extends Eintrag {
    RuestkammerStarter psychicPowers;

    public IMLibrarianinTerminatorArmour() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, TERMINATOR, PSYKER, LIBRARIAN);
        name = "Librarian in Terminator Armour";
        grundkosten = getPts("Librarian in Terminator Armour");
        power = 8;

        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        if (!buildaVater.getFormationType().equals("Dark Angels") && !buildaVater.getFormationType().equals("Blood Angels"))
            ((PsychicPowers) psychicPowers.getKammer()).enableLibrarius();
        if (buildaVater.getFormationType().equals("Blood Angels"))
            ((PsychicPowers) psychicPowers.getKammer()).enableSanguinary();
        if (buildaVater.getFormationType().equals("Dark Angels"))
            ((PsychicPowers) psychicPowers.getKammer()).enableInterromancy();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
