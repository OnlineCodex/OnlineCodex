package oc.wh40k.units.dkab;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DKABGriffon extends RuestkammerVater {
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
    OptionsUpgradeGruppe o4;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;

	public DKABGriffon() {
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
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 15));
		

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozerblade", 5));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mine plough", 15));
        
		sizeSetzen();
	}

  @Override
	public void refreshen() {
		o1.alwaysSelected();
        o2.alwaysSelected();
        
        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());
	}
}