package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMNjalStormcaller extends Eintrag {

    RuestkammerStarter psychicPowers;

	public IMNjalStormcaller() {
        name = "Njal Sturmbringer";
        grundkosten = getPts("Njal Stormcaller");
        power = 7;
        
        seperator();
        
        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(3);
        ((PsychicPowers) psychicPowers.getKammer()).enableTempestasDiscipline();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
