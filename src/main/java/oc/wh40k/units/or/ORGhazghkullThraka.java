package oc.wh40k.units.or;

import oc.Eintrag;

public class ORGhazghkullThraka extends Eintrag {


    public ORGhazghkullThraka() {

        category = 1;
        name = "Ghazghkull Thraka";
        grundkosten = getPts("Ghazghkull Thraka");
        power = 12;

        seperator();

        addWarlordTraits("Goffs: Proper Killy");

        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        setUnique(true);
    }
}
