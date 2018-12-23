package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMMissionary extends Eintrag {

    public IMMissionary() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, CHARACTER, INFANTRY, MINISTORUM_PRIEST, MISSIONARY);
        name = "Missionary";
        grundkosten = getPts("Missionary") + 
        		getPts("autogun (AMI)") + 
        		getPts("laspistol (AMI)") + 
        		getPts("Chainsword (AMI)") +
        		getPts("Frag grenades (AMI)") + 
        		getPts("Krak grenades (AMI)");
        power = 3;

        seperator();

        addWeapons(new IMAdeptaSororitasRuestkammer(name, getKeywords()), true);
        
        seperator();

        addWarlordTraits("", true);

        addToInformationVector(MINISTORUM_PRIEST_CNT, 1);
        addToInformationVector(MISSIONARY_CNT, 1);
        
        complete();
    }
    
    @Override
    public void refreshen() {
    	if(getCountFromInformationVector(MISSIONARY_CNT) > 1) {
    		setFehlermeldung("Max 1 MISSIONARY");
    	} else {
    		setFehlermeldung("");
    	}
    }
    
    @Override
    public void deleteYourself() {
        addToInformationVector(MISSIONARY_CNT, -1);
        addToInformationVector(MINISTORUM_PRIEST_CNT, -1);
    	super.deleteYourself();
    }
}