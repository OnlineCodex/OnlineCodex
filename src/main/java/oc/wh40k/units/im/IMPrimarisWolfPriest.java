package oc.wh40k.units.im;

import oc.*;

public class IMPrimarisWolfPriest extends Eintrag {
	
    RuestkammerStarter waffenUndArtefakte;

    public IMPrimarisWolfPriest() {
        name = "Primaris Wolf Priest";
        grundkosten = getPts("Primaris Wolf Priest") + getPts("Crozius arcanum") + getPts("Absolvor bolt pistol") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceWolvesRuestkammer.class, "");
        ((IMSpaceWolvesRuestkammer) waffenUndArtefakte.getKammer()).setType("Primaris Wolf Priest");
        waffenUndArtefakte.initKammer();
        waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen"));
        add(waffenUndArtefakte);
        waffenUndArtefakte.setAbwaehlbar(false);
        
        complete();
    }

    @Override
    public void refreshen() {
        power = 7;
    }
}
