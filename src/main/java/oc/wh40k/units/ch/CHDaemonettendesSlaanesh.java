package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class CHDaemonettendesSlaanesh extends Eintrag {

	private final AnzahlPanel CDDaemonettendesSlaanesh;
	private final OptionsEinzelUpgrade Kurtisane, Chaosikone, Standarte;
	private final OptionsZaehlerGruppe o1, o2;

    public CHDaemonettendesSlaanesh() {

        name = "Dämonetten des Slaanesh";
        grundkosten = 0;

        CDDaemonettendesSlaanesh = new AnzahlPanel(ID, randAbstand, cnt, "Dämonetten des Slaanesh", 10, 20, 9);
        add(CDDaemonettendesSlaanesh);

        add(ico = new oc.Picture("oc/wh40k/images/CDDaemonettendesSlaanesh.gif"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument des Chaos", 10));
        add(Chaosikone = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ikone des Chaos", 10));
        add(Standarte = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Standarte der Verzückung", 10));

        seperator();

        add(Kurtisane = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kurtisane", 5));

        ogE.addElement(new OptionsGruppeEintrag("Geringe Belohnung", 10));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));
        ogE.addElement(new OptionsGruppeEintrag("Mächtige Belohnung", 20));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));

        BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("[Forgeworld] Zarakynel");

        complete();

    }

    @Override
    public void refreshen() {
        Standarte.setAktiv(Chaosikone.isSelected());
        o1.setAktiv(Kurtisane.isSelected());
        o2.setAktiv(Kurtisane.isSelected());

        if (o1.getAnzahl() > 0) {
            o2.setMaxAnzahl(0);
        } else {
            o2.setMaxAnzahl(1);
        }

        if (o2.getAnzahl() > 0) {
            o1.setMaxAnzahl(0);
        } else {
            o1.setMaxAnzahl(2);
        }
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("[Forgeworld] Zarakynel");
    }
}
