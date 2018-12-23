package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMWolfLordinTerminatorArmour extends Eintrag {

    RuestkammerStarter waffenUndArtefakte;

    public IMWolfLordinTerminatorArmour() {
        name = "Wolf Lord in Terminator Armour";
        grundkosten = getPts("Wolf Lord in Terminator Armour");
        power = 7;
        
        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, new IMSpaceWolvesRuestkammer("Wolf Lord in Terminator Armour"), "");
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
