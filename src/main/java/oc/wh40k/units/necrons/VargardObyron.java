package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.AOPSlot.Hq;
import oc.wh40k.units.CharacterModel;
import oc.wh40k.units.Unique;

public class VargardObyron extends Eintrag
        implements Necrons, Necrons.Sautekh, Hq, CharacterModel, Necrons.Lord, Unique<VargardObyron> {

    public VargardObyron() {
        name = "Vargard Obyron";
        grundkosten = getPts("Vargard Obyron");
        power = 7;
        
        seperator();

        addWarlordTraits("Sautekh: Hyperlogical Strategist", true);

        complete();
    }
}