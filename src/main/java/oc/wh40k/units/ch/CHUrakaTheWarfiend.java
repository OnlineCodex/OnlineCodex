package oc.wh40k.units.ch;

import static oc.KeyWord.KHORNE;

import oc.Eintrag;

public class CHUrakaTheWarfiend extends Eintrag {

    public CHUrakaTheWarfiend() {

        name = "Uraka the Warfiend";
        grundkosten = getPts("Uraka the Warfiend");
        power = 9;

        seperator();

        addWarlordTraits("", KHORNE);

        complete();

    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}
