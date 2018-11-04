package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMCaptainSilasAlberec extends Eintrag {

    public SMCaptainSilasAlberec() {
        name = "Captain Silas Alberec";
        grundkosten = 185;
        add(ico = new oc.Picture("oc/wh40k/images/SMKorsarroKhan.gif"));

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);

    }

}
