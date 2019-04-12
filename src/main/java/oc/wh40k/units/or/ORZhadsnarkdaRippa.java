package oc.wh40k.units.or;

import oc.Eintrag;

public class ORZhadsnarkdaRippa extends Eintrag {


    public ORZhadsnarkdaRippa() {

        category = 1;
        name = "Zhadsnark da Rippa [FW]";
        grundkosten = getPts("Zhadsnark Da Rippa") + getPts("Da Pain Klaw") + getPts("Slugga") + getPts("Stikkbomm") + getPts("Big shoota") * 2;
        power = 7;

        addWarlordTraits("Evil Sunz: Speed Freak");

        complete();
    }

    @Override
	public void refreshen() {
        setUnique(true);
    }
}
