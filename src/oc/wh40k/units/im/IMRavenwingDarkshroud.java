package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMRavenwingDarkshroud extends Eintrag {

	OptionsUpgradeGruppe o1;
	
	public IMRavenwingDarkshroud() {
		name = "Ravenwing Darkshroud";
		grundkosten = getPts("Ravenwing Darkshroud");
		power = 7;
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Assault cannon", getPts("Assault cannon")));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
	}
}
