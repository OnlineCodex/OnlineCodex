package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMUriahJacobus extends Eintrag {

    public IMUriahJacobus() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, CHARACTER, INFANTRY, MINISTORUM_PRIEST, MISSIONARY, URIAH_JACOBUS);
        name = "UriahJacobus";
        grundkosten = getPts("UriahJacobus");
        power = 3;

        seperator();
        
        addWarlordTraits("Righteous Rage", true);

        addToInformationVector("MINISTORUM_PRIEST", 1);
        
        complete();
    }
    
    @Override
    public void deleteYourself() {
        addToInformationVector("MINISTORUM_PRIEST", -1);
    	super.deleteYourself();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
