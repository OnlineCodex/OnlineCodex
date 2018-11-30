package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class IMCompanyChampion extends Eintrag {
	
    RuestkammerStarter warlord;

    public IMCompanyChampion() {
        name = "Company Champion";
        grundkosten = getPts("Company Champion") +
                getPts("Frag grenade (SM)") +
                getPts("Krak grenade (SM)") +
                getPts("Bolt pistol (SM)") +
                getPts("Combat shield");

        if (buildaVater.getFormationType().equals("Dark Angels")) {
            grundkosten += getPts("Blade of Caliban");
        } else {
            grundkosten += getPts("Master-crafted power sword");
        }

        power = 3;
        
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