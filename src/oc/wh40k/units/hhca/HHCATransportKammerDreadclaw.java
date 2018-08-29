package oc.wh40k.units.hhca;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class HHCATransportKammerDreadclaw  extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o2;

	public HHCATransportKammerDreadclaw () {
            grundkosten = 85;
	}

	public void initButtons(boolean... defaults) {

		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Drop Pod", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
				
        sizeSetzen();
	}

	@Override
	public void refreshen() {
			
		if(!o1.isSelected()) o1.setSelected(0, true);	
	}
        
}