package oc.wh40k.units.ae;

import oc.*;

public class AEStrikingScorpions extends Eintrag {

    private final AnzahlPanel squad;

    public AEStrikingScorpions() {
        name = "Striking Scorpions";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Striking Scorpions", 5, 10, getPts("Striking Scorpions") + getPts("Shuriken pistol") + getPts("Scorpion chainsword") + getPts("Sunburst grenade"));
        add(squad);

        seperator();

        RuestkammerStarter rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new AEExarch(name, getPts("Shuriken pistol") + getPts("Scorpion chainsword") + getPts("Sunburst grenade")), "Exarch");
        rkBoss.setGrundkosten(getPts("Exarch"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(true);
        add(rkBoss);

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() > 5) {
            power = 10;
        } else {
            power = 5;
        }
    }
}

