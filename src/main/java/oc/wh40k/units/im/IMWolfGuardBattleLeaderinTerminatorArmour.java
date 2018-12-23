package oc.wh40k.units.im;

import oc.*;

public class IMWolfGuardBattleLeaderinTerminatorArmour extends Eintrag {
	
	private final RuestkammerStarter waffenUndArtefakte;

    public IMWolfGuardBattleLeaderinTerminatorArmour() {
        name = "Wolf Guard Battle Leader in Terminator Armour";
        grundkosten = getPts("Wolf Guard Battle Leader in Terminator Armour");
        power = 6;
        seperator();

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
