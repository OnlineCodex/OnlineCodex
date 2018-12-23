package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMChapterAncient extends Eintrag {

    public IMChapterAncient() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, ANCIENT, CHAPTER_ANCIENT);
        name = "Chapter Ancient";
        grundkosten = getPts("Chapter Ancient") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Power sword (SM)");
        power = 5;
        
        seperator();
        
        addWeapons(new IMSpaceMarinesRuestkammer(name, getKeywords()), true);
        
        seperator();
        
        addWarlordTraits("", true);

        complete();
    }
}
