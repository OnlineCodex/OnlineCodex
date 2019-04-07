package oc.wh40k.units.im;

import oc.Eintrag;

public class IMCommissarYarrick extends Eintrag {

    public IMCommissarYarrick() {
        name = "Commissar Yarrick";
        grundkosten = getPts("Commissar Yarrick");
        power = 9;

        seperator();

        addWarlordTraits("", true);


        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
