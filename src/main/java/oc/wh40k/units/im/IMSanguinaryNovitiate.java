package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class IMSanguinaryNovitiate extends Eintrag {

    RuestkammerStarter waffenUndReliquien;
    RuestkammerStarter warlord;

    public IMSanguinaryNovitiate() {
        name = "Sanguinary Novitiate";
        grundkosten = getPts("Apothecary") +
                getPts("Frag grenade (SM)") +
                getPts("Krak grenade (SM)") +
                getPts("Chainsword (SM)") +
                getPts("Bolt pistol (SM)");
        power = 3;
        
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
    }
}
