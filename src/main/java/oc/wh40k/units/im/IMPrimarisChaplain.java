package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMPrimarisChaplain extends Eintrag {
    OptionsEinzelUpgrade jump;
    RuestkammerStarter waffenUndReliquien;

    public IMPrimarisChaplain() {
        name = "Primaris Chaplain";
        grundkosten = getPts("Primaris Chaplain") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Crozius arcanum") + getPts("Absolver bolt pistol");

        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 6;
    }
}
