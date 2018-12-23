package oc.wh40k.units.im;

import static oc.KeyWord.*;

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
        
        addWeapons(new IMSpaceMarinesRuestkammer(name, getKeywords()), true);

        seperator();

        addWarlordTraits("", true);

        complete();
    }
}