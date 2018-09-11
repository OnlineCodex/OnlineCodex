package oc.wh40k.units.hhca;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;

public class HHCAGarvielLoken extends Eintrag {
	
	OptionsUpgradeGruppe o0;

	public HHCAGarvielLoken() {
		name = "Garviel Loken";
		grundkosten = 175;

		add(ico = new oc.Picture("oc/wh40k/images/xy.jpg"));

		addToInformationVector("HHCAPraetor", 1);

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
	@Override
	public void deleteYourself() {
		
		addToInformationVector("HHCAPraetor", -1);
		super.deleteYourself();
	}
	

}