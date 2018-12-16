package oc.wh40k.units.ch;

import oc.Eintrag;

import static oc.KeyWord.SLAANESH;

public class CHZarakynel extends Eintrag {

    public CHZarakynel() {

        name = "Zarakynel";
        grundkosten = getPts("Zarakynel");
        power = 23;
        
        seperator();

        addWarlordTraits("", SLAANESH);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
