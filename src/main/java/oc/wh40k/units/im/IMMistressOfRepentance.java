package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMMistressOfRepentance extends Eintrag {

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
    	setEintragsCNT(getCountFromInformationVector(REPENTIA_SQUAD_CNT) > 0 ? 0 : 1);
    }
}
