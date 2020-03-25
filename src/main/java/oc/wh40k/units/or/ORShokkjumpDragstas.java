package oc.wh40k.units.or;


import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORShokkjumpDragstas extends Eintrag {

	private final AnzahlPanel buggies;
	private static OptionsEinzelUpgrade sht;
	boolean kustomJobSelected = false;
	
    public ORShokkjumpDragstas() {

        kategorie = 4;
        grundkosten = 0;

        buggies = new AnzahlPanel(ID, randAbstand, cnt, "Shokkjump Dragsta", "Shokkjump Dragstas", 1, 3, getPts("Shokkjump Dragstas") + getPts("Rokkit launcha"));
        add(buggies);

        add(ico = new oc.Picture("oc/wh40k/images/Buggie.gif"));
        seperator();
		
		add(sht = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "KJ: Gyroscopic Whirlgig", getPts("Gyroscopic Whirlgig")));
		
        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {

        power = buggies.getModelle() * 6;
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
