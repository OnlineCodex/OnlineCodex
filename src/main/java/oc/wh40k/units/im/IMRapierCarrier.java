//IA Adeptus Astartes + FAQ 1.0
package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class IMRapierCarrier extends Eintrag {

	OptionsUpgradeGruppe o1;

	public IMRapierCarrier() {
		name = "Rapier Carrier";
		grundkosten = getPts("Rapier Weapons Battery Carrier") + 2*getPts("Space Marine Gunners") + 2*getPts("Bolt pistol") + 2*getPts("Frag grenade") + 1*getPts("Krak grenade");
		power = 4;
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Quad heavy bolter", getPts("Quad heavy bolter")));
		ogE.addElement(new OptionsGruppeEintrag("Laser destroyer", getPts("Laser destroyer")));
		ogE.addElement(new OptionsGruppeEintrag("Quad launcher", getPts("Quad launcher")));	//Änderung FAQ IA Adeptus Astartes 1.0
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
	}
}
