package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDHeraldofKhorne extends Eintrag {

    public CDHeraldofKhorne() {
        name = "Herald of Khorne";
        grundkosten = getPts("Herald of Khorne");
        power = 3;

        complete();
    }

    @Override
    public void refreshen() {

    }

}
