package oc.wh40k.units.dk;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DKLemanRuss extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade dozer;
	OptionsEinzelUpgrade mine;

	public DKLemanRuss() {
		grundkosten = 0;
	}

  @Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGLemanRuss.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Leman Russ", 150));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Exterminator", 150));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Annihilator", 150));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Conqueror", 150));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Vanquisher", 155));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Eradicator", 160));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Demolisher", 165));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Punisher", 180));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Executioner", 190));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon", 15));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 Heavy bolters", "Pair of sponsons with Heavy bolters", 20));
		ogE.addElement(new OptionsGruppeEintrag("2 Heavy flamers", "Pair of sponsons with Heavy flamers", 20));
		ogE.addElement(new OptionsGruppeEintrag("2 Multi-meltas", "Pair of sponsons with Multi-meltas", 30));
		ogE.addElement(new OptionsGruppeEintrag("2 Plasma cannons", "Pair of sponsons with Plasma cannons", 40));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Heavy stubber", "Pintle-mounted Heavy stubber", 10));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Storm bolter", "Pintle-mounted Storm bolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Extra armour", 15));
		
		seperator();
		
		add(dozer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dozer blade", 10));
		add(mine =new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Mine plough", 10));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("co-axial Storm bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("co-axial Heavy stubber", 15));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		sizeSetzen();
	}

  @Override
	public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();

		oe1.setAktiv(!oe2.isSelected());
		oe2.setAktiv(!oe1.isSelected());
		
		dozer.setAktiv(!mine.isSelected());
		mine.setAktiv(!dozer.isSelected());

        o3.setAktiv(o1.isSelected("Leman Russ Vanquisher"));
	}

}
