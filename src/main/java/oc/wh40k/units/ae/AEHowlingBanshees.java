package oc.wh40k.units.ae;

import oc.*;

public class AEHowlingBanshees extends Eintrag {

    private final AnzahlPanel squad;

    public AEHowlingBanshees() {
        name = "Howling Banshees";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Howling Banshees", 5, 10, getPts("Howling Banshees") + getPts("Shuriken pistol") + getPts("Power sword"));
        add(squad);

        seperator();

        RuestkammerStarter rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new AEExarch(name, getPts("Shuriken pistol") + getPts("Power sword")), "Exarch");
        rkBoss.setGrundkosten(getPts("Exarch"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(true);
        add(rkBoss);

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() > 5) {
            power = 8;
        } else {
            power = 4;
        }
    }
}