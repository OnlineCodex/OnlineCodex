package oc.wh40k.units.im;

import oc.Eintrag;

public class IMBrotherCorbulo extends Eintrag {

    public IMBrotherCorbulo() {
        name = "Brother Corbulo";
        grundkosten = getPts("Brother Corbulo");
        power = 5;
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
