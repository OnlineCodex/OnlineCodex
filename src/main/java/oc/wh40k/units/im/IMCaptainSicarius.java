package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CAPTAIN;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.SICARIUS;
import static oc.KeyWord.ULTRAMARINES;

import oc.Eintrag;

public class IMCaptainSicarius extends Eintrag {

    public IMCaptainSicarius() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, ULTRAMARINES, CHARACTER, INFANTRY, CAPTAIN, SICARIUS);

    	name = "Captain Sicarius";
        grundkosten = getPts("Captain Sicarius");
        power = 7;

        seperator();

        addWarlordTraits("Ultramarines: Adept of the Codex");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}
