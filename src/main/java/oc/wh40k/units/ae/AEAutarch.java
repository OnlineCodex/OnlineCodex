package oc.wh40k.units.ae;

import static oc.KeyWord.*;

import oc.Eintrag;

import oc.OptionsUpgradeGruppe;

public class AEAutarch extends Eintrag {

    public AEAutarch() {
       	super(AELDARI, ASURYANI, CHARACTER, INFANTRY, AUTARCH);
        
        name = "Autarch";
        grundkosten = getPts("Autarch") + getPts("Plasma grenades") + getPts("Forceshield");
        power = 4;

        seperator();

        addWeapons(AECraftworldRuestkammer.class, true);

        seperator();

        addWarlordTraits("", true);
        
        complete();
    }
}