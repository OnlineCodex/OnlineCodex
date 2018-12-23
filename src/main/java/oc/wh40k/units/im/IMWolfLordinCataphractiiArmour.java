package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMWolfLordinCataphractiiArmour extends Eintrag {

    private final RuestkammerStarter waffenUndArtefakte;

    public IMWolfLordinCataphractiiArmour() {
        name = "Wolf Lord in Cataphractii Armour";
        grundkosten = getPts("Wolf Lord in Cataphractii Armour");
        power = 8;

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
