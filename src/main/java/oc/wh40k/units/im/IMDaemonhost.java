package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMDaemonhost extends Eintrag {

    public IMDaemonhost() {
    	super(IMPERIUM, INQUISITION, ORDO_MALLEUS);
        name = "Daemonhost";
        grundkosten = getPts("Daemonhost");
        power = 1;

        complete();
    }

    @Override
    public void refreshen() {
    }

}
