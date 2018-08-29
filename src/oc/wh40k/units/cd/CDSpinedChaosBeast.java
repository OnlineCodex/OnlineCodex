package oc.wh40k.units.cd;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CDSpinedChaosBeast extends Eintrag {

	public CDSpinedChaosBeast() {
		name = "Spined Chaos Beast";
		grundkosten = 140;

		add(ico = new oc.Picture("oc/wh40k/images/SpinedChaosBeast.gif"));
		
		ogE.addElement(new OptionsGruppeEintrag("Dämon des Khorne", 0));
		ogE.addElement(new OptionsGruppeEintrag("Dämon des Nurgle", 15));
		ogE.addElement(new OptionsGruppeEintrag("Dämon des Tzeentch", 5));
		ogE.addElement(new OptionsGruppeEintrag("Dämon des Slaanesh", 15));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
