package oc.wh40k.units.dksr;

import oc.AnzahlPanel;
import oc.Eintrag;

public class DKSRCyclopsDemolitionSquadron extends Eintrag {

    AnzahlPanel squad;

    public DKSRCyclopsDemolitionSquadron() {
        name = "Cyclops Demolition Squadron";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Cyclops team", 1, 3, 30);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/DKSRCyclopsDemolitionSquadron.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
    }

}
