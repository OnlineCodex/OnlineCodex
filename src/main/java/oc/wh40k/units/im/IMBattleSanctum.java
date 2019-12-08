package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTA_SORORITAS;
import static oc.KeyWord.ADEPTUS_MINISTORUM;
import static oc.KeyWord.CELESTINE;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.FLY;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.JUMP_PACK;

import oc.Eintrag;

public class IMBattleSanctum extends Eintrag {

    public IMBattleSanctum() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, ADEPTA_SORORITAS, CHARACTER, INFANTRY, JUMP_PACK, FLY, CELESTINE);
        name = "Battle Sanctum";
        grundkosten = getPts("Battle Sanctum");
        power = 3;

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
