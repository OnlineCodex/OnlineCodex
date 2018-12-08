package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMDeathwatchPrimarisChaplain extends Eintrag {
    OptionsEinzelUpgrade jump;
    RuestkammerStarter waffenUndReliquien;

    public IMDeathwatchPrimarisChaplain() {
        name = "Primaris Chaplain";
        grundkosten = getPts("Primaris Chaplain") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Crozius arcanum") + getPts("Absolver bolt pistol (DW)");
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 6;
    }
}
