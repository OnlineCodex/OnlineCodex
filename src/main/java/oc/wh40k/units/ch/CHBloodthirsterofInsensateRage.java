package oc.wh40k.units.ch;

import static oc.KeyWord.BLOODTHIRSTER;
import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.FLY;
import static oc.KeyWord.KHORNE;
import static oc.KeyWord.MONSTER;

import oc.Eintrag;

public class CHBloodthirsterofInsensateRage extends Eintrag {

    public CHBloodthirsterofInsensateRage() {
        super(CHAOS, KHORNE, DAEMON, CHARACTER, MONSTER, BLOODTHIRSTER, FLY);

        name = "Bloodthirster of Insensate Rage";
        grundkosten = getPts("Bloodthirster Of Insensate Rage");
        power = 17;

        seperator();

        addWeapons(CHWaffenkammerCD.class, false);

        seperator();

        addWarlordTraits("", KHORNE);

        complete();
    }
}
