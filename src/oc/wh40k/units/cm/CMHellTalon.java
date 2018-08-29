package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CMHellTalon extends Eintrag {

    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;

	public CMHellTalon() {
		name = "Hell Talon";
		grundkosten = 185;

		add(ico = new oc.Picture("oc/wh40k/images/HellTalon.gif"));
		

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Possession", 20));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Autocannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Tactical bombs", 0));
		ogE.addElement(new OptionsGruppeEintrag("[Apo] Heavy bombs", 15));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
        o2.alwaysSelected();
        o3.alwaysSelected();
	}

}
