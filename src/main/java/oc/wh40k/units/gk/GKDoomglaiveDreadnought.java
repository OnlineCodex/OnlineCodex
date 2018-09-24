package oc.wh40k.units.gk;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class GKDoomglaiveDreadnought extends Eintrag {


	public GKDoomglaiveDreadnought() {
            name = "Doomglaive Dreadnought";
            grundkosten = 190;

            add(ico = new oc.Picture("oc/wh40k/images/GKCybot.jpg"));
            
            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Warpstabilisierungsfeld", 5));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wahrsilberpanzerung", 10));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));

            complete();
	}

	@Override
	public void refreshen() {
	}

}
