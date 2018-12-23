package oc.wh40k.units.im;

import oc.*;

public class IMPrimarisWolfPriest extends Eintrag {
	
    private final RuestkammerStarter waffenUndArtefakte;

    public IMPrimarisWolfPriest() {
        name = "Primaris Wolf Priest";
        grundkosten = getPts("Primaris Wolf Priest") + getPts("Crozius arcanum") + getPts("Absolvor bolt pistol") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 7;

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, new IMSpaceWolvesRuestkammer(name));
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
