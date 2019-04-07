package oc.wh40k.units.im;

import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.COMPANY_COMMANDER;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.OFFICER;

import oc.Eintrag;

public class IMCompanyCommander extends Eintrag {

    public IMCompanyCommander() {
    	super(CHARACTER, INFANTRY, OFFICER, COMPANY_COMMANDER);
        name = "Company Commander";
        grundkosten = getPts("Company Commander") + getPts("Frag grenade (AM)");
        power = 3;

        seperator();

        addWeapons(IMAstraMilitarumRuestkammer.class, true);

        seperator();

        addWarlordTraits("", true);

        complete();
    }
}