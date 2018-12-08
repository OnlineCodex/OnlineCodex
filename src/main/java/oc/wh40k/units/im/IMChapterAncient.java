package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMChapterAncient extends Eintrag {
    RuestkammerStarter waffenUndReliquien;

    public IMChapterAncient() {
        name = "Chapter Ancient";
        grundkosten = getPts("Chapter Ancient") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Power sword (SM)");
        power = 5;
        
        seperator();
        
        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
    }
}
