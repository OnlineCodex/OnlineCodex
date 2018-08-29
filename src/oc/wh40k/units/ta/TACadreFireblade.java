package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TACadreFireblade extends Eintrag {

	OptionsZaehlerGruppe o1;
	
	public TACadreFireblade() {

		name = "Cadre Fireblade";

		grundkosten = getPts("Cadre Fireblade") + getPts("Markerlight") + getPts("Pulse rifle") + getPts("Photon grenades");
		
		ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
		ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
		ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
		add(o1 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));

		complete();

	}

	//@OVERRIDE
	public void refreshen() {
		power = 2;
		if(o1.getAnzahl() > 0) {
			power++;
		}
	}
}
