package oc.wh40k.units.am;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class AMValkyreSkyTalonTransport extends  Eintrag{

	OptionsUpgradeGruppe o2;

	public AMValkyreSkyTalonTransport() {
		name = "Valkyre Sky Talon Transport";
		grundkosten = 70;
		setEintragsCNT(0);

		add(ico = new oc.Picture("oc/wh40k/images/ABVulture.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("2 Hellstrike missiles", 0));
		ogE.addElement(new OptionsGruppeEintrag("2 Rocket pods", "2 Multiple rocket pods", 30));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
	}

	@Override
	public void refreshen() {
        o2.alwaysSelected();
	}

}