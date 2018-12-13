package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMChapterAncient extends Eintrag {
    RuestkammerStarter waffenUndReliquien;

    public IMChapterAncient() {
        name = "Chapter Ancient";
        grundkosten = getPts("Chapter Ancient") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Power sword (SM)");
        power = 5;
        
        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceMarinesRuestkammer.class, "");
        ((IMSpaceMarinesRuestkammer) waffenUndReliquien.getKammer()).setType("Chapter Ancient");
        waffenUndReliquien.initKammer();
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);
        
        seperator();
        
        addWarlordTraits("", true);

        complete();
    }
}
