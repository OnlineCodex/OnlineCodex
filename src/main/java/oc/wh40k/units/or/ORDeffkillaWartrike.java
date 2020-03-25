package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORDeffkillaWartrike extends Eintrag {

	private final RuestkammerStarter waffen;
	private static OptionsEinzelUpgrade sht;
	boolean kustomJobSelected = false;
	
	public ORDeffkillaWartrike() {
        name = "Deffkilla Wartrike";
        grundkosten = getPts("Deffkilla Wartrike");
        power = 6;

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, ORWaffenUndGeschenke.class, "");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setDefaultRanged("no weapon");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setDefaultCloceCombat("no weapon");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setName(name);
        waffen.initKammer(false, false, false, false, false, false, true, false);
        waffen.setButtonText("Waffen und Geschenke");
        add(waffen);
        waffen.setAbwaehlbar(false);

        seperator();

		addWarlordTraits("", true);

		seperator();
		
		add(sht = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "KJ: Gork's Roar", getPts("Gork's Roar")));
		
        complete();
    }

    @Override
    public void refreshen() {
    	warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) waffen.getPanel().getLocation().getY() + waffen.getPanel().getSize().height + 5
        );
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