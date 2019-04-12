package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CHAPTER_MASTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.FLY;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.JUMP_PACK;
import static oc.KeyWord.KAYVAAN_SHRIKE;
import static oc.KeyWord.RAVEN_GUARD;

import oc.Eintrag;

public class IMKayvaanShrike extends Eintrag {

    public IMKayvaanShrike() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, RAVEN_GUARD, CHARACTER, INFANTRY, CHAPTER_MASTER, JUMP_PACK, FLY, KAYVAAN_SHRIKE);

        name = "Kayvaan Shrike";
        grundkosten = getPts("Kayvaan Shrike");
        power = 8;

        seperator();

        addWarlordTraits("Raven Guard: Silent Stalker");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}