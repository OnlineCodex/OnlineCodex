package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ORTrukk extends Eintrag {

	private static OptionsEinzelUpgrade sht;
	boolean kustomJobSelected = false;
	
	public ORTrukk() {
        grundkosten = getPts("Trukk") + getPts("Big shoota");
        power = 3;
        name = "Trukk";
        add(ico = new oc.Picture("oc/wh40k/images/Pikk-Up.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Wreckin' ball", getPts("Wreckin' ball")));
        ogE.addElement(new OptionsGruppeEintrag("Grabbin' klaw", getPts("Grabbin' klaw")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbomb Chukka", getPts("Stikkbomb chukka")));

		seperator();
		
		add(sht = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "KJ: Squig-Hife Tyres", getPts("Squig-Hife Tyres")));
		
        complete();
    }

    // @OVERRIDE
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
