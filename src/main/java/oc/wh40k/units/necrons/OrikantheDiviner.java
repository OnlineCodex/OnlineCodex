package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.AOPSlot.Hq;
import oc.wh40k.units.CharacterModel;
import oc.wh40k.units.Unique;
import oc.wh40k.units.UnitType.Infantry;
import oc.wh40k.units.necrons.Necrons.Sautekh;

public class OrikantheDiviner extends Eintrag<Sautekh, Hq, Infantry> implements CharacterModel, Necrons.Cryptek, Unique {

    public OrikantheDiviner() {
        name = "Orikan the Diviner";
        grundkosten = getPts("Orikan the Diviner");
        power = 6;
        
        seperator();

        addWarlordTraits("Sautekh: Hyperlogical Strategist", true);

        complete();
    }
}