package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class IMChaplainonBike extends Eintrag {
    OptionsEinzelUpgrade jump;
    RuestkammerStarter waffenUndReliquien;
    RuestkammerStarter warlord;

    public IMChaplainonBike() {
        name = "Chaplain on Bike";
        grundkosten = getPts("Chaplain on Bike") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Crozius arcanum") + getPts("Twin boltgun");
        power = 6;
        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceMarinesRuestkammer.class, "");
        ((IMSpaceMarinesRuestkammer) waffenUndReliquien.getKammer()).setType("Chaplain");
        waffenUndReliquien.initKammer();
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);
        
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        add(warlord);

        complete();
    }

	//@OVERRIDE
	public void refreshen() {
	    warlord.getPanel().setLocation(
	            (int) warlord.getPanel().getLocation().getX(),
	            (int) waffenUndReliquien.getPanel().getLocation().getY() + waffenUndReliquien.getPanel().getSize().height + 5
	    );
	}
}
