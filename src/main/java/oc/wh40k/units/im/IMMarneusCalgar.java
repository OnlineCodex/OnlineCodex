package oc.wh40k.units.im;

import oc.Eintrag;

public class IMMarneusCalgar extends Eintrag {

    public IMMarneusCalgar() {
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
