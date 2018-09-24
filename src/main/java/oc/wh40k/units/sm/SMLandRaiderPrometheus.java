package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMLandRaiderPrometheus extends Eintrag {

	OptionsUpgradeGruppe o1;

	public SMLandRaiderPrometheus() {
		name = "Land Raider Prometheus";
		grundkosten = 270;
		
		add(ico = new oc.Picture("oc/wh40k/images/SMLandRaiderPrometheus.jpg"));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter",5));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
