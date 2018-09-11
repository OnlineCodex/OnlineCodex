package oc.wh40k.units.am;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class AMHydraPlatformBattery extends Eintrag {

	AnzahlPanel Buggies;
	OptionsEinzelUpgrade Rot‰Farb‰;

	public AMHydraPlatformBattery() {

		kategorie = 4;
		grundkosten = 0;

		Buggies = new AnzahlPanel(ID, randAbstand, cnt, "Hydra Platform","Hydra Platforms", 1, 3, 50);
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
