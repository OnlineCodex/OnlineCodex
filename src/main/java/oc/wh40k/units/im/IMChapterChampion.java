package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CHAPTER;
import static oc.KeyWord.CHAPTER_CHAMPION;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;

import oc.Eintrag;

public class IMChapterChampion extends Eintrag {

    public IMChapterChampion() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, CHAPTER_CHAMPION);
        name = "Chapter Champion";
        grundkosten = getPts("Chapter Champion") +
                getPts("Frag grenade (SM)") +
                getPts("Krak grenade (SM)") +
                getPts("Bolt pistol (SM)");
        power = 4;
        seperator();

        addWeapons(IMSpaceMarinesRuestkammer.class, true);

        seperator();

        addWarlordTraits("", true);

        complete();
    }
}
