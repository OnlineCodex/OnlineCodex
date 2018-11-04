package oc.wh40k.units.da;

import oc.*;

public class DADevastorSquad extends Eintrag {

    AnzahlPanel squad;
    RuestkammerStarter rkTransport;
    RuestkammerStarter rkBoss;
    OptionsZaehlerGruppe flakk, o1;

    public DADevastorSquad() {
        name = "Devastortrupp\n";
        grundkosten = 0;
        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/DADevastatorSquad.gif"));

        seperator();

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 5, 10, 14);
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 15));
        ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 20));
        ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 15));
        ogE.addElement(new OptionsGruppeEintrag("Gravkanone", 35));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        ogE.addElement(new OptionsGruppeEintrag("Flugabwehrraketen", "Flugabwehrraketen", 10));
        add(flakk = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "Munitions Cherubin", "Munitions Cherubin", 5));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DASergeant", "Upgrade zum Sergeant");
        rkBoss.initKammer(false, false, false);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        seperator();

        rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DATransporterKammer", "Transporter");
        rkTransport.initKammer(true, true, true, false, false, false);
        rkTransport.setButtonText("Transporter");
        add(rkTransport);

        complete();
    }

    @Override
    public void refreshen() {
        if (!rkBoss.isSelected()) rkBoss.setSelected(true);
        flakk.setMaxAnzahl(o1.getAnzahl("Raketenwerfer"));

        //Detachments
        if (getCountFromInformationVector("Battle Company") > 0) {
            ((DATransporterKammer) rkTransport.getKammer()).mod = 0;
        }
    }

}
