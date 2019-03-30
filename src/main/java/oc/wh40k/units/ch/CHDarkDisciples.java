package oc.wh40k.units.ch;


import oc.*;

public class CHDarkDisciples extends Eintrag {

	private final AnzahlPanel squad;

    public CHDarkDisciples() {
        name = "Dark Disciples";
        grundkosten = 0;
        power = 1;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Dark Disciples", 2, 2, getPts("Dark Disciples"), "");
        add(squad);

        seperator();

        complete();
    }

}
