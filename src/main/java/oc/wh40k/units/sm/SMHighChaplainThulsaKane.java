package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMHighChaplainThulsaKane extends Eintrag {
    //TODO Executioners only
    public SMHighChaplainThulsaKane() {
        name = "High Chaplain Thulsa Kane";
        grundkosten = 190;
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
