package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.Eintrag;

public class TATetraScoutSpeederTeam extends Eintrag {

    AnzahlPanel squad;

    public TATetraScoutSpeederTeam() {
        name = "Tetra Scout Speeder Team";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Tetra Scout Speeder Team", 2, 4, getPts("Tetra Scout Speeder") + 2 * getPts("Pulse rifle") + getPts("High intensity markerlight"));
        add(squad);

        complete();
    }

    @Override
    public void refreshen() {
        power = 4 + 3 * (squad.getModelle() - 2);
    }
}
