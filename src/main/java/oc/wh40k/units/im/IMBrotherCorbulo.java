package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMBrotherCorbulo extends Eintrag {

    public IMBrotherCorbulo() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, CHARACTER, INFANTRY, SANGUINARY_PRIEST, BROTHER_CORBULO);
        name = "Brother Corbulo";
        grundkosten = getPts("Brother Corbulo");
        power = 5;
        seperator();
        
        addWarlordTraits("Gift of Foresight (BA)", true);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
