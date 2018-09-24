package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class CDFeuerdaemonendesTzeentch extends Eintrag {

	OptionsEinzelUpgrade Feuerspeier;
	OptionsZaehlerGruppe o1,o2;
	
	public CDFeuerdaemonendesTzeentch() {

		name = "Feuerdämonen des Tzeentch";
		grundkosten = 0;

		add(new AnzahlPanel(ID, randAbstand, cnt, "Feuerdämonen des Tzeentch", 3, 9, 23));

		add(ico = new oc.Picture("oc/wh40k/images/CDFeuerdaemonendesTzeentch.gif"));

		seperator();

		add(Feuerspeier = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Feuerspeier", 5));
		
		ogE.addElement(new OptionsGruppeEintrag("Geringe Belohnung", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));
		ogE.addElement(new OptionsGruppeEintrag("Mächtige Belohnung", 20));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));

		complete();

	}

	@Override
	public void refreshen() {
		o1.setAktiv(Feuerspeier.isSelected());
		o2.setAktiv(Feuerspeier.isSelected());
		
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
