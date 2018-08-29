package oc.wh40k.units.in;

import oc.Eintrag;
import oc.RuestkammerStarter;


public class INOrdoXenosInquisitorSolomonLok extends Eintrag {

	RuestkammerStarter rk1;

	public INOrdoXenosInquisitorSolomonLok() {
		name = "Ordo Xenos Inquisitor Solomon Lok";
		grundkosten = 60;
		add(ico = new oc.Picture("oc/wh40k/images/GKInquisitorCoteaz.jpg"));
		
		seperator();
		
		 rk1 = new RuestkammerStarter(ID, randAbstand, cnt, "INGefolgedesInquisitorsKammer", "");
        rk1.initKammer();
        rk1.setButtonText("Gefolge");
        rk1.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rk1);
		
		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}

}
