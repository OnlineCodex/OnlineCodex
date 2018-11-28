package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CHSorcereronDiscofTzeentch extends Eintrag {

    RuestkammerStarter waffen;
    OptionsUpgradeGruppe mark;

    public CHSorcereronDiscofTzeentch() {

        name = "Sorcerer on Disc of Tzeentch";
        grundkosten = getPts("Sorcerer on Disc of Tzeentch");
        power = 8;
        complete();

        seperator();

        complete();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, CHWaffenkammer.class, "");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultFK("Bolt pistol");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultNK("Force sword");
        ((CHWaffenkammer) waffen.getKammer()).setSorcerer(true);
        waffen.initKammer(true, true, true, false);
        waffen.setButtonText("Waffenkammer");
        waffen.setUeberschriftTrotzNullKostenAusgeben(true);
        add(waffen);
        waffen.setAbwaehlbar(false);

    }

    @Override
    public void refreshen() {
    }
}
