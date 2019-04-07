package oc.wh40k.units.ta;

import oc.Eintrag;

public class TAFiresightMarksman extends Eintrag {


    public TAFiresightMarksman() {
        name = "Firesight Marksman";
        grundkosten = getPts("Firesight Marksman") + getPts("Markerlight") + getPts("Pulse pistol");
        power = 1;
        seperator();

		addWarlordTraits("", true);

        complete();

    }

    //@OVERRIDE
    @Override
	public void refreshen() {
    }
}
