package oc.wh40k.units.or;


import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORKustomBoostaBlastas extends Eintrag {

	private final AnzahlPanel buggies;
	private static OptionsEinzelUpgrade sht;
	boolean kustomJobSelected = false;
	
    public ORKustomBoostaBlastas() {

        kategorie = 4;
        grundkosten = 0;

        buggies = new AnzahlPanel(ID, randAbstand, cnt, "Kustom Boosta-Blasta", "Kustom Boosta-Blastas", 1, 3, getPts("Kustom Boosta-Blastas"));
        add(buggies);

        add(ico = new oc.Picture("oc/wh40k/images/Buggie.gif"));

		seperator();
		
		add(sht = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "KJ: Sizzly Rivets", getPts("Sizzly Rivets")));
		
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
