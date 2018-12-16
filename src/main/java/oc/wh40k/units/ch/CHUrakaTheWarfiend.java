package oc.wh40k.units.ch;

import oc.Eintrag;

import static oc.KeyWord.KHORNE;

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
        setUnikat(true);
    }
}
