package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMSecutariiPeltasts extends Eintrag {

	private final AnzahlPanel squad;
	private final RuestkammerStarter rkBoss;

    public IMSecutariiPeltasts() {
        name = "Secutarii Peltasts";
        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Skitarii Peltasts", 10, 20, getPts("Secutarii Peltasts") + getPts("Galvanic caster") + getPts("Mag-inverter shield")));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, IMAdeptusMechanicusRuestkammer.class, "Peltast Alpha");
        rkBoss.initKammer(false, false, false, true);
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
