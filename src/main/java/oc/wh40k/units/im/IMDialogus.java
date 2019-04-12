package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTA_SORORITAS;
import static oc.KeyWord.ADEPTUS_MINISTORUM;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DIALOGUS;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;

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

        addWarlordTraits("");

        complete();
    }
}
