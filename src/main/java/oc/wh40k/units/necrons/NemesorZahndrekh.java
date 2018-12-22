package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.AOPSlot.Hq;
import oc.wh40k.units.CharacterModel;
import oc.wh40k.units.Source;
import oc.wh40k.units.Unique;
import oc.wh40k.units.UnitType.Infantry;
import oc.wh40k.units.necrons.Necrons.Sautekh;

import static oc.wh40k.units.Source.SourcePublication.CodexNecrons;

@Source(CodexNecrons)
public class NemesorZahndrekh extends Eintrag<Sautekh, Hq> implements CharacterModel, Infantry, Necrons.Overlord, Unique<NemesorZahndrekh> {

    public NemesorZahndrekh() {
        name = "Nemesor Zahndrekh";
        grundkosten = getPts("Nemesor Zahndrekh");
        power = 9;

        addWarlordTraits("Sautekh: Hyperlogical Strategist", true);

        complete();
    }
}
