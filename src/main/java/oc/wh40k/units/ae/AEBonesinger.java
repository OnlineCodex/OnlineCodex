package oc.wh40k.units.ae;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class AEBonesinger extends Eintrag {

	OptionsEinzelUpgrade oe1;
	OptionsZaehlerGruppe o1, o2;

	public AEBonesinger() {
		name = "Bonesinger";
		grundkosten = getPts("Bonesinger");
		power = 4;
		
		complete();
	}

	@Override
	public void refreshen() {	
	}
}
