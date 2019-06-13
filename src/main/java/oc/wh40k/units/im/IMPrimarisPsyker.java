package oc.wh40k.units.im;

import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.PRIMARIS_PSYKER;
import static oc.KeyWord.PSYKER;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMPrimarisPsyker extends Eintrag {
	private final RuestkammerStarter psychicPowers;

    public IMPrimarisPsyker() {
    	super(CHARACTER, INFANTRY, PSYKER, PRIMARIS_PSYKER);

        name = "Primaris Psyker";
        grundkosten = getPts("Primaris Psyker") + getPts("Laspistol") + getPts("Force stave");
        power = 2;

        seperator();

        addWeapons(IMAstraMilitarumRuestkammer.class, true);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).enablePsykana();
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();
        
		addWarlordTraits("", true);

        complete();
    }
}