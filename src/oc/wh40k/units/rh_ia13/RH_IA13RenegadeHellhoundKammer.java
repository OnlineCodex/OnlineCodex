package oc.wh40k.units.rh_ia13;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class RH_IA13RenegadeHellhoundKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;

	public RH_IA13RenegadeHellhoundKammer() {
		grundkosten = 0;
	}

  @Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGHellhound.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Renegade Hellhound", 115));
		ogE.addElement(new OptionsGruppeEintrag("Renegade Devil Dog", 125));
		ogE.addElement(new OptionsGruppeEintrag("Renegade Bane Wolf", 120));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", 5));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy stubber", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mine plough", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 10));

		sizeSetzen();
	}

  @Override
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0,true);
        if(!o2.isSelected()) o2.setSelected(0,true);
		
		oe1.setAktiv(!oe2.isSelected());
		oe2.setAktiv(!oe1.isSelected());
	}

}
