package oc.wh40k.units.cs;

import oc.Eintrag;
import oc.OnlineCodex;

public class CSAnggraththeUnbound extends Eintrag {

	public CSAnggraththeUnbound() {
		name = "An'ggrath the Unbound";
		grundkosten = 888;

		add(ico = new oc.Picture("oc/wh40k/images/AnggraththeUnbound.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
        if(OnlineCodex.getInstance().getKosten() < 2000 && OnlineCodex.getInstance().getCurrentArmy().equals("Chaosdaemonen")) {
            this.setFehlermeldung("Armee < 2000 Punkte");
        } else {
            this.setFehlermeldung("");
        }
	}

}
