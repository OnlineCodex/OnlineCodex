package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IMLandRaiderPrometheus extends Eintrag {

	public IMLandRaiderPrometheus() {
		name = "Land Raider Prometheus";
		grundkosten = getPts("Land Raider Prometheus") + 2*getPts("Quad heavy bolter");
		power = 20;

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (IA)")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (IA)")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multi-melta", getPts("Multi-melta")));
		
		complete();
	}

	@Override
	public void refreshen() {
	}
}
