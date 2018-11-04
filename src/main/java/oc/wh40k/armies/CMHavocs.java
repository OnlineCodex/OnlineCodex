package oc.wh40k.armies;


import oc.*;

public class CMHavocs extends Eintrag {

    AnzahlPanel squad;
    OptionsUpgradeGruppe o1;
    OptionsZaehlerGruppe o2;
    RuestkammerStarter chaosTransport;
    RuestkammerStarter rkBoss;
    OptionsZaehlerGruppe nahkampfwaffe;
    OptionsZaehlerGruppe flakk;
    OptionsUpgradeGruppe mal;
    OptionsUpgradeGruppe ikone;
    OptionsUpgradeGruppe vdlk;

    public CMHavocs() {
        //name = "Havocs\n";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Havocs", 5, 10, 13, "Havocs");
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ChaosHavocs.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Handwaffe", 2));
        add(nahkampfwaffe = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

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

        ogE.addElement(new OptionsGruppeEintrag("Veteranen", "Veteranen des Langen Krieges", 1));
        add(vdlk = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Maschinenkanone", 10));
        ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
        ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 20));
        ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 15));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        ogE.addElement(new OptionsGruppeEintrag("Flugabwehrraketen", "Flugabwehrraketen", 10));
        add(flakk = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Upgrade zum Champion", 1);
        // Besessen, Hexer, Slaanesh, Champion, Nurgle, Khorne
        rkBoss.initKammer(false, false, false, true, false, false);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setGrundkosten(10);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        seperator();

        chaosTransport = new RuestkammerStarter(ID, randAbstand, cnt, "CMTransporter", "Transporter");
        chaosTransport.initKammer(true, false);
        chaosTransport.setButtonText("Transporter");
        add(chaosTransport);

        complete();
    }

    @Override
    public void refreshen() {

        if (getCountFromInformationVector("BlackLegion") == 1) {
            vdlk.setSelected(0, true);
        }

        vdlk.setAktiv(getCountFromInformationVector("CrimsonSlaughter") == 0);

        int count = squad.getModelle();
        mal.setPreis("Mal des Khorne", 2 * count);
        mal.setPreis("Mal des Tzeentch", 2 * count);
        mal.setPreis("Mal des Nurgle", 3 * count);
        mal.setPreis("Mal des Slaanesh", 2 * count);

        vdlk.setPreis("Veteranen des Langen Krieges", 1 * count);

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

        int subtractor = 1; // boss
        nahkampfwaffe.setMaxAnzahl(squad.getModelle() - subtractor);

        flakk.setMaxAnzahl(o2.getAnzahl("Raketenwerfer"));

        chaosTransport.getPanel().setLocation(
                (int) chaosTransport.getPanel().getLocation().getX(),
                (int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height + 5
        );
    }

}
