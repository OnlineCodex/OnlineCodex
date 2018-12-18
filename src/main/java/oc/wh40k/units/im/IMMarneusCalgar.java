package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMMarneusCalgar extends Eintrag {

    public IMMarneusCalgar() {
        super(IMPERIUM, ADEPTUS_ASTARTES, ULTRAMARINES, CHARACTER, INFANTRY, CHAPTER_MASTER, TERMINATOR, MARNEUS_CALGAR);
        
        name = "Marneus Calgar";
        grundkosten = getPts("Marneus Calgar");
        power = 13;
        
        seperator();

        addWarlordTraits("Ultramarines: Adept of the Codex", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
