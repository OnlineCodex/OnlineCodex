package oc.wh40k.units.im;

import oc.*;

public class IMSecutariiHoplites extends Eintrag {

    private final AnzahlPanel squad;

    public IMSecutariiHoplites() {
        name = "Secutarii Hoplites";
        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Skitarii Hoplites", 10, 20, getPts("Secutarii Hoplites") + getPts("Arc lance") + getPts("Mag-inverter shield")));

        seperator();

        RuestkammerStarter rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new IMAdeptusMechanicusRuestkammer("Hoplite Alpha", false, false, true, false), "Hoplite Alpha");
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(false);
        add(rkBoss);

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
