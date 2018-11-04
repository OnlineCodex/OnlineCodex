package oc.wh40k.units.kd;

import oc.*;

public class KDPossessed extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1def;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def;
    OptionsUpgradeGruppe mal;
    OptionsUpgradeGruppe ikone;
    OptionsUpgradeGruppe vdlk;
    OptionsZaehlerGruppe o7;
    OptionsUpgradeGruppe o8;
    RuestkammerStarter champion;
    RuestkammerStarter chaosTransport;
    OptionsEinzelUpgrade rkBoss;

    public KDPossessed() {
        //name = "Besessene Chaos Space Marines\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Possessed", 5, 20, 30);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Ikone des Zorns", 20));
        add(ikone = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(rkBoss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Possessed Champion", 0));

        seperator();

        chaosTransport = new RuestkammerStarter(ID, randAbstand, cnt, "KDTransporter", "Transporter");
        chaosTransport.initKammer(true, false);
        chaosTransport.setButtonText("Transporter");
        add(chaosTransport);

        complete();
    }

    @Override
    public void refreshen() {

        rkBoss.setSelected(true);
    }
}
