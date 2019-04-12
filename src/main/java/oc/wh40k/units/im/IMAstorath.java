package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.ASTORATH;
import static oc.KeyWord.BLOOD_ANGELS;
import static oc.KeyWord.CHAPLAIN;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.FLY;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.JUMP_PACK;

import oc.Eintrag;

public class IMAstorath extends Eintrag {

    public IMAstorath() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, CHARACTER, INFANTRY, CHAPLAIN, JUMP_PACK, FLY, ASTORATH);
        name = "Astorath";
        grundkosten = getPts("Astorath");
        power = 8;
        seperator();

        addWarlordTraits("Soulwarden (BA)");

        complete();
    }

    @Override
    public void refreshen() {
        this.setUnique(true);
    }
}
