package oc.wh40k.units.rh_ia13;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class RH_IA13RenegadeBombardKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade mt;

	boolean paskSelected = false;

	public RH_IA13RenegadeBombardKammer() {
		grundkosten = 145;}

	public void initButtons(boolean... defaults) {
	

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Enclosed crew compartment", 15));
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Storm bolter", 5));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Heavy stubber", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dozer blade", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Extra armour", 10));
		add(mt = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Militia Training", 10));
		
		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
        if(!o2.isSelected()) o2.setSelected(0,true);
		
		oe1.setAktiv(!oe2.isSelected());
		oe2.setAktiv(!oe1.isSelected());
		
		if(BuildaHQ.aktBuildaVater.getCountFromInformationVector("RHBloodyHandedReaver")==1){
        	mt.setSelected(true);
		}
	}

}
