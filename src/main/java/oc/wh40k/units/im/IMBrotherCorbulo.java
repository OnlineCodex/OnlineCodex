package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.BLOOD_ANGELS;
import static oc.KeyWord.BROTHER_CORBULO;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.SANGUINARY_PRIEST;

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
