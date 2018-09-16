package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORFlakpanza extends Eintrag {

	public ORFlakpanza() {
		name = "Flakpanza";
		grundkosten = 60;


		add(ico = new oc.Picture("oc/wh40k/images/Flakpanza.gif"));
		


        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Leuchtspurwumme", "Grot-Leuchtspurwumme", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rotä Farbä", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot Hälfaz", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Panzaplattenz", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Abrizzbirnä", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vastärktä Rammä", 5));

		complete();

	}

	public void refreshen() {
	}
}
