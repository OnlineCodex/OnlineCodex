package oc.wh40k.units.fo;

import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class FODeflektorSchildgenerator extends Eintrag {
	
	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe ozg1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelZaehler oez;
	
	public FODeflektorSchildgenerator() {
		name = "Deflektorschildgenerator";
		grundkosten = 50;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/Aegis.jpg"));
		
		seperator();
		
		add(oez = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Zus. proj. Deflektorschilde","Zusätzliche projizierte Deflektorschilde",2,25));
		
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