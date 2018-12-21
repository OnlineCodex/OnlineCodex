package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.CharacterModel;
import oc.wh40k.units.AOPSlot.Hq;
import oc.wh40k.units.Unique;
import oc.wh40k.units.UnitType.Infantry;

public class IlluminorSzeras extends Eintrag<Necrons, Hq, Infantry> implements CharacterModel, Necrons.Cryptek, Unique {
	
    public IlluminorSzeras() {
        name = "Illuminor Szeras";
        grundkosten = getPts("Illuminor Szeras") + getPts("Eldritch lance");
        power = 8;
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}