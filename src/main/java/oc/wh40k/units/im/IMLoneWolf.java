package oc.wh40k.units.im;

import oc.*;

public class IMLoneWolf extends Eintrag {

    private final RuestkammerStarter waffenUndArtefakte;

    public IMLoneWolf() {
        name = "Lone Wolf";
        grundkosten = getPts("Lone Wolf");
        power = 5;

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, new IMSpaceWolvesRuestkammer("Lone Wolf"));
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