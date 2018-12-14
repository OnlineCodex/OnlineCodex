package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHSkulltaker extends Eintrag {

    public CHSkulltaker() {

        name = "Skulltaker";
        grundkosten = getPts("Skulltaker");
        power = 5;
        
        seperator();
        
        addWarlordTraits("Khorne: Devastating Blow", true, KHORNE);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
