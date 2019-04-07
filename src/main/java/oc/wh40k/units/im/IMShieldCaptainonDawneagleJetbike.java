package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_CUSTODES;
import static oc.KeyWord.BIKER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.FLY;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.SHIELD_CAPTAIN;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IMShieldCaptainonDawneagleJetbike extends Eintrag {

    public IMShieldCaptainonDawneagleJetbike() {
    	super(IMPERIUM, ADEPTUS_CUSTODES, CHARACTER, INFANTRY, SHIELD_CAPTAIN, BIKER, FLY);

        name = "Shield Captain on Dawneagle Jetbike";
        grundkosten = getPts("Shield-Captain on Dawneagle Jetbike");
        power = 9;

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Misericordia", getPts("Misericordia")));

        seperator();

        addWeapons(IMAdeptusCustodesRuestkammer.class, true);

        seperator();

		addWarlordTraits("", true);

        complete();
    }
}

