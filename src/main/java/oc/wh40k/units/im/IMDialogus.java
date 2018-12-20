package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMDialogus extends Eintrag {

    public IMDialogus() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, ADEPTA_SORORITAS, CHARACTER, INFANTRY, DIALOGUS);
        name = "Dialogus";
        grundkosten = getPts("Dialogus") + getPts("Dialogus staff");
        power = 2;

        seperator();
        
        addWeapons(IMAdeptaSororitasRuestkammer.class, false);
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }
}
