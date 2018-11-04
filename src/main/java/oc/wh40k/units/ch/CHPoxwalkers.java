package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CHPoxwalkers extends Eintrag {

    AnzahlPanel walkers;
    OptionsEinzelUpgrade reaper;

    public CHPoxwalkers() {

        name = "Poxwalkers";
        grundkosten = 0;
        power = 5;

        add(walkers = new AnzahlPanel(ID, randAbstand, cnt, "Poxwalkers", 10, 20, getPts("Poxwalkers")));

        complete();

    }

    public void deleteYourself() {
    }


    @Override
    public void refreshen() {
        power = 3 +
                ((walkers.getModelle() == 20) ? 3 : 0);
    }
}
