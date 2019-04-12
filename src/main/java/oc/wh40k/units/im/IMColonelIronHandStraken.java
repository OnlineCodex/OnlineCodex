package oc.wh40k.units.im;

import oc.Eintrag;

public class IMColonelIronHandStraken extends Eintrag {

    public IMColonelIronHandStraken() {
        name = "Colonel 'Iron Hand' Straken";
        grundkosten = getPts("Colonel 'Iron Hand' Straken");
        power = 5;

        seperator();

        addWarlordTraits("Catachan: Lead From the Front");

        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        setUnique(true);
    }
}