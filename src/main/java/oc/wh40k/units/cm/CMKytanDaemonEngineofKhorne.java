//IA1 2nd Ed

package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;

public class CMKytanDaemonEngineofKhorne extends Eintrag {

	OptionsUpgradeGruppe o1;
	
	public CMKytanDaemonEngineofKhorne() {
		name = "Kytan Daemon Engine of Khorne";
		grundkosten = 525;
                
		complete();
	}

	public void refreshen() {
		getCountFromInformationVector("");
		if(buildaVater.reflectionKennungLokal=="KD"){
			o1.setSelected(0, true);
		}
	}
}

