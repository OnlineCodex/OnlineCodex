package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerStarter;

public class ORWarbikers extends Eintrag {

	AnzahlPanel waaghbikaz;
	OptionsEinzelUpgrade trophäenstange;
	RuestkammerStarter Boss;
	OptionsEinzelZaehler sluggas;
	OptionsEinzelZaehler choppas;
	OptionsEinzelZaehler stikks;

	public ORWarbikers() {

		kategorie = 4;
		grundkosten = 0;
		add(waaghbikaz = new AnzahlPanel(ID, randAbstand, cnt, "Warbikers", 3, 12, getPts("Warbikers")));
		add(ico = new oc.Picture("oc/wh40k/images/Waaghbike.gif"));
		
		seperator();
		
		add(sluggas = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Slugga", waaghbikaz.getModelle(), getPts("Slugga")));
		add(choppas = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Choppa", waaghbikaz.getModelle(), getPts("Choppa")));
		add(stikks = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Stikkbombs", waaghbikaz.getModelle(), getPts("Stikkbombs")));

		seperator();

		Boss = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "Boss Nob");//TODO: Nob-Waffen
		Boss.initKammer(true,false,false,false,false);
		Boss.setGrundkosten(getPts("Boss Nob"));
		add(Boss);
		
		complete();

	}

	//@OVERRIDE
	public void refreshen() {
		sluggas.setMaxAnzahl(waaghbikaz.getModelle() - (Boss.isSelected()?1:0));
		choppas.setMaxAnzahl(waaghbikaz.getModelle() - (Boss.isSelected()?1:0));
		stikks.setMaxAnzahl(waaghbikaz.getModelle());
		
		
		Boss.setAbwaehlbar(true);
		if(waaghbikaz.getModelle() > 9){
			power = 14;
		} else if(waaghbikaz.getModelle() > 6){
			power = 11;
		} else if(waaghbikaz.getModelle() > 3){
			power = 7;
		} else {
			power = 4;
		}
	}
}
