package oc.wh40k.units.ch;

import static oc.KeyWord.BLOODTHIRSTER;
import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.KHORNE;
import static oc.KeyWord.MONSTER;
import static oc.KeyWord.SKARBRAND;

import oc.Eintrag;

public class CHSkarbrand extends Eintrag {

    public CHSkarbrand() {
        super(CHAOS, KHORNE, DAEMON, CHARACTER, MONSTER, BLOODTHIRSTER, SKARBRAND);

        name = "Skarbrand";
        grundkosten = getPts("Skarbrand");
        power = 18;

        seperator();

        addWarlordTraits("Khorne: Rage Incarnate", KHORNE);

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}
