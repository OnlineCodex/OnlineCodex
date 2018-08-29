package oc.wh40k.units.kd;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class KDLordOfSkulls extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;

	
	public KDLordOfSkulls() {
		name = "Lord Of Skulls";
		grundkosten = 888;
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Blutsturmkanone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Ichorkanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Dämonenblutkanone", 65));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Hades-Gatlingkanone", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schädelwerfer", 60));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		complete();
	}

	@Override
	public void refreshen() {
	 o1.alwaysSelected();
	 o2.alwaysSelected();
	 
	}

}
