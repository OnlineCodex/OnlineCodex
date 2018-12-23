package oc.wh40k.units.im;

import oc.*;

public class IMIronPriest extends Eintrag {

    private final RuestkammerStarter waffenUndArtefakte;
    
    public IMIronPriest() {
        name = "Iron Priest";
        grundkosten = getPts("Iron Priest") + getPts("Servo-arm") + getPts("Tempest hammer") + getPts("Helfrost pistol");
        power = 5;

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
