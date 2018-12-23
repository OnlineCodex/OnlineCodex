package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.im.ImperiumUtils.getPsychicPowerGroug;

public class IMDeathwatchLibrarian extends Eintrag {

    private final OptionsEinzelUpgrade jump;
    private final RuestkammerStarter waffenUndReliquien;
    private final RuestkammerStarter psychicPowers;

    public IMDeathwatchLibrarian() {
        name = "Librarian";
        grundkosten = getPts("Librarian") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        seperator();

        add(jump = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Pack", getPts("Librarian with Jump Pack") - getPts("Librarian")));

        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, new DeathWatchKammer("Librarian"), "");
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        waffenUndReliquien.setAbwaehlbar(false);
        add(waffenUndReliquien);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(2, getPsychicPowerGroug(checkBuildaVater())), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(false);
        add(psychicPowers);

        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 6 + (jump.isSelected() ? 1 : 0);

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
