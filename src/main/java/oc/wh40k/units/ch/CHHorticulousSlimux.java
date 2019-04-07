package oc.wh40k.units.ch;

import static oc.KeyWord.CAVALRY;
import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.HERALD_OF_NURGLE;
import static oc.KeyWord.HORTICULOUS_SLIMUX;
import static oc.KeyWord.NURGLE;
import static oc.KeyWord.PLAGUEBEARER;

import oc.Eintrag;

public class CHHorticulousSlimux extends Eintrag {

    public CHHorticulousSlimux() {
        super(CHAOS, NURGLE, DAEMON, CHARACTER, CAVALRY, HERALD_OF_NURGLE, PLAGUEBEARER, HORTICULOUS_SLIMUX);
        name = "Horticulous Slimux";
        grundkosten = getPts("Horticulous Slimux");
        power = 9;

        seperator();

        addWarlordTraits("Nurgle: Acidic Ichor", true);

        complete();
    }
}
