package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;

public class NEDestroyers extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsEinzelZaehler oe1;

    public NEDestroyers() {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Destroyer", "Destroyers", 1, 6, getPts("Destroyers") + getPts("Gauss cannon"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/NEDestroyers.jpg"));

        seperator();

        add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Heavy Destroyer", "Upgrade zum Heavy Destroyer", 0, getPts("Heavy Destroyers") - getPts("Destroyers") + getPts("Heavy gauss cannon") - getPts("Gauss cannon")));

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() >= 3) {
            oe1.setMaxAnzahl(1);
        } else {
            oe1.setMaxAnzahl(0);
        }

        power = 3 * squad.getModelle();
    }

}
