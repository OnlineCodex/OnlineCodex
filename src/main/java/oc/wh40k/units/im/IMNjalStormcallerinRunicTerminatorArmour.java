package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMNjalStormcallerinRunicTerminatorArmour extends Eintrag {

    RuestkammerStarter psychicPowers;

	public IMNjalStormcallerinRunicTerminatorArmour() {
        name = "Njal Sturmbringer in Runic Terminator Armour";
        grundkosten = getPts("Njal Stormcaller in Runic Terminator Armour");
        power = 9;
        
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
