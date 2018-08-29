package oc.wh40k.units.or;

import oc.Eintrag;

public class ORNobwithWaaaghBanner extends Eintrag {

    public ORNobwithWaaaghBanner() {
        name = "Nob with Waaagh! Banner";
        grundkosten = getPts("Nob with Waaagh! Banner") + getPts("Kustom shoota") + getPts("Stikkbombs");
        power = 4;

        add(ico = new oc.Picture("oc/wh40k/images/Waaghboss.gif"));
     
        complete();
    }

    @Override
    public void refreshen() {}

}
