package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import oc.Eintrag;

public class CHSkulltaker extends Eintrag {

    public CHSkulltaker() {
        super(CHAOS, KHORNE, DAEMON, CHARACTER, INFANTRY, BLOODLETTER, HERALD_OF_KHORNE, SKULLTAKER);

        name = "Skulltaker";
        grundkosten = getPts("Skulltaker");
        power = 5;

        seperator();
        
        addWarlordTraits("Khorne: Devastating Blow", KHORNE);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
