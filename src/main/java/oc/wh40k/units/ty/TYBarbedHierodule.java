//IA Xenos + FAQ 1.0

package oc.wh40k.units.ty;



import oc.Eintrag;



public class TYBarbedHierodule extends Eintrag {



    public TYBarbedHierodule() {



        name = "Barbed Hierodule";

        grundkosten = getPts("Barbed Hierodule") + getPts("Bio-cannon") + getPts("Massive scything talons (single)");

        power = 22;



        add(ico = new oc.Picture("oc/wh40k/images/TYJagdhierodule.gif"));



        complete();



    }



    //@OVERRIDE

    @Override
	public void refreshen() {

    }

}