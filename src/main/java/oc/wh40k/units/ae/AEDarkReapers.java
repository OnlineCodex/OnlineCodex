package oc.wh40k.units.ae;

import oc.*;

public class AEDarkReapers extends Eintrag {

    private final AnzahlPanel squad;

    public AEDarkReapers() {
        name = "Dark Reapers";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Dark Reapers", 3, 10, getPts("Dark Reapers") + getPts("Reaper launcher"));
        add(squad);

        seperator();

        RuestkammerStarter rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new AEExarch("Dark Reapers", getPts("Reaper launcher")), "Exarch");
        rkBoss.setGrundkosten(getPts("Exarch"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(true);

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() > 5) {
            power = 18;
        } else if (squad.getModelle() > 3) {
            power = 9;
        } else {
            power = 5;
        }
    }
}