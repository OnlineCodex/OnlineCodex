package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CHAPTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.LIBRARIAN;
import static oc.KeyWord.PRIMARIS;
import static oc.KeyWord.PSYKER;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMPrimarisLibrarian extends Eintrag {
	private final RuestkammerStarter psychicPowers;

    public IMPrimarisLibrarian() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, PRIMARIS, PSYKER, LIBRARIAN);
        name = "Primaris Librarian";
        grundkosten = getPts("Primaris Librarian") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 7;

        seperator();

        if(BuildaHQ.aktBuildaVater.getFormationType().equals("Dark Angels"))
        	addWeapons(IMDarkAngelsRuestkammer.class, true);
        else
        	addWeapons(IMSpaceMarinesRuestkammer.class, true);

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
