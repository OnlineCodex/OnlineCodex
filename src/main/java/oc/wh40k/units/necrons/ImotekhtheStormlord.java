package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.AOPSlot.Hq;
import oc.wh40k.units.CharacterModel;
import oc.wh40k.units.Unique;
import oc.wh40k.units.UnitType.Infantry;
import oc.wh40k.units.necrons.Necrons.Sautekh;

public class ImotekhtheStormlord extends Eintrag
        implements Hq, CharacterModel, Infantry, Necrons.Overlord, Necrons, Sautekh, Unique<ImotekhtheStormlord> {

    public ImotekhtheStormlord() {
        name = "Imotekh the Stormlord";
        grundkosten = getPts("Imotekh the Stormlord");
        power = 10;

        add(ico = new oc.Picture("oc/wh40k/images/NEImotekhderSturmherr.jpg"));
        
        seperator();

        addWarlordTraits("Sautekh: Hyperlogical Strategist", true);

        complete();
    }
}