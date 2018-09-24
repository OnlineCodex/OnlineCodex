package oc.wh40k.units.cd;

import oc.BuildaHQ;
import oc.Eintrag;

public class CDSchicksalsweberOrakeldesTzeentch extends Eintrag {

	public CDSchicksalsweberOrakeldesTzeentch() {

		name = "Schicksalsweber, Orakel des Tzeentch";

		grundkosten = 300;

		add(ico = new oc.Picture("oc/wh40k/images/CDSchicksalsweberOrakeldesTzeentch.gif"));

		addToInformationVector("CDDämonenprinz", 1);
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Dämonenprinz des Tzeentch");
		BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Dämonenprinz des Tzeentch");
		
		complete();

	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
	@Override
	public void deleteYourself() {
		addToInformationVector("CDDämonenprinz", -1);
		if(getCountFromInformationVector("CDDämonenprinz")<1){
			BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Dämonenprinz des Tzeentch");
			BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Dämonenprinz des Tzeentch");
		}
		super.deleteYourself();
	}
}
