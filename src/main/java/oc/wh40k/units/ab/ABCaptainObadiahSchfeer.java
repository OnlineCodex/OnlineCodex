package oc.wh40k.units.ab;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;

public class ABCaptainObadiahSchfeer extends Eintrag {

    OptionsUpgradeGruppe oAce;

	public ABCaptainObadiahSchfeer() {
		name = "Captain Obadiah Schfeer (Steel Dog Alpha)";
		grundkosten = 260;
		add(ico = new oc.Picture("oc/wh40k/images/ABSteelDogAlpha.jpg"));
		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
}
