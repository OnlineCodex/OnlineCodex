package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.AOPSlot.Hq;
import oc.wh40k.units.CharacterModel;
import oc.wh40k.units.Unique;
import oc.wh40k.units.UnitType;
import oc.wh40k.units.UnitType.Infantry;
import oc.wh40k.units.necrons.Necrons.Sautekh;

public class VargardObyron extends Eintrag<Sautekh, Hq, Infantry> implements CharacterModel, Necrons.Lord, Unique {

    public VargardObyron() {
        name = "Vargard Obyron";
        grundkosten = getPts("Vargard Obyron");
        power = 7;
        
        seperator();

        addWarlordTraits("Sautekh: Hyperlogical Strategist", true);

        complete();
    }
}