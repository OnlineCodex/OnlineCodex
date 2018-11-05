package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.Eintrag;

//[IA3 2nd Ed]

public class TADX6RemoraDroneFighter extends Eintrag {

    AnzahlPanel squad;

    public TADX6RemoraDroneFighter() {
        name = "DX-6 \'Remora\' Drone Fighter";
        grundkosten = 0;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "DX-6 \'Remora\' Drone Fighter", 1, 5, 90));

        add(ico = new oc.Picture("oc/wh40k/images/DX6RemoraDroneFighter.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
    }

}
