//Punktekosten laut Facebook-Seite von GW
package oc.wh40k.units.im;

import oc.Eintrag;

public class IMSlyMarbo extends Eintrag {

    public IMSlyMarbo() {
        name = "Sly Marbo";
        grundkosten = getPts("Sly Marbo");
        power = 4;

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }
}