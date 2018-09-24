package oc.wh40k.units.gk;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class GKNemesisDreadknight extends Eintrag {

	OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;

	public GKNemesisDreadknight() {
		name = "Nemesis Dreadknight";
		grundkosten = 130;

		add(ico = new oc.Picture("oc/wh40k/images/GKNemesisRitter.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Nemesis-Dämonenhammer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Nemesis-Langschwert", 10));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Erlöser-Flamer", "Schwerer Erlöser-Flammenwerfer", 20));
		ogE.addElement(new OptionsGruppeEintrag("Schnellfeuer-Psipulser", 30));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Psibolter", 35));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Teleportmodul", 30));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
