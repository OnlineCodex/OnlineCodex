//IA1 2nd Ed

package oc.wh40k.units.cs;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;

public class CSKytanDaemonEngineofKhorne extends Eintrag {

	OptionsUpgradeGruppe o1;
	
	public CSKytanDaemonEngineofKhorne() {
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

