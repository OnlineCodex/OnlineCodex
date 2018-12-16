package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import oc.Eintrag;

public class CHEpidemius extends Eintrag {

    public CHEpidemius() {
        super(CHAOS, NURGLE, DAEMON, CHARACTER, CAVALRY, HERALD_OF_NURGLE, PLAGUEBEARER, EPIDEMIUS);

        name = "Epidemius";
        grundkosten = getPts("Epidemius");
        power = 5;

        add(ico = new oc.Picture("oc/wh40k/images/CDEpidemius.gif"));
        
        seperator();
        
        addWarlordTraits("Nurgle: Virulent Touch", NURGLE);

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
