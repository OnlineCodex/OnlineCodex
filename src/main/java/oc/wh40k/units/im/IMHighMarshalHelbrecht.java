package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMHighMarshalHelbrecht extends Eintrag {

    public IMHighMarshalHelbrecht() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLACK_TEMPLARS, CHARACTER, INFANTRY, CHAPTER_MASTER, HIGH_MARSHAL_HELBRECHT);
    	
        name = "High Marshal Helbrecht";
        grundkosten = getPts("High Marshal Helbrecht");
        power = 9;
        
        seperator();

        addWarlordTraits("Black Templars: Oathkeeper", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
