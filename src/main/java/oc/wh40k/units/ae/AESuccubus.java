package oc.wh40k.units.ae;

import static oc.KeyWord.AELDARI;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DRUKHARI;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.SUCCUBUS;
import static oc.KeyWord.WYCH_CULT;

import oc.BuildaHQ;
import oc.Eintrag;

public class AESuccubus extends Eintrag {

    public AESuccubus() {
    	super(AELDARI, DRUKHARI, INFANTRY, CHARACTER, SUCCUBUS);

        name = "Succubus";
        grundkosten = getPts("Succubus");
        power = 4;

        seperator();

        if(BuildaHQ.aktBuildaVater.getFormationType().equals("Ynnari"))
        	addWeapons(AEYnnariRuestkammer.class, true);
        else
        	addWeapons(AEDrukhariRuestkammer.class, true);
        
        seperator();

        addWarlordTraits("", WYCH_CULT);

        complete();
    }
}
