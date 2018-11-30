package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class IMCompanyChampiononBike extends Eintrag {
	
    RuestkammerStarter warlord;

    public IMCompanyChampiononBike() {
        name = "Company Champion on Bike";
        grundkosten = getPts("Company Champion on Bike") +
                getPts("Frag grenade (SM)") +
                getPts("Krak grenade (SM)") +
                getPts("Bolt pistol (SM)") +
                getPts("Master-crafted power sword") +
                getPts("Twin boltgun");
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