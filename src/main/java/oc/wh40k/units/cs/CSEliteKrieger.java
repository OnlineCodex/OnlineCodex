package oc.wh40k.units.cs;

import oc.*;

public class CSEliteKrieger extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1def;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def;
    OptionsEinzelUpgrade plasmapistole;
    OptionsUpgradeGruppe mal;
    OptionsUpgradeGruppe ikone;
    OptionsUpgradeGruppe vdlk;
    OptionsUpgradeGruppe o7;
    OptionsUpgradeGruppe o8;
    RuestkammerStarter champion;
    RuestkammerStarter chaosTransport;
    OptionsZaehlerGruppe nahkampfwaffe;
    OptionsZaehlerGruppe kostenloseNahkampfWaffe;
    OptionsZaehlerGruppe bolter;
    OptionsZaehlerGruppe boltpistole;
    boolean spezialAuswahl = false;

    public CSEliteKrieger() {
        //name = "Elite-Krieger\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Elite-Krieger", 5, 20, 13);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
        add(boltpistole = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        ogE.addElement(new OptionsGruppeEintrag("Bolter", "Bolter", 0));
        add(bolter = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffe", "Nahkampfwaffe", 2));
        add(nahkampfwaffe = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffe", "Nahkampfwaffe", 0));
        add(kostenloseNahkampfWaffe = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        add(plasmapistole = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Plasmapistole", "1 x Plasmapistole", 15));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
        add(o7 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Maschinenkanone", 10));
        ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 15));
        ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
        ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 20));
        add(o8 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mal des Khorne", 2));
        ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 2));
        ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 3));
        ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", 2));
        add(mal = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Ikone des Zorns", 20));
        ogE.addElement(new OptionsGruppeEintrag("Ikone der Flammen", 15));
        ogE.addElement(new OptionsGruppeEintrag("Ikone der Verzweiflung", 10));
        ogE.addElement(new OptionsGruppeEintrag("Ikone der Ausschweifung", 30));
        ogE.addElement(new OptionsGruppeEintrag("Ikone der Vergeltung", 25));
        add(ikone = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Veteranen des Langen Krieges", 1));
        add(vdlk = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        champion = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Aufstrebender Champion");
        champion.initKammer(false, false, false, true, false, false);
        champion.setUeberschriftTrotzNullKostenAusgeben(true);
        champion.setGrundkosten(10);
        add(champion);
        champion.setAbwaehlbar(false);

        seperator(5);

        chaosTransport = new RuestkammerStarter(ID, randAbstand, cnt, "CMTransporter", "Transporter");
        chaosTransport.initKammer(true, false);
        chaosTransport.setButtonText("Transporter");
        add(chaosTransport);

        complete();
    }

    @Override
    public void deleteYourself() {
        if (spezialAuswahl) {
            addToInformationVector("CMEliteKrieger", -1);
        }
        super.deleteYourself();
    }

    @Override
    public void refreshen() {

        int count = squad.getModelle();
        mal.setPreis("Mal des Khorne", 2 * count);
        mal.setPreis("Mal des Tzeentch", 2 * count);
        mal.setPreis("Mal des Nurgle", 3 * count);
        mal.setPreis("Mal des Slaanesh", 2 * count);

        vdlk.setPreis("Veteranen des Langen Krieges", 1 * count);

        if (!champion.isSelected()) champion.setSelected(true);

        o8.setAktiv(squad.getModelle() > 9);

        if (mal.isSelected("Mal des Khorne")) {
            ikone.setAktiv("Ikone des Zorns", true);
        } else {
            ikone.setAktiv("Ikone des Zorns", false);
        }

        if (mal.isSelected("Mal des Tzeentch")) {
            ikone.setAktiv("Ikone der Flammen", true);
        } else {
            ikone.setAktiv("Ikone der Flammen", false);
        }

        if (mal.isSelected("Mal des Nurgle")) {
            ikone.setAktiv("Ikone der Verzweiflung", true);
        } else {
            ikone.setAktiv("Ikone der Verzweiflung", false);
        }

        if (mal.isSelected("Mal des Slaanesh")) {
            ikone.setAktiv("Ikone der Ausschweifung", true);
        } else {
            ikone.setAktiv("Ikone der Ausschweifung", false);
        }

        //Waffenoptionen
        boltpistole.setMaxAnzahl(count - 1 - (plasmapistole.isSelected() ? 1 : 0));
        boltpistole.setAnzahl(0, boltpistole.getMaxAnzahl());

        bolter.setMaxAnzahl(count - 1 - kostenloseNahkampfWaffe.getAnzahl() - o8.getAnzahl() - o7.getAnzahl());
        bolter.setAnzahl(0, bolter.getMaxAnzahl());

        int kostenlosabzug = nahkampfwaffe.getAnzahl() > (o7.getAnzahl() + o8.getAnzahl()) ? nahkampfwaffe.getAnzahl() : (o7.getAnzahl() + o8.getAnzahl());

        kostenloseNahkampfWaffe.setMaxAnzahl(count - 1 - kostenlosabzug);
        nahkampfwaffe.setMaxAnzahl(count - 1 - kostenloseNahkampfWaffe.getAnzahl());

        o7.setAktiv((!plasmapistole.isSelected() && (bolter.getAnzahl() > 0)) || o7.isSelected());
        plasmapistole.setAktiv(!o7.isSelected());

        o8.setAktiv(squad.getModelle() > 9 && ((bolter.getAnzahl() > 0) || o8.isSelected()));

        if (squad.getModelle() < 10) {
            o8.deselectAll();
        }

        if (!spezialAuswahl && kategorie == 3) {
            spezialAuswahl = true;
            addToInformationVector("CMEliteKrieger", 1);
            RefreshListener.fireRefresh();
        }

        int maxEliteKrieger = getCountFromInformationVector("CMFabiusGallus");

        if (getCountFromInformationVector("CMEliteKrieger") > maxEliteKrieger && kategorie == 3) {
            setFehlermeldung("Max. " + maxEliteKrieger + " Elite-Krieger");
        } else {
            setFehlermeldung("");
        }
    }
}
