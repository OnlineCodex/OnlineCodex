package oc.wh40k.units.im;

import oc.*;

public class IMLoneWolfinTerminatorArmour extends Eintrag {

    private final RuestkammerStarter waffenUndArtefakte;

    public IMLoneWolfinTerminatorArmour() {
        name = "Lone Wolf in Terminator Armour";
        grundkosten = getPts("Lone Wolf in Terminator Armour");
        power = 7;

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