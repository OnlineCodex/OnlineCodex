package oc.wh40k.units.rh_ia13;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class RH_IA13RenegadeBlightDrones extends Eintrag {

    OptionsEinzelUpgrade o1;
    OptionsEinzelUpgrade o2;

	public RH_IA13RenegadeBlightDrones() {
		grundkosten = 0;

		add(ico = new oc.Picture("oc/wh40k/images/CMBlightDroneofNurgle.jpg"));

        add(new AnzahlPanel(ID, randAbstand, cnt, "Blight Drone", "Blight Drones", 1, 3, 150));

        addToInformationVector("RHBlightDrones", +1);
        
		complete();
	}

	@Override
	public void refreshen() {
		if(getCountFromInformationVector("RHBlightDrones") > 1) {
			setFehlermeldung("0-1 Auswahl!");
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		addToInformationVector("RHBlightDrones", -1);
	}
	
}
