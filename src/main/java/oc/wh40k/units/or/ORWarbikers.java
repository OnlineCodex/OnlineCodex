package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORWarbikers extends Eintrag {

	AnzahlPanel waaghbikaz;
	OptionsEinzelUpgrade trophäenstange;
	RuestkammerStarter Boss;

	public ORWarbikers() {

		kategorie = 4;
		grundkosten = 0;
		add(waaghbikaz = new AnzahlPanel(ID, randAbstand, cnt, "Warbikers", 3, 12, getPts("Warbikers")));
		add(ico = new oc.Picture("oc/wh40k/images/Waaghbike.gif"));

		seperator();

		Boss = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "Boss Nob");
		Boss.initKammer(true,false,false,false,false);
		Boss.setGrundkosten(getPts("Boss Nob"));
		add(Boss);
		Boss.setAbwaehlbar(false);
		
		complete();

	}

	//@OVERRIDE
	public void refreshen() {
		Boss.setAbwaehlbar(true);
		if(waaghbikaz.getModelle() > 9){
			power = 17;
		} else if(waaghbikaz.getModelle() > 6){
			power = 13;
		} else if(waaghbikaz.getModelle() > 3){
			power = 9;
		} else {
			power = 5;
		}
	}
}
