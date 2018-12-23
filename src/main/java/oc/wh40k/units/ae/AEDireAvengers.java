package oc.wh40k.units.ae;

import oc.*;

public class AEDireAvengers extends Eintrag {

    AnzahlPanel squad;
    OptionsEinzelUpgrade boss;
    OptionsUpgradeGruppe o1;
    RuestkammerStarter rkBoss;

    public AEDireAvengers() {
        name = "Dire Avengers";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Dire Avengers", 5, 10, getPts("Dire Avengers") + getPts("Avenger shuriken catapult") + getPts("Sunburst grenade"));
        add(squad);

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new AEExarch("Dire Avengers", getPts("Avenger shuriken catapult")), "Exarch");
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