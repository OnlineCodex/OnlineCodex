package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.BLOOD_ANGELS;
import static oc.KeyWord.CHAPLAIN;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DEATH_COMPANY;
import static oc.KeyWord.FLY;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.JUMP_PACK;
import static oc.KeyWord.LEMARTES;

import oc.Eintrag;

public class IMLemartes extends Eintrag {

    public IMLemartes() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, DEATH_COMPANY, CHARACTER, INFANTRY, CHAPLAIN, JUMP_PACK, FLY, LEMARTES);
        name = "Lemartes";
        grundkosten = getPts("Lemartes");
        power = 7;

        seperator();

        addWarlordTraits("Soulwarden (BA)", true);

        complete();
    }

    @Override
    public void refreshen() {
        this.setUnikat(true);
    }
}
