package oc.wh40k.units.ia;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IAOfficeroftheFleet extends Eintrag {

	OptionsUpgradeGruppe o1;
	
	public IAOfficeroftheFleet() {
		name = "Officer of the Fleet";
		grundkosten = 40;

		add(ico = new oc.Picture("oc/wh40k/images/IGTechpriestEnginseer.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffe", 0));
		ogE.addElement(new OptionsGruppeEintrag("Laserpistole", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		o1.setSelected(0, true);
		
		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "", "Digitalwaffen", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "", "Refractor Feld", 10));

		seperator();
		
		complete();
	}

	@Override
	public void refreshen() {
	}

	@Override
	public void deleteYourself() {
	}

}
