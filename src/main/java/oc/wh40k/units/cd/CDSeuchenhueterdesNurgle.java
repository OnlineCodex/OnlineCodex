package oc.wh40k.units.cd;

import oc.*;

public class CDSeuchenhueterdesNurgle extends Eintrag {

    AnzahlPanel CDSeuchenhueterdesNurgle;
    OptionsEinzelUpgrade Seuchenbewahrer, Chaosikone, Standarte;
    OptionsZaehlerGruppe o1, o2;

    public CDSeuchenhueterdesNurgle() {

        name = "Seuchenhüter des Nurgle";
        grundkosten = 0;

        CDSeuchenhueterdesNurgle = new AnzahlPanel(ID, randAbstand, cnt, "Seuchenhüter des Nurgle", 10, 20, 9);
        add(CDSeuchenhueterdesNurgle);

        add(ico = new oc.Picture("oc/wh40k/images/CDSeuchenhueterdesNurgle.gif"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument des Chaos", 10));
        add(Chaosikone = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ikone des Chaos", 10));
        add(Standarte = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Seuchenbanner", 10));

        seperator();

        add(Seuchenbewahrer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Seuchenbewahrer", 5));

        ogE.addElement(new OptionsGruppeEintrag("Geringe Belohnung", 10));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));
        ogE.addElement(new OptionsGruppeEintrag("Mächtige Belohnung", 20));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));

        BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("[Forgeworld] Scabeiathrax the Bloated");

        complete();

    }

    @Override
    public void refreshen() {
        Standarte.setAktiv(Chaosikone.isSelected());
        o1.setAktiv(Seuchenbewahrer.isSelected());
        o2.setAktiv(Seuchenbewahrer.isSelected());

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
        BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("[Forgeworld] Scabeiathrax the Bloated");
    }
}
