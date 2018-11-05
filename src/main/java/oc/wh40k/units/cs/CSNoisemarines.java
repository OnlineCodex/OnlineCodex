package oc.wh40k.units.cs;

import oc.*;

public class CSNoisemarines extends Eintrag {

    AnzahlPanel squad;
    OptionsUpgradeGruppe ikone;
    OptionsUpgradeGruppe vdlk;
    OptionsZaehlerGruppe o7;
    RuestkammerStarter champion;
    RuestkammerStarter chaosTransport;
    OptionsZaehlerGruppe bolterersatz, bolter;

    public CSNoisemarines() {
        //name = "Noisemarines\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Noisemarines", 5, 20, 17);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ikone der Ausschweifung", 30));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolter", "Boltpistole, Bolter", 0));
        add(bolter = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        ogE.addElement(new OptionsGruppeEintrag("zus. Handwaffe", "Boltpistole, Bolter, Handwaffe", 1));
        ogE.addElement(new OptionsGruppeEintrag("kostenl. Handwaffe", "Boltpistole, Handwaffe", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schallblaster", "Boltpistole, Schallblaster", 3));
        add(bolterersatz = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bassblaster", "Boltpistole, Bassblaster", 30));
        ogE.addElement(new OptionsGruppeEintrag("Bassblaster + Handw.", "Boltpistole, Bassblaster, Handwaffe", 31));
        add(o7 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Veteranen", "Veteranen des Langen Krieges", 2));
        add(vdlk = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        champion = new RuestkammerStarter(ID, randAbstand, cnt, "CSChampion", "Champion der Noisemarines", 1);
        // Besessen, Hexer, Slaanesh, Champion, Nurgle, Khorne
        champion.initKammer(false, false, true, false, false, false);
        champion.setUeberschriftTrotzNullKostenAusgeben(true);
        champion.setGrundkosten(10);
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

        vdlk.setPreis("Veteranen des Langen Krieges", 1 * count);

        if (!champion.isSelected()) champion.setSelected(true);

        chaosTransport.getPanel().setLocation(
                (int) chaosTransport.getPanel().getLocation().getX(),
                (int) chaosTransport.getPanel().getLocation().getY() + chaosTransport.getPanel().getSize().height + 5
        );

        chaosTransport.getPanel().setLocation(
                (int) chaosTransport.getPanel().getLocation().getX(),
                (int) champion.getPanel().getLocation().getY() + champion.getPanel().getSize().height + 5
        );

        if (count >= 5) {
            o7.setAktiv(true);
            if (count >= 10) {
                o7.setMaxAnzahl(2);
            } else {
                o7.setMaxAnzahl(1);
            }
        } else {
            o7.setAktiv(false);
            o7.setMaxAnzahl(0);
        }

        bolter.setMaxAnzahl(count - 1 - bolterersatz.getAnzahl() - o7.getAnzahl());
        bolter.setAnzahl(0, bolter.getMaxAnzahl());
        bolterersatz.setMaxAnzahl(count - 1 - o7.getAnzahl());

        if (bolter.getMaxAnzahl() == -1) {
            refreshen();
        }
    }
}
