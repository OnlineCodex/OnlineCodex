package oc.wh40k.units.cd;


import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class CDZerfleischerdesKhorne extends Eintrag {

	AnzahlPanel CDZerfleischerdesKhorne;
	OptionsEinzelUpgrade Hoellenkrieger, Chaosikone, Standarte;
	OptionsZaehlerGruppe o1,o2;

	public CDZerfleischerdesKhorne() {

		name = "Zerfleischer des Khorne";

		grundkosten = 0;

		CDZerfleischerdesKhorne = new AnzahlPanel(ID, randAbstand, cnt, "Zerfleischer des Khorne", 10, 20, 10);

		add(CDZerfleischerdesKhorne);

		add(ico = new oc.Picture("oc/wh40k/images/CDZerfleischerdesKhorne.gif"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument des Chaos", 10));
		add(Chaosikone = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ikone des Chaos", 10));
		add(Standarte  = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Blutbanner", 10));
		
		seperator();

		add(Hoellenkrieger = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Höllenkrieger", 5));
		
		ogE.addElement(new OptionsGruppeEintrag("Geringe Belohnung", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));
		ogE.addElement(new OptionsGruppeEintrag("Mächtige Belohnung", 20));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));

        BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("[Forgeworld] An'ggrath the Unbound");

		complete();

	}

	@Override
	public void refreshen() {
		Standarte.setAktiv(Chaosikone.isSelected());
		o1.setAktiv(Hoellenkrieger.isSelected());
		o2.setAktiv(Hoellenkrieger.isSelected());
		
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

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("[Forgeworld] An'ggrath the Unbound");
    }
}
