package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.Eintrag;

public class TAMV71SniperDrones extends Eintrag {

	private final AnzahlPanel squad;

    public TAMV71SniperDrones() {
        name = "MV71 Sniper Drones";

        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "MV71 Sniper Drones", 3, 9, getPts("MV71 Sniper Drone") + getPts("Longshot pulse rifle"));
        add(squad);

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() > 6) {
            power = 8;
        } else if (squad.getModelle() > 3) {
            power = 6;
        } else {
            power = 3;
        }
    }

}
