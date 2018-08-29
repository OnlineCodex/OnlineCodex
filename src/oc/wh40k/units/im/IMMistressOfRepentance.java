package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMMistressOfRepentance extends Eintrag {

	OptionsUpgradeGruppe o1, o2, o3;
    RuestkammerStarter waffenUndRelikte;
    
	public IMMistressOfRepentance() {
		name = "Mistress of Repentance";
		grundkosten = getPts("Mistress of Repentance");
		power = 2;
		
		add(ico = new oc.Picture("oc/wh40k/images/ASPrincipalis.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Neural whips", getPts("Neural whips")));
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
