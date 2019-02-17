//IA Xenos
package oc.wh40k.units.ty;

import oc.Eintrag;

public class TYHierophantBiotitan extends Eintrag {

    public TYHierophantBiotitan() {

        name = "Hierophant Bio-titan";
        grundkosten = getPts("Hierophant Bio-titan") + 2 * getPts("Dire bio-cannon") + getPts("Lashwhip pods") + getPts("Bio-plasma torrent") + getPts("Monstrous scything talons (Hierophant)");
        power = 90;

        add(ico = new oc.Picture("oc/wh40k/images/TYHierophantBiotitan.gif"));

        complete();

    }
}
