package oc.wh40k.units.kd;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class KDHeldrake extends Eintrag {

	OptionsEinzelUpgrade o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;

	public KDHeldrake() {
		name = "Heldrake";
		grundkosten = 170;

		add(ico = new oc.Picture("oc/wh40k/images/Höllendrache.gif"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Hades-MaschKa", "Hades-Maschinenkanone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Hexenfeuerwerfer", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);
		
		seperator();
        
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fliegerass", 50));
        
		complete();
	}

	@Override
	public void refreshen() {
		
	}

}
