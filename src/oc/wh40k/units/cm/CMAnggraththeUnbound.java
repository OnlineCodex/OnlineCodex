package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OnlineCodex;

public class CMAnggraththeUnbound extends Eintrag {

	public CMAnggraththeUnbound() {
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
        } else if(OnlineCodex.getInstance().getKosten() < 3552 && OnlineCodex.getInstance().getCurrentArmy().equals("Renegades and Heretics")) {
            this.setFehlermeldung("Armee < 3552 Punkte");
        } else {
            this.setFehlermeldung("");
        }
	}

}
