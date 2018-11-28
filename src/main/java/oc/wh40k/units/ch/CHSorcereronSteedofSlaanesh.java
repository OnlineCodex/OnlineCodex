package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CHSorcereronSteedofSlaanesh extends Eintrag {

    RuestkammerStarter waffen;
    OptionsUpgradeGruppe mark;

    public CHSorcereronSteedofSlaanesh() {

        name = "Sorcerer on Steed of Slaanesh";
        grundkosten = getPts("Sorcerer on Steed of Slaanesh");
        power = 7;

        seperator();

        complete();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, CHWaffenkammer.class, "");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultFK("Bolt pistol");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultNK("Force sword");
        ((CHWaffenkammer) waffen.getKammer()).setSorcerer(true);
        waffen.initKammer(true, true, true, false);
        waffen.setButtonText("Waffenkammer");
        add(waffen);
        waffen.setAbwaehlbar(false);

        complete();
    }
}
