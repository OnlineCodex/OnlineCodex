package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class IMCompanyChampionwithJumpPack extends Eintrag {
	
    RuestkammerStarter warlord;

    public IMCompanyChampionwithJumpPack() {
        name = "Company Champion with Jump Pack";
        grundkosten = getPts("Company Champion with Jump Pack") +
                getPts("Frag grenade (SM)") +
                getPts("Krak grenade (SM)") +
                getPts("Bolt pistol (SM)") +
                getPts("Master-crafted power sword");
        power = 5;
        
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        add(warlord);

        complete();
    }

    public void refreshen() {
    }
}