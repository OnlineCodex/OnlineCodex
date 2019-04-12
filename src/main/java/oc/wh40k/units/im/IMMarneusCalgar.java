package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CHAPTER_MASTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.MARNEUS_CALGAR;
import static oc.KeyWord.TERMINATOR;
import static oc.KeyWord.ULTRAMARINES;

import oc.Eintrag;

public class IMMarneusCalgar extends Eintrag {

    public IMMarneusCalgar() {
        super(IMPERIUM, ADEPTUS_ASTARTES, ULTRAMARINES, CHARACTER, INFANTRY, CHAPTER_MASTER, TERMINATOR, MARNEUS_CALGAR);

        name = "Marneus Calgar";
        grundkosten = getPts("Marneus Calgar");
        power = 13;

        seperator();

        addWarlordTraits("Ultramarines: Adept of the Codex");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}
