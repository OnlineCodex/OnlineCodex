package oc.wh40k.units.cm;

import oc.*;

public class CMChaosDecimatorDaemonEngine extends Eintrag {

    OptionsZaehlerGruppe stdWpns;
    OptionsZaehlerGruppe wpns;
    OptionsZaehlerGruppe beam;

    OptionsUpgradeGruppe marks;

    public CMChaosDecimatorDaemonEngine() {

        name = "Chaos Decimator Daemon Engine";

        grundkosten = 205;

        add(ico = new oc.Picture("oc/wh40k/images/CDChaosDecimatorDaemonEngine.gif"));

        ogE.addElement(new OptionsGruppeEintrag("Siege Claws", "Decimator Siege Claws", 0));
        add(stdWpns = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        ogE.addElement(new OptionsGruppeEintrag("Butcher Cannon", 20));
        ogE.addElement(new OptionsGruppeEintrag("Storm Laser", 15));
        ogE.addElement(new OptionsGruppeEintrag("Soulburner Petard", 10));
        add(wpns = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        ogE.addElement(new OptionsGruppeEintrag("Heavy Conv. Beamer", "Heavy Conversion Beamer", 35));
        add(beam = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Searchlight", 1));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Smoke Launchers", 3));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Khorne", 15));
        ogE.addElement(new OptionsGruppeEintrag("Nurgle", 25));
        ogE.addElement(new OptionsGruppeEintrag("Slaanesh", 15));
        ogE.addElement(new OptionsGruppeEintrag("Tzeentch", 25));
        add(marks = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();

    }

    @Override
    public void refreshen() {
        stdWpns.setMaxAnzahl(2 - wpns.getAnzahl() - beam.getAnzahl());
        stdWpns.setAnzahl(0, 2 - wpns.getAnzahl() - beam.getAnzahl());

        wpns.setMaxAnzahl(2 - beam.getAnzahl());

        beam.setMaxAnzahl(wpns.getAnzahl() < 2 ? 1 : 0);

        //TODO Abgleich: Marks können nur verwendet werden, wenn es ein UC mit dem Mark oder einen andern Dämon der Gottheit gibt.
    }
}
