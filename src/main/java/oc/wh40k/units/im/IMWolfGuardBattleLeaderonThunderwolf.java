package oc.wh40k.units.im;

import oc.*;

public class IMWolfGuardBattleLeaderonThunderwolf extends Eintrag {

    private final RuestkammerStarter waffenUndArtefakte;

    public IMWolfGuardBattleLeaderonThunderwolf() {
        name = "Wolf Guard Battle Leader on Thunderwolf";
        grundkosten = getPts("Wolf Guard Battle Leader on Thunderwolf");
        power = 6;

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, new IMSpaceWolvesRuestkammer("Wolf Guard Battle Leader"));
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
