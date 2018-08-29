package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMHospitaller extends Eintrag {

	OptionsUpgradeGruppe o1, o2, o3;
    RuestkammerStarter waffenUndRelikte;
    
	public IMHospitaller() {
		name = "Hospitaller";
		grundkosten = getPts("Hospitaller");
		power = 2;
		
		add(ico = new oc.Picture("oc/wh40k/images/ASPrincipalis.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Chirurgeon's tools", getPts("Chirurgeon's tools")));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		complete();
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
	}

}
