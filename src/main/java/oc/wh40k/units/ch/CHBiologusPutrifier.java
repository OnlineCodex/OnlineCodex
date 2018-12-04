package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;

public class CHBiologusPutrifier extends Eintrag {

    OptionsUpgradeGruppe bell, pp;

    public CHBiologusPutrifier() {

        name = "Biologus Putrifier";
        grundkosten = getPts("Biologus Putrifier") + getPts("Injector pistol") + getPts("Plague knife") + getPts("Hyper blight grenades") + getPts("Krak grenades");
        power = 4;
        
        seperator();
        
        addWarlordTraits("", true);

        complete();

    }

    @Override
    public void refreshen() {
    }
}
