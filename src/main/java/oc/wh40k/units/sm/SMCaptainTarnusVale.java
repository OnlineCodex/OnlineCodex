package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMCaptainTarnusVale extends Eintrag {

    public SMCaptainTarnusVale() {
        //TODO Ultramarines only
        name = "Captain Tarnus Vale";
        grundkosten = 165;
        add(ico = new oc.Picture("oc/wh40k/images/CaptainLysander.gif"));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
