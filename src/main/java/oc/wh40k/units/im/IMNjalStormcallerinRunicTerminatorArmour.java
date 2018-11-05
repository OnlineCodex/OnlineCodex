package oc.wh40k.units.im;

import oc.Eintrag;

public class IMNjalStormcallerinRunicTerminatorArmour extends Eintrag {

    public IMNjalStormcallerinRunicTerminatorArmour() {
        name = "Njal Sturmbringer in Runic Terminator Armour";
        grundkosten = getPts("Njal Stormcaller in Runic Terminator Armour");
        power = 9;
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
