package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMPrimarisApothecary extends Eintrag {
    RuestkammerStarter waffenUndReliquien;

    public IMPrimarisApothecary() {
        name = "Primaris Apothecary";
        grundkosten = getPts("Primaris Apothecary") + 
        			  getPts("Frag grenade (SM)") + 
        			  getPts("Krak grenade (SM)") + 
        			  getPts("Absolver bolt pistol") + 
        			  getPts("Reductor pistol");
        
        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceMarinesRuestkammer.class, "");
        ((IMSpaceMarinesRuestkammer) waffenUndReliquien.getKammer()).setType("Apothecary");
        waffenUndReliquien.initKammer();
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);

        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 4;
    }
}
