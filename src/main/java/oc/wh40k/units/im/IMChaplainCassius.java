package oc.wh40k.units.im;

import oc.Eintrag;

public class IMChaplainCassius extends Eintrag {

    public IMChaplainCassius() {
        name = "Chaplain Cassius";
        grundkosten = getPts("Chaplain Cassius");
        power = 7;
        
        seperator();

        addWarlordTraits("Ultramarines: Adept of the Codex", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
