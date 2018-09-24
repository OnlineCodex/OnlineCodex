package oc.wh40k.units.fo;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class FOEhrwuerdigesImperium1 extends Eintrag {
	
	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe ozg1;
	OptionsUpgradeGruppe o2;

	public FOEhrwuerdigesImperium1() {
		name = "Ehrwürdiges Imperium1";
		grundkosten = 40;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/Aegis.jpg"));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Stacheldraht", 5));
		ogE.addElement(new OptionsGruppeEintrag("Barrikaden", 10));
		ogE.addElement(new OptionsGruppeEintrag("Panzersperren", 15));
		add(ozg1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,6));
		complete();
	}

	@Override
	public void refreshen() {
	}
}