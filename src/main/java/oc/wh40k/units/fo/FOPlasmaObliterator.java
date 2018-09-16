package oc.wh40k.units.fo;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class FOPlasmaObliterator extends Eintrag {
	
	OptionsUpgradeGruppe o1;
	RuestkammerStarter hauptGeb;
	RuestkammerStarter hauptHind;

	public FOPlasmaObliterator() {
		name = "Plasma Obliterator";
		grundkosten = 230;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/Aegis.jpg"));

		seperator();
		
		hauptGeb = new RuestkammerStarter(ID, randAbstand, cnt, "FOGebaeude", "Gebäude");
		hauptGeb.initKammer(true);
		hauptGeb.setUeberschriftTrotzNullKostenAusgeben(true);
		add(hauptGeb);
		
		hauptHind = new RuestkammerStarter(ID, randAbstand, cnt, "FOHindernisse", "Hindernisse");
		hauptHind.initKammer();
		hauptGeb.setUeberschriftTrotzNullKostenAusgeben(true);
		add(hauptHind);
		
		complete();
	}

	@Override
	public void refreshen() {
	}
}