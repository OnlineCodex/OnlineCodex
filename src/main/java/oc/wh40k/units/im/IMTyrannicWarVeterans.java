package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;

public class IMTyrannicWarVeterans extends Eintrag {

	private final AnzahlPanel squad;

    public IMTyrannicWarVeterans() {
        name = "Tyrannic War Veterans\n";
        grundkosten = 0;
        applyTitle = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Tyrannic War Veterans", 4, 10, getPts("Tyrannic War Veterans") +
                getPts("Special issue boltgun") +
                getPts("Bolt pistol (SM)"));
        add(squad);

        complete();
    }

    @Override
    public void refreshen() {

        power = 5;
        if (squad.getModelle() > 4) {
            power = 11;
        }
    }

}
