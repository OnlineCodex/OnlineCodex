package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMCaladiusGravTank extends Eintrag {
	OptionsUpgradeGruppe o1, o2, o3, o4, o5;

	public IMCaladiusGravTank() {
		name = "Caladius Grav-tank";
		grundkosten = getPts("Caladius Grav-tank");
		power = 8;

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Twin Iliastus accelerator cannon", getPts("Twin Iliastus accelerator cannon")));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Twin Lastrum bolt cannon", getPts("Twin Lastrum bolt cannon")));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);
		
		complete();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
		o2.alwaysSelected();
	}
}
