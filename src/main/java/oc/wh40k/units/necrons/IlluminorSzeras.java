package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.CharacterModel;
import oc.wh40k.units.AOPSlot.Hq;
import oc.wh40k.units.Source;
import oc.wh40k.units.Unique;
import oc.wh40k.units.UnitType.Infantry;

import static oc.wh40k.units.Source.SourcePublication.CodexNecrons;

@Source(CodexNecrons)
public class IlluminorSzeras extends Eintrag<Necrons, Hq> implements CharacterModel, Infantry, Necrons.Cryptek, Unique<IlluminorSzeras> {
	
    public IlluminorSzeras() {
        name = "Illuminor Szeras";
        grundkosten = getPts("Illuminor Szeras") + getPts("Eldritch lance");
        power = 8;
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}