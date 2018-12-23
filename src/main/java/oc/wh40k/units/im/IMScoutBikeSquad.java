package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerStarter;

public class IMScoutBikeSquad extends Eintrag {

    private final AnzahlPanel squad;

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

        RuestkammerStarter rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new IMSergeant("Scout Bike Squad"), "Sergeant");
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(false);
        add(rkBoss);

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