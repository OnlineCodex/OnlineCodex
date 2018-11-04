package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.Eintrag;

public class NEDeathmarks extends Eintrag {

    AnzahlPanel squad;

    public NEDeathmarks() {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Deathmarks", 5, 10, getPts("Deathmarks") + getPts("Synaptic disintegrator"));
        add(squad);

        complete();
    }

    @Override
    public void refreshen() {
        power = 5 + ((squad.getModelle() > 5) ? 4 : 0);
    }

}
