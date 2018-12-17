package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;

public class IMChapterChampion extends Eintrag {
    OptionsUpgradeGruppe o1, o2;

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
