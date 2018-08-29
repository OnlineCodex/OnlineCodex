package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORStormboyz extends Eintrag {

	AnzahlPanel Stormboyz;
	RuestkammerStarter Boss;
	
	boolean ZagstrukSelected = false;
	
	public ORStormboyz() {

		kategorie = 4;
		grundkosten = 0;

		add(Stormboyz = new AnzahlPanel(ID, randAbstand, cnt, "Stormboyz", 5, 30, getPts("Stormboyz")));

		add(ico = new oc.Picture("oc/wh40k/images/Stormboyz.gif"));

		seperator();

		Boss = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "Boss Nob");
		Boss.initKammer(true,false,false,false,false);
		Boss.setGrundkosten(getPts("Boss Nob"));
		Boss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(Boss);
		Boss.setAbwaehlbar(false);

		complete();
	}

	
	//@OVERRIDE
	public void refreshen() {
		Boss.setAbwaehlbar(true);
		if(Stormboyz.getModelle() > 20){
			power = 13;
		} else if(Stormboyz.getModelle() > 10){
			power = 9;
		} else if(Stormboyz.getModelle() > 5){
			power = 5;
		} else {
			power = 3;
		}
	}
}
