package oc.wh40k.units.cs;

import oc.*;

public class CSChaosterminatoren extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1def;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def;
    OptionsUpgradeGruppe mal;
    OptionsUpgradeGruppe ikone;
    OptionsZaehlerGruppe o7a;
    OptionsZaehlerGruppe o7aStandard;
    OptionsZaehlerGruppe o7b;
    OptionsZaehlerGruppe o7bStandard;
    OptionsZaehlerGruppe o7c;
    OptionsZaehlerGruppe o8;
    RuestkammerStarter champion;
    RuestkammerStarter chaosTransport;

    public CSChaosterminatoren() {
        //name = "Chaos Terminatoren\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Chaos Terminatoren", 3, 10, 31);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mal des Khorne", 2));
        ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 2));
        ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 3));
        ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", 2));
        add(mal = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Ikone des Zorns", 25));
        ogE.addElement(new OptionsGruppeEintrag("Ikone der Flammen", 15));
        ogE.addElement(new OptionsGruppeEintrag("Ikone der Verzweiflung", 10));
        ogE.addElement(new OptionsGruppeEintrag("Ikone der Ausschweifung", 40));
        ogE.addElement(new OptionsGruppeEintrag("Ikone der Vergeltung", 35));
        add(ikone = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiewaffe"), 0));
        add(o7aStandard = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieschwert"), 0));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieaxt"), 0));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energielanze"), 0));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiestreitkolben"), 0));
        ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 3));
        ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 7));
        ogE.addElement(new OptionsGruppeEintrag("Kettenfaust", 12));
        add(o7a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE));

        ogE.addElement(new OptionsGruppeEintrag("Kombibolter", 0));
        add(o7bStandard = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 5));
        add(o7b = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE));

        ogE.addElement(new OptionsGruppeEintrag("Energieklauenpaar", 7));
        add(o7c = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Schwerer Flammenwerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Zwillings-MaschKa", 25));
        add(o8 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        champion = new RuestkammerStarter(ID, randAbstand, cnt, "CSTerminatorwaffen", "Terminatorchampion");
        champion.initKammer(true, false, false);
        //champion.setButtonText("Terminatorchampion", true);
        champion.setGrundkosten(2);
        champion.setUeberschriftTrotzNullKostenAusgeben(true);
        add(champion);
        champion.setAbwaehlbar(false);

        seperator();

        chaosTransport = new RuestkammerStarter(ID, randAbstand, cnt, "CSTransporter", "Transporter");
        chaosTransport.initKammer(false, true);
        chaosTransport.setButtonText("Transporter");
        add(chaosTransport);

        complete();
    }

    @Override
    public void refreshen() {

        int count = squad.getModelle();
        mal.setPreis("Mal des Khorne", 3 * count);
        mal.setPreis("Mal des Tzeentch", 5 * count);
        mal.setPreis("Mal des Nurgle", 6 * count);
        mal.setPreis("Mal des Slaanesh", 4 * count);

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

        if (squad.getModelle() >= 5) {
            o8.setAktiv(true);
        } else {
            o8.setAktiv(false);
        }

        int maxAnzahl = squad.getModelle() / 5;

        o8.setMaxAnzahl(maxAnzahl);

        o7c.setMaxAnzahl(count - 1 - ((o7b.getAnzahl() + o8.getAnzahl()) > o7a.getAnzahl() ? (o7b.getAnzahl() + o8.getAnzahl()) : o7a.getAnzahl()));
        o7b.setMaxAnzahl(count - 1 - o7c.getAnzahl() - o8.getAnzahl());
        o7a.setMaxAnzahl(count - 1 - o7c.getAnzahl());

        o7aStandard.setMaxAnzahl(count - 1 - o7a.getAnzahl() - o7c.getAnzahl());
        o7bStandard.setMaxAnzahl(count - 1 - o7b.getAnzahl() - o7c.getAnzahl() - o8.getAnzahl());
        o7aStandard.setAnzahl(0, o7aStandard.getMaxAnzahl());
        o7bStandard.setAnzahl(0, o7bStandard.getMaxAnzahl());

        int offeneFKOptionen = squad.getModelle() - 1 - o7b.getAnzahl() - o7c.getAnzahl();
        if (maxAnzahl > 0 && offeneFKOptionen < 2) {
            o8.setMaxAnzahl(offeneFKOptionen);
        }

    }
}
