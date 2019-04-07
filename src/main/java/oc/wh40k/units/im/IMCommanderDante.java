package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.BLOOD_ANGELS;
import static oc.KeyWord.CHAPTER_MASTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.COMMANDER_DANTE;
import static oc.KeyWord.FLY;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.JUMP_PACK;

import oc.Eintrag;

public class IMCommanderDante extends Eintrag {

    public IMCommanderDante() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, CHARACTER, INFANTRY, CHAPTER_MASTER, JUMP_PACK, FLY, COMMANDER_DANTE);
        name = "Commander Dante";
        grundkosten = getPts("Commander Dante");
        power = 11;

        seperator();

        addWarlordTraits("Heroic Bearing (BA)", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
