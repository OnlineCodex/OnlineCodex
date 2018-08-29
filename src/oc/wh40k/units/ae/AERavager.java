package oc.wh40k.units.ae;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class AERavager extends Eintrag {
	
	OptionsZaehlerGruppe o1, o2;

	public AERavager() {
		name = "Ravager";
		grundkosten = getPts("Ravager") + getPts("Bladevanes");

		power = 8;

		ogE.addElement(new OptionsGruppeEintrag("Dark lance", getPts("Dark lance")));
    	ogE.addElement(new OptionsGruppeEintrag("Disintegrator cannon", getPts("Disintegrator cannon")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		o1.setAnzahl(0, 3);
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chain-snares", getPts("Chain-snares")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grisly trophies", getPts("Grisly trophies")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Phantasm grenade launcher", getPts("Phantasm grenade launcher")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Shock prow", getPts("Shock prow")));
		seperator();

		complete();
	}

	@Override
	public void refreshen() { 
	}
}