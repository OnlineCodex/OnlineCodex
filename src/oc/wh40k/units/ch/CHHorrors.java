package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class CHHorrors extends Eintrag {

	OptionsZaehlerGruppe horrors, instrument, icon;
	
	public CHHorrors() {

		name = "Horrors";
        grundkosten = getPts("Horrors");
        power = 5;

        ogE.addElement(new OptionsGruppeEintrag("Pink Horrors", getPts("Pink Horrors")));
        ogE.addElement(new OptionsGruppeEintrag("Blue Horrors", getPts("Blue Horrors")));
		ogE.addElement(new OptionsGruppeEintrag("Brimestone Horrors", "Pair of Brimestone Horrors", getPts("Pairs of Brimstone Horrors")));
		add(horrors = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 30));
		horrors.setAnzahl(2, 10);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Instrument of Chaos", getPts("Instrument of Chaos")));
		add(instrument = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		ogE.addElement(new OptionsGruppeEintrag("Daemonic Icon", getPts("Daemonic Icon")));
		add(icon = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		complete();

	}

	@Override
	public void refreshen() {
		
		int anzahl = horrors.getAnzahl(0);
		instrument.setAktiv(anzahl-icon.getAnzahl()>0);
		icon.setAktiv(anzahl-instrument.getAnzahl()>0);
		
		instrument.setMaxAnzahl(horrors.getAnzahl()/10);
		icon.setMaxAnzahl(horrors.getAnzahl()/10);
		
		horrors.setLegal(horrors.getAnzahl() >= 10);
		
		power = 5 +
				((horrors.getAnzahl()==20)?5:0) +
				((horrors.getAnzahl()==30)?10:0);
	}
}
