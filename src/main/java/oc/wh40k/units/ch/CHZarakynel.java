package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHZarakynel extends Eintrag {

    public CHZarakynel() {

        name = "Zarakynel";
        grundkosten = getPts("Zarakynel");
        power = 23;
        
        seperator();

        addWarlordTraits("", true, SLAANESH);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
