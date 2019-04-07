package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;

public class IMOgryns extends Eintrag {

	private final AnzahlPanel squad;

	public IMOgryns() {
        name = "Ogryns";
        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Ogryns", 3, 9, getPts("Ogryns") + getPts("Ripper gun") + getPts("Frag bomb")));
        complete();
    }

    @Override
    public void refreshen() {
        power = 4;
        if (squad.getModelle() > 6) {
            power = 12;
        } else if (squad.getModelle() > 3) {
            power = 8;
        }
    }
}