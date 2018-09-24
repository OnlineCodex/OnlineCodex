package oc.wh40k.units.am;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class AMHydraPlatformBattery extends Eintrag {

	AnzahlPanel Buggies;
	OptionsEinzelUpgrade RotäFarbä;

	public AMHydraPlatformBattery() {

		kategorie = 4;
		grundkosten = 0;

		Buggies = new AnzahlPanel(ID, randAbstand, cnt, "Hydra Platform","Hydra Platforms", 1, 3, 50);
		add(Buggies);

		add(ico = new oc.Picture("oc/wh40k/images/Buggie.gif"));
		seperator();

		
		add(RotäFarbä = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Camo-netting", 20));
		
		complete();
	}

	//@OVERRIDE
	public void refreshen() {

		RotäFarbä.setPreis(Buggies.getModelle()*20);
	}
}
