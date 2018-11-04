package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDHeraldofSlaaneshonSteed extends Eintrag {

    public CDHeraldofSlaaneshonSteed() {
        name = "Herald of Slaanesh on Steed";
        grundkosten = getPts("Herald of Slaanesh on Steed");
        power = 4;

        complete();
    }

    @Override
    public void refreshen() {

    }

}
