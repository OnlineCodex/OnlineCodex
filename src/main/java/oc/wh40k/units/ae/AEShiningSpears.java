package oc.wh40k.units.ae;

import oc.*;

public class AEShiningSpears extends Eintrag {

    private final AnzahlPanel squad;

    public AEShiningSpears() {
        name = "Shining Spears";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Shining Spears", 3, 9, getPts("Shining Spears") + getPts("Laser lance") + getPts("Twin shuriken catapult"));
        add(squad);

        seperator();

        RuestkammerStarter rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new AEExarch("Shining Spears", getPts("Laser lance")), "Exarch");
        rkBoss.setGrundkosten(getPts("Exarch"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(true);
        add(rkBoss);

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() > 6) {
            power = 21;
        } else if (squad.getModelle() > 3) {
            power = 14;
        } else {
            power = 7;
        }
    }
}