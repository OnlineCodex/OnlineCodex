package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;

public class IMConscripts extends Eintrag {

	private final AnzahlPanel squad;

    public IMConscripts() {
        grundkosten = 0;
        add(ico = new oc.Picture("oc/wh40k/images/IGConscriptsSquad.jpg"));
        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Conscripts", 20, 30, getPts("Conscripts") + getPts("Lasgun") + getPts("Frag grenade (AM)")));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() > 40) {
            power = 6;
        } else if (squad.getModelle() > 30) {
            power = 5;
        } else if (squad.getModelle() > 20) {
            power = 4;
        } else {
            power = 3;
        }
    }

}
