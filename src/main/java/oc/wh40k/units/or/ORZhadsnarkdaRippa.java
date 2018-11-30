package oc.wh40k.units.or;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORZhadsnarkdaRippa extends Eintrag {
	

    public ORZhadsnarkdaRippa() {

        kategorie = 1;
        name = "Zhadsnark da Rippa [FW]";
        grundkosten = getPts("Zhadsnark Da Rippa") + getPts("Da Pain Klaw") + getPts("Slugga") + getPts("Stikkbomm") + getPts("Big shoota") * 2;
        power = 7;

        addWarlordTraits("Evil Sunz: Speed Freak", true);
        
        complete();
    }

    public void refreshen() {
        setUnikat(true);
    }
}
