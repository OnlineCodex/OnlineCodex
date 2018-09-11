package oc.wh40k.units.ia;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;
import oc.Eintrag;

public class IAChimera extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o1x;
	OptionsUpgradeGruppe o2x;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;

	public IAChimera() {
		grundkosten = 55;

		add(ico = new oc.Picture("oc/wh40k/images/IGChimaere.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Multilaser", 0));
		add(o1x = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
		//ogE.addElement(new OptionsGruppeEintrag("Autocannon [IA1 2nd Ed]", 5));//TODO separater Einheitseintrag 
		//ogE.addElement(new OptionsGruppeEintrag("TL Heavy bolters [IA1 2nd Ed]", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
		add(o2x = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Psiaktive Munition", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wahrsilberpanzerung", 10));

		complete();
	}

  @Override
	public void refreshen() {

    o1x.setSelected(0, !o1.isSelected());
    o2x.setSelected(0, !o2.isSelected());
	}

}
