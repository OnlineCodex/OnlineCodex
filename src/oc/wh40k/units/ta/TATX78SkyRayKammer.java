package oc.wh40k.units.ta;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class TATX78SkyRayKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o3;
	
	public TATX78SkyRayKammer() {
		grundkosten = 115;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/DornenhaiGross.gif"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 MV1 Gun Drones", getPts("MV1 Gun Drone")*2 + getPts("Pulse carbine")*4));
		ogE.addElement(new OptionsGruppeEintrag("2 Burst cannons", getPts("Burst cannon")*2));
		ogE.addElement(new OptionsGruppeEintrag("2 Smart missile systems", getPts("Smart missile system")*2));
		o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
		add(o3);
		
		seperator();

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
		if(!o3.isSelected()) o3.setSelected(0, true);
	}
	
}
