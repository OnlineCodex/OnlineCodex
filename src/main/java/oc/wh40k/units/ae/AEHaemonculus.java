package oc.wh40k.units.ae;

import static oc.KeyWord.AELDARI;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DRUKHARI;
import static oc.KeyWord.HAEMONCULUS;
import static oc.KeyWord.HAEMUNCULUS_COVEN;
import static oc.KeyWord.INFANTRY;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class AEHaemonculus extends Eintrag {
    public AEHaemonculus() {
    	super(AELDARI, DRUKHARI, INFANTRY, CHARACTER, HAEMONCULUS);

        name = "Haemonculus";
        grundkosten = getPts("Haemonculus");
        power = 5;

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ichor injector", getPts("Ichor injector")));

        seperator();

        //Punkte für Crucible of malediction fehlen im Index und im FAQ

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Crucible of malediction", getPts("Crucible of malediction")));

        seperator();

        if(BuildaHQ.aktBuildaVater.getFormationType().equals("Ynnari"))
        	addWeapons(AEYnnariRuestkammer.class, true);
        else
        	addWeapons(AEDrukhariRuestkammer.class, true);
        
        seperator();

        addWarlordTraits("", HAEMUNCULUS_COVEN);

        complete();
    }
}

