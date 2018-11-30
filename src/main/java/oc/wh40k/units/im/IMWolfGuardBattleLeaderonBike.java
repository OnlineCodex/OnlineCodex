package oc.wh40k.units.im;

import oc.*;

public class IMWolfGuardBattleLeaderonBike extends Eintrag {
	
    RuestkammerStarter waffenUndArtefakte;

    public IMWolfGuardBattleLeaderonBike() {
        name = "Wolf Guard Battle Leader on Bike";
        grundkosten = getPts("Wolf Guard Battle Leader on Bike");
        power = 6;
        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceWolvesRuestkammer.class, "");
        ((IMSpaceWolvesRuestkammer) waffenUndArtefakte.getKammer()).setType("Wolf Guard Battle Leader");
        waffenUndArtefakte.initKammer();
        waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen"));
        add(waffenUndArtefakte);
        waffenUndArtefakte.setAbwaehlbar(false);

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
