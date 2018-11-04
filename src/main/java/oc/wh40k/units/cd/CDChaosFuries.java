package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.Eintrag;

public class CDChaosFuries extends Eintrag {

    AnzahlPanel furies;

    public CDChaosFuries() {

        name = "Chaos Furies";
        grundkosten = 0;
        power = 3;

        add(furies = new AnzahlPanel(ID, randAbstand, cnt, "Chaos Furies", 5, 20, getPts("Chaos Furies")));

        complete();

    }

    public void deleteYourself() {
    }


    @Override
    public void refreshen() {
        power = furies.getModelle();
    }
}
