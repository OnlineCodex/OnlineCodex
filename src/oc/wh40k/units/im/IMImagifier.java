package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMImagifier extends Eintrag {

	OptionsUpgradeGruppe o1, o2, o3;
    RuestkammerStarter waffenUndRelikte;
    
	public IMImagifier() {
		name = "Imagifier";
		grundkosten = getPts("Imagifier");
		power = 2;
		
		add(ico = new oc.Picture("oc/wh40k/images/ASPrincipalis.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun")));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		complete();
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
		o2.alwaysSelected();
	}

}
