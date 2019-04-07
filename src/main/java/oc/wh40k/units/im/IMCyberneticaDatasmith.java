package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_MECHANICUS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.CULT_MECHANICUS;
import static oc.KeyWord.CYBERNETICA_DATASMITH;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.TECH_PRIEST;

import oc.Eintrag;

public class IMCyberneticaDatasmith extends Eintrag {


    public IMCyberneticaDatasmith() {
    	super(IMPERIUM, ADEPTUS_MECHANICUS, CULT_MECHANICUS, INFANTRY, CHARACTER, TECH_PRIEST, CYBERNETICA_DATASMITH);

        name = "Cybernetica Datasmith";
        grundkosten = getPts("Cybernetica Datasmith");
        power = 3;

        seperator();

        addWeapons(IMTechPriestRuestkammer.class, true);

        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
    }
}
