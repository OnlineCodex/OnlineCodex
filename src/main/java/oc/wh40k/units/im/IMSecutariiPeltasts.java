package oc.wh40k.units.im;

import oc.*;

public class IMSecutariiPeltasts extends Eintrag {

    private final AnzahlPanel squad;

    public IMSecutariiPeltasts() {
        name = "Secutarii Peltasts";
        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Skitarii Peltasts", 10, 20, getPts("Secutarii Peltasts") + getPts("Galvanic caster") + getPts("Mag-inverter shield")));

        seperator();

        RuestkammerStarter rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new IMAdeptusMechanicusRuestkammer(name, false, false, false, true), "Peltast Alpha");
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