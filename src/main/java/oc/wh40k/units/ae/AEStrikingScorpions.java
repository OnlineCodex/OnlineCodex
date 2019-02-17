package oc.wh40k.units.ae;

import oc.*;

public class AEStrikingScorpions extends Eintrag {

	private final AnzahlPanel squad;
	private final RuestkammerStarter rkBoss;

    public AEStrikingScorpions() {
        name = "Striking Scorpions";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Striking Scorpions", 5, 10, getPts("Striking Scorpions") + getPts("Shuriken pistol") + getPts("Scorpion chainsword") + getPts("Sunburst grenade"));
        add(squad);

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, AEExarch.class, "Exarch");
        ((AEExarch) rkBoss.getKammer()).type = "Striking Scorpions";
        ((AEExarch) rkBoss.getKammer()).weaponCost = getPts("Shuriken pistol") + getPts("Scorpion chainsword") + getPts("Sunburst grenade");
        rkBoss.initKammer();
        rkBoss.setGrundkosten(getPts("Exarch"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(true);

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

