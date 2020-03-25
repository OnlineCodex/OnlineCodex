package oc.wh40k.units.or;


import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORRukkatrukkSquigbuggys extends Eintrag {

	private final AnzahlPanel buggies;
	private static OptionsEinzelUpgrade sht;
	boolean kustomJobSelected = false;
	
    public ORRukkatrukkSquigbuggys() {

        kategorie = 4;
        grundkosten = 0;

        buggies = new AnzahlPanel(ID, randAbstand, cnt, "Rukkatrukk Squigbuggy", "Rukkatrukk Squigbuggies", 1, 3, getPts("Rukkatrukk Squigbuggies"));
        add(buggies);

		seperator();
		
		add(sht = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "KJ: Nitro-Powered Squigs", getPts("Nitro-Powered Squigs")));
		
        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        power = buggies.getModelle() * 7;
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
