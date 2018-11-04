package oc.wh40k.units.kd;

import oc.*;

public class KDChaosTerminators extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1def;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def;
    OptionsUpgradeGruppe ikone;
    OptionsUpgradeGruppe bod;
    OptionsZaehlerGruppe o7a;
    OptionsZaehlerGruppe o7aStandard;
    OptionsZaehlerGruppe o7b;
    OptionsZaehlerGruppe o7bStandard;
    OptionsZaehlerGruppe o7c;
    OptionsZaehlerGruppe o8;
    RuestkammerStarter champion;
    RuestkammerStarter chaosTransport;
    OptionsEinzelUpgrade rkBoss;

    public KDChaosTerminators() {
        //name = "Chaos Terminatoren\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Chaos Terminators", 3, 10, 34);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Ikone des Zorns", 25));
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

        add(rkBoss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminator Champion", 2));

        seperator();

        chaosTransport = new RuestkammerStarter(ID, randAbstand, cnt, "KDTransporter", "Transporter");
        chaosTransport.initKammer(false, true);
        chaosTransport.setButtonText("Transporter");
        add(chaosTransport);

        complete();
    }

    @Override
    public void refreshen() {

        rkBoss.setSelected(true);
        int count = squad.getModelle();

        if (squad.getModelle() >= 5) {
            o8.setAktiv(true);
        } else {
            o8.setAktiv(false);
        }

        int maxAnzahl = squad.getModelle() / 5;

        o8.setMaxAnzahl(maxAnzahl);

        o7c.setMaxAnzahl(count - ((o7b.getAnzahl() + o8.getAnzahl()) > o7a.getAnzahl() ? (o7b.getAnzahl() + o8.getAnzahl()) : o7a.getAnzahl()));
        o7b.setMaxAnzahl(count - o7c.getAnzahl() - o8.getAnzahl());
        o7a.setMaxAnzahl(count - o7c.getAnzahl());

        o7aStandard.setMaxAnzahl(count - o7a.getAnzahl() - o7c.getAnzahl());
        o7bStandard.setMaxAnzahl(count - o7b.getAnzahl() - o7c.getAnzahl() - o8.getAnzahl());
        o7aStandard.setAnzahl(0, o7aStandard.getMaxAnzahl());
        o7bStandard.setAnzahl(0, o7bStandard.getMaxAnzahl());

        int offeneFKOptionen = squad.getModelle() - o7b.getAnzahl() - o7c.getAnzahl();
        if (maxAnzahl > 0 && offeneFKOptionen < 2) {
            o8.setMaxAnzahl(offeneFKOptionen);
        }

    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }
}
