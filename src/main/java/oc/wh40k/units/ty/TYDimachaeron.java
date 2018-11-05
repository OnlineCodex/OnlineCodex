//IA Xenos
package oc.wh40k.units.ty;

import oc.Eintrag;

public class TYDimachaeron extends Eintrag {

    public TYDimachaeron() {
        name = "Dimachaeron";
        grundkosten = getPts("Dimachaeron") + getPts("Grasping talons and thorax spine-maw") + getPts("Sickle claws");
        power = 10;

        complete();

    }

    @Override
    public void refreshen() {
    }

}
