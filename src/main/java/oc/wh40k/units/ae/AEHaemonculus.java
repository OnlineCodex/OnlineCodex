package oc.wh40k.units.ae;

import oc.*;

import static oc.KeyWord.*;

public class AEHaemonculus extends Eintrag {
    private static OptionsEinzelUpgrade oe1;

    public AEHaemonculus() {
    	super(AELDARI, DRUKHARI, INFANTRY, CHARACTER, HAEMONCULUS);
    	
        name = "Haemonculus";
        grundkosten = getPts("Haemonculus");
        power = 5;

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ichor injector", getPts("Ichor injector")));

        seperator();

        //Punkte für Crucible of malediction fehlen im Index und im FAQ

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Crucible of malediction", getPts("Crucible of malediction")));

        seperator();

        addWeapons(AEDrukhariRuestkammer.class, true);
        
        seperator();
        
        addWarlordTraits("", HAEMUNCULUS_COVEN);

        complete();
    }
}

