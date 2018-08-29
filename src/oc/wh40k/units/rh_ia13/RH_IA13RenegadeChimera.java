package oc.wh40k.units.rh_ia13;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class RH_IA13RenegadeChimera extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade mt;

	public RH_IA13RenegadeChimera() {
		grundkosten = 55;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/RHChimera.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Multi-laser", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Autocannon", 5));
		ogE.addElement(new OptionsGruppeEintrag("TL Heavy bolters", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		add(mt = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Militia Training", 10));
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", 5));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy stubber", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mine plough", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Camo netting", 15));

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
		oe1.setAktiv(!oe2.isSelected());
		oe2.setAktiv(!oe1.isSelected());

        o1.alwaysSelected();
        o2.alwaysSelected();
        
        if(BuildaHQ.aktBuildaVater.getCountFromInformationVector("RHBloodyHandedReaver")==1){
        	mt.setSelected(true);
		}
	}

}
