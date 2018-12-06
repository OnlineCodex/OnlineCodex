package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHLuciustheEternal extends Eintrag {

    public CHLuciustheEternal() {

        name = "Lucius the Eternal";
        grundkosten = getPts("Lucius the Eternal");
        power = 6;
        
        seperator();

        addWarlordTraits("Emperor's Children: Stimulated by Pain", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
