package oc.wh40k.units.ch;

import static oc.KeyWord.BLOODLETTER;
import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.HERALD_OF_KHORNE;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.KHORNE;
import static oc.KeyWord.SKULLTAKER;

import oc.Eintrag;

public class CHSkulltaker extends Eintrag {

    public CHSkulltaker() {
        super(CHAOS, KHORNE, DAEMON, CHARACTER, INFANTRY, BLOODLETTER, HERALD_OF_KHORNE, SKULLTAKER);

        name = "Skulltaker";
        grundkosten = getPts("Skulltaker");
        power = 5;

        seperator();

        addWarlordTraits("Khorne: Devastating Blow", KHORNE);

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}
