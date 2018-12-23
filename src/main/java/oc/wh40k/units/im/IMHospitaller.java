package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMHospitaller extends Eintrag {

    public IMHospitaller() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, ADEPTA_SORORITAS, CHARACTER, INFANTRY, HOSPITALLER);
        name = "Hospitaller";
        grundkosten = getPts("Hospitaller");
        power = 2;

        addWeapons(new IMAdeptaSororitasRuestkammer(name, getKeywords()), false);
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }

}
