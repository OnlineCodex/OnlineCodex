package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMThunderfireCannon extends Eintrag {

    RuestkammerStarter waffenUndReliquien;

    public IMThunderfireCannon() {
        name = "Thunderfire Cannon";
        grundkosten = getPts("Thunderfire Cannon") +
                getPts("Thunderfire Cannon - Techmarine Gunner") +
                getPts("Thunderfire cannon - weapon") +
                getPts("Servo-arm") * 2 +
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
