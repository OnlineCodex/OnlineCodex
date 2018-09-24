package oc.wh40k.units.cd;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class CDBrennenderStreitwagen extends Eintrag {

	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade ErhabenerFeuerdaemon;
	OptionsZaehlerGruppe o1,o2;

	public CDBrennenderStreitwagen() {

		name = "Brennender Streitwagen des Tzeentch";

		grundkosten = 100;

		add(ico = new oc.Picture("oc/wh40k/images/CDSeelenzermalmer.gif"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Blaue Horrors", 10));

		seperator();
		
		add(ErhabenerFeuerdaemon = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Erhabener Feuerdämon", 0));
		
		ogE.addElement(new OptionsGruppeEintrag("Geringe Belohnung", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));
		ogE.addElement(new OptionsGruppeEintrag("Mächtige Belohnung", 20));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));

		complete();

	}

	@Override
	public void refreshen() {
		ErhabenerFeuerdaemon.setSelected(true);
		o1.setAktiv(ErhabenerFeuerdaemon.isSelected());
		o2.setAktiv(ErhabenerFeuerdaemon.isSelected());
		
		if(o1.getAnzahl() > 0) {
			o2.setMaxAnzahl(0);
		} else {
			o2.setMaxAnzahl(1);
		}
		
		if(o2.getAnzahl() > 0) {
			o1.setMaxAnzahl(0);
		} else {
			o1.setMaxAnzahl(2);
		}
	}
}
