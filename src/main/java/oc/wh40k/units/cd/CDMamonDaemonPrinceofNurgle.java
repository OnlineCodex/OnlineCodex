package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDMamonDaemonPrinceofNurgle extends Eintrag {

	public CDMamonDaemonPrinceofNurgle() {
		name = "Mamon, Daemon Prince of Nurgle";
		grundkosten = 220;

		add(ico = new oc.Picture("oc/wh40k/images/CDMamon.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
