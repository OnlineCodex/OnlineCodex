package oc.wh40k.units.ae;

import oc.*;

public class AESwoopingHawks extends Eintrag {

    private final AnzahlPanel squad;

    public AESwoopingHawks() {
        name = "Swooping Hawks";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Swooping Hawks", 5, 10, getPts("Swooping Hawks") + getPts("Lasblaster"));
        add(squad);

        seperator();

        RuestkammerStarter rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new AEExarch(name, getPts("Lasblaster")), "Exarch");
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