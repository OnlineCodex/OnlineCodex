package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.CHRONUS;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.ULTRAMARINES;

import oc.Eintrag;

public class IMSergeantChronus extends Eintrag {

    public IMSergeantChronus() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, ULTRAMARINES, CHARACTER, INFANTRY, CHRONUS);

        name = "Sergeant Chronus";
        grundkosten = getPts("Sergeant Chronus");
        power = 3;

        seperator();

        addWarlordTraits("Ultramarines: Adept of the Codex");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }

}
