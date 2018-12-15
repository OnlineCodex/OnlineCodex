package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.Eintrag;

public class CHSkarbrand extends Eintrag {

    public CHSkarbrand() {

        name = "Skarbrand";
        grundkosten = getPts("Skarbrand");
        power = 19;
        setKeywords(ImmutableSet.of(CHAOS, KHORNE, DAEMON, CHARACTER, MONSTER, BLOODTHIRSTER, SKARBRAND));
        
        seperator();
        
        addWarlordTraits("Khorne: Rage Incarnate", true, KHORNE);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
