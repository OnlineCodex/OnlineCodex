package oc.wh40k.units.im;

import oc.*;

public class IMWolfPriest extends Eintrag {

    private final OptionsEinzelUpgrade oe1;
    private final RuestkammerStarter waffenUndArtefakte;

    public IMWolfPriest() {
        name = "Wolf Priest";
        grundkosten = getPts("Wolf Priest") + getPts("crozius arcanum");

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Pack", getPts("Wolf Priest with Jump Pack") - getPts("Wolf Priest")));

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
        power = 5;
        if (oe1.isSelected()) {
            power += 1;
        }
        
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) waffenUndArtefakte.getPanel().getLocation().getY() + waffenUndArtefakte.getPanel().getSize().height + 5
        );
    }
}