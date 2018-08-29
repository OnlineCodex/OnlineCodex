package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class IMHouseholdTradition extends Eintrag {
	OptionsUpgradeGruppe fk1;
	
	public IMHouseholdTradition() {
		name = "Household Tradition";
		grundkosten = 0;
		power = 0;

		ogE.addElement(new OptionsGruppeEintrag("House Terryn", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("House Griffith", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("House Hawkshroud", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("House Cadmus", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("House Mortan", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("House Raven", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("House Taranis", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("House Krast", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("House Vulker", getPts("")));
		ogE.addElement(new OptionsGruppeEintrag("Freeblades", getPts("")));
		add(fk1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		this.eintragsCNT = 0;
		
		complete();
	}

	//@OVERRIDE
	public void refreshen() {
		fk1.alwaysSelected();
	}
}
