package oc.wh40k.units.im;

import oc.Eintrag;

public class IMMasterofOrdnance extends Eintrag {

    public IMMasterofOrdnance() {
        name = "Master Of Ordnance";
        grundkosten = getPts("Master Of Ordnance") + getPts("Laspistol");
        power = 2;

        add(ico = new oc.Picture("oc/wh40k/images/IGCaptainThanstadt.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
    }
}