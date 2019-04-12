package oc.wh40k.units.ae;

import static oc.KeyWord.AELDARI;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DEATHJESTER;
import static oc.KeyWord.HARLEQUINS;
import static oc.KeyWord.INFANTRY;

import oc.Eintrag;

public class AEDeathJester extends Eintrag {

    public AEDeathJester() {
    	super(AELDARI, CHARACTER, HARLEQUINS, INFANTRY, DEATHJESTER);

        name = "Death Jester";
        grundkosten = getPts("Death Jester");
        power = 3;

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