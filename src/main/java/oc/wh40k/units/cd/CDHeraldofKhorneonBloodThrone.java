package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDHeraldofKhorneonBloodThrone extends Eintrag {

    public CDHeraldofKhorneonBloodThrone() {
        name = "Herald of Khorne on Blood Throne";
        grundkosten = getPts("Herald of Khorne on Blood Throne");
        power = 6;

        complete();
    }

    @Override
    public void refreshen() {

    }

}
