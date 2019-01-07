package oc.wh40k.units.ae;

import oc.Eintrag;
import oc.wh40k.units.Source;

import static oc.BuildaHQ.pts;
import static oc.wh40k.units.Publication.IMPERIAL_ARMOUR_XENOS;

@Source(value = IMPERIAL_ARMOUR_XENOS, page = 37)
public class AEReaper extends Eintrag {

    public AEReaper() {
        super("Reaper [FW]", 9,
                pts("Reaper")
                + pts("Storm vortex projector")
                + pts("Scythevanes")
                + pts("Sharpened prow blade"));
        complete();
    }
}