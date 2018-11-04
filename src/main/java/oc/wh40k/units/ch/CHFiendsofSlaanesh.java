package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;

public class CHFiendsofSlaanesh extends Eintrag {

    AnzahlPanel fiends;

    public CHFiendsofSlaanesh() {

        name = "Fiends of Slaanesh";
        grundkosten = 0;
        power = 5;

        add(fiends = new AnzahlPanel(ID, randAbstand, cnt, "Fiends of Slaanesh", 1, 9, getPts("Fiends of Slaanesh")));

        complete();

    }

    public void deleteYourself() {
    }


    @Override
    public void refreshen() {
        power = fiends.getModelle() * 2;
    }
}
