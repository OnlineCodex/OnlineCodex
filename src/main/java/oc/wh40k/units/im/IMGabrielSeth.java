package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CHAPTER_MASTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.FLESH_TEARERS;
import static oc.KeyWord.GABRIEL_SETH;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;

import oc.Eintrag;

public class IMGabrielSeth extends Eintrag {

    public IMGabrielSeth() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, FLESH_TEARERS, CHARACTER, INFANTRY, CHAPTER_MASTER, GABRIEL_SETH);
        name = "Gabriel Seth";
        grundkosten = getPts("Gabriel Seth");
        power = 7;

        seperator();

        addWarlordTraits("Selfless Valour (BA)");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}

