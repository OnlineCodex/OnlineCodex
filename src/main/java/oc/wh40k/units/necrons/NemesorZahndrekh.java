package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.AOPSlot.Hq;
import oc.wh40k.units.CharacterModel;
import oc.wh40k.units.Unique;
import oc.wh40k.units.UnitType.Infantry;
import oc.wh40k.units.necrons.Necrons.Sautekh;

public class NemesorZahndrekh extends Eintrag<Sautekh, Hq, Infantry> implements CharacterModel, Necrons.Overlord, Unique {

    public NemesorZahndrekh() {
        name = "Nemesor Zahndrekh";
        grundkosten = getPts("Nemesor Zahndrekh");
        power = 9;
        
        seperator();

        addWarlordTraits("Sautekh: Hyperlogical Strategist", true);

        complete();
    }
}
