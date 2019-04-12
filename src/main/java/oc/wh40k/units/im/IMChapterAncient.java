package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.ANCIENT;
import static oc.KeyWord.CHAPTER;
import static oc.KeyWord.CHAPTER_ANCIENT;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;

import oc.Eintrag;

public class IMChapterAncient extends Eintrag {

    public IMChapterAncient() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, ANCIENT, CHAPTER_ANCIENT);
        name = "Chapter Ancient";
        grundkosten = getPts("Chapter Ancient") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Power sword (SM)");
        power = 5;

        seperator();

        addWeapons(IMSpaceMarinesRuestkammer.class, true);

        seperator();

        addWarlordTraits("");

        complete();
    }
}
