package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORLootas extends Eintrag {

	AnzahlPanel Pluenderaz;
	RuestkammerStarter Spanner1;
	RuestkammerStarter Spanner2;
	RuestkammerStarter Spanner3;

	public ORLootas() {

		//kategorie = 2;

		grundkosten = 0;
		add(Pluenderaz = new AnzahlPanel(ID, randAbstand, cnt, "Lootas", 5, 15, getPts("Lootas") + getPts("Deffgun") + getPts("Stikkbombs")));
		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/Pluenderaz.gif"));

		Spanner1 = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "Spanner");
        ((ORWaffenUndGeschenke)Spanner1.getKammer()).setKillsawNK(true);
        Spanner1.initKammer(false,false,true,false,false,false);
        Spanner1.setGrundkosten(getPts("Spanner"));
        add(Spanner1);
        
        seperator();

		Spanner2 = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "Spanner");
        ((ORWaffenUndGeschenke)Spanner2.getKammer()).setKillsawNK(true);
        Spanner2.initKammer(false,false,true,false,false,false);
        Spanner2.setGrundkosten(getPts("Spanner"));
        add(Spanner2);
        
        seperator();

		Spanner3 = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "Spanner");
        ((ORWaffenUndGeschenke)Spanner3.getKammer()).setKillsawNK(true);
        Spanner3.initKammer(false,false,true,false,false,false);
        Spanner3.setGrundkosten(getPts("Spanner"));
        add(Spanner3);

		complete();

	}
	
	
	//@OVERRIDE
	public void refreshen() {
		if(Pluenderaz.getModelle() > 10){
			power = 16;
		} else if(Pluenderaz.getModelle() > 5){
			power = 12;
		} else {
			power = 8;
		}
	}
}
