package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.PSYKANA;

public class IMWyrdvanePsykers extends Eintrag {

    private final AnzahlPanel squad;

    public IMWyrdvanePsykers() {
        name = "Wyrdvane Psykers";

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Wyrdvane Psyker", 3, 9, getPts("Wyrdvane Psykers") + getPts("Laspistol") + getPts("Wyrdvane stave")));

        seperator();

        addPsychicPowers(1, PSYKANA);

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() > 6) {
            power = 3;
        } else if (squad.getModelle() > 3) {
            power = 2;
        } else {
            power = 1;
        }
    }
}