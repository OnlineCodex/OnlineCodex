package oc.wh40k.units.ae;

import static oc.KeyWord.AELDARI;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.HARLEQUINS;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.TROUPE_MASTER;

import oc.Eintrag;

public class AETroupeMaster extends Eintrag {

    public AETroupeMaster() {
    	super(AELDARI, CHARACTER, HARLEQUINS, INFANTRY, TROUPE_MASTER);

        name = "Troupe Master";
        grundkosten = getPts("Troupe Master");
        power = 4;

        seperator();

        addWeapons(AEHarlequinsRuestkammer.class, true);

        seperator();

        addWarlordTraits("");

        complete();
    }

    @Override
    public void refreshen() {
    }
}