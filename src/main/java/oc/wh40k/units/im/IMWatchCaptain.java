package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMWatchCaptain extends Eintrag {

    private final RuestkammerStarter waffenUndReliquien;
    private final OptionsEinzelUpgrade pistol;

    public IMWatchCaptain() {
        name = "Watch Captain";
        grundkosten = getPts("Watch Captain");

        add(ico = new oc.Picture("oc/wh40k/images/Kommandant.gif"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump pack", getPts("Watch Captain with Jump Pack") - getPts("Watch Captain")));

        seperator();

        add(pistol = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bolt pistol", getPts("Bolt pistol (DW)")));

        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, new DeathWatchKammer("Watch Captain"));
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        waffenUndReliquien.setAbwaehlbar(false);
        add(waffenUndReliquien);

        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        pistol.setSelected(true);
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) waffenUndReliquien.getPanel().getLocation().getY() + waffenUndReliquien.getPanel().getSize().height + 5
        );
    }

}
