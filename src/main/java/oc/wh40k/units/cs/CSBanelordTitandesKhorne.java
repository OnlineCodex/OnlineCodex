package oc.wh40k.units.cs;

import oc.Eintrag;

public class CSBanelordTitandesKhorne extends Eintrag {

    public CSBanelordTitandesKhorne() {
        name = "Banelord-Titan des Khorne";
        grundkosten = 2500;

        add(ico = new oc.Picture("oc/wh40k/images/BanelordTitandesKhorne.gif"));


        complete();

    }

    public void refreshen() {
    }
}
