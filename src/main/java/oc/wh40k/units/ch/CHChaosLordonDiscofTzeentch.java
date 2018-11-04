package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CHChaosLordonDiscofTzeentch extends Eintrag {

    RuestkammerStarter waffen;
    OptionsUpgradeGruppe mark;

    public CHChaosLordonDiscofTzeentch() {

        name = "Chaos Lord on Disc of Tzeentch";
        grundkosten = getPts("Chaos Lord on Disc of Tzeentch");
        power = 6;
        complete();

        seperator();

        complete();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, "CHWaffenkammer", "");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultFK("Bolt pistol");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultNK("Chainsword");
        ((CHWaffenkammer) waffen.getKammer()).setChampion(true);
        waffen.initKammer(true, true, true, true);
        waffen.setButtonText("Waffenkammer");
        add(waffen);
        waffen.setAbwaehlbar(false);

    }

    @Override
    public void refreshen() {
    }
}
