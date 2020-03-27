package oc.wh40k.units.im;

import oc.Eintrag;

public class IMThunderfireCannon extends Eintrag {

    public IMThunderfireCannon() {
        name = "Thunderfire Cannon";
        grundkosten = getPts("Thunderfire Cannon") +
                getPts("Thunderfire Cannon - Techmarine Gunner") +
                getPts("Thunderfire cannon - weapon") +
                getPts("Plasma cutter") +
                getPts("Flamer (SM)") +
                getPts("Bolt pistol (SM)");
        power = 7;

        complete();
    }

    @Override
    public void refreshen() {
    }
}
