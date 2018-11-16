package oc.wh40k.units.im;

import oc.*;

public class IMPrimarisRunePriest extends Eintrag {
	
    RuestkammerStarter waffenUndArtefakte;

    public IMPrimarisRunePriest() {
        name = "Primaris Rune Priest";
        grundkosten = getPts("Primaris Rune Priest") + getPts("Runic sword") + getPts("Bolt pistol (SM)") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "");
        ((IMSpaceWolvesRuestkammer) waffenUndArtefakte.getKammer()).setType("Primaris Rune Priest");
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
