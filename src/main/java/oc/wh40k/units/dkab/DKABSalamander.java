package oc.wh40k.units.dkab;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DKABSalamander extends RuestkammerVater {

	public DKABSalamander() {
		grundkosten = 55;
	}
	
  @Override
	public void initButtons(boolean... defaults) {
	  	ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", 10));
		ogE.addElement(new OptionsGruppeEintrag("Storm bolter", 10));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE,1));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Armoured track guards", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Extra armour", 10));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Dozer blade", 5));
		ogE.addElement(new OptionsGruppeEintrag("Mine plough", 15));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE,1));

		sizeSetzen();
	}

  @Override
	public void refreshen() {
	}

}
