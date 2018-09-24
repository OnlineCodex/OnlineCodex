package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelZaehler;

public class ORKopphammaMegapanza extends Eintrag {

    OptionsEinzelZaehler o1;
    OptionsEinzelZaehler o2;
    OptionsEinzelZaehler o3;

	public ORKopphammaMegapanza() {
		name = "Kopphamma-Megapanza";
		grundkosten = 400;


		add(ico = new oc.Picture("oc/wh40k/images/KopphammaMegapanza.gif"));
		

        add(o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Supa-Grotraketänz", 3, 15));
        
        seperator();
        
        add(o2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "fette Wumme", "synchronisierte fette Wumme", 2, 0));
        add(o3 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Bazzukka", "synchronisierte Bazzukka", 2, 0));

		complete();

	}

	public void refreshen() {
        o2.setAnzahl(2 - o3.getAnzahl());
	}
}
