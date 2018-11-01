package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORStormboyz extends Eintrag {

	AnzahlPanel stormboyz;
	RuestkammerStarter boss;
	
	public ORStormboyz() {

		kategorie = 4;
		grundkosten = 0;

		add(stormboyz = new AnzahlPanel(ID, randAbstand, cnt, "Stormboyz", 5, 30, getPts("Stormboyz")));

		add(ico = new oc.Picture("oc/wh40k/images/Stormboyz.gif"));

		seperator();

		boss = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "Boss Nob");
        ((ORWaffenUndGeschenke)boss.getKammer()).setBossNob(true);
        ((ORWaffenUndGeschenke)boss.getKammer()).setDefaultFK("Slugga");
        ((ORWaffenUndGeschenke)boss.getKammer()).setDefaultNK("Choppa");
		boss.initKammer();
		boss.setGrundkosten(getPts("Boss Nob"));
		boss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(boss);
		boss.setAbwaehlbar(false);

		complete();
	}

	
	//@OVERRIDE
	public void refreshen() {
		boss.setAbwaehlbar(true);
		if(stormboyz.getModelle() > 20){
			power = 14;
		} else if(stormboyz.getModelle() > 10){
			power = 9;
		} else if(stormboyz.getModelle() > 5){
			power = 5;
		} else {
			power = 3;
		}
	}
}
