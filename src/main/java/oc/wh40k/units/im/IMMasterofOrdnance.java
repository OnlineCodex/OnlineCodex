package oc.wh40k.units.im;

import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.MASTER_OF_ORDNANCE;
import static oc.KeyWord.OFFICER;

import oc.Eintrag;

public class IMMasterofOrdnance extends Eintrag {

    public IMMasterofOrdnance() {
    	super(CHARACTER, INFANTRY, OFFICER, MASTER_OF_ORDNANCE);

        name = "Master Of Ordnance";
        grundkosten = getPts("Master Of Ordnance") + getPts("Laspistol");
        power = 2;

        add(ico = new oc.Picture("oc/wh40k/images/IGCaptainThanstadt.jpg"));

        seperator();

        addWeapons(IMAstraMilitarumRuestkammer.class, true);

        seperator();

        addWarlordTraits("");

        complete();
    }

}