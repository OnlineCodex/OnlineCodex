package oc.wh40k.units.ch;

import oc.Eintrag;

import static oc.KeyWord.NURGLE;

public class CHCorbaxUtterblight extends Eintrag {

    public CHCorbaxUtterblight() {

        name = "Cor'bax Utterblight";
        grundkosten = getPts("Cor'bax Utterblight");
        power = 12;
        
        seperator();

        addWarlordTraits("", NURGLE);

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
