package oc.wh40k.units.ae;

import static oc.KeyWord.AELDARI;
import static oc.KeyWord.ARCHON;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DRUKHARI;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.KABAL;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class AEArchon extends Eintrag {
	public AEArchon() {
    	super(AELDARI, DRUKHARI, INFANTRY, CHARACTER, ARCHON);

        name = "Archon";
        grundkosten = getPts("Archon");
        power = 4;

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Phantasm grenade launcher", getPts("Phantasm grenade launcher")));

        seperator();

        if(BuildaHQ.aktBuildaVater.getFormationType().equals("Ynnari"))
        	addWeapons(AEYnnariRuestkammer.class, true);
        else
        	addWeapons(AEDrukhariRuestkammer.class, true);
        
        seperator();

        addWarlordTraits("", KABAL);

        complete();
    }
}
