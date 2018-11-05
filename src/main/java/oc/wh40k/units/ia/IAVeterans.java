package oc.wh40k.units.ia;

import oc.*;

import java.util.Vector;

public class IAVeterans extends Eintrag {//Sternguard

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1x;
    OptionsZaehlerGruppe o2x;
    OptionsZaehlerGruppe o2, o3;
    RuestkammerStarter rkTransport;
    RuestkammerStarter rkPod;
    OptionsEinzelZaehler flakk;
    RuestkammerStarter rkBoss, rkCorvus, rkBoss2;
    Vector<RuestkammerStarter> rk;

    public IAVeterans() {
        name = "Veterans\n";
        grundkosten = 0;
        überschriftSetzen = true;

        rk = new Vector<RuestkammerStarter>();

        for (int i = 0; i < 10; i++) {
            rk.add(new RuestkammerStarter(ID, randAbstand, cnt, "IAVeteran", "Veteran"));
            rk.lastElement().initKammer();
            rk.lastElement().setGrundkosten(22);
            add(rk.lastElement());
        }

        for (int i = 0; i < 5; i++) {
            rk.get(i).setAbwaehlbar(false);
            rk.get(i).setAbwaehlbar(true);
        }

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/SMProtektorgarde.jpg"));

        seperator();

        rkBoss2 = new RuestkammerStarter(ID, randAbstand, cnt, "IAVeteran", "Blackshield");
        rkBoss2.initKammer();
        rkBoss2.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss2.setGrundkosten(37);
        add(rkBoss2);

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "IAVeteran", "Upgrade zum Sergeant");
        rkBoss.initKammer(true);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setGrundkosten(0);
        add(rkBoss);

        seperator();

        rkCorvus = new RuestkammerStarter(ID, randAbstand, cnt, "IACorvusKammer", "Corvus Blackstar");
        rkCorvus.initKammer(false, true);
        rkCorvus.setButtonText("Corvus Blackstar");
        add(rkCorvus);

        complete();
    }

    @Override
    public void refreshen() {

        int countMembers = 0;
        for (int i = 0; i < 10; i++) {
            if (rk.get(i).isSelected()) countMembers++;
        }

        countMembers += rkBoss.isSelected() ? 1 : 0;
        countMembers += rkBoss2.isSelected() ? 1 : 0;

        if (rkBoss.isSelected() && rkBoss2.isSelected()) {
            rk.get(10 - 1).setAktiv(false);
            rk.get(10 - 2).setAktiv(false);
        } else if (rkBoss.isSelected() || rkBoss2.isSelected()) {
            rk.get(10 - 1).setAktiv(false);
            rk.get(10 - 2).setAktiv(true);
        } else {
            rk.get(10 - 1).setAktiv(true);
            rk.get(10 - 2).setAktiv(true);
        }

        if (countMembers < 5) {
            setFehlermeldung("Zu wenig Veteranen!");
        } else {
            setFehlermeldung("");
        }
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }

}
