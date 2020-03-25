package oc.wh40k.units.or;


import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORMegatrakkScrapjet extends Eintrag {

	private final AnzahlPanel buggies;
	private static OptionsEinzelUpgrade sht;
	boolean kustomJobSelected = false;
	
	public ORMegatrakkScrapjet() {

        kategorie = 4;
        grundkosten = 0;

        buggies = new AnzahlPanel(ID, randAbstand, cnt, "Megatrakk Scrapjet", "Megatrakk Scrapjets", 1, 3, getPts("Megatrakk Scrapjets") + getPts("Twin big shoota") * 2);
        add(buggies);

		seperator();
		
		add(sht = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "KJ: Korkscrew", getPts("Korkscrew")));
		
        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        power = buggies.getModelle() * 5;
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
