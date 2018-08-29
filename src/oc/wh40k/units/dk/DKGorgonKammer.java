package oc.wh40k.units.dk;

import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class DKGorgonKammer extends RuestkammerVater {

	public DKGorgonKammer() {}
	
	public void initButtons(boolean... b) {
		name = "Gorgon";
		grundkosten = 430;


		add(ico = new oc.Picture("oc/wh40k/images/Gorgon.gif"));
		

                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "hunter-killer missile", 10));
                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "camo-netting", 20));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "improved comms", 0));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "searchlight", 0));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "smoke launchers", 0));
                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "extra armor", 15));

		sizeSetzen();

	}

	public void refreshen() {
	}
}
