package oc.wh40k.units.am;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class AMEarthshakerPlatformBattery extends Eintrag {

	AnzahlPanel Buggies;
	OptionsEinzelUpgrade Rot‰Farb‰;

	public AMEarthshakerPlatformBattery() {

		kategorie = 4;
		grundkosten = 0;

		Buggies = new AnzahlPanel(ID, randAbstand, cnt, "Earthshaker Platform","Earthshaker Platforms", 1, 3, 75);
		add(Buggies);

		add(ico = new oc.Picture("oc/wh40k/images/Buggie.gif"));
		seperator();

		
		add(Rot‰Farb‰ = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Camo-netting", 20));
		
		complete();
	}

	//@OVERRIDE
	public void refreshen() {

		Rot‰Farb‰.setPreis(Buggies.getModelle()*20);
	}
}
