package oc.wh40k.units.cs;

import oc.Eintrag;
import oc.OnlineCodex;

public class CSScabeiathraxtheBloated extends Eintrag {

	public CSScabeiathraxtheBloated() {
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
        } else {
            this.setFehlermeldung("");
        }
	}

}
