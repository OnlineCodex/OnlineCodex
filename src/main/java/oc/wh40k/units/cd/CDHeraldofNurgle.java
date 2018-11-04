package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDHeraldofNurgle extends Eintrag {

    public CDHeraldofNurgle() {
        name = "Herald of Nurgle";
        grundkosten = getPts("Herald of Nurgle");
        power = 4;

        complete();
    }

    @Override
    public void refreshen() {

    }

}
