package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMDeathwatchChaplain extends Eintrag {

    private final OptionsEinzelUpgrade jump;
    private final RuestkammerStarter waffenUndReliquien;

    public IMDeathwatchChaplain() {
        name = "Chaplain";
        grundkosten = getPts("Chaplain") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Crozius arcanum");

        seperator();

        add(jump = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Pack", getPts("Chaplain with Jump Pack") - getPts("Chaplain")));

        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, new DeathWatchKammer("Chaplain"));
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        waffenUndReliquien.setAbwaehlbar(false);
        add(waffenUndReliquien);

        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 5 + (jump.isSelected() ? 1 : 0);
        
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) waffenUndReliquien.getPanel().getLocation().getY() + waffenUndReliquien.getPanel().getSize().height + 5
        );
    }
}