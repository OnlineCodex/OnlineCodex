package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

import static oc.wh40k.units.ch.CHWaffenkammer.ChaosWeaponsOption.SORCERER;

public class CHSorcereronDiscofTzeentch extends Eintrag {

    private final RuestkammerStarter waffen;

    public CHSorcereronDiscofTzeentch() {
        name = "Sorcerer on Disc of Tzeentch";
        grundkosten = getPts("Sorcerer on Disc of Tzeentch");
        power = 8;

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, new CHWaffenkammer(name, "Bolt pistol", "Force sword", true, true, true, false, SORCERER));
        waffen.setButtonText("Waffenkammer");
        waffen.setUeberschriftTrotzNullKostenAusgeben(true);
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
