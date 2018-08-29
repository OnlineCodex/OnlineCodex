package oc.wh40k.units.fo;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class FOTidewallRampart extends Eintrag {

	OptionsZaehlerGruppe ozg1;
	OptionsZaehlerGruppe ozg2;
	OptionsZaehlerGruppe ozg3;
	OptionsZaehlerGruppe ozg3x;

	public FOTidewallRampart() {
		name = "Tidewall Defence Network";
		grundkosten = 265;
		
		ogE.addElement(new OptionsGruppeEintrag("Tidewall Shieldline", 60));
		add(ozg1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,9999));
		ogE.addElement(new OptionsGruppeEintrag("Tidewall Gunrig", 85));
		add(ozg2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,1));
		ogE.addElement(new OptionsGruppeEintrag("Tidewall Droneport", 60));
		add(ozg3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,1));
		
		ogE.addElement(new OptionsGruppeEintrag("Angriffsdrohne", 0));
		ogE.addElement(new OptionsGruppeEintrag("Markiererdrohne", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schilddrohne", 0));
		add(ozg3x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,4));
		
		add(ico = new oc.Picture("oc/wh40k/images/TARemoteSensorTowerTeam.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
		ozg3x.setAktiv(ozg3.isSelected());
        ozg3x.setLegal(ozg3x.getAnzahl()==4);
	}
}
