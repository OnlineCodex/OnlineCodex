package oc.wh40k.units.ae;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class AEIncubi extends Eintrag {

    private final AnzahlPanel squad;

    public AEIncubi() {
        name = "Incubi";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Incubi", 5, 10, getPts("Incubi") + getPts("Klaive"));
        add(squad);

        seperator();

        add(new RuestkammerStarter(ID, randAbstand, cnt, new AEKlaivex(), "Klaivex"));

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() > 5) {
            power = 9;
        } else {
            power = 5;
        }
    }
}