package oc.wh40k.units.ch;

import static oc.KeyWord.SLAANESH;

import oc.Eintrag;

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
        setUnique(true);
    }
}
