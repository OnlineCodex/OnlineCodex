package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import oc.Eintrag;

public class CHSkarbrand extends Eintrag {

    public CHSkarbrand() {
        super(CHAOS, KHORNE, DAEMON, CHARACTER, MONSTER, BLOODTHIRSTER, SKARBRAND);

        name = "Skarbrand";
        grundkosten = getPts("Skarbrand");
        power = 18;

        seperator();
        
        addWarlordTraits("Khorne: Rage Incarnate", KHORNE);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
