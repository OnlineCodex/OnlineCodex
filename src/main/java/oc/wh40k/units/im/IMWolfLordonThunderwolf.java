package oc.wh40k.units.im;

import oc.*;

public class IMWolfLordonThunderwolf extends Eintrag {

    private final RuestkammerStarter waffenUndArtefakte;

    public IMWolfLordonThunderwolf() {
        name = "Wolf Lord on Thunderwolf";
        grundkosten = getPts("Wolf Lord on Thunderwolf");
        power = 7;

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, new IMSpaceWolvesRuestkammer(name), "");
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