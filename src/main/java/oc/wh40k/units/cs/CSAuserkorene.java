package oc.wh40k.units.cs;

import oc.*;

public class CSAuserkorene extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1def;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def;
    OptionsEinzelUpgrade plasmapistole;
    OptionsEinzelUpgrade draznicht;
    OptionsUpgradeGruppe mal;
    OptionsUpgradeGruppe ikone;
    OptionsZaehlerGruppe o7a;
    OptionsZaehlerGruppe o7aStart;
    OptionsZaehlerGruppe o7b;
    OptionsZaehlerGruppe o7bStart;
    OptionsZaehlerGruppe o7c;
    OptionsZaehlerGruppe o7d;
    OptionsZaehlerGruppe o7dStart;
    OptionsUpgradeGruppe o8;
    RuestkammerStarter champion;
    RuestkammerStarter chaosTransport;
    boolean draz = false;

    public CSAuserkorene() {
        //name = "Auserkorene Chaos Space Marines\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Auserkorene", 5, 10, 18);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));

        seperator();

        add(draznicht = new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Draznichts Ravagers", 10));

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
        ogE.addElement(new OptionsGruppeEintrag("Ikone der Ausschweifung", 35));
        ogE.addElement(new OptionsGruppeEintrag("Ikone der Vergeltung", 25));
        add(ikone = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
        add(o7aStart = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
        ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
        add(o7a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 4));

        ogE.addElement(new OptionsGruppeEintrag("Handwaffe", 0));
        add(o7bStart = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiewaffe"), 15));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieschwert"), 15));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieaxt"), 15));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energielanze"), 15));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiestreitkolben"), 15));
        ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
        add(o7b = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 4));

        ogE.addElement(new OptionsGruppeEintrag("Energieklauenpaar", 30));
        add(o7c = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 4));

        ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
        add(o7dStart = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
        ogE.addElement(new OptionsGruppeEintrag("Kombibolter", 3));
        ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
        add(o7d = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 4));

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

        champion = new RuestkammerStarter(ID, randAbstand, cnt, "CSChampion", "Champion der Auserkorenen", 1);
        // Besessen, Hexer, Slaanesh, Champion, Nurgle, Khorne
        champion.initKammer(false, false, false, true, false, false, true);
        champion.setUeberschriftTrotzNullKostenAusgeben(true);
        add(champion);
        champion.setAbwaehlbar(false);

        seperator();

        chaosTransport = new RuestkammerStarter(ID, randAbstand, cnt, "CSTransporter", "Transporter");
        chaosTransport.initKammer(true, false);
        chaosTransport.setButtonText("Transporter");
        add(chaosTransport);

        complete();
    }

    @Override
    public void refreshen() {

        int count = squad.getModelle();
        mal.setPreis("Mal des Khorne", 2 * count);
        mal.setPreis("Mal des Tzeentch", 2 * count);
        mal.setPreis("Mal des Nurgle", 3 * count);
        mal.setPreis("Mal des Slaanesh", 2 * count);

        if (!champion.isSelected()) champion.setSelected(true);

        chaosTransport.getPanel().setLocation(
                (int) chaosTransport.getPanel().getLocation().getX(),
                (int) chaosTransport.getPanel().getLocation().getY() + chaosTransport.getPanel().getSize().height + 5
        );

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

        chaosTransport.getPanel().setLocation(
                (int) chaosTransport.getPanel().getLocation().getX(),
                (int) champion.getPanel().getLocation().getY() + champion.getPanel().getSize().height + 5
        );

        int champSelection = ((CSChampion) champion.getKammer()).o2.getAnzahl("Melter") + ((CSChampion) champion.getKammer()).o2.getAnzahl("Plasmawerfer");

        o7a.setMaxAnzahl(4 - o7c.getAnzahl() - o7b.getAnzahl() - o7d.getAnzahl() - champSelection);
        o7b.setMaxAnzahl(4 - o7c.getAnzahl() - o7a.getAnzahl() - o7d.getAnzahl() - champSelection);
        int bolterSubractor = (o8.isSelected() && count == 5 ? 1 : 0);
        o7d.setMaxAnzahl(4 - (bolterSubractor > (o7c.getAnzahl() + o7a.getAnzahl() + o7b.getAnzahl() + champSelection) ? bolterSubractor : (o7c.getAnzahl() + o7a.getAnzahl() + o7b.getAnzahl() + champSelection)));
        o7c.setMaxAnzahl(4 - (bolterSubractor > (o7d.getAnzahl() + o7a.getAnzahl() + o7b.getAnzahl() + champSelection) ? bolterSubractor : (o7d.getAnzahl() + o7a.getAnzahl() + o7b.getAnzahl() + champSelection)));

        o7aStart.setMaxAnzahl(count - 1 - o7a.getAnzahl() - o7c.getAnzahl());
        o7bStart.setMaxAnzahl(count - 1 - o7b.getAnzahl() - o7c.getAnzahl());
        o7dStart.setMaxAnzahl(count - 1 - o7d.getAnzahl() - o7c.getAnzahl() - o8.getAnzahl());
        o7aStart.setAnzahl(0, o7aStart.getMaxAnzahl());
        o7bStart.setAnzahl(0, o7bStart.getMaxAnzahl());
        o7dStart.setAnzahl(0, o7dStart.getMaxAnzahl());

        ((CSChampion) champion.getKammer()).o2.setAktiv("Melter", (o7c.getAnzahl() + o7a.getAnzahl() + o7b.getAnzahl() + o7d.getAnzahl()) < 4);
        ((CSChampion) champion.getKammer()).o2.setAktiv("Plasmawerfer", (o7c.getAnzahl() + o7a.getAnzahl() + o7b.getAnzahl() + o7d.getAnzahl()) < 4);

        if (draznicht.isSelected()) {
            if (draz == false) {
                draz = true;
                addToInformationVector("CSDraznicht", 1);
            }
        } else if (!draznicht.isSelected()) {
            if (draz == true) {
                draz = false;
                addToInformationVector("CSDraznicht", -1);
            }
        }

        if (getCountFromInformationVector("CSDraznicht") > 1) {
            setFehlermeldung("Draznicht doppelt!");
        } else {
            setFehlermeldung("");
        }
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        if (draz == true) {
            draz = false;
            addToInformationVector("CSDraznicht", -1);
        }
    }
}
