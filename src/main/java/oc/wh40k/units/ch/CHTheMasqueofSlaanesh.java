package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.DAEMONETTE;
import static oc.KeyWord.HERALD_OF_SLAANESH;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.SLAANESH;
import static oc.KeyWord.THE_MASQUE_OF_SLAANESH;

import oc.Eintrag;

public class CHTheMasqueofSlaanesh extends Eintrag {

    public CHTheMasqueofSlaanesh() {
        super(CHAOS, SLAANESH, DAEMON, CHARACTER, INFANTRY, DAEMONETTE, HERALD_OF_SLAANESH, THE_MASQUE_OF_SLAANESH);

        name = "The Masque of Slaanesh";
        grundkosten = getPts("The Masque of Slaanesh");
        power = 4;

        seperator();

        addWarlordTraits("Slaanesh: The Murderdance", SLAANESH);

        complete();
    }

    @Override
    public void refreshen() {
    	setUnique(true);
    }
}
