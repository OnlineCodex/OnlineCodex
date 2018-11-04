package oc.wh40k.units.ae;

import oc.Eintrag;

public class AEReaper extends Eintrag {

    public AEReaper() {
        name = "Reaper";
        grundkosten = getPts("Reaper") + getPts("Storm vortex projector") + getPts("Scythevanes") + getPts("Sharpened prow blade");
        power = 9;
        seperator();

        complete();
    }

    @Override
    public void refreshen() {
    }
}