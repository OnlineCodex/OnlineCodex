package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.BLACK_TEMPLARS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.EMPERORS_CHAMPION;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;

import oc.Eintrag;

public class IMTheEmperorsChampion extends Eintrag {

    public IMTheEmperorsChampion() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLACK_TEMPLARS, CHARACTER, INFANTRY, EMPERORS_CHAMPION);

        name = "The Emperor's Champion";
        grundkosten = getPts("The Emperor's Champion");
        power = 6;

        seperator();

        addWarlordTraits("Black Templars: Oathkeeper");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}
