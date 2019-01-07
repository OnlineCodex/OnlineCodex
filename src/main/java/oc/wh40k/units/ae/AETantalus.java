package oc.wh40k.units.ae;

import oc.Eintrag;
import oc.wh40k.units.Source;

import static oc.BuildaHQ.pts;
import static oc.wh40k.units.Publication.IMPERIAL_ARMOUR_XENOS;

@Source(value = IMPERIAL_ARMOUR_XENOS, page = 37)
public class AETantalus extends Eintrag {

    public AETantalus() {
        super("Tantalus", 18,
                pts("Tantalus")
                + 2 * pts("Pulse-disintegrator")
                + pts("Dire scythe blade"));
        complete();
    }
}