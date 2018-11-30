package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class IMPrimarisChaplain extends Eintrag {
    OptionsEinzelUpgrade jump;
    RuestkammerStarter waffenUndReliquien;
    RuestkammerStarter warlord;

    public IMPrimarisChaplain() {
        name = "Primaris Chaplain";
        grundkosten = getPts("Primaris Chaplain") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Crozius arcanum") + getPts("Absolver bolt pistol");

        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        add(warlord);

        complete();
    }

    @Override
    public void refreshen() {
        power = 6;
    }
}
