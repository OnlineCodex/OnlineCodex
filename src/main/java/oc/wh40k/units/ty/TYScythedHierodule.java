//IA Xenos + FAQ 1.0
package oc.wh40k.units.ty;

import oc.Eintrag;

public class TYScythedHierodule extends Eintrag {
        
        public TYScythedHierodule() {

            name = "Scythed Hierodule";
            grundkosten = getPts("Scythed Hierodule") + 2*getPts("Bio-acid spray") + getPts("Massive scything talons (pair)");
            power = 22;

            add(ico = new oc.Picture("oc/wh40k/images/TYScythedHierodule.gif"));
            
            complete();

        }

	//@OVERRIDE
	public void refreshen() {
	}
}
