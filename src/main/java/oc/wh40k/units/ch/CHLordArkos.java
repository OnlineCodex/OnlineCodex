package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHLordArkos extends Eintrag {

    public CHLordArkos() {

        name = "Lord Arkos";
        grundkosten = getPts("Lord Arkos") +
        			  getPts("The Black Blade of Venom") +
        			  getPts("combi-melta") +
        			  getPts("frag grenades") +
        			  getPts("krak grenades");
        power = 7;

        complete();

    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}
