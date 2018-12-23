package oc.wh40k.units.or;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.POWER_OF_THE_WAAAGH;

public class ORWeirdboy extends Eintrag {

    public ORWeirdboy() {
        name = "Wyrdboy";
        grundkosten = getPts("Weirdboy") + getPts("Weirdboy staff");
        power = 3;

        kategorie = 1;

        add(ico = new oc.Picture("oc/wh40k/images/Wyrdboy.gif"));

        RuestkammerStarter psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(2, POWER_OF_THE_WAAAGH), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(false);
        add(psychicPowers);

        seperator();

        RuestkammerStarter waffen = new RuestkammerStarter(ID, randAbstand, cnt, new ORWaffenUndGeschenke("no weapon", "no weapon", false, false, false, false, false, false, true, true));
        waffen.setButtonText("Waffen und Geschenke");
        waffen.setAbwaehlbar(false);
        add(waffen);

        seperator();

        addWarlordTraits("", true);

        complete();
    }
}
