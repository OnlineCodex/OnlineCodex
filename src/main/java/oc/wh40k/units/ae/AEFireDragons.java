package oc.wh40k.units.ae;

import oc.*;

public class AEFireDragons extends Eintrag {

    private final AnzahlPanel squad;

    public AEFireDragons() {
        name = "Fire Dragons";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Fire Dragons", 5, 10, getPts("Fire Dragons") + getPts("Fusion gun") + getPts("Melta bomb"));
        add(squad);

        seperator();

        RuestkammerStarter rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new AEExarch(name, getPts("Fusion gun")), "Exarch");
        rkBoss.setGrundkosten(getPts("Exarch"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(true);
        add(rkBoss);

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() > 5) {
            power = 12;
        } else {
            power = 6;
        }
    }
}