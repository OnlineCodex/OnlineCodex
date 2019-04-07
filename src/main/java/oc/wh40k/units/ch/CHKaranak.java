package oc.wh40k.units.ch;

import static oc.KeyWord.BEAST;
import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.FLESH_HOUND;
import static oc.KeyWord.KARANAK;
import static oc.KeyWord.KHORNE;

import oc.Eintrag;

public class CHKaranak extends Eintrag {

    public CHKaranak() {
        super(CHAOS, KHORNE, DAEMON, BEAST, CHARACTER, FLESH_HOUND, KARANAK);
        name = "Karanak";
        grundkosten = getPts("Karanak");
        power = 4;


        seperator();

        addWarlordTraits("Khorne: Aspect of Death", KHORNE);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
