package oc.wh40k.units.im;

import oc.*;

public class IMWolfPriestinTerminatorArmour extends Eintrag {

    RuestkammerStarter waffenUndArtefakte;

    public IMWolfPriestinTerminatorArmour() {
        name = "Wolf Priest in Terminator Armour";
        grundkosten = getPts("Wolf Priest in Terminator Armour") + getPts("crozius arcanum");
        power = 6;

        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceWolvesRuestkammer.class, "");
        ((IMSpaceWolvesRuestkammer) waffenUndArtefakte.getKammer()).setType("Wolf Priest in Terminator Armour");
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
