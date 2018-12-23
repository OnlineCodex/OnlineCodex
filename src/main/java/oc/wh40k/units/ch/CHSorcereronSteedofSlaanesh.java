package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

import static oc.wh40k.units.ch.CHWaffenkammer.ChaosWeaponsOption.SORCERER;

public class CHSorcereronSteedofSlaanesh extends Eintrag {

    private final RuestkammerStarter waffen;

    public CHSorcereronSteedofSlaanesh() {
        name = "Sorcerer on Steed of Slaanesh";
        grundkosten = getPts("Sorcerer on Steed of Slaanesh");
        power = 7;

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, new CHWaffenkammer(name, "Bolt pistol", "Force sword", true, true, true, false, SORCERER));
        waffen.setButtonText("Waffenkammer");
        waffen.setAbwaehlbar(false);
        add(waffen);

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
