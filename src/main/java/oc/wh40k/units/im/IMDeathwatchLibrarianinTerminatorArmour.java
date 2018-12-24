package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.im.ImperiumUtils.getPsychicPowerGroug;

public class IMDeathwatchLibrarianinTerminatorArmour extends Eintrag {

    private final RuestkammerStarter waffenUndReliquien;

    public IMDeathwatchLibrarianinTerminatorArmour() {
        name = "Librarian in Terminator Armour";
        grundkosten = getPts("Librarian in Terminator Armour");
        power = 8;

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, new DeathWatchKammer(name), "");
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        waffenUndReliquien.setAbwaehlbar(false);
        add(waffenUndReliquien);

        seperator();

        addPsychicPowers(2, getPsychicPowerGroug(checkBuildaVater()));

        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        psychicPowers.getPanel().setLocation(
                (int) psychicPowers.getPanel().getLocation().getX(),
                (int) waffenUndReliquien.getPanel().getLocation().getY() + waffenUndReliquien.getPanel().getSize().height + 5
        );
        
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}