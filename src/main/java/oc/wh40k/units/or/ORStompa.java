package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;

public class ORStompa extends Eintrag {
	
	boolean kustomJobSelected = false;
	private final OptionsEinzelUpgrade sht;
	
    public ORStompa() {
        name = "Stompa";
        grundkosten = getPts("Stompa") +
                getPts("Deffkannon") +
                getPts("Supa Gatler") +
                getPts("Big shoota") * 3 +
                getPts("Twin big shoota") +
                getPts("Supa-rokkit") +
                getPts("Skorcha") +
                getPts("Mega-choppa");
        power = 46;

        add(ico = new oc.Picture("oc/wh40k/images/Stampfa.gif"));

        seperator();

        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Additional Supa-rokkits", 2, getPts("Supa-rokkit")));

        seperator();

		add(sht = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "KJ: Blitza-Gatler", getPts("Gork's Roar")));
		
        complete();

    }

    @Override
	public void refreshen() {
    	if(sht.isSelected() && !kustomJobSelected) {
    		int i = BuildaHQ.getCountFromInformationVectorGlobal("KustomJobs");
    		BuildaHQ.setInformationVectorValueGlobal("KustomJobs", i+1);
    		kustomJobSelected = true;
    	} else if(!sht.isSelected() && kustomJobSelected) {
    		int i = BuildaHQ.getCountFromInformationVectorGlobal("KustomJobs");
    		BuildaHQ.setInformationVectorValueGlobal("KustomJobs", i-1);
    		kustomJobSelected = false;
    	}
    }
    
    //@OVERRIDE
    @Override
	public void deleteYourself() {
        super.deleteYourself();

        if(kustomJobSelected) {
    		int i = BuildaHQ.getCountFromInformationVectorGlobal("KustomJobs");
    		BuildaHQ.setInformationVectorValueGlobal("KustomJobs", i-1);
    		kustomJobSelected = false;
    	}
    }
}