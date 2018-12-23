package oc.wh40k.units.im;

import oc.*;

public class IMPrimarisWolfLord extends Eintrag {
	
    private final RuestkammerStarter waffenUndArtefakte;

    public IMPrimarisWolfLord() {
        name = "Primaris Wolf Lord";
        grundkosten = getPts("Primaris Wolf Lord") + getPts("bolt pistol") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 7;

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, new IMSpaceWolvesRuestkammer("Primaris Wolf Lord"));
        waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen"));
        waffenUndArtefakte.setAbwaehlbar(false);
        add(waffenUndArtefakte);

        seperator();
        
		addWarlordTraits("", true);
        
        complete();
    }

    @Override
    public void refreshen() {
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) waffenUndArtefakte.getPanel().getLocation().getY() + waffenUndArtefakte.getPanel().getSize().height + 5
        );
    }
}