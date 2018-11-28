package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerStarter;

public class IMScoutBikeSquad extends Eintrag {

    AnzahlPanel squad;
    RuestkammerStarter rkBoss;

    public IMScoutBikeSquad() {
        name = "Scout Bike Squad\n";
        grundkosten = 0;
        überschriftSetzen = true;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Scout Biker", 3, 10, getPts("Scout Bike Squad") +
                getPts("bolt pistol (SM)") +
                getPts("Astartes shotgun") +
                getPts("combat knife") +
                getPts("frag grenade (SM)") +
                getPts("Krak grenade (SM)") +
                getPts("Twin boltgun")));

        seperator();

        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Astartes grenade launcher", 3, getPts("Astartes grenade launcher") - getPts("twin boltgun")));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, IMSergeant.class, "Sergeant");
        ((IMSergeant) rkBoss.getKammer()).type = "Scout Bike Squad";
        rkBoss.initKammer();
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        power = 4;
        if (squad.getModelle() > 6) {
            power = 12;
        } else if (squad.getModelle() > 3) {
            power = 8;
        }
    }

}
