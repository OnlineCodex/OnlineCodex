package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CHChaosLordonPalanquinofNurgle extends Eintrag {

    RuestkammerStarter waffen;
    OptionsUpgradeGruppe mark;

    public CHChaosLordonPalanquinofNurgle() {

        name = "Chaos Lord on Palanquin of Nurgle";
        grundkosten = getPts("Chaos Lord on Palanquin of Nurgle");
        power = 6;

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, CHWaffenkammer.class, "");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultFK("Bolt pistol");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultNK("Chainsword");
        ((CHWaffenkammer) waffen.getKammer()).setChampion(true);
        waffen.initKammer(true, true, true, true);
        waffen.setButtonText("Waffenkammer");
        add(waffen);
        waffen.setAbwaehlbar(false);
        
        seperator();
        
        addWarlordTraits("", true);

        complete();

    }

    @Override
    public void refreshen() {
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) waffen.getPanel().getLocation().getY() + waffen.getPanel().getSize().height + 5
        );
    }
}
