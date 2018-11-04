package oc.wh40k.units.dw;

import oc.Eintrag;

public class DWSquadDonatus extends Eintrag {

    public DWSquadDonatus() {
        name = "Squad Donatus";
        grundkosten = 175;

        add(ico = new oc.Picture("oc/wh40k/images/DWSquadDonatus.jpg"));


        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
