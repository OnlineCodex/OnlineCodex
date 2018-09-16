package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OnlineCodex;

public class CMAetaosraukeresSlayerofSouls extends Eintrag {

	public CMAetaosraukeresSlayerofSouls() {
		name = "Aetaos'rau'keres - Slayer of Souls";
		grundkosten = 999;

		add(ico = new oc.Picture("oc/wh40k/images/AetaosraukeresSlayerofSouls.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
        if(OnlineCodex.getInstance().getKosten() < 3996 && OnlineCodex.getInstance().getCurrentArmy().equals("Chaosdaemonen")) {
            this.setFehlermeldung("Armee < 2000 Punkte");
        } else if(OnlineCodex.getInstance().getKosten() < 3996 && OnlineCodex.getInstance().getCurrentArmy().equals("Renegades and Heretics")) {
            this.setFehlermeldung("Armee < 3996 Punkte");
        } else {
            this.setFehlermeldung("");
        }
	}

}
