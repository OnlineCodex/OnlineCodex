package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDSchaedelkanonedesKhorne extends Eintrag {


    public CDSchaedelkanonedesKhorne() {

        name = "Schädelkanone des Khorne";

        grundkosten = 125;

        add(ico = new oc.Picture("oc/wh40k/images/CDSeelenzermalmer.gif"));

        complete();

    }

    @Override
    public void refreshen() {
    }
}
