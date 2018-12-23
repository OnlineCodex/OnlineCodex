package oc.wh40k.units.im;

import oc.*;

public class IMWolfPriestinTerminatorArmour extends Eintrag {

    private final RuestkammerStarter waffenUndArtefakte;

    public IMWolfPriestinTerminatorArmour() {
        name = "Wolf Priest in Terminator Armour";
        grundkosten = getPts("Wolf Priest in Terminator Armour") + getPts("crozius arcanum");
        power = 6;

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, new IMSpaceWolvesRuestkammer("Wolf Priest in Terminator Armour"));
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
