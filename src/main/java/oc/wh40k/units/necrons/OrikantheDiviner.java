package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.AOPSlot.Hq;
import oc.wh40k.units.CharacterModel;
import oc.wh40k.units.Unique;
import oc.wh40k.units.UnitType.Infantry;

public class OrikantheDiviner extends Eintrag
        implements Necrons, Necrons.Sautekh, Hq, CharacterModel, Infantry, Necrons.Cryptek, Unique<OrikantheDiviner> {

    public OrikantheDiviner() {
        name = "Orikan the Diviner";
        grundkosten = getPts("Orikan the Diviner");
        power = 6;
        
        seperator();

        addWarlordTraits("Sautekh: Hyperlogical Strategist", true);

        complete();
    }
}