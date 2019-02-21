package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHTzaangorShaman extends Eintrag {

	private final RuestkammerStarter psychicPowers;

    public CHTzaangorShaman() {

        name = "Tzaangor Shaman";
        grundkosten = getPts("Tzaangor Shaman");
        power = 5;

        seperator();
        
        addWeapons(CHThousandSonsRuestkammer.class, true);
        
        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).enableChange();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }
}
