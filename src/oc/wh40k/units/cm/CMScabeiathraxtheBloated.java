package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OnlineCodex;

public class CMScabeiathraxtheBloated extends Eintrag {

	public CMScabeiathraxtheBloated() {
		name = "Scabeiathrax the Bloated";
		grundkosten = 777;

		add(ico = new oc.Picture("oc/wh40k/images/ScabeiathraxtheBloated.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
        if(OnlineCodex.getInstance().getKosten() < 2000 && OnlineCodex.getInstance().getCurrentArmy().equals("Chaosdaemonen")) {
            this.setFehlermeldung("Armee < 2000 Punkte");
        } else if(OnlineCodex.getInstance().getKosten() < 3108 && OnlineCodex.getInstance().getCurrentArmy().equals("Renegades and Heretics")) {
            this.setFehlermeldung("Armee < 3108 Punkte");
        } else {
            this.setFehlermeldung("");
        }
	}

}
