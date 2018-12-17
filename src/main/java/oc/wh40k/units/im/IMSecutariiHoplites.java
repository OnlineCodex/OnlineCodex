package oc.wh40k.units.im;

import oc.*;

public class IMSecutariiHoplites extends Eintrag {

    AnzahlPanel squad;
    OptionsUpgradeGruppe o1;
    OptionsZaehlerGruppe o2;
    RuestkammerStarter rkBoss;

    public IMSecutariiHoplites() {
        name = "Secutarii Hoplites";
        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Skitarii Hoplites", 10, 20, getPts("Secutarii Hoplites") + getPts("Arc lance") + getPts("Mag-inverter shield")));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, IMAdeptusMechanicusRuestkammer.class, "Hoplite Alpha");
        rkBoss.initKammer(false, false, true, false);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        power = 4;
        if (squad.getModelle() > 10) {
            power = 8;
        }
    }

}
