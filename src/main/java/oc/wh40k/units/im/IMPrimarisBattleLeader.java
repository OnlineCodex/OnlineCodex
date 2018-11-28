package oc.wh40k.units.im;

import oc.*;

public class IMPrimarisBattleLeader extends Eintrag {
	
    RuestkammerStarter waffenUndArtefakte;

    public IMPrimarisBattleLeader() {
        name = "Primaris Battle Leader";
        grundkosten = getPts("Primaris Battle Leader") + getPts("bolt pistol") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 4;
        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceWolvesRuestkammer.class, "");
        ((IMSpaceWolvesRuestkammer) waffenUndArtefakte.getKammer()).setType("Primaris Battle Leader");
        waffenUndArtefakte.initKammer();
        waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen"));
        add(waffenUndArtefakte);
        waffenUndArtefakte.setAbwaehlbar(false);
        
        complete();
    }
}
