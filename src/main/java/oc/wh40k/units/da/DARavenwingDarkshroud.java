package oc.wh40k.units.da;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
public class DARavenwingDarkshroud extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade ej;

	boolean added = false;

	public DARavenwingDarkshroud() {
		name = "Landspeeder Darkshroud";
		grundkosten = 80;
	
		seperator();
        	
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		o1.setSelected(0, true);

		seperator();
	}

	@Override
	public void refreshen() {
	}

	@Override
	public void deleteYourself() {

		super.deleteYourself();
	}

}
