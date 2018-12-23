package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

import static oc.wh40k.units.ch.CHWaffenkammer.ChaosWeaponsOption.CHAMPION;

public class CHChaosLordonJuggernautofKhorne extends Eintrag {

    private final RuestkammerStarter waffen;

    public CHChaosLordonJuggernautofKhorne() {
        name = "Chaos Lord on Juggernaut of Khorne";
        grundkosten = getPts("Chaos Lord on Juggernaut of Khorne") + getPts("Juggernaut's bladed horn");
        power = 7;

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, new CHWaffenkammer(name,"Bolt pistol", "Chainsword", true, true, true, true, CHAMPION));
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
