package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMMasterinGravisArmour extends Eintrag {

    RuestkammerStarter waffenUndReliquien;

    public IMMasterinGravisArmour() {
        name = "Master in Gravis Armour";
        grundkosten = getPts("Master in Gravis Armour") + getPts("Master-crafted power sword") + getPts("Boltstorm gauntlet");
        power = 7;
        
        seperator();
        
        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
    }
}
