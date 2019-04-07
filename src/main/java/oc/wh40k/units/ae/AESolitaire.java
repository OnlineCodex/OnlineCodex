package oc.wh40k.units.ae;

import static oc.KeyWord.AELDARI;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.HARLEQUINS;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.SOLITAIRE;

import oc.Eintrag;

public class AESolitaire extends Eintrag {

    public AESolitaire() {
    	super(AELDARI, CHARACTER, HARLEQUINS, INFANTRY, SOLITAIRE);

        name = "Solitaire";
        grundkosten = getPts("Solitaire") ;
        power = 6;

        seperator();

        addWeapons(AEHarlequinsRuestkammer.class, true);

        seperator();

        addWarlordTraits("", true);

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}