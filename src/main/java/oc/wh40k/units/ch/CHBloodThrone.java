package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import oc.Eintrag;

public class CHBloodThrone extends Eintrag {

    public CHBloodThrone() {
        super(CHAOS, KHORNE, DAEMON, CHARACTER, CHARIOT, BLOODLETTER, HERALD_OF_KHORNE, BLOOD_THRONE);
        name = "Blood Throne";
        grundkosten = getPts("Blood Throne");
        power = 6;

        seperator();
        
        addWeapons(CHWaffenkammerCD.class, true);
        
        seperator();
        
        addWarlordTraits("", KHORNE);

        complete();
    }

    @Override
    public void refreshen() {

    }

}
