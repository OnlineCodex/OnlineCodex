package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CHSorcereronPalanquinofNurgle extends Eintrag {

    RuestkammerStarter waffen;
    OptionsUpgradeGruppe mark;

    public CHSorcereronPalanquinofNurgle() {

        name = "Sorcerer on Palanquin of Nurgle";
        grundkosten = getPts("Sorcerer on Palanquin of Nurgle");
        power = 8;
        complete();

        seperator();

        complete();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, "CHWaffenkammer", "");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultFK("Bolt pistol");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultNK("Force sword");
        ((CHWaffenkammer) waffen.getKammer()).setSorcerer(true);
        waffen.initKammer(true, true, true, false);
        waffen.setButtonText("Waffenkammer");
        add(waffen);
        waffen.setAbwaehlbar(false);

    }

    @Override
    public void refreshen() {
    }
}
