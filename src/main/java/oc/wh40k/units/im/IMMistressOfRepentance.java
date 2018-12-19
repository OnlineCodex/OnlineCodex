package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMMistressOfRepentance extends Eintrag {

    RuestkammerStarter waffenUndRelikte;

    public IMMistressOfRepentance() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, ADEPTA_SORORITAS, ORDER, CHARACTER, INFANTRY, MISTRESS_OF_REPENTANCE);
        name = "Mistress of Repentance";
        grundkosten = getPts("Mistress of Repentance") + getPts("Neural whips");
        power = 2;

        seperator();
        
        addWeapons(IMAdeptaSororitasRuestkammer.class, false);

        seperator();
        
        addWarlordTraits("", true);

        complete();
    }
    
    @Override
    public void refreshen() {
    	setEintragsCNT(getCountFromInformationVector("REPENTIA_SQUAD") > 0 ? 0 : 1);
    }
}
