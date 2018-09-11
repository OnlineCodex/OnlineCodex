package oc.wh40k.units.ab;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ABGriffon extends RuestkammerVater {
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
    OptionsUpgradeGruppe o4;

	public ABGriffon() {
		grundkosten = 0;
	}

  @Override
	public void initButtons(boolean... defaults) {
        
	  	ogE.addElement(new OptionsGruppeEintrag("Griffon", 75));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
	  
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		
        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", 10));
		ogE.addElement(new OptionsGruppeEintrag("Storm bolter", 10));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Enclosed crew compartment", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozerblade", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 15));
        
		sizeSetzen();
	}

  @Override
	public void refreshen() {
		o1.alwaysSelected();
        o2.alwaysSelected();
	}
}