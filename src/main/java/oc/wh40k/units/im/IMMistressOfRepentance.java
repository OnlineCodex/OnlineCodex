package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTA_SORORITAS;
import static oc.KeyWord.ADEPTUS_MINISTORUM;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.MISTRESS_OF_REPENTANCE;
import static oc.KeyWord.ORDER;

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

        addWarlordTraits("");

        complete();
    }

    @Override
    public void refreshen() {
    	setEintragsCNT(getCountFromInformationVector(REPENTIA_SQUAD_CNT) > 0 ? 0 : 1);
    }
}
