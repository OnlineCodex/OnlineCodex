package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;

public class CHPlagueSurgeon extends Eintrag {

    OptionsUpgradeGruppe bell, pp;

    public CHPlagueSurgeon() {

        name = "Plague Surgeon";
        grundkosten = getPts("Plague Surgeon") + getPts("Bolt pistol") + getPts("Balesword") + getPts("Blight grenades") + getPts("Krak grenades");
        power = 4;
        
        seperator();
        
        addWarlordTraits("", true);

        complete();

    }

    @Override
    public void refreshen() {
    }
}
