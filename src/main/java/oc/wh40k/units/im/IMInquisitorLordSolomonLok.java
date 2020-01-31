package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMInquisitorLordSolomonLok extends Eintrag {


    public IMInquisitorLordSolomonLok() {
    	super(IMPERIUM, INQUISITION, ORDO_XENOS);
        name = "Inquisitor-Lord Solomon Lok";
        grundkosten = getPts("Inquisitor-Lord Solomon Lok");
        power = 4;

        seperator();
  
		addWarlordTraits("Ordo Xenos: Esoteric Law", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
