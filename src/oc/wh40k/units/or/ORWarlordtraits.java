package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ORWarlordtraits extends Eintrag {
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe fk1;
	OptionsZaehlerGruppe fk2;
	AnzahlPanel squad;
	
	public ORWarlordtraits() {
		name = "Armiger Helverin";
		grundkosten = 0;
		power = 0;

		ogE.addElement(new OptionsGruppeEintrag("Might is Right", getPts("")));
		add(fk1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		this.eintragsCNT = 0;
		
		complete();
	}

	//@OVERRIDE
	public void refreshen() {
		fk1.alwaysSelected();
	}
}
