package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTA_SORORITAS;
import static oc.KeyWord.ADEPTUS_MINISTORUM;
import static oc.KeyWord.CANONESS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.ORDER;

import oc.Eintrag;

public class IMCanoness extends Eintrag {

    public IMCanoness() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, ADEPTA_SORORITAS, ORDER, CHARACTER, INFANTRY, CANONESS);
        name = "Canoness";
        grundkosten = getPts("Canoness");
        power = 3;

        add(ico = new oc.Picture("oc/wh40k/images/ASPrincipalis.jpg"));

        seperator();

        addWeapons(IMAdeptaSororitasRuestkammer.class, true);

        seperator();

        addWarlordTraits("", true);

        complete();
    }
}
