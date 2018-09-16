package oc.wh40k.units.dksr;

import oc.AnzahlPanel;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DKSRHeavyArtilleryCarriage extends RuestkammerVater {

    AnzahlPanel squad;
	OptionsUpgradeGruppe o1;

	public DKSRHeavyArtilleryCarriage() {
		grundkosten = 0;
	}
	
    @Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGOrdnanceTank.jpg"));

		ogE.addElement(new OptionsGruppeEintrag("Earthshaker cannon", 75));
		ogE.addElement(new OptionsGruppeEintrag("Medusa siege gun", 100));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Crew", 4, 8, 8));
        squad.setGrundkosten(-32);
        squad.setNichtDieErsteOption(true);


		sizeSetzen();
	}

    @Override
	public void refreshen() {
        o1.alwaysSelected();
	}

}
