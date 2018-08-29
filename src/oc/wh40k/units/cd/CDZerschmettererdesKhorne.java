package oc.wh40k.units.cd;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class CDZerschmettererdesKhorne extends Eintrag {

	AnzahlPanel CDZerschmettererdesKhorne;
	OptionsEinzelUpgrade Blutjaeger, Chaosikone, Standarte;
	OptionsZaehlerGruppe o1,o2;

	public CDZerschmettererdesKhorne() {

		name = "Zerschmetterer des Khorne";

		grundkosten = 0;

		CDZerschmettererdesKhorne = new AnzahlPanel(ID, randAbstand, cnt, "Zerschmetterer des Khorne", 3, 9, 45);

		add(CDZerschmettererdesKhorne);

		add(ico = new oc.Picture("oc/wh40k/images/CDZerschmettererdesKhorne.gif"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument des Chaos", 10));
		add(Chaosikone = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ikone des Chaos", 10));
		add(Standarte  = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Blutbanner", 10));
		
		seperator();

		add(Blutjaeger = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Blutjäger", 5));
		
		ogE.addElement(new OptionsGruppeEintrag("Geringe Belohnung", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));
		ogE.addElement(new OptionsGruppeEintrag("Mächtige Belohnung", 20));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));

		seperator();

		complete();

	}

	@Override
	public void refreshen() {
		Standarte.setAktiv(Chaosikone.isSelected());
		o1.setAktiv(Blutjaeger.isSelected());
		o2.setAktiv(Blutjaeger.isSelected());
		
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
