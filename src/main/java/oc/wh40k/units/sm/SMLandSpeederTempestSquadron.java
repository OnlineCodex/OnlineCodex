package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.Eintrag;

public class SMLandSpeederTempestSquadron extends Eintrag {

    public SMLandSpeederTempestSquadron() {
        name = "Land Speeder Tempest Squadron";
        grundkosten = 0;

        add(new AnzahlPanel(ID, randAbstand, cnt, "Land Speeder Tempest", 1, 3, 90));

        add(ico = new oc.Picture("oc/wh40k/images/SMLandSpeederTempest.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
    }

}
