package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;

public class ORMekboyWorkshop extends Eintrag {


    public ORMekboyWorkshop() {

        kategorie = 1;
        name = "Mekboy Workshop";
        grundkosten = getPts("Mekboy Workshop");
        power = 5;

        add(ico = new oc.Picture("oc/wh40k/images/GhazghkullThraka.gif"));

        int i = BuildaHQ.getCountFromInformationVectorGlobal("KustomJobs");
		BuildaHQ.setInformationVectorValueGlobal("KustomJobs", i-1);
		
        complete();
    }
       
    //@OVERRIDE
    @Override
	public void deleteYourself() {
        super.deleteYourself();
   		int i = BuildaHQ.getCountFromInformationVectorGlobal("KustomJobs");
    	BuildaHQ.setInformationVectorValueGlobal("KustomJobs", i+1);
    }
}
