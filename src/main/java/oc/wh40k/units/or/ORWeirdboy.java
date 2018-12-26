package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class ORWeirdboy extends Eintrag {

    OptionsEinzelUpgrade o1;
    RuestkammerStarter psychicPowers;
    RuestkammerStarter waffen;

    public ORWeirdboy() {

        name = "Wyrdboy";
        grundkosten = getPts("Weirdboy") + getPts("Weirdboy staff");
        power = 3;

        add(ico = new oc.Picture("oc/wh40k/images/Wyrdboy.gif"));

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enablePowerOfTheWaaagh();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(false);

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, ORWaffenUndGeschenke.class, "");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setDefaultRanged("no weapon");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setDefaultCloceCombat("no weapon");
        waffen.initKammer(false, false, false, false, false, false, true, true);
        waffen.setButtonText("Waffen und Geschenke");
        add(waffen);
        waffen.setAbwaehlbar(false);
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }
}
