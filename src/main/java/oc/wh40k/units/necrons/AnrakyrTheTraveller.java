package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.AOPSlot.Hq;
import oc.wh40k.units.CharacterModel;
import oc.wh40k.units.Unique;
import oc.wh40k.units.UnitType.Infantry;

public class AnrakyrTheTraveller extends Eintrag<Necrons, Hq, Infantry>
        implements CharacterModel, Unique, Necrons.Overlord {

    public AnrakyrTheTraveller() {
        name = "Anrakyr the Traveller";
        grundkosten = getPts("Anrakyr the Traveller");
        power = 9;
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}