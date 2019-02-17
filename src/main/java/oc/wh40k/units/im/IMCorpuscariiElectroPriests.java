package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;

public class IMCorpuscariiElectroPriests extends Eintrag {

	private final AnzahlPanel squad;

    public IMCorpuscariiElectroPriests() {
        name = "Corpuscarii Electro-Priests";

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Corpuscarii Electro-Priests", 5, 20, getPts("Corpuscarii Electro-Priests") + getPts("Electrostatic gauntlets"));
        add(squad);

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        power = 3;
        if (squad.getModelle() > 15) {
            power = 12;
        } else if (squad.getModelle() > 10) {
            power = 9;
        } else if (squad.getModelle() > 5) {
            power = 6;
        }
    }
}
