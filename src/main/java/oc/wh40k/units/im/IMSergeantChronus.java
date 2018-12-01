package oc.wh40k.units.im;

import oc.Eintrag;

public class IMSergeantChronus extends Eintrag {

    public IMSergeantChronus() {
        name = "Sergeant Chronus";
        grundkosten = getPts("Sergeant Chronus");
        power = 3;
        
        seperator();

        addWarlordTraits("Ultramarines: Adept of the Codex", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
