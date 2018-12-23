package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMPreacher extends Eintrag {

    public IMPreacher() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, CHARACTER, INFANTRY, MINISTORUM_PRIEST, PREACHER);
        name = "Preacher";
        grundkosten = getPts("Preacher") + getPts("laspistol (AMI)") + getPts("chainsword (AMI)");
        power = 2;

        addWeapons(new IMAdeptaSororitasRuestkammer(name, getKeywords()), false);
        
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