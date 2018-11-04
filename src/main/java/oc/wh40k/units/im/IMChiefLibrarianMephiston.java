package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMChiefLibrarianMephiston extends Eintrag {

    RuestkammerStarter psychicPowers;

    public IMChiefLibrarianMephiston() {
        name = "Chief Librarian Mephiston";
        grundkosten = getPts("Chief Librarian Mephiston");
        power = 8;

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(3);
        ((PsychicPowers) psychicPowers.getKammer()).enableSanguinary();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
