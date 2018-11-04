package oc.wh40k.units.ae;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class AEHemlockWraithfighter extends Eintrag {

    RuestkammerStarter psychicPowers;

    public AEHemlockWraithfighter() {
        name = "Hemlock Wraithfighter";
        grundkosten = getPts("Hemlock Wraithfighter") + 2 * getPts("Heavy D-scythe") + getPts("Spirit stones");
        power = 10;

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).enableRunesOfBattle();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        complete();
    }

    @Override
    public void refreshen() {
    }
}