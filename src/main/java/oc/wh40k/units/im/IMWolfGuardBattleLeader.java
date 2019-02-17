package oc.wh40k.units.im;

import oc.*;

public class IMWolfGuardBattleLeader extends Eintrag {

	private final OptionsEinzelUpgrade oe1;
	private final RuestkammerStarter waffenUndArtefakte;

    public IMWolfGuardBattleLeader() {
        name = "Wolf Guard Battle Leader";
        grundkosten = getPts("Wolf Guard Battle Leader");

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Pack", getPts("Wolf Guard Battle Leader with Jump Pack") - getPts("Wolf Guard Battle Leader")));

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
        power = 4;
        if (oe1.isSelected()) {
            power += 1;
        }
        
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) waffenUndArtefakte.getPanel().getLocation().getY() + waffenUndArtefakte.getPanel().getSize().height + 5
        );
    }

}
