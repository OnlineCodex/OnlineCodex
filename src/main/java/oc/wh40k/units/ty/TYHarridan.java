//IA Xenos + FAQ 1.0
package oc.wh40k.units.ty;

import oc.Eintrag;

public class TYHarridan extends Eintrag {

    public TYHarridan() {

        name = "Harridan";
        grundkosten = getPts("Harridan") + 2 * getPts("Bio-cannon") + getPts("Massive scything talons (single)");
        power = 32;

        add(ico = new oc.Picture("oc/wh40k/images/TYHarridan.gif"));

        complete();

    }

    //@OVERRIDE
    public void refreshen() {
    }
}
