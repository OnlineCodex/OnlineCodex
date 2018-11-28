package oc.wh40k.units.im;

import oc.*;

public class IMPrimarisWolfLord extends Eintrag {
	
    RuestkammerStarter waffenUndArtefakte;

    public IMPrimarisWolfLord() {
        name = "Primaris Wolf Lord";
        grundkosten = getPts("Primaris Wolf Lord") + getPts("bolt pistol") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 7;
        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceWolvesRuestkammer.class, "");
        ((IMSpaceWolvesRuestkammer) waffenUndArtefakte.getKammer()).setType("Primaris Wolf Lord");
        waffenUndArtefakte.initKammer();
        waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen"));
        add(waffenUndArtefakte);
        waffenUndArtefakte.setAbwaehlbar(false);
        
        complete();
    }

    @Override
    public void refreshen() {
    }
}
