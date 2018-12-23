package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMWatchCaptaininTerminatorArmour extends Eintrag {

    private final RuestkammerStarter waffenUndReliquien;

    public IMWatchCaptaininTerminatorArmour() {
        name = "Watch Captain";
        grundkosten = getPts("Watch Captain in Terminator Armour");

        add(ico = new oc.Picture("oc/wh40k/images/Kommandant.gif"));

        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, new DeathWatchKammer("Watch Captain in Terminator Armour"));
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        waffenUndReliquien.setAbwaehlbar(false);
        add(waffenUndReliquien);

        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) waffenUndReliquien.getPanel().getLocation().getY() + waffenUndReliquien.getPanel().getSize().height + 5
        );
    }
}