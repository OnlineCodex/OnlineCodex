package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_MINISTORUM;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.MINISTORUM_PRIEST;
import static oc.KeyWord.PREACHER;

import oc.Eintrag;

public class IMPreacher extends Eintrag {

    public IMPreacher() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, CHARACTER, INFANTRY, MINISTORUM_PRIEST, PREACHER);
        name = "Preacher";
        grundkosten = getPts("Preacher") + getPts("laspistol (AMI)") + getPts("chainsword (AMI)");
        power = 2;

        seperator();

        addWeapons(IMAdeptaSororitasRuestkammer.class, false);

        seperator();

        addWarlordTraits("", true);

        addToInformationVector(MINISTORUM_PRIEST_CNT, 1);

        complete();
    }

    @Override
    public void deleteYourself() {
        addToInformationVector(MINISTORUM_PRIEST_CNT, -1);
    	super.deleteYourself();
    }
}