package oc.wh40k.units.im;

import oc.*;

public class IMWolfPriestonBike extends Eintrag {

    private final RuestkammerStarter waffenUndArtefakte;

    public IMWolfPriestonBike() {
        name = "Wolf Priest on Bike";
        grundkosten = getPts("Wolf Priest on Bike") + getPts("crozius arcanum");
        power = 7;

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, new IMSpaceWolvesRuestkammer("Wolf Priest"));
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