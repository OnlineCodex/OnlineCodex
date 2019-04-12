package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.BLACK_TEMPLARS;
import static oc.KeyWord.CHAPTER_MASTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.HIGH_MARSHAL_HELBRECHT;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;

import oc.Eintrag;

public class IMHighMarshalHelbrecht extends Eintrag {

    public IMHighMarshalHelbrecht() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLACK_TEMPLARS, CHARACTER, INFANTRY, CHAPTER_MASTER, HIGH_MARSHAL_HELBRECHT);

        name = "High Marshal Helbrecht";
        grundkosten = getPts("High Marshal Helbrecht");
        power = 9;

        seperator();

        addWarlordTraits("Black Templars: Oathkeeper");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}
