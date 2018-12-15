package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.Eintrag;

public class CHEpidemius extends Eintrag {

    public CHEpidemius() {

        name = "Epidemius";
        grundkosten = getPts("Epidemius");
        power = 5;
        setKeywords(ImmutableSet.of(CHAOS, NURGLE, DAEMON, CHARACTER, CAVALRY, HERALD_OF_NURGLE, PLAGUEBEARER, EPIDEMIUS));

        add(ico = new oc.Picture("oc/wh40k/images/CDEpidemius.gif"));
        
        seperator();
        
        addWarlordTraits("Nurgle: Virulent Touch", true, NURGLE);

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
