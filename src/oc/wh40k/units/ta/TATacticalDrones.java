package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TATacticalDrones extends Eintrag {

	OptionsZaehlerGruppe o1;

	public TATacticalDrones() {
		name = "Tactical Drones";
		grundkosten = 0;
		
		ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
		ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
		ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 12));
		
		complete();
	}

	@Override
    public void deleteYourself() {
        super.deleteYourself();
    }
	
	@Override
	public void refreshen() {
		if(o1.getAnzahl() < 4){
			setFehlermeldung("4 Drones required");
		}
		else {
			setFehlermeldung("");
		}
		
		if (o1.getAnzahl() > 8) {
			power = 6;
		} 
		else if (o1.getAnzahl() > 4) {
			power = 4;
		} 
		else {
			power = 2;
		}
	}
	
}
