package oc.wh40k.units.im;

import oc.*;

public class IMIronPriest extends Eintrag {

    RuestkammerStarter waffenUndArtefakte;
    
    public IMIronPriest() {
        name = "Iron Priest";
        grundkosten = getPts("Iron Priest") + getPts("Servo-arm") + getPts("Tempest hammer") + getPts("Helfrost pistol");
        power = 5;

        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceWolvesRuestkammer.class, "");
        ((IMSpaceWolvesRuestkammer) waffenUndArtefakte.getKammer()).setType("Iron Priest");
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
