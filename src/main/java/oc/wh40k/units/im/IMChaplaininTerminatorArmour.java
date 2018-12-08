package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMChaplaininTerminatorArmour extends Eintrag {
    OptionsEinzelUpgrade jump;
    RuestkammerStarter waffenUndReliquien;

    public IMChaplaininTerminatorArmour() {
        name = "Chaplain in Terminator Armour";
        grundkosten = getPts("Chaplain in Terminator Armour") + getPts("Crozius arcanum");
        power = 6;
        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceMarinesRuestkammer.class, "");
        ((IMSpaceMarinesRuestkammer) waffenUndReliquien.getKammer()).setType("Chaplain in Terminator Armour");
        waffenUndReliquien.initKammer();
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }

	//@OVERRIDE
	public void refreshen() {
	    warlordTraits.getPanel().setLocation(
	            (int) warlordTraits.getPanel().getLocation().getX(),
	            (int) waffenUndReliquien.getPanel().getLocation().getY() + waffenUndReliquien.getPanel().getSize().height + 5
	    );
	}
}